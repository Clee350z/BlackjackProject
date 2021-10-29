package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeckTest {

	public static void main(String[] args) {
		DeckTest dealing = new DeckTest();
		dealing.deal();
	}

	public void deal() {
		//get a deck of cards
		Deck deck = new Deck();
		//shuffle the deck
		deck.shuffle();
		//ask user how many cards
		Scanner scan = new Scanner(System.in);
		System.out.println("How many cards?");
		int amtCards = scan.nextInt();
		//deal the amount of cards
		List<Card>userHand = new ArrayList<>();
		int handTotal = 0;
		
		for (int numCard =0; numCard < amtCards && 
				(deck != null) && (deck.checkDeckSize()>0) && 
				(amtCards< deck.checkDeckSize()); numCard++ ) {
			Card dealtCard = deck.dealCard();
			
			userHand.add(dealtCard);
			handTotal += dealtCard.getValue();
		}
		
		//have user show hand
		System.out.println("Player hand total: "+ handTotal);
		for (Card card : userHand) {
			System.out.println(card);
			
		}
		scan.close();
	}

}
