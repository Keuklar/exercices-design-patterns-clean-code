package rom1.org;

import java.util.function.Supplier;
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

        static BUTTON_TYPE get(String code) {
            return Stream
                    .of(BUTTON_TYPE.values())
                    .filter(bt -> bt.getCode().equals(code))
                    .findFirst()
                    .orElse(null); // code est un ensemble ouvert
        }
    }

    enum BUTTON_CONTAINER_TYPE {
        WINDOW_BUTTON_CONTAINER(WINDOW_BUTTON, WindowsButtonContainer::new),
        HTML_BUTTON_CONTAINER(HTML_BUTTON, HTMLButtonContainer::new);

        private final BUTTON_TYPE buttonType;
        private final Supplier<Creator> creatorSupplier;

        BUTTON_CONTAINER_TYPE(BUTTON_TYPE buttonType, Supplier<Creator> creatorSupplier) {
            this.buttonType = buttonType;
            this.creatorSupplier = creatorSupplier;
        }

        static BUTTON_CONTAINER_TYPE get(BUTTON_TYPE buttonType) {
            return Stream
                    .of(BUTTON_CONTAINER_TYPE.values())
                    .filter(bc -> bc.buttonType == buttonType)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new); // buttonType est un ensemble fermé
        }
    }

    public static void main(String[] args) {
        createButton(BUTTON_TYPE.get(getParamFromArgs(args))).draw();
    }

    private static String getParamFromArgs(String[] args) {
        System.out.println(args);
        return "html_button";
//        return "window_button";
//        return "X"; // throws java.lang.IllegalArgumentException
    }

    private static Drawable createButton(BUTTON_TYPE buttonType) {
        return BUTTON_CONTAINER_TYPE
                .get(buttonType)
                .creatorSupplier
                .get()
                .createButton();
    }


}
