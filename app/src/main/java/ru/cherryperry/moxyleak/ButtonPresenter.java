package ru.cherryperry.moxyleak;

import android.support.v4.app.NotificationCompat;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import java.util.concurrent.atomic.AtomicInteger;

@InjectViewState
public class ButtonPresenter extends MvpPresenter<MvpView> {
    public static final AtomicInteger ID_GEN = new AtomicInteger(1);

    private int id;

    public ButtonPresenter() {
        id = ID_GEN.getAndIncrement();

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(CustomApplication.application)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Presenter is alive!")
                        .setContentText("Id = " + id);

        CustomApplication.notificationManager.notify(id, builder.build());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CustomApplication.notificationManager.cancel(id);
    }
}
