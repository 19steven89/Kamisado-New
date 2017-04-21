package Kamisado;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class AIMain 
{

	//Dimentions for tiles
	public static final int Tile_Size = 100;
	public static final int Width = 8;
	public static final int Height = 8;

	private Tile[][] board = new Tile[Width][Height];

	
	static char c = 'E';
	char n = 'E';
	Paint cOld;
	Piece kPiece = null;
	int keyX = 0, keyY = 0, keyOldX = 0, keyOldY = 0;

	//Groups for tiles and pieces
	private Group tileGroup = new Group();
	private Group pieceGroup = new Group();

	//Create content
	private Parent createContent() 
	{
		Pane root = new Pane();
		root.setPrefSize(Width * Tile_Size,  Height * Tile_Size);
		root.getChildren().addAll(tileGroup, pieceGroup);
		int tileNumber = 0;

		for (int y = 0; y < Height; y++) 
		{
			for (int x = 0; x < Width; x++) 
			{
				Tile tile = new Tile(tileNumber, x, y);
				board[x][y] = tile;

				tileGroup.getChildren().add(tile);

				Piece piece = null;
				switch (tileNumber) 
				{
					case 0:		piece = makePiece(PieceType.Black9Orange, x, y);
						break;
					case 1:		piece = makePiece(PieceType.Black0Blue, x, y);
						break;
					case 2:		piece = makePiece(PieceType.BlackcTurqoise, x, y);
						break;
					case 3:		piece = makePiece(PieceType.Black6Pink, x, y);
						break;
					case 4:		piece = makePiece(PieceType.BlackfYellow, x, y);
						break;
					case 5:		piece = makePiece(PieceType.Black1Red, x, y);
						break;
					case 6:		piece = makePiece(PieceType.Black8Green, x, y);
						break;
					case 7:		piece = makePiece(PieceType.Black4Brown, x, y);
						break;
					case 63: 	piece = makePiece(PieceType.White9Orange, x, y);
						break;
					case 62:	piece = makePiece(PieceType.White0Blue, x, y);
						break;
					case 61:	piece = makePiece(PieceType.WhitecTurqoise, x, y);
						break;
					case 60:	piece = makePiece(PieceType.White6Pink, x, y);
						break;
					case 59:	piece = makePiece(PieceType.WhitefYellow, x, y);
						break;
					case 58:	piece = makePiece(PieceType.White1Red, x, y);
						break;
					case 57:	piece = makePiece(PieceType.White8Green, x, y);
						break;
					case 56:	piece = makePiece(PieceType.White4Brown, x, y);
					break;
				}
				
				tileNumber++;
				if (piece != null) 
				{
					tile.setPiece(piece);
					pieceGroup.getChildren().add(piece);
				}
			}
		}

		return root;
	}

	private MoveResult tryMove(Piece piece, int newX, int newY) 
	{
		if (board[newX][newY].hasPiece()) 
		{
			return new MoveResult(MoveType.NONE);
		}

		//Old coordinates
		int x0 = toBoard(piece.getOldX());
		int y0 = toBoard(piece.getOldY());
		if (board[newX][newY].hasPiece() == false)
		{
			if (Math.abs(newX - x0) == 1 && newY - y0 == piece.getType().moveDir || newY - y0 == piece.getType().moveDir && Math.abs(newX - x0) == 0) 
			{
				return new MoveResult(MoveType.NORMAL);
			}
			if (Math.abs(newX - x0) == 2 && newY - y0 == piece.getType().moveDir * 2 || newY - y0 == piece.getType().moveDir * 2 && Math.abs(newX - x0) == 0) 
			{
				return new MoveResult(MoveType.NORMAL);
			}
			if (Math.abs(newX - x0) == 3 && newY - y0 == piece.getType().moveDir * 3 || newY - y0 == piece.getType().moveDir * 3 && Math.abs(newX - x0) == 0) 
			{
				return new MoveResult(MoveType.NORMAL);
			}
			if (Math.abs(newX - x0) == 4 && newY - y0 == piece.getType().moveDir * 4 || newY - y0 == piece.getType().moveDir * 4 && Math.abs(newX - x0) == 0) 
			{
				return new MoveResult(MoveType.NORMAL);
			}
			if (Math.abs(newX - x0) == 5 && newY - y0 == piece.getType().moveDir * 5 || newY - y0 == piece.getType().moveDir * 5 && Math.abs(newX - x0) == 0) 
			{
				return new MoveResult(MoveType.NORMAL);
			}
			if (Math.abs(newX - x0) == 6 && newY - y0 == piece.getType().moveDir * 6 || newY - y0 == piece.getType().moveDir * 6 && Math.abs(newX - x0) == 0) 
			{
				return new MoveResult(MoveType.NORMAL);
			}
			if (Math.abs(newX - x0) == 7 && newY - y0 == piece.getType().moveDir * 7 || newY - y0 == piece.getType().moveDir * 7 && Math.abs(newX - x0) == 0) 
			{
				return new MoveResult(MoveType.NORMAL);
			}
		}

		return new MoveResult(MoveType.NONE);
	}
	
	
//	public int validateAIMove()
//	{
//		
//		MoveResult beginPos = new MoveResult(MoveType.NORMAL);
//		
//		for(int row = 0; row < Height; row ++)
//		{
//			for(int column = 0; column < Height; column ++)
//			{
//				if(board[keyX][keyY].getPiece()!= null)
//				{
//					beginPos. = column;
//				}
//			}
//			
//		}
//		
//		
//	}
//	
//	
//	private MoveResult AIMoveUp()
//	{
//		
//		MoveResult endPoint = new MoveResult() 
//		
//		return new MoveResult(MoveType.NONE);		
//		
//	}
	
	

	//Convert from pixel cords and centre's piece
	private int toBoard(double pixel) 
	{
		return (int)(pixel + Tile_Size / 2) / Tile_Size;
	}
	
	
	public static void playerColourDecider(String pyr1Txt, String pyr2Txt)
	{
	
		Alert whitePlayer = new Alert(AlertType.INFORMATION);
		whitePlayer.setHeaderText("Colour Decider");
		whitePlayer.setTitle("White Player");
		int rand = (int) ( Math.random() * 2 + 1);
		
		//choose white piece player depending on random value in rand variable
		if(rand == 1)
		{
			whitePlayer.setContentText(pyr1Txt + " is the white player!");
		}
		else 
		{
			whitePlayer.setContentText(pyr2Txt + " is the white player!");
		}
		whitePlayer.showAndWait();
	}
		
	
	public void startScene(Stage primaryStage, String pyr1Txt, String pyr2Txt)
	{
		Scene scene = new Scene(createContent());
		primaryStage.setTitle(pyr1Txt + " Versus " + pyr2Txt);
		primaryStage.setScene(scene);
		primaryStage.show();		
		
		playerColourDecider(pyr1Txt, pyr2Txt);
		
		Feedback.quitGame();
		
		
		board[keyOldX][keyOldY].setOpacity(0);
		scene.setOnKeyPressed(e -> 
		{
			if(kPiece != null)
			{
				board[keyOldX][keyOldY].setOpacity(0);
			}
            	if (e.getCode() == KeyCode.UP)
            	{
            		if(keyY > 0)
            		{
            			board[keyX][keyY].setOpacity(1);
            			keyY--;
            			board[keyX][keyY].setOpacity(0);
            		}
            	}
            	if (e.getCode() == KeyCode.DOWN)
            	{
            		if(keyY < 7)
            		{
            			board[keyX][keyY].setOpacity(1);
            			keyY++;
            			board[keyX][keyY].setOpacity(0);
            		}
            	}
            	if (e.getCode() == KeyCode.LEFT)
            	{
            		if(keyX > 0)
            		{
            			board[keyX][keyY].setOpacity(1);
            			keyX--;
            			board[keyX][keyY].setOpacity(0);
            		}
            	}
            	if (e.getCode() == KeyCode.RIGHT)
            	{
            		if(keyX < 7)
            		{
            			board[keyX][keyY].setOpacity(1);
            			keyX++;
            			board[keyX][keyY].setOpacity(0);
            		}
            	}
            	
            	if (e.getCode() == KeyCode.SHIFT) 
            	{
                	if (board[keyX][keyY].hasPiece() == true && kPiece == null)
                	{
                		if(c != Character.valueOf(board[keyX][keyY].getPiece().getType().toString().charAt(0)))
                		{
                			if(n == 'E' || n == Character.valueOf(board[keyX][keyY].getPiece().getType().toString().charAt(5)))
                			{
            					kPiece = board[keyX][keyY].getPiece();
            					c = Character.valueOf(kPiece.getType().toString().charAt(0));
            					keyOldX = keyX;
            					keyOldY = keyY;
            					board[keyX][keyY].setOpacity(0);
                			}
                			else
                				Feedback.wrongColourPiece();
                		}
                		else
                			Feedback.wrongPlayer();
                	}
                	else if (board[keyX][keyY].hasPiece() == false && kPiece != null)
                	{
                		int x = Math.abs(keyOldX - keyX);
            			int y = Math.abs(keyOldY - keyY);
                		if(c == 'W' && keyY < keyOldY )
                		{
            				while(x > 0)
            				{
            					if(keyX > keyOldX)
            					{
            						if(board[keyOldX+x][keyOldY-x].hasPiece() == true)
            						{
	        							Feedback.illegalMove();
	        							break;
            						}
            					}
            					if(keyX < keyOldX)
            					{
            						if(board[keyOldX-x][keyOldY-x].hasPiece() == true)
        							{
	        							Feedback.illegalMove();
	        							break;
            						}
            					}
            					x--;
            					y--;
            				}
            				while(y > 0 && Math.abs(keyOldX - keyX) == 0)
            				{
            					if(board[keyOldX][keyOldY-y].hasPiece() == true)
            					{
        							Feedback.illegalMove();
        							break;
    							}
            					y--;
            				}
                		}
                		else if(c == 'B' && keyY > keyOldY )
                		{
            				while(x > 0)
            				{
            					if(keyX > keyOldX)
            					{
            						if(board[keyOldX+x][keyOldY+x].hasPiece() == true)
            						{
	        							Feedback.illegalMove();
	        							break;
            						}
            					}
            					if(keyX < keyOldX)
            					{
            						if(board[keyOldX-x][keyOldY+x].hasPiece() == true)
            						{
	        							Feedback.illegalMove();
	        							break;
            						}
            					}
            					x--;
            					y--;
            				}
            				while(y > 0 && Math.abs(keyOldX - keyX) == 0)
            				{
            					if(board[keyOldX][keyOldY+y].hasPiece() == true)
            					{
        							Feedback.illegalMove();
        							break;
    							}
            					y--;
            				}
                		}
                		else
                		{
                			Feedback.illegalMove();
                		}
                		if(x == 0 && y == 0)
                		{

                			kPiece.move(keyX, keyY);
                			board[keyOldX][keyOldY].setPiece(null);
                			board[keyX][keyY].setPiece(kPiece);
                			board[keyOldX][keyOldY].setOpacity(1);
                			kPiece = null;
                			n = Character.valueOf(board[keyX][keyY].getFill().toString().charAt(4));
                			if(c == 'W' && keyY == 0 || c == 'B' && keyY == 7)
                			{
                				Feedback.gameWon();
                			}
            			 }
            		}
            	}
            	if (e.getCode() == KeyCode.ESCAPE || e.getCode() == KeyCode.Q)
            	{
            		Platform.exit();
            	}
        	});
	
	}
	
	private Piece makePiece(PieceType type, int x, int y) 
	{
		Piece piece = new Piece(type, x, y);
		piece.setOnMouseReleased(e -> 
		{
			int newX = toBoard(piece.getLayoutX());
			int newY = toBoard(piece.getLayoutY());
			MoveResult result = tryMove(piece, newX, newY);

			int x0 = toBoard(piece.getOldX());
			int y0 = toBoard(piece.getOldY());

			switch (result.getType()) {
			case NONE:
				piece.abortMove();
				break;
			case NORMAL:
				if(c == Character.valueOf(type.toString().charAt(0)))
				{
					piece.abortMove();
					break;
				}
				cOld = board[x0][y0].getFill();
				if(n == 'E' || n == Character.valueOf(type.toString().charAt(5)))
				{
					n = Character.valueOf(board[newX][newY].getFill().toString().charAt(4));
					c = Character.valueOf(type.toString().charAt(0));
					piece.move(newX, newY);
					board[x0][y0].setPiece(null);
					board[newX][newY].setPiece(piece);
					if(c == 'W' && newY == 0 ||c == 'B' && newY == 7 )
					{
						Feedback.gameWon();
						
					}
					break;
				}
				else 
				{
					piece.abortMove();
					break;
				}
			case KILL:
				piece.move(newX, newY);
				board[x0][y0].setPiece(null);
				board[newX][newY].setPiece(piece);

				break;
			}
		});

		return piece;
	}

}
