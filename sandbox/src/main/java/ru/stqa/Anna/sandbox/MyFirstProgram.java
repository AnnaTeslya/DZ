package ru.stqa.Anna.sandbox;

public class MyFirstProgram {

	public static void main(String[] agrs) {
		hello("Anna");
		Square s = new Square(6);

		Rectangle r = new Rectangle(4,6);
		System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

	}
	public static void hello(String somebody) {
		System.out.println(" Hello," + somebody +"!");
	}
}


