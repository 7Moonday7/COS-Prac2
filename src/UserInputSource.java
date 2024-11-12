import java.util.Scanner;

public class UserInputSource implements InputSource {
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите URL: ");
        return scanner.nextLine();
    }
}
