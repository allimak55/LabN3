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

### 3. Программа

```java
import java.util.Scanner;
public class Main {
   public static Scanner in = new Scanner(System.in);
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
         switch (choice) {
            case 1:
               System.out.print("Введите название блюда: ");
               String name = in.nextLine();
               in.nextLine();
               System.out.print("Введите цену блюда: ");
               double price = in.nextDouble();
               in.nextLine();
               System.out.print("Введите количество порций: ");
               int count = in.nextInt();
               Menu.addDish(name, price, count);
               break;
            case 2:
               Menu.printMenu();
               break;
            case 3:
               Menu.printAvailableMenu();
               break;
            case 4:
               System.out.println("Введите номер блюда в меню: ");
               int num1 = in.nextInt();
               System.out.println("Введите количество порций: ");
               int cnt1 = in.nextInt();
               Menu.prepareCount(num1, cnt1);
               break;
            case 5:
               System.out.println("Введите номер блюда в меню: ");
               int num2 = in.nextInt();
               System.out.println("Введите новую цену: ");
               double price1 = in.nextDouble();
               Menu.changePrice(num2, price1);
               break;
            case 6:
               System.out.println("Введите номер блюда в меню: ");
               int num3 = in.nextInt();
               double res1 = Menu.buyDish(num3);
               if (res1 != -1)
                  System.out.println("Цена: " + res1);
               break;
            case 7:
               System.out.println("Сколько блюд вы хотите купить?");
               int cnt = in.nextInt();
               System.out.println("Введите номера блюд в меню: ");
               int [] num = new int[cnt];
               for (int i = 0; i < cnt; i++)
                  num[i] = in.nextInt();
               double res2 = Menu.buyMultDishes(num);
               if (res2 != -1)
                  System.out.println("Общая стоимость: " + res2);
               break;
            case 8:
               System.out.println("В пределах какой суммы вы хотите совершить покупку?");
               double sum = in.nextDouble();
               System.out.println("Максимальное количество блюд, которые вы можете купить: " + Menu.maxDishes(sum));
               break;
            case 9:
               System.out.println("Самые дорогие блюда:");
               Menu.getThreeMostExpDishes();
               break;
            case 10:
               System.out.println("Самые дешёвые блюда:");
               Menu.getThreeCheapestDishes();
               break;
            case 11:
               System.out.println("Введите название блюда: ");
               String name1 = in.nextLine();
               in.nextLine();
               Menu.removeDish(name1);
               break;
            case 12:
               System.out.println("Введите название блюда: ");
               String name2 = in.nextLine();
               in.nextLine();
               Menu.removeDishIfOutStock(name2);
               break;
            case 13:
               System.out.println("Выход...");
               exit = true;
               break;
            default:
               System.out.println("Некорректный выбор.");
               break;
         }
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
      for (int i = 0; i < dishCount; i++) {
         System.out.printf(String.format("%s - %.2f руб.\n", menu[i].getDish(), menu[i].getPrice()));
      }

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
            System.out.printf("%s - %.2f руб.\n", menu[i].getDish(), menu[i].getPrice());

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
      if (price == menu[num - 1].getPrice() || menu[num - 1].getPrice() - price > 0) {
         System.out.println("Простите, но цену можно только увеличить");
         return;
      }
      //Изменение цены
      menu[num - 1].setPrice((price));
   }
   //Покупка одного блюда(6)
   public static double buyDish(int num) {
      //Необходимые в задании проверки
      if (num < 1 || num > dishCount) {
         System.out.println("Простите, такого блюда не существует");
         return -1;
      }
      //Проверяем, чтобы количество порций было доступно для покупки
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
         if (menu[i] == null || menu[i].getCount() <= 0) {
            continue;
         }
         if (first == null || menu[i].getPrice() > first.getPrice()) {
            third = second;
            second = first;
            first = menu[i];
         }
         else if (second == null || menu[i].getPrice() > second.getPrice()) {
            third = second;
            second = menu[i];
         }
         else if (third == null || menu[i].getPrice() > third.getPrice()){
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
   public static void getThreeCheapestDishes() {
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
         }
         else if (second == null || menu[i].getPrice() < second.getPrice()) {
            third = second;
            second = menu[i];
         }
         else if (third == null || menu[i].getPrice() < third.getPrice()){
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
