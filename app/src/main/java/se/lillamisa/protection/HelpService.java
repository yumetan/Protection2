package se.lillamisa.protection;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class HelpService extends Service implements Handler.Callback {
    private static final int HELPSERVICE_NOTIFICATION_ID = 1000;
    private boolean mHelpIsRunning = false;

    private final LocalBinder mLocalBinder = new LocalBinder();
    private HelpCallback mHelpCallback;
    private Handler mHelpHandler;
    private Notification mNotification;


    public HelpService() {

    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }

    public class LocalBinder extends Binder {
        public HelpService getService() {

            return HelpService.this;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mLocalBinder;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mHelpHandler = new Handler(getMainLooper(), this);
    }

    public void clickHelp() {  //anropas från MainActivity
        startService(new Intent(this, getClass()));
        ToneGenerator toneGenerator
                = new ToneGenerator(AudioManager.STREAM_SYSTEM, ToneGenerator.MAX_VOLUME);
        toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP);
        //clickHelpInForeground();
    }

    //private void clickHelpInForeground() {







        /*if (mNotification == null) {
            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle(getString(R.string.sms_notification_title));
            mNotification = builder.getNotification();
        }

        startForeground(HELPSERVICE_NOTIFICATION_ID, mNotification);


        mHelpIsRunning = true;


        notifyHelpCallback();
        mHelpHandler.sendEmptyMessageDelayed(HELP);  //start the handler for the first time

        */

    //}


  /*  private void notifyHelpCallback() {


    }*/

    public void setHelpCallback(HelpCallback clickHelpCallback) {
        mHelpCallback = clickHelpCallback;
    }


    public interface HelpCallback {


    }


}
