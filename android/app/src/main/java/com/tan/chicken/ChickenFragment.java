package com.tan.chicken;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.tan.chicken.domain.Chicken;
import com.tan.chicken.domain.User;
import com.tan.chicken.dummy.DummyContent;
import com.tan.chicken.dummy.DummyContent.DummyItem;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ChickenFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private ChickenFragment.ChickensTask mAuthTask = null;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private View mProgressView;
    private View mChickenFormView;


    private RecyclerView chickensRecyclerView;
    private String chickens;
    private List<Chicken> chickensList;
    private String weight;
    private String gender;
    private String pedigree;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ChickenFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ChickenFragment newInstance(int columnCount) {
        ChickenFragment fragment = new ChickenFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chicken_list, container, false);

        attemptGetChickens();
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            Log.i("test", chickensList.get(0).getGender());
            recyclerView.setAdapter(new MyChickenRecyclerViewAdapter(chickensList, mListener));
        }



        sp = getActivity().getSharedPreferences("com.tan.chicken", Context.MODE_PRIVATE);
        editor = sp.edit();

        chickensRecyclerView = view.findViewById(R.id.rv_chickens);
        mProgressView = view.findViewById(R.id.chicken_progress);
        mChickenFormView = (View) chickensRecyclerView;

        return view;
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptGetChickens() {
        if (mAuthTask != null) {
            return;
        }

        boolean cancel = false;
        View focusView = null;

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
//            showProgress(true);
            mAuthTask = new ChickenFragment.ChickensTask(getContext());
            mAuthTask.execute((Void) null);
        }
    }
    /**
     * Shows the progress UI and hides the login form.
     */
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
//    private void showProgress(final boolean show) {
//        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
//        // for very easy animations. If available, use these APIs to fade-in
//        // the progress spinner.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//            mChickenFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//            mChickenFormView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mChickenFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//                }
//            });
//
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mProgressView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//                }
//            });
//        } else {
//            // The ViewPropertyAnimator APIs are not available, so simply show
//            // and hide the relevant UI components.
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mChickenFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//        }
//    }

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
            // TODO: attempt authentication against a network service.
            Log.i("TOKEN", "GETTING CHICKENS..");
            try {

                Thread.sleep(10000);
//                Local IP Address
                final String url = "http://10.10.6.24:8080/chickens";

                //Emulator URL for localhost
//                final String url = "http://10.0.2.2:8080/token/generate-token";

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", sp.getString("token", "DEFAULT"));
                HttpEntity entity = new HttpEntity(headers);
                chickens = restTemplate.exchange(
                        url, HttpMethod.GET, entity, String.class).getBody();

            } catch (InterruptedException e) {
                return false;
            }


            return true;

        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
//            showProgress(false);

            if (success) {

                JsonParser jsonParser = new JsonParser();
                // Convert JSON Array String into JSON Array
                JsonArray chickensJSON = jsonParser.parse(chickens).getAsJsonArray();
                ArrayList<Chicken> chickenList = new ArrayList<>();
                for(int i=0; i<chickensJSON.size(); i++){
                    chickenList.add(new Gson().fromJson(chickensJSON.get(i), Chicken.class));
                }
                chickensList = chickenList;
                
                Log.i("test", chickenList.get(0).getGender());
                Log.i("test", "GOT CHICKENS");

            } else {
                Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
//            showProgress(false);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
