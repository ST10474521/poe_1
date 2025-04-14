package MxolisiMaluleka;

//HELLO MY NAME IS MXOLISI MALULEKA, THIS IS THE IMPORTATION PART.

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.HashMap;

//THIS CLASS CONTAINS A HASH MAP THAT HOLDS AND STORES THE USER'S INFORMATION. 
public class Login { 
    static HashMap<String,String> database = new HashMap<>();
    private boolean LOGING_INFORMATION = false;
 
//THIS METHOD CHECKS THE USERNAME.
    public boolean checkingtheusername(String username){
        String regex = "^(?=.*_)[a-zA-Z0-9_]{1,5}$";        
        return username.matches(regex);
    }
  
//THIS METHOD CHECKS THE PASSWORD COMPLEXITY.
    public static boolean checkpasswordcomplexity(String password){
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }
    
  //THIS METHOD CHECKS THE SOUTH AFRICAN CELLPHONE NUMBER.
    public static boolean checkingtheSAcellnumber(String number){
        String regex ="^\\+27[6-8][0-9]{8}$";
        return Pattern.matches(regex, number);
    }
    
    //THIS METHOD CHECKS AND CAPTURES THE FIRST NAME.
    public String UserRegistration(String username, String password, String number){
        
        if (Registration.firstname.equals("")){  
          String message="Please Enter Your First Name";
          JOptionPane.showMessageDialog(null,message,"ERROR!!!",JOptionPane.ERROR_MESSAGE);
       return message;    
      }else {
        
           String message = "YOUR FIRST NAME IS: " +Registration.firstname;
           JOptionPane.showMessageDialog(null, message);
        }
        
       // THIS METHOD CHECKS AND CAPTURES THE LAST NAME.
        if (Registration.lastname.equals("")){  
          String SAY="Please Enter Your Last Name";
          JOptionPane.showMessageDialog(null, SAY,"ERROR!!!",JOptionPane.ERROR_MESSAGE);
       return SAY;    
      }else {
        
           String SAY = "YOUR LAST NAME IS: " +Registration.lastname;
           JOptionPane.showMessageDialog(null, SAY);
        }
        
    //THIS METHOD CHECKS AND VERIFIES THE USERNAME.
        if (checkingtheusername(username)){
            
            String SAY="USERNAME HAS BEEN SUCCESSFULLY ADDED.";
            JOptionPane.showMessageDialog(null,SAY,"Success!!!",JOptionPane.INFORMATION_MESSAGE );
            
        }else {
            String SAY="INCORRECT USERNAME FORMAT, Please ensure that your username contains an underscore and is no more than five(5) characters.";
            JOptionPane.showMessageDialog(null,SAY,"ERROR!!!",JOptionPane.ERROR_MESSAGE );
            return SAY ;
        }       
     
     // THIS METHOD CHECKS AND VERIFIES THE PASSWORD COMPLEXITY.
        if(!checkpasswordcomplexity(password)){
            
            String SAY  =  "THIS PASSWORD IS INVALID , your Password must contain a Capital Letter, a Special Case, an Underscore, a Number and is atleast EIGHT(8) Characters Long.";
            JOptionPane.showMessageDialog(null, SAY, "Error!!!" ,JOptionPane.ERROR_MESSAGE);
            return SAY;
        }   
        else  { 
            String SAY="PASSWORD HAS BEEN SUCCESSFULLY ADDED.";
            JOptionPane.showMessageDialog(null,SAY,"Success!!!", JOptionPane.INFORMATION_MESSAGE );
        }
        
        // THIS METHOD CHECKS AND VERIFIES THE CELLPHONE NUMBER.
        if (checkingtheSAcellnumber(number)){
         String SAY="YOUR CELLPHONE NUMBER HAS BEEN SUCCESSFULLY ADDED.";
         JOptionPane.showMessageDialog(null,SAY,"Success!!!", JOptionPane.INFORMATION_MESSAGE );
     }
     else {
         String SAY = "INVALID CELLPHONE NUMBER , PLEASE MAKE SURE THIS A SOUTH AFRICAN NUMBER AND STARTS WITH THE SA_INTERNATIONAL CODE(+27) ";
         JOptionPane.showMessageDialog(null, SAY,"Error!!!",JOptionPane.ERROR_MESSAGE);
         return SAY;
     }
    //THIS METHOD RETURNS THE REGISTRATION SUCCESS MESSAGE IF THE USER MEETS THE REQUIREMENTS.
         String success="YOUR ACCOUNT REGISTRATION IS COMPLETE AND SUCCESSFUL , PLEASE LOG IN.";
          JOptionPane.showMessageDialog(null,success,"REGISTRATION SUCCESSFUL",JOptionPane.INFORMATION_MESSAGE);
       return success;       
     }
   
//THIS METHOD CHECKS THE STORED USER'S INFORMATION.
public boolean Logintheuser(String username, String password){
System.out.println( "Loging in :"+ username);
System.out.println( "Password stored :"+ database.get(username));
System.out.println("Your Password is:" + password);
return database.containsKey(username) && database.get(username).equals(password);
}
// THIS METHOD CHECKS AND VERIFIES THE USER'S STORED DETAILS AND RETURNS THE LOGIN STATUS
public String LoginStatusreturner(boolean isSuccess){
String SAY = isSuccess?
        "WELCOME BACK " + Registration.firstname +" "+ Registration.lastname +" IT IS GREAT TO SEE YOU AGAIN!!! " :
       "INCORRECT USERNAME OR PASSWORD, PLEASE TRY AGAIN."; 
        JOptionPane.showMessageDialog(null, SAY, "LOGIN STATUS", isSuccess? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
return SAY;

    }

}