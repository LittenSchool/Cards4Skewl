import java.util.ArrayList;

public class Hand {
    private ArrayList<Cards> cards = new ArrayList<>();
    private String name;

    public Hand(String name) {
        this.name = name;
    }

    public void show() {
        for (int i = 0; i < cards.size();i++) {
            System.out.println(cards.get(i));
        }

    }


}
