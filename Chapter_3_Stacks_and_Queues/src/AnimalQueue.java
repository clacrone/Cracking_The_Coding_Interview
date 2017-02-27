import java.util.LinkedList;


public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public AnimalQueue() {
		// TODO Auto-generated constructor stub
		
	}

	public void enqueueAnimal(Animal a) {
		a.setOrder(order);
		order++;
		
		if (a instanceof Dog) {
			dogs.addLast((Dog)a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat)a);
		}
	}
	
	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if (dog.isOlderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}

	private Dog dequeueDogs() {
		// TODO Auto-generated method stub
		return dogs.poll();
	}

	private Cat dequeueCats() {
		// TODO Auto-generated method stub
		return cats.poll();
	}
}
