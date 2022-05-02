package rom1.org;

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
}

    public static void main(String args[]) {
        String parameter = "a";
        Drawable button;
        button = createButton(parameter);
        button.draw();
    }

    private static Drawable createButton(String parameter) {
        Drawable button;
        if (WINDOW_BUTTON.getCode().equalsIgnoreCase(parameter)) {
            button = new WindowsButton();
        } else if(HTML_BUTTON.getCode().equalsIgnoreCase(parameter)) {
            button = new HTMLButton();
        } else {
            throw new IllegalArgumentException("unknown parameter");
        }
        return button;
    }


}
