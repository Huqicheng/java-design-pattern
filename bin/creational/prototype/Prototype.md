Prototype Pattern
=============================

## Definition
The prototype pattern is a creational design pattern in software development. 
It is used when the type of objects to create is determined by a prototypical instance,
 which is cloned to produce new objects.

## What problems does is solve
avoid subclasses of an object creator in the client application, like the factory method pattern does.

avoid the inherent cost of creating a new object in the standard way (e.g., using the 'new' keyword) when 
it is prohibitively expensive for a given application.


#### It gives solution like 
Declare an abstract base class that specifies a pure virtual clone() method. 
Any class that needs a "polymorphic constructor" capability derives itself 
from the abstract base class, and implements the clone() operation.

	

## Pros & Cons
Advantages
	
	Clone() is the copy operation based on bits so it's really efficient.
	

Disadvantages

	No constraint from the constructor (it clones directly from memory), a little bit unsafe.
	



## Example
![Class Diagram](https://upload.wikimedia.org/wikipedia/commons/c/c4/W3sDesign_Prototype_Design_Pattern_UML.jpg)

``` java
// Prototype pattern
public abstract class Prototype implements Cloneable {
    public Prototype clone() throws CloneNotSupportedException{
        return (Prototype) super.clone();
    }
}
	
public class ConcretePrototype1 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (ConcretePrototype1)super.clone();
    }
}

public class ConcretePrototype2 extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (ConcretePrototype2)super.clone();
    }
}
```