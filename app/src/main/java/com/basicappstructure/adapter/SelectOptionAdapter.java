package com.basicappstructure.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basicappstructure.R;

import java.util.List;

public class SelectOptionAdapter extends RecyclerView.Adapter<SelectOptionAdapter.DataViewHolder> {

    private List<String> mOptionList;

    public SelectOptionAdapter(List<String> mOptionList) {

        this.mOptionList = mOptionList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_select_option, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        holder.tvOption.setText(mOptionList.get(position));
        holder.rbSelectOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });


    }

    @Override
    public int getItemCount() {
        return mOptionList.size();
    }


    public class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView tvOption;
        private RadioButton rbSelectOption;


        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
