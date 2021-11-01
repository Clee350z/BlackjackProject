package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cards.Deck;

public class BlackJackApp {

	public static void main(String[] args) {
		System.out.println("Hello! Welcome to the table! Press enter to continue");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();

		do {
			Player player = new Player();
			Player dealer = new Player();
			Deck deck = new Deck();
			deck.shuffle();
			
			player.addCard(deck.draw());
			dealer.addCard(deck.draw());
			player.addCard(deck.draw());
			dealer.addCard(deck.draw());
			System.out.println(player.getHandTotal());
			
			boolean gameFinish =false;
			do {
				System.out.println();
				//before the player is asked, checking for winning conditions
				if (player.getHandTotal()== 21) {
					System.out.println("Blackjack! Player win");
					gameFinish = true;
					break;
				}
				if(player.getHandTotal() >= 22) {
					System.out.println("Bust!");
					gameFinish = true;
					break;
				}
				System.out.println(" Action! Draw? Stay?");
				do {
					choice = scan.nextLine();
				} while (!choice.equalsIgnoreCase("draw") && !choice.equalsIgnoreCase("stay"));
				
				
				//Draw option... theres gotta be a better way
				if( choice.equalsIgnoreCase("draw")) {
					player.addCard(deck.draw());
					System.out.println(player.toString());
					if (player.getHandTotal()== 21) {
						System.out.println("Hit win! 21! Winner! ");
						gameFinish = true;
					}
					if(player.getHandTotal() >=22) {
						System.out.println("Bust!");
						gameFinish = true;
					}
				}
				//stay option..
				if (choice.equalsIgnoreCase("stay")) {
				System.out.println("Player stays! " + player.toString());	
				}
			}while(choice.equalsIgnoreCase("draw") && !gameFinish);
			
			
			if(!gameFinish) {
				System.out.println("Dealer shows hand");
				System.out.println(dealer.toString());
				
				//dealer must draw on a 17
				if(dealer.getHandTotal() <=17) {
					System.out.println("Dealer must draw...");
					dealer.addCard(deck.draw());
					System.out.println("Dealer hand : " + dealer.toString());
					
					if (dealer.getHandTotal() == 18) {
						if(player.getHandTotal() < 18) {
							System.out.println("Dealer wins");
							gameFinish =true;
						}
					}
					if (dealer.getHandTotal() == 19) {
						if(player.getHandTotal() < 19) {
							System.out.println("Dealer wins");
							gameFinish =true;
						}
					}
					if (dealer.getHandTotal() == 20) {
						if(player.getHandTotal() < 20) {
							System.out.println("Dealer wins");
							gameFinish =true;
						}
					}
					if (dealer.getHandTotal() == 21) {
						if(player.getHandTotal() < 21) {
							System.out.println("Dealer wins with 21!");
							gameFinish =true;
						}
					} else {
						System.out.println("Dealer stays");
						int dealerHandValue = dealer.getHandTotal();
						int playerHandValue = player.getHandTotal();
						System.out.println(dealer.toString());
						
						if(dealerHandValue > playerHandValue) {
							System.out.println("Dealer wins, Sorry!");
						} else {
							System.out.println("Player wins!");
						}
						gameFinish = true;
					}
				}
				
			
				System.out.println("Play again?");
				do {
					choice = scan.nextLine();
				}while (!choice.equalsIgnoreCase("yes"));
				
			}

			}while(choice.equalsIgnoreCase("yes"));
			
			scan.close();
	}
	
}