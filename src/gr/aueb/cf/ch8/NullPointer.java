package gr.aueb.cf.ch8;

public class NullPointer {
    public static void main(String[] args) {
        String s = null;

        if (s.equals("Coding")) {
            System.out.println("Bingo");
        }
    }
}
