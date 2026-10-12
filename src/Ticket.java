public abstract class Ticket{
	//attributes
	protected int selectMovie;
    protected int adult;
    protected int children;
    protected int student;
    protected String seatNum;
    protected int showtime;
    protected Customer customer;

    //normal constructor
    public Ticket(int mv, int ad, int ch, int st, String seat, int pickTime, Customer c){
        selectMovie = mv;
		adult = ad;
		children = ch;
		student = st;
		seatNum = seat;
        showtime = pickTime;
        customer = c;
	}

    //setter
    public void setMovie(int mv) {selectMovie = mv;}
    public void setAdult(int ad) {adult = ad;}
    public void setChildren(int ch) {children = ch;}
    public void setStudent(int st) {student = st;}
    public void setSeatNum(String seat) {seatNum = seat;}
    public void setShowtime(int pickTime) {showtime = pickTime;}
    
    //getter
    public int getMovie() {return selectMovie;}
    public int getAdult() {return adult;}
    public int getChildren() {return children;}
    public int getStudent() {return student;}
    public String getSeatNum() {return seatNum;}
    public int getShowtime() {return showtime;}

    //processor
    public abstract double calcPrice(int adult, int child, int student);
 
}