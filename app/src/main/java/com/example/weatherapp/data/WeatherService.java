package com.example.weatherapp.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.weatherapp.config.WeatherApiConfig;
import com.example.weatherapp.models.Weather;
import com.example.weatherapp.models.WeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.weatherapp.config.WeatherApiConfig.BASE_URL;

public class WeatherService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    WeatherApi weatherApi = retrofit.create(WeatherApi.class);

    public void getWeatherByCity(String cityName, WeatherCallBack callBack) {
        Call<WeatherModel> call = weatherApi.getWeatherByCity(cityName, WeatherApiConfig.API_KEY, "metric");
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callBack.onSuccess(response.body());
                    Log.e("tag", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                callBack.inFailure(new NetworkErrorException());
            }
        });

    }


    public interface WeatherCallBack {
        void onSuccess(WeatherModel model);

        void inFailure(Exception e);

    }

    public interface WeatherApi {
        @GET("data/2.5/weather")
        Call<WeatherModel> getWeatherByCity(
                @Query("q") String city,
                @Query("appid") String apiId,
                @Query("units") String units);

    }
}
