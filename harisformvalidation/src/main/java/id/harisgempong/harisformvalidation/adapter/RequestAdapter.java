package id.harisgempong.harisformvalidation.adapter;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.harisgempong.harisformvalidation.R;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {
    private final ArrayList<String> requests;
    private final Context context;
    private Object backgroundRowColor = null, textRowColor = null;

    public RequestAdapter(Context context, ArrayList<String> requests) {
        this.context = context;
        this.requests = requests;
    }

    public RequestAdapter setBackgroundRowColor(Object color) {
        this.backgroundRowColor = color;
        return this;
    }

    public RequestAdapter setTextRowColor(Object color) {
        this.textRowColor = color;
        return this;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_show_dialog_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String request = requests.get(position);
        holder.text.setText(request);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return (requests == null) ? 0 : requests.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text;
        private final CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.text = itemView.findViewById(R.id.text_row);
            this.cardView = itemView.findViewById(R.id.background_row);

            if (backgroundRowColor == null) {
                cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackgroundRow));
            } else {
                if (backgroundRowColor instanceof String) {
                    String color = "#" + backgroundRowColor.toString();
                    cardView.setCardBackgroundColor(Color.parseColor(color));
                } else if (backgroundRowColor instanceof Integer) {
                    cardView.setCardBackgroundColor(context.getResources().getColor((Integer) backgroundRowColor));
                } else {
                    cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackgroundRow));
                }
            }

            if (textRowColor == null) {
                text.setTextColor(context.getResources().getColor(R.color.colorDefaultText));
            } else {
                if (textRowColor instanceof String) {
                    String color = "#" + textRowColor.toString();
                    text.setTextColor(Color.parseColor(color));
                } else if (textRowColor instanceof Integer) {
                    text.setTextColor(context.getResources().getColor((Integer)textRowColor));
                } else {
                    text.setTextColor(context.getResources().getColor(R.color.colorDefaultText));
                }
            }
        }
    }
}
