/**
 * a player of the cat and rat game
 */
public class Player {
    private int score = 0;
    private boolean isCat;
    private Cat cat;
    private Rat rat;
    private InputHandler input;

    public Player (boolean isCat, InputHandler input) {
        this.isCat = isCat;
        this.input = input;
        if(isCat) { 
            cat = new Cat();
        } else {
            rat = new Rat(input);
        }
    }

    /**
     * swaps the rat and cat roles for player 1 and player 2
     */
    public void swapRoles() {
        isCat = !isCat;
        if(isCat) {
            cat = new Cat();
            rat = null;
        }
        else {
            rat = new Rat(input);
            cat = null;
        }
    }

    /**
     * adds one score to the player
     */
    public void addScore() {
        score++;
    }

    /**
     * returns the players score
     * @return the players score
     */
    public int getScore() {
        return score;
    }

    /**
     * checks if person is cat
     * @return if the player is currently the cat
     */
    public boolean isCat() {
        return isCat;
    }

    /**
     * gets the instance of cat for player
     * @return Cat cat
     */
    public Cat getCat() {
        return cat;
    }

    /**
     * gets the instance of rat for player
     * @return Rat rat
     */
    public Rat getRat() {
        return rat;
    }
}