package creational.builder;

/*
 * the builder which will create two components of the car.
 */
interface CarBuilder {
    Car build();

    CarBuilder setColor(final String color);

    CarBuilder setWheels(final int wheels);
}