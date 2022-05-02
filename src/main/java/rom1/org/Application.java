package rom1.org;

public class Application {

    public static void main(String args[]) {
        String parameter = "a";
        Drawable button;
        button = createButton(parameter);
        button.draw();
    }

    private static Drawable createButton(String parameter) {
        Drawable button;
        if ("window_button".equalsIgnoreCase(parameter)) {
            button = new WindowsButton();
        } else if("html_button".equalsIgnoreCase(parameter)) {
            button = new HTMLButton();
        } else {
            throw new IllegalArgumentException("unknown parameter");
        }
        return button;
    }


}
