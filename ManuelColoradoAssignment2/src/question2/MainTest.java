package question2;

import java.util.ArrayList;

public class MainTest {

	// These two methods and public variable simulate a database being queried line by line 
	// in search of actors. You can change the method to get inputs from keyboard, query an
	// URL or a database file/server hence allowing for different implementations without
	// changing the functionality
	private static int simDB = 2; 
	
	private static Actor getActorfromDB() {
		Actor queryResult;
		switch(simDB) {
			case 1: 
				queryResult = new Actor("Jack Nicholson", "Miami", 74);
				queryResult.setFilm(
						new Film[] {
							new Film("Wolf") , 
							new Film("As good as it gets"),
							new Film("One flew over the Cuckoo's nest")
							});
				break;
			case 2:
				queryResult = new Actor("Violante Placido", "Bologna", 38);
				queryResult.setFilm(
						new Film[] {
								new Film("The American"),
								new Film("Ghost Rider spirit of vengeance"),
								new Film("Barah Aanan")
						});
				break;
			default:
				queryResult = null;
		}
		simDB --;
		return queryResult;
	}

	private static boolean isDBempty() {
		return (simDB == 0);
	}

	
	public static void main(String[] args) {
		//Initialize arraylist and array of films
		ArrayList<Actor> filmophile = new ArrayList<Actor>();
		
		
	/* Previous version of the main, commented as per exercise requirements
	 * 
	 	//Create an array to store the films before passing them to the Actor object
	 	Film[] filmList = new Film[3];
	 	
		//Create new actor Jack
		Actor jack = new Actor("Jack Nicholson", "Miami", 74);
		//Record three films into the same place
		filmList[0] = new Film("Wolf");
		filmList[1] = new Film("As good as it gets");
		filmList[2] = new Film("One flew over the Cuckoo's Nest");
		//Copy them into the Actor film storage
		jack.setFilm(filmList);
		//And add the actor to the arraylist collection
		filmophile.add(jack);
		
		//Repeat for the second actor
		Actor violante = new Actor("Violante Placido", "Bologna", 38);
		filmList[0] = new Film("The American");
		filmList[1] = new Film("Ghost Rider spirit of vengeance");
		filmList[2] = new Film("Barah Aanan");
		violante.setFilm(filmList);
		
		filmophile.add(violante);
	*/
		
		while (isDBempty() == false) {
			filmophile.add(getActorfromDB()); //We obtain actor data as long as the external DB
			// keeps providing information and it's not empty
		}
		
		// we transverse the arraylist to print all actor data individually
		for (Actor actor : filmophile) {
			actor.print();
			System.out.println();
		}
	}
}
