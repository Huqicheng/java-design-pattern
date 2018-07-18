Singleton Pattern
=============================

## Definition
In software engineering, the singleton pattern is a software design pattern that
restricts the instantiation of a class to one object. 
This is useful when exactly one object is needed to coordinate actions across the system. 

## What problems does is solve



#### It gives solution like 


	

## Pros & Cons
Advantages
	
	
	

Disadvantages

	
	



## Example
![Class Diagram]()

``` java
public class Singleton {

	private static Singleton singleton;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}
}
```