package mvc.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import mvc.Controller.GameController;
import mvc.Model.Field;
import mvc.Model.Point;

public class GameWindow extends JFrame{
	
	JPanel jPanel = new JPanel();
	JButton[][] buttons = new JButton[3][3];
	
	public void init(){
		setSize(400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// что делать при закрытии
		setTitle("XO GAME");
		//jPanel.setLayout(new FlowLayout());//default
		jPanel.setLayout(new GridLayout(3, 3));
		
		for(int i=0;i<buttons.length;i++){
			JButton[] buttonLine = buttons[i];
			final int finalI = i;
			for(int j=0;j<buttons.length;j++){
				final int finalJ = j;
				JButton jButton = new JButton();
				jButton.setText(j % 2 == 0 ? "X" : "0");
				jButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String btnText = e.getActionCommand();//вернет название кнопки
						System.out.printf("Button: %s, x: %d, y: %d\n",btnText,finalJ,finalI);
						GameController.doShoot(new Point(finalI, finalJ), btnText.equals("X") ? Field.GameType.X : Field.GameType.O);
					}
				});
				
				buttons[i][j] = jButton;
				//buttonLine[j] = jButton;
				jPanel.add(jButton);
			}
		}
		
		add(jPanel);
		setVisible(true);
	}
	
}
