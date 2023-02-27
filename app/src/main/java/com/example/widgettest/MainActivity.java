package com.example.widgettest;

import static android.content.ContentValues.TAG;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public Context context = MainActivity.this;
    public static String YOUR_AWESOME_ACTION = "YourAwesomeAction";
    static final String MyOnClick = "myOnClickTag";

    Button iii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.bookmark);
        views.setTextViewText(R.id.appwidget_text,"fgfgf");

        Intent intent = new Intent(context, Bookmark.class);
        intent.setAction(YOUR_AWESOME_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

//        iii = findViewById(R.id.button2);

        RemoteViews wee = new RemoteViews(context.getPackageName(), R.layout.bookmark);
        wee.setOnClickPendingIntent(R.id.button,
                getPendingSelfIntent(context, MyOnClick));


//        iii.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    public void run() {
//                        Log.d(TAG, "onClick: ");
//
//
//                    }
//
//                });
//            }
//        });




    }
    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

}