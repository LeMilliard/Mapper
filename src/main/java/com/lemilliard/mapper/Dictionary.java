package com.lemilliard.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Kint
 */
public class Dictionary {

	private String type;
	private List<Word> words;

	public String getType() {
		return type;
	}

	public List<Word> getWords() {
		return words;
	}

	public List<Word> getMatches(String phrase) {
		List<Word> matches = new ArrayList<>();
		for (Word word : words) {
			if (word.isPresentInPhrase(phrase)) {
				matches.add(word);
			}
		}
		return matches;
	}
}
