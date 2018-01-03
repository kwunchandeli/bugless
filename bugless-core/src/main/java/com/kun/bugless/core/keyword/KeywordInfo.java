package com.kun.bugless.core.keyword;

public class KeywordInfo {
	private String keywordName;
	private String description;

	public KeywordInfo(String keywordName, String description) {
		this.keywordName = keywordName;
		this.description = description;
	}

	public String getKeywordName() {
		return keywordName;
	}

	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
