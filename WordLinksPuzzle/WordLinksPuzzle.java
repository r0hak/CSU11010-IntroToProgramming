/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the file name is taken as a parameter of the method and an ArrayList of String Values are returned.
			The signature of the method is as expected from the assignment.
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: Yes, it reads all 658,964 words from the file 
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: Yes, it returns its contents in an ArrayList of String Values

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the method returns the list represented as an ArrayList of String values
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Yes it does all of the above.

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes I have the correct method definition
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: Yes it compares each word to ensure they are all unique
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: Yes it returns false if this happens and exits the loop.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Yes it returns the boolean value to the main where the method is called

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes the method definition is correct
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Yes it uses Arrays.binarySearch(str, sWord)
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: if the variable index is >= 0, it returns a value

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes i have the correct method definition
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yes, if there is no difference or it is greater than one, the method returns false

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: the method definition is correct
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: Yes it calls those methods and prints the appropriate statement

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: The main calls wordChain which calls isEnglishWord which calls readDictionary where all the words from word.txt are read.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Yes it does the above

 Total Mark out of 100 (Add all the previous marks): 100
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordLinksPuzzle {
	public static ArrayList <String> readDictionary(String fileName){
		ArrayList<String> dictionaryWords = new ArrayList<String>();
		try
		{
		    FileReader fileReader = new FileReader(fileName);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);  
		    boolean endOfFile = false;
		    while(!endOfFile)
		    {
	            String word = bufferedReader.readLine();
		        if (word != null)
		        {
		           dictionaryWords.add(word);
		         }
		        else
		        {
		            endOfFile = true;
		        }
		    }
		    bufferedReader.close();    
		    fileReader.close();
		} 

		catch (FileNotFoundException e)
		{
		    e.printStackTrace();
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		}
		return dictionaryWords;
	}

	public static String[] readWordList(String line) {
		String[] lineWords = line.split("\\s*,\\s*");
		return lineWords;
	}
	
	public static boolean isUniqueList(String[] strWords) {
		Set<String> s = new HashSet<String>(Arrays.asList(strWords));
		return (s.size() == strWords.length);
	}
	
	public static boolean isEnglishWord(String sWord) {
		ArrayList<String> dictionaryWords = new ArrayList<String>();
		dictionaryWords = readDictionary("words.txt");
		String str[]= GetStringArray(dictionaryWords);
		Arrays.sort(str);
		
		int index = Arrays.binarySearch(str, sWord);
		return (index >= 0);
	}
	
	public static String[] GetStringArray(ArrayList<String> arr)
    {
        String str[] = new String[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            str[j] = arr.get(j);
        }
        return str;
    }
	
	public static boolean isDifferentByOne(String sWord1, String sWord2) {
		if (sWord1.length() != sWord2.length()) {
			return false;
		}
		int diffs = 0;

	    for(int i = 0; i < sWord1.length(); i++)
	    {
	        if(sWord1.charAt(i) != sWord2.charAt(i))
	        {
	            diffs++;
	        }
			
	        if(diffs > 1)
	        {
	            return false;
	        }
	    }
	    if(diffs == 1)
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}
	
	public static boolean isWordChain(String[] lineWords) {
		boolean isUnique = isUniqueList(lineWords);
		if (!isUnique) {
			return false;
		}
		for (int i = 0; i < lineWords.length; i++) {
			boolean isEngWord = isEnglishWord(lineWords[i]);
			if (!isEngWord) {
				return false;
			}
			if (i > 0) {
				boolean isDiff = isDifferentByOne(lineWords[i], lineWords[i-1]);
				if (!isDiff) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		do {
			System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
			line = "";
			line = sc.nextLine();
			if (!line.isBlank()) { 
				String[] lineWords = readWordList(line);
				boolean wordChain = isWordChain(lineWords);
				if (wordChain){
					System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
				}
				else {
					System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
				}
			}
			
		} while(!line.isBlank());
		System.out.print("Game Over. Thanks for playing!");
		sc.close();
		

	}

}
