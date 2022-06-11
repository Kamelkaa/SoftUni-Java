package restaurant.core;
import restaurant.common.enums.BeveragesType;
import restaurant.common.enums.HealthyFoodType;
import restaurant.common.enums.TableType;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.HealthFoodRepositoryImpl;
import restaurant.repositories.TableRepositoryImpl;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = new HealthFoodRepositoryImpl();
        this.beverageRepository = new BeverageRepositoryImpl();
        this.tableRepository = new TableRepositoryImpl();
        this.totalMoney = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood healthyFood = null;

        HealthyFoodType healthyFoodType = HealthyFoodType.valueOf(type);
        if (healthyFoodType.equals(HealthyFoodType.Salad)) {
            healthyFood = new Salad(name, price);
        } else if (healthyFoodType.equals(HealthyFoodType.VeganBiscuits)) {
            healthyFood = new VeganBiscuits(name, price);
        }

        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        healthFoodRepository.add(healthyFood);
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = null;

        BeveragesType beveragesType = BeveragesType.valueOf(type);
        if (beveragesType.equals(BeveragesType.Fresh)) {
            beverage = new Fresh(name, counter, brand);
        } else if (beveragesType.equals(BeveragesType.Smoothie)) {
            beverage = new Smoothie(name, counter, brand);
        }

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }

        beverageRepository.add(beverage);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        TableType tableType = TableType.valueOf(type);

        if (tableType.equals(TableType.Indoors)) {
            table = new Indoors(tableNumber, capacity);
        } else if (tableType.equals(TableType.InGarden)) {
            table = new InGarden(tableNumber, capacity);
        }

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table freeTable = tableRepository.getAllEntities().stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (freeTable == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        freeTable.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, freeTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood healthyFood = healthFoodRepository.foodByName(healthyFoodName);
        if (healthyFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(healthyFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Beverages beverage = beverageRepository.beverageByName(name, brand);
        if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        this.totalMoney += bill;
        table.clear();

        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, this.totalMoney);
    }
}
