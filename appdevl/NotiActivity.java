package net.daum.android.map.openapi.sampleapp;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
/*
 * 알림창을 클릭하면 실행되는 액티비티 
 */
public class NotiActivity extends Activity{
 //알림 매니저 객체
 NotificationManager notiManager;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  //화면 구성하기
  setContentView(R.layout.main);
  //알림 매니저 객체 얻어오기
  notiManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
  //알림 제거하기
  notiManager.cancel(MainActivity.MyNoti);
 }
 //버튼을 눌렀을때 액티비티 종료하기 위해
 public void push(View v){
  finish();
 }
 
}