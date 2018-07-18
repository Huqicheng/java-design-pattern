Builder Pattern
=============================

## Definition
The Builder is a design pattern designed to provide a flexible solution 
to various object creation problems in object-oriented programming. 
The intent of the Builder design pattern is to separate the construction 
of a complex object from its representation. 
It is one of the Gang of Four design patterns.

## What problems does is solve
How can a class (the same construction process) create different representations of a complex object?

How can a class that includes creating a complex object be simplified?


#### It gives solution like 

Encapsulate creating and assembling the parts of a complex object in a separate Builder object.

A class delegates object creation to a Builder object instead of creating the objects directly.
	

## Pros & Cons
Advantages
	
	Allows you to vary a product¡¯s internal representation.
	Encapsulates code for construction and representation.
	Provides control over steps of construction process.


Disadvantages

	Requires creating a separate ConcreteBuilder for each different type of product.
	Requires the builder classes to be mutable.
	Data members of class aren't guaranteed to be initialized.
	Dependency injection may be less supported.



## Example
![Class Diagram](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Builder_UML_class_diagram.svg/500px-Builder_UML_class_diagram.svg.png)
![Sequence](https://upload.wikimedia.org/wikipedia/commons/8/87/W3sDesign_Builder_Design_Pattern_UML.jpg)
``` java
/**
 * Represents the product created by the builder.
 */
class Car {
    private int wheels;
    private String color;

    public Car() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(final int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car [wheels = " + wheels + ", color = " + color + "]";
    }
}

/**
 * The builder abstraction.
 */
interface CarBuilder {
    Car build();

    CarBuilder setColor(final String color);

    CarBuilder setWheels(final int wheels);
}

class CarBuilderImpl implements CarBuilder {
    private Car car;

    public CarBuilderImpl() {
        car = new Car();
    }

    @Override
    public Car build() {
        return car;
    }

    @Override
    public CarBuilder setColor(final String color) {
        car.setColor(color);
        return this;
    }

    @Override
    public CarBuilder setWheels(final int wheels) {
        car.setWheels(wheels);
        return this;
    }
}

public class CarBuildDirector {
    private CarBuilder builder;

    public CarBuildDirector(final CarBuilder builder) {
        this.builder = builder;
    }

    public Car construct() {
        return builder.setWheels(4)
                      .setColor("Red")
                      .build();
    }

    public static void main(final String[] arguments) {
        final CarBuilder builder = new CarBuilderImpl();

        final CarBuildDirector carBuildDirector = new CarBuildDirector(builder);

        System.out.println(carBuildDirector.construct());
    }
}
```