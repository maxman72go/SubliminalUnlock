package edu.cornell.is.pac.unlockreplace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
	
	
  @Override
  public void onReceive(final Context context, Intent intent) {
	  
	  if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
		  new CountDownTimer(500, 1000) {

			     public void onTick(long millisUntilFinished) {
			     }

			     public void onFinish() {
			     
			     	Intent i = new Intent();
	  			i.setClassName("edu.cornell.is.pac.unlockreplace", "edu.cornell.is.pac.unlockreplace.MainActivity");
	  			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	  			//i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	  			context.startActivity(i);
			     }
			  }.start();
		  }
      }
}

  

