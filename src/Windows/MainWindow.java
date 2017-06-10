package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Pawns.Board;
import Pawns.Player;
import Resources.IString;

public class MainWindow extends JFrame {

    public MainWindow() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Board(new Player(), new Player(), IString.level_vs));
        
        setTitle("Mak Dam");
        setSize(Board.SQUARE_SIZE*(Board.WIDTH+2), Board.SQUARE_SIZE*(Board.HEIGHT+1));
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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