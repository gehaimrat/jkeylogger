package com.gehaimrat.keyloger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gehaimrat
 * Date: 14.08.13
 * Time: 22:19
 * JKeyLogger simple implementaion for screencasts and presentations.
 */
public class JKeyLogger extends JFrame {
    public JKeyLogger(){
        Container c = this.getContentPane();
        final JLabel jl = new JLabel();
        jl.setFont(new Font("Serif", Font.BOLD, 48));
        jl.setForeground(Color.white);
        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setVerticalAlignment(JLabel.CENTER);
        c.add(jl);
        //For timer
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jl.setText("");
            }
        };

        final Timer timer=new Timer(2000,taskPerformer);

        this.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (jl.getText().length()>0){
                    jl.setText(jl.getText()+"+"+e.getKeyText(e.getKeyCode()));
                }
                else{
                    jl.setText(e.getKeyText(e.getKeyCode()));
                }
                timer.restart();
            }
        });

        Dimension screenDimention = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setBackground(Color.darkGray);
        this.setSize(screenDimention.width, 100);
        this.setLocation(0,screenDimention.height - 80 - 100);
        this.setUndecorated(true);
        this.setVisible(true);

    }
}
