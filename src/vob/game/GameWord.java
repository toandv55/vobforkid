package vob.game;

import vob.model.Word;

public class GameWord extends Word {
	private int[] posSelected;
	private String selected;
	private String toSelect;
	private int numSelected;
	private int level;
	
	public GameWord(Word word, int level) {
		//super(word);
		super(word.getWord(), word.getPhonetic(), word.getMeaning(),
				word.getImageURL(), word.getAudioURL(), word.getTopic());
		super.setIslearned(word.getIslearned());
		
		this.level = level;
		this.toSelect = this.genToSelect(word.getWord(), level);
		
		numSelected = 0;
		selected = "";
		for(int i = 0; i < word.getWord().length(); i++) {
			selected += '_';
		}
		posSelected = new int[toSelect.length()];
	}
	
	//gen to seSelect
	private String genToSelect(String word, int level) {
		
		String result = "";
		
		for(int i = 0; i < level; i++) {
			//word += (char) (97 + (int)(Math.random() * 100) % 25);
			word += (char) (97 + (int)(Math.random() * 100) % 25);
		}
		
		int length = word.length();
		boolean[] check = new boolean[length];
		for(int i = 0; i < check.length; i++) check[i] = false;
		
		for(int i = 0; i < length; i++) {
			int select = ((int) (Math.random() * 100)) % (length);
			while(check[select] == true || ( i == 0 && i == select)) {
				select = (select + 1) % length;
			}
			check[select] = true;
			result += word.charAt(select);
		}
		return result;
	}
	
	public void select(int pos) {
		if(numSelected == getWord().length()) {
			numSelected -= 1; //change last character
		}
		StringBuilder sbuilder = new StringBuilder(selected);
		sbuilder.replace(numSelected, numSelected + 1, "" + toSelect.charAt(pos));
		selected = sbuilder.toString();
		posSelected[numSelected++] = pos;
	}
	
	//remove character i from selected
	public void remove(int pos) {
		
		if(pos >= numSelected) return;
		
		StringBuilder sbuilder = new StringBuilder(selected);
		sbuilder.replace(pos, numSelected, "__________".substring(0, numSelected - pos));
		numSelected -= (numSelected - pos);
		
		selected = sbuilder.toString();		
	}
	
	public boolean[] showSelected() {
		boolean[] show = new boolean[selected.length()];
		for(int i = 0; i < selected.length(); i++) {
			show[i] = true;
		}
		return show;
	}
	
	public boolean[] showToSelect() {
		
		boolean[] show = new boolean[toSelect.length()];
		
		for(int i = 0; i < toSelect.length(); i++) {
			show[i] = true;
		}
		
		for(int i = 0; i < numSelected; i++) {
			show[posSelected[i]] = false;
		}
		
		return show;
	}
	
	public void guide() {
		
		int temp = -1;
		for(int i = 0; i < numSelected; i++) {
			if(this.getWord().charAt(i) == selected.charAt(i)) {
				temp = i;
			} else {
				break;
			}
		}
		numSelected = temp + 1;
		
		
		boolean canSelect[] = this.showToSelect();
		
		for(int i =  0; i < toSelect.length(); i++) {
			
			if(canSelect[i] == false) continue;
			
			if(getWord().charAt(numSelected) == toSelect.charAt(i)) {
				select(i);
				break;
			}
		}
	}
	
	public String getSelected() {
		return selected;
	}
	
	public String getToSelect() {
		return toSelect;
	}
	
	public boolean check() {
		return getWord().equals(selected);
	}
}
