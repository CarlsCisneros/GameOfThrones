/*
import java.awt.Point;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BiggerMonster implements MonsterInterface, Movement {
	int x; 
	int y; 

	OceanMap oceanMap; 
	Movement[][] map; 
	Random rand = new Random();
	
	Circle circle; 
	int scalingFactor = 15; 
	int radius = 10; 
	int size; 
	int c; 
	
	public BiggerMonster(int x, int y, Circle newCircle) {
		oceanMap = OceanMap.getOceanMapInstance(); 
		map = oceanMap.getMap1(); 
		circle = newCircle; 
		circle.setFill(Color.DARKORANGE);
		circle.setStroke(Color.ORANGE);
		this.x = x; 
		this.y = y; 
		size = 3; 
		setPositionOfX(this.x);
		setPositionOfY(this.y);
		circle.setRadius(radius * size); 
		map[y][x] = this; 
	}
	

	public String getVal() {
		return "MONSTER"; 
	}
	/*
	private void setPositionOfX(int x) {
		// TODO Auto-generated method stub
		circle.setCenterX(x * scalingFactor + (scalingFactor/2));
	}
	*/
	/*
	public void setX(int PosX) {
		x = PosX; 
		setPositionOfX(x); 
	}
	*/
	
    /*
	private void setPositionOfY(int y) {
		// TODO Auto-generated method stub
		circle.setCenterY(y * scalingFactor + (scalingFactor/2));
	}
	*/
	
	/*
	private void setY(int PosY)  {
		y = PosY; 
		setPositionOfY(y);
	}
	
	public void setSize(int sizeNew) {
		size = sizeNew; 
	}
	
	public int getSize() {
		return size; 
	}
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y; 
	}
	
	public void increaseSize() {
		size++; 
	}
	
	public int getIndex() {
		return 0; 
	}
	
	public int getC() {
		return 0; 
	}


	@Override
	public void goNorth() {
		// TODO Auto-generated method stub

	}

	@Override
	public void goEast() {
		// TODO Auto-generated method stub

	}

	@Override
	public void goWest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void goSouth() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(int PosX, int PosY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movement getObject() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Point getMonsterLocation() {
		// TODO Auto-generated method stub
		return new Point(x, y);
	}
	
	public MonsterInterface getComponent() {
		return (MonsterInterface) circle; 
	}
	
	public Circle getCircle() {
		return circle; 
	}


	@Override
	public void changeC() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setX(int posX) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setY(int posY) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPositionOfX(int x) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPositionOfY(int y) {
		// TODO Auto-generated method stub
		
	}

}
*/