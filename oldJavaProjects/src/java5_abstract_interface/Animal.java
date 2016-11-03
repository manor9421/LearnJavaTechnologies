package java5_abstract_interface;

public abstract class Animal {
	// abstract = нельзя создавать новый экземпляр(new Animal), можно только наследоваться
	String name;
	int age;
	
	public Animal(){}
	
	public Animal(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	void eat(){
		System.out.println("eat");
	}
	
	abstract void voice();// просто обозначить, 
	// что такой метод должен быть реализован
	// у наследников(только у абстрактных классов)
}
// ПОЛИМОРФИЗМ потому что, хоть и не можем создать
// экземпляр класса, но можем создать массив, из
// него, и вложить внутрь потомков
/*
Animal[] animals = new Animal[3];
for(int i=0;i<animals.length-1;i++){
	animals[i] = new Cat();
}
animals[animals.length - 1] = new Duck();

for(Animal animal : animals){
	animal.voice();
}
*/

// кастование - Рантайм эксепшн