/**
 *
 * @author OmarHallab
 */
import java.util.Date;




public class BookDescription {
    
    //BookStatus attributes
    private Date returnDate;
    private Date borrowedDate;
    private boolean bookReservation;
    
    
    //Constructor
    public BookDescription(Date returnD , Date borrowedD , boolean bookRes){
        
        this.returnDate = returnD;
        this.borrowedDate = borrowedD;
        this.bookReservation = bookRes;
        
    }

    //setters & getters
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

  
    public void setBookReservation(boolean bookReservation) {
        this.bookReservation = bookReservation;
    }
    
    
     // End here
    
    
    // checking the reservation status of book
     public boolean isBookReserved() {
        if(this.bookReservation == true){
            return true;
        }else{
            return false;
        }
    }
   

   
    
}
