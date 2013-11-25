package source_files;

abstract class Card {
	private String cardType;
	
	public void setCardType(String ct) {
		cardType = ct;
	}
	
	public String getCardType() {
		return cardType;
	}
}