package vob.orm;

import java.util.ArrayList;
import java.util.List;

import vob.lib.Alert;
import vob.model.Topic;
import vob.model.Word;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TopicMapper extends SQLiteOpenHelper {
	private Context context;
	private static String DB_NAME = "vobforkid";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_TOPICS = "topics";
	private static final String TABLE_WORDS = "words";

	private static final String COLUMN_TOPIC_ID = "id";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_IMAGE_URL = "imageURL";

	private static final String COLUMN_WORD = "word";
	private static final String COLUMN_MEANING = "meaning";
	private static final String COLUMN_PHONETIC = " phonetic ";
	private static final String COLUMN_AUDIO_URL = "audioURL";
	private static final String COLUMN_PARENT = "topic_id";
	private static final String COLUMN_LEARNED = "islearned";
	private static final String COLUMN_STUDIED_DATE = "studiedDate";

	public TopicMapper(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TOPICS_TABLE = "CREATE TABLE " + TABLE_TOPICS + "("
				+ COLUMN_TOPIC_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME
				+ " TEXT," + COLUMN_IMAGE_URL + " TEXT" + ")";

		String CREATE_WORDS_TABLE = "CREATE TABLE " + TABLE_WORDS + "("
				+ COLUMN_WORD + " TEXT PRIMARY KEY," + COLUMN_PHONETIC
				+ " TEXT," + COLUMN_MEANING + " TEXT," + COLUMN_IMAGE_URL
				+ " TEXT," + COLUMN_AUDIO_URL + " TEXT," + COLUMN_PARENT
				+ " INTEGER," + COLUMN_LEARNED + " INTEGER,"
				+ COLUMN_STUDIED_DATE + " INTEGER" + ")";
		db.execSQL(CREATE_WORDS_TABLE);
		db.execSQL(CREATE_TOPICS_TABLE);
		new Alert(context, "onCreate").show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOPICS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
		// Recreate the table
		onCreate(db);

	}

	public Topic add(Topic topic) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_TOPIC_ID, topic.getId());
		values.put(COLUMN_NAME, topic.getName());
		values.put(COLUMN_IMAGE_URL, topic.getImageURL());

		// Inserting Row
		db.insert(TABLE_TOPICS, null, values);
		db.close(); // Closing database connection

		return topic;
	}

	public Word addWord(Word word) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_WORD, word.getWord());
		values.put(COLUMN_PHONETIC, word.getPhonetic());
		values.put(COLUMN_MEANING, word.getMeaning());
		values.put(COLUMN_IMAGE_URL, word.getImageURL());
		values.put(COLUMN_AUDIO_URL, word.getAudioURL());
		values.put(COLUMN_PARENT, word.getTopic().getId());
		values.put(COLUMN_LEARNED, word.getIslearned());

		// Inserting Row

		db.insert(TABLE_WORDS, null, values);
		db.close(); // Closing database connection

		return word;
	}
	
	public Word addTestWord(Word word) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_WORD, word.getWord());
		values.put(COLUMN_PHONETIC, word.getPhonetic());
		values.put(COLUMN_MEANING, word.getMeaning());
		values.put(COLUMN_IMAGE_URL, word.getImageURL());
		values.put(COLUMN_AUDIO_URL, word.getAudioURL());
		values.put(COLUMN_PARENT, word.getTopic().getId());
		values.put(COLUMN_LEARNED, word.getIslearned());
		values.put(COLUMN_STUDIED_DATE, word.getStudiedDate());

		// Inserting Row

		db.insert(TABLE_WORDS, null, values);
		db.close(); // Closing database connection

		return word;
	}
	public Topic find(String id) {
		return null;
	}

	public List<Word> getAllWord() {
		List<Word> wordsList = new ArrayList<Word>();
		Cursor cursor;
		String getAllWords = "SELECT * FROM " + TABLE_WORDS;
		SQLiteDatabase db = this.getWritableDatabase();

		// fetch the result set in to Word List
		cursor = db.rawQuery(getAllWords, null);
		if (cursor.moveToFirst()) {
			do {
				Word aword = new Word();
				aword.setWord(cursor.getString(0));
				aword.setPhonetic(cursor.getString(1));
				aword.setMeaning(cursor.getString(2));
				aword.setImageURL(cursor.getString(3));
				aword.setAudioURL(cursor.getString(4));
				aword.setTopicId(cursor.getInt(5));
				aword.setIslearned(cursor.getInt(6));
				aword.setStudiedDate(cursor.getLong(7));

				wordsList.add(aword);
			} while (cursor.moveToNext());
		}

		return wordsList;
	}

	public List<Word> getWordListOfTopic(int id) {
		List<Word> wordsList = new ArrayList<Word>();
		Cursor cursor;
		String getAllWords = "SELECT * FROM " + TABLE_WORDS
				+ " WHERE topic_id='" + id + "'";
		;
		SQLiteDatabase db = this.getWritableDatabase();

		// fetch the result set in to Word List
		cursor = db.rawQuery(getAllWords, null);
		if (cursor.moveToFirst()) {
			do {
				Word aword = new Word();
				aword.setWord(cursor.getString(0));
				aword.setPhonetic(cursor.getString(1));
				aword.setMeaning(cursor.getString(2));
				aword.setImageURL(cursor.getString(3));
				aword.setAudioURL(cursor.getString(4));
				aword.setTopicId(cursor.getInt(5));
				aword.setIslearned(cursor.getInt(6));
				aword.setStudiedDate(cursor.getLong(7));

				wordsList.add(aword);
			} while (cursor.moveToNext());
		}

		return wordsList;
	}
	
	public List<Topic> getAllTopicsOnly() {
		List<Topic> topicsList = new ArrayList<Topic>();
		Cursor cursor;
		String getAllTopics = "SELECT * FROM " + TABLE_TOPICS;
		SQLiteDatabase db = this.getWritableDatabase();

		// fetch the result set into Topic List
		cursor = db.rawQuery(getAllTopics, null);
		if (cursor.moveToFirst()) {
			do {
				Topic atopic = new Topic();
				atopic.setId(cursor.getInt(0));
				atopic.setName(cursor.getString(1));
				atopic.setImageURL(cursor.getString(2));
				atopic.setWordList(null);

				topicsList.add(atopic);
			} while (cursor.moveToNext());
		}
		return topicsList;
	}

	public List<Topic> getAllTopics() {
		List<Topic> topicsList = new ArrayList<Topic>();
		List<Word> wordsList = new ArrayList<Word>();
		Cursor cursor;
		String getAllTopics = "SELECT * FROM " + TABLE_TOPICS;
		String getAllWords = "SELECT * FROM " + TABLE_WORDS;
		SQLiteDatabase db = this.getWritableDatabase();

		// fetch the result set into Topic List
		cursor = db.rawQuery(getAllTopics, null);
		if (cursor.moveToFirst()) {
			do {
				Topic atopic = new Topic();
				atopic.setId(cursor.getInt(0));
				atopic.setName(cursor.getString(1));
				atopic.setImageURL(cursor.getString(2));
				atopic.setWordList(null);

				topicsList.add(atopic);
			} while (cursor.moveToNext());
		}

		wordsList = getAllWord();

		for (Topic aTopic : topicsList) {
			aTopic.setWordList(new ArrayList<Word>());
		}

		// get the wordList of each topic sdfsdf
		for (Topic aTopic : topicsList) {
			for (Word aWord : wordsList) {
				if (aTopic.getId() == aWord.getTopicId()) {
					aTopic.getWordList().add(aWord);
				}
			}
		}

		return topicsList;
	}

	public Word updateLearned(Word aWord, int value) {
		aWord.setIslearned(value);
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = "update words set islearned= " + value + " where word='"
				+ aWord.getWord() + "'";
		Log.d(sql, "toan");
		db.execSQL(sql);
		return aWord;
	}

	public Word deleteWord(Word aWord) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_WORDS, COLUMN_WORD + " = ?",
				new String[] { String.valueOf(aWord.getWord()) });
		return aWord;
	}

	public Topic deleteTopic(Topic aTopic) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_TOPICS, COLUMN_TOPIC_ID + " = ?",
				new String[] { String.valueOf(aTopic.getId()) });
		return aTopic;
	}

	public Topic destroy(String id) {
		return null;
	}

	public Topic update(String id, Topic newTopic) {
		return null;
	}

	// get specific topic without word
	public Topic getTopicOnly(int id) {
		Cursor cursor;
		SQLiteDatabase db = getReadableDatabase();
		String sql = "SELECT * FROM " + TABLE_TOPICS + " WHERE id='" + id + "'";
		Topic atopic = new Topic();
		cursor = db.rawQuery(sql, null);
		if (cursor.moveToFirst()) {
			do {

				atopic.setId(cursor.getInt(0));
				atopic.setName(cursor.getString(1));
				atopic.setImageURL(cursor.getString(2));
				atopic.setWordList(null);
			} while (cursor.moveToNext());
		}
		return atopic;
	}

	// get specific topic with its wordList
	public Topic getATopicWithWord(int id) {
		Topic atopic = new Topic();
		List<Word> wordList = new ArrayList();

		atopic = getTopicOnly(id);
		wordList = getWordListOfTopic(id);
		atopic.setWordList(wordList);

		return atopic;
	}

	// get the learned wordList of a topic sorted by time
	public Topic getReviewTopic(int id) {
		Topic reviewTopic = new Topic();

		Cursor cursor;
		List<Word> wordList = new ArrayList<Word>();
		String getAllWords = "SELECT * FROM " + TABLE_WORDS
				+ " WHERE topic_id='" + id + "'" + " AND islearned ='1'"
				+ " ORDER BY "
				+ COLUMN_STUDIED_DATE + " DESC";
		SQLiteDatabase db = this.getWritableDatabase();

		// fetch the result set in to Word List
		cursor = db.rawQuery(getAllWords, null);
		if (cursor.moveToFirst()) {
			do {
				Word aword = new Word();
				aword.setWord(cursor.getString(0));
				aword.setPhonetic(cursor.getString(1));
				aword.setMeaning(cursor.getString(2));
				aword.setImageURL(cursor.getString(3));
				aword.setAudioURL(cursor.getString(4));
				aword.setTopicId(cursor.getInt(5));
				aword.setIslearned(cursor.getInt(6));
				aword.setStudiedDate(cursor.getLong(7));

				wordList.add(aword);
			} while (cursor.moveToNext());
		}
		reviewTopic.setWordList(wordList);
		return reviewTopic;
	}
	/*
	// get the learned wordList of a topic limit by input parameter
	public Topic getReviewTopic(int id, int limit) {
		
		Topic reviewTopic = new Topic();

		Cursor cursor;
		List<Word> wordList = new ArrayList<Word>();
		String getAllWords = "SELECT * FROM " + TABLE_WORDS
				+ " WHERE topic_id='" + id + "'" + " LIMIT " + limit ;
		SQLiteDatabase db = this.getWritableDatabase();

		// fetch the result set in to Word List
		cursor = db.rawQuery(getAllWords, null);
		if (cursor.moveToFirst()) {
			do {
				Word aword = new Word();
				aword.setWord(cursor.getString(0));
				aword.setPhonetic(cursor.getString(1));
				aword.setMeaning(cursor.getString(2));
				aword.setImageURL(cursor.getString(3));
				aword.setAudioURL(cursor.getString(4));
				aword.setTopicId(cursor.getInt(5));
				aword.setIslearned(cursor.getInt(6));
				aword.setStudiedDate(cursor.getLong(7));

				wordList.add(aword);
			} while (cursor.moveToNext());
		}
		reviewTopic.setWordList(wordList);
		return reviewTopic;
	}
	*/
	public Word updateLearnDate(Word aWord, long value) {
		aWord.setStudiedDate(value);
		SQLiteDatabase db = this.getWritableDatabase();
		
		String sql = "update words set studiedDate= " + value + " where word ='"
				+ aWord.getWord()+ "'";
		
		Log.d(sql, "Update StudiedDate");
		db.execSQL(sql);
		return aWord;
	}

	public static void main(String[] arg0) {

	}

	/* Getter and Setter block */
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

}
