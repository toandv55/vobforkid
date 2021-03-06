package vob.lib;

import vob.activity.R;
import vob.game.CurrentGame;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MyDialog {
	private String ok = "Đồng ý";
	private String title;
	private String message;
	private Context context;
	public MyDialog(Context context, String title, String message) {
		this.context = context;
		this.title = title;
		this.message = message;
	}
	
	public void show() {
		
		Dialog dialog = new Dialog(context);
		
		dialog.setContentView(R.layout.finish_dialog);
		dialog.setTitle(title);
		
		TextView score = (TextView) dialog.findViewById(R.id.score);
		score.setText("" + CurrentGame.scoreTotal);
		
		TextView level = (TextView) dialog.findViewById(R.id.level);
		String strLevel[] = {"Dễ", "Vừa", "Khó", "Rất khó"};
		level.setText(strLevel[CurrentGame.level]);
		
		Button ok = (Button) dialog.findViewById(R.id.ok);
		ok.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				((Activity) context).finish();
			}
		});
		
		dialog.setCanceledOnTouchOutside(false);
		
		dialog.show();
	}
}
