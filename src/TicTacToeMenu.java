import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeMenu extends JPanel{
    JButton singleplayer = new JButton("Singleplayer");
    JButton multiplayer = new JButton("Multiplayer");
    JRadioButton easy = new JRadioButton("Easy");
    JRadioButton medium = new JRadioButton("Medium");
    JRadioButton hard = new JRadioButton("Hard");
    public TicTacToeMenu(){
        JPanel panelMain = createPanelMain();
        JPanel level = createLevelPanel();
        this.setLayout(new BorderLayout());
        this.add(panelMain, BorderLayout.NORTH);
        singleplayer.addActionListener(e-> {
            this.add(level, BorderLayout.CENTER);
            revalidate();
        });

    }
    public JPanel createPanelMain(){
        JPanel panelMain = new JPanel(new FlowLayout());
        panelMain.add(singleplayer);
        panelMain.add(multiplayer);
        return panelMain;
    }
    public JPanel createLevelPanel(){
        JPanel levelPanel = new JPanel();
        levelPanel.add(easy);
        levelPanel.add(medium);
        levelPanel.add(hard);
        return levelPanel;
    }
}
