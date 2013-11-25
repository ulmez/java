package source_files;

class Scarecrow extends Card {
	Scarecrow() {
		setCardType("Scarecrow");
	}
	
	public String toString() {
		return "Card type: " + getCardType() + "\n";
	}
}
