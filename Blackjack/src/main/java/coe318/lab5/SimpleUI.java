package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        CardPile houseCards = game.getHouseCards();
        CardPile playerCards = game.getYourCards();
        int houseScore = game.score(houseCards);
        int playerScore = game.score(playerCards);

        System.out.println("house cards: " + houseCards);
        

        System.out.println("Player cards: " + playerCards);
        System.out.println("{Player score: " + playerScore);
    }

  @Override
    public boolean hitMe() {
        // Ask the player if they want to hit (get another card).
        System.out.print("Hit? (add another card?) (answer either: yes or no): ");
        String input = user.nextLine().toLowerCase();
        return input.equals("yes");
    }

  @Override
    public void gameOver() {
       // Display the game outcome (win, lose, or tie).
        int houseScore = game.score(game.getHouseCards());
        int playerScore = game.score(game.getYourCards());

        if (playerScore > 21 || (houseScore <= 21 && houseScore >= playerScore)) {
            System.out.println("house score: "+ houseScore);
            System.out.println("Player score:"+ playerScore);
            for (Card card : game.getHouseCards().getCards()) {
           card.setFaceUp(true);
            }
            System.out.println("house cards: "+ game.getHouseCards());
            System.out.println("You Have Lost");
        } else if (houseScore > 21 || (playerScore <= 21 && playerScore > houseScore)) {
            System.out.println(""+ houseScore);
            System.out.println("You Have Won!!!");
        } else {
            System.out.println("TIE GAME");
        }
    }
}