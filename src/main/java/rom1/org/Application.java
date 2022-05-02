package rom1.org;

import java.util.stream.Stream;

import static rom1.org.Application.BUTTON_TYPE.HTML_BUTTON;
import static rom1.org.Application.BUTTON_TYPE.WINDOW_BUTTON;

public class Application {

    enum BUTTON_TYPE {
        WINDOW_BUTTON("window_button"),
        HTML_BUTTON("html_button");

    private final String code;

    BUTTON_TYPE(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    BUTTON_TYPE get(String code) {
        return Stream.of(BUTTON_TYPE.values()).filter(bt -> bt.getCode().equals(code)).findFirst().orElse(null);
    }
}

    public static void main(String args[]) {
        Drawable button;
        button = createButton(WINDOW_BUTTON);
        button.draw();
    }

    private static Drawable createButton(BUTTON_TYPE parameter) {
        Drawable button;
        if (WINDOW_BUTTON == parameter) {
            button = new WindowsButton();
        } else if(HTML_BUTTON == parameter) {
            button = new HTMLButton();
        } else {
            throw new IllegalArgumentException("unknown parameter");
        }
        return button;
    }


}
