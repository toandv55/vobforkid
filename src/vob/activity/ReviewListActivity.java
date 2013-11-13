package vob.activity;

import java.util.ArrayList;
import java.util.List;

import vob.lib.GetImage;
import vob.model.Topic;
import vob.model.Word;
import vob.orm.TopicMapper;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ReviewListActivity extends Activity {
	private List<Word> listWord;
	private int idTopic;
	
	private void init() {
		
		Bundle bundle = getIntent().getExtras();		
		idTopic = bundle.getInt("idTopic");
		
		List<Word> allWord;
		//new Alert(this, "" + idTopic).show();
		if(idTopic == -1) {
			TopicMapper topicMapper = new TopicMapper(this);
			allWord = topicMapper.getAllWord();
			
		} else {
			TopicMapper topicMapper = new TopicMapper(this);
			List<Topic> listTopic = topicMapper.getAllTopics();
			
			Topic topicCurrent = null;
			
			for(Topic t : listTopic) {
				if(t.getId() == idTopic) {
					topicCurrent = t;
					break;
				}
			}
			
			allWord = topicCurrent.getWordList();
		}
		
		listWord  = new ArrayList<Word>();
		
		
		for(Word w : allWord) {
			//Log.d("list animal", w.getWord());
			if(w.getIslearned() > 0) {
				listWord.add(w);
			}
		}
		
	}
	
	private void initView() {
		
		ListView listView = (ListView) findViewById(R.id.list_view);
		RowListWordAdapter RLUAdapter = new RowListWordAdapter(this, listWord, idTopic);
      	listView.setAdapter(RLUAdapter);
      	
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review_menu);
		
		init();
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.review_menu, menu);
		return true;
	}

}

class RowListWordAdapter extends ArrayAdapter<String> {
	
	Activity context;
	List<Word> listWord;
	int idTopic;
	
	public RowListWordAdapter(Activity context, List<Word> listWord, int idTopic) {		
		super(context, R.layout.review_menu_list_view_content, new String[listWord.size()]);
		this.context = context;
		this.listWord = listWord;
		this.idTopic = idTopic;
	}
	
	//getView
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row = null;
			
		final Word word = listWord.get(position);
		
		LayoutInflater inflater = context.getLayoutInflater();
		row = inflater.inflate(R.layout.review_menu_list_view_content, null);
		
		ImageView imageView = (ImageView) row.findViewById(R.id.image);
		imageView.setImageResource(GetImage.getDrawable(context, word.getImageURL()));
		
		
		TextView tvRow = (TextView) row.findViewById(R.id.tvViewRow);
		tvRow.setText("/" + word.getPhonetic() + "/\n" + word.getMeaning());
		tvRow.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				Intent intent = new Intent(context, ReviewActivity.class);
	        	Bundle bundle = new Bundle();
	        	bundle.putInt("idTopic", idTopic);
	        	bundle.putString("word", word.getWord());
	        	intent.putExtras(bundle);
	        	context.startActivity(intent);
			}
		});
		
		
		Button btnDelete = (Button) row.findViewById(R.id.delete);
		btnDelete.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				//new Alert(context, "delete");
				TopicMapper topicMapper = new TopicMapper(context);
				topicMapper.updateLearned(word, 0);
				Intent intent = new Intent(context, ReviewListActivity.class);				
	        	Bundle bundle = new Bundle();
	        	bundle.putInt("idTopic", idTopic);
	        	intent.putExtras(bundle);
	        	context.startActivity(intent);
	        	context.finish();
			}
		});
		
		return row;
	}
}
