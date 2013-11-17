package vob.test;

import vob.model.Topic;
import vob.model.Word;
import vob.orm.TopicMapper;
import android.content.Context;
import android.util.Log;

public class TopicMapperTest {
	Context context;
	
	public TopicMapperTest(Context context) {
		super();
		this.context = context;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	public void getTopicOnlyTest(Context context,int id){
		TopicMapper tm= new TopicMapper(context);
		Topic aTopic = new Topic();
		aTopic= tm.getTopicOnly(id);
		
		String log = "Name: "+ aTopic.getName()+"Id: "+aTopic.getId();
		if(aTopic.getWordList()== null) 
			log += log + "The WordList is null ";
		Log.d("GetTopic Only Test", log );
		
	}
	
	/*Test get a topic with its wordList*/
	public void getATopicWithWordListTest(Context context, int id){
		TopicMapper tm = new TopicMapper(context);
		Topic aTopic = new Topic();
		aTopic = tm.getATopicWithWord(id);
		
		String log = "Name: "+ aTopic.getName()+"Id: "+aTopic.getId();
		if(aTopic.getWordList()!= null) 
			log += log + "The WordList is not null ";
		Log.d("GetTopic Only Test", log );
		
		for(Word aWord : aTopic.getWordList()){
			String log2 = "Name " + aWord.getWord() + " Phonetic  " + aWord.getPhonetic()+ "ID : "+ aWord.getTopicId();
			Log.d("Word info ", log2 );
		}
	
		
		
		
	}
}
