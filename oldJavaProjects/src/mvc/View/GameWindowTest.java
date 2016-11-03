package mvc.View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameWindowTest extends JFrame{
	
	public void init(){
		setSize(400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// что делать при закрытии
		setTitle("XO GAME");
		
		JButton jButton = new JButton("Hello");
		add(jButton,BorderLayout.CENTER);// center - default
		add(new JButton("N"),BorderLayout.NORTH);
		add(new JButton("E"),BorderLayout.EAST);
		add(new JButton("W"),BorderLayout.WEST);
		add(new JButton("S"),BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	
	
}
