import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args){
        boolean exit = false;
        while(!exit) {
            System.out.println("Меню:");
            System.out.println("1. Добавить блюдо");
            System.out.println("2. Распечатать меню");
            System.out.println("3. Распечатать доступные блюда");
            System.out.println("4. Добавить приготовленное блюдо");
            System.out.println("5. Изменить цену блюда");
            System.out.println("6. Купить одно блюдо");
            System.out.println("7. Купить несколько блюд");
            System.out.println("8. Максимальное количество блюд за сумму");
            System.out.println("9. Три самых дорогих блюда");
            System.out.println("10. Три самых дешёвых блюда");
            System.out.println("11. Удалить блюдо полностью");
            System.out.println("12. Удалить блюдо, потому что оно нет в наличии");
            System.out.println("13. Выход");
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.print("Введите название блюда: ");
                String name = in.nextLine();
                in.nextLine();
                System.out.print("Введите цену блюда: ");
                double price = in.nextDouble();
                in.nextLine();
                System.out.print("Введите количество порций: ");
                int count = in.nextInt();
                Menu.addDish(name, price, count);
            }
            else if (choice == 2) {
                Menu.printMenu();
            }
            else if (choice == 3)
                Menu.printAvailableMenu();
            else if (choice == 4) {
                System.out.println("Введите номер блюда в меню: ");
                int num = in.nextInt();
                System.out.println("Введите количество порций: ");
                int cnt = in.nextInt();
                Menu.prepareCount(num, cnt);
            }
            else if (choice == 5) {
                System.out.println("Введите номер блюда в меню: ");
                int num = in.nextInt();
                System.out.println("Введите новую цену: ");
                double price = in.nextDouble();
                Menu.changePrice(num, price);
            }
            else if (choice == 6 || choice == 7) {
                System.out.println("Сколько блюд вы хотите купить?");
                int cnt = in.nextInt();
                if (cnt == 1) {
                    System.out.println("Введите номер блюда в меню: ");
                    int num = in.nextInt();
                    double res = Menu.buyDish(num);
                    if (res != -1)
                        System.out.println("Цена: " + res);

                }
                else {
                    System.out.println("Введите номера блюд в меню: ");
                    int [] num = new int[cnt];
                    for (int i = 0; i < cnt; i++)
                        num[i] = in.nextInt();
                    double res = Menu.buyMultDishes(num);
                    if (res != -1)
                        System.out.println("Общая стоимость: " + res);
                }
            }
            else if (choice == 8) {
                System.out.println("В пределах какой суммы вы хотите совершить покупку?");
                double sum = in.nextDouble();
                System.out.println("Максимальное количество блюд, которые вы можете купить: " + Menu.maxDishes(sum));
            }
            else if (choice == 9) {
                System.out.println("Самые дорогие блюда:");
                Menu.getThreeMostExpDishes();
            }
            else if (choice == 10) {
                System.out.println("Самые дешёвые блюда:");
                Menu.getThreeCheapestDishes();
            }
            else if (choice == 11) {
                System.out.println("Введите название блюда: ");
                String name = in.nextLine();
                in.nextLine();
                Menu.removeDish(name);
            }
            else if (choice == 12) {
                System.out.println("Введите название блюда: ");
                String name = in.nextLine();
                in.nextLine();
                Menu.removeDishIfOutStock(name);
            }
            else if (choice == 13) {
                System.out.println("Выход...");
                exit = true;
            }
            else
                System.out.println("Неверный выбор! Может попробуете ещё раз?");
        }
    }
}
class Dish
{
    private String dish;
    private double price;
    private int count;
    //Создание необходимых переменных названия блюд,
    //их стоимость и количество порций.
    public Dish(String dish, double price, int count) {
        this.dish = dish; //блюдо
        this.price = price; //цена
        this.count = 0; //начальное значение количества кого-то блюда = 0;
    }
    //Геттеры и сеттеры для этих переменных
    public String getDish() {
        return dish;
    }
    public void setDish(String dish){
        this.dish = dish;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price > 0) //проверка цены, потому что если она меньше нуля, то мы игнорируем
            this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return String.format("%s - %.2f руб. (%d порций)", dish, price, count);
    }
}
class Menu
{
    public static Dish[] menu = new Dish[5];
    public static int dishCount = 0;

    //Добавление блюда(1)
    public static void addDish(String dish, double price, int count) {
        /* Проверка количества добавляемых блюд
        if (count <= 0) {
            System.out.println("Простите, но количество должно быть больше 0 :(");
            return;
        } */
        //Проверка, существует ли блюдо с таким названием
        if (dishCount > 0)
            for (int i = 0; i < 5; i++)
                if (menu[i].getDish().equals(dish)) { //Проверяем "объекты" на равенство, то есть названия блюда, которое уже добавлено в меню, и нового блюда
                    System.out.println("Простите, но блюда с таким названием уже существует");
                    return;
                }
        //Проверка цены блюда
        if (price <= 0) {
            System.out.println("Простите, цена не может быть меньше или равна 0 :(");
            return;
        }
        //Проверка, возможно ли добавить новое блюдо в меню(есть ли место)
        if (dishCount >= menu.length) {
            System.out.println("Простите, но меню уже заполнено");
            return;
        }
        //Если новое блюдо прошло все проверки, то мы его добавляем
        menu[dishCount++] = new Dish(dish, price, count);
        System.out.println("Ваше блюдо добавлено");
    }
    //Печать нашего меню(полностью)(2)
    public static void printMenu() {
        //Проверка, есть ли у нас хотя бы одно добавленное блюдо в меню
        if (dishCount == 0) {
            System.out.println("Простите, но в меню еще не добавлены блюда");
            return;
        }
        //Отсортировываем массив(меню), чтобы блюда были расположены в алфавитном порядке
        sortMenu();
        //Печать меню
        System.out.println("Меню:");
        for (int i = 0; i < dishCount; i++)
            System.out.printf("%s - %.2f руб.%n", menu[i].getDish(), menu[i].getPrice());

    }
    //Печать нашего меню(доступных блюд)(3)
    public static void printAvailableMenu() {
        //Проверка, есть ли у нас хотя бы одно добавленное блюдо в меню
        if (dishCount == 0) {
            System.out.println("Простите, но в меню еще не добавлены блюда");
            return;
        }
        //Отсортировываем массив(меню), чтобы блюда были расположены в алфавитном порядке
        sortMenu();
        //Печать меню с доступными блюдами
        System.out.println("Меню доступных блюд:");
        for (int i = 0; i < dishCount - 1; i++)
            if (menu[i].getCount() > 0)
                System.out.printf("%s - %.2f руб.%n", menu[i].getDish(), menu[i].getPrice());

    }
    //Отдельная подпрограмма для сортировки массива(меню) по названию блюд
    public static void sortMenu() {
        //Проверка, есть ли у нас хотя бы одно добавленное блюдо в меню
        if (dishCount == 0) {
            System.out.println("Простите, но в меню еще не добавлены блюда");
            return;
        }
        //Сортировка пузырьком
        for (int i = 1; i < dishCount; i++)
            for (int j = 0; j < dishCount - i; j++)
                //Сравниваем названия блюд лексикографически
                if (menu[j].getDish().compareTo(menu[j + 1].getDish()) > 0) {
                    Dish temp = menu[j];
                    menu[j] = menu[j + 1];
                    menu[j + 1] = temp;
                }
    }
    //Приготовление порций блюда(4)
    public static void prepareCount(int num, int cnt) {
        //Требуемые в задании проверки
        if (num < 1 || num > dishCount) {
            System.out.println("Простите, но блюда под таким номером нет");
            return;
        }
        if (cnt <= 0) {
            System.out.println("Простите, но вы не добавили количество порций");
            return;
        }
        //Изменение количества(приготовление)
        menu[num - 1].setCount(menu[num - 1].getCount() + cnt);
        //System.out.printf("Количество порций блюда \"%s\" увеличено на %d. Текущее количество: %d%n", menu[dishNumber - 1].getName(), additionalPortions, menu[dishNumber - 1].getPortions());
    }
    //Изменение цены блюда(5)
    public static void changePrice(int num, double price) {
        //Требуемые в задании проверки
        if (num < 1 || num > dishCount) {
            System.out.println("Простите, но блюда под таким номером нет");
            return;
        }
        if (price == menu[num].getPrice() || menu[num].getPrice() - price > 0) {
            System.out.println("Простите, но цену можно только увеличить");
            return;
        }
        //Изменение цены
        menu[num - 1].setPrice((price));
        //System.out.printf("Цена блюда \"%s\" обновлена. Новая цена: %.2f руб.%n", menu[dishNumber - 1].getName(), newPrice);
    }
    //Покупка одного блюда(6)
    public static double buyDish(int num) {
        //Необходимые в задании проверки
        if (num < 1 || num > dishCount) {
            System.out.println("Простите, такого блюда не существует");
            return -1;
        }
        //присваиваем ссылку новой локальной переменной
        // на уже существующий объект блюда из массива menu
        //для удобной работы :)
        Dish dish = menu[num - 1];
        if (dish.getCount() <= 0) {
            System.out.println("Простите, такого блюда нет в наличии");
            return -1;
        }
        //изменяем количество блюд после покупки
        dish.setCount(dish.getCount() - 1);
        //возвращаем цену этого блюда
        return dish.getPrice();
    }
    //Покупка нескольких блюд(7)
    public  static double buyMultDishes(int [] nums) {
        double sum = 0; //общая сумма
        boolean res = false; //флаг

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i]; //берем первый номер из массива номеров
            if (n < 1 || n > dishCount) {
                System.out.println("Простите, но такого блюда не существует");
                return -1;
            }
            //запускаем ранее созданный метод для покупки одного блюда
            double cost = buyDish(n);
            //Делаем проверку, возможно ли купить такое блюдо
            if (cost != -1) {
                //Если блюдо прошло проверку, то добавляем его стоимость и меняем флаг
                sum += cost;
                res = true;
            }
        }
        if (res)
            return sum;
        else
            return  -1;
    }
    //Максимальное количество блюд по сумме(8)
    public  static int maxDishes(double sum) {
        int count = 0; //счётчик для доступных блюд
        Dish [] availableDishes = new Dish[dishCount];
        //Добавляем в локальный массив только доступные блюда
        for (int i = 0; i < dishCount; i++)
            if (menu[i].getCount() > 0) {
                availableDishes[count] = menu[i];
                count++;
            }
        //Сортируем массив по цене, чтобы сначала
        // получить наиболее количество блюд при покупке
        //Сортировка пузырьком
        for (int i = 1; i < count; i++)
            for (int j = 0; j < count - i; j++)
                if (availableDishes[j].getPrice() > availableDishes[j + 1].getPrice()) {
                    Dish temp = availableDishes[j];
                    availableDishes[j] = availableDishes[j + 1];
                    availableDishes[j + 1] = temp;
                }
        //переменная для подсчёта количества блюд,
        // которые можно купить на передаваемую сумму
        int dishes = 0;
        for (int i = 0; i < count; i++) {
            Dish dish = availableDishes[i]; //берем первое блюдо
            int affordableDishes = (int) Math.min(sum / dish.getPrice(), dish.getCount());
            dishes += affordableDishes;
            sum -= affordableDishes * dish.getPrice();
            if (sum <= 0)
                break;
        }
        return dishes;
    }
    //Три самых дорогих блюд(9)
    public static void getThreeMostExpDishes() {
        Dish first = null; //Переменная для самого дорого блюда
        Dish second = null; //Переменная для второго по стоимости блюда
        Dish third = null; //Переменная для третьего по стоимости блюдо
        for (int i = 0; i < dishCount; i++) {
            Dish dish = menu[i]; // Берем одно добавленное блюдо
            if (dish == null || dish.getCount() <= 0) {
                continue;
            }
            if (first == null || dish.getPrice() > first.getPrice()) {
                third = second;
                second = first;
                first = dish;
            }
            else if (second == null || dish.getPrice() > second.getPrice()) {
                third = second;
                second = dish;
            }
            else if (third == null || dish.getPrice() > third.getPrice()){
                third = dish;
            }
        }
        //Вывод
        if (first != null)
            System.out.println("1. " + first.getDish() + " - " + first.getPrice());
        else
            System.out.println("Извините, но доступных блюд нет");
        if (second != null)
            System.out.println("2. " + second.getDish() + " - " + second.getPrice());
        if (third != null)
            System.out.println("3. " + third.getDish() + " - " + third.getPrice());
    }
    //Три самых дешёвых блюд(10)
    public static void getThreeCheapestDishes() {
        Dish first = null; //Переменная для самого дешёвого блюда
        Dish second = null; //Переменная для второго по стоимости блюда
        Dish third = null; //Переменная для третьего по стоимости блюдо
        for (int i = 0; i < dishCount; i++) {
            Dish dish = menu[i]; // Берем одно добавленное блюдо
            if (dish == null || dish.getCount() <= 0) {
                continue;
            }
            if (first == null || dish.getPrice() < first.getPrice()) {
                third = second;
                second = first;
                first = dish;
            }
            else if (second == null || dish.getPrice() < second.getPrice()) {
                third = second;
                second = dish;
            }
            else if (third == null || dish.getPrice() < third.getPrice()){
                third = dish;
            }
        }
        //Вывод
        if (first != null)
            System.out.println("1. " + first.getDish() + " - " + first.getPrice());
        else
            System.out.println("Извините, но доступных блюд нет");
        if (second != null)
            System.out.println("2. " + second.getDish() + " - " + second.getPrice());
        if (third != null)
            System.out.println("3. " + third.getDish() + " - " + third.getPrice());
    }
    //Удаление блюда из списка(11)
    public static void removeDish(String name) {
        for (int i = 0; i < dishCount; i++) {
            if (menu[i].getDish().equals(name)) {
                //Смещаем элементы массива влево, чтобы заполнить пробел
                for (int j = i; j < dishCount - 1; j++)
                    menu[j] = menu[j + 1];
                //Уменьшаем количество блюд и очищаем последний элемент
                menu[--dishCount] = null;
                System.out.println("Блюдо удалено");
                return;
            }
        }
        //Если такое блюдо не найдется
        System.out.println("Такого блюда не найдено");
    }
    //Удаление блюда, если его нет в наличии(12)
    public static void removeDishIfOutStock(String name) {
        for (int i = 0; i < dishCount; i++) {
            if (menu[i].getDish().equals(name))
                if (menu[i].getCount() <= 0) {
                    for (int j = i; j < dishCount - 1; j++)
                        menu[j] = menu[j + 1];
                    menu[--dishCount] = null;
                    System.out.println("Блюдо удалено");
                }
            return;
        }
        //Если такое блюдо не найдется
        System.out.println("Такого блюда не найдено или он еще есть в наличии");
    }
}
