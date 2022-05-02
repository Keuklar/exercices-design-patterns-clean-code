package rom1.org;

public class Application {

    public static void main(String args[]) {
        String parameter = "a";
        Drawable button;
        if ("a".equalsIgnoreCase(parameter)) {
            button = createWindowsButton();
        } else if("b".equalsIgnoreCase(parameter)) {
            button = createHTMLButton();
        } else {
            throw new IllegalArgumentException("unknown parameter");
        }
        button.draw();
    }


    private static WindowsButton createWindowsButton() {
        return new WindowsButton();
    }

    private static HTMLButton createHTMLButton() {
        return new HTMLButton();
    }

}
