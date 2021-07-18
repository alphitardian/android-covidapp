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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OtherProvinceAdapter extends RecyclerView.Adapter<OtherProvinceAdapter.ListViewHolder> {

    private ArrayList<ProvinceResponse> provinceResponseArrayList;

    public OtherProvinceAdapter(ArrayList<ProvinceResponse> provinceResponseArrayList) {
        this.provinceResponseArrayList = provinceResponseArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OtherProvinceAdapter.ListViewHolder holder, int position) {
        ProvinceResponse provinceResponse = provinceResponseArrayList.get(position);
        ProvinceAttributes data = provinceResponse.getAttributes();

        holder.provinceNameTextView.setText(data.getProvinceName());
        holder.positiveCaseTextView.setText(String.valueOf(data.getPositiveCase()));
        holder.healedCaseTextView.setText(String.valueOf(data.getHealedCase()));
        holder.deadCaseTextView.setText(String.valueOf(data.getDeadCase()));
    }

    @Override
    public int getItemCount() {
        return provinceResponseArrayList.size();
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
