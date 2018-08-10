package com.example.zadek.fotbalky.Model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Player.class}, version = 1)
public abstract class FotbalkyRoomDatabase extends RoomDatabase {

    public abstract PlayerDao playerDao();

    private static FotbalkyRoomDatabase INSTANCE;


    public static FotbalkyRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FotbalkyRoomDatabase.class) {
                if (INSTANCE == null)  {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FotbalkyRoomDatabase.class, "fotbalky database").addCallback(databaseCallback).build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback databaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PlayerDao dao;

        PopulateDbAsync(FotbalkyRoomDatabase db) {

            dao = db.playerDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
