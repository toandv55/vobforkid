package vob.orm;

import java.util.ArrayList;
import java.util.List;

import vob.model.Topic;
import vob.model.Word;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WordMapper extends SQLiteOpenHelper {

	private static final String DB_NAME = "vobforkid";
	private static final String COLUMN_WORD = "word";
	private static final String COLUMN_MEANING = "meaning";
	private static final String COLUMN_IMAGE_URL = "imageURL";
	private static final String COLUMN_PHONETIC = " phonetic ";
	private static final String COLUMN_AUDIO_URL = "audioURL";
	private static final String COLUMN_PARENT = "topic_id";
	private static final int DATABASE_VERSION = 1;
	private static final String COLUMN_STUDIED_DATE = "studiedDate";
	private static final String TABLE_WORDS = "words";
	
	public WordMapper(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * Do nothing here Table creation in DatabaseMapper
		 */
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);

		// Recreate the table
		onCreate(db);

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
		values.put(COLUMN_STUDIED_DATE, word.getStudiedDate());

		// Inserting Row
		try {
			db.insert(TABLE_WORDS, null, values);
			db.close(); // Closing database connection

		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}

	public Word find(String word) {
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

	public Word destroy(String word) {
		return null;
	}

	public Word update(String word, Word newWord) {
		return null;
	}

	/*
	 * This method return a word corespond to ID which is word atribute of Word
	 * Object
	 */
	Word getWord(String wordspelling) {
		Cursor cursor;
		SQLiteDatabase db = getReadableDatabase();
		String getAWord = "SELECT * FROM words " + " where word='"
				+ wordspelling + "'";
		Word aword = new Word();
		try {
			cursor = db.rawQuery(getAWord, null);
			if (cursor.moveToFirst()) {
				do {

					aword.setWord(cursor.getString(0));
					aword.setPhonetic(cursor.getString(1));
					aword.setMeaning(cursor.getString(2));
					aword.setImageURL(cursor.getString(3));
					aword.setAudioURL(cursor.getString(4));
					aword.setTopicId(cursor.getInt(5));
					aword.setIslearned(cursor.getInt(6));
					aword.setStudiedDate(cursor.getLong(7));
				} while (cursor.moveToNext());
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new Word();
		}
		return aword;
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

	public List<Word> getWordListOfTopic(int id) {
		List<Word> wordsList = new ArrayList<Word>();
		Cursor cursor;
		String getAllWords = "SELECT * FROM " + TABLE_WORDS+ " WHERE topic_id='"+id+"'";;
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
}
