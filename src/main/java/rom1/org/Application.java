package rom1.org;

public class Application {

    public static void main(String args[]) {
        String parametre = "a";
        if ("a".equalsIgnoreCase(parametre)) {
            creerBoutonWindows().afficher();
        } else if("b".equalsIgnoreCase(parametre)) {
            createHTMLButton().draw();
        }
    }


    private static BoutonWindows creerBoutonWindows() {
        return new BoutonWindows();
    }

    private static HTMLButton createHTMLButton() {
        return new HTMLButton();
    }

}
