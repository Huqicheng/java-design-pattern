Facade Pattern
=============================

## Definition

The facade pattern (also spelled as facade) is a software-design pattern commonly 
used with object-oriented programming. The name is an analogy to 
an architectural facade.


## What problems does is solve

make a software library easier to use, understand, and test, since the facade has convenient methods for common tasks

make the library more readable, for the same reason

reduce dependencies of outside code on the inner workings of a library, since most code uses the facade, thus allowing more flexibility in developing the system

wrap a, subjectively, poorly-designed collection of APIs with a single well-designed API


#### It gives solution like 

 use the facade design pattern when a system is very complex or difficult to understand because the system has a large number of interdependent classes or 
 because its source code is unavailable. 



## Pros & Cons
Advantages
	
	
	

Disadvantages

	
	



## Example
![Class Diagram](https://upload.wikimedia.org/wikipedia/en/5/57/Example_of_Facade_design_pattern_in_UML.png)

```java
/* Complex parts */

class CPU {
    public void freeze() { ... }
    public void jump(long position) { ... }
    public void execute() { ... }
}

class HardDrive {
    public byte[] read(long lba, int size) { ... }
}

class Memory {
    public void load(long position, byte[] data) { ... }
}

/* Facade */

class ComputerFacade {
    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }
}

/* Client */

class You {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
```

