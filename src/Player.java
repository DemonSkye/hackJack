public class Player {
    public Card hand[];
    public int money;

    Player() {
        hand = new Card[5];
        money = 1000;
    }

    Player(int money){
        hand = new Card[5];
        for(int i=0; i<5; i++){
            hand[i] = new Card();
        }
        this.money = money;
    }

    public void clearHand(){
        hand = new Card[5];
        for(int i=0; i<5; i++){
            hand[i] = new Card();
        }
    }

    public int getTotalValue(Deck myDeck){
        int total =0;
        for(int i=0; i<5; i++) {
            if (hand[i] != null) {
                total += hand[i].value;
            }
        }
        return total;
    }

    public String printTotalValue(){
        int value1 =0;
        int value2 =0;
        String totalValue ="";
        for(int i=0; i<5; i++){
            if(hand[i] != null){
                if(hand[i].value == 0) { //ace
                    value2 = value1;
                    value1 += 1;
                    value2 += 11;
                }
                if(value2 != 0) {
                    value2 += hand[i].value;
                }
                value1 += hand[i].value;
            }

        }
        totalValue = value1+ "";
        if(value2 != 0) totalValue+= " / " + value2;

        return totalValue;
    }

}
