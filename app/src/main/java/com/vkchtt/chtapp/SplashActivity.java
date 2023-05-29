package com.vkchtt.chtapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
 //   View mContentView;
 FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    String nam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        nam=sh.getString("name","");
       firebaseAuth=FirebaseAuth.getInstance();
       firebaseUser= firebaseAuth.getCurrentUser();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

        }

        Thread splashThread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(3000);
                   // startActivity(new Intent(SplashActivity.this, MainActivity.class));
                   // finish();
                    launchMainScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        splashThread.start();

    }
    private void launchMainScreen() {

         if(nam.equalsIgnoreCase(""))
         {
             Intent intent = new Intent(getApplicationContext(), MainAct.class);
             startActivity(intent);
             finish();
         }
         else {
             Intent intent = new Intent(getApplicationContext(), ChatAct.class);
             startActivity(intent);
             finish();
         }

       /* if(firebaseUser != null)
        {

 Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
        startActivity(intent);
        finish();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        */




      //  new Handler(Looper.getMainLooper()).postDelayed(this::finish, 2000);
    }
}
