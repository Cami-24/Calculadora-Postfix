import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String line;

            PostfixCalculator calculator = new PostfixCalculator();

            while ((line = reader.readLine()) != null) {
                int result = calculator.evaluate(line);
                System.out.println("Resultado: " + result);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

