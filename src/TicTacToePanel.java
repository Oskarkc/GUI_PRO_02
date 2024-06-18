import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
public class TicTacToePanel extends JPanel {
    private int indexofPanel;
    static int counter = 1;
    ImageIcon iconX = new ImageIcon("/Users/oskarkoc/IdeaProjects/GUI_PRO_02/src/X.png");
    ImageIcon iconO = new ImageIcon("/Users/oskarkoc/IdeaProjects/GUI_PRO_02/src/O2.png");
    private int position;
    private playermoved listener;
    private JButton[] TicTacToeButtons;
    private static char currentPlayer = 'X';
    private final int[][] winnerpoles = {
            {0,1,2},
            {3,4,5},
            {6,7,8},

            {0,3,6},{1,4,7},{2,5,8},

            {0,4,8},{2,4,6}
    };
    public TicTacToePanel(playermoved listener,int index) {
        this.indexofPanel=index;
        this.listener = listener;
        indexofPanel=counter++;
        this.setLayout(new GridLayout(3,3));
        TicTacToeButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            TicTacToeButtons[i] = new JButton("");
            TicTacToeButtons[i].setPreferredSize(new Dimension(100, 100));
            position = i;
            TicTacToeButtons[i].addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                if(((JButton) e.getSource()).getText().equals("")){
                    ((JButton) e.getSource()).setText(String.valueOf(currentPlayer));
                    if(listener != null){
                        listener.playermoved(currentPlayer,indexofPanel-1,Arrays.asList(TicTacToeButtons).indexOf(clickedButton));
                    }
                    if(currentPlayer == 'X'){
                        ((JButton) e.getSource()).setForeground(Color.RED);
                    }else
                       ((JButton) e.getSource()).setForeground(Color.GREEN);
                        if(IsPlayerWon()){
                            changePanel();
                            currentPlayer = (currentPlayer =='X')? 'O' : 'X';
                        }else{
                            currentPlayer = (currentPlayer =='X')? 'O' : 'X';
                        }

                }
            });

            this.add(TicTacToeButtons[i]);
        }
    }
    public boolean IsPlayerWon(){
        for(int[] x : winnerpoles){
            if(
                    TicTacToeButtons[x[0]].getText().equals(String.valueOf(currentPlayer)) &&
                    TicTacToeButtons[x[1]].getText().equals(String.valueOf(currentPlayer))&&
                    TicTacToeButtons[x[2]].getText().equals(String.valueOf(currentPlayer)))

                return true;

        }
        return false;
    }
    public void changePanel(){
        removeAll();
        if(currentPlayer == 'X') {
            setIconX(this);
            this.setBackground(Color.RED);
        }
        else {
            setIconO(this);
            this.setBackground(Color.GREEN);
        }
    }
    public void setIconX(JPanel a){
        a.setLayout(new BorderLayout());
        a.add(new JButton(new ImageIcon(iconX.getImage().getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH))),BorderLayout.CENTER);
    }
    public void setIconO(JPanel a){
        a.setLayout(new BorderLayout());
        a.add(new JButton(new ImageIcon(iconO.getImage().getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH))), BorderLayout.CENTER);
    }

}

