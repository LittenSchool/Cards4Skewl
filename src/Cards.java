public class Cards {
    private String suit;
    private int value;

    public Cards(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    public String getSuit() {
        return suit;
    }
    public String getValue() {
        if (value == 13) {
            return "King";
        } else if (value == 12) {
            return "Queen";
        } else if (value == 11) {
            return "Jack";
        } else if (value == 1) {
            return "Ace";
        } else {
            return Integer.toString(value);
        }
    }
    public void display() {
        System.out.println(getValue() + " of " + getSuit());
    }

/*I made a change again*/

}
