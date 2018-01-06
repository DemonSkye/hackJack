import java.util.Scanner;

public class Menus {
    public static int mainMenu(){
        System.out.println("Welcome to the casino, today we're playing blackjack");
        System.out.println("1. Start New Game");
        System.out.println("2. Leave Table");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        while(choice != 1 && choice != 2){
            System.out.println("Invalid choice, please try again");
            System.out.println("1. Start New Game");
            System.out.println("2. Leave Table");
            choice = input.nextInt();
        }

        if(choice == 1){
            return 1;
        }
        if( choice == 2){
            return -1;
        }
        return 0;
    }

    public static int startBid(Player humanPlayer){
        System.out.println("How much would you like to bid on the following hand?");
        System.out.println("You have: " + humanPlayer.money + "$ available");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        while(choice <=1 || choice > humanPlayer.money){
            System.out.println("You cannot bid negative money or more money than you presently have");
            System.out.println("How much would you like to bid on the following hand?");
            System.out.println("You have: " + humanPlayer.money + "$ available");
            choice = input.nextInt();
        }
        humanPlayer.money -= choice;
        return choice;
    }

    public static int hitOrStand(Player human, Player computer, Deck myDeck) {
        System.out.println("The dealer is showing: " + computer.hand[0].name + " of " + computer.hand[0].suit);
        int choice = 0;
        int playerHandSize = 2;
        int computerHandSize = 2;
        boolean fail = false;
        Scanner input = new Scanner(System.in);

        while (choice != 2 && !fail) {
            System.out.println("You have been dealt: ");
            int i = 0;
            while (human.hand[i] != null) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(human.hand[i].name + " of " + human.hand[i].suit);
                i++;
            }
            System.out.print(" Total: " + human.printTotalValue());
            System.out.println();
            System.out.println("Would you like to hit or stand? Press 1 to hit, press 2 to stand: ");
            choice = input.nextInt();

            while (choice != 1 && choice != 2) {
                System.out.println("Invalid choice, please try again");
                System.out.println("1. Hit");
                System.out.println("2. Stand");
                choice = input.nextInt();
            }

            if (choice == 1) {
                myDeck.hit(human, playerHandSize);
                playerHandSize++;
                fail = LoseConditions.doILose(human, myDeck);
                if (fail) {
                    System.out.println("Sorry, you went over 21, you lose.");
                }
                choice = 0;
            }
        }

        while (computer.getTotalValue(myDeck) < 17 || computerHandSize < 4) {
            myDeck.hit(computer, computerHandSize);
            computerHandSize++;
            fail = LoseConditions.doILose(computer, myDeck);
            if (fail) {
                System.out.println("You win!!");
            }
        }
        boolean automaticWinHuman = false;
        boolean automaticWinComputer = false;
        automaticWinHuman = WinConditions.automaticWin(human, myDeck);
        automaticWinComputer = WinConditions.automaticWin(human, myDeck);

        if(automaticWinHuman && !automaticWinComputer){
            return 1;
        }
        if(automaticWinComputer && !automaticWinHuman){
            return -1;
        }

        boolean playerWin = WinConditions.whoWins(human, computer, myDeck);
        if(playerWin) return 1;
        else return -1;
    }
}
