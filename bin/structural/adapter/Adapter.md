Adapter Pattern
=============================

## Definition
In software engineering, the adapter pattern is a software design pattern 
(also known as Wrapper, an alternative naming shared with the Decorator pattern) 
that allows the interface of an existing class to be used as another interface. 
It is often used to make existing classes work with others without modifying 
their source code.

## What problems does is solve

How can a class be reused that does not have an interface that a client requires?

How can classes that have incompatible interfaces work together?

How can an alternative interface be provided for a class?

#### It gives solution like 

Define a separate Adapter class that converts the (incompatible) interface of a class (Adaptee) into another interface (Target) clients require.

Work through an Adapter to work with (reuse) classes that do not have the required interface.

	

## Pros & Cons
Advantages
	
	
	

Disadvantages

	
	



## Example
![Object Adapter](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/ObjectAdapter.png/300px-ObjectAdapter.png)
![Class Adapter](https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/ClassAdapter.png/300px-ClassAdapter.png)

``` java
public class AdapteeToClientAdapter implements Adapter {

    private final Adaptee instance;

    public AdapteeToClientAdapter(final Adaptee instance) {
         this.instance = instance;
    }

    @Override
    public void clientMethod() {
       // call Adaptee's method(s) to implement Client's clientMethod
    }

}
```