package vob.test;

import java.util.ArrayList;
import java.util.List;

import vob.model.*;
import vob.orm.WordMapper;
import android.content.Context;
import android.util.Log;

public class WordTest {
	Context context;

	public WordTest(Context context) {
		this.context = context;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	/*Test GetWordList of a specific topic by parameter ID
	Result: Pass*/
	public void testGetWordListOfTopic(){
		WordMapper wm = new WordMapper(context);
		List<Word> wl= new ArrayList<Word>();
		wl=wm.getWordListOfTopic(1);
		
		for(Word aWord : wl){
			String log = "Name " + aWord.getWord() + " Phonetic  " + aWord.getPhonetic()+ "ID : "+ aWord.getTopicId();
			Log.d("Word info ", log );
		}
	
	}
}
