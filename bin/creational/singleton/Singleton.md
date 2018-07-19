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
![Class Diagram](https://img-blog.csdn.net/20160809183726500?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

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