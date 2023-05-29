package gr.aueb.cf.ch8;

import java.util.Optional;

public class OptionalApp {
    public static void main(String[] args) {
        String s = "AUEB";
        String copied = null;

        Optional<String> str = getStrCopy(s);

        if (str.isPresent())
            copied = str.get();

        System.out.println(copied);

    }

    public static Optional<String> getStrCopy(String s) {
        return Optional.ofNullable(s);
    }
}
