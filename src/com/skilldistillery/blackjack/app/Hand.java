package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import com.skilldistillery.cards.Card;

public abstract class Hand {
	protected ArrayList<Card> cards;
	
	public abstract int getHandValue();
	
	public Hand() {
		cards=(new ArrayList<Card>());
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}

	@Override
	public String toString() {
		String showCards = " " + cards.toString();
		return showCards;
	}
	

	
	
	
	
}