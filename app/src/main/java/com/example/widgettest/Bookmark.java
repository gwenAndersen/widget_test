package com.example.widgettest;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class Bookmark extends AppWidgetProvider {

    private static final String MyOnClick = "myOnClickTag";

    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                         int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.bookmark);


        views.setOnClickPendingIntent(R.id.button2, getPendingSelfIntent(context, MyOnClick));

        views.setTextViewText(R.id.appwidget_text, widgetText);



        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    //RemoteViews.setOnClickPendingIntent(R.id.button2, getPendingSelfIntent(context, MyOnClick));

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {

            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);//add this line
        if (MyOnClick.equals(intent.getAction())){
            //your onClick action is here
            //display in short period of time
            Log.d("TAG", "onReceive: 11");
            Toast.makeText(context, "msg msgasdasd", Toast.LENGTH_SHORT).show();
        }
    };
}