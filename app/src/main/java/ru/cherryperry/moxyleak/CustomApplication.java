package ru.cherryperry.moxyleak;

import android.app.Application;
import android.app.NotificationManager;

public class CustomApplication extends Application {

    public static NotificationManager notificationManager;
    public static CustomApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        application = this;
    }
}
