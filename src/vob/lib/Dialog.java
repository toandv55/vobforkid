package vob.lib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Dialog {
	private String ok = "Đồng ý";
	private String title;
	private String message;
	private Context context;
	public Dialog(Context context, String title, String message) {
		this.context = context;
		this.title = title;
		this.message = message;
	}
	
	public void show() {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		
		builder.setMessage(message).setTitle(title);
		// Add the buttons
		builder.setPositiveButton(ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				((Activity) context).finish();
			}
		});
		builder.create().show();
	}
}
