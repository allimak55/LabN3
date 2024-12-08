## Отчет по лабораторной работе №3
#### № группы: 'ПМ-2402'
#### Выполнила: 'Тагирова Камилла Маратовна'
#### Выриант: '25'
### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Программа получает на вход 2 натуральных числа N, M и создает массив размера N на M, состоящий из логических выражений, пример: x < 5, где на месте логического знака могут быть >, < или =, справа всегда стоит число, а слева неизвестная x. После программа получает на вход натуральное число K и заменяет все неизвестные x в массиве на число K. Затем программа проверяет получившиеся логические выражения на истинность и выводит массив. Дальше программа сортирует строки массива по количеству истинных выражений в строке и выводит этот массив, заменяя истинные выражения на "Истина", а ложные на "Ложь". Дальше в программе подсчитывается количество уникальных правых частей всех логических выражений массива, и выводится этот подсчёт.

### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получать 3 числа. Два из них это размеры массива, поэтому отрицательными они быть не могут, а третье число, это число для логического выражение, оно может быть отрицательным.
(Я взяла число K, как натуральное, потому что в логических выражениях число справа натуральное.) Также размер массива не может равнять 0, поэтому минимальное значение переменных N и M возьмем равными за еденицу.

|             | Тип                | min значение    | max значение             |
|-------------|--------------------|-----------------|--------------------------|
| N (Число 1) | Натуральное число  | 1               | 2<sup>31</sup> - 1       |
| M (Число 2) | Натуральное число  | 1               | 2<sup>31</sup> - 1       |
| K (Число 3) | Натуральное число  | -2<sup>31</sup> | 2<sup>31</sup> - 1<sup>  |

#### Данные на выход

Программа выводит массив результатов логических выражений, а значит создается массив типа boolean. А для подсчёта общего количества уникальных правых частей всех логических выражений будем использовать переменнную типа int.

|            | min значение    | max значение            |
|------------|-----------------|-------------------------|
| Массив     | -               | -                       |
| Число 1    | -2<sup>31</sup> | 2<sup>31</sup> - 1<sup> |

### 2,5. Математическая модель
В главной программе нет определенных математических подсчётов, поэтому рассмотрим подпрограммы.
В подпрограмме cntRightParts происходит подсчёт уникальных правых частей всех логических выражений, туда передается наш массив с введенными логическими выражениями.
Мы создаем новый массив для хранения уникальных правых частей и заводим переменную cnt типа int как счётчик.
Запускаем цикл, в котором проходимся по элементам изначального массива (array, массив логических выражений). Создаем переменную типа String, которой присваиваем правую часть элемента массива.
Дальше проверяем, существует ли уже у нас такая правая часть, если нет, добавляем её в массив и увеличиваем счётчик, если да, то выходим из цикла и берем следующий элемент массива.
Теперь рассмотрим подпрограмму для подсчёта количества истинных выражений в строке.
В нее мы передаем строку, затем заводим счётчик и запускаем цикл, в котором проходимся по каждому элементу этой строки, то есть смотрим, сколько в строке истинных выражений. В конце возвращаем количество истинных выражений в строке в подпрограмму sortRes, которая сортирует массив по количеству истинных выражений в строке.
В подпрограмме sortRes мы сортируем массив, сравнивая количество "Истина" в строке, если же количество совпадает, то смотрим на количество "Ложь".
Я считаю, что остальные подпрограммы нет смысла рассматривать, так как они несут в себе лишь логические выражения и вычисления. Никакой математики.

### 3. Выбор структуры данных

Программа получает 3 натуральных числа, не превышающих по модулю  2<sup>31</sup> - 1<sup>. Поэтому для их хранения
можно выделить 3 переменные (`N`, `M`, `K`) типа `int`.

|             | Название переменной | Тип (в Java) | 
|-------------|---------------------|--------------|
| N (Число 1) | `N`                 | int          |
| M (Число 2) | `M`                 | int          |
| K (Число 3) | `K`                 | int          |

Для вывода результата неободимо создать массив, в котором будут храниться результаты логических выражений, а значит этот массив должен быть типа boolean и такого же размера, как размер массива с логическими выражениями, то есть N на M.
А также нам требуется вывести количество уникальных правых частей всех логических выражений, поэтому необходимо создать переменную для подсчёта типа int, так как размер массива тоже типа int, а значит количество логических выражений в нем не будет превосходить допустимые значения типа int, но и более маленькие типы данных брать не стоит, так как массив может быть большим.

|               | название переменной | Тип (в Java) | 
|---------------|---------------------|--------------|
| Массив        | `res`               | `boolean`    |
| cnt (Число 1) | `cnt`               | `int`        | 

### 4. Алгоритм

#### Алгоритм выполнения программы:

1. **Ввод данных:**  
   Программа считывает два натуральных числа, обозначенных как `N` и `M`.

2. **Создание переменных и ход программы**  
   Создаем двумерный массив, обозначенный как array размера N на M типа String. Считываем с клавиатуры логичесике выражения в этот массив. Создаем переменную типа int, обозначенную как K, для замены неизвестной (x) в логических выражениях в массиве array. Создаем массив типа boolean, обозначенный как res, для хранения результатов вычислений, а именно для результата логических выражений. Запускаем цикл в цикле, для вычисления истинности логичесих выражений и сохраняем эти результаты в созданный массив res, одновременно выводя этот массив. Для вычисления истинности логических выражений мы создаем подпрограмму, обозначенную как evaluateArray типа boolean и  передаем туда наш изначально созданный массив array, в котором хранятся логические выражения, а также передаем переменную K, чтобы заменить неизвествую в логических выражениях на значение переменной K. После создаем подпрограмму sortRes, где сортируем массив res по количеству истинных выражений в строке, передавая туда получившийся массив res, а после выводим отсортированный массив res, заменняя истинные выражения на "Истина", а ложные на "Ложь". Остается только подсчитать количество уникальных правых частей. Для этого я создала подпрограмму cntRightParts, куда передается изначальный массив array с логическими выражениями, а возвращается количество, которое сразу выводится в главной программе.

### 5. Программа

```java
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
                System.out.println("Введите название блюда: ");
                String name = in.nextLine();
                System.out.println("Введите цену блюда: ");
                double price = in.nextDouble();
                System.out.println("Введите количество порций: ");
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
                Menu.removeDish(name);
            }
            else if (choice == 12) {
                System.out.println("Введите название блюда: ");
                String name = in.nextLine();
                Menu.removeDishIfOutStock(name);
            }
            else if (choice == 13) {
                System.out.println("Выход...");
                exit = true;
            }
            else
                System.out.println("Неверный выбор!");
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
        if (count > 0)
            this.count = count;
    }
    @Override
    public String toString() {
        return String.format("%s - %.2f руб. (%d порций)", dish, price, count);
    }
}
class Menu
{
    public static Dish[] menu;
    public static int dishCount;
    public Menu() {
        this.menu = new Dish[5];
        this.dishCount = 0;
    }
    //Добавление блюда(1)
    public static void addDish(String dish, double price, int count) {
        /*Проверка количества добавляемых блюд
        if (count <= 0) {
            System.out.println("Простите, но количество должно быть больше 0 :(");
            return;
        } */
        //Проверка цены блюда
        if (price <= 0) {
            System.out.println("Простите, цена не может быть меньше или равна 0 :(");
            return;
        }
        //Проверка, существует ли блюдо с таким названием
        for (int i = 0; i < menu.length; i++)
            if (menu[i].getDish().equals(dish)) { //Проверяем "объекты" на равенство, то есть названия блюда, которое уже добавлено в меню, и нового блюда
                System.out.println("Простите, но блюда с таким названием уже существует");
                return;
            }
        //Проверка, возможно ли добавить новое блюдо в меню(есть ли место)
        if (dishCount == menu.length) {
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
        for (int i = 0; i < dishCount; i++)
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

```

### 6. Анализ правильности решения

Программа работает корректно.

1. Тест на `N = 3`, `M = 2`, и логические выражения:

    - **Input**:
        ```
        3 2
        x < 6
        x > 3
        x = 4
        x > 6
        x < 7
        x = 5
        5
        ```

    - **Output**:
        ```
        true true
        false false
        true true
        Истина Истина
        Истина Истина
        Ложь Ложь
        5
        ```

2. Тест на `N = 2`, `M = 3`, и логические выражения:

    - **Input**:
        ```
        2 3
        x > 5
        x < 3
        x = 5
        x > 1
        x < 10
        x = 5
        5
        ```

    - **Output**:
        ```
        false false true
        true true true
        Истина Истина Истина
        Ложь Ложь Истина
        4 
        ```

3. Тест на `N = 3`, `M = 2`, и логические выражения:

    - **Input**:
        ```
        2 2
        x > 2
        x < 4
        x > 3
        x = 2
        3
        ```

    - **Output**:
        ```
        true true
        false false
        Истина Истина
        Ложь Ложь
        3
        ```

4. Тест на `N = 3`, `M = 1`, и логические выражения:

    - **Input**:
        ```
        3 1
        x < 7
        x = 4
        x > 6
        5
        ```

    - **Output**:
        ```
        true
        false
        false
        Истина
        Ложь
        Ложь
        3 
        ```

5. Тест на `N = 4`, `M = 3`, и логические выражения:

    - **Input**:
        ```
        4 3
        x > 2
        x < 5
        x = 3
        x > 4
        x < 6
        x = 7
        x > 6
        x = 4
        x < 10
        x < 3
        x = 5
        x > 1
        5
        ```

    - **Output**:
        ```
        true false false
        true true false
        false false true
        false true true
        Истина Истина Ложь
        Ложь Истина Истина
        Истина Ложь Ложь
        Ложь Ложь Истина
        8 
        ```
