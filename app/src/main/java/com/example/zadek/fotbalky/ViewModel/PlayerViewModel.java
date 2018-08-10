package com.example.zadek.fotbalky.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.zadek.fotbalky.Model.Player;
import com.example.zadek.fotbalky.Model.Repository;

import java.util.List;

public class PlayerViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Player>> players;

    public PlayerViewModel(Application application) {
        super(application);
        repository = new Repository(application);
        players = repository.getAllPlayers();
    }

    public LiveData<List<Player>> getAllPlayers() {
        return players;
    }

    public void insertPlayer(Player player) {
        repository.insertPlayer(player);
    }
}
