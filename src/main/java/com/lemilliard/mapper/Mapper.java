package com.lemilliard.mapper;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Thomas Kint
 */
public class Mapper {

	private static final String filename = "mapper.json";
	private String folder;
	private Dictionary[] dictionaries;

	public Mapper(String folder) {
		this.folder = folder;
		this.loadDictionaries();
	}

	private void loadDictionaries() {
		try {
			File file = new File(folder + "/" + filename);
			FileReader fileReader = new FileReader(file);
			Gson gson = new Gson();
			this.dictionaries = gson.fromJson(fileReader, Dictionary[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, List<String>> processPhrase(String phrase) {
		return processPhrase(phrase, getWordTypes().toArray(new String[0]));
	}

	public HashMap<String, List<String>> processPhrase(String phrase, String... wordTypes) {
		Dictionary dictionary;
		String normalizedPhrase = normalizeString(phrase);
		HashMap<String, List<String>> result = new HashMap<>();
//		List<String> phraseWords = splitPhrase(phrase);
		for (String wordType : wordTypes) {
			result.put(wordType, new ArrayList<>());
			dictionary = getDictionaryByType(wordType);
			for (Word word : dictionary.getMatches(normalizedPhrase)) {
				result.get(wordType).add(word.getValue());
			}
		}
		return result;
	}

	public List<Word> getMatchesByType(List<String> phraseWords, String wordType) {
		List<Word> matches = new ArrayList<>();
		for (String phraseWord : phraseWords) {
			matches.addAll(searchMatchesByType(phraseWord, wordType));
		}
		return matches;
	}

	public List<String> getWordTypes() {
		List<String> wordTypes = new ArrayList<>();
		for (Dictionary dictionary : dictionaries) {
			wordTypes.add(dictionary.getType());
		}
		return wordTypes;
	}

	private List<String> splitPhrase(String phrase) {
		return Arrays.asList(phrase.split(" "));
	}

	private Dictionary getDictionaryByType(String type) {
		int i = 0;
		Dictionary dictionary = null;
		while (i < dictionaries.length && dictionary == null) {
			if (dictionaries[i].getType().equals(type)) {
				dictionary = dictionaries[i];
			}
			i++;
		}
		return dictionary;
	}

	private List<Word> searchMatchesByType(String word, String type) {
		List<Word> matches = new ArrayList<>();
		Dictionary dictionary = getDictionaryByType(type);
		if (dictionary != null) {
			for (Word dictionaryWord : dictionary.getWords()) {
				if (dictionaryWord.doesMatchWord(word)) {
					matches.add(dictionaryWord);
				}
			}
		}
		return matches;
	}

	public static String normalizeString(String phrase) {
		return Normalizer
				.normalize(phrase.toLowerCase(), Normalizer.Form.NFD)
				.replaceAll("[\u0300-\u036F]", "");
	}
}
