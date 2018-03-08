
//package joeyVersion;
import java.awt.Point;
import java.util.Random;
// import java.util.ArrayList;

public class OceanMap {
	final static int pirates = 2;
	boolean[][] grid;
	int dimensions;
	int islandCount;
	Random rand = new Random();
	Point shipLocation;
	Point sharkLocation;
	Point monsterLocation; 
	Point DoubleLocation;
	Point treasureLocation;
	Point[] islands = new Point[20];
	Point[] pirate = new Point[pirates];

	// ArrayList<Movement> moveables = new ArrayList<Movement>();
	// Constructor
	// Not adding validation code so make sure islandCount is much less than
	// dimension^2
	public OceanMap(int dimensions, int islandCount) {
		this.dimensions = dimensions;
		this.islandCount = islandCount;
		createGrid();
		placeIslands();
		shipLocation = placeShip();
		placePirate();
		placeShark();
		placeMonster(); 
		placeDoubleS();
		placeTreasure();
	}

	// Create an empty map
	private void createGrid() {
		grid = new boolean[dimensions][dimensions];
		for (int x = 0; x < dimensions; x++)
			for (int y = 0; y < dimensions; y++)
				grid[x][y] = false;
	}

	// Place islands onto map
	private void placeIslands() {
		int islandsToPlace = islandCount;
		int count = 0;
		while (islandsToPlace > 0) {
			int x = rand.nextInt(dimensions);
			int y = rand.nextInt(dimensions);
			if (!grid[x][y]) {
				grid[x][y] = true;
				islandsToPlace--;
				islands[count] = new Point(x, y);
				count++;
			}
		}
	}

	private Point placeShip() {
		boolean placedShip = false;
		int x = 0, y = 0;
		while (!placedShip) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (!grid[x][y]) {
				placedShip = true;
				// grid[x][y] =true;
			}
		}
		return new Point(x, y);
	}

	private void placeShark() {
		boolean placedShark = false;
		int x = 0;
		int y = 0;
		while (!placedShark) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (!grid[x][y]) {
				sharkLocation = new Point(x, y);
				placedShark = true;
			}
		}
	}
	
	private void placeMonster() {
		boolean placedMonster = false;
		int x = 0;
		int y = 0;
		while (!placedMonster) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (!grid[x][y]) {
				monsterLocation = new Point(x, y);
				placedMonster = true;
			}
		}
	}
	

	private void placeTreasure() {
		boolean placedTreasure = false;
		int x = 0;
		int y = 0;
		while (!placedTreasure) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (!grid[x][y]) {
				treasureLocation = new Point(x, y);
				placedTreasure = true;
			}
		}
	}

	private void placeDoubleS() {
		boolean placedDouble = false;
		int x = 0;
		int y = 0;
		while (!placedDouble) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (!grid[x][y]) {
				DoubleLocation = new Point(x, y);
				placedDouble = true;
			}
		}
	}

	private void placePirate() {
		int x = 0, y = 0;
		int count = 0;
		while (count < pirates) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (!grid[x][y]) {
				pirate[count] = new Point(x, y);
				count++;
			}
		}
	}

	public Point getShipLocation() {
		return shipLocation;
	}

	public Point[] getPirates() {
		return pirate;
	}

	public Point getSharkLocation() {
		return sharkLocation;
	}
	
	public Point getMonsterLocation() {
		return monsterLocation; 
	}

	public Point getDoubleSpeed() {
		return DoubleLocation;
	}

	public Point[] getIslands() {
		return islands;
	}

	public Point getTreasureLocation() {
		return treasureLocation;
	}

	// Return generated map
	public boolean[][] getMap() {
		return grid;
	}

	public int getDimensions() {
		return dimensions;
	}

	public boolean isOcean(int x, int y) {
		if (x >= 0 && x < dimensions && y >= 0 && y < dimensions) {
			if (!grid[x][y])
				return true;
			return false;
		}
		return false;
	}

	public boolean checkL() {
		for (int i = 0; i < 2; i++) {
			if (getPirates()[i].equals(getShipLocation())) {
				return false;
			}
		}
		if (getShipLocation().equals(getSharkLocation())) {
			return false;
		}
		return true;
	}

	public boolean checkW() {
		if (getShipLocation().equals(getTreasureLocation())) {
			return true;
		}
		return false;
	}
}
