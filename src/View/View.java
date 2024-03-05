package View;

import java.util.Scanner;

public class View {
    public void show(String message) {
        System.out.println(message);
    }
    public String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
