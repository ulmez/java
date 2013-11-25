package source_files;

import java.util.Scanner;

class ScaredyCat {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String strPlayer;
		String strTemp;
		int numPlayer;
		Scanner sc;
		Player[] players;
		GameLogic gl = new GameLogic();
		Table tabl = new Table();
		
		do {
			numPlayer = 0;
			System.out.print("Welcome to the game \"Scaredy Cat\".\n\nInsert 2 - 4 players here: ");
			
			sc = new Scanner(System.in);
			
			do {
				strPlayer = sc.nextLine();
				
				System.out.println();
				
				if(gl.isInteger(strPlayer) && Integer.parseInt(strPlayer) >= 2 && Integer.parseInt(strPlayer) <= 4) {
					numPlayer = Integer.parseInt(strPlayer);
				} else {
					System.out.print("Wrong, you typed in: " + strPlayer + "\n\nTry again: ");
				}
			} while(numPlayer == 0);
			
			players = new Player[numPlayer];
			
			for(int i = 0; i < players.length; i++) {
				String strTempAge;
				System.out.print("Insert player " + (i + 1) + " age: ");
				strTempAge = sc.nextLine();
				
				if(gl.isInteger(strTempAge)) {
					players[i] = new Player(Integer.parseInt(strTempAge), i);
				} else {
					i--;
					System.out.println("\nNot an integer value, try again:\n");
				}
			}
			
			gl.sortPlayerArray(players);
			gl.initDec();
			gl.shuffleDec();
			
			do {
				for(int i = 0; i < players.length; i++) {
					strTemp = "";
					System.out.print("\nPress enter to take a card from the deck player " + (players[i].getPlayerIndex() + 1) + ": ");
					strTemp = sc.nextLine();
					if(strTemp.equals("")) {
						System.out.println("\nPlayer " + (players[i].getPlayerIndex() + 1) + ", age: " + players[i].getAge() + ",");
						
						if(gl.getCardType(0).equals("Bird")) {
							Bird tempBird = (Bird)gl.getCard(0);
							players[i].setHand(gl.getCard(0));
							gl.drawCardFromDeck();
							
							System.out.println("draw a bird card from the deck.");
							System.out.print("Number of birds on the card: " + tempBird.getNumberOfBirds() + "\n\n");
						} else if(gl.getCardType(0).equals("Scarecrow")) {
							System.out.println("Draw a scarecrow card from the deck, so you place it on the table\n");
							tabl.raiseScarecrowNr();
							gl.drawCardFromDeck();
							if(tabl.getScarecrowNr() == 6) {
								break;
							}
						} else {
							gl.returnCardsToDeck(players[i]);
							gl.shuffleDec();
							System.out.println("Draw a cat card from the deck, scares all your bird cards away back to the deck plus the cat for player " + (players[i].getPlayerIndex() + 1) + "\n");
						}
						
						if(players[i].getNumberOfCards() != 1) {
							System.out.println("Player " + (players[i].getPlayerIndex() + 1) + " now have "+ players[i].getNumberOfCards() + " bird cards. They are:");
						} else {
							System.out.println("Player " + (players[i].getPlayerIndex() + 1) + " now have "+ players[i].getNumberOfCards() + " bird card. It is:");
						}
						
						System.out.println(players[i].getHand() + "\n");
						System.out.println("Number of cards still in the deck are " + gl.getDeckLength() + ". They are:");
						System.out.println(gl.getFullDeck());
						System.out.print("\nNumber of scarecrows on the table: " + tabl.getScarecrowNr() + "\n");
					} else {
						i--;
						System.out.println("Din't take a card, try again");
					}
				}
			} while(tabl.checkScarecrowNr());
			
			tabl.resetScarecrowNr();
			
			System.out.println("All 6 scarecrow cards are on the table, and the game is over.\n");
			System.out.println("List of cards each player have in the end:");
			
			int birdMax = 0;
			for(int i = 0; i < players.length; i++) {
				if(birdMax < players[i].getTotalNumberOfBirds()) {
					birdMax = players[i].getTotalNumberOfBirds();
				}
				
				System.out.println("The total number of birds for player " + (players[i].getPlayerIndex() + 1) + " of age " + players[i].getAge() + " is: " + players[i].getTotalNumberOfBirds());
				System.out.println(players[i].getHand());
				System.out.println();
			}
			
			int numOfSameMaxScore = 0;
			for(int i = 0; i < players.length; i++) {
				if(birdMax == players[i].getTotalNumberOfBirds()) {
					numOfSameMaxScore++;
				}
			}
			
			if(numOfSameMaxScore < 2) {
				System.out.print("The winner is: ");
			} else {
				System.out.println("It's a draw. Listed here under is the players with the same amount of birds:");
			}
			
			for(int i = 0; i < players.length; i++) {
				if(birdMax == players[i].getTotalNumberOfBirds()) {
					System.out.println("player " + (players[i].getPlayerIndex() + 1) + " of age " + players[i].getAge());
				}
			}
			
			System.out.println();
			System.out.print("If you want to play again, write \"Y\" and press enter: ");
			
			strTemp = "";
			strTemp = sc.nextLine();
			strTemp = strTemp.toLowerCase();
		} while(strTemp.equals("y"));
		
		System.out.println("\nGame over!");
	}
}