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
    
    //pipes
    int pipeX = board_width;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class Pipe{
        int x = pipeX;
        int y = pipeY;
        int w = pipeWidth;
        int h = pipeHeight;
        Image img;
        boolean passed = false;

        
        Pipe(Image img){
           this.img = img;
        }
    }


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
    // game logic
    birdy bird ;
    int velocityX = -4; // move the pipes to the left every frames by 4px
    int velocityY = 0; // move the bird up and down
    int gravityY = 1;

    ArrayList<Pipe> pipes;
    Random random = new Random();

    Timer gameloop;
    Timer placePipesTimer;
    double score = 0 ;
    boolean gameOver = false;

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
        pipes = new ArrayList<Pipe>();

        // place pipes timer
        placePipesTimer = new Timer(3000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                placePipes();
            }
        });
        placePipesTimer.start();

        // game timer
        gameloop = new Timer(1000/15, this);
        gameloop.start();
    }

    public void placePipes(){
        //MATH.RANDOM --> 0-1 * PIPEHEIGHT/2 == 256
        //128
        //0 - 128 -(0-256) >> 1/4PIPEHEIGHT >> 3/4 PIPEHEGIHT
        int randomPipeY = (int) (pipeY - pipeHeight/4 - Math.random() * (pipeHeight/2));
        int openingSpace = board_height/4;

        Pipe topPipe = new Pipe(top_pipe);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottom_pipe);
        bottomPipe.y = topPipe.y + pipeHeight + openingSpace; // the pipe.y is randomizing thas why the bottom pipe is random too
        pipes.add(bottomPipe);



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

        //pipes
        for(int i = 0; i<pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img,pipe.x,pipe.y,pipe.w,pipe.h,null);
        }
        
        //score 
        g.setColor(Color.white);

        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
        }
        else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
         }

         
    public void move(){
        velocityY = velocityY + gravityY;// make the bird go down 
      
        bird.y = bird.y + velocityY; // move the bird upward
        bird.y = Math.max(bird.y,0); // set the maximum height of bird  to 0

        //pipes
        for(int i = 0; i<pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;

            if (!pipe.passed && bird.x > pipe.x + pipe.w){
                pipe.passed = true;
                score += 0.5;
            }
            if (collision(bird, pipe)){
                gameOver = true ;
            }
            
        }

        if(bird.y > board_height){
            gameOver= true; 
        }
    }

    public boolean collision(birdy a, Pipe b) {
        return a.x < b.x + b.w &&   //a's top left corner doesn't reach b's top right corner
               a.x + a.w > b.x &&   //a's top right corner passes b's top left corner
               a.y < b.y + b.h &&  //a's top left corner doesn't reach b's bottom left corner
               a.y + a.h > b.y;    //a's bottom left corner passes b's top left corner
    }


    @Override
    public void actionPerformed(ActionEvent e) {//need to know
        move();
        repaint(); // need to know
        if (gameOver){
            placePipesTimer.stop();
            gameloop.stop();
        }
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