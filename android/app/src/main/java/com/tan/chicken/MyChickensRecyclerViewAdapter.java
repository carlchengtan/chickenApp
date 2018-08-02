package com.tan.chicken;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tan.chicken.domain.Chicken;

import java.util.List;

public class MyChickensRecyclerViewAdapter  extends RecyclerView.Adapter<MyChickensRecyclerViewAdapter.ChickenViewHolder> {

    private List<Chicken> chickens;
    private Context context;

    private static final String ARG_CHICKEN = "CHICKEN";

    MyChickensRecyclerViewAdapter(List<Chicken> chickens){
        this.chickens = chickens;
    }

    @NonNull
    @Override
    public MyChickensRecyclerViewAdapter.ChickenViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_chickens_list, viewGroup, false);
        context = v.getContext();
        return new ChickenViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyChickensRecyclerViewAdapter.ChickenViewHolder viewHolder, int position) {

        final Chicken chicken = chickens.get(position);

        viewHolder.weight.setText(chicken.getWeight() == null ? " " : chicken.getWeight().toString());
        viewHolder.pedigree.setText(chicken.getPedigree() == null ? " " : chicken.getPedigree());
        viewHolder.gender.setText(chicken.getGender() == null ? " " : chicken.getGender());
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChickenDetailActivity.class);
                intent.putExtra(ARG_CHICKEN, chicken);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return chickens.size();
    }

    protected static class ChickenViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView pedigree;
        TextView gender;
        TextView weight;

        ChickenViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv_chickens);
            pedigree = itemView.findViewById(R.id.pedigree);
            gender = itemView.findViewById(R.id.gender);
            weight = itemView.findViewById(R.id.weight);
        }
    }


}
