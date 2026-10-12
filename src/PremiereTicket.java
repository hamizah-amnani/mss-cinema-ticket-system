import java.io.*;
import java.util.*;

public class PremiereTicket extends Ticket{
	//attribute
    private boolean merchandise;

	//normal constructor
    public PremiereTicket(int mv, int ad, int ch, int st, String seat, int pickTime, boolean merch, Customer customer){
        super(mv, ad, ch, st, seat, pickTime, customer);
        merchandise = merch;
        this.customer = customer;
    }
    
    //setter
    public void setMerchandise(boolean merch) {merchandise = merch;}

    //getter
    public boolean getMerchandise() {return merchandise;}

    //processor
    public double calcPrice(int adult, int child, int student){
        double price = 0.0;
        if(super.getMovie() == 1){
            price = (35 * adult) + (28 * child) + (32 * student);
        } else if(super.getMovie() == 2){
            price = (38 * adult) + (30 * child) + (35 * student);
        } else if(super.getMovie() == 3){
            price = (32 * adult) + (20 * child) + (30 * student);
        }

        if(!merchandise)
            price += 45;

        try{
            BufferedReader br = new BufferedReader(new FileReader("registeredUser.txt"));
            String line = br.readLine();
            while(line != null){
                StringTokenizer st = new StringTokenizer(line, ";");
                String username = st.nextToken();
                String password = st.nextToken();
                String member = st.nextToken();
                // if(super.getUsername().equals(username)){
                if(customer.getUsername().equals(username)){
                    if(member.equals("true")){
                        price *= 0.7;
                    }
                }
                line = br.readLine();
            }

            return price;
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            return 0;
        }

    }   
}