package source_files;

class Cat extends Card {
	Cat() {
		setCardType("Cat");
	}
	
	public String toString() {
		return "Card type: " + getCardType() + "\n";
	}
}