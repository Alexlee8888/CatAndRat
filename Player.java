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
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
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
}