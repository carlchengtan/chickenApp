package com.tan.chicken;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.tan.chicken.domain.Chicken;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class ChickensFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private ChickensFragment.ChickensTask mAuthTask = null;
    private SharedPreferences sp;
    private View progressView;

    private String chickensTemp;
    private ArrayList<Chicken> chickens;
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
        progressView = view.findViewById(R.id.chicken_progress);

        if(chickens == null){
            chickens = new ArrayList<>();
            attemptGetChickens(view);
        }else{
            chickensRecyclerView.setAdapter(new MyChickensRecyclerViewAdapter(chickens));
            chickensRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        return view;
    }

    /*LOADER*/
    private void attemptGetChickens(View view) {
        if (mAuthTask != null) {
            return;
        }
        // Show a progress spinner, and kick off a background task to
        // perform the attemptChicken function
        showProgress(true);
        mAuthTask = new ChickensFragment.ChickensTask(view.getContext());
        mAuthTask.execute((Void) null);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        progressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });

        chickensRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
        chickensRecyclerView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                chickensRecyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class ChickensTask extends AsyncTask<Void, Void, Boolean> {

        private final Context context;

        ChickensTask(Context context) {
            this.context = context;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            Log.i("test", "GETTING CHICKENS..");
            try {

                Thread.sleep(2000);
//                Local IP Address
                final String url = "http://10.10.6.24:8080/chickens";

                //Emulator URL for localhost
//                final String url = "http://10.0.2.2:8080/chickens";

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", sp.getString("token", "DEFAULT"));
                HttpEntity entity = new HttpEntity(headers);
                chickensTemp = restTemplate.exchange(
                        url, HttpMethod.GET, entity, String.class).getBody();

            } catch (InterruptedException e) {
                return false;
            }

            return true;

        }

        @Override
        protected void onPostExecute(final Boolean success) {

            if (success) {

                JsonParser jsonParser = new JsonParser();
                JsonArray chickensJSON = jsonParser.parse(chickensTemp).getAsJsonArray();

                for(int i=0; i<chickensJSON.size(); i++){
                    chickens.add(new Gson().fromJson(chickensJSON.get(i), Chicken.class));
                }

                chickensRecyclerView.setAdapter(new MyChickensRecyclerViewAdapter(chickens));
                chickensRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                showProgress(false);
                Log.i("test", "GOT CHICKENS");

            } else {
                Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

}
