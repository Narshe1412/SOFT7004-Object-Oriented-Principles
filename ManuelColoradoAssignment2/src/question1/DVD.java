package question1;

//Part c) Create DVD class
/*
 * Class diagram
 * +---------------------+
 * |  DVD                |
 * |---------------------|
 * | title: String       |
 * | artist: String      |
 * | genre: String       |
 * |---------------------|
 * | DVD()               |
 * | DVD(String, String) |
 * | setTitle(String)    |
 * | setArtist(String)   |
 * | setGenre(String)    |
 * | print()             |
 * +---------------------+
 * 
 * 
 * */

public class DVD { 
	private String title, artist, genre;
	
	//Constructors
	public DVD() {
		this("","");
		genre = "";
	}

	public DVD(String title, String artist) {
		setTitle(title);
		setArtist(artist);
	}

	// Mutators
	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	// Accessors
	// - not needed: They are not used for this class
	
	// Methods
	public void print() {
		System.out.println("Song: " + title + "\n" + 
				"Artist: " + artist + "\n" + 
				"Genre: " + (genre == "" ? "N/A": genre)); //Prints N/A if genre is Not Available
	}

}
