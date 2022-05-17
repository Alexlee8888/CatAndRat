public class Player {
    private int lives = 5;
    private boolean isCat;
    private Cat cat;
    private Rat rat;
    private InputHandler input;

    public Player (boolean isCat, InputHandler input) {
        this.isCat = isCat;
        this.input = input;
        if(isCat) { 
            cat = new Cat(input);
        } else {
            rat = new Rat(input);
        }
    }

    public void swapRoles() {
        isCat = !isCat;
        if(isCat) {
            cat = new Cat(input);
            rat = null;
        }
        else {
            rat = new Rat(input);
            cat = null;
        }
        lives = 5;
    }

    public void loseLife() {
        lives--;
    }

    public int getLives() {
        return lives;
    }

    public boolean isCat() {
        return isCat;
    }

    public Cat getCat() {
        return cat;
    }

    public Rat getRat() {
        return rat;
    }

    // public void update() {
    //     rat.update();
    //     cat.update(input.getMouseClick());
    // }
}