package com.example.zadek.fotbalky;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zadek.fotbalky.Model.Player;

import java.util.List;



public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private List<Player> players;

    // Constructor
    PlayersAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recylerview_player_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (players != null) {
            Player currentPlayer = players.get(position);

            holder.playerNameItemView.setText(currentPlayer.getName());
        } else {
            holder.playerNameItemView.setText(R.string.no_records);
        }
    }

    void setPlayers(List<Player> players) {
        this.players = players;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (players != null) {
            return players.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView playerNameItemView;

        ViewHolder(View itemView) {
            super(itemView);
            playerNameItemView = itemView.findViewById(R.id.playerNameTextView);
        }
    }
}
