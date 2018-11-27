package com.lemilliard.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Kint
 */
class Dictionary {

	private String type;
	private List<Word> words;

	String getType() {
		return type;
	}

	List<Word> getMatches(String phrase) {
		List<Word> matches = new ArrayList<>();
		for (Word word : words) {
			if (word.isPresentInPhrase(phrase)) {
				matches.add(word);
			}
		}
		return matches;
	}
}
