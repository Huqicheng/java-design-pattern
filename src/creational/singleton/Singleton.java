package creational.singleton;

public class Singleton {

	// this is for lazy initialization
	// otherwise, you should initialize singleton in the static area,
	// which is 'private static Singleton singleton = new Singleton();'
	// and in getInstance(), just return the singleton.
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
