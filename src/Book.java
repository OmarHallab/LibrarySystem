
/**
 *
 * @author OmarHallab
 */
public class Book {
    
    //Book attributes
    
    private String  bookName , authorName;
    private BookDescription bookD;
    
    
    //Constructor
    public Book(String bookN , String authorN , BookDescription bookD){
        this.bookName = bookN;
        this.authorName = authorN;
        this.bookD = bookD;
    }

    // setters & getters 
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BookDescription getBookDescription() {
        return bookD;
    }

    public void setBookStatus(BookDescription bookD) {
        this.bookD = bookD;
    }
    
    
    // End here
    
    
    
}
