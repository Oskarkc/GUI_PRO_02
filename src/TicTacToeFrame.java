import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class TicTacToeFrame extends JFrame implements playermoved {
    TicTacToeMoveHistory moveHistory;
    JPanel panele[] = new JPanel[9];
    TicTacToeMenu menu = new TicTacToeMenu();
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
            this.add(menu);
            menu.singleplayer.addActionListener(e->{
                revalidate();
                repaint();
            });
            menu.multiplayer.addActionListener(e -> {
                remove(menu);
                moveHistory=new TicTacToeMoveHistory();
                for (int i = 0; i < 9; i++) {
                panele[i] = new TicTacToePanel(this,i);
                panele[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panele[i].addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        if (checkforWin()) {
                            if (currentplayerX) {
                                JOptionPane.showMessageDialog(TicTacToeFrame.this, "X wins");
                            }
                            if (currentplayerO) {
                                JOptionPane.showMessageDialog(TicTacToeFrame.this, "O wins");
                            }
                        }
                    }
                });
                this.add(panele[i]);
            }
                pack();
                revalidate();
                repaint();
            });
            this.setVisible(true);



    }

    @Override
    public void playermoved(char current, int x,int y) {
        moveHistory.addMove(current,transformOnString(x),transformOnString(y));
        if(panele[y].getBackground().equals(Color.RED) || panele[y].getBackground().equals(Color.GREEN)){
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
            if (j == y) {
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
public String transformOnString(int x){
    return switch (x) {
        case 0 -> "LG";
        case 1 -> "SG";
        case 2 -> "PG";
        case 3 -> "SL";
        case 4 -> "SS";
        case 5 -> "SP";
        case 6 -> "DL";
        case 7 -> "DS";
        case 8 -> "DP";
        default -> "";
    };
}

}
