package com.tebayoll.hurufabjad;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.media.MediaPlayer;

public class Splashscreen extends Activity {

	 //Set waktu lama splashscreen
    private static int splashInterval = 3000;
    MediaPlayer s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        
        s1 = MediaPlayer.create(this, R.raw.benar);
        s1.setLooping(false);
        s1.setVolume(1, 1);
        s1.start();
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	
                //jeda selesai Splashscreen
                finish();
                overridePendingTransition(0,0);
                Intent i = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent
                overridePendingTransition(0,0);  
            }
			private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    };
	
}
