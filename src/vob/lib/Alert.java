package vob.lib;

import android.app.AlertDialog;
import android.content.Context;

public class Alert {

	Context context;
	String message;
	
	public Alert(Context context, String message) {
		
		this.context = context;
		this.message = message;		
	}
	
	public void show() {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setPositiveButton("OK", null);
		builder.setMessage(message);
		builder.create().show();
	}
	
}
