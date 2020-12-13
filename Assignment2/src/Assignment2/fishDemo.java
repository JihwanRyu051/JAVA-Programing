package Assignment2;

public class fishDemo {
	public static void main(String[] args){
		/*
		Fish fish = new ClassName(); //use the name of the class that you create to replace ClassName.
		fish.greeting();
		fish.someMethod();  //use the method that you write to replace someMethod.
		*/
		Fish fish = new Fish(3, "Nemo");
		Fish shark = new Shark(5, "Bruce", "Deep and Dark Sea");
		shark.greeting();
		Shark hungryShark = (Shark)shark;
		hungryShark.eatFish(fish);
	}

}
