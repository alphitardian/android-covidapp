package com.alphitardian.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.alphitardian.covidapp.adapters.OtherCountryAdapter;
import com.alphitardian.covidapp.adapters.OtherProvinceAdapter;
import com.alphitardian.covidapp.api.ApiList;
import com.alphitardian.covidapp.api.RetrofitClient;
import com.alphitardian.covidapp.databinding.ActivityOtherListBinding;
import com.alphitardian.covidapp.models.WorldResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherCountryActivity extends AppCompatActivity {

    private ActivityOtherListBinding binding;

    private ArrayList<WorldResponse> worldResponseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtherListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Other Country");

        binding.progressCircular.setVisibility(View.VISIBLE);

        getApiCall();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search_menu).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchFilter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void getApiCall() {
        ApiList apiList = RetrofitClient.getRetrofitClient().create(ApiList.class);
        Call<ArrayList<WorldResponse>> call = apiList.getGlobalCase();

        call.enqueue(new Callback<ArrayList<WorldResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<WorldResponse>> call, Response<ArrayList<WorldResponse>> response) {
                if (response.isSuccessful()) {
                    ArrayList<WorldResponse> data = response.body();

                    for (WorldResponse item : data) {
                        WorldResponse itemData = new WorldResponse(item.getWorldAttributes());
                        worldResponseArrayList.add(itemData);
                    }

                    binding.progressCircular.setVisibility(View.GONE);
                    showRecyclerList(worldResponseArrayList);
                } else {
                    Toast.makeText(OtherCountryActivity.this, "API Call Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<WorldResponse>> call, Throwable t) {
                Toast.makeText(OtherCountryActivity.this, "API Call Failed!", Toast.LENGTH_SHORT).show();
                Log.e("ApiCall", "onFailure: " + t, t);
            }
        });
    }

    private void showRecyclerList(ArrayList list) {
        binding.provinceListRecycleview.setLayoutManager(new LinearLayoutManager(this));
        OtherCountryAdapter adapter = new OtherCountryAdapter(list);
        binding.provinceListRecycleview.setAdapter(adapter);
        binding.provinceListRecycleview.setHasFixedSize(true);
    }

    private void searchFilter(String text) {
        ArrayList<WorldResponse> filteredList = new ArrayList<>();

        for (WorldResponse item : worldResponseArrayList) {
            if (item.getWorldAttributes().getCountryRegion().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        showRecyclerList(filteredList);
    }
}