/**
 * person is an individual player who plays the game
 */
public class Person extends Player {

    /**
     * creates a new person
     * @param isCat whether the person is the cat first or not
     * @param input inputhandler for cat and rat
     */
    public Person(boolean isCat, InputHandler input) {
        super(isCat, input);
    }
}