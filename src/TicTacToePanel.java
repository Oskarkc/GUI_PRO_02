import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TicTacToePanel extends JPanel {
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
    public TicTacToePanel(playermoved listener) {
        this.listener = listener;
        this.setLayout(new GridLayout(3,3));
        TicTacToeButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            TicTacToeButtons[i] = new JButton("");
            position = i;
            TicTacToeButtons[i].addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                if(((JButton) e.getSource()).getText().equals("")){
                    ((JButton) e.getSource()).setText(String.valueOf(currentPlayer));
                    if(currentPlayer == 'X'){
                        ((JButton) e.getSource()).setForeground(Color.RED);
                    }else
                       ((JButton) e.getSource()).setForeground(Color.GREEN);
                        if(IsPlayerWon()){
                            ChangeButtons();
                            currentPlayer = (currentPlayer =='X')? 'O' : 'X';
                        }else{
                            currentPlayer = (currentPlayer =='X')? 'O' : 'X';
                        }
                        if(listener != null){
                            listener.playermoved(Arrays.asList(TicTacToeButtons).indexOf(clickedButton));
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
    public void ChangeButtons(){
        for(JButton button : TicTacToeButtons){
            button.setEnabled(false);
            button.setVisible(false);
        }
        if(currentPlayer == 'X')
            this.setBackground(Color.RED);
        else
            this.setBackground(Color.GREEN);
    }

}

