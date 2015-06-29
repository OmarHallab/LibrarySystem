

/**
 *
 * @author OmarHallab
 */

public class Student extends User {
    //User attributes
    
    private LibraryCard libraryCard;
    
    
    
 
   
    //Constructor
    public Student(String fName , String lName , String uName , LibraryCard lc){
        super(fName,lName,uName);
        this.libraryCard = lc;
    }
    public Student(){
        super();
        this.libraryCard = null;
    }
    
    //setters & getters
    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }
    
    //End here
    
    
    
}
