package com.thadocizn.imageviewer;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.thadocizn.imageviewer.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        linearLayout = findViewById(R.id.parentLayout);
        linearLayout.addView(generateTextView("Charles", 1));

    }

    public TextView generateTextView(String text, int position) {
        TextView textView = new TextView(this);
        textView.setTextSize(18);
        textView.setId(position);
        textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        textView.setText(text);
        return textView;
    }
}
