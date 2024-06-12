import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements Playermoved {
    JPanel panele[] = new JPanel[9];
    boolean playermoved = false;

    public TicTacToeFrame() {
        this.setTitle("Tic Tac Toe");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            panele[i] = new TicTacToePanel(this);
            panele[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(panele[i]);
        }
        pack();
        this.setVisible(true);
    }

    @Override
    public void Playermoved(int x) {
        for (int j = 0; j < 9; j++) {
            Component[] components = panele[j].getComponents();
            if (j == x) {
                for (Component c : components)
                    c.setEnabled(true);
            }
            else
                for (Component c : components)
                    c.setEnabled(false);
        }

    }


}
