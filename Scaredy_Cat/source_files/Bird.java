package source_files;

class Bird extends Card {
	private int numberOfBirds;
	
	Bird() {
		setCardType("Bird");
		numberOfBirds = 1;
	}
	
	Bird(int nob) {
		setCardType("Bird");
		numberOfBirds = nob;
	}
	
	public void setNumberOfBirds(int nob) {
		numberOfBirds = nob;
	}
	
	public int getNumberOfBirds() {
		return numberOfBirds;
	}
	
	public String toString() {
		return "Card type: " + getCardType() + "\nNumber of birds: " + numberOfBirds + "\n";
	}
}