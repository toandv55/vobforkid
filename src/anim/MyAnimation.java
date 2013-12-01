package anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class MyAnimation {
	
	public static ObjectAnimator fadeOut(View v, float alpha, int duration, int repeat) {	
		ObjectAnimator oba = ObjectAnimator.ofFloat(v, "alpha", alpha);
		oba.setDuration(duration);
		oba.setRepeatCount(repeat);
		return oba;
	}
	
	public static ObjectAnimator fadeIn(View v, float alpha1, float alpha2, int duration, int repeat) {
		ObjectAnimator oba = ObjectAnimator.ofFloat(v, "alpha", alpha1, alpha2);
		oba.setDuration(duration);
		oba.setRepeatCount(repeat);
		return oba;
	}
		
	public static ObjectAnimator moverX(View v, float begin, float end, int duration, int repeat) {
		ObjectAnimator oba = ObjectAnimator.ofFloat(v, "translationX", begin, end);
		oba.setDuration(duration);
		oba.setRepeatCount(repeat);
		return oba;
	}
	
	public static ObjectAnimator moverY(View v, float begin, float end, int duration, int repeat) {
		ObjectAnimator oba = ObjectAnimator.ofFloat(v, "translationY", begin, end);
		oba.setDuration(duration);
		oba.setRepeatCount(repeat);
		return oba;
	}
	
	public static ObjectAnimator rotation(View v, int duration) {
		ObjectAnimator oba = ObjectAnimator.ofFloat(v, "rotation", 0);
	    oba.setDuration(duration);
	    return oba;
	}
	
	public static AnimatorSet animatorSet(ObjectAnimator[] with, ObjectAnimator[] after) {
		AnimatorSet ans = new AnimatorSet();
		//ans.playSequentially(after);
		ans.playTogether(with);
		ans.setDuration(20000);
		//ans.playSequentially(after);
		return ans;
	}
	
	public static void start(ObjectAnimator oba) {
		oba.start();
	}
	
	public static void start(AnimatorSet ans) {
		ans.start();
	}
}
