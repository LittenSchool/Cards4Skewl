public class Deck {
    private Cards[] allCards;

    public Deck() {
        //initialise deck
        allCards = new Cards[52];
        String[] listOfSuits = {"Hearts","Spades","Clubs","Diamonds"};
        //suits
        //hearts
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i <= 13; i++) {
                Cards c = new Cards(listOfSuits[j], i);
                allCards[i - 1] = c;
            }
        }
        for (Cards allCard : allCards) {
            allCard.display();
        }
        }
}
