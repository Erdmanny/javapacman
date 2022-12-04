import java.util.HashSet;
import java.util.Set;

/* This is the pacman object */
class Player extends Mover {

    char currDirection = 'L';
    char desiredDirection = 'L';

    int pelletsEaten = 0; //Keeps track of pellets eaten to determine end of game

    boolean teleport = false;    // teleport is true when travelling through the teleport tunnels

    boolean stopped = false;     // Stopped is set when the pacman is not moving or has been killed

    /* Constructor places pacman in initial location and orientation */
    public Player(int x, int y) {
        super(x, y);
    }



    /* Update what pellet the pacman is on top of */
    public void updatePellet() {
        if (isChoiceDest()) {
            pelletX = x / gridSize - 1;
            pelletY = y / gridSize - 1;
        }
    }

    public void moveSwitchAdvanced(char direction){
        switch (direction) {
            case 'L':
                if (isValidDest(x - increment, y)) {
                    x -= increment;
                } else if (y == 9 * gridSize && x < 2 * gridSize) {
                    x = max - gridSize * 1;
                    teleport = true;
                }
                break;
            case 'R':
                if (isValidDest(x + gridSize, y)) {
                    x += increment;
                } else if (y == 9 * gridSize && x > max - gridSize * 2) {
                    x = 1 * gridSize;
                    teleport = true;
                }
                break;
            case 'U':
                if (isValidDest(x, y - increment))
                    y -= increment;
                break;
            case 'D':
                if (isValidDest(x, y + gridSize))
                    y += increment;
                break;
        }
    }



    /* This function is used for demoMode.  It is copied from the Ghost class.  See that for comments */
    public void demoMove() {
        lastX = x;
        lastY = y;
        if (isChoiceDest()) direction = newDirection();
        moveSwitchAdvanced(direction);
        currDirection = direction;
        frameCount++;
    }

    /* The move function moves the pacman for one frame in non demo mode */
    public void move() {
        lastX = x;
        lastY = y;

        /* Try to turn in the direction input by the user */
        /*Can only turn if we're in center of a grid*/
        if (isChoiceDest() ||
                /* Or if we're reversing*/
                (desiredDirection == 'L' && currDirection == 'R') ||
                (desiredDirection == 'R' && currDirection == 'L') ||
                (desiredDirection == 'U' && currDirection == 'D') ||
                (desiredDirection == 'D' && currDirection == 'U')
        ) {
            moveSwitch(desiredDirection);
        }
        /* If we haven't moved, then move in the direction the pacman was headed anyway */
        if (lastX == x && lastY == y) {
            moveSwitchAdvanced(currDirection);
        }

        /* If we did change direction, update currDirection to reflect that */
        else {
            currDirection = desiredDirection;
        }

        /* If we didn't move at all, set the stopped flag */
        if (lastX == x && lastY == y)
            stopped = true;

            /* Otherwise, clear the stopped flag and increment the frameCount for animation purposes*/
        else {
            stopped = false;
            frameCount++;
        }
    }


}
