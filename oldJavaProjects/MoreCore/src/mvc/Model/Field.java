package mvc.Model;

import java.awt.Window.Type;

import javax.swing.JButton;

public class Field {
	public enum GameType {X,O,NOT_SET}
	
	GameType[][] cells;
	
	public Field(){
		cells = new GameType[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				cells[i][j] = GameType.NOT_SET;
			}
		}
	}
	
	public void show(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				//System.out.println(cells[i][j] + " ");
				switch(cells[i][j]){
					case X:
						System.out.print("X");
						break;
					case O:
						System.out.print("O");
						break;
					case NOT_SET:
						System.out.print(".");
						break;
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void doShoot(Point point, GameType type){
		cells[point.getX()][point.getY()] = type;
	}
	
	public boolean checkWin(GameType t){
		boolean isWin = false;
		
		if (cells[0][0] == t && cells[1][0] == t && cells[2][0] == t) {
            isWin = true;
        }
        if (cells[0][1] == t && cells[1][1] == t && cells[2][1] == t) {
            isWin = true;
        }
        if (cells[0][2] == t && cells[1][2] == t && cells[2][2] == t) {
            isWin = true;
        }
        if (cells[0][0] == t && cells[0][1] == t && cells[0][2] == t) {
            isWin = true;
        }
        if (cells[1][0] == t && cells[1][1] == t && cells[1][2] == t) {
            isWin = true;
        }
        if (cells[2][0] == t && cells[2][1] == t && cells[2][2] == t) {
            isWin = true;
        }
        if (cells[0][0] == t && cells[1][1] == t && cells[2][2] == t) {
            isWin = true;
        }
        if (cells[2][0] == t && cells[1][1] == t && cells[0][2] == t) {
            isWin = true;
        }
		
		return isWin;
	}
}
