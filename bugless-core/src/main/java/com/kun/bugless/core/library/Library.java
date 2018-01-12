package com.kun.bugless.core.library;

import java.util.ArrayList;
import java.util.List;

import com.kun.bugless.core.keyword.KeywordInfo;

public class Library implements ILibrary {
	private String libraryNameString;
	private String libraryClasString;
	private List<KeywordInfo> keywords = new ArrayList<KeywordInfo>();

	public Library(String libraryNameString,String libraryClasString) {
		this.libraryNameString = libraryNameString;
		this.libraryClasString = libraryClasString;
	}

	public String getLibraryName() {
		return this.libraryNameString;
	}
	
	public String getLibraryClasString() {
		return libraryClasString;
	}

	public void setLibraryClasString(String libraryClasString) {
		this.libraryClasString = libraryClasString;
	}

	public List<String> getKeywordList(){
		List<String> list = new ArrayList<String>();
		for(KeywordInfo info : keywords){
			list.add(info.getKeywordName());
		}
		return list;
	}
	
	public String[] getKeywordNames() {
		List<String> list = this.getKeywordList();
		int size =list.size();
		return list.toArray(new String[size]);
	}

	public boolean containKeyword(String keywordName) {
		return this.getKeywordList().contains(keywordName);
	}

	public void addKeyword(KeywordInfo keyword) {
		keywords.add(keyword);
	}

}
