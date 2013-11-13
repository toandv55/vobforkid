package vob.model;

import java.util.ArrayList;
import java.util.List;

import vob.annotation.HasMany;
import vob.annotation.Id;
import vob.annotation.MappedWithTable;
@MappedWithTable
public class Topic {
	@Id
	private int id;
	private String name;
	private String imageURL;
	
	@HasMany(children = "Words")
	private List<Word> wordList;
	
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topic(int id, String name, String imageURL, List<Word> wordList) {
		super();
		this.id = id;
		this.name = name;
		this.imageURL = imageURL;
		this.wordList = new ArrayList<Word>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Word> getWordList() {
		return wordList;
	}
	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
