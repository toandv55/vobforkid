package vob.activity;

import java.util.ArrayList;
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
		
		List<Word> allWord;
		//new Alert(this, "" + idTopic).show();
		if(idTopic == -1) {
			TopicMapper topicMapper = new TopicMapper(this);
			allWord = topicMapper.getAllWord();
			
		} else {
			TopicMapper topicMapper = new TopicMapper(this);
			List<Topic> listTopic = topicMapper.getAllTopics();
			
			Topic topicCurrent = null;
			
			for(Topic t : listTopic) {
				if(t.getId() == idTopic) {
					topicCurrent = t;
					break;
				}
			}
			
			allWord = topicCurrent.getWordList();
		}
		
		listWord  = new ArrayList<Word>();
		
		
		for(Word w : allWord) {
			//Log.d("list animal", w.getWord());
			if(w.getIslearned() > 0) {
				listWord.add(w);
			}
		}
		
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
		//listWord = new ArrayList<Word>();
		//listWord.add(new Word("abcd", "go", "di","image3"));
		//listWord.add(new Word("bcda", "play", "chơi", "image4"));
		//listWord.add(new Word("cdab", "run", "Chay", "image5"));
		
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
