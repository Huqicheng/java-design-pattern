Abstract Factory Pattern
=============================

## Definition
The abstract factory pattern provides a way to encapsulate a group of 
individual factories that have a common theme without specifying their 
concrete classes.[1] 
In normal usage, the client software creates a concrete implementation of the abstract factory 
and then uses the generic interface of the factory to create the concrete objects 
that are part of the theme. The client doesn't know (or care) 
which concrete objects it gets from each of these internal factories, 
since it uses only the generic interfaces of their products. 
This pattern separates the details of implementation of a set of 
objects from their general usage and relies on object composition, 
as object creation is implemented in methods exposed in the factory interface.

## What problems does is solve

How can an application be independent of how its objects are created?
How can a class be independent of how the objects it requires are created?
How can families of related or dependent objects be created?

It gives solution like, 

	1. Encapsulate object creation in a separate (factory) object. 
	That is, define an interface (AbstractFactory) for creating objects, 
	and implement the interface.
	
	2. A class delegates object creation to a factory object instead of creating objects directly.

## Pros & Cons

## Example
[Class Diagram](https://en.wikipedia.org/wiki/File:Abstract_factory.svg)

``` java
public interface IButton {
	void paint();
}

public interface IGUIFactory {
	public IButton createButton();
}

public class WinFactory implements IGUIFactory {
	@Override
	public IButton createButton() {
		return new WinButton();
	}
}

public class OSXFactory implements IGUIFactory {
	@Override
	public IButton createButton() {
		return new OSXButton();
	}
}

public class WinButton implements IButton {
	@Override
	public void paint() {
		System.out.println("WinButton");
	}
}

public class OSXButton implements IButton {
	@Override
	public void paint() {
		System.out.println("OSXButton");
	}
}

public class Main {

	public static void main(final String[] arguments) throws Exception {
		IGUIFactory factory = null;
		
		final String appearance = randomAppearance();	// Current operating system

		if (appearance.equals("OSX")) {
			factory = new OSXFactory();
		} else if(appearance.equals("Windows")) {
			factory = new WinFactory();
		} else {
			throw new Exception("No such operating system");
		}
		
		final IButton button = factory.createButton();

		button.paint();
	}
	
	/**
	 * This is just for the sake of testing this program, and doesn't have to do
	 * with Abstract Factory pattern.
	 * @return
	 */
	public static String randomAppearance() {
		final String[] appearanceArray = new String[3];

		appearanceArray[0] = "OSX";
		appearanceArray[1] = "Windows";
		appearanceArray[2] = "error";
		final java.util.Random random = new java.util.Random();

		final int randomNumber = random.nextInt(3);

		return appearanceArray[randomNumber];
	}
}
```