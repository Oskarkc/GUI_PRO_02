import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToeFrame extends JFrame implements playermoved {
    JPanel panele[] = new JPanel[9];
    boolean currentplayerX = false;
    boolean currentplayerO = false;
    private final int[][] winnerpoles = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},

            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},

            {0, 4, 8}, {2, 4, 6}
    };

    public TicTacToeFrame() {
        this.setTitle("Tic Tac Toe");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            panele[i] = new TicTacToePanel(this);
            panele[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panele[i].addMouseListener(new MouseAdapter(){ public void mouseEntered(MouseEvent e){
                if (checkforWin()) {
                    if (currentplayerX) {
                        JOptionPane.showMessageDialog(TicTacToeFrame.this, "X wins");
                    }
                    if (currentplayerO) {
                        JOptionPane.showMessageDialog(TicTacToeFrame.this, "O wins");
                    }
                }
            }});
            this.add(panele[i]);
        }
        pack();
        this.setVisible(true);

    }

    @Override
    public void playermoved(int x) {
        if(panele[x].getBackground().equals(Color.RED) || panele[x].getBackground().equals(Color.GREEN)){
            for (int i = 0; i < 9; i++) {
                Component[] components = panele[i].getComponents();
                for(Component c : components){
                    c.setEnabled(true);
                }
            }
            return;
        }
        for (int j = 0; j < 9; j++) {
            Component[] components = panele[j].getComponents();
            if (j == x) {
                for (Component c : components)
                    c.setEnabled(true);
            } else
                for (Component c : components)
                    c.setEnabled(false);
        }
    }

    private boolean checkforWin() {
        for (int[] x : winnerpoles) {
            if (
                    panele[x[0]].getBackground().equals(Color.RED) &&
                            panele[x[1]].getBackground().equals(Color.RED) &&
                            panele[x[2]].getBackground().equals(Color.RED)
            ) {
                currentplayerX = true;
                return true;
            } else if (
                    panele[x[0]].getBackground().equals(Color.GREEN) &&
                            panele[x[1]].getBackground().equals(Color.GREEN) &&
                            panele[x[2]].getBackground().equals(Color.GREEN)
            ) {
                currentplayerO = true;
                return true;
            }
        }
        return false;
    }


}
