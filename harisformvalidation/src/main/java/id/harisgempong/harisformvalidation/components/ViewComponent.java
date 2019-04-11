package id.harisgempong.harisformvalidation.components;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import id.harisgempong.harisformvalidation.R;
import id.harisgempong.harisformvalidation.adapter.RequestAdapter;

public class ViewComponent {
    private final Context context;
    private Object backgroundColor = null, iconColor = null, textColor = null, backgroundRowColor = null, textRowColor = null;

    ViewComponent(Context context) {
        this.context = context;
    }

    public void setBackgroundColor(Object color) {
        this.backgroundColor = color;
    }
    public void setIconColor(Object color) {
        this.iconColor = color;
    }
    public void setTextColor(Object color) {
        this.textColor = color;
    }
    public void setBackgroundRowColor(Object color) {
        this.backgroundRowColor = color;
    }
    public void setTextRowColor(Object color) {
        this.textRowColor = color;
    }
    private void setColor(CardView cardView, ImageView icon, TextView text) {
        if (backgroundColor == null) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackground));
        } else {
            if (backgroundColor instanceof String) {
                try {
                    String color = "#" + backgroundColor.toString();
                    cardView.setCardBackgroundColor(Color.parseColor(color));
                } catch (IllegalArgumentException e) {
                    cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackground));
                }
            } else if (backgroundColor instanceof Integer) {
                cardView.setCardBackgroundColor(context.getResources().getColor((Integer) backgroundColor));
            } else {
                cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackground));
            }
        }

        if (iconColor == null) {
            Drawable failIcon = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.icon_fail));
            DrawableCompat.setTint(failIcon, context.getResources().getColor(R.color.colorDefaultRed));
            icon.setImageDrawable(failIcon);
        } else {
            Drawable failIcon = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.icon_fail));
            if (iconColor instanceof String) {
                String color = "#" + iconColor.toString();
                DrawableCompat.setTint(failIcon, Color.parseColor(color));
                icon.setImageDrawable(failIcon);
            } else if (iconColor instanceof Integer) {
                DrawableCompat.setTint(failIcon, context.getResources().getColor((Integer) iconColor));
                icon.setImageDrawable(failIcon);
            } else {
                DrawableCompat.setTint(failIcon, context.getResources().getColor(R.color.colorDefaultRed));
                icon.setImageDrawable(failIcon);
            }
        }

        if (textColor == null) {
            text.setTextColor(context.getResources().getColor(R.color.colorDefaultRed));
        } else {
            if (textColor instanceof String) {
                String color = "#" + textColor.toString();
                text.setTextColor(Color.parseColor(color));
            } else if (textColor instanceof Integer) {
                text.setTextColor(context.getResources().getColor((Integer) textColor));
            } else {
                text.setTextColor(context.getResources().getColor(R.color.colorDefaultRed));
            }
        }
    }
    public void showError() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_show_dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        dialog.setCancelable(true);
        dialog.show();

        CardView cardView = dialog.findViewById(R.id.cardView);
        ImageView icon = dialog.findViewById(R.id.icon);
        TextView text = dialog.findViewById(R.id.text);

        setColor(cardView, icon, text);

        if (NewFormValidation.errors.size() > 4) {
            cardView.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.WRAP_CONTENT, 800));
        }

        RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        RequestAdapter adapter = new RequestAdapter(context, NewFormValidation.errors)
                .setBackgroundRowColor(backgroundRowColor)
                .setTextRowColor(textRowColor);
        recyclerView.setAdapter(adapter);
    }
}
