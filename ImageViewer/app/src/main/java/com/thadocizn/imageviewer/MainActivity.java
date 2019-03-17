package com.thadocizn.imageviewer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import static com.thadocizn.imageviewer.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        ButterKnife.bind(this);
    }

    public TextView generateTextView(String text, int position) {
        TextView textView = new TextView(this);
        textView.setTextSize(18);
        textView.setId(position);
        textView.setText(text);
        return textView;
    }
}
