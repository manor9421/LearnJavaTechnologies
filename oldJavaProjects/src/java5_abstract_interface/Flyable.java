package java5_abstract_interface;

// интерфейс - это способность
public interface Flyable {// интерфейс - как абстрактный
	// класс(все методы - public abstract), но нельзя
	// создавать переменные, а константы можно
	/*public static final*/ int MAX_SPEED = 100;
	/*public abstract*/ void fly();
}
