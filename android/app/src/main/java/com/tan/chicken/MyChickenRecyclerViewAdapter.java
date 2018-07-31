package com.tan.chicken;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tan.chicken.ChickenFragment.OnListFragmentInteractionListener;
import com.tan.chicken.domain.Chicken;
import com.tan.chicken.domain.User;
import com.tan.chicken.dummy.DummyContent.DummyItem;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyChickenRecyclerViewAdapter extends RecyclerView.Adapter<MyChickenRecyclerViewAdapter.ViewHolder> {

    private final List<Chicken> chickensList;
    private final OnListFragmentInteractionListener mListener;


    public MyChickenRecyclerViewAdapter(List<Chicken> items, OnListFragmentInteractionListener listener) {

        chickensList = items;
        mListener = listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_chicken, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Chicken chicken = chickensList.get(position);
        holder.weightTextView.setText(chicken.getWeight().toString());
        holder.pedigreeTextView.setText(chicken.getPedigree());
        holder.genderTextView.setText(chicken.getGender());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return chickensList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView genderTextView;
        public final TextView pedigreeTextView;
        public final TextView weightTextView;

        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            genderTextView = view.findViewById(R.id.tv_gender);
            pedigreeTextView = view.findViewById(R.id.tv_pedigree);
            weightTextView = view.findViewById(R.id.tv_weight);
        }
    }


}
