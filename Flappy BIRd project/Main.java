import javax.swing.JFrame;

public class Main {
    public static void main(String []args){
      JFrame frame = new JFrame("Flappy bird");
    //  frame.setVisible(true);
     // frame.setSize(360, 640);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //  frame.setLayout(null);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      
      Flappybird flappybird = new Flappybird();
      frame.add(flappybird);
      frame.pack();
      flappybird.requestFocus();
      frame.setVisible(true);


    }
}
