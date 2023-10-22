import java.util.Scanner;  // Импорт класса Scanner для ввода данных
public class Main {  // Основной класс программы
    public static void main(String[] args) {  // Основной метод программы
        Scanner scanner = new Scanner(System.in);  // Создание объекта Scanner для ввода данных

        boolean continueElevator = true;  // Переменная для управления продолжением работы лифта

        while (continueElevator) {  // Цикл для управления повторением работы лифта
            System.out.print("Введите имя: ");  // Вывод приглашения на ввод имени
            String clientName = scanner.nextLine();  // Считывание имени клиента

            // Создание клиента
            Client client = new ElevatorClient(clientName);

            System.out.println("Какой этаж вам нужно:");  // Вывод приглашения для выбора этажа
            System.out.println("Вы находитесь на 0-м этаже");
            System.out.println("1 этаж с квартирами 1-5");
            System.out.println("2 этаж с квартирами 6-10");
            System.out.println("3 этаж с квартирами 11-15");

            int floorChoice = scanner.nextInt();  // Считывание выбора этажа
            int apartmentChoice = 0;
            Lift selectedLift = null;

            switch (floorChoice) {  // Проверка выбора этажа с использованием оператора switch
                case 1:
                    System.out.println("Выберите квартиру (1-5):");  // Вывод приглашения для выбора квартиры
                    apartmentChoice = scanner.nextInt();  // Считывание выбора квартиры
                    if (apartmentChoice < 1 || apartmentChoice > 5) {  // Проверка корректности выбора квартиры
                        System.out.println("Неверный выбор квартиры. Завершение программы...");
                        System.exit(0);  // Завершение программы
                    }
                    selectedLift = new FirstFloorLiftAdapter(new FirstFloorLift(), apartmentChoice);  // Создание адаптера для первого этажа
                    break;
                case 2:
                    System.out.println("Выберите квартиру (6-10):");  // Вывод приглашения для выбора квартиры
                    apartmentChoice = scanner.nextInt();  // Считывание выбора квартиры
                    if (apartmentChoice < 6 || apartmentChoice > 10) {  // Проверка корректности выбора квартиры
                        System.out.println("Неверный выбор квартиры. Завершение программы...");
                        System.exit(0);  // Завершение программы
                    }
                    selectedLift = new SecondFloorLiftAdapter(new SecondFloorLift(), apartmentChoice);  // Создание адаптера для второго этажа
                    break;
                case 3:
                    System.out.println("Выберите квартиру (11-15):");  // Вывод приглашения для выбора квартиры
                    apartmentChoice = scanner.nextInt();  // Считывание выбора квартиры
                    if (apartmentChoice < 11 || apartmentChoice > 15) {  // Проверка корректности выбора квартиры
                        System.out.println("Неверный выбор квартиры. Завершение программы...");
                        System.exit(0);  // Завершение программы
                    }
                    selectedLift = new ThirdFloorLiftAdapter(new ThirdFloorLift(), apartmentChoice);  // Создание адаптера для третьего этажа
                    break;
                default:
                    System.out.println("Неверный выбор этажа. Завершение программы...");
                    System.exit(0);  // Завершение программы в случае некорректного выбора этажа
            }

            System.out.println("Выберите действие:");  // Вывод приглашения для выбора действия
            System.out.println("1. Зайти в лифт");
            System.out.println("2. Выйти из лифта");

            int actionChoice = scanner.nextInt();  // Считывание выбора действия

            if (actionChoice == 1) {
                selectedLift.connect();  // Вызов метода подключения к лифту
                String message = client.getName() + " пришел на " + floorChoice + " этаж и пошел в квартиру " + apartmentChoice;
                System.out.println(message);  // Вывод сообщения о действии клиента
            } else if (actionChoice == 2) {
                selectedLift.disconnect();  // Вызов метода выхода из лифта
            }

            System.out.println("Хотите использовать лифт еще раз? : ");  // Вывод приглашения для продолжения работы с лифтом
            System.out.println("1. да");
            System.out.println("2. нет");
            String continueChoice = scanner.next();
            if (!"1".equalsIgnoreCase(continueChoice)) {
                continueElevator = false;  // Завершение работы с лифтом в случае выбора "нет"
            }
        }

        System.out.println("Завершение программы...");  // Вывод сообщения о завершении программы
    }
}