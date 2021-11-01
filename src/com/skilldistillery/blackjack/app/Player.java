package com.skilldistillery.blackjack.app;

import java.util.ArrayList;

import com.skilldistillery.cards.Card;

public class Player {
	
	private int numCardsInHand;
	ArrayList<Card> currentHand;
	
	public Player() {
		currentHand = new ArrayList<Card>();	
	}
	
	public void addCard(Card aCard) {
		currentHand.add(aCard);
	}
	
	public int getHandTotal() {
		int handTotal=0;
		for(Card card : currentHand) {
			handTotal += card.getValue();
		}
		return handTotal;
	}
	

	public int getNumCardsInHand() {
		return numCardsInHand;
	}

	public void setNumCardsInHand(int numCardsInHand) {
		this.numCardsInHand = numCardsInHand;
	}

	@Override
	public String toString() {
		return " [currentHand=" + currentHand + "]";
	}
	
	
}
