package com.lemilliard.mapper;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lemilliard.mapper.Mapper.normalizeString;

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

	public boolean isPresentInPhrase(String phrase) {
		boolean present = doesPhraseContainsWord(phrase, value);
		int i = 0;
		while (i < matches.size() && !present) {
			if (doesPhraseContainsWord(phrase, matches.get(i))) {
				present = true;
			}
			i++;
		}
		return present;
	}

	private boolean doesPhraseContainsWord(String phrase, String word) {
		String normalizedWord = normalizeString(word);
		Pattern pattern = Pattern.compile(normalizedWord);
		Matcher matcher = pattern.matcher(phrase);
		return matcher.find();
	}
}
