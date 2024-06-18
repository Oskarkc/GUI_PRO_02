import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TicTacToeMoveHistory extends JFrame{
        JTextArea layot = new JTextArea();
        JTextArea moves = new JTextArea();
        JScrollBar mainhist = new JScrollBar();
        int moveCounter = 1;
    public TicTacToeMoveHistory() {
        this.setTitle("Tic Tac Toe Move History");
        this.setSize(300, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(1000,200);
        setDescription();
        this.add(layot, BorderLayout.NORTH);
        this.add(mainhist, BorderLayout.EAST);
        this.add(moves, BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void setDescription(){
        layot.setText("NR   GRACZ \t MAIN POS \t SMALL POS");
        layot.setEditable(false);
    }
    public void addMove(char currentplayer,String mainBoard,String smallBoard){
        moves.append(moveCounter +"       "+String.valueOf(currentplayer) + "\t" + mainBoard + "\t" + smallBoard + "\n");
        moveCounter++;
    }

}
