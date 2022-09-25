package com.yash.cac3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2;
    final String Chanel_ID = "My channel";
    final int Notificaton_ID = 101;
    Button notifyBtn;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext() , BotActivity.class);
                startActivity(i);
            }
        });

        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , MainActivity3.class);
                startActivity(intent);
            }
        });
        Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.google.com"));
//        startActivity(intent);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);


        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_signal_cellular_connected_no_internet_4_bar_24, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(MainActivity.this)
                    .setContentIntent(pi)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentText("App running")
                    .setSubText("App running")
                    .setChannelId(Chanel_ID)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(Chanel_ID, "New channel", NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(MainActivity.this)
                    .setContentIntent(pi)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.phone)
                    .setContentText("App running")
                    .setSubText("App running")
                    .build();
        }

        nm.notify(Notificaton_ID, notification);

    }
}