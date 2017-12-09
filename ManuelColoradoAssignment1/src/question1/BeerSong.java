package question1;

public class BeerSong {

	public static void main(String[] args) {
        int numOfBeers = 99; //Starting number of beers

        while (numOfBeers > 0) {
        	// Sing the beer song while we have enough beers
            singBeerSong(numOfBeers);
            
            // Reduce total of beers after we've taken one
            numOfBeers --;
        }
    }

    private static void singBeerSong(int numOfBeers) {
    	// We obtain the string of total bottles
    	String bottleText = stringifyBeer(numOfBeers);
        // Initialize the verse
    	String song = "";
        		
    	// Main verse
        song = bottleText + " of beer on the wall\n" +
                bottleText + " of beer\n" +
                "\tTake one down\n" +
                "\tPass it around\n" +
                "\n";

        // Last phrase of the verse, changes depending on the amount of remaining bottles
        if (numOfBeers <= 1) {
            song += "No more bottles of beer on the wall";
        } else {
            song += stringifyBeer(numOfBeers - 1) + " of beer on the wall\n";
        }

        // Print the whole verse on the console
        System.out.println(song);
    }
    
    private static String stringifyBeer(int numOfBeers) {
    	// We convert the number of beers (int) to a string
    	// This method also returns singular or plural word bottle
    	String text = numOfBeers + " bottle";
        if (numOfBeers != 1) text += "s";
    	return text;
    }
    
}
