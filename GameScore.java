import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameScore{

    /* Score information */
    private int currentScore;
    private int highScore;

    /* if the high scores have been cleared, we have to update the top of the screen to reflect that */
    private boolean highScoresAreCleared = false;

    public GameScore(){
        initHighScores();
        currentScore =0;
    }


    public int getCurrentScore(){
        return currentScore;
    }

    public int getHighScore(){
        return highScore;
    }

    public boolean getHighScoresAreCleared(){
        return highScoresAreCleared;
    }

    public void setHighScoresAreCleared(boolean highScoresAreCleared){
        this.highScoresAreCleared = highScoresAreCleared;
    }


    public void setCurrentScore(int currentScore){
        this.currentScore = currentScore;
    }


    /* Reads the high scores file and saves it */
    public void initHighScores()
    {
        File file = new File("highScores.txt");
        Scanner sc;
        try
        {
            sc = new Scanner(file);
            highScore = sc.nextInt();
            sc.close();
        }
        catch(Exception e)
        {
        }
    }

    /* Writes the new high score to a file and sets flag to update it on screen */
    public void updateScore(int score)
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter("highScores.txt");
            out.println(score);
            out.close();
        }
        catch(Exception e)
        {
        }
        highScore=score;
        highScoresAreCleared =true;
    }

    /* Wipes the high scores file and sets flag to update it on screen */
    public void clearHighScores()
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter("highScores.txt");
            out.println("0");
            out.close();
        }
        catch(Exception e)
        {
        }
        highScore=0;
        highScoresAreCleared =true;
    }

}