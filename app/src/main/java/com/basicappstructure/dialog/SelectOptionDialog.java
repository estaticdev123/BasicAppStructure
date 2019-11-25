package com.basicappstructure.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.basicappstructure.R;
import com.basicappstructure.adapter.SelectOptionAdapter;

import java.util.List;

public class SelectOptionDialog extends Dialog implements View.OnClickListener {


    private OnButtonClickListener onButtonClickListener;
    private RecyclerView rvOption;
    private TextView tvDone;
    private Context mContext;
    private List<String> mOptionList;


    public SelectOptionDialog(Context context, List<String> mOptionList, OnButtonClickListener onButtonClickListener) {
        super(context);
        this.onButtonClickListener = onButtonClickListener;
        this.mContext = context;
        this.mOptionList = mOptionList;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_select_option);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().getAttributes().windowAnimations = R.style.DialogTheme;

        initialisation();

    }

    private void initialisation() {
        rvOption = findViewById(R.id.rvOption);
        tvDone = findViewById(R.id.tvDone);

        rvOption.setLayoutManager(new LinearLayoutManager(mContext));
        rvOption.setAdapter(new SelectOptionAdapter(mOptionList));


    }

    @Override
    public void onClick(View view) {


    }


    public interface OnButtonClickListener {
        void onOkClick(View view);


    }

}