package com.tan.chicken;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tan.chicken.domain.Chicken;

import java.util.List;


public class ChickenListAdapter extends RecyclerView.Adapter<ChickenListAdapter.ChickenViewHolder> {

    class ChickenViewHolder extends RecyclerView.ViewHolder {
        private final TextView chickenItemView;

        private ChickenViewHolder(View itemView) {
            super(itemView);
            chickenItemView = itemView.findViewById(R.id.gender);
        }
    }

    private final LayoutInflater mInflater;
    private List<Chicken> mChickens; // Cached copy of chickens

    ChickenListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.fragment_chickens_list, parent, false);
        return new ChickenViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChickenViewHolder holder, int position) {
        Chicken current = mChickens.get(position);
        holder.chickenItemView.setText(current.getGender());
    }

    void setChickens(List<Chicken> chickens){
        mChickens = chickens;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mChickens has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mChickens != null)
            return mChickens.size();
        else return 0;
    }
}


