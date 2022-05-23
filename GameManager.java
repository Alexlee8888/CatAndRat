import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * manages the logic of the game
 */
public class GameManager {
    private InputHandler inputHandler;
    private Player player1;
    private Player player2;
    // private TreeMap<Integer, ArrayList<String>> leaderboard;
    private Timer timer;
    private int second, minute;
    private DecimalFormat dFormat = new DecimalFormat("00");
    private String decs, decm;
    private String timerLabel = "00:30";
    private int rounds = 2;
    public boolean gameOver = false;

    /**
     * constructor for game manager, creates 2 new players (multiplayer game)
     * 
     * @param inputHandler key/mouse listener
     */
    GameManager(InputHandler inputHandler) {
        // leaderboard = new TreeMap<>();
        this.inputHandler = inputHandler;
        player1 = new Person(true, inputHandler); // player 1 is cat, player 2 is rat
        player2 = new Person(false, inputHandler); // player 1 is cat, player 2 is rat
    }

    /**
     * updates everything and checks for mouse clicks from the player who is
     * controlling cat
     * then updates score accordingly
     */
    public void tick() {
        // check for click
        if (inputHandler.getMouseClick() != null) {
            if (player1.isCat()) {
                player1.getCat().update(inputHandler.getMouseClick());
            } else {
                player2.getCat().update(inputHandler.getMouseClick());
            }
            Location[] hitbox;
            if (player1.isCat()) {
                hitbox = player2.getRat().getHitbox();
            } else {
                hitbox = player1.getRat().getHitbox();
            }
            Location click = inputHandler.getMouseClick();
            if (click.getX() >= hitbox[0].getX() && click.getX() <= hitbox[1].getX() && click.getY() >= hitbox[0].getY()
                    && click.getY() <= hitbox[1].getY()) {
                System.out.println("clicked");
                if (player1.isCat()) {
                    player1.addScore();
                } else {
                    player2.addScore();
                }
                System.out.println("player 1 score: " + player1.getScore() + " player 2 score: " + player2.getScore());
            }

            inputHandler.resetClickPoint();
        }
        // check for release
        if (inputHandler.getMouseRelease() != null) {
            if (player1.isCat()) {
                player1.getCat().reset();
            } else {
                player2.getCat().reset();
            }
            inputHandler.resetReleasePoint();
        }
        // update everything
        if (player1.isCat()) {
            player2.getRat().update();
        } else {
            player1.getRat().update();
        }
    }

    /**
     * draws cat, rat, scoreboard
     * 
     * @param g graphics
     */
    public void render(Graphics g) {
        drawScoreBoard(g);
        g.drawString(timerLabel, 800, 50);
        if (player1.isCat()) {
            player1.getCat().draw(g);
            player2.getRat().draw(g);
        } else {
            player1.getRat().draw(g);
            player2.getCat().draw(g);
        }
    }

    /**
     * After round is over, player 1 and player 2 swaps roles
     */
    public void swapRoles() {
        // System.out.println("swapped");
        player1.swapRoles();
        player2.swapRoles();
        // System.out.println("player 1 lives: " + player1.getScore() + " player 2
        // lives: " + player2.getScore());
    }

    /**
     * draws scoreboard using times roman
     * 
     * @param g
     */
    public void drawScoreBoard(Graphics g) {
        g.setColor(Color.BLACK);

        g.setFont(new Font("TimesRoman", Font.BOLD, 40));

        String player1score = "Player 1 (" + (player1.isCat() ? "Cat) : " : "Rat) : ")
                + String.valueOf(player1.getScore());
        g.drawString(player1score, 10, 50);
        String player2score = "Player 2 (" + (player2.isCat() ? "Cat) : " : "Rat) : ")
                + String.valueOf(player2.getScore());
        g.drawString(player2score, 10, 100);
    }

    /**
     * timer for each round
     * 1 min 30 seconds per round
     * uses action listener
     */
    public void timer() {
        this.minute = 0;
        this.second = 10;
        int delay = 1000; // milliseconds
        timerLabel = dFormat.format(minute) + ":" + dFormat.format(second);
        ActionListener taskPerf = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                second--;
                decs = dFormat.format(second);
                decm = dFormat.format(minute);
                timerLabel = decm + ":" + decs;

                if (second == -1) {
                    second = 59;
                    minute--;
                    decs = dFormat.format(second);
                    decm = dFormat.format(minute);
                    timerLabel = decm + ":" + decs;
                }
                if (minute == 0 && second == 0) {
                    timer.stop();
                    swapRoles();
                    rounds--;
                    if (rounds > 0) {
                        timer();
                    } else {
                        gameOver = true;
                    }
                }
            }

        };
        timer = new Timer(delay, taskPerf);
        timer.start();
    }

    /**
     * returns a string to represent who had the most clicks on the rat (who won)
     * 
     * @return string string to show who won
     */
    public String winString() {
        if (player1.getScore() > player2.getScore()) {
            return "Player 1 won!";
        } else if (player2.getScore() > player1.getScore()) {
            return "Player 2 won!";
        } else {
            return "It's a tie!";
        }
    }

    public String returnScore() {
        return player1.getScore() + " : " + player2.getScore();
    }

    /**
     * returns timer
     * 
     * @return timer
     */
    public Timer getTimer() {
        return timer;
    }
}
