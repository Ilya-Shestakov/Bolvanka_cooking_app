package com.example.bolvanka;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<ItemModel> items;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prod, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.nameTextView.setText(item.getName());
        holder.counterTextView.setText(String.valueOf(item.getCounter()));
        holder.itemImageView.setImageResource(item.getImageResId());

        holder.plusButton.setOnClickListener(v -> {
            int counter = item.getCounter();
            item.setCounter(counter + 1);
            holder.counterTextView.setText(String.valueOf(item.getCounter()));
        });

        holder.minusButton.setOnClickListener(v -> {
            int counter = item.getCounter();
            if(counter > 0){
                item.setCounter(counter - 1);
                holder.counterTextView.setText(String.valueOf(item.getCounter()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public List<ItemModel> getItems() {
        return items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageView;
        TextView nameTextView;
        TextView counterTextView;
        ConstraintLayout plusButton;
        ConstraintLayout minusButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.product_image);
            nameTextView = itemView.findViewById(R.id.product_name);
            counterTextView = itemView.findViewById(R.id.score_product_to_backet);
            plusButton = itemView.findViewById(R.id.score_plus);
            minusButton = itemView.findViewById(R.id.score_minus);
        }
    }
}