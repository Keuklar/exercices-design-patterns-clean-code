package rom1.org;

public class Application {

    public static void main(String args[]) {
        String parameter = "a";
        if ("a".equalsIgnoreCase(parameter)) {
            createWindowsButton().draw();
        } else if("b".equalsIgnoreCase(parameter)) {
            createHTMLButton().draw();
        }
    }


    private static WindowsButton createWindowsButton() {
        return new WindowsButton();
    }

    private static HTMLButton createHTMLButton() {
        return new HTMLButton();
    }

}
