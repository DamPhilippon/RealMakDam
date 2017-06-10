package Pawns;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import Resources.IInt;
import Resources.IString;

public class Board extends JPanel{
	public static int WIDTH=10;
	public static int HEIGHT=10;
	public static int SQUARE_SIZE = IInt.SQUARE_SIZE;
	public static int PAWN_SIZE = IInt.PAWN_SIZE;
	public static int PAWNS_NUMBER_WHITE = 20;
	public static int PAWNS_NUMBER_BLACK = 20;
	
	Player whitePlayer;
	Player blackPlayer;
	ArrayList<Pawn> whitePawns = new ArrayList<Pawn>();
	ArrayList<Pawn> blackPawns = new ArrayList<Pawn>();
	
	HashMap<Integer, HashMap<Integer, Case> > myCases = new HashMap<Integer,HashMap<Integer,Case>>();
	
	boolean vsIA = true;
	String levelIA = null;
	
	public Board(Player one, Player two, String level)
	{
		this.whitePlayer = one;
		this.blackPlayer = two;
		
		for (int i = 0; i<WIDTH; i++)
		{
			HashMap<Integer,Case> tempMap = new HashMap<Integer,Case>();
			for (int j = 0; j<HEIGHT ; j++)
			{
				Case aCase;
				if((i+j) % 2 ==0)
				{
					aCase = new Case(IString.white);
				}
				else
				{
					aCase = new Case(IString.black);
				}
				tempMap.put(j,aCase);
			}
			myCases.put(i, tempMap);
		}
		int index_width=-1;
		int index_height=0;
		for (int i = 0; i < PAWNS_NUMBER_WHITE; i++)
		{
			index_width = index_width+2;
			if(index_width >= WIDTH)
			{
				index_width = index_width - (WIDTH+1);
				if(index_width<0)
				{
					index_width = index_width+2;
				}
				index_height = index_height + 1;
			}
			Pawn aPawn = new Pawn(IString.white,myCases.get(index_width).get(index_height), this.whitePlayer);
			whitePawns.add(aPawn);
			myCases.get(index_width).get(index_height).setPawn(aPawn);
		}
		index_width = -2;
		index_height = HEIGHT-1;
		for (int i = 0; i < PAWNS_NUMBER_BLACK; i++)
		{
			index_width = index_width+2;
			if(index_width >= WIDTH)
			{
				index_width = index_width - (WIDTH+1);
				if(index_width<0)
				{
					index_width = index_width+2;
				}
				index_height = index_height - 1;
			}
			Pawn aPawn = new Pawn(IString.black,myCases.get(index_width).get(index_height), this.blackPlayer);
			blackPawns.add(aPawn);
			myCases.get(index_width).get(index_height).setPawn(aPawn);
		}
		if(level.equals(IString.level_vs))
		{
			this.vsIA = false;
		}
		else
		{
			this.levelIA = level;
		}
	}
	
	public Player getWhitePlayer()
	{
		return this.whitePlayer;
	}
	public Player getBlackPlayer()
	{
		return this.blackPlayer;
	}
	public void setWhitePlayer(Player aPlayer)
	{
		this.whitePlayer = aPlayer;
	}
	public void setBlackPlayer(Player aPlayer)
	{
		this.blackPlayer = aPlayer;
	}
	public boolean getVsIA()
	{
		return this.vsIA;
	}
	public void setVsIA(boolean aIA)
	{
		this.vsIA = aIA;
	}
	public String getLevelIA()
	{
		return this.levelIA;
	}
	public void setLevelIA(String aLevel)
	{
		this.levelIA = aLevel;
	}
	private void doDrawing(Graphics g) 
	{

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(new Color(150, 150, 150));

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        int x = 0;
        for(int i =0; i<WIDTH;i++)
        {
        	x = x + SQUARE_SIZE;
        	for(int j =0; j<HEIGHT;j++)
            {
        		Case theCase = this.myCases.get(i).get(j);
        		if(theCase.getColor().equals(IString.white))
				{
            		g2d.setColor(new Color(255, 0, 0));
				}
				else
				{
	        		g2d.setColor(new Color(0, 0, 0));
				}
        		g2d.fillRect(x, j*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
        		
        		if(theCase.getPawn()!=null)
        		{
        			if(theCase.getPawn().getColor().equals(IString.black))
        			{
    	        		g2d.setColor(new Color(IInt.black_r, IInt.black_g, IInt.black_b));
            			g2d.fillOval(x+((SQUARE_SIZE-PAWN_SIZE)/2), j*SQUARE_SIZE +((SQUARE_SIZE-PAWN_SIZE)/2), PAWN_SIZE-2, PAWN_SIZE-2);
    	        		g2d.setColor(new Color(IInt.black_cr, IInt.black_cg, IInt.black_cb));
            			g2d.draw(new Ellipse2D.Double(x+((SQUARE_SIZE-PAWN_SIZE)/2), j*SQUARE_SIZE +((SQUARE_SIZE-PAWN_SIZE)/2), PAWN_SIZE, PAWN_SIZE));
        			}
        			else
        			{
    	        		g2d.setColor(new Color(IInt.white_r, IInt.white_g, IInt.white_b));
            			g2d.fillOval(x+((SQUARE_SIZE-PAWN_SIZE)/2), j*SQUARE_SIZE+1 +((SQUARE_SIZE-PAWN_SIZE)/2), PAWN_SIZE-2, PAWN_SIZE-2);
    	        		g2d.setColor(new Color(IInt.white_cr, IInt.white_cg, IInt.white_cb));
            			g2d.draw(new Ellipse2D.Double(x+((SQUARE_SIZE-PAWN_SIZE)/2), j*SQUARE_SIZE +((SQUARE_SIZE-PAWN_SIZE)/2), PAWN_SIZE, PAWN_SIZE));
        			}
        		}
            }
        }
        
   } 

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }    
}
