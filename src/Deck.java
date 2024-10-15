public class Deck {
    private Cards[] allCards;
    private String[] allCardString = new String[52];
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
        for (int i = 0; i < allCards.length; i++) {

            allCardString[i] = allCards[i].getValue() + " of " + allCards[i].getSuit();
        }

    }

    public String[] alphabetSort(String[] list) {
            boolean sorted = false;
            int i = 0;
            int counter = 0;
            int temp = 0;
            while (!sorted) {

                if (list[i].compareTo( list[i+1])) {
                    temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                }

                i++;
                if (i == list.length-2-counter){
                    i = 0;
                    counter++;
                }

                if (counter == list.length) {
                    sorted = true;
                }
            }
            return list;
        }


    }

    public void displayAll() {
        for (int i = 0; i < allCards.length; i++) {
            System.out.println(allCardString[i]);
        }
    }
}
