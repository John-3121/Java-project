import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Flappybird extends JPanel implements ActionListener, KeyListener{
    // Board
    int board_width = 360;
    int board_height = 640;

    // Images
    Image top_pipe;
    Image bottom_pipe;
    Image Bird;
    Image Flappy_Bird_Bg;

    //Bird
    int bird_x = board_width / 8;
    int bird_y = board_height / 2;
    int bird_width = 34;
    int bird_height = 24;

    class birdy{
      int x = bird_x;
      int y = bird_y;
      int w = bird_width ;
      int h = bird_height; 
      Image img;
      birdy(Image img){
        this.img = img;
      }
    }
    birdy bird ;
    int velocityY = 0;
    int gravityY = 1;

    Timer gameloop;

    Flappybird() {
        setPreferredSize(new Dimension(360, 640));//need to know
        setFocusable(true);
        addKeyListener(this);
        // load images
        top_pipe = new ImageIcon(getClass().getResource("/toppipe.png")).getImage();
        bottom_pipe = new ImageIcon(getClass().getResource("/bottompipe.png")).getImage();
        Bird = new ImageIcon(getClass().getResource("/flappybird.png")).getImage();
        Flappy_Bird_Bg = new ImageIcon(getClass().getResource("/flappybirdbg.png")).getImage();
        //Bird
        bird = new birdy(Bird);

        // game timer
        gameloop = new Timer(1000/15, this);
        gameloop.start();
    }

    @Override
    public void paintComponent(Graphics g) {//need to know
        super.paintComponent(g); // nee to know
        draw(g);
    }

    public void draw(Graphics g) {
        // draw background
        g.drawImage(Flappy_Bird_Bg, 0, 0, board_width, board_height, null);
        // draw bird (you can uncomment this part if you want to draw the bird)
        g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
    }
    public void move(){
        velocityY = velocityY + gravityY;// make the bird go down 
      
        bird.y = bird.y + velocityY; // move the bird upward
        bird.y = Math.max(bird.y,0); // set the maximum height of bird  to 0
    }

    @Override
    public void actionPerformed(ActionEvent e) {//need to know
        move();
        repaint(); // need to know
    }

   

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE ){
            velocityY =  -8;
        }
    }
    //not needed but if you delete this two method your gonna get an error
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    } 
}
