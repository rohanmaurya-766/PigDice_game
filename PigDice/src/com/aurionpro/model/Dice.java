package com.aurionpro.model;

import java.util.Random;
import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int player1score = 0, player2score = 0;
		int turntotal, roll;
		boolean isplayer1turn = true;

		while (player1score < 100 && player2score < 100) {
			turntotal = 0;
			System.out.println("\n" + (isplayer1turn ? "Player 1" : "Player2"));

			while (true) {
				System.out.println("Roll or Hold (r/h):");
				String choice = sc.nextLine();

				if (choice.equalsIgnoreCase("r")) {
					roll = rand.nextInt(6) + 1;
					System.out.println("You rolled:" + roll);
					if (roll == 1) {
						turntotal = 0;
						System.out.println("Oops! Rolled 1. Reset!!");
						break;
					} else {
						turntotal += roll;
						System.out.println("Total turn:" + turntotal);
					}
				} else if (choice.equalsIgnoreCase("h")) {
					if (isplayer1turn) {
						player1score += turntotal;
					} else {
						player2score += turntotal;
					}
					break;
				} else {
					System.out.println("Invalid input. Enter 'r'or 'h' ");
				}
			}
			System.out.println("Score-> Player 1:" + player1score + " | Score-> Player 2:" + player2score);
			isplayer1turn = !isplayer1turn;

		}
		System.out.println("\nGame Over!");
		if (player1score >= 100) {
			System.out.println("🎉 Player 1 wins!");
		} else {
			System.out.println("🎉 Player 2 wins!");
		}
	}

}
