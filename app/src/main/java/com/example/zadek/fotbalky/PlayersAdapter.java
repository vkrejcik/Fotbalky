package com.example.zadek.fotbalky;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zadek.fotbalky.Model.Player;

import java.util.List;



public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private List<Player> players;

    // Delete this afterwards
    private Context context;

    // Constructor
    PlayersAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recylerview_player_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (players != null) {
            final Player currentPlayer = players.get(position);

            holder.playerNameItemView.setText(currentPlayer.getName());
            holder.playerWinsTextView.setText(currentPlayer.getWins() + "");
            holder.playerLossesTextView.setText(currentPlayer.getLosses() + "");
            holder.playerTotalPointTextView.setText(currentPlayer.getPoints_total() + "");

            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Replace this afterwards with functional code
                    Toast.makeText(context, currentPlayer.getName() + " " + position + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder.playerNameItemView.setText(R.string.no_records);
        }
    }

    @Override
    public int getItemCount() {
        if (players != null) {
            return players.size();
        } else {
            return 0;
        }
    }

    void setPlayers(List<Player> players) {
        this.players = players;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final ConstraintLayout parentLayout;
        private final TextView playerNameItemView;
        private final TextView playerWinsTextView;
        private final TextView playerLossesTextView;
        private final TextView playerTotalPointTextView;

        ViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.recyclerViewItemParentLayout);
            playerNameItemView = itemView.findViewById(R.id.recyclerViewPlayerNameTextView);
            playerWinsTextView = itemView.findViewById(R.id.recyclerViewWinsTextView);
            playerLossesTextView = itemView.findViewById(R.id.recyclerViewLossesTextView);
            playerTotalPointTextView = itemView.findViewById(R.id.recyclerViewTotalPoints);

        }
    }
}
