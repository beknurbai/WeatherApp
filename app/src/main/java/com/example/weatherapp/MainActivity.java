package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.data.WeatherService;
import com.example.weatherapp.models.DaysTempModels;
import com.example.weatherapp.models.WeatherModel;
import com.example.weatherapp.presentation.adapters.DaysTempAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private DaysTempAdapter adapter;
    private ArrayList<DaysTempModels> card = new ArrayList<>();
    private TextView todayDay, weatherState, stateTemp, tempMax,
            tempMin, humidity, pressure, windState,
            sunrise, sunset, dayTime;
    private ImageView weatherImState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRecView();
        initialization();

    }

    private void initialization() {
        todayDay = findViewById(R.id.text_today_date);
        weatherState = findViewById(R.id.tv_weather_state);
        stateTemp = findViewById(R.id.state_temp);
        tempMax = findViewById(R.id.tv_temp_max);
        tempMin = findViewById(R.id.tv_temp_min);
        humidity = findViewById(R.id.tv_hm);
        pressure = findViewById(R.id.tv_pressure);
        windState = findViewById(R.id.tv_wind_state);
        sunrise = findViewById(R.id.tv_time_sunrise);
        sunset = findViewById(R.id.tv_time_sunset);
        dayTime = findViewById(R.id.tv_day_time);
        //initialization TextView


        weatherImState = findViewById(R.id.iv_weather_state);
        //initialization ImageView

        requestApi();
        //request in WeatherApi
    }

    private void requestApi() {
        App.weatherService.getWeatherByCity("Bishkek", new WeatherService.WeatherCallBack() {
            @Override
            public void onSuccess(WeatherModel model) {
                Log.e("tag", "onSuccess:cod "+model.getTimezone());

                Log.e("TAG", "onSuccess: ");
                String currentDate = new SimpleDateFormat("EEEE-dd-MM-yyyy-HH:mm",
                        Locale.getDefault()).format(new Date());
                todayDay.setText(currentDate);
                weatherState.setText(model.getWeather().get(0).getMain());
                stateTemp.setText(model.getMain().getTemp().intValue() + "\u2103");
                tempMax.setText(model.getMain().getTempMax().intValue() + "\u2103");
                tempMin.setText(model.getMain().getTempMin().intValue() + "\u2103");
                humidity.setText(model.getMain().getHumidity().intValue() + "%");
                pressure.setText(model.getMain().getPressure().intValue() + "mBar");
                windState.setText(model.getWind().getSpeed()+"km/h");


                long am=Long.valueOf(model.getSys().getSunrise())*1000;
                Date sunrise1=new java.util.Date(am);
                String sunr=new SimpleDateFormat(" hh:mma").format(sunrise1);
                sunrise.setText(sunr);


                long pm=Long.valueOf(model.getSys().getSunset())*1000;
                Date sunset1=new java.util.Date(pm);
                String suns=new SimpleDateFormat(" hh:mma").format(sunset1);
                sunset.setText(suns);

                int dayTimeMin = model.getSys().getSunset()-model.getSys().getSunrise();
                long pmam=dayTimeMin*1000;
                Date dayTimeInNormal=new java.util.Date(pmam);
                String dayT=new SimpleDateFormat(" h:mma").format(dayTimeInNormal);
                dayTime.setText(dayT);


            }

            @Override
            public void inFailure(Exception e) {

            }
        });

    }


    private void createRecView() {
        RecyclerView recyclerView = findViewById(R.id.rec_view_day_temp_state);
        adapter = new DaysTempAdapter(card);
        recyclerView.setAdapter(adapter);
    }
}