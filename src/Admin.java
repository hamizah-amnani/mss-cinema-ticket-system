import java.io.*;
import java.util.*;

public class Admin{
	//attributes
	private String adminID;
	private String adminPW;

	// normal constructor
	public Admin(String id, String pw) {
		adminID = id;
		adminPW = pw;
	}

	// setter
	public void setAdminID(String id) {adminID = id;}
	public void setAdminPW(String pw) {adminPW = pw;}

    //getter
	public String getAdminID() {return adminID;}
	public String getAdminPW() {return adminPW;}

	//processor
	public boolean AdminVerification(String ID, String PW){
        try{
            BufferedReader in = new BufferedReader(new FileReader("admin.txt"));
            String inData = null;
            while((inData = in.readLine()) != null){
                StringTokenizer st = new StringTokenizer(inData,";");
                String id  = st.nextToken();
                String pw = st.nextToken();
                if(adminID.equals(id) && adminPW.equals(pw))
                    return true;
            }
            in.close();
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