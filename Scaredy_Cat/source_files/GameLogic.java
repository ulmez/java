package source_files;

import java.util.Arrays;
import java.util.Random;

class GameLogic {
	private Card[] deck;
	
	public int getDeckLength() {
		return deck.length;
	}
	
	public String getCardType(int index) {
		return deck[index].getCardType();
	}
	
	public Card getCard(int index) {
		return deck[index];
	}
	
	public boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}
	
	public void sortPlayerArray(Player[] p) {
		int[] tempAges = new int[p.length];
		
		for(int i = 0; i < p.length; i++) {
			tempAges[i] = p[i].getAge();
		}
		
		Arrays.sort(tempAges);
		
		for(int i = 0; i < p.length; i++) {
			p[i].setAge(tempAges[i]);
			p[i].setPlayerIndex(i);
		}
	}
	
	public void initDec() {
		deck = new Card[49];
		
		for(int i = 0; i < deck.length; i++) {
			if(i < 7) {
				deck[i] = new Bird();
			} else if(i < 14) {
				deck[i] = new Bird(2);
			} else if(i < 21) {
				deck[i] = new Bird(3);
			} else if(i < 28) {
				deck[i] = new Bird(4);
			} else if(i < 34) {
				deck[i] = new Bird(5);
			} else if(i < 40) {
				deck[i] = new Bird(6);
			} else if(i < 46) {
				deck[i] = new Scarecrow();
			} else {
				deck[i] = new Cat();
			}
		}
	}
	
	public void shuffleDec() {
		Random rg = new Random();
		Card[] tempDeck = new Card[deck.length];
		int[] someArray = new int[deck.length];
		int theLength = someArray.length - 1;
		int toSwap; // The index we will swap  (i.e. the random number)
		int temp; // A temporary variable to hold reference to index variable i points to
		
		for(int i = 0; i < someArray.length; i++) {
			someArray[i] = i;
		}
		
		for (int i = theLength; i > 0; i--) { 
		    toSwap = rg.nextInt(i);
		    temp = someArray[i];
		    someArray[i] = someArray[toSwap];
		    someArray[toSwap] = temp;
		}
		
		for(int i = 0; i < someArray.length; i++) {
			for(int j = 0; j < deck.length; j++) {
				if(someArray[i] == j) {
					tempDeck[i] = deck[j];
					break;
				}
			}
		}
		
		deck = tempDeck;
	}
	
	public void drawCardFromDeck() {
		Card[] tempDeck = new Card[deck.length - 1];
		boolean firstTimeCheck = false;
		for(int i = 0; i < deck.length; i++) {
			if(firstTimeCheck) {
				tempDeck[i - 1] = deck[i];
			}
			firstTimeCheck = true;
		}
		
		deck = new Card[tempDeck.length];
		deck = tempDeck;
	}
	
	public void returnCardsToDeck(Player p) {
		Card[] tempDeck = new Card[(deck.length) + (p.getNumberOfCards())];
		int tempCounter = 0;
		
		for(int i = 0; i < deck.length; i++) {
			tempDeck[i] = deck[i];
		}
		
		for(int i = deck.length; i < tempDeck.length; i++) {
			tempDeck[i] = p.getCard(tempCounter);
			tempCounter++;
		}
		
		deck = new Card[tempDeck.length];
		deck = tempDeck;
		
		p.resetHand();
	}
	
	public String getFullDeck() {
		String strTemp = "Bird 1\tBird 2\tBird 3\tBird 4\tBird 5\tBird 6\tScarecr\tCat\n";
		int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0, counter6 = 0;
		int scarecrow = 0;
		int cat = 3;
		
		for(int i = 0; i < deck.length; i++) {
			if(deck[i].getCardType().equals("Bird")) {
				Bird tempBird = (Bird)deck[i];
				if(tempBird.getNumberOfBirds() == 1) {
					counter1++;
				} else if(tempBird.getNumberOfBirds() == 2) {
					counter2++;
				} else if(tempBird.getNumberOfBirds() == 3) {
					counter3++;
				} else if(tempBird.getNumberOfBirds() == 4) {
					counter4++;
				} else if(tempBird.getNumberOfBirds() == 5) {
					counter5++;
				} else {
					counter6++;
				}
			} else if(deck[i].getCardType().equals("Scarecrow")) {
				scarecrow++;
			}
		}
		
		strTemp += counter1 + "\t" + counter2 + "\t" + counter3 + "\t" + counter4 + "\t" + counter5 + "\t" + counter6 + "\t" + scarecrow + "\t" + cat;
		
		return strTemp;
	}
}