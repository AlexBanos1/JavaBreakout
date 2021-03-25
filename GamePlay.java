import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 36;
    private Timer timer;
    private int delay = 8;
    private int playerx = 310;
    private int ballPosx = 120;
    private int ballPosy = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private MapGenerator map;

    public GamePlay() {
        map = new MapGenerator(4, 9);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        //map
        map.draw((Graphics2D)g);

        //borders
        g.setColor(Color.white);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        //score
        g.setColor(Color.white);
        g.setFont(new Font("sans-serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);

        //paddle
        g.setColor(Color.red);
        g.fillRect(playerx, 550, 100, 8);

        //the ball
        g.setColor(Color.red);
        g.fillOval(ballPosx, ballPosy, 20, 20);

        if(totalBricks <= 0) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.green);
            g.setFont(new Font("sans-serif", Font.BOLD, 30));
            g.drawString("You won!", 265, 300);
            g.setFont(new Font("sans-serif", Font.BOLD, 25));
            g.drawString("Score:" + score, 275, 350);

            g.setFont(new Font("sans-serif", Font.BOLD, 20));
            g.drawString("Press ENTER to restart", 230, 400);
        }

        if(ballPosy > 570) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.red);
            g.setFont(new Font("sans-serif", Font.BOLD, 30));
            g.drawString("GAME OVER", 250, 300);
            g.setFont(new Font("sans-serif", Font.BOLD, 25));
            g.drawString("Score: " + score, 275, 350);

            g.setFont(new Font("sans-serif", Font.BOLD, 20));
            g.drawString("Press ENTER to restart", 230, 400);

        }

        g.dispose();
    }
}
