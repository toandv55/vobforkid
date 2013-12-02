package vob.activity;

import vob.lib.Alert;
import vob.lib.InsertSomeData;
import vob.orm.DatabaseMapper;
import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import anim.MyAnimation;

public class StartMenuActivity extends Activity {

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch(Exception e) {			
		}
	}
	private void initView() {
		//play ImageView
		final ImageView play = (ImageView) findViewById(R.id.play);
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				play.startAnimation(AnimationUtils.loadAnimation(StartMenuActivity.this, R.anim.zoom_out));
				Thread t = new Thread(new Runnable() {
					public void run() {
						sleep(300);
						play();
					}
				});
				t.start();
			}
		});
		
		//review ImageView
		final ImageView review = (ImageView) findViewById(R.id.review);
		review.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				review.startAnimation(AnimationUtils.loadAnimation(StartMenuActivity.this, R.anim.zoom_out));				
				Thread t = new Thread(new Runnable() {
					public void run() {
						sleep(300);
						review();
					}
				});
				t.start();
			}
		});
		
		final ImageView setting = (ImageView) findViewById(R.id.setting);
		setting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setting.startAnimation(AnimationUtils.loadAnimation(StartMenuActivity.this, R.anim.zoom_out));
				Thread t = new Thread(new Runnable() {
					public void run() {
						sleep(300);
						setting();
					}
				});
				t.start();
			}
		});
		     
		//quit ImageView
		final ImageView exit = (ImageView) findViewById(R.id.exit);
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//MyAnimation.fadeOut(exit, "alpha", 500, 1);
				exit.startAnimation(AnimationUtils.loadAnimation(StartMenuActivity.this, R.anim.zoom_out));
				Thread t = new Thread(new Runnable() {
					public void run() {
						sleep(300);
						exit();
					}
				});
				t.start();
			}
		});
		
		cloud();
	}
	
	@SuppressLint("NewApi")
	protected void cloud() {
		final Context context = this;
		for(int i = 0; i < 10; i++) {
			ImageView clound = (ImageView) findViewById(R.id.clound);
			ObjectAnimator oba = MyAnimation.moverX(clound, -400, 400, 50000, 50);
			//oba.setRepeatCount(50);
			MyAnimation.start(oba);
			try {
				//Thread.sleep(10000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_menu);
		@SuppressWarnings("unused")
		DatabaseMapper dbm = new DatabaseMapper(this);
		
		
		if (!dbm.checkExistData()) {
			InsertSomeData inserter = new InsertSomeData(this);
			try {
				inserter.insertTopic();
				inserter.insertWord();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		initView();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_menu, menu);
		return true;
	}
	/**
	 * Switches to PlayMenuActivity
	 * @param v
	 */
	public void play() {
		Intent intent = new Intent(this, StudyMenuActivity.class);
		startActivity(intent);
	}
	
	public void review() {
		Intent intent = new Intent(this, ReviewMenuActivity.class);
		startActivity(intent);
	}
	
	public void setting() {
		Intent intent = new Intent(this, SettingActivity.class);
		startActivity(intent);
	}
	public void exit() {
		finish();
		System.exit(0);
	}
}
