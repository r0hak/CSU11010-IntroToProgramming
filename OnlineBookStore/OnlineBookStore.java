import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore {
	public static int ISBN_INDEX = 0;
    public static int TITLE_INDEX = 1;
    public static int AUTHOR_INDEX = 2;
    public static int PUBLISHER_INDEX = 3;
    public static int PUBLISHER_YEAR_INDEX = 4;
    public static int QUANTITY_INDEX = 5;
    public static int PRICE_INDEX = 6;
    
    public static void printBookDetails(ArrayList<Book> bookList) {
 
    	for (int i =0; i< bookList.size(); ++i) {
    		
    		System.out.printf("ISBN: %s TITLE: %s Price: %.2f Quantity: %d \n", bookList.get(i).getIsbn(), bookList.get(i).getTitle(), bookList.get(i).getPrice(), bookList.get(i).getQuantity());

    	}
  
    }

    public static Book getBook(ArrayList<Book> bookList, String title) {
    	
    	for (int i =0; i< bookList.size(); ++i) {
    		
    		if ( (bookList.get(i).getTitle().equalsIgnoreCase(title))) {
    			return bookList.get(i);
    		}
    	}
    	return null;
    	
    }
    
    public static void topUpCard(ChargeCard card, double amount) {
    	card.topUpFunds(amount);
    }
    
    public static void purchaseBook(ArrayList<Book> bookList) {
    	boolean quit = false;
    	ChargeCard myCard = new ChargeCard();
    	Scanner sc = new Scanner(System.in);
    	do {
    		System.out.print("Please enter the funds on your card: ");
    		if (sc.hasNextDouble())
    		{
    			double funds = sc.nextDouble();
    			if (funds > 0) {
    				topUpCard(myCard, funds);
    				quit = true;
    			}
    			else {
    				System.out.println("Error: You must enter a positive amount (e.g. 50.0)");
    			}
    		}
    		else {
    			System.out.println("Error:  You must enter a positive amount (e.g. 50.0)");
    			sc.next();
            
    		}
    	} while (!quit);
    	quit = false;
    	sc.nextLine();
    	do {
    		System.out.print("Enter a title of the book to Purchase (or type 'quit'): ");
			String searchTitle = sc.nextLine();
			if (searchTitle.equalsIgnoreCase("quit")) {
					quit = true;
			}	
			else {	
				Book aBook = getBook(bookList, searchTitle);
				
				if (aBook != null) {
					int aQuantity = aBook.getQuantity();
					if (( aQuantity> 0) && (aBook.getPrice() < myCard.getFunds())) {
						aBook.setQuantity(aQuantity-1);
						myCard.removeFunds(aBook.getPrice());
						System.out.printf("Book Purchased, Funds: %.2f\n", myCard.getFunds());
						printBookDetails(bookList);
					}
					else {
						if (aQuantity <=0 ) {
							System.out.println("Book is Out of Stock");
						}
						else {
							System.out.println("Insufficient Funds");
						}
					
					}
				}
				else {
					System.out.println("Book Not Found:");
				}
			}	
		} while (!quit);
    	sc.close();
    }
    
    public static void main(String[] args)
    {
	ArrayList<Book> bookList = new ArrayList<Book>();
	try
	{
	    FileReader fileReader = new FileReader("books.txt");// Enter the entire path of the file if needed
	    BufferedReader bufferedReader = new BufferedReader(fileReader);  
	    boolean endOfFile = false;
	    while(!endOfFile)
	    {
            String bookLine = bufferedReader.readLine();
	        if (bookLine != null)
	        {
	            String[] bookData = bookLine.split(", ");
	            String isbn = bookData[ISBN_INDEX];
	            String title = bookData[TITLE_INDEX];
	            String author = bookData[AUTHOR_INDEX];
	            String publisher = bookData[PUBLISHER_INDEX];
	            int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
	            int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
	            double price = Double.parseDouble (bookData[PRICE_INDEX]);
	            Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
	            bookList.add(book);
	            

	         }
	        else
	        {
	            endOfFile = true;
	        }
	    }
	    bufferedReader.close();    
	    fileReader.close();
	} // End try 

	catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}

	// Uncomment the following lines once you have implemented the required methods
	printBookDetails(bookList);
	purchaseBook(bookList);
   }

}
