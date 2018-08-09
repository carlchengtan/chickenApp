package com.tan.chicken;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.service.ChickenService;
import com.tan.chicken.service.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChickensFragment extends Fragment{

    private SharedPreferences sp;
    private List<Chicken> chickens;
    private RecyclerView chickensRecyclerView;

    public ChickensFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chickens, container, false);

        sp = getActivity().getSharedPreferences("com.tan.chicken", Context.MODE_PRIVATE);;
        chickensRecyclerView = view.findViewById(R.id.rv_chickens);

        getChickens(view.getContext());

        return view;
    }

    private void getChickens(Context context) {
        ChickenService service
                = ServiceGenerator.createService(
                ChickenService.class, sp.getString("token", "DEFAULT"));

        Call<List<Chicken>> callAsync = (service.getChickens());
        callAsync.enqueue(new Callback<List<Chicken>>() {
            @Override
            public void onResponse(@NonNull Call<List<Chicken>> call, @NonNull Response<List<Chicken>> response) {
                chickens = response.body();
                chickensRecyclerView.setAdapter(new MyChickensRecyclerViewAdapter(chickens));
                chickensRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void onFailure(Call<List<Chicken>> call, Throwable throwable) {
                Toast.makeText(context, "Cannot connect to server "+ throwable, Toast.LENGTH_LONG).show();
            }
        });

    }

    public List<Chicken> sendChickens(){
        return this.chickens;
    }
}


