package com.tebayoll.hurufabjad;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.widget.*;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.media.MediaPlayer;
import android.os.Handler;


public class Abjad extends Activity {

	private MediaPlayer player;

    static int splash = 700;
    Button btnabc, btnabc_big;
    ImageView animAbjad, hewan_atas;
    public Animation muncul, hewan_atas_anim;
	public Button btna, btnb, btnc, btnd, btne, btnf, btng, btnh, btni, btnj, btnk, btnl, btnm, kiri, kanan,
	btnn, btno, btnp, btnq, btnr, btns, btnt, btnu, btnv, btnw, btnx, btny, btnz;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_abjad);

     // Font
		
     		 Typeface cell = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
         
        
        btnabc = (Button) findViewById(R.id.btnabc);

        btnabc_big = (Button) findViewById(R.id.btnabc_big);
        animAbjad = (ImageView) findViewById(R.id.animAbjad);
        hewan_atas = (ImageView) findViewById(R.id.hewan_atas);
        
        btna = (Button) findViewById(R.id.btna);
        btnb = (Button) findViewById(R.id.btnb);
        btnc = (Button) findViewById(R.id.btnc);
        btnd = (Button) findViewById(R.id.btnd);
        btne = (Button) findViewById(R.id.btne);
        btnf = (Button) findViewById(R.id.btnf);
        btng = (Button) findViewById(R.id.btng);
        btnh = (Button) findViewById(R.id.btnh);
        btni = (Button) findViewById(R.id.btni);
        btnj = (Button) findViewById(R.id.btnj);
        btnk = (Button) findViewById(R.id.btnk);
        btnl = (Button) findViewById(R.id.btnl);
        btnm = (Button) findViewById(R.id.btnm);
        btnn = (Button) findViewById(R.id.btnn);
        btno = (Button) findViewById(R.id.btno);
        btnp = (Button) findViewById(R.id.btnp);
        btnq = (Button) findViewById(R.id.btnq);
        btnr = (Button) findViewById(R.id.btnr);
        btns = (Button) findViewById(R.id.btns);
        btnt = (Button) findViewById(R.id.btnt);
        btnu = (Button) findViewById(R.id.btnu);
        btnv = (Button) findViewById(R.id.btnv);
        btnw = (Button) findViewById(R.id.btnw);
        btnx = (Button) findViewById(R.id.btnx);
        btny = (Button) findViewById(R.id.btny);
        btnz = (Button) findViewById(R.id.btnz);

        kiri = (Button) findViewById(R.id.tag_kiri);

        kanan = (Button) findViewById(R.id.tag_kanan);
        
        kiri.setTypeface(cell);
        kanan.setTypeface(cell);
        
        btna.setTypeface(cell);
        btnb.setTypeface(cell);
        btnc.setTypeface(cell);
        btnd.setTypeface(cell);
        btne.setTypeface(cell);
        btnf.setTypeface(cell);
        btng.setTypeface(cell);
        btnh.setTypeface(cell);
        btni.setTypeface(cell);
        btnj.setTypeface(cell);
        btnk.setTypeface(cell);
        btnl.setTypeface(cell);
        btnm.setTypeface(cell);
        btnn.setTypeface(cell);
        btno.setTypeface(cell);
        btnp.setTypeface(cell);
        btnq.setTypeface(cell);
        btnr.setTypeface(cell);
        btns.setTypeface(cell);
        btnt.setTypeface(cell);
        btnu.setTypeface(cell);
        btnv.setTypeface(cell);
        btnw.setTypeface(cell);
        btnx.setTypeface(cell);
        btny.setTypeface(cell);
        btnz.setTypeface(cell);
        btnabc.setTypeface(cell);
        btnabc_big.setTypeface(cell);
       
        
     // Animation
		
		muncul = AnimationUtils.loadAnimation(this, R.anim.abjmuncul);
		 
		hewan_atas_anim = AnimationUtils.loadAnimation(this, R.anim.hewan_atas);
        
        
        btnabc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	kapital("kecil");
            	btnabc_big.setBackgroundResource(R.drawable.btnp_xml);
            	btnabc.setBackgroundResource(R.drawable.btnp_active);
            }
        });  
        
        btnabc_big.setBackgroundResource(R.drawable.btnp_active);
        
        btnabc_big.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               
            	kapital("besar");
            	btnabc.setBackgroundResource(R.drawable.btnp_xml);
            	btnabc_big.setBackgroundResource(R.drawable.btnp_active);
                
            	
             }
         });
        
        
        btna.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("a");
                tangani("a");
            }
        });
        
        btnb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("b");
                tangani("b");
            }
        });
        
        btnc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("c");
                tangani("c");
            }
        });
        
        btnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("d");
                tangani("d");
            }
        });
        
        btne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("e");
                tangani("e");
            }
        });
        
        btnf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("f");
                tangani("f");
            }
        });
        
        btng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("g");
                tangani("g");
            }
        });
        
        btnh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("h");
                tangani("h");
            }
        });
        
        btni.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("i");
                tangani("i");
            }
        });
        
        btnj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("j");
                tangani("j");
            }
        });
        
        btnk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("k");
                tangani("k");
            }
        });
        
        btnl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("l");
                tangani("l");
            }
        });
        
        btnm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("m");
                tangani("m");
            }
        });
        
        btnn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("n");
                tangani("n");
            }
        });
        
        btno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("o");
                tangani("o");
            }
        });
        
        btnp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("p");
                tangani("p");
            }
        });
        
        btnq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("q");
                tangani("q");
            }
        });
        
        btnr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("r");
                tangani("r");
            }
        });
        
        btns.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("s");
                tangani("s");
            }
        });
        
        btnt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("t");
                tangani("t");
            }
        });
        
        btnu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("u");
                tangani("u");
            }
        });
        
        btnv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("v");
                tangani("v");
            }
        });
        
        btnw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("w");
                tangani("w");
            }
        });
        
        btnx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("x");
                tangani("x");
            }
        });
        
        btny.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("y");
                tangani("y");
            }
        });
        
        btnz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playSound("z");
                tangani("z");
            }
        });
        
      
        
    }
    
   

   	private void playSound(String arg){
   		try{
   			if (player.isPlaying()) {
   				player.stop();
   				player.release();
   			}
   		}catch(Exception e){
   			
   		}
   		
   		if (arg == "a"){
   			player = MediaPlayer.create(this, R.raw.a);

   		} else if (arg == "b") {
   			player = MediaPlayer.create(this, R.raw.b);
   		} else if (arg == "c") {
   			player = MediaPlayer.create(this, R.raw.c);
   		} else if (arg == "d") {
   			player = MediaPlayer.create(this, R.raw.d);
   		} else if (arg == "e") {
   			player = MediaPlayer.create(this, R.raw.e);
   		} else if (arg == "f") {
   			player = MediaPlayer.create(this, R.raw.f);
   		} else if (arg == "g") {
   			player = MediaPlayer.create(this, R.raw.g);
   		} else if (arg == "h") {
   			player = MediaPlayer.create(this, R.raw.h);
   		} else if (arg == "i") {
   			player = MediaPlayer.create(this, R.raw.i);
   		} else if (arg == "j") {
   			player = MediaPlayer.create(this, R.raw.j);
   		} else if (arg == "k") {
   			player = MediaPlayer.create(this, R.raw.k);
   		} else if (arg == "l") {
   			player = MediaPlayer.create(this, R.raw.l);
   		} else if (arg == "m") {
   			player = MediaPlayer.create(this, R.raw.m);
   		} else if (arg == "n") {
   			player = MediaPlayer.create(this, R.raw.n);
   		} else if (arg == "o") {
   			player = MediaPlayer.create(this, R.raw.o);
   		} else if (arg == "p") {
   			player = MediaPlayer.create(this, R.raw.p);
   		} else if (arg == "q") {
   			player = MediaPlayer.create(this, R.raw.q);
   		} else if (arg == "r") {
   			player = MediaPlayer.create(this, R.raw.r);
   		} else if (arg == "s") {
   			player = MediaPlayer.create(this, R.raw.s);
   		} else if (arg == "t") {
   			player = MediaPlayer.create(this, R.raw.t);
   		} else if (arg == "u") {
   			player = MediaPlayer.create(this, R.raw.u);
   		} else if (arg == "v") {
   			player = MediaPlayer.create(this, R.raw.v);
   		} else if (arg == "w") {
   			player = MediaPlayer.create(this, R.raw.w);
   		} else if (arg == "x") {
   			player = MediaPlayer.create(this, R.raw.x);
   		} else if (arg == "y") {
   			player = MediaPlayer.create(this, R.raw.y);
   		} else if (arg == "z") {
   			player = MediaPlayer.create(this, R.raw.z);
   		}
   		
   		player.setLooping(false); // Set looping
   		player.start();
   	}
   	
   	// handler animation karo liane
   	
   	public void tangani(String arg) {
   		
   		if (arg == "a") {
   			tahan("mati");
   			animAbjad.setBackgroundResource(R.drawable.ha);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.ayam);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "b") {
   			tahan("mati");
   			animAbjad.setBackgroundResource(R.drawable.hb);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.beruang);
   			hewan_atas.startAnimation(hewan_atas_anim);
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "c") {
   			tahan("mati");
   			animAbjad.setBackgroundResource(R.drawable.hc);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.cicak);
   			hewan_atas.startAnimation(hewan_atas_anim);
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "d") {
   			animAbjad.setBackgroundResource(R.drawable.hd);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.domba);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "e") {
   			animAbjad.setBackgroundResource(R.drawable.he);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.elang);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "f") {
   			animAbjad.setBackgroundResource(R.drawable.hf);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.flamingo);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "g") {
   			animAbjad.setBackgroundResource(R.drawable.hg);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.gajah);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "h") {
   			animAbjad.setBackgroundResource(R.drawable.hh);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.harimau);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "i") {
   			animAbjad.setBackgroundResource(R.drawable.hi);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.ikan);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "j") {
   			animAbjad.setBackgroundResource(R.drawable.hj);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.jangkrik);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "k") {
   			animAbjad.setBackgroundResource(R.drawable.hk);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.kerbau);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "l") {
   			animAbjad.setBackgroundResource(R.drawable.hl);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.lalat);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "m") {
   			animAbjad.setBackgroundResource(R.drawable.hm);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.merpati);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "n") {
   			animAbjad.setBackgroundResource(R.drawable.hn);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.nyamuk);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "o") {
   			animAbjad.setBackgroundResource(R.drawable.ho);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.orangutan);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "p") {
   			animAbjad.setBackgroundResource(R.drawable.hp);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.panda);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "q") {
   			animAbjad.setBackgroundResource(R.drawable.hq);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.quokka);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "r") {
   			animAbjad.setBackgroundResource(R.drawable.hr);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.rusa);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "s") {
   			animAbjad.setBackgroundResource(R.drawable.hs);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.singa);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "t") {
   			animAbjad.setBackgroundResource(R.drawable.ht);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.tikus);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "u") {
   			animAbjad.setBackgroundResource(R.drawable.hu);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.ular);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "v") {
   			animAbjad.setBackgroundResource(R.drawable.hv);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.INVISIBLE);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "w") {
   			animAbjad.setBackgroundResource(R.drawable.hw);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.walet);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "x") {
   			animAbjad.setBackgroundResource(R.drawable.hx);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.INVISIBLE);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "y") {
   			animAbjad.setBackgroundResource(R.drawable.hy);
   			animAbjad.startAnimation(muncul);
   			hewan_atas.setVisibility(View.INVISIBLE);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} else if (arg == "z") {
   			animAbjad.setBackgroundResource(R.drawable.hz);
   			animAbjad.startAnimation(muncul);
   			
   			hewan_atas.setVisibility(View.VISIBLE);
   			hewan_atas.setBackgroundResource(R.drawable.zebra);
   			hewan_atas.startAnimation(hewan_atas_anim);
   			tahan("mati");
   		 new Handler().postDelayed(new Runnable() {


             @Override
             public void run() {

                 // setelah splash
            	 tahan("jalan");

                 this.finish();
             }

             private void finish() {
             }
         }, splash);
   		} 
   	}
   	
   	// false or true button
   	
   	public void tahan(String arg) {
   		
   		if (arg == "mati") {
   			
   	   		btna.setEnabled(false);
   	   		btnb.setEnabled(false);
   	   		btnc.setEnabled(false);
   	   		btnd.setEnabled(false);
   	   		btne.setEnabled(false);
   	   		btnf.setEnabled(false);
   	   		btng.setEnabled(false);
   	   		btnh.setEnabled(false);
   	   		btni.setEnabled(false);
   	   		btnj.setEnabled(false);
   	   		btnk.setEnabled(false);
   	   		btnl.setEnabled(false);
   	   		btnm.setEnabled(false);
   	   		btnn.setEnabled(false);
   	   		btno.setEnabled(false);
   	   		btnp.setEnabled(false);
   	   		btnq.setEnabled(false);
   	   		btnr.setEnabled(false);
   	   		btns.setEnabled(false);
   	   		btnt.setEnabled(false);
   	   		btnu.setEnabled(false);
   	   		btnv.setEnabled(false);
   	   		btnw.setEnabled(false);
   	   		btnx.setEnabled(false);
   	   		btny.setEnabled(false);
   	   		btnz.setEnabled(false);
   		} else if (arg == "jalan") {
   			btna.setEnabled(true);
   	   		btnb.setEnabled(true);
   	   		btnc.setEnabled(true);
   	   		btnd.setEnabled(true);
   	   		btne.setEnabled(true);
   	   		btnf.setEnabled(true);
   	   		btng.setEnabled(true);
   	   		btnh.setEnabled(true);
   	   		btni.setEnabled(true);
   	   		btnj.setEnabled(true);
   	   		btnk.setEnabled(true);
   	   		btnl.setEnabled(true);
   	   		btnm.setEnabled(true);
   	   		btnn.setEnabled(true);
   	   		btno.setEnabled(true);
   	   		btnp.setEnabled(true);
   	   		btnq.setEnabled(true);
   	   		btnr.setEnabled(true);
   	   		btns.setEnabled(true);
   	   		btnt.setEnabled(true);
   	   		btnu.setEnabled(true);
   	   		btnv.setEnabled(true);
   	   		btnw.setEnabled(true);
   	   		btnx.setEnabled(true);
   	   		btny.setEnabled(true);
   	   		btnz.setEnabled(true);
   		}
   		
   	}
   	
    // besar or kecil button
    
    public void kapital(String arg) {
        
        if (arg == "besar") {
            
            btna.setText("A");
            btnb.setText("B");
            btnc.setText("C");
            btnd.setText("D");
            btne.setText("E");
            btnf.setText("F");
            btng.setText("G");
            btnh.setText("H");
            btni.setText("I");
            btnj.setText("J");
            btnk.setText("K");
            btnl.setText("L");
            btnm.setText("M");
            btnn.setText("N");
            btno.setText("O");
            btnp.setText("P");
            btnq.setText("Q");
            btnr.setText("R");
            btns.setText("S");
            btnt.setText("T");
            btnu.setText("U");
            btnv.setText("V");
            btnw.setText("W");
            btnx.setText("X");
            btny.setText("Y");
            btnz.setText("Z");
        } else if (arg == "kecil") {
            btna.setText("a");
            btnb.setText("b");
            btnc.setText("c");
            btnd.setText("d");
            btne.setText("e");
            btnf.setText("f");
            btng.setText("g");
            btnh.setText("h");
            btni.setText("i");
            btnj.setText("j");
            btnk.setText("k");
            btnl.setText("l");
            btnm.setText("m");
            btnn.setText("n");
            btno.setText("o");
            btnp.setText("p");
            btnq.setText("q");
            btnr.setText("r");
            btns.setText("s");
            btnt.setText("t");
            btnu.setText("u");
            btnv.setText("v");
            btnw.setText("w");
            btnx.setText("x");
            btny.setText("y");
            btnz.setText("z");
        }
        
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
		MainActivity.player.setVolume(0, 0);
	}
	
	public void onResume() {
		super.onResume();
		MainActivity.player.setVolume(1, 1);
	}

   
}
