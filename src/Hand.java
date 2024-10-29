import java.util.ArrayList;

public class Hand {
    private ArrayList<Cards> cards = new ArrayList<>();
    private String name;

    public void delay(int ms) {
        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - ms);
    }

    public Hand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Cards card) {
        cards.add(card);
    }

    public void show() {
        System.out.println("\n" + name + "'s Hand:");
        for (int i = 0; i < cards.size();i++) {
            delay(500);
            cards.get(i).display();
        }
    }

    public void showNewestCard() {
        cards.getLast().display();
    }

    public int blackjackValue(String cardValue) {
        String[] listOfFaces = {"King", "Queen", "Jack",};
        for (int i = 0; i < listOfFaces.length;i++) {
            if (cardValue.equals(listOfFaces[i])) {
                return 10;
            }
        }
        if (cardValue.equals("Ace")) {
            return 11;
        }
        else {
            return Integer.parseInt(cardValue);
        }

    }
    public int handValue() {

        int value = 0;
        int numAces = 0;

        for (int i = 0; i < cards.size();i++) {
            value += blackjackValue(cards.get(i).getValue());
            if (cards.get(i).getValue().equals("Ace")) {
                numAces++;
            }
        }

        if (value > 21) { //Reduces value of hand if there are aces
            while (numAces > 0) {
                value -= 10;
                numAces--;
            }
        }

        return value;

    }

    public void displayValue() {
        System.out.println("Value of " + getName() + "'s hand: " + handValue());
    }


}
