

/**
 *
 * @author OmarHalab
 */

import java.util.ArrayList;


//Cannot be instantiated
public abstract class User {
    //Person attributes
    private String firstName, lastName, userName, password;

 public User(){
     super();
 }
    
    
    //Constructor
    public User(String fName , String lName , String uName ){
        this.firstName = fName;
        this.lastName = lName;
        this.userName = uName;
      
    }
    
    //Setters & Getters 
    
       public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //End here
    
    
    // Log-In method of our program to verify user
    
    public boolean login (String uName,String password, ArrayList<String>user){
        //concatenate both strings 
        String usernamepassword = uName + password;
        
        //validate access if they are in our database ArrayList<String>person
        
        // s instance of ArrayList<String>person
        for (String s : user){
            
             // if they match allow access
            if(s.equals(usernamepassword)){
                return true;
            }
        }
        //else deny
        return false;
    }
    

}
