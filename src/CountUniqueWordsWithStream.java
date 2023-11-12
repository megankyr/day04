import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class CountUniqueWordsWithStream {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("Please provide the file path as your command line argument");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            long count = bufferedReader.lines()
                    .map(line -> line.trim().replaceAll("[^\\sa-zA-Z0-9]", ""))
                    .filter(line -> line.length() > 0)
                    .map(line -> line.split(" "))
                    .flatMap(words -> Stream.of(words))
                    .map(word -> word.toLowerCase())
                    .distinct()
                    .count();

            System.out.println("The number of unqiue words in " + args[0] + " are " + count);
        }
    }
}
