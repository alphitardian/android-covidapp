package com.alphitardian.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alphitardian.covidapp.api.ApiList;
import com.alphitardian.covidapp.api.RetrofitClient;
import com.alphitardian.covidapp.databinding.ActivityMainBinding;
import com.alphitardian.covidapp.models.IndonesiaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setElevation(0);

        binding.caseLayout.setVisibility(View.GONE);

        binding.otherProvinceButton.setOnClickListener(this);
        binding.otherCountryButton.setOnClickListener(this);

        getApiCall();
    }

    private void getApiCall() {
        ApiList apiList = RetrofitClient.getRetrofitClient().create(ApiList.class);
        Call<ArrayList<IndonesiaResponse>> call = apiList.getIndonesiaCase();

        call.enqueue(new Callback<ArrayList<IndonesiaResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<IndonesiaResponse>> call, Response<ArrayList<IndonesiaResponse>> response) {
                if (response.isSuccessful()) {
                    IndonesiaResponse data = response.body().get(0);

                    binding.progressCircular.setVisibility(View.GONE);
                    binding.caseLayout.setVisibility(View.VISIBLE);
                    applyLayout(data);
                } else {
                    Toast.makeText(MainActivity.this, "API Call Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<IndonesiaResponse>> call, Throwable t) {
                Log.e("APICall", "onFailure: " + t, t);
                Toast.makeText(MainActivity.this, "API Call Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void applyLayout(IndonesiaResponse response) {
        binding.positiveCaseTextview.setText(response.getPositiveCase());
        binding.healedCaseTextview.setText(response.getHealedCase());
        binding.deadCaseTextview.setText(response.getDeadCase());
        binding.hospitalizedCaseTextview.setText(response.getHospitalizedCase());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.other_province_button) {
            Intent intent = new Intent(this, OtherProvinceActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.other_country_button) {
            Intent intent = new Intent(this, OtherCountryActivity.class);
            startActivity(intent);
        }
    }
}