public class Deck {
    private Cards[] allCards;

    public Deck() {
        //initialise deck
        allCards = new Cards[52];

        //suits
        //hearts

        for (int i = 1; i <= 13; i++) {
            Cards c = new Cards("Hearts", i);
            allCards[i-1] = c;
        }
        /*for (int i = 0; i < allCards.length; i++) {
            allCards[i].display();
        }
        */

    }
}
