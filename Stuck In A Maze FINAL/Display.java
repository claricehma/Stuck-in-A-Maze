import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


/**
 * Example of one approach to continuous motion
 */
public class Display extends JPanel implements KeyListener 
{

    // initialize stuff
    ActionEvent e;
    ArrayList<WallCoodinates> wallCoordinatesVertical = new ArrayList<>();
    ArrayList<WallCoodinates> wallCoordinatesHorizontal = new ArrayList<>();
    String Path = ""; // R or D
    Color prevColor = new Color(19, 218, 185);
    Color finishLineColor = new Color(21, 138, 97);
    Color wallColor = new Color(13, 71, 11);
    int speed = 20; 
    int x = 233;
    int y = 103;
    int key = 0;
    int counter = 0;
    int plusNum = 0;
    int[][] walls = new int[20][20];
    boolean moving = true;
    int numSquaresAcross;
    int squaresAcross;
    GraphicsWindow o;
    Maze m;

    // CONSTRUCTOR: adds a keylistener and starts a timer that will automatically
    // update/refresh display
    public Display(int numSquaresAcross, GraphicsWindow owner, int level) {
        this.setPreferredSize(new Dimension(760, 760));
        addKeyListener(this); /** IMPORTANT */
        this.numSquaresAcross = numSquaresAcross;
        o = owner;

        // depending on level = the length of the total maze
        if(level == 1) {
            plusNum = 400;
        } else if(level == 2) {
            plusNum = 460;
        } 

        // actual squares across (not including the w x l of each square)
        squaresAcross = plusNum/20;

        // generate path
        int xPath = 0;
        int yPath = 0;
        while(xPath < x + plusNum || yPath < y + plusNum) {
            int randomDir = (int)(Math.random() * 2);

            if(randomDir == 0 && yPath < y + plusNum) {
                // goes down
                yPath += Math.sqrt(plusNum);
                Path += "D";
            } else {
                // goes right
                xPath += Math.sqrt(plusNum);
                Path += "R";
            }
        }


        // makes maze
        m = new Maze(Path, plusNum / 20);

        // put up walls
        walls = m.returnWalls();

    }
        
    /** THIS WHOLE SECTION IMPORTANT */
    // needed, but called internally by Java:
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    // clears the canvas, draws the circle:
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // clear canvas
        // makes the drawings cleaner:
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw finish line box
        int endCoordinateX = 210 + plusNum;
        int endCoordinateY = 80 + plusNum;
        g.setColor(finishLineColor);
        g.fillRect(endCoordinateX, endCoordinateY, 20, 20);

        // draw start line box
        int startCoordinateX = 230;
        int startCoordinateY = 100;
        g.setColor(Color.RED);
        g.fillRect(startCoordinateX, startCoordinateY, 20, 20);

        // only change maze every 4 shifts on the hard level
        if(counter % 4 == 0 && plusNum / 20 == 23) {
            m = new Maze(Path, plusNum / 20);
            walls = m.returnWalls();
            wallCoordinatesHorizontal.clear();
            wallCoordinatesVertical.clear();
        }

        // random changing wall color for hard maze
        int R = 240 + (int)(Math.random() * 16);
        int G = 240 + (int)(Math.random() * 16);
        int B = 240 + (int)(Math.random() * 16);

        //draw the grid lines:
        for(int col = 0; col < numSquaresAcross; col++) {
            for(int row = 0; row < numSquaresAcross; row++) {
                //set location of where to draw current rectangle
                int x =  (int)(20 * col) + 230;
                int y =  (int)(20 * row) + 100;
    
                g2.setStroke(new BasicStroke(2));

                if(plusNum / 20 == 23) { // only work for hard level
                    if(counter % 3 == 0) {
                        g.setColor(new Color(R, G, B));
                    } else {
                        g.setColor(new Color(230,255,229));
                    }
                } else {
                    g.setColor(wallColor);
                }

                // draws green walls if in 2D array is 1 or 2
                if(walls[col][row] == 1) {
                    g.drawLine(x, y, x + 20, y);
                    for(int i = 0; i <= 20; i++) {
                        wallCoordinatesHorizontal.add(new WallCoodinates(x + i, y));
                    }
                } else if(walls[col][row] == 2) {
                    g.drawLine(x, y, x, y + 20);
                    for(int i = 0; i <= 20; i++) {
                        wallCoordinatesVertical.add(new WallCoodinates(x, y + i));
                    }
                }

            }
        }
            

        // draw the grid border lines 
        int x1 = 230;
        int y1 = 100;
        if(plusNum / 20 != 23) {
            g.setColor(wallColor);
        } else {
            g.setColor(new Color(R, G, B));
        }
        g.drawLine(x1, y1, x1 + plusNum, y1);
        g.drawLine(x1, y1, x1, y1 + plusNum);
        g.drawLine(x1 + plusNum, y1 + plusNum, x1 + plusNum, y1);
        g.drawLine(x1 + plusNum, y1 + plusNum, x1, y1 + plusNum);
    
        
        g.setColor(prevColor);
        // draw circle (or oval if you width != height):
        g.fillOval(x, y, 15, 15);

        counter++;


        // exits game when player reaches finish box
        if(x >= 200 + plusNum && y >= 80 + plusNum) {
            o.dispose();
            startCelebration();
        }
    }

    // updates where the circle should be, then calls repaint
    public void update() {
        /**
         * THIS METHOD IS CALLED EVERY TIME THE TIMER FIRES
         * IF YOU'RE NOT USING A TIMER, JUST CALL THIS FROM KEYPRESSED!
         */
        // call any methods here that will update anything on the board that needs
        // updating
        squaresAcross = plusNum / 20;

        if (moving) {
            if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                boolean doesNotBump = true;
                // loop through to make sure that player does not bump into wall
                outerloop:
                for(int i = 0; i < wallCoordinatesHorizontal.size(); i++) {
                    WallCoodinates coordinateOfWall = wallCoordinatesHorizontal.get(i);
                    if(coordinateOfWall.X == x && coordinateOfWall.Y < y && coordinateOfWall.Y > y - squaresAcross) {
                        doesNotBump = false;
                        break outerloop;
                    }
                }


                if(doesNotBump) {
                    y -= speed; // W = up
                }

            } else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                boolean doesNotBump = true;
                // loop through to make sure that player does not bump into wall
                outerloop:
                for(int i = 0; i < wallCoordinatesHorizontal.size(); i++) {
                    WallCoodinates coordinateOfWall = wallCoordinatesHorizontal.get(i);
                    if(coordinateOfWall.X == x && coordinateOfWall.Y > y && coordinateOfWall.Y < y + squaresAcross) {
                        doesNotBump = false;
                        break outerloop;
                    }
                }

                if(doesNotBump) {
                    y += speed; // S = down
                }

            } else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                boolean doesNotBump = true;
                // loop through to make sure that player does not bump into wall
                outerloop:
                for(int i = 0; i < wallCoordinatesVertical.size(); i++) {
                    WallCoodinates coordinateOfWall = wallCoordinatesVertical.get(i);
                    if(coordinateOfWall.X < x && coordinateOfWall.X > x - squaresAcross && coordinateOfWall.Y == y) {
                        doesNotBump = false;
                        break outerloop;
                    }
                }

                if(doesNotBump) {
                    x -= speed; // A = left
                }
            }
            else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                boolean doesNotBump = true;
                // loop through to make sure that player does not bump into wall
                outerloop:
                for(int i = 0; i < wallCoordinatesVertical.size(); i++) {
                    WallCoodinates coordinateOfWall = wallCoordinatesVertical.get(i);
                    if(coordinateOfWall.X > x && coordinateOfWall.X < x + squaresAcross && coordinateOfWall.Y == y) {
                        doesNotBump = false;
                        break outerloop;
                    }
                }
                
                if(doesNotBump) {
                    x += speed; // D = right
                }

            }

            // set boundaries
            if(x > 233 + (squaresAcross - 1) * 20)x = 233 + (squaresAcross - 1) * 20;
            if(x < 233) x = 233;
            if(y > 103 + (squaresAcross - 1) * 20) y = 103 + (squaresAcross - 1) * 20;
            if(y < 103) y = 103;
            // if none of these keys, then neither x nor y change - no motion
            repaint(); // now paint the updated objects on the JPanel
        }

    }

    /** THIS WHOLE SECTION IMPORTANT */
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode(); // get the latest key that was pressed
        moving = true;
        update();
    }

    public void keyReleased(KeyEvent e) {
        moving = false;
        update();
    }
    public void keyTyped(KeyEvent e){}


    /***
     * start the celebration after finish maze!
     */
    public void startCelebration() {
        Color backgroundColor = new Color(230,255,229);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 20); // or Font.PLAIN
        UIManager.put("OptionPane.messageFont", font); // message color
        UIManager.put("OptionPane.buttonFont", font); // button color
        UIManager.put("OptionPane.messageForeground", Color.BLACK); // text COLOR
        UIManager.put("Panel.background", backgroundColor);
        

        ImageIcon yay = new ImageIcon(Display.class.getResource(
                        "Yay!!!!.gif"));

        JOptionPane.showMessageDialog(null,
                "CONGRATULATIONS, YOU WIN!!!",
                "CONGRATS!!!!!",
                JOptionPane.WARNING_MESSAGE,
                yay);

        Runner r = new Runner();
        r.secondTime();

        
    
    }

}
