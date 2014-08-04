package edu.cornell.is.pac.unlockreplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
  
/** Called when the activity is first created. */
	
	private ViewFlipper switcher;
	private static final int REFRESH_SCREEN = 1;
	

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.profileswitcher);
    
    
    Intent intent = new Intent(this, MyBroadcastReceiver.class);
    switcher = (ViewFlipper) findViewById(R.id.profileSwitcher);

      //load the activity
      new CountDownTimer(25, 1000) {

		     public void onTick(long millisUntilFinished) {
		     }

		     public void onFinish() {
		    	 switcher.showNext();
		    	 new CountDownTimer(50, 1000) {

				     public void onTick(long millisUntilFinished) {
				     }

				     public void onFinish() {
				    	 //finish();
				         //overridePendingTransition(0, 0);
				    	 switcher.showNext();
				    	 new CountDownTimer(1000,1000){
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
		  }.start();
  }

} 