package day2;

interface Vehicle {
	void wheels();
	void mileage();
}

abstract class Car implements Vehicle {
	public void wheels() {
		System.out.println("Car has 4 wheels");
	}
}

class Swift extends Car {
	public void mileage() {
		System.out.println("Mileage is 40kmpl");
	}
}

class Ferrari extends Car {
	public void mileage() {
		System.out.println("Mileage is 42kmpl");
	}
}

public class Exercise4 {
	public static void main(String[] args) {
		Swift s = new Swift();
		Ferrari f = new Ferrari();
		ui(s);
		ui(f);
	}

	public static void ui(Car c) {
		c.wheels();
		c.mileage();
	}
}
