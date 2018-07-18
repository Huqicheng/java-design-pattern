Factory Method Pattern
=============================

## Definition
In class-based programming, the factory method pattern is a creational pattern 
that uses factory methods to deal with the problem of creating objects 
without having to specify the exact class of the object that will be created. 
This is done by creating objects by calling a factory method¡ªeither specified 
in an interface and implemented by child classes, or implemented in a base class 
and optionally overridden by derived classes¡ªrather than by calling a constructor.

## What problems does is solve
How can an object be created so that subclasses can redefine which class to instantiate?

How can a class defer instantiation to subclasses?


#### It gives solution like 

Define a separate operation (factory method) for creating an object.

Create an object by calling a factory method.
	

## Pros & Cons
Advantages
	
	


Disadvantages

	



## Example
![Class Diagram](https://upload.wikimedia.org/wikipedia/commons/4/43/W3sDesign_Factory_Method_Design_Pattern_UML.jpg)

``` java
public abstract class Room {
}

public class MagicRoom extends Room {
}

public class OrdinaryRoom extends Room {
}

public abstract class MazeGame {
    private final List<Room> rooms = new ArrayList<>();

    public MazeGame() {
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        room1.connect(room2);
        rooms.add(room1);
        rooms.add(room2);
    }

    abstract protected Room makeRoom();
}

public class MagicMazeGame extends MazeGame {
    @Override
    protected Room makeRoom() {
        return new MagicRoom(); 
    }
}

public class OrdinaryMazeGame extends MazeGame {
    @Override
    protected Room makeRoom() {
        return new OrdinaryRoom(); 
    }
}

MazeGame ordinaryGame = new OrdinaryMazeGame();
MazeGame magicGame = new MagicMazeGame();
```