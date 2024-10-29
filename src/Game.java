import java.util.Scanner;

public class Game {
    public void delay(int ms) {
        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - ms);
    }

    public void runGame() {
        Scanner playerInput = new Scanner(System.in);
        Deck deck = new Deck();

        deck.shuffle();

        Hand playerHand = new Hand("Player");
        playerHand.add(deck.deal());
        playerHand.add(deck.deal());
        playerHand.show();
        delay(500);
        playerHand.displayValue();

        Hand dealerHand = new Hand("Dealer");
        dealerHand.add(deck.deal());
        delay(1000);
        dealerHand.show();
        dealerHand.add(deck.deal());
        boolean turnEnded = false;
        while (playerHand.handValue() < 21 && !turnEnded) {
            delay(1000);
            System.out.println("\nHit or Stand?");
            String choice = playerInput.nextLine();
            if (choice.equals("s")) {
                delay(500);
                System.out.println("You Stand with a hand value of " + playerHand.handValue());
                turnEnded = true;
            }
            else {
                playerHand.add(deck.deal());
                playerHand.show();
                delay(500);
                playerHand.displayValue();
            }
        }
        if (playerHand.handValue() == 21) {
            System.out.println("\n---Blackjack!---");
        }
        if (playerHand.handValue() > 21) {
            System.out.println("\nBust D:");
            //System.out.println(playerHand.handValue());
        }
        if (playerHand.handValue() < 21) {
            dealerHand.show();
            delay(500);// Dealer's turn
            while (dealerHand.handValue() < 17 ) {
                dealerHand.add(deck.deal());
                dealerHand.showNewestCard();
                delay(500);
            }
            if (dealerHand.handValue() < playerHand.handValue() || dealerHand.handValue() > 21) {
                System.out.println("\nYou Win! ");
                delay(500);
                System.out.println(dealerHand.handValue() + " vs " + playerHand.handValue());
            }
            if (dealerHand.handValue() == playerHand.handValue()) {
                System.out.println("\nDraw... ");
                delay(500);
                System.out.println(dealerHand.handValue() + " vs " + playerHand.handValue());
            }
            if (dealerHand.handValue() > playerHand.handValue() && dealerHand.handValue() <= 21)  {
                System.out.println("\nYou Lose... ");
                delay(500);
                System.out.println(dealerHand.handValue() + " vs " + playerHand.handValue());
            }

        }
        delay(1000);
    }
}
