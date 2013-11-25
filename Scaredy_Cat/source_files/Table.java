package source_files;

class Table {
	private int scarecrowNr;
	
	Table() {
		scarecrowNr = 0;
	}
	
	void raiseScarecrowNr() {
		scarecrowNr++;
	}
	
	void resetScarecrowNr() {
		scarecrowNr = 0;
	}
	
	boolean checkScarecrowNr() {
		return (scarecrowNr < 6);
	}
	
	int getScarecrowNr() {
		return scarecrowNr;
	}
}
