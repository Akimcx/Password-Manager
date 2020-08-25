import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7548417867965398854L;

    private static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

    public static void main( String[] args ) throws IOException, ClassNotFoundException {

        System.out.println( "---------------Choose an option---------------" );
        System.out.println( "1-LogIn\n2-Sign Up" );
        System.out.print( "> " );

        String userChoice = br.readLine();

        if ( userChoice.equals( "1" ) ) {
            logIn();
        } else {
            signUp();
        }
    }

    private static void logIn() throws IOException, ClassNotFoundException {

        System.out.print( "Email: " );
        String email = br.readLine();
        System.out.print( "Password: " );
        String password = br.readLine();

        User user;

        FileInputStream fis = new FileInputStream( "userlist.ser" );
        ObjectInputStream ois = new ObjectInputStream( fis );
        user = ( User ) ois.readObject();

        if ( user.getEmail().equals( email ) ) { welcome( user ); }
    }

    private static void signUp() throws IOException {

        System.out.print( "Get started with your email: " );
        String userEmail = br.readLine();

        System.out.print( "Pick a username: " );
        String username = br.readLine();

        System.out.println( "New master password\nAt least 10 characters long" );
        System.out.print( "Not your email\n> " );
        String masterPassword = br.readLine();

        System.out.print( "Confirm your master password\n> " );
        String masterPasswordConfirm = br.readLine();

        if ( !userEmail.matches( "[\\w\\.-]*@[a-z]*\\.[a-z]{2,}" ) ) { System.out.println( "Invalid email" ); }

        if ( masterPassword.length() < 10 ) {
            System.out.println( "Your master password should be at least 10 charactes long!" );
        }
        if ( masterPassword.equals( userEmail ) ) {
            System.out.println( "Your master password should be different than your email" );
        }
        if ( !masterPassword.equals( masterPasswordConfirm ) ) { System.out.println( "Passwords don't match" ); }

        User newUser = new User( username, userEmail, masterPassword );

        saveUser( newUser );

        welcome( newUser );
    }

    private static void saveUser( User user ) throws IOException {

        FileOutputStream fos = new FileOutputStream( "userlist.ser" );
        ObjectOutputStream oos = new ObjectOutputStream( fos );

        oos.writeObject( user );
        oos.close();
        fos.close();
    }

    private static void welcome( User user ) throws IOException {

        String name = user.getUsername();

        System.out.println( "\nWelcome " + name + ", type Ctrl + c to logout\n" );

        System.out.println( "1- Add an item to your vault" );
        System.out.println( "2- Get an item from your vault" );
        System.out.println( "4- List all items in your vault" );
        System.out.print( "3- Remove an item from your vault\n> " );

        String userChoice = br.readLine();

        switch ( userChoice ) {
            case "1":
                user.getVault().addItem( new Item( "Facebook", "marcus", "moool" ) );
        }
    }

}
