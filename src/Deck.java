import java.util.Random;

@SuppressWarnings("FieldMayBeFinal")
public class Deck {
    private Cards[] allCards;
    private int topCard = 0;

    public Deck() {
        //initialise deck
        allCards = new Cards[52];
        String[] listOfSuits = {"Hearts", "Spades", "Clubs", "Diamonds"};
        //suits
        for (int j = 0; j < 4; j++) {  //each loop of this changes the suit
            for (int i = 1; i <= 13; i++) {
                Cards c = new Cards(listOfSuits[j], i);
                allCards[i - 1 + (j * 13)] = c;
            }
        }
    }
    public void display() {
        for (Cards allCard : allCards) {
            allCard.display();
        }
    }
    public void shuffle() {
        topCard = 0;
        for (int i = allCards.length-1; i > 0;i--) {
            Random r = new Random();
            int j = r.nextInt(0,i);
            Cards temp = allCards[i];
            allCards[i] = allCards[j];
            allCards[j] = temp;
        }
    }
    public Cards deal() {
        Cards temp = allCards[topCard];
        topCard++;
        return temp;
    }
}
