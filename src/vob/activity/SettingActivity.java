package vob.activity;

import vob.game.CurrentGame;
import vob.lib.Alert;
import vob.lib.BackgroundSoundService;
import vob.lib.FinishDialog;
import vob.lib.ResourceR;
import vob.orm.TopicMapper;
import vob.orm.WordMapper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends Activity {

	private void initView() {
		
		final CheckBox musicBackground = (CheckBox) findViewById(R.id.music_background);
		if(CurrentGame.soundBackground == true) {
			musicBackground.setChecked(true);
		}		
		
		final CheckBox deleteReview = (CheckBox) findViewById(R.id.delete_review);
		if(CurrentGame.deleteReview == true) {
			deleteReview.setChecked(true);
		}
		
		final RadioGroup chooseTime = (RadioGroup) findViewById(R.id.choose_time);
		if(CurrentGame.timePlay == 5 * 60 * 1000) {
			((RadioButton) findViewById(R.id.choose_5)).setChecked(true);
		} else if(CurrentGame.timePlay == 10 * 60 * 1000) {
			((RadioButton) findViewById(R.id.choose_10)).setChecked(true);
		} else {
			((RadioButton) findViewById(R.id.choose_15)).setChecked(true);
		}
		
		final RadioGroup chooseLevel = (RadioGroup) findViewById(R.id.choose_level);
		if(CurrentGame.level == 0) {
			((RadioButton) findViewById(R.id.choose_easy)).setChecked(true);
		} else if(CurrentGame.level == 1) {
			((RadioButton) findViewById(R.id.choose_medium)).setChecked(true);
		} else if(CurrentGame.level == 2) {
			((RadioButton) findViewById(R.id.choose_hard)).setChecked(true);
		} else if(CurrentGame.level == 3) {
			((RadioButton) findViewById(R.id.choose_very_hard)).setChecked(true);			
		}
		
		Button ok = (Button) findViewById(R.id.ok);
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(musicBackground.isChecked()) {
					//startService(new Intent(SettingActivity.this,BackgroundSoundService.class));
					CurrentGame.player = MediaPlayer.create(SettingActivity.this, ResourceR.getRaw(SettingActivity.this, "afraid")); 
					CurrentGame.player.setLooping(true); // Set looping
					CurrentGame.player.setVolume(100,100);
					CurrentGame.player.start();
					CurrentGame.soundBackground = true;
				} else {
					//stopService(new Intent(SettingActivity.this,BackgroundSoundService.class));
					CurrentGame.player.stop();
					CurrentGame.soundBackground = false;
				}
				
				if(deleteReview.isChecked()) {
					TopicMapper topicMapper = new TopicMapper(SettingActivity.this);
					topicMapper.updateAllWordNotLeared();
					CurrentGame.deleteReview = true;
				} else {
					CurrentGame.deleteReview = false;
				}
				
				int chooseTimeId = chooseTime.getCheckedRadioButtonId();
				RadioButton rbChooseTime = (RadioButton) findViewById(chooseTimeId);
				String time = (String) rbChooseTime.getText();
				CurrentGame.timePlay = Integer.parseInt(time) * 60 * 1000;
				
				int chooseLevelId = chooseLevel.getCheckedRadioButtonId();
				RadioButton rbChooseLevel = (RadioButton) findViewById(chooseLevelId);
				String strLevel = (String) rbChooseLevel.getText();
				
				int level = 1;
				if(strLevel.equals("Dễ") == true) {
					level = 0;
				} else if(strLevel.equals("Vừa") == true) {
					level = 1;
				} else if(strLevel.equals("Khó") == true) {
					level = 2;
				} else if(strLevel.equals("Rất khó") == true) {
					level = 3;
				}
				CurrentGame.level = level;
				
				SettingActivity.this.finish();
			}
		});
		
		
		Button cancel = (Button) findViewById(R.id.cancel);
		cancel.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				SettingActivity.this.finish();
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		initView();	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reset, menu);
		return true;
	}

}
