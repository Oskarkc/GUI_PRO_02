import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame implements Runnable {
    JPanel panele[] = new JPanel[9];
    public TicTacToeFrame() {
        this.setTitle("Tic Tac Toe");
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            panele[i] = new TicTacToePanel();
            panele[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(panele[i]);
        }
        pack();
        this.setVisible(true);
    }
    public void run() {
        while (!IsGameWon) {
            int wylosowanypanel =((int) Math.random() * 9+1);
            panele[wylosowanypanel].setVisible(true);
        }
    }
}
