package com.tebayoll.hurufabjad;



import android.app.Activity;
import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.*;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.media.MediaPlayer;
import android.os.Handler;

public class Hewan extends Activity {

	public Typeface cell;
    static int splash = 3000;
	private MediaPlayer suara;
	public Button textAnim, abjadAnim, tag_kiri, tag_kanan;
	public RelativeLayout rl;
	public ImageView hewanAnim, ayam, beruang, cicak, domba, elang, flamingo, gajah, harimau, ikan,
	jangkrik, kerbau, lalat, merpati, nyamuk, orangutan, panda, quokka, rusa, singa, tikus, ular, walet, zebra;
	public Animation plat, muncul, hilang, abjad_anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_hewan);

		textAnim = (Button) findViewById(R.id.textAnim);
		abjadAnim = (Button) findViewById(R.id.abjadAnim);
		tag_kiri = (Button) findViewById(R.id.tag_kiri);
		tag_kanan = (Button) findViewById(R.id.tag_kanan);
		rl = (RelativeLayout) findViewById(R.id.rlHewan);
		
		hewanAnim = (ImageView) findViewById(R.id.hewanAnim);
		ayam = (ImageView) findViewById(R.id.ayam);
		beruang = (ImageView) findViewById(R.id.beruang);
		cicak = (ImageView) findViewById(R.id.cicak);
		domba = (ImageView) findViewById(R.id.domba);
		elang = (ImageView) findViewById(R.id.elang);
		flamingo = (ImageView) findViewById(R.id.flamingo);
		gajah = (ImageView) findViewById(R.id.gajah);
		harimau = (ImageView) findViewById(R.id.harimau);
		ikan = (ImageView) findViewById(R.id.ikan);
		jangkrik = (ImageView) findViewById(R.id.jangkrik);
		kerbau = (ImageView) findViewById(R.id.kerbau);
		lalat = (ImageView) findViewById(R.id.lalat);
		merpati = (ImageView) findViewById(R.id.merpati);
		nyamuk = (ImageView) findViewById(R.id.nyamuk);
		orangutan = (ImageView) findViewById(R.id.orangutan);
		panda = (ImageView) findViewById(R.id.panda);
		quokka = (ImageView) findViewById(R.id.quokka);
		rusa = (ImageView) findViewById(R.id.rusa);
		singa = (ImageView) findViewById(R.id.singa);
		tikus = (ImageView) findViewById(R.id.tikus);
		ular = (ImageView) findViewById(R.id.ular);
		walet = (ImageView) findViewById(R.id.walet);
		zebra = (ImageView) findViewById(R.id.zebra);
		
		// Font
		
		 cell = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
    
		 textAnim.setTypeface(cell);
		 tag_kiri.setTypeface(cell);
		 tag_kanan.setTypeface(cell);
		
		// Animation
		
				muncul = AnimationUtils.loadAnimation(this, R.anim.muncul);
				hilang = AnimationUtils.loadAnimation(this, R.anim.hilang);
				plat = AnimationUtils.loadAnimation(this, R.anim.plat);

				abjad_anim = AnimationUtils.loadAnimation(this, R.anim.hewan_atas);
				
		
		ayam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("ayam");
                ayam.startAnimation(plat);
            }
        });
		
		beruang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("beruang");
                beruang.startAnimation(plat);
            }
        });
        
        cicak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("cicak");
                cicak.startAnimation(plat);
            }
        });
        
        domba.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("domba");
                domba.startAnimation(plat);
            }
        });
        
        elang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("elang");
                elang.startAnimation(plat);
            }
        });
        
        flamingo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("flamingo");
                flamingo.startAnimation(plat);
            }
        });
        
        gajah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("gajah");
                gajah.startAnimation(plat);
            }
        });
        
        harimau.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("harimau");
                harimau.startAnimation(plat);
            }
        });
        
        ikan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("ikan");
                ikan.startAnimation(plat);
            }
        });
        
        jangkrik.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("jangkrik");
                jangkrik.startAnimation(plat);
            }
        });
        
        kerbau.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("kerbau");
                kerbau.startAnimation(plat);
            }
        });
        
        lalat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("lalat");
                lalat.startAnimation(plat);
            }
        });
        
        merpati.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("merpati");
                merpati.startAnimation(plat);
            }
        });
        
        nyamuk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("nyamuk");
                nyamuk.startAnimation(plat);
            }
        });
        
        orangutan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("orangutan");
                orangutan.startAnimation(plat);
            }
        });
        
        panda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("panda");
                panda.startAnimation(plat);
            }
        });
        
        quokka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("quokka");
                quokka.startAnimation(plat);
            }
        });
        
        rusa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("rusa");
                rusa.startAnimation(plat);
            }
        });
        
        singa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("singa");
                singa.startAnimation(plat);
            }
        });
        
        tikus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("tikus");
                tikus.startAnimation(plat);
            }
        });
        
        ular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("ular");
                ular.startAnimation(plat);
            }
        });
        
        walet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("walet");
                walet.startAnimation(plat);
            }
        });
        
        zebra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                atasibro("zebra");
                zebra.startAnimation(plat);
            }
        });
		
		
		
	}
	
	
	
	 
	
public void atasibro(String arg) {
		
		try{
   			if (suara.isPlaying()) {
   				suara.stop();
   				suara.release();
   			}
   		}catch(Exception e){
   			
   		}
		
		if (arg == "ayam") {
			tahan("mati");
			hewanAnim.setVisibility(View.VISIBLE);
			hewanAnim.setBackgroundResource(R.drawable.ayam);
			hewanAnim.startAnimation(muncul);
			

			textAnim.setVisibility(View.VISIBLE);
			textAnim.setText("ayam");
			textAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.ha);
			abjadAnim.startAnimation(abjad_anim);
			suara = MediaPlayer.create(this, R.raw.ayam);
        	
        	
			 new Handler().postDelayed(new Runnable() {


	             @Override
	             public void run() {

	                 // setelah splash
	     				tahan("jalan");
	            	 	hewanAnim.startAnimation(hilang);
		    			
		    			
		    			
		     			
	     			
	     			

	                 this.finish();
	             }

	             private void finish() {
	             }
	         }, splash);
			
		} else if (arg == "beruang") {
			tahan("mati");
			hewanAnim.setVisibility(View.VISIBLE);
			hewanAnim.setBackgroundResource(R.drawable.beruang);
			hewanAnim.startAnimation(muncul);
			

			textAnim.setVisibility(View.VISIBLE);
			textAnim.setText("beruang");
			textAnim.startAnimation(muncul);
			suara = MediaPlayer.create(this, R.raw.beruang);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hb);
			abjadAnim.startAnimation(abjad_anim);
        	
        	
			 new Handler().postDelayed(new Runnable() {


	             @Override
	             public void run() {

	                 // setelah splash	
	     				tahan("jalan");
	            	 	hewanAnim.startAnimation(hilang);
		    			
		    			
		    			
		     			
	     			
	     			

	                 this.finish();
	             }

	             private void finish() {
	             }
	         }, splash);
        
		} else if (arg == "cicak") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.cicak);
            hewanAnim.startAnimation(muncul);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("cicak");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.cicak);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hc);
			abjadAnim.startAnimation(abjad_anim);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash

         				tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "domba") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.domba);
            hewanAnim.startAnimation(muncul);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("domba");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.domba);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hd);
			abjadAnim.startAnimation(abjad_anim);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "elang") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.elang);
            hewanAnim.startAnimation(muncul);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("elang");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.elang);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.he);
			abjadAnim.startAnimation(abjad_anim);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "flamingo") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.flamingo);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hf);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("flamingo");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.flamingo);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "gajah") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.gajah);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hg);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("gajah");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.gajah);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "harimau") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.harimau);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hh);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("harimau");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.harimau);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "ikan") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.ikan);
            hewanAnim.startAnimation(muncul);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("ikan");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.ikan);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hi);
			abjadAnim.startAnimation(abjad_anim);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "jangkrik") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.jangkrik);
            hewanAnim.startAnimation(muncul);
            

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hj);
			abjadAnim.startAnimation(abjad_anim);
            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("jangkrik");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.jangkrik);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "kerbau") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.kerbau);
            hewanAnim.startAnimation(muncul);

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hk);
			abjadAnim.startAnimation(abjad_anim);

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("kerbau");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.kerbau);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "lalat") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.lalat);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hl);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("lalat");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.lalat);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "merpati") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.merpati);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hm);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("merpati");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.merpati);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "nyamuk") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.nyamuk);
            hewanAnim.startAnimation(muncul);

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hn);
			abjadAnim.startAnimation(abjad_anim);

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("nyamuk");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.nyamuk);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "orangutan") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.orangutan);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.ho);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("orangutan");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.orangutan);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "panda") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.panda);
            hewanAnim.startAnimation(muncul);

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hp);
			abjadAnim.startAnimation(abjad_anim);

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("panda");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.panda);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "quokka") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.quokka);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hq);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("quokka");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.quokka);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "rusa") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.rusa);
            hewanAnim.startAnimation(muncul);

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hr);
			abjadAnim.startAnimation(abjad_anim);

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("rusa");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.rusa);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "singa") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.singa);
            hewanAnim.startAnimation(muncul);

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hs);
			abjadAnim.startAnimation(abjad_anim);

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("singa");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.singa);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "tikus") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.tikus);
            hewanAnim.startAnimation(muncul);
            

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.ht);
			abjadAnim.startAnimation(abjad_anim);
            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("tikus");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.tikus);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "ular") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.ular);
            hewanAnim.startAnimation(muncul);

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hu);
			abjadAnim.startAnimation(abjad_anim);

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("ular");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.ular);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "walet") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.walet);
            hewanAnim.startAnimation(muncul);
			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hw);
			abjadAnim.startAnimation(abjad_anim);
            

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("walet");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.walet);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        } else if (arg == "zebra") {
			tahan("mati");
            hewanAnim.setVisibility(View.VISIBLE);
            hewanAnim.setBackgroundResource(R.drawable.zebra);
            hewanAnim.startAnimation(muncul);

			
			abjadAnim.setVisibility(View.VISIBLE);
			abjadAnim.setBackgroundResource(R.drawable.hz);
			abjadAnim.startAnimation(abjad_anim);

            textAnim.setVisibility(View.VISIBLE);
            textAnim.setText("zebra");
            textAnim.startAnimation(muncul);
            suara = MediaPlayer.create(this, R.raw.zebra);
            
            
             new Handler().postDelayed(new Runnable() {


                 @Override
                 public void run() {

                     // setelah splash
         			tahan("jalan");
                        hewanAnim.startAnimation(hilang);
                        
                        
                        
                        
                    
                    

                     this.finish();
                 }

                 private void finish() {
                 }
             }, splash);
        
        }
		
		suara.setLooping(false); // Set perulangan mati
   		suara.start(); // suara hewan mainkan
		
	}
	

    public void tahan(String arg) {
        
        if (arg == "mati") {
            
            ayam.setEnabled(false);
            beruang.setEnabled(false);
            cicak.setEnabled(false);
            domba.setEnabled(false);
            elang.setEnabled(false);
            flamingo.setEnabled(false);
            gajah.setEnabled(false);
            harimau.setEnabled(false);
            ikan.setEnabled(false);
            jangkrik.setEnabled(false);
            kerbau.setEnabled(false);
            lalat.setEnabled(false);
            merpati.setEnabled(false);
            nyamuk.setEnabled(false);
            orangutan.setEnabled(false);
            panda.setEnabled(false);
            quokka.setEnabled(false);
            rusa.setEnabled(false);
            singa.setEnabled(false);
            tikus.setEnabled(false);
            ular.setEnabled(false);
            walet.setEnabled(false);
            zebra.setEnabled(false);
        } else if (arg == "jalan") {
        
            ayam.setEnabled(true);
            beruang.setEnabled(true);
            cicak.setEnabled(true);
            domba.setEnabled(true);
            elang.setEnabled(true);
            flamingo.setEnabled(true);
            gajah.setEnabled(true);
            harimau.setEnabled(true);
            ikan.setEnabled(true);
            jangkrik.setEnabled(true);
            kerbau.setEnabled(true);
            lalat.setEnabled(true);
            merpati.setEnabled(true);
            nyamuk.setEnabled(true);
            orangutan.setEnabled(true);
            panda.setEnabled(true);
            quokka.setEnabled(true);
            rusa.setEnabled(true);
            singa.setEnabled(true);
            tikus.setEnabled(true);
            ular.setEnabled(true);
            walet.setEnabled(true);
            zebra.setEnabled(true);
        }
        
    }
    
    
    
    public void back (View v) {
    	try{
   			if (suara.isPlaying()) {
   				suara.stop();
   				suara.release();
   			}
   		}catch(Exception e){
   			
   		}
    	
    	finish();
  	}
  	
  	@Override
      public void onBackPressed() {
  		try{
   			if (suara.isPlaying()) {
   				suara.stop();
   				suara.release();
   			}
   		}catch(Exception e){
   			
   		}
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
