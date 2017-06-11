package Windows;

import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Pawns.Board;
import Pawns.Player;
import Resources.IString;

public class MainWindow extends JFrame {
	public static int FPS = 30;
	boolean running = true;
	Board theBoard;
    public MainWindow() {
    	theBoard = new Board(new Player("Damien"), new Player("Tap"), IString.level_vs,this);
        initUI();
    }
    
    private void initUI() 
    {
        add(theBoard);
        setTitle("Mak Dam");
        setSize(300, 300);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow frame = this;
        this.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Are you sure to close this window?", "Really Closing?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    running = false;
                	System.exit(0);
                }
            }
        }); 
    }
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                MainWindow ex = new MainWindow();
                ex.setVisible(true);
          
            }
        });
    }
}