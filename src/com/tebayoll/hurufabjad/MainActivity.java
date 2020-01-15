package com.tebayoll.hurufabjad;


import android.app.Activity;
import android.graphics.Typeface;
import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.graphics.drawable.*;
import android.media.MediaPlayer;
import android.os.Handler;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;


public class MainActivity extends Activity {

	public static MediaPlayer player, reset;
	public static MediaPlayer btn_klik;
	public RelativeLayout rl, popup;
	Dialog myDialog, myDialogExit;
	public Typeface cell;
	
	
	public Button header, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        AnimationDrawable air, burung, judule;
        Animation brg, jdl;

		brg = AnimationUtils.loadAnimation(this, R.anim.hewan_atas);
		jdl = AnimationUtils.loadAnimation(this, R.anim.judul);
		
        RelativeLayout rl_air = (RelativeLayout) findViewById(R.id.air);
        RelativeLayout judul = (RelativeLayout) findViewById(R.id.rl_title);
        Button burung_img = (Button) findViewById(R.id.burung);
        rl_air.setBackgroundResource(R.drawable.air);
        air = (AnimationDrawable) rl_air.getBackground();
        air.start();
        
        judul.setBackgroundResource(R.drawable.judule);
        judule = (AnimationDrawable) judul.getBackground();
        judule.start();
        judul.startAnimation(jdl);
        

        burung_img.setBackgroundResource(R.drawable.burung);
        burung = (AnimationDrawable) burung_img.getBackground();
        burung.start();
        burung_img.startAnimation(brg);
        
     // Font
		
		 cell = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
    
        myDialogExit = new Dialog(this);
        
        popup = (RelativeLayout) findViewById(R.id.popup); 
        rl = (RelativeLayout) findViewById(R.id.rl); 
        
        
 // Button
        

        
        header = (Button) findViewById(R.id.header_main_menu);
        
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        
        btn1.setTypeface(cell);
        btn2.setTypeface(cell);
        btn3.setTypeface(cell);
        btn4.setTypeface(cell);
        btn5.setTypeface(cell);
        btn6.setTypeface(cell);
        btn7.setTypeface(cell);
        btn8.setTypeface(cell);
        btn9.setTypeface(cell);
        header.setTypeface(cell);
      
        // bg musik
        
        player = MediaPlayer.create(this, R.raw.mp3bg);
        player.setVolume(1, 1);
        player.setLooping(true);
        player.start();
        
        reset = MediaPlayer.create(this, R.raw.reset);
        reset.setVolume(1, 1);
        reset.setLooping(false);
        
        btn_klik = MediaPlayer.create(this, R.raw.klik);
        btn_klik.setVolume(1, 1);
        btn_klik.setLooping(false);
        
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	
                Intent goo = new Intent(getApplicationContext(), Abjad.class);
                startActivity(goo);
                
            }
        });
        
      
        
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                
                Intent goo = new Intent(getApplicationContext(), Hewan.class);
                startActivity(goo);
            }
        });
        
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                
                Intent goo = new Intent(getApplicationContext(), Mudah.class);
                startActivity(goo);
            }
        });
     
        
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                
                Intent goo = new Intent(getApplicationContext(), Warna.class);
                startActivity(goo);
            }
        });
        
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                
                Intent goo = new Intent(getApplicationContext(), CariAbjad.class);
                startActivity(goo);
            }
        });
        
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                
                Intent goo = new Intent(getApplicationContext(), Tebak.class);
                startActivity(goo);
            }
        });  
        

       
        
        
        
        
    
        
        
        
        
    }
    
  
	// handle bg musik
    
  

    // sound
    
	
	
	
	
	// kembali
    
    public void keluar(View view) {
    	onBackPressed();
    }
	
	@Override
    public void onBackPressed() {
        
		Button ya, tidak;
         
         myDialogExit.setContentView(R.layout.keluar);
         

         ya = (Button) myDialogExit.findViewById(R.id.ya);
         tidak = (Button) myDialogExit.findViewById(R.id.tidak);
         
         ya.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            	 reset.start();
                 finish();
                 System.exit(0);
             }
         });
         
         tidak.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 myDialogExit.dismiss();
             }
         });
		

         myDialogExit.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
         myDialogExit.show();
         
        }
	
	public void credit (View v) {
		reset.start();
		
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.kredit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        
        
        TextView tx1 = (TextView) dialog.findViewById(R.id.tx1);
        tx1.setTypeface(cell);
        TextView tx2 = (TextView) dialog.findViewById(R.id.tx2);
        tx2.setTypeface(cell);
        TextView tx3 = (TextView) dialog.findViewById(R.id.tx3);
        tx3.setTypeface(cell);
        TextView tx4 = (TextView) dialog.findViewById(R.id.tx4);
        tx4.setTypeface(cell);
        
        Button bt1 = (Button) dialog.findViewById(R.id.bt1);
        bt1.setTypeface(cell);
        Button bt2 = (Button) dialog.findViewById(R.id.bt2);
        bt2.setTypeface(cell);
        Button bt3 = (Button) dialog.findViewById(R.id.bt3);
        bt3.setTypeface(cell);
        Button bt4 = (Button) dialog.findViewById(R.id.bt4);
        bt4.setTypeface(cell);
        Button bt5 = (Button) dialog.findViewById(R.id.head);
        bt5.setTypeface(cell);
        
        bt1.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
                Uri uriUrl = Uri.parse("http://www.fb.me/tebayol");
                Intent go = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(go);
                dialog.dismiss();
            }
        });
        
        bt2.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.freepik.com/free-photos-vectors/background");
                Intent go = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(go);
                dialog.dismiss();
            }
        });
        
        bt3.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.freepik.com/free-photos-vectors/background");
                Intent go = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(go);
                dialog.dismiss();
            }
        });
        
        bt4.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.freesound.org");
                Intent go = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(go);
                dialog.dismiss();
            }
        });
		
	}
	
	public void about (View v) {
		reset.start();
		
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tentang);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        
        
        TextView tx1 = (TextView) dialog.findViewById(R.id.tx1);
        tx1.setTypeface(cell);
        TextView tx2 = (TextView) dialog.findViewById(R.id.tx2);
        tx2.setTypeface(cell);
        TextView tx3 = (TextView) dialog.findViewById(R.id.tx3);
        tx3.setTypeface(cell);
        
        
        Button bt5 = (Button) dialog.findViewById(R.id.head);
        bt5.setTypeface(cell);
        
        
	}
	
	public void onPause() {
		super.onPause();
		player.setVolume(0, 0);
	}
	
	public void onResume() {
		super.onResume();
		player.setVolume(1, 1);
	}
	
	public void internet (View v) {
		
		isNetworkAvailable();
	}
	
	public void isNetworkAvailable() {
	    ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {

	        Toast.makeText(getApplicationContext(), "Internet Connection", Toast.LENGTH_LONG).show();
	    } else {
	        Toast.makeText(getApplicationContext(), "Internet Connection Is Required", Toast.LENGTH_LONG).show();

	    }
	}
    
  
}
