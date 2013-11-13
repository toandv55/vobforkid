package vob.lib;

import java.util.ArrayList;
import java.util.List;

import vob.model.Topic;
import vob.model.Word;
import vob.orm.TopicMapper;
import android.content.Context;
import android.util.Log;

public class InsertSomeData {
	
	public InsertSomeData(Context context) {
		TopicMapper topicMaper = new TopicMapper(context);
		//topicMaper.deleteAllData();
		Log.d("Create TopicMapper","Create TopicMapper");
				
		
		// Insert topic Succesfull 		
		Topic animal = new Topic(1, "Animal", "image5", null );
		Topic plant = new Topic(2, "Plant ", "image5", null );
		Topic human = new Topic (3 , "Human", "image5", null );
		
		Log.d ("Insert ","Initiate inserting new topics  ");
		topicMaper.add(animal);
		topicMaper.add(plant);
		topicMaper.add(human);
		Log.d ("Insert ","Inserting success");
		
		
	/*	Word cat = new Word ("cat","kæt","con meo", null,null,animal);
		Word dog = new Word ("dog","dɒg","con cho",null,null,animal);
		Log.d("Insert","Initiate inserting new words ");
		topicMaper.addWord(cat);
		topicMaper.addWord(dog);
		
		Log.d("Insert terminate ","Insert words succesfull");
		
		Log.d("Reading all Words","Reading all Words ...");
		List <Word> list = topicMaper.getAllWord();
		
		for(Word aWord : list){
			String log = "Name " + aWord.getWord() + " Phonetic  " + aWord.getPhonetic()+ "ID : "+ aWord.getTopicId();
			Log.d("Word info ", log );
		}
		
		Log.d("Reading all Topic ","Reading all Topic  ...");
		List <Topic> alist = topicMaper.getAllTopics();
		
		for(Topic aTopic : alist){
			String log = "ID : " + aTopic.getId() + "Name :" + aTopic.getName();
			Log.d("Topic info ", log );
		}*/
		
		//Create List Animal object to be inserted. 
		
		Word bird = new Word (	"bird","bɜd",	"con chim", "bird",	"bird",	animal);
		Word chicken = new Word (	"chicken",	"tʃɪk.ɪn",	"con gà", "chicken",	"chicken",	animal);
		Word cow = new Word (	"cow",	"kaʊ",	"con bò", "cow",	"cow",	animal);
		Word crocodile = new Word (	"crocodile",	"krɒk.ə.daɪl",	"cá sấu",	 "crocodile",	"crocodile",	animal);
		Word dog = new Word ("dog","dɒg","con chó", "dog","dog",animal);
		Word duck = new Word ("duck","dʌk","con vịt", "duck","duck",animal);
		Word elephant = new Word ("elephant","el.ɪ.fənt ","con voi", "elephant","elephant",animal);
		Word frog = new Word ("frog","frɒg","con ếch", "frog","frog",animal);
		Word goat = new Word ("goat","gəʊt","con dê", "goat","goat",animal);
		Word hippopotamus = new Word ("hippopotamus","hɪp.əpɒt.ə.məs ","hà mã", "hippo","hippo",animal);
		Word horse = new Word ("horse","hɔs","con ngựa", "horse","horse",animal);
		Word lizard = new Word ("lizard","lɪz.əd","con thằn lằn", "lizard","lizard",animal);
		Word monkey = new Word ("monkey","mʌŋ.ki","con khỉ", "monkey","monkey",animal);
		Word mouse = new Word ("mouse","maʊs","con chuột", "mouse","mouse",animal);
		Word sheep = new Word ("sheep","ʃip","con cừu", "sheep","sheep",animal);
		Word snake = new Word ("snake","sneɪk","con rắn", "snake","snake",animal);
		Word spider = new Word ("spider","spaɪ.dər","con nhện", "spider","spider",animal);
		Word tiger = new Word ("tiger","taɪ.gər","con hổ", "tiger","tiger",animal);
		
		List<Word> addList = new ArrayList<Word>();
		addList.add(bird);
		addList.add(chicken);
		addList.add(cow);
		addList.add(crocodile);
		addList.add(dog);
		addList.add(duck);
		addList.add(elephant);
		addList.add(frog);
		addList.add(goat);
		addList.add(hippopotamus);
		addList.add(horse);
		addList.add(lizard);
		addList.add(monkey);
		addList.add(mouse);
		addList.add(sheep);
		addList.add(snake);
		addList.add(spider);
		addList.add(tiger);
		
		// Insert WordList into database
		for (Word aWord : addList){
			topicMaper.addWord(aWord);
		}
	}
}
