import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;

public class Runner {
    public static void main(String[] args) throws Exception {

        Color backgroundColor = new Color(230,255,229);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 20); // or Font.PLAIN
        UIManager.put("OptionPane.messageFont", font); // message color
        UIManager.put("OptionPane.buttonFont", font); // button color
        UIManager.put("OptionPane.messageForeground", Color.black); // text COLOR
        UIManager.put("Panel.background", backgroundColor);

        String welcome = "Welcome to Stuck In A Maze! Click on either a level or the instructions.";

        ImageIcon image = new ImageIcon(Runner.class.getResource(
                "Logo.png"));

        String[] options = {"Hard", "Easy", "Instructions"};

        int choice = JOptionPane.showOptionDialog(null,
                welcome,
                "Stuck In A Maze: MENU",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                image,
                options,
                options[0]);


        boolean pickedEasy = false;
        boolean pickedHard = false;
        boolean pickedInstructions = false;

        switch (choice) {
            
                case 0: {
                        pickedHard = true;
                        break;
                } 

                case 1: {
                        pickedEasy = true;
                        break;
                } case 2: {
                        pickedInstructions = true;
                        break;
                }
        }


        if(pickedEasy) {
                easyWelcome();
                GraphicsWindow start  = new GraphicsWindow(1);

        } else if(pickedHard) {
                hardWelcome();
                GraphicsWindow start  = new GraphicsWindow(2);
        }  else if(pickedInstructions) {
                instructions();
        }
    }


    public void secondTime() {
        Color backgroundColor = new Color(230,255,229);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 20); // or Font.PLAIN
        UIManager.put("OptionPane.messageFont", font); // message color
        UIManager.put("OptionPane.buttonFont", font); // button color
        UIManager.put("OptionPane.messageForeground", Color.black); // text COLOR
        UIManager.put("Panel.background", backgroundColor);

        String welcome = "Welcome to Stuck In A Maze! Please click on which level you want to play.";

        ImageIcon image = new ImageIcon(Runner.class.getResource(
                "Logo.png"));

        String[] options = {"Hard", "Easy", "Instructions"};

        int choice = JOptionPane.showOptionDialog(null,
                welcome,
                "Stuck In A Maze: MENU",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                image,
                options,
                options[0]);

        boolean pickedEasy = false;
        boolean pickedHard = false;
        boolean pickedInstructions = false;

        switch (choice) {
            
                case 0: {
                        pickedHard = true;
                        break;
                }

                case 1: {
                        pickedEasy = true;
                        break;
                }

                case 2: {
                        pickedInstructions = true;
                        break;
                }
        }

        if(pickedEasy) {
                easyWelcome();
                GraphicsWindow start = new GraphicsWindow(1);
        } else if(pickedHard) {
                hardWelcome();
                GraphicsWindow start = new GraphicsWindow(2);
        } else if(pickedInstructions) {
                instructions();
        }
    }

    public static void easyWelcome() {
        Color backgroundColor = new Color(230,255,229);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 20); // or Font.PLAIN
        UIManager.put("OptionPane.messageFont", font); // message color
        UIManager.put("OptionPane.buttonFont", font); // button color
        UIManager.put("OptionPane.messageForeground", Color.BLACK); // text COLOR
        UIManager.put("Panel.background", backgroundColor);
        

        // all instruction images
        ImageIcon step1 = new ImageIcon(Display.class.getResource(
                        "easystep1.png"));
        ImageIcon step2 = new ImageIcon(Display.class.getResource(
                "easystep2.png"));
        ImageIcon step3 = new ImageIcon(Display.class.getResource(
        "easystep3.png"));


        // show step 1
        JOptionPane.showMessageDialog(null,
                null,
                "Step 1",
                JOptionPane.WARNING_MESSAGE,
                step1);

        // show step 2
        JOptionPane.showMessageDialog(null,
        null,
        "Step 2",
        JOptionPane.WARNING_MESSAGE,
        step2);

        // show step 3
        JOptionPane.showMessageDialog(null,
        null,
        "Step 3",
        JOptionPane.WARNING_MESSAGE,
        step3);
    }

    public static void hardWelcome() {

        // all instruction images
        ImageIcon step1 = new ImageIcon(Display.class.getResource(
                        "hardstep1.png"));
        ImageIcon step2 = new ImageIcon(Display.class.getResource(
        "hardstep2.png"));
        ImageIcon step3 = new ImageIcon(Display.class.getResource(
        "hardstep3.gif"));
        ImageIcon step4 = new ImageIcon(Display.class.getResource(
        "hardstep4.png"));
        ImageIcon step5 = new ImageIcon(Display.class.getResource(
        "hardstep5.png"));
        ImageIcon step6 = new ImageIcon(Display.class.getResource(
        "hardstep6.png"));
        ImageIcon step7= new ImageIcon(Display.class.getResource(
        "hardstep7.png"));

        // show step 1
        JOptionPane.showMessageDialog(null,
                null,
                "Step 1",
                JOptionPane.WARNING_MESSAGE,
                step1);

        // show step2
        JOptionPane.showMessageDialog(null,
        null,
        "Step 2",
        JOptionPane.WARNING_MESSAGE,
        step2);

        // show step3
        JOptionPane.showMessageDialog(null,
                null,
                "Step 3",
                JOptionPane.WARNING_MESSAGE,
                step3);

        // show step4
        JOptionPane.showMessageDialog(null,
        null,
        "Step 4",
        JOptionPane.WARNING_MESSAGE,
        step4);

        // show step5
        JOptionPane.showMessageDialog(null,
                null,
                "Step 5",
                JOptionPane.WARNING_MESSAGE,
                step5);

        // show step6
        JOptionPane.showMessageDialog(null,
                null,
                "Step 6",
                JOptionPane.WARNING_MESSAGE,
                step6);

        // show step7
        JOptionPane.showMessageDialog(null,
                null,
                "Step 7",
                JOptionPane.WARNING_MESSAGE,
                step7);

    }


    public static void instructions() {
        Color backgroundColor = new Color(230,255,229);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 20); // or Font.PLAIN
        UIManager.put("OptionPane.messageFont", font); // message color
        UIManager.put("OptionPane.buttonFont", font); // button color
        UIManager.put("OptionPane.messageForeground", Color.BLACK); // text COLOR
        UIManager.put("Panel.background", backgroundColor);
        

        // all instruction images
        ImageIcon step1 = new ImageIcon(Display.class.getResource(
                        "step1.png"));
        ImageIcon step2 = new ImageIcon(Display.class.getResource(
        "step2.png"));
        ImageIcon step3 = new ImageIcon(Display.class.getResource(
        "step3.png"));
        ImageIcon step4 = new ImageIcon(Display.class.getResource(
        "step4.png"));
        ImageIcon step5 = new ImageIcon(Display.class.getResource(
        "step5.png"));

        // show step 1
        JOptionPane.showMessageDialog(null,
                null,
                "Step 1",
                JOptionPane.WARNING_MESSAGE,
                step1);

        // show step2
        JOptionPane.showMessageDialog(null,
        null,
        "Step 2",
        JOptionPane.WARNING_MESSAGE,
        step2);

        // show step3
        JOptionPane.showMessageDialog(null,
                null,
                "Step 3",
                JOptionPane.WARNING_MESSAGE,
                step3);

        // show step4
        JOptionPane.showMessageDialog(null,
        null,
        "Step 4",
        JOptionPane.WARNING_MESSAGE,
        step4);

        // show step5
        JOptionPane.showMessageDialog(null,
                null,
                "Step 5",
                JOptionPane.WARNING_MESSAGE,
                step5);


        Runner r = new Runner();
        r.secondTime();
    }


    
}
