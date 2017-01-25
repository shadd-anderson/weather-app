package com.weatherforecast.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.weatherforecast.stormy.R;
import com.weatherforecast.stormy.model.Hour;
import com.weatherforecast.stormy.ui.HourlyForecastActivity;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {
    private Hour[] hours;
    private Context context;

    public HourAdapter(Context context, Hour[] hours) {
        this.context = context;
        this.hours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_list_item, parent, false);
        return new HourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(hours[position]);
    }

    @Override
    public int getItemCount() {
        return hours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.timeLabel) public TextView timeLabel;
        @BindView(R.id.summaryLabel) public TextView summaryLabel;
        @BindView(R.id.temperatureLabel) public TextView temperatureLabel;
        @BindView(R.id.iconImageView) public ImageView iconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour) {
            timeLabel.setText(hour.getHour() + "");
            summaryLabel.setText(hour.getSummary());
            temperatureLabel.setText(hour.getTemperature() + "");
            iconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View view) {
            String time = timeLabel.getText().toString();
            String temperature = temperatureLabel.getText().toString();
            String summary = summaryLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s", time, temperature, summary);
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}
