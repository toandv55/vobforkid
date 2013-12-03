package vob.lib;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundSoundService extends Service {
	private MediaPlayer player;
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }
    public void onCreate(){
        super.onCreate();
        /*
        player = MediaPlayer.create(this, ResourceR.getRaw(this, "afraid")); 
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        player.start();
        */
        new Alert(this, "Service Started").show();
    }
    public void onDestroyed(){
        new Alert(this, "Service Destroyed").show();
        super.onDestroy();
        player.stop();
    }
}