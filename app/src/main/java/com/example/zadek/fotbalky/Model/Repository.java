package com.example.zadek.fotbalky.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.os.AsyncTask;

import java.util.List;

public class Repository {

    private PlayerDao playerDao;
    private LiveData<List<Player>> players;

    public Repository(Application application) {
        FotbalkyRoomDatabase database = FotbalkyRoomDatabase.getDatabase(application);

        playerDao = database.playerDao();
        players = playerDao.getAllPlayers();
    }

    public LiveData<List<Player>> getAllPlayers() {
        return players;
    }

    public void insertPlayer(Player player) {
        new insertAsyncTask(playerDao).execute(player);
    }

    // insertAsyncTask
    private static class insertAsyncTask extends AsyncTask<Player, Void, Void> {

        private PlayerDao playerDao;

        insertAsyncTask(PlayerDao dao) {
            playerDao = dao;
        }

        @Override
        protected Void doInBackground(Player... players) {
            playerDao.insert(players[0]);

            return null;
        }
    }
}
