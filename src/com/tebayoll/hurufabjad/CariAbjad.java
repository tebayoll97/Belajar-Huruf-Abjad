package com.tebayoll.hurufabjad;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.widget.*;
import android.view.*;
import android.widget.Button;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;

public class CariAbjad extends Activity {

	RelativeLayout rl_abjad, rl_awal, rl_hasil;
	public Button abjad1, abjad2, abjad3, abjad4, abjad5, abjad6, abjad7, abjad8, abjad9, abjad10, start, btn_th, btn_ok,
	btn_thawal, btn_coin;
	public int counter = 61, nilai = 0, timer=60000;
	public String idabjad1="", idabjad2="", idabjad3="", idabjad4="", idabjad5="", idabjad6="", 
			idabjad7="",idabjad8="",idabjad9="",idabjad10="",target_abjad="";
	public boolean benergak;
	public TextView cd, tx_nilai, tv_target_text, score, tv_score, high_score;
	MediaPlayer suara, bg;
	
	public int spscore=0, sphigh_score=0, splash=300;
	public Animation atas, kiri, kiri_a, kanan_b, kanan_a, bawah, bawah_r;
	
	CountDownTimer thetimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cari_abjad);
		

			AnimationDrawable air;
		 RelativeLayout rl_air = (RelativeLayout) findViewById(R.id.air);
	       
		 	rl_air.setBackgroundResource(R.drawable.air);
	        air = (AnimationDrawable) rl_air.getBackground();
	        air.start();
	        
	        btn_coin = (Button) findViewById(R.id.coin);
	        
		
		 // Font
		
		 Typeface cell = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
   

		rl_abjad = (RelativeLayout) findViewById (R.id.al_abjad);
		rl_awal = (RelativeLayout) findViewById (R.id.rl_awal);
		rl_hasil = (RelativeLayout) findViewById (R.id.rl_hasil);
		

		score = (TextView) findViewById (R.id.score);
		tv_score = (TextView) findViewById (R.id.tv_score);
		high_score = (TextView) findViewById (R.id.high_score);
		
		bg = MediaPlayer.create(this, R.raw.bg_abjad);
        bg.setVolume(1, 1);
        bg.setLooping(true);
        bg.start();
		
		 
		start = (Button) findViewById (R.id.start);
		btn_th = (Button) findViewById (R.id.btn_th);
		btn_thawal = (Button) findViewById (R.id.btn_thawal);
		btn_ok = (Button) findViewById (R.id.btn_ok);
		abjad1 = (Button) findViewById (R.id.abjad1);
		abjad2 = (Button) findViewById (R.id.abjad2);
		abjad3 = (Button) findViewById (R.id.abjad3);
		abjad4 = (Button) findViewById (R.id.abjad4);
		abjad5 = (Button) findViewById (R.id.abjad5);
		abjad6 = (Button) findViewById (R.id.abjad6);
		abjad7 = (Button) findViewById (R.id.abjad7);
		abjad8 = (Button) findViewById (R.id.abjad8);
		abjad9 = (Button) findViewById (R.id.abjad9);
		abjad10 = (Button) findViewById (R.id.abjad10);
		
 // Animation
		
		final Animation thawal = AnimationUtils.loadAnimation(this, R.anim.abjmuncul);
		btn_thawal.startAnimation(thawal);
		
	
		
		
		cd = (TextView) findViewById (R.id.cd);
		tx_nilai = (TextView) findViewById (R.id.nilai);
		tv_target_text = (TextView) findViewById (R.id.tv_target_text);
		
		cd.setTypeface(cell);
		tx_nilai.setTypeface(cell);
		btn_th.setTypeface(cell);
		start.setTypeface(cell);
		tv_target_text.setTypeface(cell);
		btn_thawal.setTypeface(cell);
		
		score.setTypeface(cell);
		tv_score.setTypeface(cell);
		high_score.setTypeface(cell);
		btn_ok.setTypeface(cell);
		
		
		// animasi

		atas = AnimationUtils.loadAnimation(this, R.anim.ca_atas);
		kiri = AnimationUtils.loadAnimation(this, R.anim.ca_kiri);
		kiri_a = AnimationUtils.loadAnimation(this, R.anim.ca_kiri_a);
		kanan_b = AnimationUtils.loadAnimation(this, R.anim.ca_kanan_b);
		bawah = AnimationUtils.loadAnimation(this, R.anim.ca_bawah);
		bawah_r = AnimationUtils.loadAnimation(this, R.anim.ca_bawah_r);
		kanan_a = AnimationUtils.loadAnimation(this, R.anim.ca_kanan_a);
		
		
		// score
		SharedPreferences splvl = getSharedPreferences("scores", 0);
        
		
        
	     // Retrive data id layout lvl1
			
			sphigh_score = splvl.getInt("high_score" , 0);
			spscore = splvl.getInt("score" , 0);
		
		// cari abjad
		
		 String items_target[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
				 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount;
	       final String list_target;
	       Random r = new Random();
	        
	       list_target = items_target[r.nextInt(26)]; //yg da di random
	        
	       
	        
		   target_abjad = list_target;
    	   btn_th.setText("Target Abjad : "+target_abjad);
    	   btn_thawal.setText(target_abjad);
	       
		
	       
	       
	       
		
	  		 
	  		thetimer = new CountDownTimer(timer, 1000){
                public void onTick(long millisUntilFinished){
                    counter--;
                    cd.setText(String.valueOf(counter));
                    tx_nilai.setText("Point kamu "+String.valueOf(nilai));
                    
                    if (!idabjad1.equalsIgnoreCase(target_abjad) && !idabjad2.equalsIgnoreCase(target_abjad) && 
         	    		   !idabjad3.equalsIgnoreCase(target_abjad) && !idabjad4.equalsIgnoreCase(target_abjad) &&
         	    		   !idabjad5.equalsIgnoreCase(target_abjad) && !idabjad6.equalsIgnoreCase(target_abjad) &&
         	    		   !idabjad7.equalsIgnoreCase(target_abjad) && !idabjad8.equalsIgnoreCase(target_abjad) &&
         	    		   !idabjad9.equalsIgnoreCase(target_abjad) && !idabjad10.equalsIgnoreCase(target_abjad)) {
         	    	   
         	    	   updateViews();
         	    	   
         	       } 
                }
                public  void onFinish(){
             	   
                	suarajawab("selesai");
                	
                   cd.setText("Permaian Selesai");
                   rl_abjad.setVisibility(View.INVISIBLE);
                   btn_coin.setVisibility(View.INVISIBLE);
                   rl_hasil.setVisibility(View.VISIBLE);
                   
                   
                   btn_th.setVisibility(View.INVISIBLE);
                   tx_nilai.setVisibility(View.INVISIBLE);
                   cd.setVisibility(View.INVISIBLE);
                   
                   score.setText(String.valueOf(nilai));
                  
                   if (nilai > sphigh_score) {
                	   SharedPreferences splvl = getSharedPreferences("scores", 0);
                       SharedPreferences.Editor editor = splvl.edit();
                       editor.putInt("high_score", nilai);
                       editor.commit();
                       
                	   high_score.setText("Skor Terbaik baru\n"+String.valueOf(nilai));
                   } else {
                	   high_score.setText("Skor Terbaik\n"+String.valueOf(sphigh_score));
                	   
                	   
                   }
                   
                }
            };
		
       
       start.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
           	
        	   // anim koin

            btn_coin.setVisibility(View.VISIBLE);
        	   
        	AnimationDrawable coin;
   	        btn_coin.setBackgroundResource(R.drawable.coin);
   	        coin = (AnimationDrawable) btn_coin.getBackground();
   	        coin.start();
        	   
        	 /*  abjad9.startAnimation(kiri);
       		abjad3.startAnimation(kiri);
       		abjad4.startAnimation(kiri_a);
       		abjad6.startAnimation(kiri_a);
       		abjad2.startAnimation(kanan_b);
       		abjad1.startAnimation(bawah);
       		abjad8.startAnimation(kanan_a);
       		abjad5.startAnimation(kanan_a);
       		abjad7.startAnimation(atas);
       		abjad10.startAnimation(bawah_r); */
       		
        	   
        	   rl_abjad.setVisibility(View.VISIBLE);
        	   rl_awal.setVisibility(View.INVISIBLE);
        	   btn_th.setVisibility(View.VISIBLE);
        	   tx_nilai.setVisibility(View.VISIBLE);
        	   cd.setVisibility(View.VISIBLE);
        	   
        	   tx_nilai.setText(String.valueOf(nilai));
    		   

        	   btn_th.startAnimation(thawal);
        	   thetimer.start();
        	   
           }
       });
       
       btn_ok.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   refresh();
        	   
        	   
           }
       });
       
       abjad1.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad1.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 
        	   

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       abjad2.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad2.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   suarajawab("benar");
        		   
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad3.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad3.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   suarajawab("benar");
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad4.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad4.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad5.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad5.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 
               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad6.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad6.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad7.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad7.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad8.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad8.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad9.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad9.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

    		             @Override
    		             public void run() {
    		            	 gantiwarna("normal");
    		             }

    		         }, splash);
        	   } 

               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
		
       abjad10.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

        	   
        	   
        	   if (idabjad10.equalsIgnoreCase(target_abjad)) {
        		   nilai+=100;
        		   updateViews();
        		   gantiwarna("hijau");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   suarajawab("benar");
        		   
        	   } else {
        		   nilai-=50;
        		   suarajawab("salah");
        		   gantiwarna("merah");
        		   new Handler().postDelayed(new Runnable() {

  		             @Override
  		             public void run() {
  		            	 gantiwarna("normal");
  		             }

  		         }, splash);
        		   
        		   
        	   } 
               tx_nilai.setText("Point kamu "+String.valueOf(nilai));
           }
       });
       
       
	} // akhir root
	
	
	// suara
    public void suarajawab(String arg) {
    	
    	try{
   			if (suara.isPlaying()) {
   				suara.stop();
   				suara.release();
   			}
   		}catch(Exception e){
   			
   		}
    	
    	if (arg == "benar") {
    		suara = MediaPlayer.create(this, R.raw.benar);
    	} else if (arg == "salah") {
    		suara = MediaPlayer.create(this, R.raw.salah);
    	} else if (arg == "selesai") {
    		suara = MediaPlayer.create(this, R.raw.applause);
    	}
    	
    	 suara.setLooping(false);
		suara.start();
	
    }
	
	 public void rand_abjad1 (String arg) {
	    	
	    	if (arg == "a") {
	    		idabjad1 = "a";
	    		abjad1.setText("a");
	    	} else if (arg == "b") {
	    		idabjad1 = "b";
	    		abjad1.setText("b");
	    	} else if (arg == "c") {
	    		idabjad1 = "c";
	    		abjad1.setText("c");
	    	} else if (arg == "d") {
	    		idabjad1 = "d";
	    		abjad1.setText("d");
	    	} else if (arg == "e") {
	    		idabjad1 = "e";
	    		abjad1.setText("e");
	    	} else if (arg == "f") {
	    		idabjad1 = "f";
	    		abjad1.setText("f");
	    	} else if (arg == "g") {
	    		idabjad1 = "g";
	    		abjad1.setText("g");
	    	} else if (arg == "h") {
	    		idabjad1 = "h";
	    		abjad1.setText("h");
	    	} else if (arg == "i") {
	    		idabjad1 = "i";
	    		abjad1.setText("i");
	    	} else if (arg == "j") {
	    		idabjad1 = "j";
	    		abjad1.setText("j");
	    	} else if (arg == "k") {
	    		idabjad1 = "k";
	    		abjad1.setText("k");
	    	} else if (arg == "l") {
	    		idabjad1 = "l";
	    		abjad1.setText("l");
	    	} else if (arg == "m") {
	    		idabjad1 = "m";
	    		abjad1.setText("m");
	    	} else if (arg == "n") {
	    		idabjad1 = "n";
	    		abjad1.setText("n");
	    	} else if (arg == "o") {
	    		idabjad1 = "o";
	    		abjad1.setText("o");
	    	} else if (arg == "p") {
	    		idabjad1 = "p";
	    		abjad1.setText("p");
	    	} else if (arg == "q") {
	    		idabjad1 = "q";
	    		abjad1.setText("q");
	    	} else if (arg == "r") {
	    		idabjad1 = "r";
	    		abjad1.setText("r");
	    	} else if (arg == "s") {
	    		idabjad1 = "s";
	    		abjad1.setText("s");
	    	} else if (arg == "t") {
	    		idabjad1 = "t";
	    		abjad1.setText("t");
	    	} else if (arg == "u") {
	    		idabjad1 = "u";
	    		abjad1.setText("u");
	    	} else if (arg == "v") {
	    		idabjad1 = "v";
	    		abjad1.setText("v");
	    	} else if (arg == "w") {
	    		idabjad1 = "w";
	    		abjad1.setText("w");
	    	} else if (arg == "x") {
	    		idabjad1 = "x";
	    		abjad1.setText("x");
	    	} else if (arg == "y") {
	    		idabjad1 = "y";
	    		abjad1.setText("y");
	    	} else if (arg == "z") {
	    		idabjad1 = "z";
	    		abjad1.setText("z");
	    	}
	 }
	 
	 public void rand_abjad2 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad2 = "a";
	    		abjad2.setText("a");
	    	} else if (arg == "b") {
	    		idabjad2 = "b";
	    		abjad2.setText("b");
	    	} else if (arg == "c") {
	    		idabjad2 = "c";
	    		abjad2.setText("c");
	    	} else if (arg == "d") {
	    		idabjad2 = "d";
	    		abjad2.setText("d");
	    	} else if (arg == "e") {
	    		idabjad2 = "e";
	    		abjad2.setText("e");
	    	} else if (arg == "f") {
	    		idabjad2 = "f";
	    		abjad2.setText("f");
	    	} else if (arg == "g") {
	    		idabjad2 = "g";
	    		abjad2.setText("g");
	    	} else if (arg == "h") {
	    		idabjad2 = "h";
	    		abjad2.setText("h");
	    	} else if (arg == "i") {
	    		idabjad2 = "i";
	    		abjad2.setText("i");
	    	} else if (arg == "j") {
	    		idabjad2 = "j";
	    		abjad2.setText("j");
	    	} else if (arg == "k") {
	    		idabjad2 = "k";
	    		abjad2.setText("k");
	    	} else if (arg == "l") {
	    		idabjad2 = "l";
	    		abjad2.setText("l");
	    	} else if (arg == "m") {
	    		idabjad2 = "m";
	    		abjad2.setText("m");
	    	} else if (arg == "n") {
	    		idabjad2 = "n";
	    		abjad2.setText("n");
	    	} else if (arg == "o") {
	    		idabjad2 = "o";
	    		abjad2.setText("o");
	    	} else if (arg == "p") {
	    		idabjad2 = "p";
	    		abjad2.setText("p");
	    	} else if (arg == "q") {
	    		idabjad2 = "q";
	    		abjad2.setText("q");
	    	} else if (arg == "r") {
	    		idabjad2 = "r";
	    		abjad2.setText("r");
	    	} else if (arg == "s") {
	    		idabjad2 = "s";
	    		abjad2.setText("s");
	    	} else if (arg == "t") {
	    		idabjad2 = "t";
	    		abjad2.setText("t");
	    	} else if (arg == "u") {
	    		idabjad2 = "u";
	    		abjad2.setText("u");
	    	} else if (arg == "v") {
	    		idabjad2 = "v";
	    		abjad2.setText("v");
	    	} else if (arg == "w") {
	    		idabjad2 = "w";
	    		abjad2.setText("w");
	    	} else if (arg == "x") {
	    		idabjad2 = "x";
	    		abjad2.setText("x");
	    	} else if (arg == "y") {
	    		idabjad2 = "y";
	    		abjad2.setText("y");
	    	} else if (arg == "z") {
	    		idabjad2 = "z";
	    		abjad2.setText("z");
	    	}
	 }
	 
	 public void rand_abjad3 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad3 = "a";
	    		abjad3.setText("a");
	    	} else if (arg == "b") {
	    		idabjad3 = "b";
	    		abjad3.setText("b");
	    	} else if (arg == "c") {
	    		idabjad3 = "c";
	    		abjad3.setText("c");
	    	} else if (arg == "d") {
	    		idabjad3 = "d";
	    		abjad3.setText("d");
	    	} else if (arg == "e") {
	    		idabjad3 = "e";
	    		abjad3.setText("e");
	    	} else if (arg == "f") {
	    		idabjad3 = "f";
	    		abjad3.setText("f");
	    	} else if (arg == "g") {
	    		idabjad3 = "g";
	    		abjad3.setText("g");
	    	} else if (arg == "h") {
	    		idabjad3 = "h";
	    		abjad3.setText("h");
	    	} else if (arg == "i") {
	    		idabjad3 = "i";
	    		abjad3.setText("i");
	    	} else if (arg == "j") {
	    		idabjad3 = "j";
	    		abjad3.setText("j");
	    	} else if (arg == "k") {
	    		idabjad3 = "k";
	    		abjad3.setText("k");
	    	} else if (arg == "l") {
	    		idabjad3 = "l";
	    		abjad3.setText("l");
	    	} else if (arg == "m") {
	    		idabjad3 = "m";
	    		abjad3.setText("m");
	    	} else if (arg == "n") {
	    		idabjad3 = "n";
	    		abjad3.setText("n");
	    	} else if (arg == "o") {
	    		idabjad3 = "o";
	    		abjad3.setText("o");
	    	} else if (arg == "p") {
	    		idabjad3 = "p";
	    		abjad3.setText("p");
	    	} else if (arg == "q") {
	    		idabjad3 = "q";
	    		abjad3.setText("q");
	    	} else if (arg == "r") {
	    		idabjad3 = "r";
	    		abjad3.setText("r");
	    	} else if (arg == "s") {
	    		idabjad3 = "s";
	    		abjad3.setText("s");
	    	} else if (arg == "t") {
	    		idabjad3 = "t";
	    		abjad3.setText("t");
	    	} else if (arg == "u") {
	    		idabjad3 = "u";
	    		abjad3.setText("u");
	    	} else if (arg == "v") {
	    		idabjad3 = "v";
	    		abjad3.setText("v");
	    	} else if (arg == "w") {
	    		idabjad3 = "w";
	    		abjad3.setText("w");
	    	} else if (arg == "x") {
	    		idabjad3 = "x";
	    		abjad3.setText("x");
	    	} else if (arg == "y") {
	    		idabjad3 = "y";
	    		abjad3.setText("y");
	    	} else if (arg == "z") {
	    		idabjad3 = "z";
	    		abjad3.setText("z");
	    	}
	 }
	 
	 public void rand_abjad4 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad4 = "a";
	    		abjad4.setText("a");
	    	} else if (arg == "b") {
	    		idabjad4 = "b";
	    		abjad4.setText("b");
	    	} else if (arg == "c") {
	    		idabjad4 = "c";
	    		abjad4.setText("c");
	    	} else if (arg == "d") {
	    		idabjad4 = "d";
	    		abjad4.setText("d");
	    	} else if (arg == "e") {
	    		idabjad4 = "e";
	    		abjad4.setText("e");
	    	} else if (arg == "f") {
	    		idabjad4 = "f";
	    		abjad4.setText("f");
	    	} else if (arg == "g") {
	    		idabjad4 = "g";
	    		abjad4.setText("g");
	    	} else if (arg == "h") {
	    		idabjad4 = "h";
	    		abjad4.setText("h");
	    	} else if (arg == "i") {
	    		idabjad4 = "i";
	    		abjad4.setText("i");
	    	} else if (arg == "j") {
	    		idabjad4 = "j";
	    		abjad4.setText("j");
	    	} else if (arg == "k") {
	    		idabjad4 = "k";
	    		abjad4.setText("k");
	    	} else if (arg == "l") {
	    		idabjad4 = "l";
	    		abjad4.setText("l");
	    	} else if (arg == "m") {
	    		idabjad4 = "m";
	    		abjad4.setText("m");
	    	} else if (arg == "n") {
	    		idabjad4 = "n";
	    		abjad4.setText("n");
	    	} else if (arg == "o") {
	    		idabjad4 = "o";
	    		abjad4.setText("o");
	    	} else if (arg == "p") {
	    		idabjad4 = "p";
	    		abjad4.setText("p");
	    	} else if (arg == "q") {
	    		idabjad4 = "q";
	    		abjad4.setText("q");
	    	} else if (arg == "r") {
	    		idabjad4 = "r";
	    		abjad4.setText("r");
	    	} else if (arg == "s") {
	    		idabjad4 = "s";
	    		abjad4.setText("s");
	    	} else if (arg == "t") {
	    		idabjad4 = "t";
	    		abjad4.setText("t");
	    	} else if (arg == "u") {
	    		idabjad4 = "u";
	    		abjad4.setText("u");
	    	} else if (arg == "v") {
	    		idabjad4 = "v";
	    		abjad4.setText("v");
	    	} else if (arg == "w") {
	    		idabjad4 = "w";
	    		abjad4.setText("w");
	    	} else if (arg == "x") {
	    		idabjad4 = "x";
	    		abjad4.setText("x");
	    	} else if (arg == "y") {
	    		idabjad4 = "y";
	    		abjad4.setText("y");
	    	} else if (arg == "z") {
	    		idabjad4 = "z";
	    		abjad4.setText("z");
	    	}
	 }
	 
	 public void rand_abjad5 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad5 = "a";
	    		abjad5.setText("a");
	    	} else if (arg == "b") {
	    		idabjad5 = "b";
	    		abjad5.setText("b");
	    	} else if (arg == "c") {
	    		idabjad5 = "c";
	    		abjad5.setText("c");
	    	} else if (arg == "d") {
	    		idabjad5 = "d";
	    		abjad5.setText("d");
	    	} else if (arg == "e") {
	    		idabjad5 = "e";
	    		abjad5.setText("e");
	    	} else if (arg == "f") {
	    		idabjad5 = "f";
	    		abjad5.setText("f");
	    	} else if (arg == "g") {
	    		idabjad5 = "g";
	    		abjad5.setText("g");
	    	} else if (arg == "h") {
	    		idabjad5 = "h";
	    		abjad5.setText("h");
	    	} else if (arg == "i") {
	    		idabjad5 = "i";
	    		abjad5.setText("i");
	    	} else if (arg == "j") {
	    		idabjad5 = "j";
	    		abjad5.setText("j");
	    	} else if (arg == "k") {
	    		idabjad5 = "k";
	    		abjad5.setText("k");
	    	} else if (arg == "l") {
	    		idabjad5 = "l";
	    		abjad5.setText("l");
	    	} else if (arg == "m") {
	    		idabjad5 = "m";
	    		abjad5.setText("m");
	    	} else if (arg == "n") {
	    		idabjad5 = "n";
	    		abjad5.setText("n");
	    	} else if (arg == "o") {
	    		idabjad5 = "o";
	    		abjad5.setText("o");
	    	} else if (arg == "p") {
	    		idabjad5 = "p";
	    		abjad5.setText("p");
	    	} else if (arg == "q") {
	    		idabjad5 = "q";
	    		abjad5.setText("q");
	    	} else if (arg == "r") {
	    		idabjad5 = "r";
	    		abjad5.setText("r");
	    	} else if (arg == "s") {
	    		idabjad5 = "s";
	    		abjad5.setText("s");
	    	} else if (arg == "t") {
	    		idabjad5 = "t";
	    		abjad5.setText("t");
	    	} else if (arg == "u") {
	    		idabjad5 = "u";
	    		abjad5.setText("u");
	    	} else if (arg == "v") {
	    		idabjad5 = "v";
	    		abjad5.setText("v");
	    	} else if (arg == "w") {
	    		idabjad5 = "w";
	    		abjad5.setText("w");
	    	} else if (arg == "x") {
	    		idabjad5 = "x";
	    		abjad5.setText("x");
	    	} else if (arg == "y") {
	    		idabjad5 = "y";
	    		abjad5.setText("y");
	    	} else if (arg == "z") {
	    		idabjad5 = "z";
	    		abjad5.setText("z");
	    	}
	 }
	 
	 public void rand_abjad6 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad6 = "a";
	    		abjad6.setText("a");
	    	} else if (arg == "b") {
	    		idabjad6 = "b";
	    		abjad6.setText("b");
	    	} else if (arg == "c") {
	    		idabjad6 = "c";
	    		abjad6.setText("c");
	    	} else if (arg == "d") {
	    		idabjad6 = "d";
	    		abjad6.setText("d");
	    	} else if (arg == "e") {
	    		idabjad6 = "e";
	    		abjad6.setText("e");
	    	} else if (arg == "f") {
	    		idabjad6 = "f";
	    		abjad6.setText("f");
	    	} else if (arg == "g") {
	    		idabjad6 = "g";
	    		abjad6.setText("g");
	    	} else if (arg == "h") {
	    		idabjad6 = "h";
	    		abjad6.setText("h");
	    	} else if (arg == "i") {
	    		idabjad6 = "i";
	    		abjad6.setText("i");
	    	} else if (arg == "j") {
	    		idabjad6 = "j";
	    		abjad6.setText("j");
	    	} else if (arg == "k") {
	    		idabjad6 = "k";
	    		abjad6.setText("k");
	    	} else if (arg == "l") {
	    		idabjad6 = "l";
	    		abjad6.setText("l");
	    	} else if (arg == "m") {
	    		idabjad6 = "m";
	    		abjad6.setText("m");
	    	} else if (arg == "n") {
	    		idabjad6 = "n";
	    		abjad6.setText("n");
	    	} else if (arg == "o") {
	    		idabjad6 = "o";
	    		abjad6.setText("o");
	    	} else if (arg == "p") {
	    		idabjad6 = "p";
	    		abjad6.setText("p");
	    	} else if (arg == "q") {
	    		idabjad6 = "q";
	    		abjad6.setText("q");
	    	} else if (arg == "r") {
	    		idabjad6 = "r";
	    		abjad6.setText("r");
	    	} else if (arg == "s") {
	    		idabjad6 = "s";
	    		abjad6.setText("s");
	    	} else if (arg == "t") {
	    		idabjad6 = "t";
	    		abjad6.setText("t");
	    	} else if (arg == "u") {
	    		idabjad6 = "u";
	    		abjad6.setText("u");
	    	} else if (arg == "v") {
	    		idabjad6 = "v";
	    		abjad6.setText("v");
	    	} else if (arg == "w") {
	    		idabjad6 = "w";
	    		abjad6.setText("w");
	    	} else if (arg == "x") {
	    		idabjad6 = "x";
	    		abjad6.setText("x");
	    	} else if (arg == "y") {
	    		idabjad6 = "y";
	    		abjad6.setText("y");
	    	} else if (arg == "z") {
	    		idabjad6 = "z";
	    		abjad6.setText("z");
	    	}
	 }
	 
	 public void rand_abjad7 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad7 = "a";
	    		abjad7.setText("a");
	    	} else if (arg == "b") {
	    		idabjad7 = "b";
	    		abjad7.setText("b");
	    	} else if (arg == "c") {
	    		idabjad7 = "c";
	    		abjad7.setText("c");
	    	} else if (arg == "d") {
	    		idabjad7 = "d";
	    		abjad7.setText("d");
	    	} else if (arg == "e") {
	    		idabjad7 = "e";
	    		abjad7.setText("e");
	    	} else if (arg == "f") {
	    		idabjad7 = "f";
	    		abjad7.setText("f");
	    	} else if (arg == "g") {
	    		idabjad7 = "g";
	    		abjad7.setText("g");
	    	} else if (arg == "h") {
	    		idabjad7 = "h";
	    		abjad7.setText("h");
	    	} else if (arg == "i") {
	    		idabjad7 = "i";
	    		abjad7.setText("i");
	    	} else if (arg == "j") {
	    		idabjad7 = "j";
	    		abjad7.setText("j");
	    	} else if (arg == "k") {
	    		idabjad7 = "k";
	    		abjad7.setText("k");
	    	} else if (arg == "l") {
	    		idabjad7 = "l";
	    		abjad7.setText("l");
	    	} else if (arg == "m") {
	    		idabjad7 = "m";
	    		abjad7.setText("m");
	    	} else if (arg == "n") {
	    		idabjad7 = "n";
	    		abjad7.setText("n");
	    	} else if (arg == "o") {
	    		idabjad7 = "o";
	    		abjad7.setText("o");
	    	} else if (arg == "p") {
	    		idabjad7 = "p";
	    		abjad7.setText("p");
	    	} else if (arg == "q") {
	    		idabjad7 = "q";
	    		abjad7.setText("q");
	    	} else if (arg == "r") {
	    		idabjad7 = "r";
	    		abjad7.setText("r");
	    	} else if (arg == "s") {
	    		idabjad7 = "s";
	    		abjad7.setText("s");
	    	} else if (arg == "t") {
	    		idabjad7 = "t";
	    		abjad7.setText("t");
	    	} else if (arg == "u") {
	    		idabjad7 = "u";
	    		abjad7.setText("u");
	    	} else if (arg == "v") {
	    		idabjad7 = "v";
	    		abjad7.setText("v");
	    	} else if (arg == "w") {
	    		idabjad7 = "w";
	    		abjad7.setText("w");
	    	} else if (arg == "x") {
	    		idabjad7 = "x";
	    		abjad7.setText("x");
	    	} else if (arg == "y") {
	    		idabjad7 = "y";
	    		abjad7.setText("y");
	    	} else if (arg == "z") {
	    		idabjad7 = "z";
	    		abjad7.setText("z");
	    	}
	 }
	 
	 public void rand_abjad8 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad8 = "a";
	    		abjad8.setText("a");
	    	} else if (arg == "b") {
	    		idabjad8 = "b";
	    		abjad8.setText("b");
	    	} else if (arg == "c") {
	    		idabjad8 = "c";
	    		abjad8.setText("c");
	    	} else if (arg == "d") {
	    		idabjad8 = "d";
	    		abjad8.setText("d");
	    	} else if (arg == "e") {
	    		idabjad8 = "e";
	    		abjad8.setText("e");
	    	} else if (arg == "f") {
	    		idabjad8 = "f";
	    		abjad8.setText("f");
	    	} else if (arg == "g") {
	    		idabjad8 = "g";
	    		abjad8.setText("g");
	    	} else if (arg == "h") {
	    		idabjad8 = "h";
	    		abjad8.setText("h");
	    	} else if (arg == "i") {
	    		idabjad8 = "i";
	    		abjad8.setText("i");
	    	} else if (arg == "j") {
	    		idabjad8 = "j";
	    		abjad8.setText("j");
	    	} else if (arg == "k") {
	    		idabjad8 = "k";
	    		abjad8.setText("k");
	    	} else if (arg == "l") {
	    		idabjad8 = "l";
	    		abjad8.setText("l");
	    	} else if (arg == "m") {
	    		idabjad8 = "m";
	    		abjad8.setText("m");
	    	} else if (arg == "n") {
	    		idabjad8 = "n";
	    		abjad8.setText("n");
	    	} else if (arg == "o") {
	    		idabjad8 = "o";
	    		abjad8.setText("o");
	    	} else if (arg == "p") {
	    		idabjad8 = "p";
	    		abjad8.setText("p");
	    	} else if (arg == "q") {
	    		idabjad8 = "q";
	    		abjad8.setText("q");
	    	} else if (arg == "r") {
	    		idabjad8 = "r";
	    		abjad8.setText("r");
	    	} else if (arg == "s") {
	    		idabjad8 = "s";
	    		abjad8.setText("s");
	    	} else if (arg == "t") {
	    		idabjad8 = "t";
	    		abjad8.setText("t");
	    	} else if (arg == "u") {
	    		idabjad8 = "u";
	    		abjad8.setText("u");
	    	} else if (arg == "v") {
	    		idabjad8 = "v";
	    		abjad8.setText("v");
	    	} else if (arg == "w") {
	    		idabjad8 = "w";
	    		abjad8.setText("w");
	    	} else if (arg == "x") {
	    		idabjad8 = "x";
	    		abjad8.setText("x");
	    	} else if (arg == "y") {
	    		idabjad8 = "y";
	    		abjad8.setText("y");
	    	} else if (arg == "z") {
	    		idabjad8 = "z";
	    		abjad8.setText("z");
	    	}
	 }
	 
	 public void rand_abjad9 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad9 = "a";
	    		abjad9.setText("a");
	    	} else if (arg == "b") {
	    		idabjad9 = "b";
	    		abjad9.setText("b");
	    	} else if (arg == "c") {
	    		idabjad9 = "c";
	    		abjad9.setText("c");
	    	} else if (arg == "d") {
	    		idabjad9 = "d";
	    		abjad9.setText("d");
	    	} else if (arg == "e") {
	    		idabjad9 = "e";
	    		abjad9.setText("e");
	    	} else if (arg == "f") {
	    		idabjad9 = "f";
	    		abjad9.setText("f");
	    	} else if (arg == "g") {
	    		idabjad9 = "g";
	    		abjad9.setText("g");
	    	} else if (arg == "h") {
	    		idabjad9 = "h";
	    		abjad9.setText("h");
	    	} else if (arg == "i") {
	    		idabjad9 = "i";
	    		abjad9.setText("i");
	    	} else if (arg == "j") {
	    		idabjad9 = "j";
	    		abjad9.setText("j");
	    	} else if (arg == "k") {
	    		idabjad9 = "k";
	    		abjad9.setText("k");
	    	} else if (arg == "l") {
	    		idabjad9 = "l";
	    		abjad9.setText("l");
	    	} else if (arg == "m") {
	    		idabjad9 = "m";
	    		abjad9.setText("m");
	    	} else if (arg == "n") {
	    		idabjad9 = "n";
	    		abjad9.setText("n");
	    	} else if (arg == "o") {
	    		idabjad9 = "o";
	    		abjad9.setText("o");
	    	} else if (arg == "p") {
	    		idabjad9 = "p";
	    		abjad9.setText("p");
	    	} else if (arg == "q") {
	    		idabjad9 = "q";
	    		abjad9.setText("q");
	    	} else if (arg == "r") {
	    		idabjad9 = "r";
	    		abjad9.setText("r");
	    	} else if (arg == "s") {
	    		idabjad9 = "s";
	    		abjad9.setText("s");
	    	} else if (arg == "t") {
	    		idabjad9 = "t";
	    		abjad9.setText("t");
	    	} else if (arg == "u") {
	    		idabjad9 = "u";
	    		abjad9.setText("u");
	    	} else if (arg == "v") {
	    		idabjad9 = "v";
	    		abjad9.setText("v");
	    	} else if (arg == "w") {
	    		idabjad9 = "w";
	    		abjad9.setText("w");
	    	} else if (arg == "x") {
	    		idabjad9 = "x";
	    		abjad9.setText("x");
	    	} else if (arg == "y") {
	    		idabjad9 = "y";
	    		abjad9.setText("y");
	    	} else if (arg == "z") {
	    		idabjad9 = "z";
	    		abjad9.setText("z");
	    	}
	 }
	 
	 public void rand_abjad10 (String arg) {
	    	
			if (arg == "a") {
	    		idabjad10 = "a";
	    		abjad10.setText("a");
	    	} else if (arg == "b") {
	    		idabjad10 = "b";
	    		abjad10.setText("b");
	    	} else if (arg == "c") {
	    		idabjad10 = "c";
	    		abjad10.setText("c");
	    	} else if (arg == "d") {
	    		idabjad10 = "d";
	    		abjad10.setText("d");
	    	} else if (arg == "e") {
	    		idabjad10 = "e";
	    		abjad10.setText("e");
	    	} else if (arg == "f") {
	    		idabjad10 = "f";
	    		abjad10.setText("f");
	    	} else if (arg == "g") {
	    		idabjad10 = "g";
	    		abjad10.setText("g");
	    	} else if (arg == "h") {
	    		idabjad10 = "h";
	    		abjad10.setText("h");
	    	} else if (arg == "i") {
	    		idabjad10 = "i";
	    		abjad10.setText("i");
	    	} else if (arg == "j") {
	    		idabjad10 = "j";
	    		abjad10.setText("j");
	    	} else if (arg == "k") {
	    		idabjad10 = "k";
	    		abjad10.setText("k");
	    	} else if (arg == "l") {
	    		idabjad10 = "l";
	    		abjad10.setText("l");
	    	} else if (arg == "m") {
	    		idabjad10 = "m";
	    		abjad10.setText("m");
	    	} else if (arg == "n") {
	    		idabjad10 = "n";
	    		abjad10.setText("n");
	    	} else if (arg == "o") {
	    		idabjad10 = "o";
	    		abjad10.setText("o");
	    	} else if (arg == "p") {
	    		idabjad10 = "p";
	    		abjad10.setText("p");
	    	} else if (arg == "q") {
	    		idabjad10 = "q";
	    		abjad10.setText("q");
	    	} else if (arg == "r") {
	    		idabjad10 = "r";
	    		abjad10.setText("r");
	    	} else if (arg == "s") {
	    		idabjad10 = "s";
	    		abjad10.setText("s");
	    	} else if (arg == "t") {
	    		idabjad10 = "t";
	    		abjad10.setText("t");
	    	} else if (arg == "u") {
	    		idabjad10 = "u";
	    		abjad10.setText("u");
	    	} else if (arg == "v") {
	    		idabjad10 = "v";
	    		abjad10.setText("v");
	    	} else if (arg == "w") {
	    		idabjad10 = "w";
	    		abjad10.setText("w");
	    	} else if (arg == "x") {
	    		idabjad10 = "x";
	    		abjad10.setText("x");
	    	} else if (arg == "y") {
	    		idabjad10 = "y";
	    		abjad10.setText("y");
	    	} else if (arg == "z") {
	    		idabjad10 = "z";
	    		abjad10.setText("z");
	    	}
	 }
	 
	 
	 private void gantiwarna(String arg) {
		 if (arg == "merah") {
			 abjad1.setBackgroundResource(R.drawable.wmerah);
		 abjad2.setBackgroundResource(R.drawable.wmerah);
		 abjad3.setBackgroundResource(R.drawable.wmerah);
		 abjad4.setBackgroundResource(R.drawable.wmerah);
		 abjad5.setBackgroundResource(R.drawable.wmerah);
		 abjad6.setBackgroundResource(R.drawable.wmerah);
		 abjad7.setBackgroundResource(R.drawable.wmerah);
		 abjad8.setBackgroundResource(R.drawable.wmerah);
		 abjad9.setBackgroundResource(R.drawable.wmerah);
		 abjad10.setBackgroundResource(R.drawable.wmerah);
	 } else if (arg == "hijau") {
		 
		 abjad1.setBackgroundResource(R.drawable.whijau);
		 abjad2.setBackgroundResource(R.drawable.whijau);
		 abjad3.setBackgroundResource(R.drawable.whijau);
		 abjad4.setBackgroundResource(R.drawable.whijau);
		 abjad5.setBackgroundResource(R.drawable.whijau);
		 abjad6.setBackgroundResource(R.drawable.whijau);
		 abjad7.setBackgroundResource(R.drawable.whijau);
		 abjad8.setBackgroundResource(R.drawable.whijau);
		 abjad9.setBackgroundResource(R.drawable.whijau);
		 abjad10.setBackgroundResource(R.drawable.whijau);
		 
	 } else if (arg == "normal") {
		 
		 abjad1.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad2.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad3.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad4.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad5.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad6.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad7.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad8.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad9.setBackgroundResource(R.drawable.btn_main_activity);
		 abjad10.setBackgroundResource(R.drawable.btn_main_activity);
		 
	 } 
		 
	 }
	 
	 private void updateViews() {
		 
		 
		 
		 String items[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
				 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount;
	       final String list;
	       Random r = new Random();
	       list = items[r.nextInt(26)]; //yg da di random
	        
	       rand_abjad1(list);
	       
	       
	       String items2[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount2;
	       final String list2;
	       Random r2 = new Random();
	       list2 = items2[r2.nextInt(26)]; //yg da di random
	        
	       rand_abjad2(list2);
	       
	       
	       String items3[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount3;
	       final String list3;
	       Random r3 = new Random();
	       list3 = items3[r3.nextInt(26)]; //yg da di random
	        
	       rand_abjad3(list3);
		 
	 
	       
	       String items4[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount4;
	       final String list4;
	       Random r4 = new Random();
	       list4 = items4[r4.nextInt(26)]; //yg da di random
	        
	       rand_abjad4(list4);
		 
	 
	       String items5[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount5;
	       final String list5;
	       Random r5 = new Random();
	       list5 = items5[r5.nextInt(26)]; //yg da di random
	        
	       rand_abjad5(list5);
		 
	 
	       String items6[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount6;
	       final String list6;
	       Random r6 = new Random();
	       list6 = items6[r6.nextInt(26)]; //yg da di random
	        
	       rand_abjad6(list6);
		 
	 
	       String items7[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount7;
	       final String list7;
	       Random r7 = new Random();
	       list7 = items7[r7.nextInt(26)]; //yg da di random
	        
	       rand_abjad7(list7);
		 
	 
	       String items8[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount8;
	       final String list8;
	       Random r8 = new Random();
	       list8 = items8[r8.nextInt(26)]; //yg da di random
	        
	       rand_abjad8(list8);
		 
	 
	       String items9[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount9;
	       final String list9;
	       Random r9 = new Random();
	       list9 = items9[r9.nextInt(26)]; //yg da di random
	        
	       rand_abjad9(list9);
		 
	 
	       String items10[] = {"a", "b", "c", "d", "e", "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" 
					 , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
	       int amount10;
	       final String list10;
	       Random r10 = new Random();
	       list10 = items10[r10.nextInt(26)]; //yg da di random
	        
	       rand_abjad10(list10);
		 
	 
	         
	 }
	 
	 public void refresh() {
			Intent intent = getIntent();
	        finish();
	        overridePendingTransition(0,0);
	        startActivity(intent);
	        overridePendingTransition(0,0);
		}
	 
	
	 
	    public void back (View v) {
			finish();
		}
		
		@Override
	    public void onBackPressed() {
			finish();
		}
	    
		public void onPause() {
			super.onPause();
			bg.setVolume(0, 0);
		}
		
		public void onResume() {
			super.onResume();
			bg.setVolume(1, 1);
		}
		
		
	
	

}
