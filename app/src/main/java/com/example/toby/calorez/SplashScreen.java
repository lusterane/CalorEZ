package com.example.toby.calorez;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = "SplashScreen";
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        public void run() {
            Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(homeIntent);
            finish();
        }
    };

    boolean delayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // hide title
        this.getSupportActionBar().hide(); // hide title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        startFadeInAnimation();
    }

    private void startFadeInAnimation(){
        ImageView imageView = findViewById(R.id.imageView);
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        imageView.startAnimation(startAnimation);
    }
    /*
        opens the main activity after a a specified time
        3000 milliseconds recommended
     */
    private boolean startDelayedActivity(){
        handler.postDelayed(runnable, 3000);
        return true;
    }
    @Override
    protected void onPause(){
        handler.removeCallbacks(runnable);
        super.onPause();
    }
    @Override
    protected void onResume(){
        // start main activity
        if(delayed) {
            Log.d(TAG, "onResume: Activity starts");
            startActivity(new Intent(this, MainActivity.class));
            super.onResume();
        }
    }
    @Override
    protected void onStart(){
        delayed = startDelayedActivity();
        super.onStart();
    }
    @Override
    protected void onDestroy(){
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }

}
