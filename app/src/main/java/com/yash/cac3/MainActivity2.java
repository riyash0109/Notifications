package com.yash.cac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
WebView wb1;
ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wb1 = (WebView) findViewById(R.id.webid1);
        wb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webod = Uri.parse("https://www.google.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW , webod);
                startActivity(intent);

            }
        });
        img1 = (ImageView) findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:8825221586"));
                startActivity(intent);
            }
        });

        img2 = (ImageView) findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webid = Uri.parse("https://www.myntra.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW ,webid);
                startActivity(intent);
            }
        });
    }
}