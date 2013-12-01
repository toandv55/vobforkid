package vob.lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

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
		AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_HOLO_LIGHT);
		
		builder.setMessage(message).setTitle(title);
		// Add the buttons
		builder.setPositiveButton(ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				((Activity) context).finish();
			}
		});
		//builder.create().set
		AlertDialog dialog = builder.create();
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
	}
}
