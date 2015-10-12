package com.ui;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class HomeActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        ImageView advert = (ImageView)this.findViewById(R.id.advert);
        final AnimationDrawable dance = (AnimationDrawable)advert.getBackground();
        
        advert.post(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				dance.start();
				
			}
		});
	}
}
