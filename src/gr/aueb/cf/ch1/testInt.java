package gr.aueb.cf.ch1;

public class testInt {
    public static void main(String[] args) {
        int x = 55, y = 0, d = 10;
        double dbl = (x+d-1)/d;
        int res = (int)((x-y)/d + 0.9);
        System.out.println(res +" "+dbl);
    }
}
