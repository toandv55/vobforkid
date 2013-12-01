package vob.activity;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import vob.model.*;
import vob.orm.TopicMapper;
import vob.lib.*;

public class ReviewActivity extends FragmentActivity {
	private static List<Word> listWord;
	private int pos;
	
	private void init() {
		
		Bundle bundle = getIntent().getExtras();		
		int idTopic = bundle.getInt("idTopic");
		String word = bundle.getString("word");
		
		TopicMapper topicMapper = new TopicMapper(this);
		
		listWord = topicMapper.getReviewTopic(idTopic).getWordList();
	
		pos = 0;
		
		for(Word w : listWord) {
			if(w.getWord().equals(word) == true) {
				break;
			}
			pos++;
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review);
		
		init();
		
		ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
		viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
		viewPager.setCurrentItem(pos);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.study, menu);
		return true;
	}
	
	private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
	    public MyFragmentPagerAdapter(FragmentManager fm)   {
	        super(fm);
	    }

	    @Override
	    public Fragment getItem(int index) {
	        return PageFragment.newInstance(ReviewActivity.this, listWord, index);
	    }

	    @Override
	    public int getCount() {
	        return listWord.size();
	    }
	}
}
