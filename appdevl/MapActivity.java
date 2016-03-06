package net.daum.android.map.openapi.sampleapp;

import android.app.Activity;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;









public class DaumMapSampleActivity extends Activity 
implements MapView.OpenAPIKeyAuthenticationResultListener, MapView.MapViewEventListener, MapView.CurrentLocationEventListener, MapView.POIItemEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener {
	
	private static final int MENU_MAP_TYPE = Menu.FIRST + 1;
	private static final int MENU_MAP_MOVE = Menu.FIRST + 2;
	private static final int MENU_LOCATION_TRACKING = Menu.FIRST + 3;
	private static final int MENU_MAP_OVERLAY = Menu.FIRST + 4;
	
	private static final String LOG_TAG = "DaumMapLibrarySample";
	
	private MapView mapView;
	private MapPOIItem poiItem;
	private MapReverseGeoCoder reverseGeoCoder = null;
	
    //위도 경도 계산을 위한 임시 변수
    double k;
	double k2;
	
	String num;
	String hour;
	String min;
	double sum;
	double speed = 6;
	double ti;
	
    
    // 도착시간 예측을 위한 변수
	double finmin ;
    double finhour ;	
   
	
	////////////////////////알림창 이용하는 변수
	//알림 메니저 객체
	 NotificationManager notiManager;
	 //진동을 줘보자 진동객체
	 Vibrator vibrator;
	 //알림 식별값
	 final static int MyNoti=0;
	 
	 
	 
	 
	 //////////////////////////////// 도로네트워크 구축을 위한 좌표 설정
    
	 
	 
	
	

	 double disa1=37.44916116140092;
	 double disb1=126.66433369773401;
	 double disa2 = 37.44916116140092;
	 double disb2 = 126.66433369773401;
	 double disa3 = 37.44852116357945;
	 double disb3 = 126.66423484690428;
	 double disa4 = 37.447920891591885;
	 double disb4 = 126.66543544283323;
	 double disa5 = 37.447014203863205;
	 double disb5 = 126.66661477734647;
	 double disa6 = 37.44617445608496;
	 double disb6 = 126.66597435775505;
	 double disa7 = 37.44662217288238;
	 double disb7 = 126.66498919138512;
	 double disa8 = 37.44575551473811;
	 double disb8 = 126.66439411648484;
	 double disa9 = 37.44534352276897;
	 double disb9 = 126.66526610907968;
	 double disa10 = 37.444485747604425;
	 double disb10 = 126.66462579914898;
	 double disa11 = 37.44469195075936;
	 double disb11 = 126.66426326014635;
	 double disa12 = 37.44554767510742;
	 double disb12 = 126.66418033137569;
	 double disa13 = 37.44626628829096;
	 double disb13 = 126.66340866375662;
	 double disa14 = 37.44520149919954;
	 double disb14 = 126.662848401043;
	 double disa15 = 37.444745111477786;
	 double disb15 = 126.66394660610547;
	 double disa16 = 37.44387867322;
	 double disb16 = 126.66343066017333;
	 double disa17 = 37.44492521748764;
	 double disb17 = 126.66075902691743;
	 double disa18 = 37.44578275430717;
	 double disb18 = 126.66130889145964;
	 double disa19 = 37.44638217179703;
	 double disb19 = 126.65982578000665;
	 double disa20 = 37.44702272596568;
	 double disb20 = 126.66011670389098;
	 double disa21 = 37.44708641312328;
	 double disb21 = 126.66033113363468;
	 double disa22 = 37.44761082662793;
	 double disb22 = 126.66034006368181;
	 double disa23 = 37.44842286110906;
	 double disb23 = 126.66073193226748;
	 double disa24 = 37.44804861762151;
	 double disb24 = 126.66219146234243;
	 double disa25 = 37.449527997552686;
	 double disb25 = 126.66279508067211;
	 double disa26 = 37.450820806416424;
	 double disb26 = 126.6580426465678;
	 double disa27 = 37.448906431475194;
	 double disb27 = 126.65658220308816;
	 double disa28 = 37.44791319572104;
	 double disb28 = 126.65895996678;
	 double disa29 = 37.44721802396067;
	 double disb29 = 126.65847718121083;
	 double disa30 = 37.44766528482385;
	 double disb30 = 126.65735634639081;
	 double disa31 = 37.445638399271374;
	 double disb31 = 126.65748989812573;
	 double disa32 = 37.446881805834316;
	 double disb32 = 126.65439908172268;
	 double disa33 = 37.44915667281064;
	 double disb33 = 126.65588038162238;
	 double disa34 = 37.450080250519825;
	 double disb34 = 126.65373566782756;
	 double disa35 = 37.45023911633297;
	 double disb35 = 126.65414178639521;
	 double disa36 = 37.44968868369573;
	 double disb36 = 126.65540441886355;
	 double disa37 = 37.45103845543203;
	 double disb37 = 126.65635320663335;
	 double disa38 = 37.45142175166536;
	 double disb38 = 126.65493310347312;
	 double disa39 = 37.451581221743496;
	 double disb39 = 126.65400563851605;
	 double disa40 = 37.452078010836416;
	 double disb40 = 126.65289013387144;
	 double disa41 = 37.45201377863869;
	 double disb41 = 126.65249487191974;
	 double disa42 = 37.45106578606284;
	 double disb42 = 126.65183811760454;
	 double disa43 = 37.45037655265713;
	 double disb43 = 126.65338395761191;
	 double disa44 = 37.450178449266055;
	 double disb44 = 126.65342442659766;
	 double disa45 = 37.45041070155096;
	 double disb45 = 126.65273961807563;
	 double disa46 = 37.448772148965396;
	 double disb46 = 126.65164532621537;
	 double disa47 = 37.448239397642226;
	 double disb47 = 126.65278355823182;
	 double disa48 = 37.44768210630025;
	 double disb48 = 126.65323817497878;
	 double disa49 = 37.447433851075694;
	 double disb49 = 126.65307545647044;


		
double sum1;


/////////////////////////////////팝업창





/////////////////////////////////위치 정보 제공 팝업창
	
    /** Called when the activity is first created. */
	
	@Override
	public void onCurrentLocationUpdate(MapView mapView, MapPoint currentLocation, float accuracyInMeters) {
		MapPoint.GeoCoordinate mapPointGeo = currentLocation.getMapPointGeoCoord(); 
		Log.i(LOG_TAG, String.format("MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)", mapPointGeo.latitude, mapPointGeo.longitude, accuracyInMeters));
        
		double k = mapPointGeo.latitude;
		double k2 = mapPointGeo.longitude;
	}
	
	
	
	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        setTitle("현재 택배기사 위치");
        
        ///////////////////////
        //알림 메니저 객체 얻어오기
        notiManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        //진동 객체 생성
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
       ///////////////////////////////////
        
        
        
        
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        
        TextView textView = new TextView(this);
        textView.setText("택배도착 시간과 택배기사 개인정보");
        textView.setTextSize(18.0f);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.DKGRAY);
        textView.setTextColor(Color.WHITE);
        
        linearLayout.addView(textView);
        
        MapView.setMapTilePersistentCacheEnabled(true);
        
        mapView = new MapView(this);

        mapView.setDaumMapApiKey("f96866017a0770749566e1beac079e725ce7bed9");
        mapView.setOpenAPIKeyAuthenticationResultListener(this);
        mapView.setMapViewEventListener(this);
        mapView.setPOIItemEventListener(this);
        mapView.setMapType(MapView.MapType.Standard);
        
        
        
        
        
        
        poiItem = new MapPOIItem();
		poiItem.setItemName("우리집");
		poiItem.setMapPoint(MapPoint.mapPointWithGeoCoord(disa49,disb49));
		////////한라 아파트 위치
		poiItem.setMarkerType(MapPOIItem.MarkerType.RedPin);
		poiItem.setShowAnimationType(MapPOIItem.ShowAnimationType.DropFromHeaven);
		mapView.addPOIItem(poiItem);
		mapView.fitMapViewAreaToShowAllPOIItems();
		
		
		
		
		
		
		/////////////////////////이동경로
		/** 택배기사 경로 표시하기 **/
		MapPolyline existingPolyline = mapView.findPolylineByTag(1000);
		
		if (existingPolyline != null) {
			mapView.removePolyline(existingPolyline);
		}
		
		
		
		
		MapPolyline polyline1 = new MapPolyline();
		polyline1.setTag(1000);
		polyline1.setLineColor(Color.argb(128, 255, 51, 0));						
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa1,disb1));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa2,disb2));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa3,disb3));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa4,disb4));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa5,disb5));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa6,disb6));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa7,disb7));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa8,disb8));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa9,disb9));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa10,disb10));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa11,disb11));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa12,disb12));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa13,disb13));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa14,disb14));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa15,disb15));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa16,disb16));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa17,disb17));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa18,disb18));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa19,disb19));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa20,disb20));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa21,disb21));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa22,disb22));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa23,disb23));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa24,disb24));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa25,disb25));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa26,disb26));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa27,disb27));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa28,disb28));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa29,disb29));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa30,disb30));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa31,disb31));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa32,disb32));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa33,disb33));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa34,disb34));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa35,disb35));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa36,disb36));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa37,disb37));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa38,disb38));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa39,disb39));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa40,disb40));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa41,disb41));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa42,disb42));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa43,disb43));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa44,disb44));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa45,disb45));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa46,disb46));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa47,disb47));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa48,disb48));
		polyline1.addPoint(MapPoint.mapPointWithGeoCoord(disa49,disb49));
		mapView.addPolyline(polyline1);									
		mapView.fitMapViewAreaToShowPolyline(polyline1);
		

        
        linearLayout.addView(mapView);
        
        setContentView(linearLayout);
        
        startLocationService();
    	/** 경로 표시 끝내기**/
        
    }
    	
	
    public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_LOCATION_TRACKING, Menu.NONE, "택배기사위치");
		menu.add(0, MENU_MAP_MOVE, Menu.NONE, "사원정보");
		
		
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item)
    {

		final int itemId = item.getItemId();
		
		switch (itemId)
		
		{
		
		case MENU_MAP_MOVE:
			
	    {
	    /*
	    	Toast awesomeToast= Toast.makeText(this,"이순동       " +
	    			"전화번호 : 010-2559-3178",Toast.LENGTH_SHORT);
	    	LinearLayout ll=(LinearLayout)awesomeToast.getView();
	    	TextView tv = (TextView) ll.getChildAt(0);
	    	ll.removeAllViews();
	    	
	    	ImageView android = new ImageView(this);
	    	android.setImageResource(R.drawable.go);
	    	ll.addView(android);
	    	ll.addView(tv);
	    	
	    	
	    	awesomeToast.show();
	    	*/
	    	
	    	
	    	
	    	
	    	
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			
			
			
			alertDialog.setIcon(R.drawable.go);
			alertDialog.setTitle(" ");
			
			
			alertDialog.setMessage(String.format("이름 : 이순동                                     " +
					"                           전화번호 : 010-2559-3178"));
			alertDialog.setPositiveButton("확인", null);
			alertDialog.show();
			
			
			//alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
			
		}
	    return true;
		
		case MENU_LOCATION_TRACKING:
		{
			//Builder dialog = new AlertDialog.Builder(this);
		
			//dialog.setTitle("Location Tracking");
			
			mapView.setCurrentLocationEventListener(this);
			
			
			
			
			mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
							
			/////////////////////////////////////////////////////////////도착예정시간		   
			
			
			double total1 = Cale(disa1,disb1,disa2,disb2);
			double total2 = Cale(disa2,disb2,disa3,disb3);
			double total3 = Cale(disa3,disb3,disa4,disb4);
			double total4 = Cale(disa4,disb4,disa5,disb5);
			double total5 = Cale(disa5,disb5,disa6,disb6);
			double total6 = Cale(disa6,disb6,disa7,disb7);
			double total7 = Cale(disa7,disb7,disa8,disb8);
			double total8 = Cale(disa8,disb8,disa9,disb9);
			double total9 = Cale(disa9,disb9,disa10,disb10);
			double total10 = Cale(disa10,disb10,disa11,disb11);
			double total11 = Cale(disa12,disb12,disa13,disb13);
			double total12 = Cale(disa13,disb13,disa14,disb14);
			double total13 = Cale(disa14,disb14,disa15,disb15);
			double total14 = Cale(disa15,disb15,disa16,disb16);
			double total15 = Cale(disa16,disb16,disa17,disb17);
			double total16 = Cale(disa17,disb17,disa18,disb18);
			double total17 = Cale(disa18,disb18,disa19,disb19);
			double total18 = Cale(disa19,disb19,disa20,disb20);
			double total19 = Cale(disa20,disb20,disa21,disb21);
			double total20 = Cale(disa21,disb21,disa22,disb22);
			double total21 = Cale(disa22,disb22,disa23,disb23);
			double total22 = Cale(disa23,disb23,disa24,disb24);
			double total23 = Cale(disa24,disb24,disa25,disb25);
			double total24 = Cale(disa25,disb25,disa26,disb26);
			double total25 = Cale(disa26,disb26,disa27,disb27);
			double total26 = Cale(disa27,disb27,disa28,disb28);
			double total27 = Cale(disa28,disb28,disa29,disb29);
			double total28 = Cale(disa29,disb29,disa30,disb30);
			double total29 = Cale(disa30,disb30,disa31,disb31);
			double total30 = Cale(disa31,disb31,disa32,disb32);
			double total31 = Cale(disa32,disb32,disa33,disb33);
			double total32 = Cale(disa33,disb33,disa34,disb34);
			double total33 = Cale(disa34,disb34,disa35,disb35);
			double total34 = Cale(disa35,disb35,disa36,disb36);
			double total35 = Cale(disa36,disb36,disa37,disb37);
			double total36 = Cale(disa37,disb37,disa38,disb38);
			double total37 = Cale(disa38,disb38,disa39,disb39);
			double total38 = Cale(disa39,disb39,disa40,disb40);
			double total39 = Cale(disa40,disb40,disa41,disb41);
			double total40 = Cale(disa41,disb41,disa42,disb42);
			double total41 = Cale(disa42,disb42,disa43,disb43);
			double total42 = Cale(disa43,disb43,disa44,disb44);
			double total43 = Cale(disa44,disb44,disa45,disb45);
			double total44 = Cale(disa45,disb45,disa46,disb46);
			double total45 = Cale(disa46,disb46,disa47,disb47);
			double total46 = Cale(disa47,disb47,disa48,disb48);
			double total47 = Cale(disa48,disb48,disa49,disb49);
			
			
		if (k>37.42016116140092 && k2>126.67588038162238)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40+total41+total42+total43+total44+total45+total46;
 			
 		}
 		if (k>37.41316112 && k2>126.614880382)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40+total41+total42+total43+total44+total45;
 			
 		}if (k>37.42016123 && k2>126.614880381)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40+total41+total42+total43+total44;
 			
 		}if (k>37.4201611632 && k2>126.675891)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40+total41+total42+total43;
 			
 		}if (k>37.420161126 && k2>126.67563)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40+total41+total42;
 			
 		}if (k>37.420161243 && k2>126.6758812)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40+total41;
 			
 		}if (k>37.4201611876 && k2>126.6758843)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40;
 			
 		}if (k>37.4201213 && k2>126.6758143)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39;
 			
 		}
 		if (k>37.42016194 && k2>126.675880143)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38;
 		}
 		if (k>37.42124 && k2>126.675893)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37;
 		}if (k>37.42016205 && k2>126.67588113)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36;
 		}
 		if (k>37.4201732 && k2>126.6758945)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35;
 		}if (k>37.421432 && k2>126.6758613)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34;
 		}
 		if (k>37.421443 && k2>126.6758642)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33;
 		}
 		if (k>37.421498 && k2>126.6758685)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32;
 		}
 		if (k>37.421324 && k2>126.675432)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31;
 		}
 		if (k>37.4214465 && k2>126.6758234)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30;
 		}
 		if (k>37.421487 && k2>126.6758108)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29;
 		}
 		if (k>37.421474 && k2>126.6758108)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28;
 		}
 		if (k>37.421474 && k2>126.6756123)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27;
 		}
 		if (k>37.421309 && k2>126.6756123)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26;
 		}
 		if (k>37.421002 && k2>126.6756123)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25;
 		}
 		if (k>37.421002 && k2>126.6751109)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24;
 		}
 		if (k>37.4214778 && k2>126.6751109)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23;
 		}
 		if (k>37.4214778 && k2>126.679889)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22;
 		}
 		if (k>37.420991 && k2>126.679889)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21;
 		}
 		if (k>37.420991 && k2>126.675228)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20;
 		}
 		if (k>37.42981 && k2>126.675228)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19;
					
 		}
 		if (k>37.42981 && k2>126.675287)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18;
 		}
 		if (k>37.42981 && k2>126.675118)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17;
 		}
 		if (k>37.421345 && k2>126.675118)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16;
 		}
 		if (k>37.421345 && k2>126.6750892)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15;
 		}
 		if (k>37.421814 && k2>126.6750892)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14;
 		}
 		if (k>37.421814 && k2>126.674001)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13;
 		}
 		if (k>37.421485 && k2>126.674001)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12;
 		}
 		if (k>37.421485 && k2>126.674156)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11;
 		}
 		if (k>37.421587 && k2>126.674156)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10;
 		}
 		if (k>37.421587 && k2>126.674491)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9;
 		}
 		if (k>37.421901 && k2>126.674491)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7+total8;
 		}
 		if (k>37.421901 && k2>126.67891)
 		{
 			sum = total1+total2+total3+total4+total5+total6+total7;
 		}
 		if (k>37.421409 && k2>126.67891)
 		{
 			sum = total1+total2+total3+total4+total5+total6;
 		}
 		if (k>37.421409 && k2>126.67799)
 		{
 			sum = total1+total2+total3+total4+total5;
 		}
 		if (k>37.421315 && k2>126.67799)
 		{
 			sum = total1+total2+total3+total4;
 		}
 		if (k>37.421315 && k2>126.67709)
 		{
 			sum = total1+total2+total3;
 		}
 		if (k>37.421909 && k2>126.67709)
 		{
 			sum = total1+total2+total3;
 		}
 		if (k>37.421909 && k2>126.67801)
 		{
 			sum = total1+total2;
 		}
 		else
 		{
 			sum=total1;
 		}
		
 		
 		
 		
 		
 		 sum = sum*1000;
		 sum1 = Math.round(sum);
		 sum1 = sum1/1000;
		 ti = sum1/speed;
 		
		 ti = Math.round(ti*60);
         finmin = Double.parseDouble(min);
         finhour = Double.parseDouble(hour);
         finmin=finmin+ti;
         
             //////////////////////
             
             
             if(finmin>60)
             {
            	 finhour=finhour+1;
            	 finmin=finmin-60;
             }
             String am="오전";
             
             if(finhour>=13)
             {
            	 finhour=finhour-12;
            	 am ="오후";
             }
             

			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			
			double am1 = Math.round(finhour);
			double am2 = Math.round(finmin);
			
			 int kkk1 = (int) Math.round(finhour);
             int kkk2 = (int) Math.round(finmin);
			
			alertDialog.setTitle("도착 예정시간");
			alertDialog.setMessage(String.format("택배 도착예정시간은 "+kkk1+"시 "+kkk2+"분입니다."));
			alertDialog.setPositiveButton("확인", null);
			alertDialog.show();
	
			
		
            
            /////////////////////////////
			
	
						
						
						
						
						
						////////////////////////////알림창
						//알림 메니저 객체 얻어오기
				        notiManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				        //진동 객체 생성
				        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
							   
				         Handler handler = new Handler()
				        {
				            public void handleMessage(android.os.Message msg) 
				            {
				             //notification 객체 생성(상단바에 보여질 아이콘, 메세지, 도착시간 정의)////사진
				             Notification noti = new Notification(R.drawable.sooonnn//알림창에 띄울 아이콘
				                      , "택배 위치 추적", //간단 메세지
				                      System.currentTimeMillis()); //도착 시간
				             
				             //기본으로 지정된 소리를 내기 위해
				             noti.defaults = Notification.DEFAULT_SOUND;
				             //알림 소리를 한번만 내도록
				             noti.flags = Notification.FLAG_ONLY_ALERT_ONCE;
				             //확인하면 자동으로 알림이 제거 되도록
				             noti.flags = Notification.FLAG_AUTO_CANCEL;
				             
				             //사용자가 알람을 확인하고 클릭했을때 새로운 액티비티를 시작할 인텐트 객체
				             Intent intent = new Intent(DaumMapSampleActivity.this, MainActivity.class);
				             //새로운 태스크(Task) 상에서 실행되도록(보통은 태스크1에 쌓이지만 태스크2를 만들어서 전혀 다른 실행으로 관리한다)
				             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				             //인텐트 객체를 포장해서 전달할 인텐트 전달자 객체
				             PendingIntent pendingI = PendingIntent.getActivity(DaumMapSampleActivity.this, 0, intent, 0);
				             //상단바를 드래그 했을때 보여질 내용 정의하기
				             
				             ////////////////도착시간표시
				             
				 			double total1 = Cale(disa1,disb1,disa2,disb2);
							double total2 = Cale(disa2,disb2,disa3,disb3);
							double total3 = Cale(disa3,disb3,disa4,disb4);
							double total4 = Cale(disa4,disb4,disa5,disb5);
							double total5 = Cale(disa5,disb5,disa6,disb6);
							double total6 = Cale(disa6,disb6,disa7,disb7);
							double total7 = Cale(disa7,disb7,disa8,disb8);
							double total8 = Cale(disa8,disb8,disa9,disb9);
							double total9 = Cale(disa9,disb9,disa10,disb10);
							double total10 = Cale(disa10,disb10,disa11,disb11);
							double total11 = Cale(disa12,disb12,disa13,disb13);
							double total12 = Cale(disa13,disb13,disa14,disb14);
							double total13 = Cale(disa14,disb14,disa15,disb15);
							double total14 = Cale(disa15,disb15,disa16,disb16);
							double total15 = Cale(disa16,disb16,disa17,disb17);
							double total16 = Cale(disa17,disb17,disa18,disb18);
							double total17 = Cale(disa18,disb18,disa19,disb19);
							double total18 = Cale(disa19,disb19,disa20,disb20);
							double total19 = Cale(disa20,disb20,disa21,disb21);
							double total20 = Cale(disa21,disb21,disa22,disb22);
							double total21 = Cale(disa22,disb22,disa23,disb23);
							double total22 = Cale(disa23,disb23,disa24,disb24);
							double total23 = Cale(disa24,disb24,disa25,disb25);
							double total24 = Cale(disa25,disb25,disa26,disb26);
							double total25 = Cale(disa26,disb26,disa27,disb27);
							double total26 = Cale(disa27,disb27,disa28,disb28);
							double total27 = Cale(disa28,disb28,disa29,disb29);
							double total28 = Cale(disa29,disb29,disa30,disb30);
							double total29 = Cale(disa30,disb30,disa31,disb31);
							double total30 = Cale(disa31,disb31,disa32,disb32);
							double total31 = Cale(disa32,disb32,disa33,disb33);
							double total32 = Cale(disa33,disb33,disa34,disb34);
							double total33 = Cale(disa34,disb34,disa35,disb35);
							double total34 = Cale(disa35,disb35,disa36,disb36);
							double total35 = Cale(disa36,disb36,disa37,disb37);
							double total36 = Cale(disa37,disb37,disa38,disb38);
							double total37 = Cale(disa38,disb38,disa39,disb39);
							double total38 = Cale(disa39,disb39,disa40,disb40);
							double total39 = Cale(disa40,disb40,disa41,disb41);
							double total40 = Cale(disa41,disb41,disa42,disb42);
							double total41 = Cale(disa42,disb42,disa43,disb43);
							double total42 = Cale(disa43,disb43,disa44,disb44);
							double total43 = Cale(disa44,disb44,disa45,disb45);
							double total44 = Cale(disa45,disb45,disa46,disb46);
							double total45 = Cale(disa46,disb46,disa47,disb47);
							double total46 = Cale(disa47,disb47,disa48,disb48);
							double total47 = Cale(disa48,disb48,disa49,disb49);
							
							
						sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
									total11+total12+total13+total14+total15+total16+total17+total18+total19+
									total20+total21+total22+total23+total24+total25+total26+total27+total28+
									total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
									total39+total40+total41+total42+total43+total44+total45+total46+total47;
				 		
				 		sum = sum*1000;
			    		 sum1 = Math.round(sum);
			    		 sum1 = sum1/1000;
			    		 ti = sum1/speed;
				 		
				 		
				             ti = Math.round(ti*60);
				             finmin = Double.parseDouble(min);
				             finhour = Double.parseDouble(hour);
				             finmin=finmin+ti;
				             //////////////////////
				             
				             if(finmin>=60)
				             {
				            	 finhour=finhour+1;
				            	 finmin=finmin-60;
				             }
				             String am="오전";
				             
				             if(finhour>=13)
				             {
				            	 finhour=finhour-12;
				            	 am ="오후";
				             }
				             int kkk1 = (int) Math.round(finhour);
				             int kkk2 = (int) Math.round(finmin);
				             
				             
				             noti.setLatestEventInfo(DaumMapSampleActivity.this, "택배 도착예정시간", "도착예정시간은 "+ am +" "+kkk1+"시  "+kkk2+ "분 입니다.", pendingI);
				             //알림창 띄우기(알림이 여러개일수도 있으니 알림을 구별할 상수값, 여러개라면 상수값을 달리 줘야 한다.)
				             notiManager.notify(MyNoti, noti);
				             //진동주기(** 퍼미션이 필요함 **)
				             vibrator.vibrate(1000); //1초 동안 진동
				             
				             
				            }
				            
				            
				           };
				           
				           
				           Toast.makeText(this, "알림창에 도착예정시간을 표시합니다.", 0).show();
					        handler.sendEmptyMessageDelayed(0, 1000);
					     /////////////////////////////////////////////////////   
				        //여기까지가 알림창
					        
				        
					        

						
						
						//polyline1.addPoint(MapPoint.mapPointWithGeoCoord(k,k2));
						
					
						
						
						
					
						
						
						
			}
		
		}
		
		
	

	
	
			return true;
    
    

			
 
   
			
			
		}
    
    
    
		
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// net.daum.mf.map.api.MapView.OpenAPIKeyAuthenticationResultListener

	@Override
	public void onDaumMapOpenAPIKeyAuthenticationResult(MapView mapView, int resultCode, String resultMessage) {
		Log.i(LOG_TAG,	String.format("Open API Key Authentication Result : code=%d, message=%s", resultCode, resultMessage));	
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// net.daum.mf.map.api.MapView.MapViewEventListener
	
	public void onMapViewInitialized(MapView mapView) { 
		Log.i(LOG_TAG, "MapView had loaded. Now, MapView APIs could be called safely"); 
		mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
	} 
	
	@Override
	public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapCenterPoint) {
		MapPoint.GeoCoordinate mapPointGeo = mapCenterPoint.getMapPointGeoCoord();
		Log.i(LOG_TAG, String.format("MapView onMapViewCenterPointMoved (%f,%f)", mapPointGeo.latitude, mapPointGeo.longitude));
	}

	@Override
	public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {
		
		MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage(String.format("Double-Tap on (%f,%f)", mapPointGeo.latitude, mapPointGeo.longitude));
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
	}

	@Override
	public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {
		
		MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage(String.format("Long-Press on (%f,%f)", mapPointGeo.latitude, mapPointGeo.longitude));
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
	}

	@Override
	public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {
		MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();
		Log.i(LOG_TAG, String.format("MapView onMapViewSingleTapped (%f,%f)", mapPointGeo.latitude, mapPointGeo.longitude));
	}

	@Override
	public void onMapViewZoomLevelChanged(MapView mapView, int zoomLevel) {
		Log.i(LOG_TAG, String.format("MapView onMapViewZoomLevelChanged (%d)", zoomLevel));
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// net.daum.mf.map.api.MapView.CurrentLocationEventListener
	


	@Override
	public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float headingAngle) {
		Log.i(LOG_TAG, String.format("MapView onCurrentLocationDeviceHeadingUpdate: device heading = %f degrees", headingAngle));
	}
	
	@Override
	public void onCurrentLocationUpdateFailed(MapView mapView) {
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage("Current Location Update Failed!");
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
	}
	
	@Override
	public void onCurrentLocationUpdateCancelled(MapView mapView) {
		Log.i(LOG_TAG, "MapView onCurrentLocationUpdateCancelled");
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// net.daum.mf.map.api.MapView.POIItemEventListener
	
	@Override
	public void onPOIItemSelected(MapView mapView, MapPOIItem poiItem) {
		Log.i(LOG_TAG, String.format("MapPOIItem(%s) is selected", poiItem.getItemName()));
	}
	
	@Override
	public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem poiItem) {

		String alertMessage = null;
		
		if (poiItem == this.poiItem) {
			
			alertMessage = "Touched the callout-balloon of item1";
			
		} else if (poiItem.getTag() == 153) {
			
			String addressForThisItem = MapReverseGeoCoder.findAddressForMapPoint("DAUM_LOCAL_DEMO_APIKEY", poiItem.getMapPoint());
			alertMessage = String.format("Touched the callout-balloon of item2 (address : %s)", addressForThisItem);
			
		} else if ((poiItem.getUserObject() instanceof String) &&  poiItem.getUserObject().equals("item3")) {
			
			Intent intent = new Intent(this, MapPOIDetailActivity.class);
			intent.putExtra("POIName", poiItem.getItemName());
			startActivity(intent);
			return;
			
		} else if (poiItem.getTag() == 276) {
			
			alertMessage = "Touched the callout-balloon of item4";
		}

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage(alertMessage);
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
	}
// 다음 지도 api 사용
	@Override
	public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem poiItem, MapPoint newMapPoint) {
		
		MapPoint.GeoCoordinate newMapPointGeo = newMapPoint.getMapPointGeoCoord();
		String alertMessage = String.format("Draggable MapPOIItem(%s) has moved to new point (%f,%f)", poiItem.getItemName(), newMapPointGeo.latitude, newMapPointGeo.longitude);
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage(alertMessage);
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	// net.daum.mf.map.api.MapReverseGeoCoder.ReverseGeoCodingResultListener
	
	@Override
	public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder rGeoCoder, String addressString) {
		
		String alertMessage = String.format("Center Point Address = [%s]", addressString);
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage(alertMessage);
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
		
		reverseGeoCoder = null;
	}
	
	@Override
	public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder rGeoCoder) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("DaumMapLibrarySample");
		alertDialog.setMessage("Reverse Geo-Coding Failed");
		alertDialog.setPositiveButton("OK", null);
		alertDialog.show();
		
		reverseGeoCoder = null;
	}
	
	
	
	
	
    private void startLocationService() 
    {
    	// 위치 관리자 객체 참조
    	LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// 위치 정보를 받을 리스너 생성
    	GPSListener gpsListener = new GPSListener();
		long minTime = 10000;
		float minDistance = 0;
		// GPS를 이용한 위치 요청
		manager.requestLocationUpdates(
					LocationManager.GPS_PROVIDER,
					minTime,
					minDistance,
					gpsListener);
		// 네트워크를 이용한 위치 요청
		manager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER,
				minTime,
				minDistance,
				gpsListener);
		// 위치 확인이 안되는 경우에도 최근에 확인된 위치 정보 먼저 확인
		try {
			Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if (lastLocation != null) {
				Double latitude = lastLocation.getLatitude();
				Double longitude = lastLocation.getLongitude();
			Toast.makeText(getApplicationContext(), "Last Known Location : " + "Latitude : "+ latitude + "\nLongitude:"+ longitude, Toast.LENGTH_LONG).show();
			}
		
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}

		//Toast.makeText(getApplicationContext(), "위치 확인이 시작되었습니다. 로그를 확인하세요.", Toast.LENGTH_SHORT).show();
    }
    
    /////////////////위도 경도로 거리 구하기
    public double Cale(double lat1, double long1,double lat2,double long2){
    	double dDistance = 0;
    	double A = lat1 *(Math.PI/180.0);
    	double B = long1*(Math.PI/180.0);
    	double C = lat2*(Math.PI/180.0);
    	double D = long2*(Math.PI/180.0);
    	double E = D - B;
    	double oh = C - A;
    	double F = Math.pow(Math.sin(oh/2.0), 2.0)+Math.cos(A)*Math.cos(C)*Math.pow(Math.sin(E/2.0),2.0);
    	double G = 2.0*Math.atan2(Math.sqrt(F), Math.sqrt(1.0-F));
    	double kEarth =6376.5;
    	dDistance = kEarth * G;
    	return dDistance;
    }
    /////////////////////////////////
    
    
    
    
    
    
    /////////////////////////////
    
    private class GPSListener implements LocationListener 
	{
		/**
		 * 위치 정보가 확인될 때 자동 호출되는 메소드
		 */
	    public void onLocationChanged(Location location) {
			Double latitude = location.getLatitude();
			Double longitude = location.getLongitude();
			k = location.getLatitude();
			k2 = location.getLongitude();
			
			
			double total1 = Cale(disa1,disb1,disa2,disb2);
			double total2 = Cale(disa2,disb2,disa3,disb3);
			double total3 = Cale(disa3,disb3,disa4,disb4);
			double total4 = Cale(disa4,disb4,disa5,disb5);
			double total5 = Cale(disa5,disb5,disa6,disb6);
			double total6 = Cale(disa6,disb6,disa7,disb7);
			double total7 = Cale(disa7,disb7,disa8,disb8);
			double total8 = Cale(disa8,disb8,disa9,disb9);
			double total9 = Cale(disa9,disb9,disa10,disb10);
			double total10 = Cale(disa10,disb10,disa11,disb11);
			double total11 = Cale(disa12,disb12,disa13,disb13);
			double total12 = Cale(disa13,disb13,disa14,disb14);
			double total13 = Cale(disa14,disb14,disa15,disb15);
			double total14 = Cale(disa15,disb15,disa16,disb16);
			double total15 = Cale(disa16,disb16,disa17,disb17);
			double total16 = Cale(disa17,disb17,disa18,disb18);
			double total17 = Cale(disa18,disb18,disa19,disb19);
			double total18 = Cale(disa19,disb19,disa20,disb20);
			double total19 = Cale(disa20,disb20,disa21,disb21);
			double total20 = Cale(disa21,disb21,disa22,disb22);
			double total21 = Cale(disa22,disb22,disa23,disb23);
			double total22 = Cale(disa23,disb23,disa24,disb24);
			double total23 = Cale(disa24,disb24,disa25,disb25);
			double total24 = Cale(disa25,disb25,disa26,disb26);
			double total25 = Cale(disa26,disb26,disa27,disb27);
			double total26 = Cale(disa27,disb27,disa28,disb28);
			double total27 = Cale(disa28,disb28,disa29,disb29);
			double total28 = Cale(disa29,disb29,disa30,disb30);
			double total29 = Cale(disa30,disb30,disa31,disb31);
			double total30 = Cale(disa31,disb31,disa32,disb32);
			double total31 = Cale(disa32,disb32,disa33,disb33);
			double total32 = Cale(disa33,disb33,disa34,disb34);
			double total33 = Cale(disa34,disb34,disa35,disb35);
			double total34 = Cale(disa35,disb35,disa36,disb36);
			double total35 = Cale(disa36,disb36,disa37,disb37);
			double total36 = Cale(disa37,disb37,disa38,disb38);
			double total37 = Cale(disa38,disb38,disa39,disb39);
			double total38 = Cale(disa39,disb39,disa40,disb40);
			double total39 = Cale(disa40,disb40,disa41,disb41);
			double total40 = Cale(disa41,disb41,disa42,disb42);
			double total41 = Cale(disa42,disb42,disa43,disb43);
			double total42 = Cale(disa43,disb43,disa44,disb44);
			double total43 = Cale(disa44,disb44,disa45,disb45);
			double total44 = Cale(disa45,disb45,disa46,disb46);
			double total45 = Cale(disa46,disb46,disa47,disb47);
			double total46 = Cale(disa47,disb47,disa48,disb48);
			double total47 = Cale(disa48,disb48,disa49,disb49);
			
			
		
		if (k>37.450150)
		{
			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37;
			
		}
		else
		{
			sum = total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+
					total11+total12+total13+total14+total15+total16+total17+total18+total19+
					total20+total21+total22+total23+total24+total25+total26+total27+total28+
					total29+total30+total31+total32+total33+total34+total35+total36+total37+total38+
					total39+total40+total41+total42+total43+total44+total45+total46+total47;
		}	
			
		
			
			
			
			
			
			double dis = Cale(k,k2,disa1,disb1);
			
			
			
			
			
			 hour = new SimpleDateFormat("HH").format(new Date());
    		 min = new SimpleDateFormat("mm").format(new Date());
    		 
    		 sum=sum-dis;
    		 sum = sum*1000;
    		 sum1 = Math.round(sum);
    		 sum1 = sum1/1000;
    		 ti = sum1/speed;
    		 
    		 
    		
    		 
    		 
			
			 num = String.format("%.1f ", dis);
			
/////////////// 이걸 이용해서 몇 분남았는지 불러오기
			//String msg = "Latitude : "+ latitude + "\nLongitude:"+ longitude;
			//Log.i("GPSListener", msg);
			
		    //	Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
			
		/*	String msg = "남은 거리는 : "+ num +"입니다. 도착예정시간은 "+hour+"시  "+min+ "km 입니다.";
			Log.i("GPSListener", msg);
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
			*/
			
//////////////////////////////////////			
			
			
		}

	    public void onProviderDisabled(String provider) {
	    }

	    public void onProviderEnabled(String provider) {
	    }

	    public void onStatusChanged(String provider, int status, Bundle extras) {
	    }

	}
    
    
    	
    //////////////////////여기서 부터는 알림창을 위한 함수들 오버라이드
    
    

	
	
	
	
	

}