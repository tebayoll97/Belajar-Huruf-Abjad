package com.tebayoll.hurufabjad;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.widget.*;
import android.view.*;
import android.widget.Button;
import android.media.MediaPlayer;
import android.os.Handler;




public class Tebak extends Activity  {
	
	Dialog myDialog;
    MediaPlayer suara;
    public Typeface cell;
    public Animation plat, gone, appear;

    
    static int splashjwb = 1500;
	String idpage="";
	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, tag_soal, btnjwb, btnreset, tag_pilih, tag_tebak;
	ImageView hewan, benar;
	RelativeLayout rlkanan, rlkiri;
	TextView tv_tips, tv_progress, tv_jwb;
	ProgressBar prolvl1;
	String t1="", t2="", t3="", t4="", t5="", t6="", t7="";
	
	Button l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20;
	
	int ayam, beruang, cicak, domba, elang, flamingo, gajah, harimau, ikan,
	jangkrik, kerbau, lalat, merpati, nyamuk, orangutan, panda, quokka, rusa, singa, tikus, ular, walet, zebra;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tebak);
        
     // Animation
		
     		gone = AnimationUtils.loadAnimation(this, R.anim.goneleft);
     		appear = AnimationUtils.loadAnimation(this, R.anim.appearleft);
		plat = AnimationUtils.loadAnimation(this, R.anim.plat);
        
		// random para tolol
		
        String items[] = {"ayam", "merpati", "ular", "kerbau", "ikan", "elang", "lalat", "beruang",
        		 "panda", "rusa", "cicak", "domba", "singa", "nyamuk", "quokka", "harimau",
        		 "walet", "tikus", "zebra", "gajah"};
        int amount;
        String list;
        Random r = new Random();
        amount = (int)(Math.random()*25+1); // used to determine the amount of cycles of getting a random string in items[] array.
         
        list = items[r.nextInt(20)]; //The variable I would like to use to store all of the randomly picked strings
         
       

		hewan = (ImageView) findViewById (R.id.hewan);
		benar = (ImageView) findViewById (R.id.benar);
		tag_soal = (Button) findViewById (R.id.tag_soal);
		tag_pilih = (Button) findViewById (R.id.tag_pilih_nomor);
		tag_tebak = (Button) findViewById (R.id.tag_header);
		btnjwb = (Button) findViewById (R.id.btnjwb);
		btnreset = (Button) findViewById (R.id.reset);
		
		//button lvl
		l1 = (Button) findViewById (R.id.lvl1);
		l3 = (Button) findViewById (R.id.lvl3);
		l2 = (Button) findViewById (R.id.lvl2);
		l4 = (Button) findViewById (R.id.lvl4);
		l5 = (Button) findViewById (R.id.lvl5);
		l6 = (Button) findViewById (R.id.lvl6);
		l7 = (Button) findViewById (R.id.lvl7);
		l8 = (Button) findViewById (R.id.lvl8);
		l9 = (Button) findViewById (R.id.lvl9);
		l10 = (Button) findViewById (R.id.lvl10);
		l11 = (Button) findViewById (R.id.lvl11);
		l12 = (Button) findViewById (R.id.lvl12);
		l13 = (Button) findViewById (R.id.lvl13);
		l14 = (Button) findViewById (R.id.lvl14);
		l15 = (Button) findViewById (R.id.lvl15);
		l16 = (Button) findViewById (R.id.lvl16);
		l17 = (Button) findViewById (R.id.lvl17);
		l18 = (Button) findViewById (R.id.lvl18);
		l19 = (Button) findViewById (R.id.lvl19);
		l20 = (Button) findViewById (R.id.lvl20);
		
		
		
		// button jawab
		btn1 = (Button) findViewById (R.id.btn1);
		btn2 = (Button) findViewById (R.id.btn2);
		btn3 = (Button) findViewById (R.id.btn3);
		btn4 = (Button) findViewById (R.id.btn4);
		btn5 = (Button) findViewById (R.id.btn5);
		btn6 = (Button) findViewById (R.id.btn6);
		btn7 = (Button) findViewById (R.id.btn7);
		btn8 = (Button) findViewById (R.id.btn8);
		btn9 = (Button) findViewById (R.id.btn9);
		
		prolvl1 = (ProgressBar) findViewById (R.id.prolvl1);
		tv_tips = (TextView) findViewById (R.id.tv_tips);
		tv_jwb = (TextView) findViewById (R.id.tv_jwb);
		
		
		 // Font
		
		cell = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
   
		l1.setTypeface(cell);
		l2.setTypeface(cell);
		l3.setTypeface(cell);
		l4.setTypeface(cell);
		l5.setTypeface(cell);
		l6.setTypeface(cell);
		l7.setTypeface(cell);
		l8.setTypeface(cell);
		l9.setTypeface(cell);
		l10.setTypeface(cell);
		l11.setTypeface(cell);
		l11.setTypeface(cell);
		l12.setTypeface(cell);
		l13.setTypeface(cell);
		l14.setTypeface(cell);
		l15.setTypeface(cell);
		l16.setTypeface(cell);
		l17.setTypeface(cell);
		l18.setTypeface(cell);
		l19.setTypeface(cell);
		l20.setTypeface(cell);
		
		

		btn1.setTypeface(cell);
		btn2.setTypeface(cell);
		btn3.setTypeface(cell);
		btn4.setTypeface(cell);
		btn5.setTypeface(cell);
		btn6.setTypeface(cell);
		btn7.setTypeface(cell);
		btn8.setTypeface(cell);
		btn9.setTypeface(cell);
		

		tag_soal.setTypeface(cell);
		tag_pilih.setTypeface(cell);
		tag_tebak.setTypeface(cell);
		btnjwb.setTypeface(cell);
		btnreset.setTypeface(cell);
		tv_jwb.setTypeface(cell);
		
		
      
	   // Retrive data id layout lvl1
		SharedPreferences splvl = getSharedPreferences("tebak", 0);
		
       ayam  = splvl.getInt("ayam" , 0);
       merpati = splvl.getInt("merpati" , 0);
       ular = splvl.getInt("ular" , 0);
       kerbau = splvl.getInt("kerbau" , 0);
       ikan = splvl.getInt("ikan" , 0);
       elang = splvl.getInt("elang" , 0);
       lalat = splvl.getInt("lalat" , 0);
       beruang  = splvl.getInt("beruang" , 0);
       panda = splvl.getInt("panda" , 0);
       rusa = splvl.getInt("rusa" , 0);
       cicak  = splvl.getInt("cicak" , 0);
       domba = splvl.getInt("domba" , 0);
       singa = splvl.getInt("singa" , 0);
       nyamuk = splvl.getInt("nyamuk" , 0);
       quokka = splvl.getInt("quokka" , 0);
       harimau = splvl.getInt("harimau" , 0);
       walet = splvl.getInt("walet" , 0);
       tikus = splvl.getInt("tikus" , 0);
       zebra = splvl.getInt("zebra" , 0);
       gajah = splvl.getInt("gajah" , 0);
		
       
       // handle reset button
       
       if (gajah == 1) {
    	   btnreset.setVisibility(View.VISIBLE);
       }
       
       myDialog = new Dialog(this);
       
       btnreset.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
        	   Button ya, tidak;
               
               myDialog.setContentView(R.layout.reset);
               

               ya = (Button) myDialog.findViewById(R.id.ya);
               tidak = (Button) myDialog.findViewById(R.id.tidak);
               
               ya.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                   	
                   	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                       SharedPreferences.Editor editor = splvl.edit();
                       editor.clear();
                       editor.commit();

                       MainActivity.reset.start();
                       
                       refresh();
                   }
               });
               
               tidak.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       myDialog.dismiss();
                   }
               });
      		

               myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               myDialog.show();
           	
           	
           
           }
       });
       
       // root
       
       if (ayam != 1) {
			page("ayam"); 
       } else if (merpati != 1) {
   		page("merpati"); 
       } else if (ular != 1) {
   		page("ular"); 
       } else if (kerbau != 1) {
   		page("kerbau"); 
       } else if (ikan != 1) {
       	page("ikan"); 
       } else if (elang != 1) {
       	page("elang"); 
       } else if (lalat != 1) {
       	page("lalat"); 
       } else if (beruang != 1) {
       	page("beruang"); 
       } else if (panda != 1) {
       	page("panda"); 
       } else if (rusa != 1) {
       	page("rusa"); 
       } else if (cicak != 1) {
       	page("cicak"); 
       } else if (domba != 1) {
       	page("domba"); 
       } else if (singa != 1) {
       	page("singa"); 
       } else if (nyamuk != 1) {
       	page("nyamuk"); 
       } else if (quokka != 1) {
       	page("quokka"); 
       } else if (harimau != 1) {
       	page("harimau"); 
       } else if (walet != 1) {
       	page("walet"); 
       } else if (tikus != 1) {
       	page("tikus"); 
       } else if (zebra != 1) {
       	page("zebra"); 
       } else if (gajah != 1) {
       	page("gajah"); 
       } else {
       	page(list);
       }
		
		
		// button lvl
		
		lvlbutton();
		
	    l1.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {

           	MainActivity.btn_klik.start();
           	page("ayam");
           	tkosong();
           
           }
       });
	    
	    l2.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (ayam == 1) {
       			page("merpati"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l3.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (merpati == 1) {
       			page("ular"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l4.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (ular == 1) {
       			page("kerbau"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	  
	    l5.setOnClickListener(new View.OnClickListener() {
	           public void onClick(View arg0) {
	        	   
	              	MainActivity.btn_klik.start();
	           	if (kerbau == 1) {
	       			page("ikan"); 
	               } else {
	               	
	               }
	           	tkosong();
	           
	           }
	       });
	    
	    l6.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (ikan == 1) {
       			page("elang"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l7.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (elang == 1) {
       			page("lalat"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l8.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (lalat == 1) {
       			page("beruang"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l9.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (beruang == 1) {
       			page("panda"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l10.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (panda == 1) {
       			page("rusa"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l11.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (rusa == 1) {
       			page("cicak"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l12.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (cicak == 1) {
       			page("domba"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l13.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (domba == 1) {
       			page("singa"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l14.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (singa == 1) {
       			page("nyamuk"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l15.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (nyamuk == 1) {
       			page("quokka"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l16.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (quokka == 1) {
       			page("harimau"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l17.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (harimau == 1) {
       			page("walet"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l18.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (walet == 1) {
       			page("tikus"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l19.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (tikus == 1) {
       			page("zebra"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    l20.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   
           	MainActivity.btn_klik.start();
           	if (zebra == 1) {
       			page("gajah"); 
               } else {
               	
               }
           	tkosong();
           
           }
       });
	    
	    
	    
	    
        
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

         	   
               	MainActivity.btn_klik.start();
            	if (idpage.equals("ayam")) {
                	button("a");
            	} else if (idpage.equals("merpati")) {
            		button("p");
            	} else if (idpage.equals("ular")) {
            		button("d");
            	} else if (idpage.equals("kerbau")) {
            		button("k");
            	} else if (idpage.equals("ikan")) {
            		button("k");
            	} else if (idpage.equals("elang")) {
            		button("m");
            	} else if (idpage.equals("lalat")) {
            		button("t");
            	} else if (idpage.equals("beruang")) {
            		button("g");
            	} else if (idpage.equals("panda")) {
            		button("a");
            	} else if (idpage.equals("rusa")) {
            		button("u");
            	} else if (idpage.equals("cicak")) {
            		button("k");
            	} else if (idpage.equals("domba")) {
            		button("a");
            	} else if (idpage.equals("singa")) {
            		button("g");
            	} else if (idpage.equals("nyamuk")) {
            		button("k");
            	} else if (idpage.equals("quokka")) {
            		button("q");
            	} else if (idpage.equals("harimau")) {
            		button("u");
            	} else if (idpage.equals("walet")) {
            		button("t");
            	} else if (idpage.equals("tikus")) {
            		button("z");
            	} else if (idpage.equals("zebra")) {
            		button("x");
            	} else if (idpage.equals("gajah")) {
            		button("h");
            	}
            
            }
        });
		
		btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
            	if (idpage.equals("ayam")) {
                	button("g");
            	} else if (idpage.equals("merpati")) {
            		button("r");
            	} else if (idpage.equals("ular")) {
            		button("z");
            	} else if (idpage.equals("kerbau")) {
            		button("r");
            	} else if (idpage.equals("ikan")) {
            		button("b");
            	} else if (idpage.equals("elang")) {
            		button("j");
            	} else if (idpage.equals("lalat")) {
            		button("l");
            	} else if (idpage.equals("beruang")) {
            		button("n");
            	} else if (idpage.equals("panda")) {
            		button("s");
            	} else if (idpage.equals("rusa")) {
            		button("p");
            	} else if (idpage.equals("cicak")) {
            		button("a");
            	} else if (idpage.equals("domba")) {
            		button("d");
            	} else if (idpage.equals("singa")) {
            		button("s");
            	} else if (idpage.equals("nyamuk")) {
            		button("n");
            	} else if (idpage.equals("quokka")) {
            		button("k");
            	} else if (idpage.equals("harimau")) {
            		button("r");
            	} else if (idpage.equals("walet")) {
            		button("w");
            	} else if (idpage.equals("tikus")) {
            		button("y");
            	} else if (idpage.equals("zebra")) {
            		button("d");
            	} else if (idpage.equals("gajah")) {
            		button("g");
            	}
            }
            
        });
		
		btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
            	if (idpage.equals("ayam")) {
                	button("u");
            	} else if (idpage.equals("merpati")) {
            		button("e");
            	} else if (idpage.equals("ular")) {
            		button("l");
            	} else if (idpage.equals("kerbau")) {
            		button("u");
            	} else if (idpage.equals("ikan")) {
            		button("x");
            	} else if (idpage.equals("elang")) {
            		button("n");
            	} else if (idpage.equals("lalat")) {
            		button("a");
            	} else if (idpage.equals("beruang")) {
            		button("u");
            	} else if (idpage.equals("panda")) {
            		button("d");
            	} else if (idpage.equals("rusa")) {
            		button("i");
            	} else if (idpage.equals("cicak")) {
            		button("n");
            	} else if (idpage.equals("domba")) {
            		button("b");
            	} else if (idpage.equals("singa")) {
            		button("i");
            	} else if (idpage.equals("nyamuk")) {
            		button("y");
            	} else if (idpage.equals("quokka")) {
            		button("a");
            	} else if (idpage.equals("harimau")) {
            		button("m");
            	} else if (idpage.equals("walet")) {
            		button("l");
            	} else if (idpage.equals("tikus")) {
            		button("i");
            	} else if (idpage.equals("zebra")) {
            		button("z");
            	} else if (idpage.equals("gajah")) {
            		button("m");
            	}
            }
            
        });
		
		btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
            	if (idpage.equals("ayam")) {
                	button("n");
            	} else if (idpage.equals("merpati")) {
            		button("i");
            	} else if (idpage.equals("ular")) {
            		button("n");
            	} else if (idpage.equals("kerbau")) {
            		button("d");
            	} else if (idpage.equals("ikan")) {
            		button("a");
            	} else if (idpage.equals("elang")) {
            		button("g");
            	} else if (idpage.equals("lalat")) {
            		button("y");
            	} else if (idpage.equals("beruang")) {
            		button("a");
            	} else if (idpage.equals("panda")) {
            		button("n");
            	} else if (idpage.equals("rusa")) {
            		button("a");
            	} else if (idpage.equals("cicak")) {
            		button("c");
            	} else if (idpage.equals("domba")) {
            		button("m");
            	} else if (idpage.equals("singa")) {
            		button("a");
            	} else if (idpage.equals("nyamuk")) {
            		button("m");
            	} else if (idpage.equals("quokka")) {
            		button("o");
            	} else if (idpage.equals("harimau")) {
            		button("h");
            	} else if (idpage.equals("walet")) {
            		button("a");
            	} else if (idpage.equals("tikus")) {
            		button("s");
            	} else if (idpage.equals("zebra")) {
            		button("r");
            	} else if (idpage.equals("gajah")) {
            		button("i");
            	}
            
            }
            
        });
		
		btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
            	if (idpage.equals("ayam")) {
                	button("y");
            	} else if (idpage.equals("merpati")) {
            		button("a");
            	} else if (idpage.equals("ular")) {
            		button("r");
            	} else if (idpage.equals("kerbau")) {
            		button("b");
            	} else if (idpage.equals("ikan")) {
            		button("n");
            	} else if (idpage.equals("elang")) {
            		button("a");
            	} else if (idpage.equals("lalat")) {
            		button("b");
            	} else if (idpage.equals("beruang")) {
            		button("e");
            	} else if (idpage.equals("panda")) {
            		button("h");
            	} else if (idpage.equals("rusa")) {
            		button("l");
            	} else if (idpage.equals("cicak")) {
            		button("i");
            	} else if (idpage.equals("domba")) {
            		button("o");
            	} else if (idpage.equals("singa")) {
            		button("o");
            	} else if (idpage.equals("nyamuk")) {
            		button("a");
            	} else if (idpage.equals("quokka")) {
            		button("n");
            	} else if (idpage.equals("harimau")) {
            		button("i");
            	} else if (idpage.equals("walet")) {
            		button("l");
            	} else if (idpage.equals("tikus")) {
            		button("u");
            	} else if (idpage.equals("zebra")) {
            		button("a");
            	} else if (idpage.equals("gajah")) {
            		button("a");
            	}
            
            }
            
        });
		
		btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
            	if (idpage.equals("ayam")) {
                	button("i");
            	} else if (idpage.equals("merpati")) {
            		button("t");
            	} else if (idpage.equals("ular")) {
            		button("a");
            	} else if (idpage.equals("kerbau")) {
            		button("e");
            	} else if (idpage.equals("ikan")) {
            		button("i");
            	} else if (idpage.equals("elang")) {
            		button("l");
            	} else if (idpage.equals("lalat")) {
            		button("c");
            	} else if (idpage.equals("beruang")) {
            		button("r");
            	} else if (idpage.equals("panda")) {
            		button("a");
            	} else if (idpage.equals("rusa")) {
            		button("r");
            	} else if (idpage.equals("cicak")) {
            		button("l");
            	} else if (idpage.equals("domba")) {
            		button("i");
            	} else if (idpage.equals("singa")) {
            		button("n");
            	} else if (idpage.equals("nyamuk")) {
            		button("z");
            	} else if (idpage.equals("quokka")) {
            		button("u");
            	} else if (idpage.equals("harimau")) {
            		button("n");
            	} else if (idpage.equals("walet")) {
            		button("e");
            	} else if (idpage.equals("tikus")) {
            		button("t");
            	} else if (idpage.equals("zebra")) {
            		button("e");
            	} else if (idpage.equals("gajah")) {
            		button("j");
            	}
            
            }
            
        });
		
		btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
            	if (idpage.equals("ayam")) {
                	button("m");
            	} else if (idpage.equals("merpati")) {
            		button("m");
            	} else if (idpage.equals("ular")) {
            		button("u");
            	} else if (idpage.equals("kerbau")) {
            		button("a");
            	} else if (idpage.equals("ikan")) {
            		button("d");
            	} else if (idpage.equals("elang")) {
            		button("e");
            	} else if (idpage.equals("lalat")) {
            		button("t");
            	} else if (idpage.equals("beruang")) {
            		button("b");
            	} else if (idpage.equals("panda")) {
            		button("p");
            	} else if (idpage.equals("rusa")) {
            		button("s");
            	} else if (idpage.equals("cicak")) {
            		button("o");
            	} else if (idpage.equals("domba")) {
            		button("r");
            	} else if (idpage.equals("singa")) {
            		button("m");
            	} else if (idpage.equals("nyamuk")) {
            		button("u");
            	} else if (idpage.equals("quokka")) {
            		button("g");
            	} else if (idpage.equals("harimau")) {
            		button("a");
            	} else if (idpage.equals("walet")) {
            		button("w");
            	} else if (idpage.equals("tikus")) {
            		button("k");
            	} else if (idpage.equals("zebra")) {
            		button("b");
            	} else if (idpage.equals("gajah")) {
            		button("o");
            	}
            
            }
            
        });
		
		btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
               hapus();
            }
            
        });
		
		btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
         	   
               	MainActivity.btn_klik.start();
            tkosong();
               tv_jwb.setText("");
            }
            
        });
		
		btnjwb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               
            	String jawaban;
            	jawaban = tv_jwb.getText().toString();
            	
            	if (idpage.equals("ayam")) {
            		
            		if (jawaban.equalsIgnoreCase("ayam"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("merpati")) {
            		
            		if (jawaban.equalsIgnoreCase("merpati"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("ular")) {
            		
            		if (jawaban.equalsIgnoreCase("ular"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("kerbau")) {
            		
            		if (jawaban.equalsIgnoreCase("kerbau"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("ikan")) {
            		
            		if (jawaban.equalsIgnoreCase("ikan"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("elang")) {
            		
            		if (jawaban.equalsIgnoreCase("elang"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("lalat")) {
            		
            		if (jawaban.equalsIgnoreCase("lalat"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("beruang")) {
            		
            		if (jawaban.equalsIgnoreCase("beruang"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("panda")) {
            		
            		if (jawaban.equalsIgnoreCase("panda"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("rusa")) {
            		
            		if (jawaban.equalsIgnoreCase("rusa"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("cicak")) {
            		
            		if (jawaban.equalsIgnoreCase("cicak"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("domba")) {
            		
            		if (jawaban.equalsIgnoreCase("domba"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("singa")) {
            		
            		if (jawaban.equalsIgnoreCase("singa"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("nyamuk")) {
            		
            		if (jawaban.equalsIgnoreCase("nyamuk"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("quokka")) {
            		
            		if (jawaban.equalsIgnoreCase("quokka"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("harimau")) {
            		
            		if (jawaban.equalsIgnoreCase("harimau"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("walet")) {
            		
            		if (jawaban.equalsIgnoreCase("walet"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("tikus")) {
            		
            		if (jawaban.equalsIgnoreCase("tikus"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("zebra")) {
            		
            		if (jawaban.equalsIgnoreCase("zebra"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	} else if (idpage.equals("gajah")) {
            		
            		if (jawaban.equalsIgnoreCase("gajah"))  {
            			 jawaban("benar");
            		} else {
            			jawaban("salah");
            		}
            		
            	}
            	
            	
            	
            
            }
            
        });
		
        
    }
    
    // end of onCreate
    
    public void page (String arg) {
    	
    	if (arg == "ayam") {
    		
    	
    	idpage = "ayam";
    	tag_soal.setText("No. 1");
    	hewan.setBackgroundResource(R.drawable.ayam);
		
		btn1.setText("A");
		btn2.setText("G");
		btn3.setText("U");
		btn4.setText("N");
		btn5.setText("Y");
		btn6.setText("I");
		btn7.setText("M");
    	
    } else if (arg == "merpati") {
    	idpage = "merpati";
    	tag_soal.setText("No. 2");
    	hewan.setBackgroundResource(R.drawable.merpati);
		
		btn1.setText("P");
		btn2.setText("R");
		btn3.setText("E");
		btn4.setText("I");
		btn5.setText("A");
		btn6.setText("T");
		btn7.setText("M");
    	
    } else if (arg == "ular") {
    	idpage = "ular";
    	tag_soal.setText("No. 3");
    	hewan.setBackgroundResource(R.drawable.ular);
		
		btn1.setText("D");
		btn2.setText("Z");
		btn3.setText("L");
		btn4.setText("N");
		btn5.setText("R");
		btn6.setText("A");
		btn7.setText("U");
    	
    } else if (arg == "kerbau") {
    	idpage = "kerbau";
    	tag_soal.setText("No. 4");
    	hewan.setBackgroundResource(R.drawable.kerbau);
		
		btn1.setText("K");
		btn2.setText("R");
		btn3.setText("U");
		btn4.setText("D");
		btn5.setText("B");
		btn6.setText("E");
		btn7.setText("A");
    	
    } else if (arg == "ikan") {
    	idpage = "ikan";
    	tag_soal.setText("No. 5");
    	hewan.setBackgroundResource(R.drawable.ikan);
		
		btn1.setText("K");
		btn2.setText("B");
		btn3.setText("X");
		btn4.setText("A");
		btn5.setText("N");
		btn6.setText("I");
		btn7.setText("D");
    	
    } else if (arg == "elang") {
    	idpage = "elang";
    	tag_soal.setText("No. 6");
    	hewan.setBackgroundResource(R.drawable.elang);
		
		btn1.setText("M");
		btn2.setText("J");
		btn3.setText("N");
		btn4.setText("G");
		btn5.setText("A");
		btn6.setText("L");
		btn7.setText("E");
    	
    } else if (arg == "lalat") {
    	idpage = "lalat";
    	tag_soal.setText("No. 7");
    	hewan.setBackgroundResource(R.drawable.lalat);
		
		btn1.setText("T");
		btn2.setText("L");
		btn3.setText("A");
		btn4.setText("Y");
		btn5.setText("B");
		btn6.setText("C");
		btn7.setText("T");
    	
    } else if (arg == "beruang") {
    	idpage = "beruang";
    	tag_soal.setText("No. 8");
    	hewan.setBackgroundResource(R.drawable.beruang);
		
		btn1.setText("G");
		btn2.setText("N");
		btn3.setText("U");
		btn4.setText("A");
		btn5.setText("E");
		btn6.setText("R");
		btn7.setText("B");
    	
    } else if (arg == "panda") {
    	idpage = "panda";
    	tag_soal.setText("No. 9");
    	hewan.setBackgroundResource(R.drawable.panda);
		
		btn1.setText("A");
		btn2.setText("S");
		btn3.setText("D");
		btn4.setText("N");
		btn5.setText("H");
		btn6.setText("A");
		btn7.setText("P");
    	
    } else if (arg == "rusa") {
    	idpage = "rusa";
    	tag_soal.setText("No. 10");
    	hewan.setBackgroundResource(R.drawable.rusa);
		
		btn1.setText("U");
		btn2.setText("P");
		btn3.setText("I");
		btn4.setText("A");
		btn5.setText("L");
		btn6.setText("R");
		btn7.setText("S");
    	
    } else if (arg == "cicak") {
    	idpage = "cicak";
    	tag_soal.setText("No. 11");
    	hewan.setBackgroundResource(R.drawable.cicak);
		
		btn1.setText("K");
		btn2.setText("A");
		btn3.setText("N");
		btn4.setText("C");
		btn5.setText("I");
		btn6.setText("L");
		btn7.setText("O");
    	
    } else if (arg == "domba") {
    	idpage = "domba";
    	tag_soal.setText("No. 12");
    	hewan.setBackgroundResource(R.drawable.domba);
		
		btn1.setText("A");
		btn2.setText("D");
		btn3.setText("B");
		btn4.setText("M");
		btn5.setText("O");
		btn6.setText("I");
		btn7.setText("R");
    	
    } else if (arg == "singa") {
    	idpage = "singa";
    	tag_soal.setText("No. 13");
    	hewan.setBackgroundResource(R.drawable.singa);
		
		btn1.setText("G");
		btn2.setText("S");
		btn3.setText("I");
		btn4.setText("A");
		btn5.setText("O");
		btn6.setText("N");
		btn7.setText("M");
    	
    } else if (arg == "nyamuk") {
    	idpage = "nyamuk";
    	tag_soal.setText("No. 14");
    	hewan.setBackgroundResource(R.drawable.nyamuk);
		
		btn1.setText("K");
		btn2.setText("N");
		btn3.setText("Y");
		btn4.setText("M");
		btn5.setText("A");
		btn6.setText("Z");
		btn7.setText("U");
    	
    } else if (arg == "quokka") {
    	idpage = "quokka";
    	tag_soal.setText("No. 15");
    	hewan.setBackgroundResource(R.drawable.quokka);
		
		btn1.setText("Q");
		btn2.setText("K");
		btn3.setText("A");
		btn4.setText("O");
		btn5.setText("N");
		btn6.setText("U");
		btn7.setText("G");
    	
    } else if (arg == "harimau") {
    	idpage = "harimau";
    	tag_soal.setText("No. 16");
    	hewan.setBackgroundResource(R.drawable.harimau);
		
		btn1.setText("U");
		btn2.setText("R");
		btn3.setText("M");
		btn4.setText("H");
		btn5.setText("I");
		btn6.setText("N");
		btn7.setText("A");
    	
    } else if (arg == "walet") {
    	idpage = "walet";
    	tag_soal.setText("No. 17");
    	hewan.setBackgroundResource(R.drawable.walet);
		
		btn1.setText("T");
		btn2.setText("W");
		btn3.setText("L");
		btn4.setText("A");
		btn5.setText("L");
		btn6.setText("E");
		btn7.setText("W");
    	
    } else if (arg == "tikus") {
    	idpage = "tikus";
    	tag_soal.setText("No. 18");
    	hewan.setBackgroundResource(R.drawable.tikus);
		
		btn1.setText("Z");
		btn2.setText("Y");
		btn3.setText("I");
		btn4.setText("S");
		btn5.setText("U");
		btn6.setText("T");
		btn7.setText("K");
    	
    } else if (arg == "zebra") {
    	idpage = "zebra";
    	tag_soal.setText("No. 19");
    	hewan.setBackgroundResource(R.drawable.zebra);
		
		btn1.setText("X");
		btn2.setText("D");
		btn3.setText("Z");
		btn4.setText("R");
		btn5.setText("A");
		btn6.setText("E");
		btn7.setText("B");
    	
    } else if (arg == "gajah") {
    	idpage = "gajah";
    	tag_soal.setText("No. 20");
    	hewan.setBackgroundResource(R.drawable.gajah);
		
		btn1.setText("H");
		btn2.setText("G");
		btn3.setText("M");
		btn4.setText("I");
		btn5.setText("A");
		btn6.setText("J");
		btn7.setText("O");
    	
    }
    	
  }
    
  //  handle jawaban
    
    public void jawaban (String arg) {
    	if (arg == "salah") {
    		suarasalah();
    		hewan.startAnimation(plat);
    	} else if (arg == "benar") {
            
    		tkosong();
    		suarabenar();
    		
    		 
    		
            if (idpage.equals("ayam")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("ayam", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
               
            } else if (idpage.equals("merpati")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("merpati", 1);
                editor.commit();
                
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
            } else if (idpage.equals("ular")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("ular", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("kerbau")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("kerbau", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("ikan")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("ikan", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("elang")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("elang", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("lalat")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("lalat", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("beruang")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("beruang", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("panda")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("panda", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("rusa")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("rusa", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("cicak")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("cicak", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("domba")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("domba", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("singa")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("singa", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("nyamuk")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("nyamuk", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("quokka")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("quokka", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("harimau")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("harimau", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("walet")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("walet", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("tikus")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("tikus", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("zebra")) {
            	
            	SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("zebra", 1);
                editor.commit();
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);

   	            	refresh();
   	            	
   	             }

   	         }, splashjwb);
   		     
            } else if (idpage.equals("gajah")) {
            	
            	 SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("gajah", 1);
                editor.commit();
                
                
                
            	
                benar.startAnimation(gone);
   		     	benar.setVisibility(View.INVISIBLE);

   		     new Handler().postDelayed(new Runnable() {

   	             @Override
   	             public void run() {

   	 		        benar.startAnimation(appear);
   			        benar.setVisibility(View.VISIBLE);



                SharedPreferences splvl = getSharedPreferences("tebak", 0);
                SharedPreferences.Editor editor = splvl.edit();
   			        String apakah = splvl.getString("apakahselesai" , "");
   			        

   			        if (!apakah.equalsIgnoreCase("benar") ) {
                      editor.putString("apakahselesai", "benar");
                      editor.commit();
   			        	   selesai();
   			        } else {

   	   	            	refresh();
   			        }
   			        
   	            	
   	             }

   	         }, splashjwb);
   		     
            }
            
            
    	}
    }
    
    
    // refresh
    
    public void refresh() {
		Intent intent = getIntent();
        finish();
        overridePendingTransition(0,0);
        startActivity(intent);
        overridePendingTransition(0,0);
	}
    
    
    
    
    
    
    
    // handle button pilihan
    
   public void button (String arg) {
	   
	   if (arg == "a") {
		   
		   if (t1.equals("")) {
       		t1 = "A";
       		tv_jwb.setText(t1);
       	
       		} else if (t2.equals("")) {
       		t2 = "A";
       		tv_jwb.setText(t1+t2);
       		
       		} else if (t3.equals("")) {
       		t3 = "A";
       		tv_jwb.setText(t1+t2+t3);
       		
       		} else if (t4.equals("")) {
       		t4 = "A";
       		tv_jwb.setText(t1+t2+t3+t4);
       		
       		}  else if (t5.equals("")) {
       		t5 = "A";
       		tv_jwb.setText(t1+t2+t3+t4+t5);
       		
       		}  else if (t6.equals("")) {
       		t6 = "A";
       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
       		
       		}  else if (t7.equals("")) {
       		t7 = "A";
       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
       		} 
		   
	   } else if (arg == "b") {
		   
		   if (t1.equals("")) {
	       		t1 = "B";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "B";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "B";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "B";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "B";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "B";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "B";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "c") {
		   if (t1.equals("")) {
	       		t1 = "C";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "C";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "C";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "C";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "C";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "C";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "C";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "d") {
		   if (t1.equals("")) {
	       		t1 = "D";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "D";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "D";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "D";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "D";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "D";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "D";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "e") {
		   if (t1.equals("")) {
	       		t1 = "E";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "E";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "E";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "E";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "E";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "E";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "E";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "f") {
		   if (t1.equals("")) {
	       		t1 = "F";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "F";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "F";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "F";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "F";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "F";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "F";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "g") {
		   if (t1.equals("")) {
	       		t1 = "G";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "G";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "G";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "G";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "G";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "G";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "G";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "h") {
		   if (t1.equals("")) {
	       		t1 = "H";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "H";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "H";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "H";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "H";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "H";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "H";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "i") {
		   if (t1.equals("")) {
	       		t1 = "I";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "I";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "I";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "I";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "I";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "I";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "I";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "j") {
		   if (t1.equals("")) {
	       		t1 = "J";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "J";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "J";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "J";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "J";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "J";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "J";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "k") {
		   if (t1.equals("")) {
	       		t1 = "K";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "K";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "K";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "K";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "K";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "K";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "K";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "l") {
		   if (t1.equals("")) {
	       		t1 = "L";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "L";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "L";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "L";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "L";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "L";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "L";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "m") {
		   if (t1.equals("")) {
	       		t1 = "M";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "M";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "M";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "M";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "M";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "M";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "M";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "n") {
		   if (t1.equals("")) {
	       		t1 = "N";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "N";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "N";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "N";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "N";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "N";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "N";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "o") {
		   if (t1.equals("")) {
	       		t1 = "O";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "O";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "O";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "O";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "O";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "O";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "O";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "p") {
		   if (t1.equals("")) {
	       		t1 = "P";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "P";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "P";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "P";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "P";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "P";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "P";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "q") {
		   if (t1.equals("")) {
	       		t1 = "Q";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "Q";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "Q";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "Q";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "Q";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "Q";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "Q";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "r") {
		   if (t1.equals("")) {
	       		t1 = "R";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "R";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "R";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "R";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "R";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "R";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "R";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "s") {
		   if (t1.equals("")) {
	       		t1 = "S";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "S";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "S";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "S";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "S";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "S";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "S";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "t") {
		   if (t1.equals("")) {
	       		t1 = "T";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "T";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "T";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "T";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "T";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "T";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "T";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "u") {
		   if (t1.equals("")) {
	       		t1 = "U";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "U";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "U";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "U";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "U";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "U";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "U";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "v") {
		   if (t1.equals("")) {
	       		t1 = "V";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "V";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "V";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "V";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "V";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "V";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "V";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "w") {
		   if (t1.equals("")) {
	       		t1 = "W";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "W";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "W";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "W";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "W";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "W";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "W";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "x") {
		   if (t1.equals("")) {
	       		t1 = "X";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "X";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "X";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "X";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "X";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "X";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "X";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "y") {
		   if (t1.equals("")) {
	       		t1 = "Y";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "Y";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "Y";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "Y";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "Y";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "Y";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "Y";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   } else if (arg == "z") {
		   if (t1.equals("")) {
	       		t1 = "Z";
	       		tv_jwb.setText(t1);
	       	
	       		} else if (t2.equals("")) {
	       		t2 = "Z";
	       		tv_jwb.setText(t1+t2);
	       		
	       		} else if (t3.equals("")) {
	       		t3 = "Z";
	       		tv_jwb.setText(t1+t2+t3);
	       		
	       		} else if (t4.equals("")) {
	       		t4 = "Z";
	       		tv_jwb.setText(t1+t2+t3+t4);
	       		
	       		}  else if (t5.equals("")) {
	       		t5 = "Z";
	       		tv_jwb.setText(t1+t2+t3+t4+t5);
	       		
	       		}  else if (t6.equals("")) {
	       		t6 = "Z";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6);
	       		
	       		}  else if (t7.equals("")) {
	       		t7 = "Z";
	       		tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
	       		} 
		   
	   }
	   
   }
   
 public void lvlbutton() {
	   
	 	if (ayam != 1) {
	 		butt("mati");
	 	} else if (merpati!=1) {
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
	   } else if (ular!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   
	   }  else if (kerbau!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   
	   }   else if (ikan!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   
	   }   else if (elang!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   
	   }   else if (lalat!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (beruang!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   
	   }   else if (panda!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   
	   }   else if (rusa!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (cicak!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (domba!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (singa!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (nyamuk!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
		   l14.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (quokka!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
		   l14.setBackgroundResource(R.drawable.btno_xml);
		   l15.setBackgroundResource(R.drawable.btno_xml);
		   
	   }   else if (harimau!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
		   l14.setBackgroundResource(R.drawable.btno_xml);
		   l15.setBackgroundResource(R.drawable.btno_xml);
		   l16.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (walet!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
		   l14.setBackgroundResource(R.drawable.btno_xml);
		   l15.setBackgroundResource(R.drawable.btno_xml);
		   l16.setBackgroundResource(R.drawable.btno_xml);
		   l17.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (tikus!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
		   l14.setBackgroundResource(R.drawable.btno_xml);
		   l15.setBackgroundResource(R.drawable.btno_xml);
		   l16.setBackgroundResource(R.drawable.btno_xml);
		   l17.setBackgroundResource(R.drawable.btno_xml);
		   l18.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (zebra!=1){
		   butt("mati");
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
		   l14.setBackgroundResource(R.drawable.btno_xml);
		   l15.setBackgroundResource(R.drawable.btno_xml);
		   l16.setBackgroundResource(R.drawable.btno_xml);
		   l17.setBackgroundResource(R.drawable.btno_xml);
		   l18.setBackgroundResource(R.drawable.btno_xml);
		   l19.setBackgroundResource(R.drawable.btno_xml);
	   }   else if (gajah!=1){
		   l2.setBackgroundResource(R.drawable.btno_xml);
		   l3.setBackgroundResource(R.drawable.btno_xml);
		   l4.setBackgroundResource(R.drawable.btno_xml);
		   l5.setBackgroundResource(R.drawable.btno_xml);
		   l6.setBackgroundResource(R.drawable.btno_xml);
		   l7.setBackgroundResource(R.drawable.btno_xml);
		   l8.setBackgroundResource(R.drawable.btno_xml);
		   l9.setBackgroundResource(R.drawable.btno_xml);
		   l10.setBackgroundResource(R.drawable.btno_xml);
		   l11.setBackgroundResource(R.drawable.btno_xml);
		   l12.setBackgroundResource(R.drawable.btno_xml);
		   l13.setBackgroundResource(R.drawable.btno_xml);
		   l14.setBackgroundResource(R.drawable.btno_xml);
		   l15.setBackgroundResource(R.drawable.btno_xml);
		   l16.setBackgroundResource(R.drawable.btno_xml);
		   l17.setBackgroundResource(R.drawable.btno_xml);
		   l18.setBackgroundResource(R.drawable.btno_xml);
		   l19.setBackgroundResource(R.drawable.btno_xml);
		   l20.setBackgroundResource(R.drawable.btno_xml);
	   }
	   
   }
   
 public void butt(String arg) {
	   if (arg == "mati") {
		   l2.setBackgroundResource(R.drawable.btno_inactive);
		   l3.setBackgroundResource(R.drawable.btno_inactive);
		   l4.setBackgroundResource(R.drawable.btno_inactive);
		   l5.setBackgroundResource(R.drawable.btno_inactive);
		   l6.setBackgroundResource(R.drawable.btno_inactive);
		   l7.setBackgroundResource(R.drawable.btno_inactive);
		   l8.setBackgroundResource(R.drawable.btno_inactive);
		   l9.setBackgroundResource(R.drawable.btno_inactive);
		   l10.setBackgroundResource(R.drawable.btno_inactive);
		   l11.setBackgroundResource(R.drawable.btno_inactive);
		   l12.setBackgroundResource(R.drawable.btno_inactive);
		   l13.setBackgroundResource(R.drawable.btno_inactive);
		   l14.setBackgroundResource(R.drawable.btno_inactive);
		   l15.setBackgroundResource(R.drawable.btno_inactive);
		   l16.setBackgroundResource(R.drawable.btno_inactive);
		   l17.setBackgroundResource(R.drawable.btno_inactive);
		   l18.setBackgroundResource(R.drawable.btno_inactive);
		   l19.setBackgroundResource(R.drawable.btno_inactive);
		   l20.setBackgroundResource(R.drawable.btno_inactive);
		   
	   } else {
		   
	   }
   }
   
   public void tkosong() {
	tv_jwb.setText("");
   	t1 = "";
   	t2 = "";
   	t3 = "";
   	t4 = "";
   	t5 = "";
   	t6 = "";
   	t7 = "";  
   }
   
   public void hapus() {
	   
	   if (!t1.equals("") && t2.equals("")) {
		   t1 = "";
		   tv_jwb.setText(t1);
		   
	   } else if (!t2.equals("") && t3.equals("")) {
		   t2 = "";
		   tv_jwb.setText(t1+t2);
		   
	   } else if (!t3.equals("") && t4.equals("")) {
		   t3 = "";
		   tv_jwb.setText(t1+t2+t3);
		   
	   } else if (!t4.equals("") && t5.equals("")) {
		   t4 = "";
		   tv_jwb.setText(t1+t2+t3+t4);
		   
	   } else if (!t5.equals("") && t6.equals("")) {
		   t5 = "";
		   tv_jwb.setText(t1+t2+t3+t4+t5);
		   
	   } else if (!t6.equals("") && t7.equals("")) {
		   t6 = "";
		   tv_jwb.setText(t1+t2+t3+t4+t5+t6);
		   
	   } else if (!t7.equals("")) {
		   t7 = "";
		   tv_jwb.setText(t1+t2+t3+t4+t5+t6+t7);
		   
	   }
   }
   
   public void suarabenar() {
		suara = MediaPlayer.create(this, R.raw.benar);
  		suara.setLooping(false);
  		suara.start();
	}
	
	public void suarasalah() {
		suara = MediaPlayer.create(this, R.raw.salah);
  		suara.setLooping(false);
  		suara.start();
	}
	
	private void updateViews() {
		
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
	
	public void selesai() {
		
		MediaPlayer suara2;
		suara2 = MediaPlayer.create(this, R.raw.applause);
  		suara2.setLooping(false);
  		suara2.start();
		
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.selesai);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        
        
        TextView tx1 = (TextView) dialog.findViewById(R.id.tx1);
        tx1.setTypeface(cell);
        tx1.setText("Yeahh.. kamu berhasil menebak semua nama hewan dengan benar.. kamu kalau sudah besar pasti jadi anak yang baik dan benar.. Amiin..");
        
        
        Button bt1 = (Button) dialog.findViewById(R.id.bt1);
        bt1.setTypeface(cell);
        
        Button bt2 = (Button) dialog.findViewById(R.id.head);
        bt2.setTypeface(cell);
        
        
        bt1.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
                dialog.dismiss();
                refresh();
            }
        });
        
        
	}
    
}