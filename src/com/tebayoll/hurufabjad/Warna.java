package com.tebayoll.hurufabjad;



import android.app.Activity;
import android.graphics.Typeface;
import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Bundle;
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

public class Warna extends Activity {

	MediaPlayer player;
	public Animation warna;
	public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, wrn_dasar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_warna);
		
		
		  // Animation
		
				warna = AnimationUtils.loadAnimation(this, R.anim.warna);
				
		// Font
		
		
		 Typeface cell = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
   
		 
		 wrn_dasar = (Button) findViewById(R.id.wrn_dasar);
		 
		 	btn1 = (Button) findViewById(R.id.btn1);
	        btn2 = (Button) findViewById(R.id.btn2);
	        btn3 = (Button) findViewById(R.id.btn3);
	        btn4 = (Button) findViewById(R.id.btn4);
	        btn5 = (Button) findViewById(R.id.btn5);
	        btn6 = (Button) findViewById(R.id.btn6);
	        btn7 = (Button) findViewById(R.id.btn7);
	        btn8 = (Button) findViewById(R.id.btn8);
	        btn9 = (Button) findViewById(R.id.btn9);
	        btn10 = (Button) findViewById(R.id.btn10);
	        
	        btn1.setTypeface(cell);
	        btn2.setTypeface(cell);
	        btn3.setTypeface(cell);
	        btn4.setTypeface(cell);
	        btn5.setTypeface(cell);
	        btn6.setTypeface(cell);
	        btn7.setTypeface(cell);
	        btn8.setTypeface(cell);
	        btn9.setTypeface(cell);
	        btn9.setTypeface(cell);
	        wrn_dasar.setTypeface(cell);
	      
	        
	        
	        btn1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("merah");
	                btn1.startAnimation(warna);
	            
	            }
	        }); 
	        
	        btn2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("biru");
	                btn2.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("kuning");
	                btn3.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("hijau");
	                btn4.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("ungu");
	                btn5.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn6.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("jingga");
	                btn6.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn7.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("nila");
	                btn7.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn8.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("pink");
	                btn8.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn9.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("hitam");
	                btn9.startAnimation(warna);
	                
	            }
	        }); 
	        
	        btn10.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	playSound("putih");
	                btn10.startAnimation(warna);
	                
	            }
	        });
	        
	      
	        
	        
	        
		
	}

	
	// suara 
	
	private void playSound(String arg){
   		try{
   			if (player.isPlaying()) {
   				player.stop();
   				player.release();
   			}
   		}catch(Exception e){
   			
   		}
   		
   		if (arg == "merah"){
   			player = MediaPlayer.create(this, R.raw.wmerah);

   		} else if (arg == "biru") {
   			player = MediaPlayer.create(this, R.raw.wbiru);
   		} else if (arg == "kuning") {
   			player = MediaPlayer.create(this, R.raw.wkuning);
   		} else if (arg == "hijau") {
   			player = MediaPlayer.create(this, R.raw.whijau);
   		} else if (arg == "ungu") {
   			player = MediaPlayer.create(this, R.raw.wungu);
   		} else if (arg == "jingga") {
   			player = MediaPlayer.create(this, R.raw.wjingga);
   		} else if (arg == "nila") {
   			player = MediaPlayer.create(this, R.raw.wnila);
   		}  else if (arg == "pink") {
   			player = MediaPlayer.create(this, R.raw.wpink);
   		}  else if (arg == "hitam") {
   			player = MediaPlayer.create(this, R.raw.whitam);
   		}  else if (arg == "putih") {
   			player = MediaPlayer.create(this, R.raw.wputih);
   		}
   		
   		player.setLooping(false); // Set looping
   		player.start();
   	}
	
	
	// back
	
	 public void back (View v) {
	    	
	    	finish();
	  	}
	
	@Override
  public void onBackPressed() {
		
 	finish();
	}
	
	public void onPause() {
		super.onPause();
		MainActivity.player.setVolume(0, 0);
	}
	
	public void onResume() {
		super.onResume();
		MainActivity.player.setVolume(1, 1);
	}
	
	
}
