package Kamisado;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static Kamisado.Tile.red;
import static Kamisado.Tile.orange;
import static Kamisado.Tile.blue;
import static Kamisado.Tile.turqoise;
import static Kamisado.Tile.yellow;
import static Kamisado.Tile.pink;
import static Kamisado.Tile.brown;
import static Kamisado.Tile.green;
import static Kamisado.Main.Tile_Size;
public class Piece extends StackPane 
{

	private PieceType type;

	private double mouseX, mouseY;
	private double oldX, oldY;

	public PieceType getType() 
	{
		return type;
	}

	public double getOldX() 
	{
		return oldX;
	}

	public double getOldY() 
	{
		return oldY;
	}

	public Piece(PieceType type, int x, int y) 
	{
		this.type = type;
		//String theType = type.toString();
		char c = Character.valueOf(type.toString().charAt(0));

		move(x, y);

		Ellipse bg = new Ellipse(Tile_Size * 0.3125, Tile_Size * 0.26);
		bg.setFill(Color.BLACK);

		bg.setStroke(Color.BLACK);
		bg.setStrokeWidth(Tile_Size * 0.03);

		bg.setTranslateX((Tile_Size - Tile_Size * 0.3125 * 2) / 2);
		bg.setTranslateY((Tile_Size - Tile_Size * 0.26 * 2) / 2 + Tile_Size * 0.07);

		Ellipse ellipse = new Ellipse(Tile_Size * 0.3125, Tile_Size * 0.26);

		ellipse.setFill(c == 'W' ? Color.valueOf("#ffffff") : Color.valueOf("#000000"));

		ellipse.setStroke(Color.SILVER);
		ellipse.setStrokeWidth(Tile_Size * 0.03);

		ellipse.setTranslateX((Tile_Size - Tile_Size * 0.3125 * 2) / 2);
		ellipse.setTranslateY((Tile_Size - Tile_Size * 0.26 * 2) / 2);

		Ellipse pieceColour = new Ellipse(Tile_Size * 0.15, Tile_Size * 0.15);
		switch (type) {
		case Black9Orange: case White9Orange: 	pieceColour.setFill(Color.valueOf(orange));
			break;
		case Black0Blue: case White0Blue:			pieceColour.setFill(Color.valueOf(blue));
			break;
		case BlackcTurqoise:	case WhitecTurqoise:	pieceColour.setFill(Color.valueOf(turqoise));
			break;
		case Black6Pink:	case White6Pink:			pieceColour.setFill(Color.valueOf(pink));
			break;
		case BlackfYellow:	case WhitefYellow:	pieceColour.setFill(Color.valueOf(yellow));
			break;
		case Black1Red:	case White1Red:			pieceColour.setFill(Color.valueOf(red));
			break;
		case Black8Green:	case White8Green:	pieceColour.setFill(Color.valueOf(green));
			break;
		case Black4Brown:	case White4Brown:	pieceColour.setFill(Color.valueOf(brown));
			break;
		}

		pieceColour.setStroke(Color.SILVER);
		pieceColour.setStrokeWidth(Tile_Size * 0.03);

		pieceColour.setTranslateX((Tile_Size - Tile_Size * 0.3125 * 2) / 2);
		pieceColour.setTranslateY((Tile_Size - Tile_Size * 0.26 * 2) / 2);

		getChildren().addAll(bg, ellipse, pieceColour);

		setOnMousePressed(e -> 
		{
			mouseX = e.getSceneX();
			mouseY = e.getSceneY();
		});

		setOnMouseDragged(e -> 
		{
			relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
		});
	}
	
	public void move(int x, int y) 
	{
		oldX = x * Tile_Size;
		oldY = y * Tile_Size;
		relocate(oldX, oldY);
	}

	public void abortMove() 
	{
		relocate(oldX, oldY);
	}

}
