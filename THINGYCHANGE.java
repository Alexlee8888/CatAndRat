import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;
import java.awt.*;

public abstract class THINGYCHANGE {
    private InputHandler inputHandler;
    private static Image image;
    public THINGYCHANGE(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
}
