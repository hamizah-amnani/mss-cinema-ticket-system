import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GoldTicket extends Ticket{
    //normal constructor
    public GoldTicket(int mv,int ad, int ch, int st, String seat, int pickTime, Customer customer){
        super(mv, ad, ch, st, seat, pickTime, customer);
    }

	//processor
    public double calcPrice(int adult, int child, int student){
        double price = 0.0;
        if(super.getMovie() == 1){
            price = (25 * adult) + (19 * child) + (22 * student);
        } else if(super.getMovie() == 2){
            price = (24 * adult) + (15 * child) + (20 * student);
        } else if(super.getMovie() == 3){
            price = (20 * adult) + (12 * child) + (15 * student);
        }

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
	