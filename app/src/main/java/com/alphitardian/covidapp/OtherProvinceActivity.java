package com.alphitardian.covidapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alphitardian.covidapp.adapters.OtherProvinceAdapter;
import com.alphitardian.covidapp.api.ApiList;
import com.alphitardian.covidapp.api.RetrofitClient;
import com.alphitardian.covidapp.databinding.ActivityOtherListBinding;
import com.alphitardian.covidapp.models.ProvinceResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherProvinceActivity extends AppCompatActivity {

    private ActivityOtherListBinding binding;

    private ArrayList<ProvinceResponse> provinceResponseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtherListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Other Province");

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
        Call<ArrayList<ProvinceResponse>> call = apiList.getProvinceCase();

        call.enqueue(new Callback<ArrayList<ProvinceResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ProvinceResponse>> call, Response<ArrayList<ProvinceResponse>> response) {
                if (response.isSuccessful()) {
                    ArrayList<ProvinceResponse> data = response.body();

                    for (ProvinceResponse item : data) {
                        ProvinceResponse itemData = new ProvinceResponse(item.getAttributes());
                        provinceResponseArrayList.add(itemData);
                    }

                    binding.progressCircular.setVisibility(View.GONE);
                    showRecyclerList(provinceResponseArrayList);
                } else {
                    Toast.makeText(OtherProvinceActivity.this, "API Call Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ProvinceResponse>> call, Throwable t) {
                Toast.makeText(OtherProvinceActivity.this, "API Call Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showRecyclerList(ArrayList list) {
        binding.provinceListRecycleview.setLayoutManager(new LinearLayoutManager(this));
        OtherProvinceAdapter adapter = new OtherProvinceAdapter(list);
        binding.provinceListRecycleview.setAdapter(adapter);
        binding.provinceListRecycleview.setHasFixedSize(true);
    }

    private void searchFilter(String text) {
        ArrayList<ProvinceResponse> filteredList = new ArrayList<>();

        for (ProvinceResponse item : provinceResponseArrayList) {
            if (item.getAttributes().getProvinceName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        showRecyclerList(filteredList);
    }
}