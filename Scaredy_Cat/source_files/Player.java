package source_files;

class Player {
	private int age;
	private int index;
	private Card[] hand = new Card[49];
	
	Player(int a, int i) {
		age = a;
		index = i;
	}
	
	void setPlayerIndex(int i) {
		index = i;
	}
	
	int getPlayerIndex() {
		return index;
	}
	
	void setAge(int a) {
		age = a;
	}
	
	int getAge() {
		return age;
	}
	
	Card getCard(int index) {
		return hand[index];
	}
	
	void setHand(Card c) {
		for(int i = 0; i < hand.length; i++) {
			if(hand[i] == null) {
				hand[i] = c;
				break;
			}
		}
	}
	
	int getNumberOfCards() {
		int tempCounter = 0;
		
		for(int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {
				tempCounter++;
			}
		}
		
		return tempCounter;
	}
	
	public String getHand() {
		String temp = "Bird 1\tBird 2\tBird 3\tBird 4\tBird 5\tBird 6\n";
		int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0, counter6 = 0;
		
		for(int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {
				Bird tempBird = (Bird)hand[i];
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
			}
		}
		
		temp += counter1 + "\t" + counter2 + "\t" + counter3 + "\t" + counter4 + "\t" + counter5 + "\t" + counter6;
		
		return temp;
	}
	
	public void resetHand() {
		for(int i = 0; i < hand.length; i++) {
			hand[i] = null;
		}
	}
	
	public int getTotalNumberOfBirds() {
		int birdSum = 0;
		for(int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {
				Bird tempBird = (Bird)hand[i];
				birdSum += tempBird.getNumberOfBirds();
			}
		}
		return birdSum;
	}
	
	public String toString() {
		return "Players age: " + age + "\nPlayer index: " + index;
	}
}
