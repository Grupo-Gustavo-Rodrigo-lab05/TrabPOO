package pt.trabFinal;

import javax.swing.*;
import java.awt.*;

public class JanelaMenu extends JFrame{

    public JanelaMenu(String arquivoImagem) {
        super();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ImageIcon imagemMenu = new ImageIcon(arquivoImagem);
        JLabel campoImagem = new JLabel(imagemMenu);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 100;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(campoImagem, c);

        c.ipady = 0; //Resetar para o default
        c.gridwidth = 0;

        JButton botaoJogar = new JButton("Jogar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(botaoJogar, c);

        JButton botaoHelp = new JButton("Help");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(botaoHelp, c);

        JButton botaoCreditos = new JButton("Créditos");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        contentPane.add(botaoCreditos, c);

        setVisible(true);
    }
}
