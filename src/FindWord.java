import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class FindWord {
    public static void main(String[] args) throws Exception {

        File myFile = new File("movies.txt");
        Scanner fileScanner = new Scanner(myFile);
        ArrayList<String> films = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String filmLine = fileScanner.nextLine();
            films.add(filmLine);
        }

        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.nextLine();


        ArrayList<String> res = new ArrayList<>();

        File file = new File("temp.txt");
        if (!file.exists()){
            file.createNewFile();
        }

        for ( int i = 0; i < films.size(); i++ ){
           String curFilm = films.get(i);

           if (curFilm.contains(inputWord)){
               res.add(curFilm);

               Files.writeString(Path.of("temp.txt"), curFilm + "\n", StandardOpenOption.APPEND);
           }
        }

        if (res.isEmpty()) {
            System.out.println("Sorry, film with word \"" + inputWord +  "\" not found.");
        }
    }


}

