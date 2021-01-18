import java.util.Arrays;

/**
 * @author Jan Schroeder, Felix Nilles
 * @version 0.0.1
 */
public class Manapool {
    private enums.DeckSize deckSize;
    private double capacity;
    private double stored;

    private int identity[] = {0, 0, 0, 0, 0, 0};

    /**
     * @param size Groeße des Decks
     */
    public Manapool(enums.DeckSize size) {
        this.deckSize = size;
        switch (size) {
            case LIMITED:
                setCapacity(40 * 0.425);
                setStored(40 * 0.425);
                break;
            case CONSTRUCTED:
                setCapacity(60 * 0.43333333333);
                setStored(60 * 0.43333333333);
                break;
            case EDH:
                setCapacity(100 * 0.36);
                setStored(100 * 0.36);
                break;
            default:
                break;
        }
    }

    /**
     * @return Gibt die Anzahl an Maximalen Mana aus
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * @param capacity setzt die Anzahl an Maximalen Mana
     */
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    /**
     * @return gibt die Anzahl an gespeichertem Mana aus
     */
    public double getStored() {
        return stored;
    }

    /**
     * @param stored setzt die Anzahl an gespeichertem Mana
     */
    public void setStored(double stored) {
        this.stored = stored;
    }

    /**
     * @param identities Weist die Kapazitaet anteilhaft zu
     */
    public void setIdentity(double[] identities) {
        int count = 0;
        for (int i = 0; i < identities.length; i++) {
            identity[i] = (int)Math.round(identities[i] * getCapacity());
            count += (int)Math.round(identities[i] * getCapacity());
        }

        for (double id :
                identity) {
            System.out.println(id);
        }
    }

    /**
     *
     * @return gibt die Anzahl wieder
     */
    public int[] getIdentity() {
        return identity;
    }

    /**
     *
     * @return gibt die Deckgröße aus
     */
    public enums.DeckSize getDeckSize() {
        return deckSize;
    }
}
