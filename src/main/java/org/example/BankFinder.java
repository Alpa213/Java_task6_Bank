
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class BankFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first three digits of bank account: ");
        String bankNumber = scanner.nextLine();

        String url = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        try {
            URL fileUrl = new URL(url);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            fileUrl.openStream(),
                            Charset.forName("Cp852")
                    )
            );

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith(bankNumber)) {

                    System.out.println("Bank number: " + bankNumber);
                    System.out.println("Bank information: " + line);

                    found = true;
                    break;
                }
            }

            reader.close();

            if (!found) {
                System.out.println("Bank not found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
