import java.util.HashSet;
import java.util.Set;

/* Both Player and Ghost inherit Mover.  Has generic functions relevant to both*/
class Mover {
    /* Framecount is used to count animation frames*/
    int frameCount = 0;

    /* State contains the game map */
    boolean[][] state;

    /* gridSize is the size of one square in the game.
       max is the height/width of the game.
       increment is the speed at which the object moves,
       1 increment per move() call */
    int gridSize;
    int max;
    int increment;


    char direction = 'L';
    int lastX;
    int lastY;
    int x;
    int y;
    int pelletX;
    int pelletY;

    /* Generic constructor */
    public Mover(int x, int y) {
        gridSize = 20;
        increment = 4;
        max = 400;
        state = new boolean[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                state[i][j] = false;
            }
        }
        pelletX = x / gridSize - 1;
        pelletY = y / gridSize - 1;
        this.lastX = x;
        this.lastY = y;
        this.x = x;
        this.y = y;
    }


    public char newDirection() {
        int random;
        char backwards = 'U';
        int newX = x, newY = y;
        int lookX = x, lookY = y;
        Set<Character> set = new HashSet<Character>();
        switch (direction) {
            case 'L':
                backwards = 'R';
                break;
            case 'R':
                backwards = 'L';
                break;
            case 'U':
                backwards = 'D';
                break;
            case 'D':
                backwards = 'U';
                break;
        }

        char newDirection = backwards;
        /* While we still haven't found a valid direction */
        while (newDirection == backwards || !isValidDest(lookX, lookY)) {
            /* If we've tried every location, turn around and break the loop */
            if (set.size() == 3) {
                newDirection = backwards;
                break;
            }

            newX = x;
            newY = y;
            lookX = x;
            lookY = y;

            /* Randomly choose a direction */
            random = (int) (Math.random() * 4) + 1;
            if (random == 1) {
                newDirection = 'L';
                newX -= increment;
                lookX -= increment;
            } else if (random == 2) {
                newDirection = 'R';
                newX += increment;
                lookX += gridSize;
            } else if (random == 3) {
                newDirection = 'U';
                newY -= increment;
                lookY -= increment;
            } else if (random == 4) {
                newDirection = 'D';
                newY += increment;
                lookY += gridSize;
            }
            if (newDirection != backwards) {
                set.add(new Character(newDirection));
            }
        }
        return newDirection;
    }

    public boolean isChoiceDest() {
        return (x % gridSize == 0 && y % gridSize == 0);
    }

    /* Updates the state information */
    public void updateState(boolean[][] state) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.state[i][j] = state[i][j];
            }
        }
    }

    /* Determines if a set of coordinates is a valid destination.*/
    public boolean isValidDest(int x, int y) {
    /* The first statements check that the x and y are inbounds.  The last statement checks the map to
       see if it's a valid location */
        if ((((x) % 20 == 0) || ((y) % 20) == 0) && 20 <= x && x < 400 && 20 <= y && y < 400 && state[x / 20 - 1][y / 20 - 1]) {
            return true;
        }
        return false;
    }


    public void moveSwitch(char direction){
        switch (direction) {
            case 'L':
                if (isValidDest(x - increment, y))
                    x -= increment;
                break;
            case 'R':
                if (isValidDest(x + gridSize, y))
                    x += increment;
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
}
