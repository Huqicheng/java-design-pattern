Composite Pattern
=============================

## Definition

In software engineering, the composite pattern is a partitioning design pattern. 
The composite pattern describes a group of objects that is treated the same way 
as a single instance of the same type of object. 
The intent of a composite is to "compose" objects into tree structures 
to represent part-whole hierarchies. 
Implementing the composite pattern lets clients treat individual objects 
and compositions uniformly.

## What problems does is solve

A part-whole hierarchy should be represented so that clients can treat part and whole objects uniformly.

A part-whole hierarchy should be represented as tree structure.


#### It gives solution like 

Define a unified Component interface for both part (Leaf) objects and whole (Composite) objects.

Individual Leaf objects implement the Component interface directly, and Composite objects forward requests to their child components.

	

## Pros & Cons
Advantages
	
	
	

Disadvantages

	
	



## Example
![Class Diagram](https://upload.wikimedia.org/wikipedia/commons/3/39/W3sDesign_Composite_Design_Pattern_Type_Safety_UML.jpg)

```java
// File System, update later
```

``` java
/** "Component" */
interface Graphic {

    //Prints the graphic.
    public void print();
}

/** "Composite" */
class CompositeGraphic implements Graphic {

    //Collection of child graphics.
    private List<Graphic> childGraphics = new ArrayList<Graphic>();

    //Prints the graphic.
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();  //Delegation
        }
    }

    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }
}

/** "Leaf" */
class Ellipse implements Graphic {

    //Prints the graphic.
    public void print() {
        System.out.println("Ellipse");
    }
}

/** Client */
public class Program {

    public static void main(String[] args) {
        //Initialize four ellipses
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();

        //Initialize three composite graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();

        //Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);

        graphic2.add(ellipse4);

        graphic.add(graphic1);
        graphic.add(graphic2);

        //Prints the complete graphic (Four times the string "Ellipse").
        graphic.print();
    }
}
```