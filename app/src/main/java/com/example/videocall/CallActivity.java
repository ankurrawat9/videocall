package com.example.videocall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity implements OpenTokShared.OpenTokListener{
    private FrameLayout publisherViewContainer;
    private FrameLayout subscriberViewContainer;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        publisherViewContainer = findViewById(R.id.publisher_container);
        subscriberViewContainer = findViewById(R.id.subscriber_container);

        i1=findViewById(R.id.imageView);

        OpenTokShared.getInstance().connectToSession(this);
        OpenTokShared.getInstance().createPublisher(this, true);
        OpenTokShared.getInstance().addOpenTokListener((OpenTokShared.OpenTokListener) this);

        publisherViewContainer.addView(OpenTokShared.getInstance().getPublisherView());

        i1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View arg0) {

finish();
Toast.makeText(CallActivity.this, "Thank You for Calling", Toast.LENGTH_SHORT).show();
Intent i =new Intent(getApplicationContext(),Calling.class);
 startActivity(i);




 onBackPressed();

                                  }



                              }
        );


    }

    @Override
    public void subscriberConnected() {
        subscriberViewContainer.addView(OpenTokShared.getInstance().getSubscriberView());
    }


}
