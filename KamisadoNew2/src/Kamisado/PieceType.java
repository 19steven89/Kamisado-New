package Kamisado;

public enum PieceType 
{
	Black1Red(2), Black0Blue(1), Black8Green(1), Black9Orange(1), BlackcTurqoise(1), BlackfYellow(1), Black4Brown(1), Black6Pink(1),
	White1Red(-1), White0Blue(-1), White8Green(-1), White9Orange(-1), WhitecTurqoise(-1), WhitefYellow(-1), White4Brown(-1), White6Pink(-1);

	final int moveDir;

	PieceType(int moveDir) 
	{
		this.moveDir = moveDir;
	}

}
