package Pawns;

import Resources.IInt;
import Resources.IString;

public class Case {
	private Pawn myPawn;
	private String myColor;
	private int r;
	private int g;
	private int b;
	public Case(String aColor)
	{
		this.myColor = aColor;
	}
	
	public String getColor()
	{
		return this.myColor;
	}
	public void setColor(String aColor)
	{
		myColor = aColor;
	}
	public void reinitRGB()
	{
		if(myColor.equals(IString.black))
		{
			this.r=IInt.black_r;
			this.g=IInt.black_g;
			this.b=IInt.black_b;
		}
		else
		{
			this.r=IInt.white_r;
			this.g=IInt.white_g;
			this.b=IInt.white_b;
		}
	}
	public void setRGB(int ar, int ag, int ab)
	{
		this.r = ar;
		this.g = ag;
		this.b = ab;
	}
	public int[] getRGB()
	{
		int result[] = {this.r,this.g,this.b};
		return result;
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
