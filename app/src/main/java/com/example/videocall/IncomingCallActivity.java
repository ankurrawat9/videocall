package com.example.videocall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IncomingCallActivity extends AppCompatActivity {
Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_call);

    b2= findViewById(R.id.button3);


        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View arg0) {

                                      finish();
                                      System.exit(0);

                                  }
                              }
                           );

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);


    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    public void answerCall(View view) {
        Intent callActivity = new Intent(this, CallActivity.class);
        startActivity(callActivity);
    }
}
