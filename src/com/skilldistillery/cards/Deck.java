package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;
	
	//In the constructor, initialize the List with all 52 cards.
	public Deck() {
		deck = newDeck();
	}
	
	private List <Card> newDeck() {
		List<Card> deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(rank,suit);
				deck.add(card);
			}
			
		}
		return deck;
	}
	public int  checkDeckSize(){
		return deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	//these methods will help 'deal' a card object 

	public Card draw() {
		return deck.remove(0);
	}
	
	public List<Card> getCard() {
		return deck;
	}
	
	public void addCard(Card addCard) {
		this.deck.add(addCard);
	}

	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}
	
	
	
}

