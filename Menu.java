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
