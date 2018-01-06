public class WinConditions {
    public static boolean whoWins(Player human, Player computer, Deck myDeck){
        //player wins = true, computer wins = false
        if(human.getTotalValue(myDeck) > computer.getTotalValue(myDeck)){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean automaticWin(Player p, Deck myDeck){
        int cardsInHandPlayer = 0;
        for(int i=0; i<p.hand.length; i++) {
            if (p.hand[i] != null) {
                cardsInHandPlayer += 1;
            }
        }

        if(cardsInHandPlayer == 5){
            return true;
        }

        if(cardsInHandPlayer == 2){
            if(p.getTotalValue(myDeck) == 21){
                if(p.hand[0].name.equalsIgnoreCase("Jack") || p.hand[1].name.equalsIgnoreCase("Jack")){
                    if(p.hand[0].suit.equalsIgnoreCase("Spades") || p.hand[1].suit.equalsIgnoreCase("Clubs")){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
