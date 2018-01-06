public class LoseConditions {
    public static boolean doILose(Player x, Deck myDeck){
        if(x.getTotalValue(myDeck) > 21){
            return true;
        }

        return false;
    }
}
