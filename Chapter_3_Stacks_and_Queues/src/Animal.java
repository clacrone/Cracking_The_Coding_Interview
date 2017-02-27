
public abstract class Animal {
	private int order;
	protected String name;
	
	public Animal(String n) {
		// TODO Auto-generated constructor stub
		name = n;
	}

	public void setOrder(int n) {
		order = n;
	}
	
	public int getOrder() {
		return order;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}
