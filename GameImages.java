import java.awt.*;

public class GameImages{

    private Image pacmanImage = Toolkit.getDefaultToolkit().getImage("img/pacman.jpg");
    private Image pacmanUpImage = Toolkit.getDefaultToolkit().getImage("img/pacmanup.jpg");
    private Image pacmanDownImage = Toolkit.getDefaultToolkit().getImage("img/pacmandown.jpg");
    private Image pacmanLeftImage = Toolkit.getDefaultToolkit().getImage("img/pacmanleft.jpg");
    private Image pacmanRightImage = Toolkit.getDefaultToolkit().getImage("img/pacmanright.jpg");
    private Image ghost10 = Toolkit.getDefaultToolkit().getImage("img/ghost10.jpg");
    private Image ghost20 = Toolkit.getDefaultToolkit().getImage("img/ghost20.jpg");
    private Image ghost30 = Toolkit.getDefaultToolkit().getImage("img/ghost30.jpg");
    private Image ghost40 = Toolkit.getDefaultToolkit().getImage("img/ghost40.jpg");
    private Image ghost11 = Toolkit.getDefaultToolkit().getImage("img/ghost11.jpg");
    private Image ghost21 = Toolkit.getDefaultToolkit().getImage("img/ghost21.jpg");
    private Image ghost31 = Toolkit.getDefaultToolkit().getImage("img/ghost31.jpg");
    private Image ghost41 = Toolkit.getDefaultToolkit().getImage("img/ghost41.jpg");
    private Image titleScreenImage = Toolkit.getDefaultToolkit().getImage("img/titleScreen.jpg");
    private Image gameOverImage = Toolkit.getDefaultToolkit().getImage("img/gameOver.jpg");
    private Image winScreenImage = Toolkit.getDefaultToolkit().getImage("img/winScreen.jpg");


    public Image getPacmanImage(){
        return pacmanImage;
    }

    public Image getTitleScreenImage(){
        return titleScreenImage;
    }

    public Image getWinScreenImage(){
        return winScreenImage;
    }


    public Image getGameOverImage(){
        return gameOverImage;
    }

    public Image getGhost10(){
        return ghost10;
    }

    public Image getGhost20(){
        return ghost20;
    }

    public Image getGhost30(){
        return ghost30;
    }

    public Image getGhost40(){
        return ghost40;
    }

    public Image getGhost11(){
        return ghost11;
    }

    public Image getGhost21(){
        return ghost21;
    }

    public Image getGhost31(){
        return ghost31;
    }

    public Image getGhost41(){
        return ghost41;
    }

    public Image getPacmanLeftImage(){
        return pacmanLeftImage;
    }

    public Image getPacmanRightImage(){
        return pacmanRightImage;
    }

    public Image getPacmanUpImage(){
        return pacmanUpImage;
    }

    public Image getPacmanDownImage(){
        return pacmanDownImage;
    }


}