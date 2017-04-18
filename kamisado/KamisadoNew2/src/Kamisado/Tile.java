package Kamisado;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle  {

	private Piece piece;
	private String colour;
	
	public String getColour(){
		return colour;
	}
	
	public boolean hasPiece() {
		return piece != null;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	//Colours for tiles
	public static String red = "#ff1100";
	public static String blue = "#0000ff";
	public static String green = "#008800";
	public static String orange = "#ff9933";
	public static String turqoise = "#00cccc";
	public static String yellow = "#ffff00";
	public static String brown = "#994c00";
	public static String pink = "#ff66ff";
	public static String tileColor;

	public Tile(int n, int x, int y) {
		setWidth(Main.Tile_Size);
		setHeight(Main.Tile_Size);

		relocate(x * Main.Tile_Size, y * Main.Tile_Size);

		switch (n) {
		case 0:	case 9: case 18: case 27: case 36: case 45: case 54: case 63: setFill(Color.valueOf(orange));
			break;
		case 1:	case 12: case 23: case 26: case 37: case 40: case 51: case 62:	setFill(Color.valueOf(blue));
			break;
		case 2:	case 15: case 20: case 25: case 38: case 43: case 48: case 61:	setFill(Color.valueOf(turqoise));
			break;
		case 3:	case 10: case 17: case 24: case 39: case 46: case 53: case 60:	setFill(Color.valueOf(pink));
			break;
		case 4:	case 13: case 22: case 31: case 32: case 41: case 50: case 59:	setFill(Color.valueOf(yellow));
			break;
		case 5:	case 8: case 19: case 30: case 33: case 44: case 55: case 58:	setFill(Color.valueOf(red));
			break;
		case 6:	case 11: case 16: case 29: case 34: case 47: case 52: case 57:	setFill(Color.valueOf(green));
			break;
		case 7:	case 14: case 21: case 28: case 35: case 42: case 49: case 56:	setFill(Color.valueOf(brown));
			break;
		}
	}
}
