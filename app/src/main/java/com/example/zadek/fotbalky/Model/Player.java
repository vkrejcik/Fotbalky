package com.example.zadek.fotbalky.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "players_table")
public class Player {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo
    private String name;

    @NonNull
    @ColumnInfo
    private Integer wins;

    @NonNull
    @ColumnInfo
    private Integer losses;

    @NonNull
    @ColumnInfo
    private Integer ties;

    @NonNull
    @ColumnInfo
    private Integer games_played;

    @NonNull
    @ColumnInfo
    private Integer points_attack;

    @NonNull
    @ColumnInfo
    private Integer points_defense;

    @NonNull
    @ColumnInfo
    private Integer points_total;

    // Constructor
    public Player(@NonNull String name,
                  @NonNull Integer wins,
                  @NonNull Integer losses,
                  @NonNull Integer ties,
                  @NonNull Integer games_played,
                  @NonNull Integer points_attack,
                  @NonNull Integer points_defense,
                  @NonNull Integer points_total) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.games_played = games_played;
        this.points_attack = points_attack;
        this.points_defense = points_defense;
        this.points_total = points_total;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Integer getWins() {
        return wins;
    }

    @NonNull
    public Integer getLosses() {
        return losses;
    }

    @NonNull
    public Integer getTies() {
        return ties;
    }

    @NonNull
    public Integer getGames_played() {
        return games_played;
    }

    @NonNull
    public Integer getPoints_attack() {
        return points_attack;
    }

    @NonNull
    public Integer getPoints_defense() {
        return points_defense;
    }

    @NonNull
    public Integer getPoints_total() {
        return points_total;
    }
}
