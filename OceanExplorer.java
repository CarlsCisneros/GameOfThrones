import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
// import java.util.ArrayList;

public class OceanExplorer extends Application {

	boolean[][] islandMap;
	Pane root;
	final int dimensions = 20;
	final int islandCount = 20;
	final int scale = 50;
	boolean GameOver = false;
	Text WText, LText;
	Image shipImage;
	Image pirateImage;
	Image islandImage;
	Image pirateLand;
	Image sharkImage;
	Image pirate2Image;
	Image treasureImage;
	Image monsterImage; 

	ImageView treasureImageView;
	ImageView pirate2ImageView;
	ImageView shipImageView;
	ImageView[] pirateImageView;
	ImageView[] islandImageView;
	ImageView sharkImageView;
	ImageView monsterImageView; 

	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	PirateShips pirateShips;
	littleShark shark;
	Monster monster; 
	DoubleSpeed doubleSpeed;
	// ArrayList<Movement> moveables;

	@Override
	public void start(Stage mapStage) throws Exception {

		oceanMap = new OceanMap(dimensions, islandCount);
		islandMap = oceanMap.getMap(); // Note: We will revisit this in a future class and use an iterator instead of
										// exposing the underlying representation!!!
		islandImageView = new ImageView[oceanMap.getIslands().length];
		pirateImageView = new ImageView[oceanMap.getPirates().length];
		root = new AnchorPane();
		drawMap();

		ship = new Ship(oceanMap);
		pirateShips = new PirateShips(oceanMap);
		shark = new littleShark(oceanMap);
		monster = new Monster(oceanMap); 
		doubleSpeed = new DoubleSpeed(oceanMap);
		loadShipImage();
		ship.addObserver(pirateShips);
		// gg();
		ship.addObserver(shark);
		ship.addObserver(monster);
		ship.addObserver(doubleSpeed);
		scene = new Scene(root, 1000, 1000);
		mapStage.setTitle("Christopher Columbus Sails the Ocean Blue");
		mapStage.setScene(scene);
		mapStage.show();
		startSailing();
	}

	private void loadShipImage() {
		// Load the ship image for player
		Image shipImage = new Image("ship.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation().x * scale);
		shipImageView.setY(oceanMap.getShipLocation().y * scale);
		root.getChildren().add(shipImageView);
		// moveables.add(ship);

		// Load the treasure Image
		Image treasureImage = new Image("treasure.png", 50, 50, true, true);
		treasureImageView = new ImageView(treasureImage);
		treasureImageView.setX(oceanMap.getTreasureLocation().x * scale);
		treasureImageView.setY(oceanMap.getTreasureLocation().y * scale);
		root.getChildren().add(treasureImageView);

		// Load the shark image
		Image sharkImage = new Image("LittleShark.jpg", 50, 50, true, true);
		sharkImageView = new ImageView(sharkImage);
		sharkImageView.setX(oceanMap.getSharkLocation().x * scale);
		sharkImageView.setY(oceanMap.getSharkLocation().y * scale);
		root.getChildren().add(sharkImageView);
		
		// Load the monster image
		Image monsterImage = new Image("monster.jpg", 50, 50, true, true);
		monsterImageView = new ImageView(monsterImage);
		monsterImageView.setX(oceanMap.getMonsterLocation().x * scale);
		monsterImageView.setY(oceanMap.getMonsterLocation().y * scale);
		root.getChildren().add(monsterImageView);

		// Load the double speed ship
		Image pirate2Image = new Image("doubleS.png", 50, 50, true, true);
		pirate2ImageView = new ImageView(pirate2Image);
		pirate2ImageView.setX(oceanMap.getDoubleSpeed().x * scale);
		pirate2ImageView.setY(oceanMap.getDoubleSpeed().y * scale);
		root.getChildren().add(pirate2ImageView);

		// Load the pirate ships
		Image pirateImage = new Image("pirateShip.png", 50, 50, true, true);
		for (int i = 0; i < oceanMap.getPirates().length; i++) {
			pirateImageView[i] = new ImageView(pirateImage);
			pirateImageView[i].setX(oceanMap.getPirates()[i].x * scale);
			pirateImageView[i].setY(oceanMap.getPirates()[i].y * scale);
			root.getChildren().add(pirateImageView[i]);
		}
		// Load the island images
		Image islandImage = new Image("island.jpg", 50, 50, true, true);
		for (int i = 0; i < 20; i++) {
			islandImageView[i] = new ImageView(islandImage);
			islandImageView[i].setX(oceanMap.getIslands()[i].x * scale);
			islandImageView[i].setY(oceanMap.getIslands()[i].y * scale);
			root.getChildren().add(islandImageView[i]);
		}

	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
				for (int i = 0; i < oceanMap.getPirates().length; i++) {
					pirateImageView[i].setX(pirateShips.getShipLocation()[i].x * scale);
					pirateImageView[i].setY(pirateShips.getShipLocation()[i].y * scale);

				}
				sharkImageView.setX(shark.getLittleShark().x * scale);
				sharkImageView.setY(shark.getLittleShark().y * scale);
				
				monsterImageView.setX(monster.getMonster().x * scale);
				monsterImageView.setY(monster.getMonster().y * scale);

				pirate2ImageView.setX(doubleSpeed.getDoubleSS().x * scale);
				pirate2ImageView.setY(doubleSpeed.getDoubleSS().y * scale);
				if (GameOver == false) {
					gg();
				}
			}
		});
	}

	// Draw ocean and islands
	public void drawMap() {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (islandMap[x][y])
					rect.setFill(Color.GREEN);
				else
					rect.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rect);
			}
		}
	}

	public void gg() {
		if (oceanMap.checkL() == false) {
			LText = new Text(100, 500, "You Lost!");
			LText.setFont(Font.font("Verdana", 50));
			root.getChildren().add(LText);
			GameOver = true;

		} else if (oceanMap.checkW() == true) {
			WText = new Text(100, 500, "You Won!");
			WText.setFont(Font.font("Verdana", 50));
			root.getChildren().add(WText);
			GameOver = true;

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}