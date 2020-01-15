package com.tebayoll.hurufabjad;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Coba extends Activity  {
    public int counter = 10;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);
        
        button = (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);
        
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(11000, 1000){
                    public void onTick(long millisUntilFinished){
                        textView.setText(String.valueOf(counter));
                        counter--;
                        if (counter < 3 ) {
                        	textView.setTextColor(Color.RED);
                        }
                    }
                    public  void onFinish(){
                       textView.setText("FINISH!!");
                       Intent goo = new Intent(getApplicationContext(), MainActivity.class);
                       startActivity(goo);
                    }
                }.start();
            }
        });
    }
}