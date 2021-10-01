package by.it_academy.hw.hw4;

import java.util.ArrayList;
import java.util.List;

public class FactoryNisan extends Factory {
    private List<Car> warehouse;

    public FactoryNisan() {
        warehouse = new ArrayList<>();
        warehouse.add(new CarNisan(Label.NISAN, Color.GREEN, 2019, WheelSize.LARGE, Capacity.LARGE));
        warehouse.add(new CarNisan(Label.NISAN, Color.RED, 2021, WheelSize.SMALL, Capacity.SMALL));
        warehouse.add(new CarNisan(Label.NISAN, Color.GREY, 2020, WheelSize.MEDIUM, Capacity.MEDIUM));
    }

    public List<Car> getWarehouse() {
        return warehouse;
    }

    public Car createCar(Color color, int year, WheelSize size, Capacity capacity) {
        for (Car car : warehouse) {
            if (car.getColor().equals(color) && car.getYear() == year && car.getWheelSize().equals(size) && car.getEngineCapacity().equals(capacity)) {
                System.out.println("Завод " + getClass().getSimpleName() + " нашел в хранилище машину:");
                Car tmp = car;
                warehouse.remove(car);
                System.out.println("Салон получает машину:");
                return tmp;
            } else if (car.getYear() == year && car.getWheelSize().equals(size) && car.getEngineCapacity().equals(capacity)) {
                System.out.println("Завод " + getClass().getSimpleName() + " нашел в хранилище машину, которую можно изменить.");
                System.out.println(car.toString());
                Car tmp = car;
                warehouse.remove(car);
                ServiceChangeColor.changeColor(tmp, color);
                System.out.println("Салон получает машину:");
                return tmp;
            } else if (car.getColor().equals(color) && car.getYear() == year && car.getEngineCapacity().equals(capacity)) {
                System.out.println("Завод " + getClass().getSimpleName() + " нашел в хранилище машину, которую можно изменить.");
                System.out.println(car.toString());
                Car tmp = car;
                warehouse.remove(car);
                ServiceChangeWheel.changeWheel(tmp, size);
                System.out.println("Салон получает машину:");
                return tmp;
            } else if (car.getYear() == year && car.getEngineCapacity().equals(capacity)) {
                System.out.println("Завод " + getClass().getSimpleName() + " нашел в хранилище машину, которую можно изменить.");
                System.out.println(car.toString());
                Car tmp = car;
                warehouse.remove(car);
                ServiceChangeWheel.changeWheel(tmp, size);
                ServiceChangeColor.changeColor(tmp, color);
                System.out.println("Салон получает машину:");
                return tmp;
            }
        }
        System.out.println("Салон получает машину:");
        return new CarNisan(Label.NISAN, color, year, size, capacity);
    }

    public Car addOption(Car car, Option option) {
        ServiceOption.addOption(car, option);
        System.out.println("Салон получает машину:");
        return car;
    }

    public Car removeOption(Car car, Option option) {
        ServiceOption.removeOption(car, option);
        System.out.println("Салон получает машину:");
        return car;
    }
}