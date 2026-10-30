/***
 * Maze class, will decide where a wall is put. 0 = no wall, 1 = horizont. wall, 2 = vert. wall
 * @author Clarice 
 */
public class Maze {
    
    // declarations/initializations
    int[][] wallEasy = new int[20][20];
    int[][] wallHard = new int[23][23];
    int lengthOfGrid = 0;
    String Path = "";
    
    public Maze(String path, int squaresAcross) {

        lengthOfGrid = squaresAcross;

        if(lengthOfGrid == 20) { // easy level
            Path = path;
            // set path
            for(int i = 0; i < 20; i++) {
                for(int j = 0; j < 20; j++) {
                    int num = (int)(Math.random() * 3);
                    wallEasy[i][j] = num;
                }
            }

            // eliminate the walls that block the path
            int xPosOnGrid = 0;
            int yPosOnGrid = 0;
            for(int i = 0; i < Path.length(); i++) {
                if(Path.charAt(i) == 'D') {
                    if(yPosOnGrid < wallEasy.length && xPosOnGrid < wallEasy.length) {
                        wallEasy[yPosOnGrid][xPosOnGrid] = 0;
                        xPosOnGrid++;
                    }
                } else {
                    if(yPosOnGrid < wallEasy.length && xPosOnGrid < wallEasy.length) {
                        wallEasy[yPosOnGrid][xPosOnGrid] = 0;
                        yPosOnGrid++;
                    }
                }
            }
        } else if(lengthOfGrid == 23) { // hard level
            Path = path;
            // set path
            for(int i = 0; i < 23; i++) {
                for(int j = 0; j < 23; j++) {
                    int num = (int)(Math.random() * 3);
                    wallHard[i][j] = num;
                }
            }

            // eliminate the walls that block the path
            int xPosOnGrid = 0;
            int yPosOnGrid = 0;
            for(int i = 0; i < Path.length(); i++) {
                if(Path.charAt(i) == 'D') {
                    if(yPosOnGrid < wallHard.length && xPosOnGrid < wallHard.length) {
                        wallHard[yPosOnGrid][xPosOnGrid] = 0;
                        xPosOnGrid++;
                    }
                } else {
                    if(yPosOnGrid < wallHard.length && xPosOnGrid < wallHard.length) {
                        wallHard[yPosOnGrid][xPosOnGrid] = 0;
                        yPosOnGrid++;
                    }
                }
            }
        } 



    }


    /***
     * return back the spots where walls exist
     * @return walls 
     */
    public int[][] returnWalls() {

        if(lengthOfGrid == 20) {
            return wallEasy;
        } 
        return wallHard;
    }









}
