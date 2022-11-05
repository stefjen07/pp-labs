import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        ArrayList<String> results = new ArrayList<>();
        while(!text.isEmpty()) {
            AtomicBoolean isFirst = new AtomicBoolean(true);
            char[] delimiters = {' ', ',', '.'};

            AtomicReference<String> result = new AtomicReference<>("");
            text.chars().forEach(ch -> {
                for (char delimiter : delimiters) {
                    if (ch == delimiter) {
                        isFirst.set(true);
                        result.set(result.get() + String.valueOf((char) (ch)));
                        return;
                    }
                }

                result.set(result.get() + String.valueOf((char) (isFirst.get() ? Character.toUpperCase(ch) : ch)));
                isFirst.set(false);
            });
            results.add(result.get());

            text = scanner.nextLine();
        }

        for(String result: results) {
            System.out.println(result);
        }
    }
}