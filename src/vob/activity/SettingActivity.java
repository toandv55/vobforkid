package vob.activity;

import vob.game.Game;
import vob.lib.Alert;
import vob.lib.MyDialog;
import vob.orm.WordMapper;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends Activity {

	private void initView() {
		
		final CheckBox musicBackground = (CheckBox) findViewById(R.id.music_background);
		final CheckBox deleteReview = (CheckBox) findViewById(R.id.delete_review);
		final RadioGroup chooseTime = (RadioGroup) findViewById(R.id.choose_time);
		final RadioGroup chooseLevel = (RadioGroup) findViewById(R.id.choose_level);
		
		RadioButton choose5 = (RadioButton) findViewById(R.id.choose_5);
		choose5.setChecked(true);
		RadioButton chooseEasy = (RadioButton) findViewById(R.id.choose_easy);
		chooseEasy.setChecked(true);
		
		Button ok = (Button) findViewById(R.id.ok);
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(musicBackground.isChecked()) {
					
				}
				
				if(deleteReview.isChecked()) {
					
				}
				
				int chooseTimeId = chooseTime.getCheckedRadioButtonId();
				RadioButton rbChooseTime = (RadioButton) findViewById(chooseTimeId);
				String time = (String) rbChooseTime.getText();
				Game.timePlay = Integer.parseInt(time) * 60 * 1000;
				
				int chooseLevelId = chooseLevel.getCheckedRadioButtonId();
				RadioButton rbChooseLevel = (RadioButton) findViewById(chooseLevelId);
				String strLevel = (String) rbChooseLevel.getText();
				
				int level = 1;
				if(strLevel.equals("Dễ") == true) {
					level = 1;
				} else if(strLevel.equals("Vừa") == true) {
					level = 2;
				} else if(strLevel.equals("Khó") == true) {
					level = 3;
				} else if(strLevel.equals("Rất khó") == true) {
					level = 4;
				}
				Game.level = level;
				
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
