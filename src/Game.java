// The goal of this exercise is to see how much of a Game of command line blackjack I can make in 90 minutes of testing.
// Before the timer begins I will be queueing up ~90 minutes of music on youtube and starting a 90 minute timer on google.
// I have also created empty classes called "Game, Deck, and WinConditions" as fiddling around with menus seems outside the scope
// Minimum success criteria: Game will use a single Deck of cards with 52 unique cards A-K of hearts, diamonds, clubs and spades to deal 1 computer and 1 player a hand.
// The computer will always hit until 17 or greater, the other player will be human controlled.  Whomever is closer to 21 wins, with automatic win conditions being either blackjack
// (a jack of either clubs or spades and a second card who's value is 10).  Human player will have some amount of money which will be "bet".  Game will run in a loop until player runs out
// of money or "leaves table".

//90 minutes is up: All todo's added after time ran out.
//Todo: Menus will loop when you win and will not exit when you select "win table", can be fixed by checking "choice" before shuffle in main method.
//Todo: Implement double down / insurance
//Todo: Implement proper win checking in game loop
//Todo: properly increment player money on win.
public class Game {
    public static void main(String args[]) {
        Deck myDeck = new Deck();
        Player human = new Player();
        Player computer = new Player(50000);
        int choice = 0;

        while(choice != 2){
            choice = Menus.mainMenu();
            myDeck.shuffle();
            int bid;
            bid = Menus.startBid(human);
            myDeck.deal(human, computer);
            int win = Menus.hitOrStand(human, computer, myDeck);
            if (win == 1){
                human.money+= bid*2;
                computer.money -= bid;
            }
            human.clearHand();
            computer.clearHand();
        }
        System.out.println("Thanks for playing");

    }
}
