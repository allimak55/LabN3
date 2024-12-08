import java.io.PrintStream;
import java.util.Scanner;

public class MenuManager {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        boolean exit = false;
        Menu menu = new Menu();

        while (!exit) {
            printMenu();
            int choice = in.nextInt();
            exit = handleChoice(choice, menu);
        }
    }

    public static void printMenu() {
        out.println("""
                Меню:
                1. Добавить блюдо
                2. Распечатать меню
                3. Распечатать доступные блюда
                4. Добавить приготовленное блюдо
                5. Изменить цену блюда
                6. Купить одно блюдо
                7. Купить несколько блюд
                8. Максимальное количество блюд за сумму
                9. Три самых дорогих блюда
                10. Три самых дешёвых блюда
                11. Удалить блюдо полностью
                12. Удалить блюдо, потому что его нет в наличии
                13. Выход
                """);
        out.print("Выберите действие: ");
    }

    public static boolean handleChoice(int choice, Menu menu) {
        switch (choice) {
            case 1 -> addDish(menu);
            case 2 -> menu.printMenu();
            case 3 -> menu.printAvailableMenu();
            case 4 -> {
                menu.printAvailableMenu();
                addPreparedDish(menu);
            }
            case 5 -> {
                menu.printMenu();
                changeDishPrice(menu);
            }
            case 6, 7 -> {
                menu.printAvailableMenu();
                buyDish(menu, choice == 6);
            }
            case 8 -> {
                menu.printAvailableMenu();
                getMaxDishesWithinBudget(menu);
            }
            case 9 -> menu.getThreeMostExpDishes();
            case 10 -> menu.getThreeCheapestDishes();
            case 11 -> {
                menu.printMenu();
                removeDish(menu);
            }
            case 12 -> {
                menu.printMenu();
                removeDishOutOfStock(menu);
            }
            case 13 -> {
                out.println("Выход...");
                return true;
            }
            default -> out.println("Неверный выбор! Попробуйте ещё раз.");
        }
        return false;
    }

    public static void addDish(Menu menu) {
        out.print("Введите название блюда: ");
        in.nextLine(); // очистка буфера
        String name = in.nextLine();
        out.print("Введите цену блюда: ");
        double price = in.nextDouble();
        out.print("Введите количество порций: ");
        int count = in.nextInt();
        menu.addDish(name, price, count);
    }

    public static void addPreparedDish(Menu menu) {
        out.print("Введите номер блюда в меню: ");
        int num = in.nextInt();
        out.print("Введите количество порций: ");
        int count = in.nextInt();
        menu.prepareCount(num, count);
    }

    public static void changeDishPrice(Menu menu) {
        out.print("Введите номер блюда в меню: ");
        int num = in.nextInt();
        out.print("Введите новую цену: ");
        double price = in.nextDouble();
        menu.changePrice(num, price);
    }

    public static void buyDish(Menu menu, boolean single) {
        if (single) {
            out.print("Введите номер блюда в меню: ");
            int num = in.nextInt();
            double price = menu.buyDish(num);
            if (price != -1) out.println("Цена: " + price);
        } else {
            out.print("Сколько блюд вы хотите купить? ");
            int count = in.nextInt();
            int[] dishNumbers = new int[count];
            out.println("Введите номера блюд:");
            for (int i = 0; i < count; i++) {
                dishNumbers[i] = in.nextInt();
            }
            double total = menu.buyMultDishes(dishNumbers);
            if (total != -1) out.println("Общая стоимость: " + total);
        }
    }

    public static void getMaxDishesWithinBudget(Menu menu) {
        out.print("В пределах какой суммы вы хотите совершить покупку? ");
        double budget = in.nextDouble();
        int maxDishes = menu.maxDishes(budget);
        out.println("Максимальное количество блюд, которые вы можете купить: " + maxDishes);
    }

    public static void removeDish(Menu menu) {
        out.print("Введите название блюда: ");
        in.nextLine(); // очистка буфера
        String name = in.nextLine();
        menu.removeDish(name);
    }

    public static void removeDishOutOfStock(Menu menu) {
        out.print("Введите название блюда: ");
        in.nextLine(); // очистка буфера
        String name = in.nextLine();
        menu.removeDishIfOutStock(name);
    }
}
