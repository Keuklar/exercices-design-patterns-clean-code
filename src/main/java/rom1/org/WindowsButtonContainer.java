package rom1.org;

public class WindowsButtonContainer implements Creator {
    // Ce n'est pas évident ici mais il peut y avoir beaucoup de code
    // on est plus dans un conteneur qu'un créateur
    public Drawable createButton() {
        return new WindowsButton();
    }
}
