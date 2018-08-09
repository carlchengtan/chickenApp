package com.tan.chicken;
import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.service.ChickenService;
import com.tan.chicken.service.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScanFragment extends Fragment {

    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private Context context;

    private String UID;
    private TextView promptRFID;
    private Button assignChickenButton;

    private List<Chicken> chickens;

    private SharedPreferences sp;

    private static final String ARG_CHICKEN = "CHICKEN";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scan, container, false);
        context = view.getContext();
        nfcAdapter = NfcAdapter.getDefaultAdapter(context);
        promptRFID = view.findViewById(R.id.text);
        assignChickenButton = view.findViewById(R.id.btn_assign_uid);
        sp = getActivity().getSharedPreferences("com.tan.chicken", Context.MODE_PRIVATE);


        if (nfcAdapter == null) {
            Toast.makeText(context, "This device doesn't support NFC.", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }

        pendingIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, getActivity().getClass())
                        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (nfcAdapter != null) {
            if (!nfcAdapter.isEnabled())
                showWirelessSettings();

            nfcAdapter.enableForegroundDispatch(getActivity(), pendingIntent, null, null);
        }
    }

    private void showWirelessSettings() {
        Toast.makeText(context, "You need to enable NFC", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
        startActivity(intent);
    }

    public void resolveIntent(Intent intent) {
        String action = intent.getAction();

        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {

            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            byte[] id = tag.getId();
            UID = toHex(id);

            Toast.makeText(context, "RFID Scanned", Toast.LENGTH_SHORT).show();
            checkAssigned(context);
        }
    }

    private String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = bytes.length - 1; i >= 0; --i) {
            int b = bytes[i] & 0xff;
            if (b < 0x10)
                sb.append('0');
            sb.append(Integer.toHexString(b));
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void setChickens(List<Chicken> chickens){
        this.chickens = chickens;
    }

    private void checkAssigned(Context context){
        ChickenService service
                = ServiceGenerator.createService(
                ChickenService.class, sp.getString("token", "DEFAULT"));

        Call<Chicken> callAsync = (service.findByRfid(UID));
        callAsync.enqueue(new Callback<Chicken>() {
            @Override
            public void onResponse(@NonNull Call<Chicken> call, Response<Chicken> response) {
                if(response.body() == null){
                    showAssignButton(true);
                }else{
                    Chicken chicken = response.body();
                    showChickenDetail(context, chicken);
                }

            }

            @Override
            public void onFailure(Call<Chicken> call, Throwable throwable) {
                Toast.makeText(context, "Cannot connect to server "+ throwable, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showAssignButton(Boolean show){
        assignChickenButton.setVisibility(show ? View.VISIBLE : View.GONE);
//        promptRFID.setVisibility(show ? View.GONE : View.VISIBLE);
        promptRFID.setText("New Tag Found - Click ASSIGN to tag a chicken");
        assignChickenButton.setOnClickListener(view -> {

        });
    }

    private void showChickenDetail(Context context, Chicken chicken){
        Intent intent = new Intent(context, ChickenDetailActivity.class);
        intent.putExtra(ARG_CHICKEN, chicken);
        context.startActivity(intent);
    }
}