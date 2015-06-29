import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author OmarHallab
 */
public class SEProj {

    public static ArrayList<String> Students = new ArrayList<>();
    public static ArrayList<String> Librarians = new ArrayList<>();
    public static ArrayList<Book> Books = new ArrayList<>();
    public static ArrayList<Student> StudentList = new ArrayList<>();

    
    public static String viewRegistryOfBooks(){
        String output;
        int count = 0;
        output = "The books that are currently available is/are: \n";
        for(Book b : Books){
            output += count +". " +b.getBookName() +"\n";
            count++;
        }
        return output;
        
    }
    
    public static int bookExists(String bookname){
        int i = 0;
        for(Book b : Books){
            if(b.getBookName().equals(bookname)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public static int studentExists (String studentUsername){
        String userName;
        int i =0 ;
        for(Student s : StudentList){
            userName = s.getUserName();
            if(userName.equals(studentUsername)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
           JFrame frame = new JFrame();
            frame.setSize(500, 300);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Library Application");
	   
            
       Border Line = LineBorder.createBlackLineBorder();
       JPanel combined = new JPanel();
       combined.setLayout(new GridLayout(2,1));
       combined.setBackground(Color.LIGHT_GRAY);
       
       
       JPanel questionPanel = new JPanel();
       JLabel question = new JLabel("            what type of user are you?");
       question.setFont(new Font("arial",Font.BOLD,25));
       question.setForeground(Color.BLACK);
       questionPanel.add(question);
       questionPanel.setBorder(Line);
       
       
       JPanel answerPanel = new JPanel();
       answerPanel.setLayout(new GridLayout(1,2));
       
       JButton sButton = new JButton("Student");
       sButton.setFont(new Font("arial",Font.BOLD,15));
       JButton lButton = new JButton("Librarian");
       lButton.setFont(new Font("arial",Font.BOLD,15));
       
       answerPanel.add(sButton);
       answerPanel.add(lButton);
       answerPanel.setBorder(Line);
       
       combined.add(question);
       combined.add(answerPanel);
       combined.setBorder(Line);
       
        
       
        Date dateRet1 = new Date(2015,1,7);
        Date dateBor1 = new Date(2015,1,3);
        Date dateRet2 = new Date(2015,2,10);
        Date dateBor2 = new Date(2015,2,5);
        Date dateRet3 = new Date(2015,3,25);
        Date dateBor3 = new Date(2015,3,20);
        
        BookDescription bookD1 = new BookDescription(dateRet1,dateBor1,false);
        BookDescription bookD2 = new BookDescription(dateRet2,dateBor2,false);
        BookDescription bookD3 = new BookDescription(dateRet3,dateBor3,false);
        
        
        Book b1 = new Book("The new moon","Sigmund Romberg",bookD1);
        Book b2 = new Book("The Alchemist", "Paulo Coelho" ,bookD2);
        Book b3 = new Book("Hunger Games", "Suzanne Collins",bookD3);
        
        Books.add(b1);
        Books.add(b2);
        Books.add(b3);
        
        
    
        String s ;
        char choice;
        
        
        String sUsername = "admin";
        String sPassword = "admin";
        Students.add(sUsername + sPassword);
        
        
        String lUsername = "admin";
        String lPassword = "admin";
        Librarians.add(lUsername + lPassword);
        
         final LibraryCard libraryC = new LibraryCard("A0910375",20,new ArrayList<Book>(),new ArrayList<Book>());
      
        frame.add(combined);
        frame.setVisible(true);
        System.out.println("Successfully initiated!");
        System.out.println("------------------------------------");
        System.out.println("Activity log :");
      
       sButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                 
                
                  String c;
                  Student s = new Student();
       
                  
                  
                  
                  String  sUsername = JOptionPane.showInputDialog("Enter your username :");
                  String  sPassword = JOptionPane.showInputDialog("Enter your password :");
                   
                  
                   if(s.login(sUsername,sPassword,Students) == true){
                       
                  
                       s = new Student("admin","admin" ,sUsername, libraryC);
                       StudentList.add(s);
                       
                       JOptionPane.showMessageDialog(null , "Welcome " +s.getUserName().toUpperCase() +" !" +"\n id number : " +libraryC.getId());
                       System.out.println();
                       System.out.println(s.getUserName() +" has successfully logged in!");
                       
                       boolean cont = true;
                       do{
                           
                          c = JOptionPane.showInputDialog("Your available services are : \n "
                                   +"1. View available Books.\n"
                                   +"2. Borrow a Book.\n" 
                                   +"3. reserve a Book. \n"
                                   +"4. View account books & dates. \n"
                                   +"5. Your current fee. \n"
                                   +"6. Log out.");
                           
                          
                            
                           switch(Character.toLowerCase(c.charAt(0))){
                               
                               
                               case'1': 
                                        JOptionPane.showMessageDialog(null,viewRegistryOfBooks());
                                        break;
                               
                               case '2':
                                   if(Books.isEmpty()){
                                       JOptionPane.showMessageDialog(null,"There are no available books.");
                                       cont = true;
                                   }else{
                                      boolean check = false;
                                       do{
                                          c = JOptionPane.showInputDialog(viewRegistryOfBooks());
                                          if(bookExists(c) == -1){
                                              JOptionPane.showMessageDialog(null,"This book does not exist! try again.");
                                              check = false;
                                          }else{
                                              int index = bookExists(c);
                                              if(Books.get(index).getBookDescription().isBookReserved()){
                                                  JOptionPane.showMessageDialog(null,"Sorry, this book is reserved. Try another!");
                                                  check = false;
                                                  
                                              }else{
                                                  Books.get(index).getBookDescription().setBookReservation(true);
                                                  Book b = Books.get(index);
                                                  s.getLibraryCard().setBooksBorrowed(b);
                                                  JOptionPane.showMessageDialog(null, "You have successfully borrowed : " +b.getBookName());
                                                  check = false;
                                                  
                                                  
                                              }
                                          }
                                                                                    
                                       }while(check == true);
                                   }
                                   break;
              //case 1 ended
                                   
                                   
                                   case '3':
                                   if(Books.isEmpty()){
                                       JOptionPane.showMessageDialog(null,"There are no available books.");
                                       cont = true;
                                   }else{
                                      boolean check = false;
                                       do{
                                          c = JOptionPane.showInputDialog("Which Book do you want to reserve ? \n" +viewRegistryOfBooks());
                                          if(bookExists(c) == -1){
                                              JOptionPane.showMessageDialog(null,"This book does not exist! try again.");
                                              check = false;
                                          }else{
                                              int index = bookExists(c);
                                              if(Books.get(index).getBookDescription().isBookReserved()){
                                                  JOptionPane.showMessageDialog(null,"Sorry, this book is already reserved. Try another!");
                                                  check = false;
                                                  
                                              }else{
                                                  Books.get(index).getBookDescription().setBookReservation(true);
                                                  Book b = Books.get(index);
                                                  s.getLibraryCard().setBooksReserved(b);
                                                  JOptionPane.showMessageDialog(null, "You have successfully reserved : " +b.getBookName());
                                                  check = false;
                                                  
                                                  
                                              }
                                          }
                                                                                    
                                       }while(check == true);
                                   }
                                   break;
                                   
    //case 2 ended                               
                                   
                               case '4':
                                   cont = true;
                                   c = JOptionPane.showInputDialog("choose your category :\n" 
                                           +"1. list of Books you already reserved. \n" 
                                           +"2. list of Books you are currently Borrowing with their respective due dates"
                                          );
                                    
                                 
                                   switch(Character.toLowerCase(c.charAt(0))){
                                    
                                           
                                    
                                       case '1':
                                           s.getLibraryCard().viewRegistryOfReservedBooks();
                                           break;
                                     
                                       case'2':
                                           s.getLibraryCard().ViewDateofBorrowedBooks();
                                           break;
                                       
                                       default: 
                                           JOptionPane.showMessageDialog(null, "Invalid input! Please try again.");
                                           break;
                                   }
                         

                              
                                   break;
          //case 3 ended
                                   
                                   
                                   
                                case'5':
                                           int fees = s.getLibraryCard().getFees();
                                           JOptionPane.showMessageDialog(null, "Your current fee is : $" +fees);
                                           break;   
                                   
          //case 4 ended
                                   
                             case'6':
                                       JOptionPane.showMessageDialog(null, "You have successfully logged out !");
                                       System.out.print(s.getUserName() +" has successfully logged out!");
                                       s = null;
                                       cont = false;
                                       break;
           //case 5 ended
                                       
                             default:
                                 JOptionPane.showMessageDialog(null,"Invalid input! Please try again.");
                                 cont = true;
                                 break;    
                                   
                           }
    //End switch for the user menu                   
 
                       }while(cont == true);
           
                   }else{
                      
                       JOptionPane.showMessageDialog(null,"invalid input. Not a registered Student! Please try again.");
                   }
                   
                 
            }
       });
  
       
       lButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

               String c ;
               Librarian l = new Librarian();
               Date dateRet = new Date(2015,1,7);
               Date dateBor = new Date(2015,1,3);
               BookDescription bookD = new BookDescription(dateRet,dateBor,false);
               String  lUsername = JOptionPane.showInputDialog("Enter your username: ");
               String  lPassword = JOptionPane.showInputDialog("Enter your password: ");
               
                   
                   if(l.login(lUsername,lPassword, Librarians) == true){
                       l = new Librarian("Admin","Admin",lUsername);
                       System.out.println();
                       System.out.println(l.getUserName() +" has successfully logged!");
                       JOptionPane.showMessageDialog(null , "Welcome " +l.getUserName().toUpperCase() +" !");
                       
                       boolean cont = true;
                       do{
                           
                           c = JOptionPane.showInputDialog("Your available services are : \n "
                                    +"1. Enter a new Book. \n "
                                    +"2. Access a user's Library card. \n"
                                    +"3. View list of available Books. \n"
                                    +"4. Logout.");
                           
                            
                            switch(Character.toLowerCase(c.charAt(0))){
                                
                                case'1':
                                    
                                  c = JOptionPane.showInputDialog( viewRegistryOfBooks() +"Do you want to add another book ?");
                                    if(Character.toLowerCase(c.charAt(0))=='y'){
                                        
                                        do{
                                            String bookName = JOptionPane.showInputDialog("Enter the books name :");
                                            String authorName = JOptionPane.showInputDialog("Enter the author's name :");
                                            Book newBook = new Book(bookName,authorName,bookD);
                                            Books.add(newBook);
                                            
                                            c = JOptionPane.showInputDialog("Do you want to add another book ?");
                                            
                                        }while(Character.toLowerCase(c.charAt(0))=='y');
                                            
                                    }else{
                                       
                                        JOptionPane.showMessageDialog(null, "Operation complete.");
                                        break;
                                       
                                    }
                                  
        //case 1 ended                            
                                    
                                case '2':
                                    
                                    c = JOptionPane.showInputDialog("Enter the Student's username :");
                                    int studentIndex = studentExists(c);
                                    
                                    if(studentIndex == -1){
                                        JOptionPane.showMessageDialog(null,"This student does not exist. Try again.");
                                        
                                    }else{
                                        
                                   c = JOptionPane.showInputDialog("Your available services are : \n "
                                    +"1. View registry of reserved books. \n "
                                    +"2. View registry of borrowed books with date of return. \n"
                                    +"3. add a fee.");
                           
                                        switch(Character.toLowerCase(c.charAt(0))){
                                            
                                        
                                       case '1':
                                        StudentList.get(studentIndex).getLibraryCard().viewRegistryOfReservedBooks();
                                        break;
                                        case '2':
                                        StudentList.get(studentIndex).getLibraryCard().ViewDateofBorrowedBooks();
                                        break;
                                        case '3':
                                            c = JOptionPane.showInputDialog("Enter the value of the fee: ");
                                            int fee = Integer.parseInt(c);
//                                            System.out.println(StudentList.get(studentIndex).getLibraryCard().getFees());
                                            StudentList.get(studentIndex).getLibraryCard().setFees((int)(StudentList.get(studentIndex).getLibraryCard().getFees())+ fee);
                                            JOptionPane.showMessageDialog(null,"The fee has been charged!");
//                                            System.out.println(StudentList.get(studentIndex).getLibraryCard().getFees());
                                        
                                        break;
                                    
                                default: 
                                   JOptionPane.showMessageDialog(null,"Invalid input! Please try again.");
                                    break;
                                }
                                    }
                                        break;
     //case 2 ended              
                                    case'3': 
                                        JOptionPane.showMessageDialog(null,viewRegistryOfBooks());
                                        break;
     //case 3 ended
                                    case'4':
                                       JOptionPane.showMessageDialog(null, "You have successfully logged out !");
                                       System.out.println(l.getUserName() +" has succesfully logged out!");
                                       l = null;
                                       cont = false;
                                       break;
    //case 4 ended                      
                                    default:                
                                      JOptionPane.showMessageDialog(null,"Invalid input! Please try again.");
                                      cont = true;
                                      break;  
                                        
                     
              //End switch for the librarian menu
                           }
                                    
                       }while(cont == true);
                       
                       
                   }else{
                       
                       JOptionPane.showMessageDialog(null,"Invalid input. Not a registered Librarian! Please try again.");
                   }
                   
            }
       });
       
      
                  
                    
      
                   
                      
}
}
