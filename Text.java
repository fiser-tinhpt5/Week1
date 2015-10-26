/*
 * Exercise 3. Count appearance numbers of words. Sort decrease follow appearance numbers and alphabetic. 
 */
package exerciseSS1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * author Pham Trung Tinh
 */

public class Text {

	private ArrayList<Represent> countText;
	private ArrayList<String> arrayList;

	public ArrayList<Represent> getCountText() {
		return countText;
	}

	public ArrayList<String> getArrayList() {
		return arrayList;
	}

	//Cut word and put into List
	public void convertToArrayList(String paragraph) {

		int beginIndex = 0;
		arrayList = new ArrayList<String>();
		while (beginIndex < paragraph.length()) {
			char ch = paragraph.charAt(beginIndex);
			if ((ch == ' ') || (ch == '.') || (ch == ',') || (ch == ':')
					|| (ch == ';')) {
				beginIndex++;
				continue;
			}
			
			int endIndex = beginIndex;
			while (endIndex < paragraph.length()) {
				char ch1 = paragraph.charAt(endIndex);
				if ((ch1 != ' ') && (ch1 != '.') && (ch1 != ',')
						&& (ch1 != ':') && (ch1 != ';')) {
					endIndex++;
				} else {
					break;
				}
			}
			arrayList.add(paragraph.substring(beginIndex, endIndex));
			beginIndex = endIndex;
		}
	}

	//
	public void countAppearanceNumberOfWord() {
		Collections.sort(arrayList);
		int beginIndex = 0;
		countText = new ArrayList<Represent>();
		for (int endIndex = 0; endIndex < arrayList.size() - 1; endIndex++) {
			if (arrayList.get(endIndex).equals(arrayList.get(endIndex + 1))) {
				continue;
			} else {
				Represent represent = new Represent();
				represent.setWord(arrayList.get(endIndex));
				represent.setNumberOfWord(endIndex - beginIndex + 1);
				beginIndex = endIndex + 1;
				countText.add(represent);
			}
			if (beginIndex == arrayList.size() - 1) {
				Represent represent = new Represent();
				represent.setWord(arrayList.get(beginIndex));
				represent.setNumberOfWord(1);
				countText.add(represent);
			}
		}
	}

	public void printList(ArrayList<Represent> arrayList) {
		Collections.sort(arrayList);
		for (Represent represent : arrayList) {
			System.out.println(represent.getWord() + " "
					+ represent.getNumberOfWord());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Text.txt");
		Scanner sc = new Scanner(file);
		String paragraph = sc.nextLine();
		sc.close();
		
		Text text = new Text();
		text.convertToArrayList(paragraph.trim());
		text.countAppearanceNumberOfWord();
		text.printList(text.getCountText());
	}
}

class Represent implements Comparable<Represent> {
	private String word;
	private int numberOfWord;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getNumberOfWord() {
		return numberOfWord;
	}

	public void setNumberOfWord(int numberOfWord) {
		this.numberOfWord = numberOfWord;
	}

	@Override
	public int compareTo(Represent represent) {
		int compareNumber = represent.numberOfWord;
		return compareNumber - this.numberOfWord;
	}
}
