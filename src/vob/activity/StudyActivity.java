package vob.activity;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import vob.game.CurrentGame;
import vob.game.GameWord;
import vob.lib.*;
import vob.model.Word;
import vob.orm.TopicMapper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import anim.MyAnimation;

public class StudyActivity extends Activity {
	
	private List<Word> listWord;
	private int currentWord;
	private GameWord gameWord;
	private int scoreForWord = 0;
	private int[] pos;
	private Timer time;
	
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
			selected[ran] = true;
		}
	}
	
	private void initView() {
		
		final ImageView pause  = (ImageView) findViewById(R.id.pause);
		pause.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(time.isRunning() == true) {
					time.stop();
					pause.setImageResource(ResourceR.getDrawable(StudyActivity.this, "pause_icon"));
				} else {
					time.startCountDown();
					pause.setImageResource(ResourceR.getDrawable(StudyActivity.this, "continue_icon"));
				}
				pause.startAnimation(AnimationUtils.loadAnimation(StudyActivity.this, R.anim.zoom_out));
			}
		});
		
		final ImageView listen = (ImageView) findViewById(R.id.listen);
		listen.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				listen();
				listen.startAnimation(AnimationUtils.loadAnimation(StudyActivity.this, R.anim.zoom_out));
			}
		});
		
		//ignore button
		final ImageView ignore = (ImageView) findViewById(R.id.ignore);
		ignore.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {			
				ignore();
				ignore.startAnimation(AnimationUtils.loadAnimation(StudyActivity.this, R.anim.zoom_out));
			}
		});
		
		//guide button
		final ImageView guide = (ImageView) findViewById(R.id.guide);
		guide.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				guide();
				guide.startAnimation(AnimationUtils.loadAnimation(StudyActivity.this, R.anim.zoom_out));
			}
		});
		
		TextView tvTime = (TextView) findViewById(R.id.time);
		tvTime.setText("Thời gian : " + CurrentGame.timePlay / 60 / 1000 + ":00");
		
		TextView tvScore = (TextView) findViewById(R.id.score);
		tvScore.setText("Điểm : 0");
		
		final ImageView add_score = (ImageView) findViewById(R.id.add_score);
		add_score.setVisibility(View.INVISIBLE);
	}
	
	private void init() {
		
		Bundle bundle = getIntent().getExtras();
        
        int topicId = bundle.getInt("idTopic");
        
        TopicMapper topicMapper = new TopicMapper(this);
        
        if(topicId == -1) {
        	listWord = topicMapper.getAllWord();
        } else {
        	listWord = topicMapper.getATopicWithWord(topicId).getWordList();
        }
                        
        //set time
        time = new Timer(this, (TextView) findViewById(R.id.time));
        time.setTimeHave(CurrentGame.timePlay);
        time.startCountDown();
        
        genPos();
        
        currentWord = -1;
        next();
        CurrentGame.scoreTotal = 0;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_study);
		initView();
		init();
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.study, menu);
		return true;
	}
	
	
	private void showImage() {
		ImageView image = (ImageView) findViewById(R.id.image);
		image.setImageResource(ResourceR.getDrawable(this, gameWord.getImageURL()));
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
	        	
	        	checkWord();
	        	
	        	update();
	        }
	    });
		
		TextView tvscoreTotal = (TextView) findViewById(R.id.score);
		tvscoreTotal.setText("Điểm : " + CurrentGame.scoreTotal);
	}
	
	private void listen() {
		
        try {
        	 MediaPlayer mp = new MediaPlayer();
        	 mp = MediaPlayer.create(this, ResourceR.getRaw(this, gameWord.getAudioURL()));        	 
             mp.start();
        } catch(Exception e) {
        	
        }
	}
	
	private void ignore() {
		if(CurrentGame.scoreTotal > 5) {
			CurrentGame.scoreTotal -= 5;
			final ImageView add_score = (ImageView) findViewById(R.id.add_score);
    		add_score.setVisibility(View.VISIBLE);
    		add_score.setImageResource(ResourceR.getDrawable(this, "app_sub_5"));
    		ObjectAnimator oba1 = MyAnimation.moverY(add_score, 0, -100, 5000, 0);
    		ObjectAnimator oba2 = MyAnimation.fadeOut(add_score, 0, 4000, 0);
    		AnimatorSet ans = new AnimatorSet();
    		ans.play(oba1).with(oba2);
    		ans.setDuration(5000);
    		ans.start();
    		//MyAnimation.start(MyAnimation.moverY(add_score, 0, -100, 5000, 0));
		}
		next();
	}
	
	//next word
	private void next() {
		
		currentWord++;
		
		while(currentWord < listWord.size() - 1 && (listWord.get(pos[currentWord]).getWord().length() > 4 + 2 * CurrentGame.level
				|| listWord.get(pos[currentWord]).getWord().length() < 2 + CurrentGame.level)) {
			currentWord++;
		}		
		
		if(currentWord >= listWord.size() - 1) {
			time.stop();
			new FinishDialog(this, "Đã hết từ", "Chúc mừng bạn đã đạt được " + CurrentGame.scoreTotal + " điểm").show();
			return;
		}
		
		gameWord = new GameWord(listWord.get(pos[currentWord]), CurrentGame.level);
		
		scoreForWord = gameWord.getWord().length() * 10;
		
		//set this word is leared at time
		int time = Calendar.DATE * 24 * 60 * 60 + Calendar.MILLISECOND / 1000;
		
		TopicMapper topicMapper = new TopicMapper(this);
		topicMapper.updateLearned(listWord.get(pos[currentWord]), 1);
		topicMapper.updateLearnDate(listWord.get(pos[currentWord]), time);
		//topicMapper.updateLearnDate(aWord, value)
		
		showImage();
		showDescription();
		update();
	}
	
	private void checkWord() {
		if(gameWord.check() == true) {
    		if(scoreForWord < 0) scoreForWord = 0;
    		//new Alert(StudyActivity.this, "Chúc mừng bạn đã chọn đúng!\n Điểm cộng " + scoreForWord).show();
    		CurrentGame.scoreTotal += scoreForWord;
    		
    		final ImageView add_score = (ImageView) findViewById(R.id.add_score);
    		add_score.setVisibility(View.VISIBLE);
    		add_score.setImageResource(ResourceR.getDrawable(this, "app_add_" + scoreForWord));
    		MyAnimation.start(MyAnimation.moverY(add_score, 0, -100, 5000, 0));
    		
    		next();    		
    		
    		//new Alert(this, "score").show();
    	}
	}
	
	//guide a character
	private void guide() {
		
		gameWord.guide();
		
		scoreForWord -= 15;
		
		checkWord();
		
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
				imageView.setImageResource(ResourceR.getDrawable(mContext, "" + content.charAt(position)));
			} else {
				imageView.setImageResource(ResourceR.getDrawable(mContext, "hoi"));
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