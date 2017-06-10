package Pawns;

public class Pawn {
	private String myColor;
	private Case myCase;
	private Player myPlayer;
	
	
	public Pawn(String aColor, Case aCase, Player aPlayer)
	{
		this.myColor = aColor;
		this.myCase = aCase;
		this.myPlayer = aPlayer;
	}
	
	public void setColor(String aColor)
	{
		this.myColor = aColor;
	}
	public String getColor()
	{
		return this.myColor;
	}
	public Case getCase()
	{
		return this.myCase;
	}
	public void setCase(Case aCase)
	{
		this.myCase = aCase;
	}
	public Player getPlayer()
	{
		return this.myPlayer;
	}
	public void setPlayer(Player aPlayer)
	{
		this.myPlayer = aPlayer;
	}
}
