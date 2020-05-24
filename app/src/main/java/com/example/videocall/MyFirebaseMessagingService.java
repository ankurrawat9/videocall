package com.example.videocall;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String title=remoteMessage.getNotification().getTitle();
        String body=remoteMessage.getNotification().getBody();




        long[] vibrate = new long[] { 1000, 1000, 1000, 1000, 1000 };
        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(this,"TAC").setContentTitle(title).setContentText(body)
        .setSmallIcon(R.drawable.call).setVibrate(vibrate).setTimeoutAfter(20000);




       Intent intent=new Intent(this,IncomingCallActivity.class);

       PendingIntent pendingIntent= PendingIntent.getActivity(this,10,intent,PendingIntent.FLAG_CANCEL_CURRENT);
       notificationBuilder.setFullScreenIntent(pendingIntent,true);


                        notificationBuilder.setContentTitle("Initaiting video call")
                        .setContentText("click here to start")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_CALL);







        notificationBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

int id= (int)System.currentTimeMillis();

if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

}

notificationManager.notify(id,notificationBuilder.build());
        NotificationChannel channel = new NotificationChannel("TAC","demo",NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(channel);
    }
}
