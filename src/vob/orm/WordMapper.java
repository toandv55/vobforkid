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

public class WordMapper extends SQLiteOpenHelper {

	private static final String DB_NAME = "vobforkid";
	private static final String COLUMN_WORD = "word";
	private static final String COLUMN_MEANING = "meaning";
	private static final String COLUMN_IMAGE_URL = "imageURL";
	private static final String COLUMN_PHONETIC = " phonetic ";
	private static final String COLUMN_AUDIO_URL = "audioURL";
	private static final String COLUMN_PARENT = "topic_id";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_WORDS = "words";

	public WordMapper(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_WORDS_TABLE = "CREATE TABLE " + TABLE_WORDS + "("
				+ COLUMN_WORD + " TEXT PRIMARY KEY," + COLUMN_PHONETIC
				+ " TEXT, " + COLUMN_MEANING + " TEXT," + COLUMN_IMAGE_URL
				+ " TEXT," + COLUMN_AUDIO_URL + " TEXT" + COLUMN_PARENT
				+ " INTEGER " + ")";
		db.execSQL(CREATE_WORDS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);

		// Recreate the table
		onCreate(db);

	}

	public Word addWord( Word word ) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_WORD, word.getWord());
		values.put(COLUMN_PHONETIC , word.getPhonetic());
		values.put(COLUMN_MEANING, word.getMeaning());
		values.put(COLUMN_IMAGE_URL, word.getImageURL());
		values.put(COLUMN_AUDIO_URL, word.getAudioURL());
		values.put(COLUMN_PARENT, word.getTopic().getId());

		// Inserting Row

		db.insert(TABLE_WORDS, null, values);
		db.close(); // Closing database connection

		return word;
	}

	public Word find(String word) {
		return null;
	}

	public List<Word> all() {
		List<Word> wordList = new ArrayList<Word>();
		// Select all world
		String getAllWords = "SELECT  * FROM " + TABLE_WORDS;

		SQLiteDatabase db = this.getWritableDatabase();

		// fetch the result set in to wordList
		Cursor cursor = db.rawQuery(getAllWords, null);
		if (cursor.moveToFirst()) {
			do {
				Word aword = new Word();
				aword.setWord(cursor.getString(0));
				aword.setMeaning(cursor.getString(1));
				aword.setImageURL(cursor.getString(2));
				aword.setAudioURL(cursor.getString(3));
				aword.setPhonetic(cursor.getString(4));
				aword.setTopicId(cursor.getInt(5));

				wordList.add(aword);
			} while (cursor.moveToNext());
		}

		return wordList;
		// + "INNER JOIN " + TABLE_TOPICS
		// + " ON " + TABLE_WORDS+"."+ COLUMN_PARENT + "=" + TABLE_TOPICS + "."
		// + "id"
	}

	public Word destroy(String word) {
		return null;
	}

	public Word update(String word, Word newWord) {
		return null;
	}
}
