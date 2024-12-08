## Отчет по лабораторной работе №3
#### № группы: 'ПМ-2402'
#### Выполнила: 'Тагирова Камилла Маратовна'
#### Выриант: '25'
### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Алгоритм](#2-алгоритм)
- [Программа](#3-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Разработать программу для управления меню столовой, включающего названия блюд,
> их стоимость и количество порций. Реализовать функции добавления, изменения и удаления блюд, 
> управления продажами и анализа ассортимента.


### 2. Алгоритм

#### Алгоритм выполнения программы:

1. **Мы создаем меню столовой, которое включает в себя название блюд, их стоимость и количество порций:**
> Для этого у нас создается класс Dish, в котором описаны эти поля, а именно поле String dish, поле double price и поле int count.
> Dish - название блюда, price - цена блюда, count - количество порций блюда. Мы описываем соответствующие геттеры и сеттеры для этих полей и конструктор Dish, а также перераспределяем формат вывода. 
2. **Мы создаем отдельный класс Menu для работы с конкретными задачами, например: вывод меню, добавление блюда, удаление блюда и т.д**
> В классе мы создаем свои поля, а именно массив, в котором будут храниться наши блюда и отдельную переменную для подсчёта добавленных блюд.
> Для выполнения конкретных задач мы создаем методы.
3. **Метод addDish - метод, который добавляет новое блюдо в меню**
> Для начала мы осуществляем необходимые проверки: цена не должна быть нулевой или же меньше нуля, не должно быть блюд с одинаковым названием, есть ли еще свободное место в меню.
> Когда все проверки проходят мы добавляем новое блюдо в меню, увеличиваем счётчик добавленных блюд на 1 и сообщаем пользователю об успешном добавлении.
4. **Метод printMenu - метод печати нашего меню, в независимости от количества порций каждого блюдо**
> Для начала мы проверяем, есть ли у нас хотя бы одно блюдо, которое можно вывести, если нет, то сообщаем об этом.
> Сортируем наше меню, чтобы вывод блюд осуществлялся в алфавитном порядке. Для этого создаем отдельный метод **sortMenu**, в котором сортируем наш массив пузырьком, сравнивая названия блюд, которые уже хранятся в меню и передаваемого.
> Выводим название блюда и его цену.
5. **Метод printAvailableMenu - метод печати нашего меню (только доступных блюд)**
> Работает также, как и предыдущий метод, но с одной дополнительной проверкой(количеств порций должно быть > 0, так как вывод должен быть только доступных блюд)
6. **Метод prepareCount - приготовление порций блюда**
> В метод передается номер блюда в меню и количество порций, на которое должно измениться количество уже существующих порций.
> Проверяем, чтобы передаваемый номер блюда был существующим, а также чтобы передаваемое количество порций было весомое, то есть > 0.
> Если все передаваемые значения прошли проверки, мы изменяем количество порций блюда.
7. **Метод changePrice - изменение цены блюда**
> В метод передается номер блюда в меню и новая цена.
> Осуществляем проверки номера и цены (цена не должна быть > уже существующие цены)
> Если все передаваемые значения прошли проверку, мы изменяем цену.
8. **Метод buyDish - покупка одного блюда**
> В метод передается номер блюда в меню.
> Проверяем передаваемый номер.
> Проверяем, доступно ли сейчас купить это блюдо, то есть количество порций > 0 или нет.
> Если проверка прошла, то уменьшаем количество порций на 1 и возвращаем пользователю цену этого блюда.
9. **Метод buyMultDishes - покупка нескольких блюд**
> В метод передается массив целых чисел - это номера блюд, которые хотят купить.
> Создаем новую переменную типа double для подсчёта общей суммы и (для удобства) переменную типа boolean, чтобы отследить, осуществилась ли операция.
> Начинаем проходить по нашему массиву. Берем первый номер, проверяем его, подходит ли он под условие.
> Если номер прошел проверку, то передаем этот номер в уже созданный метод для покупки одного блюда (buyDish).
> Если этот номер вернулся нужной ценой этого блюда, то добавляем его в общую сумму.
> Проходимся по массиву номеров до конца и получаем общую сумму для покупки.
10. **Метод maxDishes - максимальное количество блюд по передаваемой сумме**
> В метод передается определенная сумма, на которую пользователь собирается осуществить покупку.
> Создаем переменную для подсчёта доступных блюд.
> Создаем новый массив типа Dich, в который добавляем только доступные блюда. 
> Сортируем полученный массив по цене блюд, чтобы начать подсчёт с блюд с самой низкой ценой.
> Создаем переменную для подсчёта максимального количества блюд, которые можно купить на эту сумму.
> Начинаем проходится по нашему отсортированному массиву, берем первое блюдо, создаем временную переменную для вычисления минимального значения между доступным количеством порций этого блюда и количеством порций, которые мы можем купить с передаваемой суммой. 
> Прибавляем полученное количество к нашему счетчику и вычитаем из общей суммы сумму, которую должны заплатить за это блюдо.
> Возвращаем получившееся максимальное количество блюд, которое можно купить за такую сумму.
11. **Метод getThreeMostExpDishes - три самых дорогих блюда**
> Создаем три переменные типа Dish для хранения трех самых дорогих блюд.
> Запускаем цикл, где проходимся по каждому блюду нашего меню.
> И осуществляем каждый раз проверку, подходит ли наше блюдо под условие самых дорогих блюд, в зависимости от присваиваний нашим переменным новых значений.
> После цикла выводим три самых дорогих блюда, если их вообще нет, то выводим это.
12. **Метод getThreeMostExpDishes - три самых дорогих блюда**
> Создаем три переменные типа Dish для хранения трех самых дешёвых блюд.
> Запускаем цикл, где проходимся по каждому блюду нашего меню.
> И осуществляем каждый раз проверку, подходит ли наше блюдо под условие самых дешёвых блюд, в зависимости от присваиваний нашим переменным новых значений.
> После цикла выводим три самых дешёвых блюда, если их вообще нет, то выводим это.
13. **Метод removeDish - удаление блюда**
> В метод передается название нашего блюда.
> Запускаем цикл, в котором проходимся по элементам нашего массива (меню).
> Если название блюда совпадает с названием, которое мы передали в массив,
> то мы запускаем новый цикл, в котором начинаем идти с номера, который нашли и перезаписываем всё меню.
14. **Метод removeDishIfOutStock - удаление блюда, если его нет в наличии**
>

### 3.1. Программа работы с пользователем

```java
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
```
### 3.2. Класс с методами для работы с меню столовой
```java
public class Menu {
public Dish[] menu;
public int dishCount;

    Menu() {
        menu = new Dish[5];
        dishCount = 0;
    }

    //Добавление блюда(1)
    public void addDish(String dish, double price, int count) {
        //Проверка, существует ли блюдо с таким названием
        if (dishCount > 0)
            for (int i = 0; i < dishCount; i++)
                //todo
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
    public void printMenu() {
        //Проверка, есть ли у нас хотя бы одно добавленное блюдо в меню
        if (dishCount == 0) {
            System.out.println("Простите, но в меню еще не добавлены блюда");
            return;
        }
        //Отсортировываем массив(меню), чтобы блюда были расположены в алфавитном порядке
        sortMenu();
        //Печать меню
        System.out.println("Меню:");
        for (int i = 0; i < dishCount; i++) {
            int number = i + 1;
            System.out.printf("%d. %s - %.2f руб.\n", number, menu[i].getDish(), menu[i].getPrice());
        }
    }

    //Печать нашего меню(доступных блюд)(3)
    public void printAvailableMenu() {
        //Проверка, есть ли у нас хотя бы одно добавленное блюдо в меню
        if (dishCount == 0) {
            System.out.println("Простите, но в меню еще не добавлены блюда");
            return;
        }
        //Отсортировываем массив(меню), чтобы блюда были расположены в алфавитном порядке
        sortMenu();
        //Печать меню с доступными блюдами
        System.out.println("Меню доступных блюд:");
        int number = 0;
        for (int i = 0; i < dishCount; i++)
            if (menu[i].getCount() > 0) {
                number++;
                System.out.printf("%d. %s - %.2f руб. (%d порций)\n", number, menu[i].getDish(), menu[i].getPrice(), menu[i].getCount());
            }
    }

    //Отдельная подпрограмма для сортировки массива(меню) по названию блюд
    public void sortMenu() {
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
    public void prepareCount(int num, int cnt) {
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
        System.out.printf("%s\n%d. %s (%d порций)\n", "Успешно", num, menu[num - 1].getDish(), menu[num - 1].getCount());
    }

    //Изменение цены блюда(5)
    public void changePrice(int num, double price) {
        //Требуемые в задании проверки
        if (num < 1 || num > dishCount) {
            System.out.println("Простите, но блюда под таким номером нет");
            return;
        }
        if (price == menu[num - 1].getPrice() || menu[num - 1].getPrice() - price > 0) {
            System.out.println("Простите, но цену можно только увеличить");
            return;
        }
        //Изменение цены
        menu[num - 1].setPrice((price));
        System.out.printf("Цена блюда \"%s\" обновлена. Новая цена: %.2f руб.%n", menu[num - 1].getDish(), menu[num - 1].getPrice());
    }

    //Покупка одного блюда(6)
    public double buyDish(int num) {
        //Необходимые в задании проверки
        if (num < 1 || num > dishCount) {
            System.out.println("Простите, такого блюда не существует");
            return -1;
        }
        if (menu[num - 1].getCount() <= 0) {
            System.out.println("Простите, такого блюда нет в наличии");
            return -1;
        }
        //изменяем количество блюд после покупки
        menu[num - 1].setCount(menu[num - 1].getCount() - 1);
        //возвращаем цену этого блюда
        return menu[num - 1].getPrice();
    }

    //Покупка нескольких блюд(7)
    public double buyMultDishes(int[] nums) {
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
            return -1;
    }

    //Максимальное количество блюд по сумме(8)
    public int maxDishes(double sum) {
        int count = 0; //счётчик для доступных блюд
        Dish[] availableDishes = new Dish[dishCount];
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
    public void getThreeMostExpDishes() {
        Dish first = null; //Переменная для самого дорого блюда
        Dish second = null; //Переменная для второго по стоимости блюда
        Dish third = null; //Переменная для третьего по стоимости блюдо
        for (int i = 0; i < dishCount; i++) {
            if (menu[i] == null || menu[i].getCount() <= 0) {
                continue;
            }
            if (first == null || menu[i].getPrice() > first.getPrice()) {
                third = second;
                second = first;
                first = menu[i];
            } else if (second == null || menu[i].getPrice() > second.getPrice()) {
                third = second;
                second = menu[i];
            } else if (third == null || menu[i].getPrice() > third.getPrice()) {
                third = menu[i];
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
    public void getThreeCheapestDishes() {
        Dish first = null; //Переменная для самого дешёвого блюда
        Dish second = null; //Переменная для второго по стоимости блюда
        Dish third = null; //Переменная для третьего по стоимости блюдо
        for (int i = 0; i < dishCount; i++) {
            if (menu[i] == null || menu[i].getCount() <= 0) {
                continue;
            }
            if (first == null || menu[i].getPrice() < first.getPrice()) {
                third = second;
                second = first;
                first = menu[i];
            } else if (second == null || menu[i].getPrice() < second.getPrice()) {
                third = second;
                second = menu[i];
            } else if (third == null || menu[i].getPrice() < third.getPrice()) {
                third = menu[i];
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
    public void removeDish(String name) {
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
    public void removeDishIfOutStock(String name) {
        for (int i = 0; i < dishCount; i++) {
            if (menu[i].getDish().equals(name)) {
                if (menu[i].getCount() <= 0) {
                    for (int j = i; j < dishCount - 1; j++)
                        menu[j] = menu[j + 1];
                    menu[--dishCount] = null;
                    System.out.println("Блюдо удалено");
                    return;
                }
                else {
                    System.out.println("Блюдо еще есть в наличии");
                }
            }
        }
        //Если такое блюдо не найдется
        System.out.println("Такого блюда не найдено или он еще есть в наличии");
    }
}
```

### 3.3. Класс для создания блюда
```java
public class Dish {
    private String dish;
    private double price;
    private int count;

    //Создание необходимых переменных названия блюд,
    //их стоимость и количество порций.
    public Dish(String dish, double price, int count) {
        this.dish = dish; //блюдо
        this.price = price; //цена
        this.count = count; //количество порций
    }

    //Геттеры и сеттеры для этих переменных
    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
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

```

### 6. Анализ правильности решения

Программа работает корректно.

1. Тест: добавление блюда:

    - **Input**:
        ```
         1
         Кура
         123
         1

        ```

    - **Output**:
        ```
        Ваше блюдо добавлено
        ```

2. Тест: печать меню полностью:

    - **Input**:
        ```
        2
        ```

    - **Output**:
        ```
        Меню:
        1. Кура - 123,00 руб.
        2. Пельмени - 500,00 руб.
        3. Пицца - 234,00 руб.
        4. Халва - 12,00 руб.

        ```

3. Тест: печать меню доступных блюд

    - **Input**:
        ```
        3
        ```

    - **Output**:
        ```
        Меню доступных блюд:
        Кура - 123,00 руб. (1 порций)
        Пельмени - 500,00 руб. (6 порций)
        Пицца - 234,00 руб. (2 порций)
        Халва - 12,00 руб. (3 порций)

        ```

4. Тест: добавление порций

    - **Input**:
        ```
        4
        3
        2
    
        ```

    - **Output**:
        ```
        Выберите действие: 4
        Меню доступных блюд:
        1. Кура - 250,00 руб. (4 порций)
        2. Пицца - 180,00 руб. (5 порций)
        3. Цезарь - 200,00 руб. (3 порций)
        Введите номер блюда в меню: 3
        Введите количество порций: 2
        Успешно
        3. Цезарь (5 порций)
      
        ```

5. Тест: изменение цены

    - **Input**:
        ```
        5
        2
        256,5
        ```

    - **Output**:
        ```
        Выберите действие: 5
        Меню:
        1. Кура - 250,00 руб.
        2. Пицца - 180,00 руб.
        3. Цезарь - 200,00 руб.
        Введите номер блюда в меню: 2
        Введите новую цену: 256,5
        Цена блюда "Пицца" обновлена. Новая цена: 256,50 руб.
        ```
6. Тест: купить одно блюдо

   - **Input**:
       ```
       6
       3
       ```

   - **Output**:
       ```
       Меню доступных блюд:
       1. Кура - 250,00 руб. (4 порций)
       2. Пицца - 256,50 руб. (5 порций)
       3. Цезарь - 200,00 руб. (5 порций)
       Введите номер блюда в меню: 3
       Цена: 200.0
       ```
7. Тест: купить несколько блюд

   - **Input**:
       ```
       7
       3
       1 2 3
       ```

   - **Output**:
       ```
       Выберите действие: 7
       Меню доступных блюд:
       1. Кура - 250,00 руб. (4 порций)
       2. Пицца - 256,50 руб. (5 порций)
       3. Цезарь - 200,00 руб. (4 порций)
       Сколько блюд вы хотите купить? 3
       Введите номера блюд:
       1 2 3
       Общая стоимость: 706.5
       ```
8. Тест: Максимальное количество блюд за сумму

   - **Input**:
       ```
       8
       1111,25
       ```

   - **Output**:
       ```
       Выберите действие: 8
       Меню доступных блюд:
       1. Кура - 250,00 руб. (3 порций)
       2. Пицца - 256,50 руб. (4 порций)
       3. Цезарь - 200,00 руб. (3 порций)
       В пределах какой суммы вы хотите совершить покупку? 1111,25
       Максимальное количество блюд, которые вы можете купить: 5
       ```     
9. Тест: Три самых дорогих блюда

   - **Input**:
       ```
       9
       ```

   - **Output**:
       ```
       1. Манты - 500.0
       2. Пельмени - 430.0
       3. Пицца - 256.5
       ```     
10. Тест: Три самых дешёвых блюда

   - **Input**:
       ```
       10
       ```

   - **Output**:
       ```
       1. Цезарь - 200.0
       2. Кура - 250.0
       3. Пицца - 256.5

       ```          
11. Тест: Удалить блюдо полностью

    - **Input**:
        ```
        11
        Цезарь
        ```

    - **Output**:
        ```
        Выберите действие: 11
        Меню:
        1. Кура - 250,00 руб.
        2. Манты - 500,00 руб.
        3. Пельмени - 430,00 руб.
        4. Пицца - 256,50 руб.
        5. Цезарь - 200,00 руб.
        Введите название блюда: Цезарь
        Блюдо удалено

        ```    
12. Тест: Удалить блюдо, потому что его нет в наличии

   - **Input**:
       ```
       12
       Паста
       ```

   - **Output**:
       ```
       Выберите действие: 12
       Меню:
       1. Долма - 300,00 руб.
       2. Паста - 450,00 руб.
       3. Пицца - 230,00 руб.
       4. Цезарь - 200,00 руб.
       Введите название блюда: Паста
       Блюдо удалено

       ```      