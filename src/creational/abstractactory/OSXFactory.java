package creational.abstractactory;

public class OSXFactory implements IGUIFactory {
	@Override
	public IButton createButton() {
		return new OSXButton();
	}
}
