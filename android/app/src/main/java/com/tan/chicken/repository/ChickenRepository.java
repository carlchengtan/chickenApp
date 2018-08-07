package com.tan.chicken.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.tan.chicken.domain.Chicken;

import java.util.List;

public class ChickenRepository {

    private ChickenDao mChickenDao;
    private LiveData<List<Chicken>> mAllChickens;

    ChickenRepository(Application application) {
        ChickenRoomDatabase db = ChickenRoomDatabase.getDatabase(application);
        mChickenDao = db.chickenDao();
        mAllChickens = mChickenDao.getAllChickens();
    }

    LiveData<List<Chicken>> getAllChickens() {
        return mAllChickens;
    }


    public void insert (Chicken chicken) {
        new insertAsyncTask(mChickenDao).execute(chicken);
    }

    private static class insertAsyncTask extends AsyncTask<Chicken, Void, Void> {

        private ChickenDao mAsyncTaskDao;

        insertAsyncTask(ChickenDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Chicken... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}