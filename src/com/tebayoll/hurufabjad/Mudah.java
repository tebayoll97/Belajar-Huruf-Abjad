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
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.widget.*;
import android.view.*;
import android.widget.Button;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;

public class Mudah extends Activity {


    static int splashjwb = 1500;
    MediaPlayer suara, tune;
	
    
    
    public Animation gone, appear, plat;
    public Typeface cell;
    int x1=0, x2=0;
    
	int progressStatus = 0;
	int id = 0;
	int gp = 0, gm;
	Button lvl1, lvl2, lvl3;
	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, tag_soal, TAG_KIRI, TAG_TENGAH;
	Button mulailagi;
	ImageView abjad, benar;
	RelativeLayout rlabjad, rl;
	TextView tv_tips, tv_progress;
	ProgressBar prolvl1;
	Dialog myDialog;
	
	
	
	String tip_lvl1, tip_lvl2, tip_lvl3,
		   tip_lvl1_selesai, tip_lvl2_selesai, tip_lvl3_selesai;
	
	// sharedPreference
	
	int idlvl1_1, idlvl1_2, idlvl1_3, idlvl1_4, idlvl1_5, idlvl1_6, idlvl1_7, idlvl1_8, idlvl1_9, idlvl1_10,
		idlvl2_1, idlvl2_2, idlvl2_3, idlvl2_4, idlvl2_5, idlvl2_6, idlvl2_7, idlvl2_8,
		idlvl3_1, idlvl3_2, idlvl3_3, idlvl3_4, idlvl3_5, idlvl3_6;
	
			
	// end sharedPreference
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mudah);
		
		
		tune = MediaPlayer.create(this, R.raw.mudah_tune);
		tune.setLooping(false);
		
       
		   // anim koin
			Button btn_coin = (Button) findViewById(R.id.coin);
	        
			
		
    		AnimationDrawable coin;
	        btn_coin.setBackgroundResource(R.drawable.coin);
	        coin = (AnimationDrawable) btn_coin.getBackground();
	        coin.start();
		
		myDialog = new Dialog(this);
		
		tip_lvl1 = "Cocokkan huruf dari gambar di samping dengan huruf yang di bawahnya !";
		tip_lvl2 = "Yang manakah huruf kecil dari huruf besar di samping ?";
		tip_lvl3 = "Manakah huruf kecil yg benar dari gambar huruf besar di samping ?";
		
		tip_lvl1_selesai = "Yeayy.. Tantangan pertama telah selesai, silahkan lanjutkan tantangan berikutnya";
		tip_lvl2_selesai = "Yeayy.. Tantangan kedua telah selesai, silahkan lanjutkan tantangan berikutnya";
		tip_lvl3_selesai = "Yeayy.. Kamu telah menyelesaikan semua tantangan. Klik tombol Reset untuk mengulang kembali";
		
		
        
     // Animation
		
		gone = AnimationUtils.loadAnimation(this, R.anim.goneleft);
		appear = AnimationUtils.loadAnimation(this, R.anim.appearleft);
		plat = AnimationUtils.loadAnimation(this, R.anim.plat);

		rlabjad = (RelativeLayout) findViewById (R.id.rlabjad);
		benar = (ImageView) findViewById (R.id.benar);
		rl = (RelativeLayout) findViewById (R.id.rlmudah);
		
		lvl1 = (Button) findViewById (R.id.lvl1);
		lvl2 = (Button) findViewById (R.id.lvl2);
		lvl3 = (Button) findViewById (R.id.lvl3);
		

		abjad = (ImageView) findViewById (R.id.abjad);
		tag_soal = (Button) findViewById (R.id.tag_soal);
		TAG_KIRI = (Button) findViewById (R.id.tag_kiri);
		TAG_TENGAH = (Button) findViewById (R.id.tag_tengah);
		
		
		
		// button jawab
		btn1 = (Button) findViewById (R.id.btn1);
		btn2 = (Button) findViewById (R.id.btn2);
		btn3 = (Button) findViewById (R.id.btn3);
		btn4 = (Button) findViewById (R.id.btn4);
		btn5 = (Button) findViewById (R.id.btn5);
		btn6 = (Button) findViewById (R.id.btn6);
		btn7 = (Button) findViewById (R.id.btn7);
		btn8 = (Button) findViewById (R.id.btn8);
		

		mulailagi = (Button) findViewById (R.id.mulailagi);
		
		prolvl1 = (ProgressBar) findViewById (R.id.prolvl1);
		tv_tips = (TextView) findViewById (R.id.tv_tips);
		tv_progress = (TextView) findViewById (R.id.tv_progress);
		
		// Font
		
		  cell = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
   
		 	btn1.setTypeface(cell);
	        btn2.setTypeface(cell);
	        btn3.setTypeface(cell);
	        btn4.setTypeface(cell);
	        btn5.setTypeface(cell);
	        btn6.setTypeface(cell);
	        btn7.setTypeface(cell);
	        btn8.setTypeface(cell);
	        

	        tv_tips.setTypeface(cell);
	        tv_progress.setTypeface(cell);
	        

	        mulailagi.setTypeface(cell);
	        lvl1.setTypeface(cell);
	        lvl2.setTypeface(cell);
	        lvl3.setTypeface(cell);
	        

	        tag_soal.setTypeface(cell);
	        TAG_KIRI.setTypeface(cell);
	        TAG_TENGAH.setTypeface(cell);
		
		
		SharedPreferences splvl = getSharedPreferences("status", 0);
        
		
        
	     // Retrive data id layout lvl1
			
        idlvl1_1  = splvl.getInt("idlvl1_1" , 0);
        idlvl1_2  = splvl.getInt("idlvl1_2" , 0);
        idlvl1_3  = splvl.getInt("idlvl1_3" , 0);
        idlvl1_4  = splvl.getInt("idlvl1_4" , 0);
        idlvl1_5  = splvl.getInt("idlvl1_5" , 0);
        idlvl1_6  = splvl.getInt("idlvl1_6" , 0);
        idlvl1_7  = splvl.getInt("idlvl1_7" , 0);
        idlvl1_8  = splvl.getInt("idlvl1_8" , 0);
        idlvl1_9  = splvl.getInt("idlvl1_9" , 0);
        idlvl1_10  = splvl.getInt("idlvl1_10" , 0);
        
        idlvl2_1  = splvl.getInt("idlvl2_1" , 0);
        idlvl2_2  = splvl.getInt("idlvl2_2" , 0);
        idlvl2_3  = splvl.getInt("idlvl2_3" , 0);
        idlvl2_4  = splvl.getInt("idlvl2_4" , 0);
        idlvl2_5  = splvl.getInt("idlvl2_5" , 0);
        idlvl2_6  = splvl.getInt("idlvl2_6" , 0);
        idlvl2_7  = splvl.getInt("idlvl2_7" , 0);
        idlvl2_8  = splvl.getInt("idlvl2_8" , 0);
        
        idlvl3_1  = splvl.getInt("idlvl3_1" , 0);
        idlvl3_2  = splvl.getInt("idlvl3_2" , 0);
        idlvl3_3  = splvl.getInt("idlvl3_3" , 0);
        idlvl3_4  = splvl.getInt("idlvl3_4" , 0);
        idlvl3_5  = splvl.getInt("idlvl3_5" , 0);
        idlvl3_6  = splvl.getInt("idlvl3_6" , 0);
        
        
        // page kiri
        
        if (idlvl1_10 != 1) {
        	lvl2.setBackgroundResource(R.drawable.btn_b);
        } else {
        	lvl2.setBackgroundResource(R.drawable.btnp_xml);
        }
        
        
        if (idlvl2_8 != 1) {
        	lvl3.setBackgroundResource(R.drawable.btn_b);
        }  else {
        	lvl3.setBackgroundResource(R.drawable.btnp_xml);
        }
        
        if (idlvl3_6 == 1) {
        	mulailagi.setVisibility(View.VISIBLE);
        } else {
        	mulailagi.setVisibility(View.INVISIBLE);
        }
        
        // page kanan
		
        if (idlvl1_1 != 1) {
        	layout_lvl("lvl1s1");
        	progress("lvl1s1");
        } else if (idlvl1_2 != 1) {
        	layout_lvl("lvl1s2");
        	progress("lvl1s2");
        } else if (idlvl1_3 != 1) {
        	layout_lvl("lvl1s3");
        	progress("lvl1s3");
        } else if (idlvl1_4 != 1) {
        	layout_lvl("lvl1s4");
        	progress("lvl1s4");
        } else if (idlvl1_5 != 1) {
        	layout_lvl("lvl1s5");
        	progress("lvl1s5");
        } else if (idlvl1_6 != 1) {
        	layout_lvl("lvl1s6");
        	progress("lvl1s6");
        } else if (idlvl1_7 != 1) {
        	layout_lvl("lvl1s7");
        	progress("lvl1s7");
        } else if (idlvl1_8 != 1) {
        	layout_lvl("lvl1s8");
        	progress("lvl1s8");
        } else if (idlvl1_9 != 1) {
        	layout_lvl("lvl1s9");
        	progress("lvl1s9");
        } else if (idlvl1_10 != 1) {
        	layout_lvl("lvl1s10");
        	progress("lvl1s10");
        } else if (idlvl1_10 == 1 && x1 == 0 && idlvl2_1 == 0) {
        	layout_lvl("lvl1_selesai");
        	progress("lvl1_selesai");
        	
        	
        } else if (idlvl2_1 != 1) {
        	layout_lvl("lvl2s1");
        	progress("lvl2s1");
        } else if (idlvl2_2 != 1) {
        	layout_lvl("lvl2s2");
        	progress("lvl2s2");
        } else if (idlvl2_3 != 1) {
        	layout_lvl("lvl2s3");
        	progress("lvl2s3");
        } else if (idlvl2_4 != 1) {
        	layout_lvl("lvl2s4");
        	progress("lvl2s4");
        } else if (idlvl2_5 != 1) {
        	layout_lvl("lvl2s5");
        	progress("lvl2s5");
        } else if (idlvl2_6 != 1) {
        	layout_lvl("lvl2s6");
        	progress("lvl2s6");
        } else if (idlvl2_7 != 1) {
        	layout_lvl("lvl2s7");
        	progress("lvl2s7");
        } else if (idlvl2_8 != 1) {
        	layout_lvl("lvl2s8");
        	progress("lvl2s8");
        } else if (idlvl2_8 == 1 && x2 == 0 && idlvl3_1 == 0) {
        	layout_lvl("lvl2_selesai");
        	progress("lvl2_selesai");
        	
        	
        } else if (idlvl3_1 != 1) {
        	layout_lvl("lvl3s1");
        	progress("lvl3s1");
        } else if (idlvl3_2 != 1) {
        	layout_lvl("lvl3s2");
        	progress("lvl3s2");
        } else if (idlvl3_3 != 1) {
        	layout_lvl("lvl3s3");
        	progress("lvl3s3");
        } else if (idlvl3_4 != 1) {
        	layout_lvl("lvl3s4");
        	progress("lvl3s4");
        } else if (idlvl3_5 != 1) {
        	layout_lvl("lvl3s5");
        	progress("lvl3s5");
        } else if (idlvl3_6 != 1) {
        	layout_lvl("lvl3s6");
        	progress("lvl3s6");
        }  else if (idlvl3_6== 1) {
        	layout_lvl("lvl3_selesai");
        	progress("lvl3_selesai");
        }	
		
        
        mulailagi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	
            	
            	Button ya, tidak;
                
                myDialog.setContentView(R.layout.reset);
                

                ya = (Button) myDialog.findViewById(R.id.ya);
                tidak = (Button) myDialog.findViewById(R.id.tidak);
                
                ya.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    	
                    	SharedPreferences splvl = getSharedPreferences("status", 0);
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
        
        
		lvl1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	            	
	            	 if (idlvl1_1 != 1) {
	                 	layout_lvl("lvl1s1");
	                 	progress("lvl1s1");
	                 } else if (idlvl1_2 != 1) {
	                 	layout_lvl("lvl1s2");
	                 	progress("lvl1s2");
	                 } else if (idlvl1_3 != 1) {
	                 	layout_lvl("lvl1s3");
	                 	progress("lvl1s3");
	                 } else if (idlvl1_4 != 1) {
	                 	layout_lvl("lvl1s4");
	                 	progress("lvl1s4");
	                 } else if (idlvl1_5 != 1) {
	                 	layout_lvl("lvl1s5");
	                 	progress("lvl1s5");
	                 } else if (idlvl1_6 != 1) {
	                 	layout_lvl("lvl1s6");
	                 	progress("lvl1s6");
	                 } else if (idlvl1_7 != 1) {
	                 	layout_lvl("lvl1s7");
	                 	progress("lvl1s7");
	                 } else if (idlvl1_8 != 1) {
	                 	layout_lvl("lvl1s8");
	                 	progress("lvl1s8");
	                 } else if (idlvl1_9 != 1) {
	                 	layout_lvl("lvl1s9");
	                 	progress("lvl1s9");
	                 } else if (idlvl1_10 != 1) {
	                 	layout_lvl("lvl1s10");
	                 	progress("lvl1s10");
	                 } else if (idlvl1_10 == 1) {
	                 	layout_lvl("lvl1_selesai");
	                 	progress("lvl1_selesai");
	                 	
	                 	
	                 	
	                 }
	         		
	            	
	            }
	        });
		 
		lvl2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0) {
	               
	            	x1=1;
	            	
	            	  if (idlvl1_10 != 1) {
	                  	lvl2.setBackgroundResource(R.drawable.btn_b);
	                    Toast.makeText(getApplicationContext(),"Belum Terbuka !",Toast.LENGTH_SHORT).show();
	                  } else {
	                  	lvl2.setBackgroundResource(R.drawable.btnp_xml);
	                  	
	                  	 if (idlvl2_1 != 1) {
	 	                 	layout_lvl("lvl2s1");
	 	                 	progress("lvl2s1");
	 	                 } else if (idlvl2_2 != 1) {
	 	                 	layout_lvl("lvl2s2");
	 	                 	progress("lvl2s2");
	 	                 } else if (idlvl2_3 != 1) {
	 	                 	layout_lvl("lvl2s3");
	 	                 	progress("lvl2s3");
	 	                 } else if (idlvl2_4 != 1) {
	 	                 	layout_lvl("lvl2s4");
	 	                 	progress("lvl2s4");
	 	                 } else if (idlvl2_5 != 1) {
	 	                 	layout_lvl("lvl2s5");
	 	                 	progress("lvl2s5");
	 	                 } else if (idlvl2_6 != 1) {
	 	                 	layout_lvl("lvl2s6");
	 	                 	progress("lvl2s6");
	 	                 } else if (idlvl2_7 != 1) {
	 	                 	layout_lvl("lvl2s7");
	 	                 	progress("lvl2s7");
	 	                 } else if (idlvl2_8 != 1) {
	 	                 	layout_lvl("lvl2s8");
	 	                 	progress("lvl2s8");
	 	                 } else if (idlvl2_8 == 1) {
	 		                 	layout_lvl("lvl2_selesai");
	 		                 	progress("lvl2_selesai");
	 		                 }
	 	            
	                  	
	                  }
	                  
	                  
	                  
	            	
	            	
	            }
	        });
		
		lvl3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               
            	x2=1;
            	
                  if (idlvl2_8 != 1) {
                  	lvl3.setBackgroundResource(R.drawable.btn_b);
                    Toast.makeText(getApplicationContext(),"Belum Terbuka !",Toast.LENGTH_SHORT).show();
                  }  else {
                  	lvl3.setBackgroundResource(R.drawable.btnp_xml);
                  	
                  	if (idlvl3_1 != 1) {
                    	layout_lvl("lvl3s1");
                    	progress("lvl3s1");
                    } else if (idlvl3_2 != 1) {
                    	layout_lvl("lvl3s2");
                    	progress("lvl3s2");
                    } else if (idlvl3_3 != 1) {
                    	layout_lvl("lvl3s3");
                    	progress("lvl3s3");
                    } else if (idlvl3_4 != 1) {
                    	layout_lvl("lvl3s4");
                    	progress("lvl3s4");
                    } else if (idlvl3_5 != 1) {
                    	layout_lvl("lvl3s5");
                    	progress("lvl3s5");
                    } else if (idlvl3_6 != 1) {
                    	layout_lvl("lvl3s6");
                    	progress("lvl3s6");
                    }  else if (idlvl3_6 == 1) {
                     	layout_lvl("lvl3_selesai");
                     	progress("lvl3_selesai");
                     }
                  	
                  }
            	
            	
            	
            }
        });
		
		// button abjad
		
		btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               
            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("salah");
                } else if (idlvl1_2 != 1) {
                	jawaban("salah");
                } else if (idlvl1_3 != 1) {
                	jawaban("salah");
                } else if (idlvl1_4 != 1) {
                	jawaban("salah");
                } else if (idlvl1_5 != 1) {
                	jawaban("salah");
                } else if (idlvl1_6 != 1) {
                	jawaban("benar");
                } else if (idlvl1_7 != 1) {
                	jawaban("benar");
                } else if (idlvl1_8 != 1) {
                	jawaban("salah");
                } else if (idlvl1_9 != 1) {
                	jawaban("salah");
                } else if (idlvl1_10 != 1) {
                	jawaban("benar");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("salah");
                } else if (idlvl2_2 != 1) {
                	jawaban("salah");
                } else if (idlvl2_3 != 1) {
                	jawaban("salah");
                } else if (idlvl2_4 != 1) {
                	jawaban("salah");
                } else if (idlvl2_5 != 1) {
                	jawaban("benar");
                } else if (idlvl2_6 != 1) {
                	jawaban("salah");
                } else if (idlvl2_7 != 1) {
                	jawaban("salah");
                } else if (idlvl2_8 != 1) {
                	jawaban("salah");
                	
                	
                }  else if (idlvl3_1 != 1) {
                	jawaban("salah");
                } else if (idlvl3_2 != 1) {
                	jawaban("salah");
                } else if (idlvl3_3 != 1) {
                	jawaban("benar");
                } else if (idlvl3_4 != 1) {
                	jawaban("salah");
                } else if (idlvl3_5 != 1) {
                	jawaban("benar");
                } else if (idlvl3_6 != 1) {
                	jawaban("salah");
                }
            	
            	
            }
        });
		
		btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               

            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("salah");
                } else if (idlvl1_2 != 1) {
                	jawaban("salah");
                } else if (idlvl1_3 != 1) {
                	jawaban("salah");
                } else if (idlvl1_4 != 1) {
                	jawaban("salah");
                } else if (idlvl1_5 != 1) {
                	jawaban("salah");
                } else if (idlvl1_6 != 1) {
                	jawaban("salah");
                } else if (idlvl1_7 != 1) {
                	jawaban("salah");
                } else if (idlvl1_8 != 1) {
                	jawaban("salah");
                } else if (idlvl1_9 != 1) {
                	jawaban("salah");
                } else if (idlvl1_10 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("salah");
                } else if (idlvl2_2 != 1) {
                	jawaban("salah");
                } else if (idlvl2_3 != 1) {
                	jawaban("salah");
                } else if (idlvl2_4 != 1) {
                	jawaban("salah");
                } else if (idlvl2_5 != 1) {
                	jawaban("salah");
                } else if (idlvl2_6 != 1) {
                	jawaban("benar");
                } else if (idlvl2_7 != 1) {
                	jawaban("salah");
                } else if (idlvl2_8 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl3_1 != 1) {
                	jawaban("salah");
                } else if (idlvl3_2 != 1) {
                	jawaban("salah");
                } else if (idlvl3_3 != 1) {
                	jawaban("salah");
                } else if (idlvl3_4 != 1) {
                	jawaban("salah");
                } else if (idlvl3_5 != 1) {
                	jawaban("salah");
                } else if (idlvl3_6 != 1) {
                	jawaban("salah");
                }
            	
            }
        });
		
		btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("salah");
                } else if (idlvl1_2 != 1) {
                	jawaban("salah");
                } else if (idlvl1_3 != 1) {
                	jawaban("benar");
                } else if (idlvl1_4 != 1) {
                	jawaban("salah");
                } else if (idlvl1_5 != 1) {
                	jawaban("salah");
                } else if (idlvl1_6 != 1) {
                	jawaban("salah");
                } else if (idlvl1_7 != 1) {
                	jawaban("salah");
                } else if (idlvl1_8 != 1) {
                	jawaban("salah");
                } else if (idlvl1_9 != 1) {
                	jawaban("salah");
                } else if (idlvl1_10 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("salah");
                } else if (idlvl2_2 != 1) {
                	jawaban("salah");
                } else if (idlvl2_3 != 1) {
                	jawaban("salah");
                } else if (idlvl2_4 != 1) {
                	jawaban("salah");
                } else if (idlvl2_5 != 1) {
                	jawaban("salah");
                } else if (idlvl2_6 != 1) {
                	jawaban("salah");
                } else if (idlvl2_7 != 1) {
                	jawaban("salah");
                } else if (idlvl2_8 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl3_1 != 1) {
                	jawaban("benar");
                } else if (idlvl3_2 != 1) {
                	jawaban("salah");
                } else if (idlvl3_3 != 1) {
                	jawaban("salah");
                } else if (idlvl3_4 != 1) {
                	jawaban("salah");
                } else if (idlvl3_5 != 1) {
                	jawaban("salah");
                } else if (idlvl3_6 != 1) {
                	jawaban("salah");
                }
            }
        });
		
		btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               
            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("salah");
                } else if (idlvl1_2 != 1) {
                	jawaban("salah");
                } else if (idlvl1_3 != 1) {
                	jawaban("salah");
                } else if (idlvl1_4 != 1) {
                	jawaban("salah");
                } else if (idlvl1_5 != 1) {
                	jawaban("salah");
                } else if (idlvl1_6 != 1) {
                	jawaban("salah");
                } else if (idlvl1_7 != 1) {
                	jawaban("salah");
                } else if (idlvl1_8 != 1) {
                	jawaban("salah");
                } else if (idlvl1_9 != 1) {
                	jawaban("salah");
                } else if (idlvl1_10 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("salah");
                } else if (idlvl2_2 != 1) {
                	jawaban("salah");
                } else if (idlvl2_3 != 1) {
                	jawaban("salah");
                } else if (idlvl2_4 != 1) {
                	jawaban("benar");
                } else if (idlvl2_5 != 1) {
                	jawaban("salah");
                } else if (idlvl2_6 != 1) {
                	jawaban("salah");
                } else if (idlvl2_7 != 1) {
                	jawaban("salah");
                } else if (idlvl2_8 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl3_1 != 1) {
                	jawaban("salah");
                } else if (idlvl3_2 != 1) {
                	jawaban("salah");
                } else if (idlvl3_3 != 1) {
                	jawaban("salah");
                } else if (idlvl3_4 != 1) {
                	jawaban("salah");
                } else if (idlvl3_5 != 1) {
                	jawaban("salah");
                } else if (idlvl3_6 != 1) {
                	jawaban("salah");
                }
            	
            }
        });
		
		btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               

            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("salah");
                } else if (idlvl1_2 != 1) {
                	jawaban("salah");
                } else if (idlvl1_3 != 1) {
                	jawaban("salah");
                } else if (idlvl1_4 != 1) {
                	jawaban("salah");
                } else if (idlvl1_5 != 1) {
                	jawaban("benar");
                } else if (idlvl1_6 != 1) {
                	jawaban("salah");
                } else if (idlvl1_7 != 1) {
                	jawaban("salah");
                } else if (idlvl1_8 != 1) {
                	jawaban("benar");
                } else if (idlvl1_9 != 1) {
                	jawaban("salah");
                } else if (idlvl1_10 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("benar");
                } else if (idlvl2_2 != 1) {
                	jawaban("salah");
                } else if (idlvl2_3 != 1) {
                	jawaban("salah");
                } else if (idlvl2_4 != 1) {
                	jawaban("salah");
                } else if (idlvl2_5 != 1) {
                	jawaban("salah");
                } else if (idlvl2_6 != 1) {
                	jawaban("salah");
                } else if (idlvl2_7 != 1) {
                	jawaban("salah");
                } else if (idlvl2_8 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl3_1 != 1) {
                	jawaban("salah");
                } else if (idlvl3_2 != 1) {
                	jawaban("benar");
                } else if (idlvl3_3 != 1) {
                	jawaban("salah");
                } else if (idlvl3_4 != 1) {
                	jawaban("benar");
                } else if (idlvl3_5 != 1) {
                	jawaban("salah");
                } else if (idlvl3_6 != 1) {
                	jawaban("salah");
                }
            	
            }
        });
		
		btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("salah");
                } else if (idlvl1_2 != 1) {
                	jawaban("benar");
                } else if (idlvl1_3 != 1) {
                	jawaban("salah");
                } else if (idlvl1_4 != 1) {
                	jawaban("salah");
                } else if (idlvl1_5 != 1) {
                	jawaban("salah");
                } else if (idlvl1_6 != 1) {
                	jawaban("salah");
                } else if (idlvl1_7 != 1) {
                	jawaban("salah");
                } else if (idlvl1_8 != 1) {
                	jawaban("salah");
                } else if (idlvl1_9 != 1) {
                	jawaban("benar");
                } else if (idlvl1_10 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("salah");
                } else if (idlvl2_2 != 1) {
                	jawaban("salah");
                } else if (idlvl2_3 != 1) {
                	jawaban("benar");
                } else if (idlvl2_4 != 1) {
                	jawaban("salah");
                } else if (idlvl2_5 != 1) {
                	jawaban("salah");
                } else if (idlvl2_6 != 1) {
                	jawaban("salah");
                } else if (idlvl2_7 != 1) {
                	jawaban("salah");
                } else if (idlvl2_8 != 1) {
                	jawaban("benar");
                	
                	
                } else if (idlvl3_1 != 1) {
                	jawaban("salah");
                } else if (idlvl3_2 != 1) {
                	jawaban("salah");
                } else if (idlvl3_3 != 1) {
                	jawaban("salah");
                } else if (idlvl3_4 != 1) {
                	jawaban("salah");
                } else if (idlvl3_5 != 1) {
                	jawaban("salah");
                } else if (idlvl3_6 != 1) {
                	jawaban("salah");
                }
            	
            }
        });
		
		btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("benar");
                } else if (idlvl1_2 != 1) {
                	jawaban("salah");
                } else if (idlvl1_3 != 1) {
                	jawaban("salah");
                } else if (idlvl1_4 != 1) {
                	jawaban("salah");
                } else if (idlvl1_5 != 1) {
                	jawaban("salah");
                } else if (idlvl1_6 != 1) {
                	jawaban("salah");
                } else if (idlvl1_7 != 1) {
                	jawaban("salah");
                } else if (idlvl1_8 != 1) {
                	jawaban("salah");
                } else if (idlvl1_9 != 1) {
                	jawaban("salah");
                } else if (idlvl1_10 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("salah");
                } else if (idlvl2_2 != 1) {
                	jawaban("salah");
                } else if (idlvl2_3 != 1) {
                	jawaban("salah");
                } else if (idlvl2_4 != 1) {
                	jawaban("salah");
                } else if (idlvl2_5 != 1) {
                	jawaban("salah");
                } else if (idlvl2_6 != 1) {
                	jawaban("salah");
                } else if (idlvl2_7 != 1) {
                	jawaban("benar");
                } else if (idlvl2_8 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl3_1 != 1) {
                	jawaban("salah");
                } else if (idlvl3_2 != 1) {
                	jawaban("salah");
                } else if (idlvl3_3 != 1) {
                	jawaban("salah");
                } else if (idlvl3_4 != 1) {
                	jawaban("salah");
                } else if (idlvl3_5 != 1) {
                	jawaban("salah");
                } else if (idlvl3_6 != 1) {
                	jawaban("benar");
                }
            	
            	
            }
        });
		
		btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               

            	MainActivity.btn_klik.start();
            	
            	if (idlvl1_1 != 1) {
                	jawaban("salah");
                } else if (idlvl1_2 != 1) {
                	jawaban("salah");
                } else if (idlvl1_3 != 1) {
                	jawaban("salah");
                } else if (idlvl1_4 != 1) {
                	jawaban("benar");
                } else if (idlvl1_5 != 1) {
                	jawaban("salah");
                } else if (idlvl1_6 != 1) {
                	jawaban("salah");
                } else if (idlvl1_7 != 1) {
                	jawaban("salah");
                } else if (idlvl1_8 != 1) {
                	jawaban("salah");
                } else if (idlvl1_9 != 1) {
                	jawaban("salah");
                } else if (idlvl1_10 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl2_1 != 1) {
                	jawaban("salah");
                } else if (idlvl2_2 != 1) {
                	jawaban("benar");
                } else if (idlvl2_3 != 1) {
                	jawaban("salah");
                } else if (idlvl2_4 != 1) {
                	jawaban("salah");
                } else if (idlvl2_5 != 1) {
                	jawaban("salah");
                } else if (idlvl2_6 != 1) {
                	jawaban("salah");
                } else if (idlvl2_7 != 1) {
                	jawaban("salah");
                } else if (idlvl2_8 != 1) {
                	jawaban("salah");
                	
                	
                } else if (idlvl3_1 != 1) {
                	jawaban("salah");
                } else if (idlvl3_2 != 1) {
                	jawaban("salah");
                } else if (idlvl3_3 != 1) {
                	jawaban("salah");
                } else if (idlvl3_4 != 1) {
                	jawaban("salah");
                } else if (idlvl3_5 != 1) {
                	jawaban("salah");
                } else if (idlvl3_6 != 1) {
                	jawaban("salah");
                }
            	
            }
        });
		
		
		
		
		
            	
            	
            	
         
		
		
		
		
	}
	
	// Method level dan soal
	
	public void layout_lvl (String arg) {
		
		if (arg == "lvl1s1") {
			
			
			
			abjad.setBackgroundResource(R.drawable.hc);
			button("ada");
			tv_tips.setText(tip_lvl1);
			tag_soal.setText("No. 1");

			
			btn1.setText("J");
			btn2.setText("B");
			btn3.setText("A");
			btn4.setText("D");
			btn5.setText("G");
			btn6.setText("B");
			btn7.setText("C");
			btn8.setText("F");
			
		} else if (arg == "lvl1s2") {
			
			abjad.setBackgroundResource(R.drawable.hj);
			button("ada");
			tv_tips.setText(tip_lvl1);
			tag_soal.setText("No. 2");
			
			btn1.setText("D");
			btn2.setText("G");
			btn3.setText("A");
			btn4.setText("B");
			btn5.setText("C");
			btn6.setText("J");
			btn7.setText("M");
			btn8.setText("U");
			
		} else if (arg == "lvl1s3") {
			
			tag_soal.setText("No. 3");
			
			abjad.setBackgroundResource(R.drawable.ha);
			button("ada");
			tv_tips.setText(tip_lvl1);
			
			btn1.setText("M");
			btn2.setText("G");
			btn3.setText("A");
			btn4.setText("T");
			btn5.setText("C");
			btn6.setText("N");
			btn7.setText("D");
			btn8.setText("K");
			
		} else if (arg == "lvl1s4") {
			
			tag_soal.setText("No. 4");
			
			abjad.setBackgroundResource(R.drawable.hb);
			button("ada");
			tv_tips.setText(tip_lvl1);
			
			btn1.setText("A");
			btn2.setText("G");
			btn3.setText("F");
			btn4.setText("E");
			btn5.setText("D");
			btn6.setText("O");
			btn7.setText("N");
			btn8.setText("B");
			
		} else if (arg == "lvl1s5") {
			
			tag_soal.setText("No. 5");
			
			abjad.setBackgroundResource(R.drawable.hf);
			button("ada");
			tv_tips.setText(tip_lvl1);
			
			btn1.setText("E");
			btn2.setText("A");
			btn3.setText("B");
			btn4.setText("O");
			btn5.setText("F");
			btn6.setText("G");
			btn7.setText("A");
			btn8.setText("N");
			
		} else if (arg == "lvl1s6") {
			
			tag_soal.setText("No. 6");
			
			abjad.setBackgroundResource(R.drawable.hd);
			button("ada");
			tv_tips.setText(tip_lvl1);
			
			btn1.setText("D");
			btn2.setText("I");
			btn3.setText("M");
			btn4.setText("A");
			btn5.setText("R");
			btn6.setText("A");
			btn7.setText("H");
			btn8.setText("I");
			
		} else if (arg == "lvl1s7") {
			
			tag_soal.setText("No. 7");
			
			abjad.setBackgroundResource(R.drawable.hi);
			tv_tips.setText(tip_lvl1);
			button("ada");
			
			btn1.setText("I");
			btn2.setText("B");
			btn3.setText("U");
			btn4.setText("M");
			btn5.setText("R");
			btn6.setText("T");
			btn7.setText("U");
			btn8.setText("A");
			
		} else if (arg == "lvl1s8") {
			
			tag_soal.setText("No. 8");
			
			abjad.setBackgroundResource(R.drawable.hk);
			tv_tips.setText(tip_lvl1);
			button("ada");
			
			btn1.setText("S");
			btn2.setText("M");
			btn3.setText("P");
			btn4.setText("E");
			btn5.setText("K");
			btn6.setText("E");
			btn7.setText("O");
			btn8.setText("X");
			
		} else if (arg == "lvl1s9") {
			
			tag_soal.setText("No. 9");
			
			abjad.setBackgroundResource(R.drawable.ht);
			button("ada");
			tv_tips.setText(tip_lvl1);
			
			btn1.setText("B");
			btn2.setText("E");
			btn3.setText("N");
			btn4.setText("J");
			btn5.setText("U");
			btn6.setText("T");
			btn7.setText("G");
			btn8.setText("W");
			
		} else if (arg == "lvl1s10") {
			
			tag_soal.setText("No. 10");
			
			abjad.setBackgroundResource(R.drawable.he);
			button("ada");
			tv_tips.setText(tip_lvl1);
			
			btn1.setText("E");
			btn2.setText("D");
			btn3.setText("A");
			btn4.setText("N");
			btn5.setText("P");
			btn6.setText("I");
			btn7.setText("S");
			btn8.setText("N");
			
		} else if (arg == "lvl1_selesai") {
			
			tag_soal.setText("Selesai");
			
			abjad.setBackgroundResource(R.drawable.selesai);
			tv_tips.setText(tip_lvl1_selesai);
			button("hilang");
			
		}  else if (arg == "lvl2s1") {
			
			tag_soal.setText("No. 1");
			
			abjad.setBackgroundResource(R.drawable.hg);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("a");
			btn2.setText("b");
			btn3.setText("a");
			btn4.setText("h");
			btn5.setText("g");
			btn6.setText("a");
			btn7.setText("u");
			btn8.setText("l");
			
		}  else if (arg == "lvl2s2") {
			
			tag_soal.setText("No. 2");
			
			abjad.setBackgroundResource(R.drawable.he);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("s");
			btn2.setText("a");
			btn3.setText("m");
			btn4.setText("p");
			btn5.setText("a");
			btn6.setText("n");
			btn7.setText("y");
			btn8.setText("e");
			
		}  else if (arg == "lvl2s3") {
			
			tag_soal.setText("No. 3");
			
			abjad.setBackgroundResource(R.drawable.hn);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("p");
			btn2.setText("a");
			btn3.setText("h");
			btn4.setText("t");
			btn5.setText("o");
			btn6.setText("n");
			btn7.setText("g");
			btn8.setText("a");
			
		}  else if (arg == "lvl2s4") {
			
			tag_soal.setText("No. 4");
			
			abjad.setBackgroundResource(R.drawable.hj);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("p");
			btn2.setText("a");
			btn3.setText("n");
			btn4.setText("j");
			btn5.setText("u");
			btn6.setText("l");
			btn7.setText("x");
			btn8.setText("d");
			
		}  else if (arg == "lvl2s5") {
			
			tag_soal.setText("No. 5");
			
			abjad.setBackgroundResource(R.drawable.hi);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("i");
			btn2.setText("k");
			btn3.setText("a");
			btn4.setText("n");
			btn5.setText("p");
			btn6.setText("a");
			btn7.setText("r");
			btn8.setText("e");
			
		}  else if (arg == "lvl2s6") {
			
			tag_soal.setText("No. 6");
			
			abjad.setBackgroundResource(R.drawable.ha);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("g");
			btn2.setText("a");
			btn3.setText("r");
			btn4.setText("i");
			btn5.setText("t");
			btn6.setText("e");
			btn7.setText("l");
			btn8.setText("u");
			
		}  else if (arg == "lvl2s7") {
			
			tag_soal.setText("No. 7");
			
			abjad.setBackgroundResource(R.drawable.hh);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("w");
			btn2.setText("a");
			btn3.setText("r");
			btn4.setText("e");
			btn5.setText("g");
			btn6.setText("e");
			btn7.setText("h");
			btn8.setText("i");
			
		}  else if (arg == "lvl2s8") {
			
			tag_soal.setText("No. 8");
			
			abjad.setBackgroundResource(R.drawable.hx);
			button("ada");
			tv_tips.setText(tip_lvl2);
			
			btn1.setText("f");
			btn2.setText("o");
			btn3.setText("r");
			btn4.setText("c");
			btn5.setText("e");
			btn6.setText("x");
			btn7.setText("m");
			btn8.setText("n");
			
		} else if (arg == "lvl2_selesai") {
			
			tag_soal.setText("Selesai");
			
			abjad.setBackgroundResource(R.drawable.selesai);
			button("hilang");
			tv_tips.setText(tip_lvl2_selesai);
			
			btn1.setText("S");
			btn2.setText("E");
			btn3.setText("L");
			btn4.setText("A");
			btn5.setText("M");
			btn6.setText("A");
			btn7.setText("T");
			btn8.setText("T");
			
		}  else if (arg == "lvl3s1") {
			
			tag_soal.setText("No. 1");
			
			abjad.setBackgroundResource(R.drawable.hs);
			button("ada");
			tv_tips.setText(tip_lvl3);
			
			btn1.setText("D");
			btn2.setText("r");
			btn3.setText("s");
			btn4.setText("Z");
			btn5.setText("R");
			btn6.setText("a");
			btn7.setText("n");
			btn8.setText("E");
			
		}  else if (arg == "lvl3s2") {
			
			tag_soal.setText("No. 2");
			
			abjad.setBackgroundResource(R.drawable.hz);
			button("ada");
			tv_tips.setText(tip_lvl3);
			
			btn1.setText("n");
			btn2.setText("O");
			btn3.setText("p");
			btn4.setText("r");
			btn5.setText("z");
			btn6.setText("M");
			btn7.setText("o");
			btn8.setText("E");
			
		}  else if (arg == "lvl3s3") {
			
			tag_soal.setText("No. 3");
			
			abjad.setBackgroundResource(R.drawable.hq);
			button("ada");
			tv_tips.setText(tip_lvl3);
			
			btn1.setText("q");
			btn2.setText("Y");
			btn3.setText("a");
			btn4.setText("g");
			btn5.setText("T");
			btn6.setText("s");
			btn7.setText("Q");
			btn8.setText("t");
			
		}  else if (arg == "lvl3s4") {
			
			tag_soal.setText("No. 4");
			
			abjad.setBackgroundResource(R.drawable.hr);
			button("ada");
			tv_tips.setText(tip_lvl3);
			
			btn1.setText("B");
			btn2.setText("A");
			btn3.setText("k");
			btn4.setText("e");
			btn5.setText("r");
			btn6.setText("I");
			btn7.setText("o");
			btn8.setText("R");
			
		}  else if (arg == "lvl3s5") {
			
			tag_soal.setText("No. 5");
			
			abjad.setBackgroundResource(R.drawable.hv);
			button("ada");
			tv_tips.setText(tip_lvl3);
			
			btn1.setText("v");
			btn2.setText("o");
			btn3.setText("R");
			btn4.setText("m");
			btn5.setText("I");
			btn6.setText("r");
			btn7.setText("T");
			btn8.setText("S");
			
		}  else if (arg == "lvl3s6") {
			
			tag_soal.setText("No. 6");
			
			abjad.setBackgroundResource(R.drawable.ho);
			button("ada");
			tv_tips.setText(tip_lvl3);
			
			btn1.setText("r");
			btn2.setText("A");
			btn3.setText("G");
			btn4.setText("n");
			btn5.setText("a");
			btn6.setText("R");
			btn7.setText("o");
			btn8.setText("X");
			
		} else if (arg == "lvl3_selesai") {
			
			tag_soal.setText("Selesai");
			
			abjad.setBackgroundResource(R.drawable.selesai);
			button("hilang");
			tv_tips.setText(tip_lvl3_selesai);
			
			btn1.setText("S");
			btn2.setText("E");
			btn3.setText("L");
			btn4.setText("A");
			btn5.setText("M");
			btn6.setText("A");
			btn7.setText("T");
			btn8.setText("T");
			
		} 
		
	}
	
	
public void progress (String arg) {
		
		if (arg == "lvl1s1") {
			
			tv_progress.setText("0/10");
			prolvl1.setProgress(0);
			
		} else if (arg == "lvl1s2") {
			
			tv_progress.setText("1/10");
			prolvl1.setProgress(10);
			
		} else if (arg == "lvl1s3") {
			
			tv_progress.setText("2/10");
			prolvl1.setProgress(20);
			
		} else if (arg == "lvl1s4") {
			
			tv_progress.setText("3/10");
			prolvl1.setProgress(30);
			
		} else if (arg == "lvl1s5") {
			
			tv_progress.setText("4/10");
			prolvl1.setProgress(40);
			
		} else if (arg == "lvl1s6") {
			
			tv_progress.setText("5/10");
			prolvl1.setProgress(50);
			
		} else if (arg == "lvl1s7") {
			
			tv_progress.setText("6/10");
			prolvl1.setProgress(60);
			
		} else if (arg == "lvl1s8") {
			
			tv_progress.setText("7/10");
			prolvl1.setProgress(70);
			
		} else if (arg == "lvl1s9") {
			
			tv_progress.setText("8/10");
			prolvl1.setProgress(80);
			
		} else if (arg == "lvl1s10") {
			
			tv_progress.setText("9/10");
			prolvl1.setProgress(90);
			
		} else if (arg == "lvl1_selesai") {
			
			tv_progress.setText("10/10");
			prolvl1.setProgress(100);
			
		} else if (arg == "lvl2s1") {
			
			tv_progress.setText("0/8");
			prolvl1.setProgress(0);
			
		} else if (arg == "lvl2s2") {
			
			tv_progress.setText("1/8");
			prolvl1.setProgress(12);
			
		} else if (arg == "lvl2s3") {
			
			tv_progress.setText("2/8");
			prolvl1.setProgress(25);
			
		} else if (arg == "lvl2s4") {
			
			tv_progress.setText("3/8");
			prolvl1.setProgress(37);
			
		} else if (arg == "lvl2s5") {
			
			tv_progress.setText("4/8");
			prolvl1.setProgress(50);
			
		} else if (arg == "lvl2s6") {
			
			tv_progress.setText("5/8");
			prolvl1.setProgress(62);
			
		} else if (arg == "lvl2s7") {
			
			tv_progress.setText("6/8");
			prolvl1.setProgress(75);
			
		} else if (arg == "lvl2s8") {
			
			tv_progress.setText("7/8");
			prolvl1.setProgress(87);
			
		} else if (arg == "lvl2_selesai") {
			
			tv_progress.setText("8/8");
			prolvl1.setProgress(100);
			
		} else if (arg == "lvl3s1") {
			
			tv_progress.setText("0/6");
			prolvl1.setProgress(0);
			
		} else if (arg == "lvl3s2") {
			
			tv_progress.setText("1/6");
			prolvl1.setProgress(16);
			
		} else if (arg == "lvl3s3") {
			
			tv_progress.setText("2/6");
			prolvl1.setProgress(32);
			
		} else if (arg == "lvl3s4") {
			
			tv_progress.setText("3/6");
			prolvl1.setProgress(48);
			
		} else if (arg == "lvl3s5") {
			
			tv_progress.setText("4/6");
			prolvl1.setProgress(66);
			
		} else if (arg == "lvl3s6") {
			
			tv_progress.setText("5/6");
			prolvl1.setProgress(82);
			
		} else if (arg == "lvl3_selesai") {
			
			tv_progress.setText("6/6");
			prolvl1.setProgress(100);
			
		} 
		
	}

// penanganan benar atau salah

	public void jawaban (String arg) {
		
		// jika benar
		
		if (arg == "benar") {
		
			
			if (idlvl1_1 != 1) {
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_1", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s2");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	refresh(); 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	
		            	
		             }

		         }, splashjwb);
		        
		        
	        } else if (idlvl1_2 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_2", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s3");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {


		            	refresh();
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
		            	
		             }

		             
		         }, splashjwb);
	        	
	        } else if (idlvl1_3 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_3", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s4");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {


				        refresh();
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl1_4 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_4", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s5");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		            
		         }, splashjwb);
	        	
	        } else if (idlvl1_5 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_5", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s6");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		            
		         }, splashjwb);
	        	
	        } else if (idlvl1_6 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_6", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s7");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl1_7 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_7", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s8");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl1_8 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_8", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s9");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl1_9 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_9", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl1s10");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl1_10 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl1_10", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("selesai");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
				        tune.start();
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl2_1 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_1", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2s2");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		            
		         }, splashjwb);
	        	
	        } else if (idlvl2_2 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_2", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2s3");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl2_3 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_3", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2s4");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl2_4 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_4", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2s5");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl2_5 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_5", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2s6");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		            
		         }, splashjwb);
	        	
	        } else if (idlvl2_6 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_6", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2s7");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl2_7 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_7", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2s8");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        } else if (idlvl2_8 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl2_8", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl2_selesai");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 tune.start();
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        }  else if (idlvl3_1 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl3_1", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl3s2");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        }   else if (idlvl3_2 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl3_2", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl3s3");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        }  else if (idlvl3_3 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl3_3", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl3s4");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        }  else if (idlvl3_4 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl3_4", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl3s5");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        }  else if (idlvl3_5 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl3_5", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl3s6");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
			        	refresh();
		            	
		             }

		         }, splashjwb);
	        	
	        }  else if (idlvl3_6 != 1) {
	        	
           	 	SharedPreferences splvl = getSharedPreferences("status", 0);
                SharedPreferences.Editor editor = splvl.edit();
                editor.putInt("idlvl3_6", 1);
                editor.commit();
				
				suarabenar();
		        benar.startAnimation(gone);
		        benar.setVisibility(View.INVISIBLE);

	        	progress("lvl3_selesai");
		        new Handler().postDelayed(new Runnable() {

		             @Override
		             public void run() {

		            	 tune.start();
		 		        benar.startAnimation(appear);
				        benar.setVisibility(View.VISIBLE);
				        
				        SharedPreferences splvl = getSharedPreferences("status", 0);
                        SharedPreferences.Editor editor = splvl.edit();
                        String apakah = splvl.getString("apakahselesai" , "");
                    

                    if (!apakah.equalsIgnoreCase("benar") && idlvl3_6 != 1) {
                      editor.putString("apakahselesai", "benar");
                      editor.commit();
                           selesai();
                    } else {

                        refresh();
                    }
				        
		            	
		             }

		         }, splashjwb);
	        	
	        }
			
			
			
			
	        
	     
			
		// jika salah	
			
		} else if (arg == "salah") {
			
		        rlabjad.startAnimation(plat);
		        suarasalah();
		      
		}
		
	}
	

	
	 public void refresh() {
			Intent intent = getIntent();
	        finish();
	        overridePendingTransition(0,0);
	        startActivity(intent);
	        overridePendingTransition(0,0);
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

	public void button (String arg) {
		
		if (arg == "ada") {
			btn1.setVisibility(View.VISIBLE);
			btn2.setVisibility(View.VISIBLE);
			btn3.setVisibility(View.VISIBLE);
			btn4.setVisibility(View.VISIBLE);
			btn5.setVisibility(View.VISIBLE);
			btn6.setVisibility(View.VISIBLE);
			btn7.setVisibility(View.VISIBLE);
			btn8.setVisibility(View.VISIBLE);
		} else if (arg == "hilang") {
			btn1.setVisibility(View.INVISIBLE);
			btn2.setVisibility(View.INVISIBLE);
			btn3.setVisibility(View.INVISIBLE);
			btn4.setVisibility(View.INVISIBLE);
			btn5.setVisibility(View.INVISIBLE);
			btn6.setVisibility(View.INVISIBLE);
			btn7.setVisibility(View.INVISIBLE);
			btn8.setVisibility(View.INVISIBLE);
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
        tx1.setText("Yeahh.. kamu berhasil mencocokkan huruf abjad dengan baik danbenar.. pasti kalau kamu sudah besar, kamu akan jadi anak yang baik dan benar.. Amiin..");
        
        
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
