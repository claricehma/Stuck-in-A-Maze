import java.awt.*;
import javax.swing.*;

/**
 * Provides a window for buttons, entry boxes and canvasing of grahpics 1. Sets
 * up all imporant control variable values, 2. makes a Window for buttons and
 * graphics and timer control 3. and makes a canvas to show graphics 4. starts
 * the timer to start animation
 * 
 * @author Beckwith, edited by Clarice
 * @version 1.2.0
 */
public class GraphicsWindow extends JFrame {
    Timer t;
    String boxText = "";
    boolean moving = true;
    // components and objects:
    //JButton button;
    JPanel topPanel, canvasPanel;
    JTextField info;
    Canvas canvas;

    // size of window:
    int WIDTH;
    int HEIGHT;

    int numSquaresAcross;
    int middleX, middleY;
    int squareSize;

    /**
     * Constructor for Window
     */
    public GraphicsWindow(int level) {
        // calls constructor of the "super class"- JFrame - arg is titlebar name
        
        super("Stuck In A Maze");
        

        // the JFrame/Graphics Window size:
        WIDTH = 950;
        HEIGHT = 700;
        canvas = new Canvas();
        /******** NUMBERS YOU MIGHT CHANGE: **********/
        // will establish size of each square

        // depending on level, square size will change
        if(level == 1) {
            numSquaresAcross = 20; 
        } else if(level == 2) {
            numSquaresAcross = 23;
        } 


        /*********************************************/

        

        // allows you to place things where you want them (see this.add() below)
        this.setLayout(new BorderLayout());

        // make a button for possible future use:
        //button = new JButton("button name");
        //button.setActionCommand("button");

        // panel to buttons and textfields in:
        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        //topPanel.add(button);


        // add the canvas to this JFrame:
        this.add(topPanel, BorderLayout.NORTH);
        Display display = new Display(numSquaresAcross, this, level); // the JPanel with paintComponent
        this.add(display, BorderLayout.CENTER);


        // final setup
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }


  
}
