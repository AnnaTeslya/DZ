package ru.stqa.Anna.sandbox;

public class MyFirstProgram {

	public static void main(String[] agrs) {
		hello("user");
		hello("Anna");
		double l = 8.0;
		double a=4;
		double b=7;
		System.out.println("Площадь квадрата со стороной " + l + " равна " + area(l));
		System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a,b));

	}

	public static void hello(String somebody) {
		System.out.println(" Hello," + somebody +"!");
	}
	public static double area(double len) {
		return len * len;
	}
	public static double area(double a, double b){
		return a*b;
	}

}