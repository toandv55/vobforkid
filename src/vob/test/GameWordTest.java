package vob.test;

import vob.game.GameWord;
import vob.model.Word;

public class GameWordTest {
	
	//check s1 in s2 (s2 have all character s1)
	private boolean checkIn(String s1, String s2) {
		
		int[] count1 = new int[200];
		int[] count2 = new int[200];
		for(int i = 0; i < count1.length; i++) {
			count1[i] = count2[i] = 0;
		}
		
		for(int i = 0; i < s1.length(); i++) {
			count1[(int) s1.charAt(i)]++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			count2[(int) s2.charAt(i)]++;
		}
		
		for(int i = 0; i < count1.length; i++) {
			if(count1[i] < count2[i]) return false;
		}
		return true;
	}
	
	public boolean test0() {
		GameWord wordGame = new GameWord(new Word("play", null, null, null, null, null), 0);
		if(false == "____".equals(wordGame.getSelected())) return false;
		if(4 != (wordGame.getToSelect().length())) return false;
		if(false == checkIn(wordGame.getWord(), wordGame.getToSelect())) return false;
		return true;
	}
	
	public boolean test1() {
		GameWord wordGame = new GameWord(new Word("play", null, null, null, null, null), 1);
		if(false == "____".equals(wordGame.getSelected())) return false;
		if(5 != (wordGame.getToSelect().length())) return false;
		if(false == checkIn(wordGame.getWord(), wordGame.getToSelect())) return false;
		return true;
	}
	
	public boolean test2() {
		GameWord wordGame = new GameWord(new Word("play", null, null, null, null, null), 2);
		if(false == "____".equals(wordGame.getSelected())) return false;
		if(6 != (wordGame.getToSelect().length())) return false;
		if(false == checkIn(wordGame.getWord(), wordGame.getToSelect())) return false;
		return true;
	}
	
	public boolean test() {
		if(test0()) {
			return true;
		} else {
			return false;
		}
	}
}
