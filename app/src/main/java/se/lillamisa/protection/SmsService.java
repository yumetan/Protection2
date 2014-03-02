package se.lillamisa.protection;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class SmsService extends Service implements Handler.Callback {
    private static final int SMSSERVICE_NOTIFICATION_ID = 1001;

    private IBinder mLocalBinder;
    private SmsCallback mSmsCallback;
    private Handler mHelpHandler;
    private Notification mNotification;


    public SmsService() {


    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }

    public class LocalBinder extends Binder {
        public SmsService getService() {

            return SmsService.this;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //  throw new UnsupportedOperationException("Not yet implemented");
        return mLocalBinder;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        //mTimerHandler = new Handler(getMainLooper(), this);
    }

    public void clickSend() {
        startService(new Intent(this, getClass()));
        clickSend();
        clickSendInForeground();
    }

    private void clickSendInForeground() {
        /*Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(getString(R.string.sms_notification_title));
        mNotification = builder.getNotification();
        startForeground(SMSSERVICE_NOTIFICATION_ID, mNotification);*/



           /*SendTextMessage msendTextMessage = new SendTextMessage (String destinationAddress,
                   String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent);*/


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("sectionNumber", 1);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Creates the PendingIntent
        PendingIntent notifyIntent =
                PendingIntent.getActivity(
                        this,
                        1,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        // Puts the PendingIntent into the notification builder
        // builder.setContentIntent(notifyIntent);
    }

    public void setSmsCallback(SmsCallback clickSendCallback) {

        mSmsCallback = clickSendCallback;
    }

    public interface SmsCallback {

    }


}
