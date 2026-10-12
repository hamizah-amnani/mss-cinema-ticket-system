import java.util.*;
import java.io.*;
import java.text.*;

public class TicketApp {

    // SEAT ARRANGEMENT
    static String displaySeat(int ticketChoice) {
        String line1, line2, line3, line4, line5, line6, line7, line8, line9;
        if (ticketChoice == 2) {
            line1 = "\n---------------------------SEAT SELECTION---------------------------------";
            line2 = "\n__________________________________________________________________________";
            line3 = "\n                               SCREEN\n\n";
            line4 = "\n[ A1  A2 ]         [ A3 ]  [ A4 ]  [ A5 ]  [ A6 ]  [ A7 ]       [ A8  A9 ]";
            line5 = "\n[ B1  B2 ]         [ B3 ]  [ B4 ]  [ B5 ]  [ B6 ]  [ B7 ]       [ B8  B9 ]";
            line6 = "\n[ C1  C2 ]         [ C3 ]  [ C4 ]  [ C5 ]  [ C6 ]  [ C7 ]       [ C8  C9 ]";
            line7 = "\n[ D1  D2 ]         [ D3 ]  [ D4 ]  [ D5 ]  [ D6 ]  [ D7 ]       [ D8  D9 ]";
            line8 = "\n[ E1  E2 ]         [ E3 ]  [ E4 ]  [ E5 ]  [ E6 ]  [ E7 ]       [ E8  E9 ]";
            line9 = "\nEXIT/IN  ________________________________________________________  EXIT/IN";
        } else {
            line1 = "\n---------------------------SEAT SELECTION---------------------------------";
            line2 = "\n__________________________________________________________________________";
            line3 = "\n                               SCREEN\n\n";
            line4 = "\n[A1][A2]    [A3][A4][A5][A6][A7][A8][A9][A10][A11][A12][A13]    [A14][A15]";
            line5 = "\n[B1][B2]    [B3][B4][B5][B6][B7][B8][B9][B10][B11][B12][B13]    [B14][B15]";
            line6 = "\n[C1][C2]    [C3][C4][C5][C6][C7][C8][C9][C10][C11][C12][C13]    [C14][C15]";
            line7 = "\n[D1][D2]    [D3][D4][D5][D6][D7][D8][D9][D10][D11][D12][D13]    [D14][D15]";
            line8 = "\n[E1][E2]    [E3][E4][E5][E6][E7][E8][E9][E10][E11][E12][E13]    [E14][E15]";
            line9 = "\nEXIT/IN  ________________________________________________________  EXIT/IN";
        }

        return line1 + line2 + line3 + line4 + line5 + line6 + line7 + line8 + line9;
    }

    // FOOD MENU
    static void foodMenu() {
        System.out.print("\n\n--------------------FOOD & BEVERAGES SELECTION--------------------");
        System.out.print("\nSET 1 (SINGLE COMBO) - RM 9.50");
        System.out.print("\n _______________________________");
        System.out.print("\n| 1 - CARAMEL POPCORN  (M)      |");
        System.out.print("\n -------------------------------");
        System.out.print("\n| 1 - SOFT DRINK  (M)           |");
        System.out.print("\n|       OR MINERAL WATER 500ml  |");
        System.out.print("\n _______________________________");

        System.out.print("\nSET 2 (COUPLE COMBO) - RM 15.00");
        System.out.print("\n _______________________________");
        System.out.print("\n| 1 - CARAMEL POPCORN  (M)      |");
        System.out.print("\n -------------------------------");
        System.out.print("\n| 2 - SOFT DRINK  (M)           |");
        System.out.print("\n|       OR MINERAL WATER 500ml  |");
        System.out.print("\n -------------------------------");
        System.out.print("\n| 1 - NUGGET / MEATBALL (L)     |");
        System.out.print("\n _______________________________");

        System.out.print("\nSET 3 (FAMILY COMBO) - RM45.00 ");
        System.out.print("\n _______________________________");
        System.out.print("\n| 2 - CARAMEL POPCORN  (L)      |");
        System.out.print("\n -------------------------------");
        System.out.print("\n| 4 - SOFT DRINK  (M)           |");
        System.out.print("\n|       OR MINERAL WATER 500ml  |");
        System.out.print("\n -------------------------------");
        System.out.print("\n| 1 - NUGGET / MEATBALL (L)     |");
        System.out.print("\n -------------------------------");
        System.out.print("\n| 2 - HOTDOG                    |");
        System.out.print("\n _______________________________");

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        final int size = 40;
        try {
            // file input/output
            BufferedWriter outRegisterUser = new BufferedWriter(new FileWriter("registeredUser.txt", true));
            //decimal
            DecimalFormat df = new DecimalFormat("##,###.00");
            // declare
            Admin[] admin = new Admin[size];
            Customer[] cust = new Customer[size];
            MovieInfo movieInfo[] = new MovieInfo[size];

            String inData = null;
            int countMovie = 0, countCust = 0, countAdmin = 0;
            // READ FILE CUSTOMER
            BufferedReader inRegisterUser = new BufferedReader(new FileReader("registeredUser.txt"));
            while ((inData = inRegisterUser.readLine()) != null) {
                StringTokenizer c = new StringTokenizer(inData, ";");
                String nm = c.nextToken();
                String pass = c.nextToken();
                boolean mbr = Boolean.parseBoolean(c.nextToken());

                cust[countCust] = new Customer(nm, pass, mbr);
                countCust++;
            }

            // READ FILE INPUT ADMIN
            BufferedReader in = new BufferedReader(new FileReader("admin.txt"));
            while ((inData = in.readLine()) != null) {
                StringTokenizer adm = new StringTokenizer(inData, ";");
                String id = adm.nextToken();
                String pw = adm.nextToken();

                admin[countAdmin] = new Admin(id, pw);
                countAdmin++;
            }

            // READ FILE INPUT MOVIE
            BufferedReader inMovieInfo = new BufferedReader(new FileReader("movie.txt"));
            while ((inData = inMovieInfo.readLine()) != null) {
                StringTokenizer info = new StringTokenizer(inData, ";");
                int movieID = Integer.parseInt(info.nextToken());
                String movieName = info.nextToken();
                String movieRated = info.nextToken();
                String movieGenre = info.nextToken();
                String movieDirector = info.nextToken();
                String movieCast = info.nextToken();
                String movieTime = info.nextToken();

                movieInfo[countMovie] = new MovieInfo(movieID, movieName, movieRated, movieGenre, movieDirector,movieCast, movieTime);
                countMovie++;
            }
            in.close();
            inRegisterUser.close();
            inMovieInfo.close();

            // choose admin or customer
            System.out.println("ENTER 1 FOR CUSTOMER LOGIN");
            System.out.println("ENTER 2 FOR ADMIN LOGIN");
            System.out.print("--> ");
            int choice = scan.nextInt();

            String NM, PASS;
            double price = 0;
            double  totalPayment = 0;
            double merchPrice = 0;
            int set = 0;
            String movie = null, time = null;
            int ad = 0, ch = 0, st = 0;
            String seatNum = null;
            int i = 0;
            PrintWriter updateMovie = null;
            // CUSTOMER
            if (choice == 1) {
                System.out.println("-------------MSS CINEMA CUSTOMER LOGIN-------------");

                // REGISTER @ NONREGISTER USER
                System.out.println("      A - LOGIN     |     B - REGISTER");
                System.out.print("--> ");
                String insert = scan1.nextLine();

                boolean isExist = false;
                // LOG IN USER
                if (insert.equalsIgnoreCase("A")) {
                    System.out.print("Username: ");
                    NM = scan1.nextLine();
                    System.out.print("Password: ");
                    PASS = scan1.nextLine();

                    // verify account
                    Customer custs = new Customer(NM, PASS, false);
                    isExist = custs.CustomerVerification(NM, PASS);
                    while (isExist == false) {
                        System.out.println("Invalid username or password. Please try again.");
                        System.out.print("Username: ");
                        NM = scan1.nextLine();
                        System.out.print("Password: ");
                        PASS = scan1.nextLine();

                        custs = new Customer(NM, PASS, false);
                        isExist = custs.CustomerVerification(NM, PASS);
                    }
                } 
                else {
                    System.out.print("New Username: ");
                    NM = scan1.nextLine();
                    System.out.print("New Password: ");
                    PASS = scan1.nextLine();

                    outRegisterUser.write("\n" + NM + ";" + PASS + ";false");

                    System.out.println("Register complete. Please log in again.");
                }

                if (isExist == true) {
                    System.out.println("\nLogin successful.");

                    // ENTERING ONLINE CINEMA...
                    System.out.println("----------------WELCOME TO MSS CINEMA----------------");
                    System.out.println("SHOWING TODAY!!");

                    while (i < countMovie) {
                        System.out.println(movieInfo[i].displayMenu());
                        i++;
                    }
                    // OPTIONS FOR CUSTOMER
                    int choose = 0;
                    System.out.println("\n1 - ORDER TICKET");
                    System.out.println("2 - MEMBERSHIP");
                    System.out.print(">> ");
                    choose = scan.nextInt();

                    if (choose == 1) {
                        System.out.print("GOLD(1) // PREMIERE(2) >> ");
                        int ticketChoice = scan.nextInt();
                        int j = 0;
                        while (j < countMovie) {
                            // while(j < i){
                            System.out.println("\n MOVIE " + (j + 1) + "  >> " + movieInfo[j].getMovieName());
                            j++;
                        }

                        System.out.print("\nSELECT MOVIE >> ");
                        int mv = scan.nextInt();

                        System.out.print("NUMBER OF ADULTS >> ");
                        ad = scan.nextInt();
                        System.out.print("NUMBER OF CHILDREN >> ");
                        ch = scan.nextInt();
                        System.out.print("NUMBER OF STUDENTS >> ");
                        st = scan.nextInt();

                        System.out.println(displaySeat(ticketChoice));

                        System.out.print("SEAT NUMBER (example: A1,A2,A3)>> ");
                        seatNum = scan1.nextLine();

                        System.out.print("SHOWTIME (1/2/3) >>");
                        int pickTime = scan.nextInt();

                        System.out.print("ADD ON FOOD? (Y/N): ");
                        String foodset = scan1.nextLine();

                        // for(i = 0; i < size; i++){
                        boolean merch = false;
                        if (ticketChoice == 2) {
                            System.out.print("BUY MERCHANDISE? (true/false) >> ");
                            merch = scan.nextBoolean();
                        }

                        String[] showtime = movieInfo[mv - 1].getMovieTime().split("/");

                        for (i = 0; i < showtime.length; i++) {
                            if (pickTime == i)
                                time = showtime[i - 1];
                        }

                        // to print movie name
                        movie = movieInfo[mv - 1].getMovieName();

                        double foodPrice = 0;
                        if (foodset.equalsIgnoreCase("Y")) {
                            foodMenu();
                            System.out.print("\nFOOD SET?(1/2/3) >> ");
                            set = scan.nextInt();
                            System.out.print("QUANTITY >> ");
                            int quantity = scan.nextInt();
                            if (set == 1)
                                foodPrice = 9.50 * quantity;
                            else if (set == 2)
                                foodPrice = 15 * quantity;
                            else
                                foodPrice = 45 * quantity;
                        } else {
                            foodPrice = 0;
                        }

                        // CALCULATE PRICE
                        Customer custs = new Customer(NM, PASS, false);
                        
                        if(ticketChoice == 1){
                            GoldTicket gt = new GoldTicket(mv, ad, ch, st, seatNum, pickTime, custs);
                            price = gt.calcPrice(ad, ch, st);
                        } 
                        else {
                            PremiereTicket pt = new PremiereTicket(mv, ad, ch, st, seatNum, pickTime, merch, custs);
                            price = pt.calcPrice(ad, ch, st);
                        }

                        totalPayment = price + foodPrice;
                        
                        // RECEIPT
                        System.out.println(" __________________________________________________");
                        System.out.println("|-----------------MSS CINEMA-------------------------|");
                        System.out.println("|====================================================|");
                        System.out.println("|-------------THANK YOU FOR YOUR PURCHASE------------|");
                        System.out.println("\n|Ticket Details:                                   |");
                        System.out.println("|Movie Name: " + movie);
                        System.out.println("|Showing time: " + time);
                        System.out.println("\n|Customer details:               ");
                        System.out.println("|Seats: " + seatNum);
                        System.out.println("|Number of adults: " + ad);
                        System.out.println("|Number of child: " + ch);
                        System.out.println("|Number of students: " + st);
                        System.out.println("|Food set: " + set);
                        System.out.println("|Total price to be paid:         ");
                        System.out.println("|RM" + df.format(totalPayment));
                        System.out.println("|Payment via online banking.                         |");
                        System.out.println("|====================================================|");
                        System.out.println("|----------------------------------------------------|");
                        System.out.println(" ____________________________________________________");
                        i++;

                        System.out.println("THANK YOU FOR YOUR PURCHASE! LOGGING OUT...");
                    } else {
                        for (i = 0; i < size; i++) {
                            if (cust[i].getUsername().equalsIgnoreCase(NM)) {
                                if (cust[i].getMember() == true) {
                                    System.out.println("You are already a member! LOGGING OUT...");
                                    break;
                                } else {
                                    System.out.println(
                                            "You are not a member. Would you like to subscribe? (Y/N) >> ");
                                    String subs = scan1.nextLine();
                                        if (subs.equalsIgnoreCase("Y")) {
                                            System.out.println("Congrats! You have become a member! LOGGING OUT..");
                                        } 
                                        else
                                            break;
                                    
                                }
                            }
                        }
                    }
                }
            }
            // ADMIN
            else {
                System.out.println("-----------MSS CINEMA ADMIN LOGIN---------");
                System.out.println("Username: ");
                String ID = scan1.nextLine();
                System.out.println("Password: ");
                String PW = scan1.nextLine();

                // verify account
                Admin adm = new Admin(ID, PW);
                boolean isExist = adm.AdminVerification(ID, PW);

                while (isExist == false) {
                    System.out.println("Invalid username or password. Please try again.");
                    System.out.println("Username: ");
                    ID = scan1.nextLine();
                    System.out.println("Password: ");
                    PW = scan1.nextLine();

                    adm = new Admin(ID, PW);
                    isExist = adm.AdminVerification(ID, PW);
                }

                if (isExist == true) {
                    System.out.println("Login successful.");

                    updateMovie = new PrintWriter(new BufferedWriter(new FileWriter("movie.txt")));

                    System.out.print("Enter movie ID for update >> ");
                    String movieID = scan1.nextLine();

                    // ENTER NEW DATA FOR MOVIE
                    for (i = 0; i < countMovie; i++) {
                        System.out.print("\n-------------------------UPDATE NEW MOVIE---------------------------");

                        System.out.print("Enter new movie release >> ");
                        String movieName = scan1.nextLine();
                        System.out.print("\nMovie description : ");
                        System.out.print("Movie rated    >> ");
                        String movieRated = scan1.nextLine();
                        System.out.print("Movie Genre    >> ");
                        String movieGenre = scan1.nextLine();
                        System.out.print("Movie Director >>");
                        String movieDirector = scan1.nextLine();
                        System.out.print("Movie Cast (Name/Name)  >>");
                        String movieCast = scan1.nextLine();
                        System.out.print("Movie Time (Time/Time/Time)   >>");
                        String movieTime = scan1.nextLine();
                        System.out.println(">> Premiere Price");
                        System.out.print("Adult Price/Children Price/Student Price: ");
                        String pp = scan1.nextLine();
                        System.out.println(">> Gold Price");
                        System.out.print("Adult Price/Children Price/Student Price: ");
                        String gp = scan1.nextLine();

                        if (Integer.parseInt(movieID) == movieInfo[i].getMovieID()) {
                            updateMovie.println(movieID + ";" + movieName + ";" + movieRated + ";" + movieGenre + ";"
                                    + movieDirector + ";" + movieCast + ";" + movieTime + ";" + pp + ";" + gp);
                        }
                    }
                }
            }
            inRegisterUser.close();
            if (updateMovie != null) updateMovie.close();
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}