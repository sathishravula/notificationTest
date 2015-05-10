package com.javacodegeeks.android.notificationstest;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class BackGroungService extends Service {
  private SharedPreferences rules;
  private SharedPreferences.Editor rulesEditor;

  @Override
  public void onCreate() {
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d("test11", "onStartCommand:" + new Date());
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        rules = getSharedPreferences("rules", MODE_MULTI_PROCESS);
//        rulesEditor = rules.edit();
//        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
//        String json = rules.getString("rules", "");
//        ArrayList<Rule> rules1 = null;
//        if (!json.isEmpty()) {
//          rules1 = new Gson().fromJson(json, new TypeToken<ArrayList<Rule>>() {
//          }.getType());
//          ArrayList<SMS> smsList = db.getAllSMS();
//          for (SMS sms : smsList)
//            postSMS(sms, rules1);
//          stopSelf();
//        }
//      }
//    }).start();
    return Service.START_STICKY;
  }


  @Override
  public IBinder onBind(Intent arg0) {
    return null;
  }

  @Override
  public void onDestroy() {
  }

//  public void postSMS(SMS sms, ArrayList<Rule> rules1) {
//    String url = "";
//    for (Rule rule : rules1) {
//      if (sms.getMessage().contains(rule.getPattern())) {
//        url = rule.getUrl();
//        break;
//      }
//    }
//    String result;
//    try {
//      JSONObject json = new JSONObject();
//      json.put("from", sms.getFrom());
//      json.put("to", rules.getString("toNumber", "No Number"));
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
//      json.put("timestamp", sdf.format(sms.getTime_stamp()));
//      json.put("message", sms.getMessage());
//
//      HttpPost post = new HttpPost(url);
//      post.setHeader("Accept", "application/json");
//      post.setHeader("Content-Type", "application/json");
//      post.setEntity(new StringEntity(json.toString(), "UTF-8"));
//      DefaultHttpClient client = new DefaultHttpClient();
//      HttpResponse httpresponse = client.execute(post);
//
//      HttpEntity entity = httpresponse.getEntity();
//      InputStream stream = entity.getContent();
//      result = convertStreamToString(stream);
//    } catch (Exception e) {
//      result = "cancel";
//    }
//    if(result.trim().equalsIgnoreCase("ok")){
//      DatabaseHandler db = new DatabaseHandler(this);
//     db.updateStatus(sms.getId(),1);
//    }
//  }

  public String convertStreamToString(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuffer stringBuffer = new StringBuffer();
    String line = null;
    try {
      while ((line = reader.readLine()) != null) {
        stringBuffer.append(line + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return stringBuffer.toString();
    }
  }

}
