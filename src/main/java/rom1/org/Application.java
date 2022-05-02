package rom1.org;

public class Application {

    public static final String WINDOW_BUTTON = "window_button";
    public static final String HTML_BUTTON = "html_button";

    public static void main(String args[]) {
        String parameter = "a";
        Drawable button;
        button = createButton(parameter);
        button.draw();
    }

    private static Drawable createButton(String parameter) {
        Drawable button;
        if (WINDOW_BUTTON.equalsIgnoreCase(parameter)) {
            button = new WindowsButton();
        } else if(HTML_BUTTON.equalsIgnoreCase(parameter)) {
            button = new HTMLButton();
        } else {
            throw new IllegalArgumentException("unknown parameter");
        }
        return button;
    }


}
