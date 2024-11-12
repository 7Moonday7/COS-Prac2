import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URLValidator validator = new URLValidator();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Выберите источник URL:");
            System.out.println("1 - Ввести строку в коде");
            System.out.println("2 - Ввести строку с клавиатуры");
            System.out.println("3 - Прочитать строку из файла");
            System.out.println("4. Выход");
            System.out.print("Введите номер источника: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Переход на новую строку после ввода числа

            InputSource inputSource;
            switch (choice) {
                case 1:
                    inputSource = new StringInputSource("http://www.example.com");
                    break;
                case 2:
                    inputSource = new UserInputSource();
                    break;
                case 3:
                    System.out.print("Введите путь к файлу: ");
                    String filePath = scanner.nextLine();
                    inputSource = new FileInputSource(filePath);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return; // Завершаем программу
                default:
                    System.out.println("Неверный выбор.");
                    continue;
            }

            try {
                String url = inputSource.getInput();
                if (validator.isValidURL(url)) {
                    System.out.println("URL является валидным: " + url);
                } else {
                    System.out.println("URL является НЕвалидным: " + url);
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.println(); // Пустая строка для удобства чтения вывода
        }
    }
}