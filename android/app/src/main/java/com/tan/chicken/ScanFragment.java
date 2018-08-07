package com.tan.chicken;
import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScanFragment extends Fragment {

    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private Context context;

    private String UID;
    private TextView promptRFID;
    private Button assignChickenButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scan, container, false);
        context = view.getContext();
        nfcAdapter = NfcAdapter.getDefaultAdapter(context);
        promptRFID = view.findViewById(R.id.text);
        assignChickenButton = view.findViewById(R.id.btn_assign_uid);

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

    private void showButton(Boolean show){
        assignChickenButton.setVisibility(show ? View.VISIBLE : View.GONE);
        promptRFID.setVisibility(show ? View.GONE : View.VISIBLE);
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
            showButton(true);
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

}