package Pawns;

public class Case {
	private Pawn myPawn;
	private String myColor;
	
	public Case(String aColor)
	{
		this.myColor = aColor;
	}
	
	public String getColor()
	{
		return this.myColor;
	}
	
	public void setPawn(Pawn aPawn)
	{
		this.myPawn = aPawn;
	}
	public Pawn getPawn()
	{
		return this.myPawn;
	}
}
