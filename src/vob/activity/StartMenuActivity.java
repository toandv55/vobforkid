package vob.activity;

import vob.lib.InsertSomeData;
import vob.test.*;
import vob.orm.DatabaseMapper;
import vob.orm.TopicMapper;
import vob.test.WordTest;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class StartMenuActivity extends Activity {

	private void initView() {
		//play ImageView
		ImageView play = (ImageView) findViewById(R.id.play);
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				play();
			}
		});
		
		//review ImageView
		ImageView review = (ImageView) findViewById(R.id.review);
		review.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				review();
				
			}
		});
		
		//setting ImageView
		ImageView setting = (ImageView) findViewById(R.id.setting);
		setting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setting();
			}
		});
		
		//quit ImageView
		ImageView exit = (ImageView) findViewById(R.id.exit);
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				exit();
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_menu);
		@SuppressWarnings("unused")
		DatabaseMapper dbm= new DatabaseMapper(this);
		
		InsertSomeData inserter = new InsertSomeData(this);
		inserter.insertTopic();
		inserter.insertWord();
		inserter.insertTestdata();
		
		/*TopicMapperTest tmt = new TopicMapperTest(this);
		 tmt.getATopicWithWordListTest(this,2);
		tmt.getTopicOnlyTest(this,2);
		tmt.getReviewTopicTest(this, 100);*/
	
		
		
		
		//Test
		
		/*WordTest wt = new WordTest(this);
		wt.testGetWordListOfTopic();*/
		initView();



		//review();
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
