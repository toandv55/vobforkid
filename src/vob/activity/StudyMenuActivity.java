package vob.activity;

import java.util.List;

import vob.lib.Alert;
import vob.lib.InsertSomeData;
import vob.lib.ResourceR;
import vob.model.Topic;
import vob.orm.DatabaseMapper;
import vob.orm.TopicMapper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class StudyMenuActivity extends Activity {

	private List<Topic> listTopic;
	
	private void init() {
		TopicMapper topicMapper = new TopicMapper(this);
        listTopic = topicMapper.getAllTopicOnlySort();
        
        Topic allTopic = new Topic(-1, "all topic", "add_topic", null);
        listTopic.add(0, allTopic);
	}
	
	private void initView() {
		GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new TopicAdapter(this, listTopic));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	//new Alert(StudyMenuActivity.this, "" + position).show();
	        	Intent intent = new Intent(StudyMenuActivity.this, StudyActivity.class);
	        	Bundle bundle = new Bundle();
	        	bundle.putInt("idTopic", listTopic.get(position).getId());
	        	intent.putExtras(bundle);
	        	//new Alert(StudyMenuActivity.this, "" + listTopic.get(position).getId()).show();
	        	startActivity(intent);
	        }
	    });
	    
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_study_menu);
		
		init();
		initView();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.study_menu, menu);
		return true;
	}

	private class TopicAdapter extends ArrayAdapter<String> {
		private Context context;
		List<Topic> listTopic;
		/*
		 * private String[] numberTopic = { "Chủ đề 1", "Chủ đề 2", "Chủ đề 3",
		 * "Chủ đề 4", "Chủ đề 5", "Chủ đề 6", };
		 */
		public TopicAdapter(Context context, List<Topic> listTopic) {
			super(context, R.layout.study_menu_grid_view_content, new String[listTopic.size()]);
			this.context = context;
			this.listTopic = listTopic;
		}


		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
	    	
	    	View view = null;
	 
			if (convertView == null) {  // if it's not recycled, initialize some attributes
				LayoutInflater inflater = ((Activity) context).getLayoutInflater();
				view = inflater.inflate(R.layout.study_menu_grid_view_content, null);
				TextView tv = (TextView)view.findViewById(R.id.textview);
				ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
				imageView.setImageResource(ResourceR.getDrawable(context, listTopic.get(position).getImageURL()));
				tv.setText(listTopic.get(position).getName());
				
			} else {
			    view = convertView;
			}
			
			return view;
	    }    

	}

}
