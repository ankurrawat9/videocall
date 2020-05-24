package com.example.videocall;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Calling extends AppCompatActivity {
Button i2;

    private static final String TAG = CallActivity.class.getSimpleName();
    private static final int PERMISSION_REQUEST_CODE = 1000;
private RequestQueue mRequestQue;
    private String URL="https://fcm.googleapis.com/fcm/send";
    CallReceiverService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

    mRequestQue= Volley.newRequestQueue(this);
        FirebaseMessaging.getInstance().subscribeToTopic("news");



    i2=findViewById(R.id.button2);





        i2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View arg0) {

                                                sendNotification();


                                  }
                              }
        );

















 }
















    private  void sendNotification(){

        JSONObject mainObj=new JSONObject();
        try {

            mainObj.put("to","/topics/"+"news");
            JSONObject notificationObj = new JSONObject();
            notificationObj.put("Connecting calls","Establishing Connecetions");
            notificationObj.put("click here to join ","the call ");



            mainObj.put("notification",notificationObj);




            JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, URL, mainObj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {




                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("MUR", "onError: "+error.networkResponse);
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header= new HashMap<>();
                    header.put("content-type","application/json");
                    header.put("authorization","key=AAAAWI7yGDk:APA91bGnVJk_2RkmVzOrU-VvrkDVnH6dBjQj8mEeSwHuTE6qNX5yXccPFrm5O1V2-GUn5ee6n5EqQCdt6pBnuhp64yBADOyQHLIQ2rphhjeXA8VEfZZwCMBW8yCagHDchIy0hLy_Utvw");
                    return  header;
                }
            };


            mRequestQue.add(request);

        }catch (JSONException e){
            e.printStackTrace();
        }

    }






}









