import java.util.Random;

import static java.lang.Math.abs;

//A deck of 52 cards
public class Deck {
    //Suit 1: Hearts
    //Suit 2: Diamonds
    //Suit 3: Clubs
    //Suit 4: Spades
    public Card[] cards;
    public int usedCards[];

    //Todo: Change name to better explain this removes all "used" flags from cards.
    public void shuffle(){
        //shuffle cards back into Deck
        for(int i = 0; i<52; i++){
            usedCards[i] = 0;
        }
    }

    //Todo: remove unused
    public String getSuit(int x){
        switch(x){
            case 0: return "Hearts";
            case 1: return "Diamonds";
            case 2: return "Clubs";
            case 3: return "Spades";
            default: return "Error";
        }
    }

    public int getValue(int cardNumber){
        switch(cardNumber){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 10;
            case 11:
                return 10;
            case 12:
                return 10;
            default:
                return -1;
        }
    }

    public String getName(int cardNumber){
        switch(cardNumber) {
            case 0:
                return "Ace";
            case 1:
                return "2";
            case 2:
                return "3";
            case 3:
                return "4";
            case 4:
                return "5";
            case 5:
                return "6";
            case 6:
                return "7";
            case 7:
                return "8";
            case 8:
                return "9";
            case 9:
                return "10";
            case 10:
                return "Jack";
            case 11:
                return "Queen";
            case 12:
                return "King";
            default:
                return "Error";
        }
    }

    public void deal(Player x, Player y){
        Random rand = new Random();
        int cardNumber;
        int counterX = 0;
        int counterY = 0;
        for(int i=0; i<4; i++){
            cardNumber = abs(rand.nextInt()%52);
            if(i%2 == 0 && usedCards[cardNumber] == 0){
                x.hand[counterX] = cards[cardNumber];
                usedCards[cardNumber] = 1;
                counterX++;
            }
            else if(i%2 != 0 && usedCards[cardNumber] == 0){
                y.hand[counterY] = cards[cardNumber];
                usedCards[cardNumber] = 1;
                counterY++;
            }
        }
    }

    public void hit(Player x, int handsize){
        Random rand = new Random();
        int cardNumber = abs(rand.nextInt()%52);
        while(usedCards[cardNumber] == 1){
            cardNumber = abs(rand.nextInt()%52);
        }
        x.hand[handsize] = cards[cardNumber];
    }

    Deck(){
        cards = new Card[52];
        for(int i= 0; i<52; i++){
            cards[i] = new Card();
        }
        usedCards = new int[52];
        for(int i=0; i<13; i++){
           cards[i].value = getValue(i);
           cards[i].suit = "Hearts";
           cards[i].name = getName(i);
           usedCards[i]=0;
        }
        for(int i =13; i<26; i++){
            cards[i].value = getValue(i%13);
            cards[i].suit = "Diamonds";
            cards[i].name = getName(i%13);
            usedCards[i]=0;
        }
        for(int i =26; i<39; i++){
            cards[i].value = getValue(i%13);
            cards[i].suit = "Clubs";
            cards[i].name = getName(i%13);
            usedCards[i]=0;

        }
        for(int i =39; i<52; i++){
            cards[i].value = getValue(i%13);
            cards[i].suit = "Spades";
            cards[i].name = getName(i%13);
            usedCards[i]=0;
        }
    }
}
