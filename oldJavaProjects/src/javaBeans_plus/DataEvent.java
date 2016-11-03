package javaBeans_plus;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import java.util.EventObject;
import java.util.Vector;

public class DataEvent{// extends EventObject
/*
	private MySource source; 
	private long date;
	
	public DataEvent (Object source) { 
		super(source); 
		this.source = (StickFigure)source; 
	    	date = System.currentTimeMillis(); 
	} 
	public long getDate() {
		return date;
	}
	//...
*/
}
/*
Требования:
- Наличие пустого конструктора
- set/get-теры 
- Add/remove methods for events 
	Java event model (as introduced by JDK 1.1)
- потокобезопасность
*/
/*
// должны быть интерфейсы, в их конец добавляют "Listener"
public interface MySourceListener extends java.util.EventListener {
	public void mySourceChanged(DataEvent e);
	//....
}

// add/remove методы. В конце ставим ИМЕННО то, что они добавляют/удаляют
public void addMySourceListener (MySourceListener listeningObject);
public void removeMySourceListener (MySourceListener listeningObject);

// Подписка на событие
private Vector targets = new Vector(2);// класс Vector потокобезопасен
//...
public synchronized void addMySourceListener(MySourceListener l) {
	targets.addElement(l);
// throws java.util.TooManyListenersException; 
}
public synchronized void removeMySourceListener(MySourceListener l) {
	targets.removeElement(l);
}

//Отправка сообщений
protected void notifyTargets() {// protected - чтобы клиент его точно не видел
Vector l;// создаем локальную коллекцию
DataEvent s = new DataEvent(this);
synchronized(this) {

	// процесс отправки сообщений многим может быть долгим,
	// поэтому мы создаем ПОВЕРХНОСНУЮ копию массива, который
	// хранит ссылки на те же элементы. Теперь при работе мы никому не мешаем
	l = (Vector) targets.clone();
}
for (int i = 0; i < l.size(); i++) {
	MySourceListener sl =
	(MySourceListener) l.elementAt(i);
	sl. mySourceChanged(s);
	}
}

// Индексированное свойство
private String[] lines = new String[10];
public String[] getLines() {
	return this.lines.clone();
}
public String getLines( int index ) {
	return this.lines[index];
}
public void setLines( String[] lines ){
	this.lines = lines;
}
public void setLines( int index, String line ) {
	this.lines[index] = line;
}

// Связанные свойства (bound properties)
private String title;
private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
public String getTitle(){
	return this.title;
}
public void setTitle( String title ){
	String old = this.title;
	this.title = title;
	this.pcs.firePropertyChange( "title", old, title );// сообщить всем, кто подписан, что это свойство изменилось
}
public void addPropertyChangeListener(PropertyChangeListener l ) {
	this.pcs.addPropertyChangeListener( l );
}

// Контролируемые свойства
private String title; 
private final PropertyChangeSupport pcs = new PropertyChangeSupport( this );
private final VetoableChangeSupport vcs = new VetoableChangeSupport( this );
public String getTitle(){
	return this.title;
}
public void setTitle( String title ) throws PropertyVetoException {
	String old = this.title;
	this.vcs.fireVetoableChange( "title", old, title );
	this.title = title;
	this.pcs.firePropertyChange( "title", old, title );
}
*/