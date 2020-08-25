import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -332737147712229523L;

    private String email, username, masterPassword;
    private Vault vault;

    public User( String name, String email, String masterPassword ) throws IOException {

        this.vault = new Vault();
        this.email = email;
        this.username = name;
        this.masterPassword = masterPassword;
    }

    public void setMasterPassword( String masterPassword ) { this.masterPassword = masterPassword; }

    public void setEmail( String email ) { this.email = email; }

    public void setUsername( String name ) { this.username = name; }

    public String getEmail() { return email; }

    public String getMasterPassword() { return masterPassword; }

    public String getUsername() { return username; }

    public Vault getVault() { return vault; }

}
