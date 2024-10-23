import java.util.ArrayList;

public class Hand {
    private ArrayList<Cards> cards = new ArrayList<>();
    private String name;

    public Hand(String name) {
        this.name = name;
    }
    public void add(Cards card) {
        cards.add(card);
    }
    public void show() {
        System.out.println(name + "'s Hand:");
        for (int i = 0; i < cards.size();i++) {
            cards.get(i).display();
        }

    }


}
