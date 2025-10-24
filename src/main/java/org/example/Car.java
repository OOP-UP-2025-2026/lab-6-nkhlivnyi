package ua.opnu;

public class Car implements Comparable {

    private int price;
    private int year;
    private int horsePower;

    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Car) {
            Car c = (Car) o;

            // 1. Менша ціна → "більше"
            if (this.price != c.price)
                return c.price - this.price;

            // 2. Новіший рік → "більше"
            if (this.year != c.year)
                return this.year - c.year;

            // 3. Більше кінських сил → "більше"
            return this.horsePower - c.horsePower;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Car{price=" + price + ", year=" + year + ", hp=" + horsePower + '}';
    }
}
