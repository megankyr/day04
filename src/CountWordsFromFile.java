import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordsFromFile {
    public static void main(String[] args) throws IOException{

        if (args.length == 0){
            System.out.println("Please provide the file path as your command line argument");
        }

        String line;
        int count = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))){
            while ((line = bufferedReader.readLine()) != null){
                line = line.trim().replaceAll("[^\\sa-zA-Z0-9]", "");
                if (line.length() <= 0)
                    continue;
                String[] words = line.split(" ");
                count += words.length;
            }
        }

        System.out.println("The number of words in " + args[0] + " are " + count);

    }
}