package vob.lib;

import java.util.List;

import vob.activity.R;
import vob.model.Word;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PageFragment extends Fragment {
	
	public static Context mcontext;
	
	public static List<Word> listWord;
	public static PageFragment newInstance(Context context, List<Word> list, int index) {
		PageFragment pageFragment = new PageFragment();
		listWord = list;
		mcontext = context;
		Bundle bundle = new Bundle();
	    bundle.putInt("index", index);
	    pageFragment.setArguments(bundle);
		return pageFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 final Word word = listWord.get(getArguments().getInt("index"));
		 
		 View view = inflater.inflate(R.layout.review_fragment_content, container, false);
		 
		 ImageView imageView = (ImageView) view.findViewById(R.id.image);		 
		 TextView tv = (TextView)view.findViewById(R.id.description);
		 
		 imageView.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
	        	 MediaPlayer mp = new MediaPlayer();
	        	 mp = MediaPlayer.create(mcontext, ResourceR.getRaw(mcontext, word.getAudioURL()));  
	             mp.start();
			}
		});
		 
		
		 
		 imageView.setImageResource(ResourceR.getDrawable(mcontext, word.getImageURL()));
		 tv.setText("/" + word.getPhonetic() + "/\n" + word.getMeaning());
		 
		return view;
	}
}
