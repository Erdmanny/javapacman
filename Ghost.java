import java.util.HashSet;
import java.util.Set;

/* Ghost class controls the ghost. */
class Ghost extends Mover {

    int lastPelletX, lastPelletY; //The pellet the ghost was last on top of

    /*Constructor places ghost and updates states*/
    public Ghost(int x, int y) {
        super(x, y);
        lastPelletX = pelletX;
        lastPelletY = pelletY;
    }



    /* update pellet status */
    public void updatePellet() {
        int tempX, tempY;
        tempX = x / gridSize - 1;
        tempY = y / gridSize - 1;
        if (tempX != pelletX || tempY != pelletY) {
            lastPelletX = pelletX;
            lastPelletY = pelletY;
            pelletX = tempX;
            pelletY = tempY;
        }

    }



    /* Random move function for ghost */
    public void move() {
        lastX = x;
        lastY = y;
        if (isChoiceDest()) direction = newDirection();  // If we can make a decision, pick a new direction randomly
        moveSwitch(direction);
    }
}
