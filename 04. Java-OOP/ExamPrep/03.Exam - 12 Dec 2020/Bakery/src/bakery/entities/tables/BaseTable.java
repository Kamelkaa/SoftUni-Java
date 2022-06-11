package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;


public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.price = 0;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    //Reserves the table with the count of people given.
    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople * getPricePerPerson();
        isReserved = true;
    }

    //Orders the provided food (think of a way to collect all the food which is ordered).
    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    //Orders the provided drink (think of a way to collect all the drinks which are ordered).
    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    //Returns the bill for all of the ordered drinks and food.
    @Override
    public double getBill() {
        double drinksBill = drinkOrders.stream()
                .mapToDouble(Drink::getPrice)
                .sum();
        double foodBill = foodOrders.stream()
                .mapToDouble(BakedFood::getPrice)
                .sum();

        return foodBill + drinksBill + this.getPrice();
    }

    //Removes all the ordered drinks and food and finally frees the table sets the count of people and price to 0.
    @Override
    public void clear() {
        drinkOrders.clear();
        foodOrders.clear();
        isReserved = false;
        this.price = 0;

    }

    @Override
    public String getFreeTableInfo() {
        return String.format("Table: %d%n" +
                        "Type: %s%n" +
                        "Capacity: %d%n" +
                        "Price per Person: %.2f", getTableNumber(),
                this.getClass().getSimpleName(), getCapacity(), getPricePerPerson());
    }
}
