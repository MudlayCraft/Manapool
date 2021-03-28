import java.io.File;
import java.util.Scanner;

public class Decklist {

    public static String[] loadDeck(String deckName) {

        File file = new File("C:\\Users\\jansc\\OneDrive\\Dokumente\\Magic\\Decklists\\"+deckName);
        Scanner s = null;

        try {
            s = new Scanner(file);
        }catch (Exception e){
            System.out.println(e);
        }
        String[] arr = {};

        while(s.hasNext()){
            System.out.println(s.useDelimiter("\n").next());
            arr = add(arr, s.useDelimiter("\n").next());
        }
        return arr;
    }

    public static String[] add(String[] arr, String... elements){
        String[] tempArr = new String[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);

        for(int i=0; i < elements.length; i++)
            tempArr[arr.length+i] = elements[i];
        return tempArr;

    }
}
