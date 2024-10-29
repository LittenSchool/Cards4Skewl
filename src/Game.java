import java.util.Scanner;

public class Game {
    public void runGame() {
        Scanner playerInput = new Scanner(System.in);
        Deck deck = new Deck();

        deck.shuffle();

        Hand playerHand = new Hand("Player");
        playerHand.add(deck.deal());
        playerHand.add(deck.deal());
        playerHand.show();
        playerHand.displayValue();

        Hand dealerHand = new Hand("Dealer");
        dealerHand.add(deck.deal());
        dealerHand.show();
        dealerHand.add(deck.deal());
        boolean turnEnded = false;
        while (playerHand.handValue() < 21 && !turnEnded) {
            System.out.println("\nHit or Stand?");
            String choice = playerInput.nextLine();
            if (choice.equals("s")) {
                System.out.println("You Stand with a hand value of " + playerHand.handValue());
                turnEnded = true;
            }
            else {
                playerHand.add(deck.deal());
                playerHand.show();
                System.out.println("Value of hand: " + playerHand.handValue());
            }
        }
        if (playerHand.handValue() == 21) {
            System.out.println("Blackjack! \n");
        }
        if (playerHand.handValue() > 21) {
            System.out.println("Bust D: \n");
            //System.out.println(playerHand.handValue());
        }
        if (playerHand.handValue() < 21) {
            dealerHand.show(); // Dealer's turn
            while (dealerHand.handValue() < 17 ) {
                dealerHand.add(deck.deal());
                dealerHand.showNewestCard();
            }
            if (dealerHand.handValue() < playerHand.handValue() || dealerHand.handValue() > 21) {
                System.out.println("You Win! \n");
                System.out.println(dealerHand.handValue() + " vs " + playerHand.handValue());
            }
            if (dealerHand.handValue() == playerHand.handValue()) {
                System.out.println("Draw... \n");
                System.out.println(dealerHand.handValue() + " vs " + playerHand.handValue());
            }
            if (dealerHand.handValue() > playerHand.handValue() && dealerHand.handValue() <= 21)  {
                System.out.println("You Lose... \n");
                System.out.println(dealerHand.handValue() + " vs " + playerHand.handValue());
            }

        }
    }
}
