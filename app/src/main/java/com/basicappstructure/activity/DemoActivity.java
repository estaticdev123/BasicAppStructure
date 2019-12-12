package com.basicappstructure.activity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.basicappstructure.R;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);


        EditText editText = findViewById(R.id.etFocus);
        //   showSoftKeyboard(editText);

        Button txtView = findViewById(R.id.txtView);

        ScrollView sv = (ScrollView) findViewById(R.id.scrollView);



        int[] location = new int[2];
        txtView.getLocationOnScreen(location);

        sv.postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.e("run1: ",""+location[1] );
                Log.e("run2: ",""+txtView.getY() );
                Log.e("run3: ",""+txtView.getTop() );
                sv.scrollBy(0, (int) (txtView.getY()/2));
            }
        }, 100);


    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }


    public static Point getLocationOnScreen(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0], location[1]);
    }
}
