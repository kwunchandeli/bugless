package com.kun.bugless.core.library;

import java.util.List;

import com.kun.bugless.core.keyword.KeywordInfo;

public interface ILibrary {
	public String getLibraryClasString();
	public String getLibraryName();
	public String[] getKeywordNames();
	public boolean containKeyword(String keywordName);
	public void addKeyword(KeywordInfo keyword);
	public List<String> getKeywordList();
}
