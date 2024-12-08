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
