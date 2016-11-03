package com.mnr.makesome;

public class Room {

	Wall wall;
	int peopleCount;
	
	public static class Wall{// we can create new instance(with new Wall(1,1)) out of Room class withour static field
		int wallLength;
		int wallHeight;
		
		public Wall(int a, int b) {
			this.wallLength = a;
			this.wallHeight = b;
		}

	};

	public Room(int length, int height, int people) {
		this.wall = new Wall(length, height);
		this.peopleCount = people;
	}
	
	public void showParameters(){
		System.out.println("room height: " + wall.wallHeight
				+ "\n" + "room length: " + wall.wallLength
				+ "\n" + "people count: " + peopleCount);
	}
	
	
}