package vob.orm;

import vob.lib.Alert;
import vob.lib.InsertSomeData;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseMapper extends SQLiteOpenHelper {
	
	// Static Variable Declaration 
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
	private static final String COLUMN_STUDIED_DATE="studiedDate";
	
	public DatabaseMapper(Context context){
		super(context, DB_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TOPICS_TABLE = "CREATE TABLE " + TABLE_TOPICS+ " IF NOT EXISTS " 
				+ "(" + COLUMN_TOPIC_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME
				+ " TEXT," + COLUMN_IMAGE_URL + " TEXT" + ")";
		new Alert(context, "Create words").show();
		String CREATE_WORDS_TABLE = "CREATE TABLE " + TABLE_WORDS +" IF NOT EXISTS "
				+ "(" + COLUMN_WORD + " TEXT PRIMARY KEY," + COLUMN_PHONETIC
				+ " TEXT," + COLUMN_MEANING + " TEXT," + COLUMN_IMAGE_URL
				+ " TEXT," + COLUMN_AUDIO_URL + " TEXT," + COLUMN_PARENT
				+ " INTEGER," + COLUMN_LEARNED + " INTEGER," + COLUMN_STUDIED_DATE+ " INTEGER" +")";
		db.execSQL(CREATE_WORDS_TABLE);
		db.execSQL(CREATE_TOPICS_TABLE);
	//	new Alert(context, "onCreate").show();
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOPICS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
		// Recreate the table
		onCreate(db);

	}
	boolean deleteDatabase(){
		SQLiteDatabase db = this.getWritableDatabase();
		String delWordTable = "DROP TABLE IF EXISTS " + TABLE_TOPICS;
		String delTopicTable = "DROP TABLE IF EXISTS " + TABLE_WORDS;
		
		
		try {	db.execSQL(delWordTable);
				db.execSQL(delTopicTable);
			} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
		return true;
	}
	
	boolean insertData(){
		SQLiteDatabase db=this.getWritableDatabase();

		return true;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
}
