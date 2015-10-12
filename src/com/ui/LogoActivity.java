package com.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

public class LogoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        
        //淡入淡出变化
        AlphaAnimation animation = new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(3000);//动画持续时间
        //animation.start();
        LinearLayout linView = (LinearLayout)this.findViewById(R.id.lid);
        linView.setAnimation(animation);
        //跳转到第二屏幕
        animation.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				
				Intent intent = new Intent(LogoActivity.this,LoginActivity.class);
			    startActivity(intent);
			}
		});
       
    }
}