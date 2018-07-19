Proxy Pattern
=============================

## Definition
A proxy, in its most general form, is a class functioning as an interface to 
something else. The proxy could interface to anything: a network connection, 
a large object in memory, a file, or some other resource that is expensive or 
impossible to duplicate. In short, a proxy is a wrapper or agent object that is 
being called by the client to access the real serving object behind the scenes. 
Use of the proxy can simply be forwarding to the real object, or can provide 
additional logic. In the proxy, extra functionality can be provided, 
for example caching when operations on the real object are resource intensive, 
or checking preconditions before operations on the real object are invoked. 
For the client, usage of a proxy object is similar to using the real object, 
because both implement the same interface.



## What problems does is solve

The access to an object should be controlled .

Additional functionality should be provided when accessing an object.


#### It gives solution like 


can be used as substitute for another object (Subject) and

implements additional functionality to control the access to this subject.


## Pros & Cons
Advantages
	
	
	

Disadvantages

	
	



## Example
![Class Diagram](https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Proxy_pattern_diagram.svg/439px-Proxy_pattern_diagram.svg.png)

```java
interface Image {
    public void displayImage();
}

// On System A
class RealImage implements Image {

    private String filename = null;
    /**
     * Constructor
     * @param filename
     */
    public RealImage(final String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    /**
     * Loads the image from the disk
     */
    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        System.out.println("Displaying " + filename);
    }

}

// On System B
class ProxyImage implements Image {

    private RealImage image = null;
    private String filename = null;
    /**
     * Constructor
     * @param filename
     */
    public ProxyImage(final String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        if (image == null) {
           image = new RealImage(filename);
        }
        image.displayImage();
    }

}

class ProxyExample {

   /**
    * Test method
    */
   public static void main(final String[] arguments) {
        final Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        final Image image2 = new ProxyImage("HiRes_10MB_Photo2");

        image1.displayImage(); // loading necessary
        image1.displayImage(); // loading unnecessary
        image2.displayImage(); // loading necessary
        image2.displayImage(); // loading unnecessary
        image1.displayImage(); // loading unnecessary
    }
}
```

