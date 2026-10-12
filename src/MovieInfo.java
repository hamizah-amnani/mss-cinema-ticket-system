public class MovieInfo{
    //attributes
    private int movieID;
    private String movieName;
    private String movieRated;
    private String movieGenre;
    private String movieDirector;
    private String movieCast;
    private String movieTime;

    //normal constructor
    public MovieInfo(int movieID, String movieName, String movieRated, String movieGenre, String movieDirector,String movieCast, String movieTime) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.movieRated = movieRated;
        this.movieGenre = movieGenre;
        this.movieDirector = movieDirector;
        this.movieCast = movieCast;
        this.movieTime = movieTime;
    }

	//setter
    public void setMovieID(int movieID) {this.movieID = movieID;}
    public void setMovieName(String movieName) {this.movieName = movieName;}
    public void setMovieRated(String movieRated) {this.movieRated = movieRated;}
    public void setMovieGenre(String movieGenre) {this.movieGenre = movieGenre;}
    public void setMovieDirector(String movieDirector) {this.movieDirector = movieDirector;}
    public void setMovieCast(String movieCast) {this.movieCast = movieCast;}
    public void setMovieTime(String movieTime) {this.movieTime = movieTime;}

	//getter
    public int getMovieID() {return movieID;}
    public String getMovieName() {return movieName;}
    public String getMovieRated() {return movieRated;}
    public String getMovieGenre() {return movieGenre;}
    public String getMovieDirector() {return movieDirector;}
    public String getMovieCast() {return movieCast;}
    public String getMovieTime() {return movieTime;}
    
    //processor
    public String displayMenu(){
        String line1 = "\n<< " + movieName + "(" + movieRated + ")";
        String line2 = "\n<< " + movieGenre; 
        String line3 = "\n<< Movie Director :" + movieDirector;
        String line4 = "\n<< Movie Casts :" + movieCast;
        
        String[] showtime = getMovieTime().split("/");
        
		String line5 = "\n<< Showtime 1: " + showtime[0];
        String line6 = "\n<< Showtime 2: " + showtime[1];
		String line7 = "\n<< Showtime 3: " + showtime[2];
		
        return line1 + line2 + line3 + line4 + line5 + line6 + line7;
    }
    
}