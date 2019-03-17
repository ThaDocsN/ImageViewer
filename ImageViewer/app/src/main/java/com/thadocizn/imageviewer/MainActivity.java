package com.thadocizn.imageviewer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.thadocizn.imageviewer.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    public static final int IMAGE_REQUEST_CODE = 1;

    private LinearLayout linearLayout;
    private ArrayList<ImageData> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        linearLayout = findViewById(R.id.parentLayout);
        linearLayout.addView(generateTextView("Charles", 1));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, IMAGE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_REQUEST_CODE) {
                String uri = data.getData().toString();

                //todo add imagtes to emulator
                ImageData imageData = new ImageData("image", uri);
                imageList = new ArrayList<>();
                imageList.add(imageData);

                TextView textView = generateTextView(uri, imageList.indexOf(imageData));
                linearLayout.addView(textView);

            }
        }
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
