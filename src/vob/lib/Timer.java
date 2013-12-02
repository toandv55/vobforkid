package vob.lib;

import vob.game.CurrentGame;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Timer {
	private CountDownTimer cdt;
	private Context context;
	private int timeHave; //thoi gian cho phep
	private int timeExtant; //thoi gian con lai
	private TextView tv;
	private boolean running;
	private boolean finish;
	
	public Timer(Context context, TextView tv) {
		 this.context = context;
		 this.tv = tv;
		 running = false;
		 finish = false;
	}
	
	public void startCountDown() {
		cdt = new CountDownTimer(timeHave, 1000) {
	
			public void onTick(long millisUntilFinished) {
				
		         timeExtant -= 1000;
		         
		         int min = (timeExtant / 1000) / 60;
		         int sec = (timeExtant / 1000) - min * 60;
		         
		         tv.setText("Thời gian: " + min + ":" + sec);		       
		         
		         running = true;
		    }
		
		    public void onFinish() {
		    	tv.setText("Thoi gian: 0");
		    	finish = true;
		    	new MyDialog(context, "Hoàn thành", "Chúc mừng bạn đã đạt được " + CurrentGame.scoreTotal + "điểm").show();	  
		    }
		};
	  cdt.start();
	}
	
	public void stop() {
		timeHave = timeExtant;
		cdt.cancel();
		//new Alert(context, "Time Extant " + timeExtant).show();
		running = false;
	}
	
	public void resume() {
		startCountDown();
	}
	
	public void finish() {
		cdt.cancel();
	}
	public void setTimeHave(int time) {
		timeHave = time;
		timeExtant = time;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public boolean isFinish() {
		return finish;
	}
}
