package com.weatherforecast.stormy.ui;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.weatherforecast.stormy.R;
import com.weatherforecast.stormy.adapters.DayAdapter;
import com.weatherforecast.stormy.model.Day;

import java.util.Arrays;

import static butterknife.ButterKnife.bind;

public class DailyForecastActivity extends Activity {
    private Day[] days;

    @BindView(android.R.id.list) ListView listView;
    @BindView(android.R.id.empty) TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        bind(this);
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        days = Arrays.copyOf(parcelables, parcelables.length, Day[].class);
        DayAdapter adapter = new DayAdapter(this, days);
        listView.setAdapter(adapter);
        listView.setEmptyView(emptyTextView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String dayOfWeek = days[i].getDayOfTheWeek();
                String conditions = days[i].getSummary();
                String highTemp = days[i].getTemperatureMax() + "";
                String message = String.format("On %s the high will be %s and it will be %s", dayOfWeek, highTemp, conditions);

                Toast.makeText(DailyForecastActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
