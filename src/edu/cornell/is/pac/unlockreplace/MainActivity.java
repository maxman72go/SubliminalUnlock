package edu.cornell.is.pac.unlockreplace;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
  
/** Called when the activity is first created. */
	
	private ViewSwitcher switcher;
	private static final int REFRESH_SCREEN = 1;
	

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.profileswitcher);
    
    
    Intent intent = new Intent(this, MyBroadcastReceiver.class);
    switcher = (ViewSwitcher) findViewById(R.id.profileSwitcher);

      //load the activity
      new CountDownTimer(25, 1000) {

		     public void onTick(long millisUntilFinished) {
		     }

		     public void onFinish() {
		    	 switcher.showNext();
		    	 new CountDownTimer(1, 1000) {

				     public void onTick(long millisUntilFinished) {
				     }

				     public void onFinish() {
				         finish();
				         overridePendingTransition(0, 0);
				     }
				  }.start();
		     }
		  }.start();
  }

} 