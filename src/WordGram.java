
/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Brian Du
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Creates WordGram object
	 * @param source: the String array from which the WordGram gets its String elements
	 * @param start: the start index
	 * @param size: the size of the WordGram
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		// TODO: initialize myWords and ...
		myToString = null;
		for (int k = 0; k < size; k++) {
			if(k + start < source.length) {
				myWords[k] = source[k+ start];
			} else {
				break;				
			}
		}
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Gives the size of a Wordgram object or the length of its array
	 * @return the size of the WordGram
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}

	    // TODO: complete this method
		WordGram wg = (WordGram) o;
		if (this.length() != wg.length()) return false;
		for (int k =0; k < this.length(); k++) {
			if (!this.myWords[k].equals(wg.myWords[k])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
	//check if this is correct
	if (myHash == 0) {
		myHash = this.toString().hashCode();
	}	
		return myHash;
	}
	

	/**
	 * "Shifts" WordGram object one index over so that new WordGram contains
	 * same elements as previous WordGram, but the first element is removed and a new
	 * last element added 
	 * @param last is last String of returned WordGram
	 * @return wg, new Wordgram 
	 */
	
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		
		for (int k = 0; k < myWords.length - 1; k++) {
				wg.myWords[k] = myWords[k + 1];
		}
		wg.myWords[myWords.length - 1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method

		if (myToString == null) {
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
