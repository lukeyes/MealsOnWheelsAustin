
package com.mowaa.mealsonwheels.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.mowaa.mealsonwheels.AppConfig;
import com.mowaa.mealsonwheels.R;
import com.mowaa.mealsonwheels.utils.RobotoTypeface;

public class SplashActivity extends Activity {

    private Context mContext = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = SplashActivity.this;
        setContentView(R.layout.splash_screen);
        TextView tv = (TextView) findViewById(R.id.tv_meals);
        RobotoTypeface.setBlackTypeface(mContext, tv);
        switchToMain();
    }

    private void switchToMain() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(mContext, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                SplashActivity.this.finish();
            }
        }, AppConfig.SPLASHSCREENDELAY);
    }
}
