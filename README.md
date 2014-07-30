SubliminalUnlock
================

Shows a subliminal image when phone is unlocked
It works by using a ViewSwitcher to initally load an empty view, then switch to the picture, then terminate after a short period of time.

```
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
				         //disable animation
				         overridePendingTransition(0, 0);
				     }
				  }.start();
		     }
		  }.start();
```

Uses a BroadcastReceiver that listens to the intent of ```ACTION_USER_PRESENT```
