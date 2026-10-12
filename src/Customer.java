import java.io.*;
import java.util.*;

public class Customer{
	//attributes
    private String username;
    private String password;
    private boolean member;

    // normal constructor
    public Customer(String nm, String pass, boolean mbr) {
        username = nm;
        password = pass;
        member = mbr;
    }

    // setters
    public void setUsername(String nm) {username = nm;}
    public void setPassword(String pass) {password = pass;}
    public void setMember(boolean mbr) {member = mbr;}

    // getters
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public boolean getMember() {return member;}

    // processor
    public boolean CustomerVerification(String NM, String PASS){
        try{
            BufferedReader inRegisterUser = new BufferedReader(new FileReader("registeredUser.txt"));
            String inData = null;
            while((inData = inRegisterUser.readLine()) != null){
                StringTokenizer st = new StringTokenizer(inData,";");
                String nm  = st.nextToken();
                String pass = st.nextToken();
                if(nm.equals(NM) && pass.equals(PASS))
                    return true;
            }
            
            inRegisterUser.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        catch(Exception e) {
            System.out.println("Problem: "+e.getMessage());
        }
        return false;
    }
}