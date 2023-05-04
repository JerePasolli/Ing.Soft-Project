import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {
        Pacman pac = new Pacman();
        pac.setVisible(true);
        pac.setTitle("Pacman");
        pac.setSize(380,420);
        pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pac.setLocationRelativeTo(null);

    }
}
