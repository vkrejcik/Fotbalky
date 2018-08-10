package com.example.zadek.fotbalky.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PlayerDao {

    @Insert
    void insert(Player player);

//    @Query("DELETE FROM players_table")
//    void deletePlayers();

    @Query("DELETE FROM players_table WHERE name LIKE :name and id LIKE :id")
    void deletePlayer(String name, int id);

    @Query("SELECT * FROM players_table")
    LiveData<List<Player>> getAllPlayers();
}
