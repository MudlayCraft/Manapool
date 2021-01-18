/**
 * @author Jan Schroeder, Felix Nilles
 * @version 0.0.1
 */
public class Interactor {
    Manapool manapool;

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


}
