package com.alphitardian.covidapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alphitardian.covidapp.R;
import com.alphitardian.covidapp.models.ProvinceAttributes;
import com.alphitardian.covidapp.models.ProvinceResponse;
import com.alphitardian.covidapp.models.WorldAttributes;
import com.alphitardian.covidapp.models.WorldResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OtherCountryAdapter extends RecyclerView.Adapter<OtherCountryAdapter.ListViewHolder> {
    private ArrayList<WorldResponse> worldResponseArrayList;

    public OtherCountryAdapter(ArrayList<WorldResponse> worldResponseArrayList) {
        this.worldResponseArrayList = worldResponseArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public OtherCountryAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new OtherCountryAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OtherCountryAdapter.ListViewHolder holder, int position) {
        WorldResponse provinceResponse = worldResponseArrayList.get(position);
        WorldAttributes data = provinceResponse.getWorldAttributes();

        holder.provinceNameTextView.setText(data.getCountryRegion());
        holder.positiveCaseTextView.setText(String.valueOf(data.getConfirmedCase()));
        holder.healedCaseTextView.setText(String.valueOf(data.getRecoveredCase()));
        holder.deadCaseTextView.setText(String.valueOf(data.getDeadCase()));
    }

    @Override
    public int getItemCount() {
        return worldResponseArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView provinceNameTextView, positiveCaseTextView, healedCaseTextView, deadCaseTextView;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            provinceNameTextView = itemView.findViewById(R.id.province_name_textview);
            positiveCaseTextView = itemView.findViewById(R.id.positive_case_textview);
            healedCaseTextView = itemView.findViewById(R.id.healed_case_textview);
            deadCaseTextView = itemView.findViewById(R.id.dead_case_textview);
        }
    }
}
