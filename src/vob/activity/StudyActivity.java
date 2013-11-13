package vob.activity;

import java.util.List;

import vob.game.GameWord;
import vob.lib.*;
import vob.model.Topic;
import vob.model.Word;
import vob.orm.TopicMapper;
import vob.test.GameWordTest;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class StudyActivity extends Activity {
	
	private List<Word> listWord;
	private int currentWord;
	private GameWord gameWord;
	private int level = 0;
	private int[] pos;
	
	private void genPos() {
		
		int size = listWord.size();
		
		pos = new int[size];
		boolean[] selected = new boolean[size];
		for(int i = 0; i < size; i++) selected[i] = false;
		
		for(int i = 0; i < size; i++) {
			int ran = (int) (Math.random() * size) % size;
			while(selected[ran] == true) {
				ran = (ran + 1) % size;
			}
			pos[i] = ran;
		}
	}
	
	private void init() {
		
		Bundle bundle = getIntent().getExtras();
		
		int topicId = bundle.getInt("idTopic");
		
		TopicMapper topicMapper = new TopicMapper(this);
		if(topicId == -1) {			
			listWord = topicMapper.getAllWord();
			
		} else {			
			List<Topic> listTopic = topicMapper.getAllTopics();
			
			Topic topicCurrent = null;
			
			for(Topic t : listTopic) {
				if(t.getId() == topicId) {
					topicCurrent = t;
					break;
				}
			}
			
			listWord = topicCurrent.getWordList();
		}
		
		currentWord = 0;
		genPos();
		
		while(listWord.get(pos[currentWord]).getWord().length() > 6 && currentWord < listWord.size()) {
			currentWord++;
		}		
		
		gameWord = new GameWord(listWord.get(pos[currentWord]), level);
				
		//update learned
		topicMapper.updateLearned(listWord.get(pos[currentWord]), 1);
		
		GameWordTest test = new GameWordTest();
		if(!test.test()) {
			new Alert(this, "gameWord err").show();
		}
		
		ImageView ignore = (ImageView) findViewById(R.id.ignore);
		ignore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ignore();				
			}
		});
		
		ImageView guide = (ImageView) findViewById(R.id.guide);
		guide.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				guide();	
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_study);
		
		init();
		
		showImage();
		showDescription();
		update();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.study, menu);
		return true;
	}
	
	
	private void showImage() {
		ImageView image = (ImageView) findViewById(R.id.image);
		image.setImageResource(GetImage.getDrawable(this, gameWord.getImageURL()));
	}
	
	private void showDescription() {
		TextView descrip = (TextView) findViewById(R.id.description);
		descrip.setText("/" + gameWord.getPhonetic() + "/\n" + gameWord.getMeaning());
	}
	
	private void update() {
		
		GridView gridSelected = (GridView) findViewById(R.id.selected);
		gridSelected.setNumColumns(gameWord.getSelected().length());
		
		ImageAdapter adapterSelected = new ImageAdapter(this, gameWord.getSelected(), gameWord.showSelected());
		gridSelected.setAdapter(adapterSelected);
		
		gridSelected.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	gameWord.remove(position);
	        	update();
	        }
	    });
		
		
		GridView gridToSelect = (GridView) findViewById(R.id.to_select);
		
		gridToSelect.setNumColumns(gameWord.getToSelect().length());
		ImageAdapter adapterToSelect = new ImageAdapter(this, gameWord.getToSelect(), gameWord.showToSelect());
		//ImageAdapter adapterToSelect = new ImageAdapter(this, copyStringArray(strToSelect, length + 1 - current), null);
		gridToSelect.setAdapter(adapterToSelect);
		gridToSelect.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	
	        	gameWord.select(position);
	        	
	        	if(gameWord.check() == true) {
	        		new Alert(StudyActivity.this, "Chúc mừng bạn đã chọn đúng!").show();
	        		ignore();
	        	}
	        	
	        	update();
	        }
	    });
	}
	
	/*
	private void pauseActivity() {
		
	}
	
	private void resumeActivity() {
		
	}
	*/
	private void ignore() {
		currentWord++;
		while(listWord.get(pos[currentWord]).getWord().length() > 6 && currentWord < listWord.size()) {
			currentWord++;
		}
		gameWord = new GameWord(listWord.get(pos[currentWord]), level);
		
		TopicMapper topicMapper = new TopicMapper(this);
		topicMapper.updateLearned(listWord.get(pos[currentWord]), 1);
		
		showImage();
		showDescription();
		update();
	}
	
	private void guide() {
		
		gameWord.guide();
		
		if(gameWord.check() == true) {
    		new Alert(StudyActivity.this, "true").show();
    		ignore();
    	}
		//showImage();
		//showDescription();
		update();
	}

}

/*Adapter for this Activity*/
class ImageAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private String content;
    private boolean[] show;

    public ImageAdapter(Context c, String content, boolean[] show) {
        super(c, R.drawable.image, new String[content.length()]);

        mContext = c;
        this.content = content;
        this.show = show;
    }
    
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	
    	ImageView imageView;
 
		if (convertView == null) {  // if it's not recycled, initialize some attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(2, 2, 2, 2);
			//imageView.setImageResource(R.drawable.z);
			if(content.charAt(position) != '_') {
				imageView.setImageResource(GetImage.getDrawable(mContext, "" + content.charAt(position)));
			} else {
				imageView.setImageResource(GetImage.getDrawable(mContext, "hoi"));
			}
		} else {
		    imageView = (ImageView) convertView;
		}
		if(show[position] == false) {
			//imageView.se
			imageView.setVisibility(View.INVISIBLE);
		}
		return imageView;
    }    
   
}