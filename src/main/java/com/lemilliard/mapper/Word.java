package com.lemilliard.mapper;

import java.text.Normalizer;
import java.util.List;

/**
 * @author Thomas Kint
 */
public class Word {
	private String value;
	private List<String> matches;

	public String getValue() {
		return value;
	}

	public List<String> getMatches() {
		return matches;
	}

	public boolean doesMatchWord(String word) {
		boolean match = doesWordsMatch(word, value);
		int i = 0;
		while (i < matches.size() && !match) {
			if (doesWordsMatch(word, matches.get(i))) {
				match = true;
			}
			i++;
		}
		return match;
	}

	private boolean doesWordsMatch(String word1, String word2) {
		return normalizeWord(word1).equals(normalizeWord(word2));
	}

	private String normalizeWord(String word) {
		return Normalizer
				.normalize(word.toLowerCase(), Normalizer.Form.NFD)
				.replaceAll("[\u0300-\u036F]", "");
	}
}
