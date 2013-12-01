package vob.lib;

import java.util.ArrayList;
import java.util.List;

import vob.model.Topic;
import vob.model.Word;
import vob.orm.TopicMapper;
import android.content.Context;
import android.util.Log;

public class InsertSomeData {
	Context context;
	
	
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public InsertSomeData(Context mycontext) {
		context= mycontext;
		
	/*	
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
		
		
	}
	public void insertTopic(){
		TopicMapper topicMaper = new TopicMapper(context);
				
		Topic animal = new Topic(1, "animal", "animal", null );
		Topic clothes = new Topic(2, "clothes", "clothes", null );
		Log.d ("Insert ","Initiate inserting new topics  ");
		topicMaper.add(animal);
		topicMaper.add(clothes);
		Log.d ("Insert ","Inserting topic success");
	}
	
	public void insertWord(){
//		Create topic List
		Topic animal = new Topic(1, "animal", "animal", null );
		Topic clothes = new Topic(2, "clothes", "clothes", null );
		/*
		Create WordList to be insert*/
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
		
		/*List Clothes*/ 
		Word bag = new Word("bag", "bæg", "túi xách", "bag", "bag", clothes);
        Word dress = new Word("dress", "dres", "váy", "dress", "dress", clothes);
        Word glasses = new Word("glasses", "glɑs", "con hổ", "glasses", "glasses", clothes);
        Word hat = new Word("hat", "hæt", "mũ", "hat", "hat", clothes);
        Word jacket = new Word("jacket", "dʒæk.ɪt", "áo khoác", "jacket", "jacket", clothes);
        Word jeans = new Word("jeans", "dʒinz", "quần jean", "jeans", "jeans", clothes);
        Word shoe = new Word("shoe", "taɪ.gər", "giày", "shoe", "shoe", clothes);
        Word sock = new Word("sock", "sɒk", "tất", "sock", "sock", clothes);
        Word trousers = new Word("trousers", "traʊ.zəz", "quần dài", "trousers", "trousers", clothes);
        Word watch = new Word("watch", "wɒtʃ", "đồng hồ", "watch", "watch", clothes);
        Word shirt = new Word("shirt", "ʃɜt", "áo sơ mi", "shirt", "shirt", clothes);

        addList.add(bag);
        addList.add(dress);
        addList.add(glasses);
        addList.add(hat);
        addList.add(jeans);
        addList.add(shoe);
        addList.add(sock);
        addList.add(trousers);
        addList.add(watch);
        addList.add(shirt);
        addList.add(jacket);
		
		TopicMapper topicMaper = new TopicMapper(context);
		// Insert WordList into database
		for (Word aWord : addList){
			topicMaper.addWord(aWord);
		}
		
		Log.d("Insert Word", "Word");
	}
	
	public void insertTestdata(){
		TopicMapper tm = new TopicMapper(context);
		
		Topic testTopic = new Topic(100, "test", "test", null);
		tm.add(testTopic);
		
		Word test1 = new Word("test1", "test1", "test1", "test1", "test1", 1, testTopic, 2);
		Word test2 = new Word("test2", "test2", "test2", "test2", "test2", 1, testTopic, 5);
		Word test3 = new Word("test3", "test3", "test3", "test3", "test3", 1, testTopic, 1);
		List<Word> addList = new ArrayList<Word>();
		 addList.add(test1);
		 addList.add(test2);
		 addList.add(test3);
		 
		 for (Word aWord : addList){
			 tm.addTestWord(aWord);
			}
		 Log.d("Insert test data", "insert test data");
	}
	
}
