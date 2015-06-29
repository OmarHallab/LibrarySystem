

/**
 *
 * @author OmarHallab
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LibraryCard {
    
    //LibraryCard attributes
    
    private String id;
    private int fees;
    
    // create ArrayList<Book> for both reservation & borrowing of books into LibraryCard database
    private ArrayList<Book> booksReserved;
    private ArrayList<Book> booksBorrowed;
    
    //Constructor
    public LibraryCard(String iD, int f ,ArrayList<Book> booksRes , ArrayList<Book> booksB){
        this.id = iD;
        this.fees= f;
        this.booksReserved = booksRes;
        this.booksBorrowed = booksB;
    }

    
    // setters & getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public ArrayList<Book> getBooksReserved() {
        return booksReserved;
    }

    // add book/s to reservation registry
    public void setBooksReserved(Book booksReserved) {
      try {
            this.booksReserved.add(booksReserved);
        } catch (Exception e) {
            System.out.println(e);
        }

     
    }

    public ArrayList<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(Book booksBorrowed) {
         try {
            this.booksBorrowed.add(booksBorrowed);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // End here
    
    
    
    // Function to view the registry of reserved books 
    public void viewRegistryOfReservedBooks(){
        String output;
        if(this.booksReserved.isEmpty()){
            output = "There are no reserved books";
        }else{
            int count = 1;
            output = "The books that are currently reserved are : \n ";
            for (Book b : booksReserved){
                output +=count +". "  +b.getBookName() +"\n";
                count++;
                
            }
        }
        JOptionPane.showMessageDialog(null, output);
        
    }
    
    
    //Function to view the registry of borrowed books
    public void viewRegistryOfBorrowedBooks(){
        String output;
        if(this.booksBorrowed.isEmpty()){
            output = "There are no borrowed books";
        }else{
            
            output = "the books that are currently borrowed are : \n";
            for(Book b :booksBorrowed){
                output += b.getBookName();
            }
        }
        JOptionPane.showMessageDialog(null, output);
    }
    
    
    //Function to view the names of books with their dates respectively
    public void ViewDateofBorrowedBooks(){
        String output= "";
        if(this.booksBorrowed.isEmpty()){
            output = "There are no borrowed books";
        }else{
            
            int count = 1;
            for (Book b : booksBorrowed){
               
                
                output +=count +". "  +b.getBookName() +"\n";
                output += "The borrowed Date:  " + b.getBookDescription().getBorrowedDate() +"\n";
                output += "the Date of return: " +b.getBookDescription().getReturnDate() +"\n";
                count++;
            }
        }
        
        JOptionPane.showMessageDialog(null, output);
        
    }

   
    
}
