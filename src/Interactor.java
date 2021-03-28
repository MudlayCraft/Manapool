/**
 * @author Jan Schroeder, Felix Nilles
 * @version 0.0.1
 */



public class Interactor {
    Manapool manapool;
    static Deck[] decks;


    public Interactor(enums.DeckSize size) {
        manapool = new Manapool(size);
    }

    /*
    TODO:
        void landGezogen()
        float landProbability()
        Array[][] CMC()
     */
    public void landGezogen(enums.Color color) {
        switch (color) {
            case FOREST:
                int[] identity = manapool.getIdentity();
                identity[0] -= 1;
                break;
        }
    }


    public static enums.DeckSize getFormat(Deck deck){
        int count = 0;
        for (int i = 0; i < deck.deckList.length; i++){
            if(Character.isDigit(deck.deckList[i].charAt(0))){
                count += Integer.parseInt(deck.deckList[i].split("x")[0]);
            }else{
                count++;
            }
        }

        switch (count) {
            case 40:
                return enums.DeckSize.LIMITED;
            case 60:
                return enums.DeckSize.CONSTRUCTED;
            case 100:
                return enums.DeckSize.EDH;
            default:
                break;
        }
        return null;
    }

    public static void addDeck(Deck deck){
        decks = add(decks,deck);
    }

    private static Deck[] add(Deck[] arr, Deck... elements){
        Deck[] tempArr = new Deck[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);

        for(int i=0; i < elements.length; i++)
            tempArr[arr.length+i] = elements[i];
        return tempArr;

    }
}


