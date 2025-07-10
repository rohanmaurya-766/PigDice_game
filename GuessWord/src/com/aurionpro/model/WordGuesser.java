package com.aurionpro.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class WordGuesser {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] words = { "apple", "banana", "computer", "elephant", "guitar" };
		String word = words[new Random().nextInt(words.length)].toLowerCase();

		char[] blanks = new char[word.length()];
		Arrays.fill(blanks, '_');

		int lives = 6;
		Set<Character> guessedLetters = new HashSet<>();

		while (lives > 0 && new String(blanks).contains("_")) {
			System.out.println("\nWord: " + new String(blanks));
			System.out.println("Lives remaining: " + lives);
			System.out.print("Guess a letter: ");
			char guess = scanner.nextLine().toLowerCase().charAt(0);

			if (guessedLetters.contains(guess)) {
				System.out.println("You already guessed that letter.");
				continue;
			}

			guessedLetters.add(guess);
			boolean correct = false;

			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == guess) {
					blanks[i] = guess;
					correct = true;
				}
			}

			if (correct) {
				System.out.println("Good guess!");
			} else {
				lives--;
				System.out.println(" Wrong guess! Lost a life.");
			}
		}

		if (new String(blanks).equals(word)) {
			System.out.println("\n Congratulations! You guessed the word: " + word);
		} else {
			System.out.println("\n Game Over! The word was: " + word);
		}
	}
}
