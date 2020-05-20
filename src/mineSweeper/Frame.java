
package mineSweeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.Timer;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Huseyin Muhammed
 *            180541616
 */
public class Frame extends JFrame  implements MouseListener
{     
  
        public static int tile_size = tile.gettile_size();
        public static int tile_num_x =14; //x olarak kiremit
        public static int tile_num_y =14; //y olarak kiremit
        private static int numofbombs=20 ;  // bomba sayisi 
        private static int top = 70; // yukardaki bosluk
    	private static int width = ((tile_size) )* (tile_num_x +1)-20;  //ekran  ağırlığı
	private static int height = (((tile_size) )* (tile_num_y +1))+top+28; //ekran yüksekliği
        private int insetLeft; // inset turkcede ne oldunu bilmiyorum  
	private int insetright;
        private int insettop;
	private int insetbottom;
        private  int widthinset ;
	private  int heightinset;
        private Screen screen ; 
        private gamespace gamespace ; // oyun yeri
        private Font font ;
        private int bomobsnum = numofbombs; 
        private int timestart  =0 ; // zaman bir kere calismak icin 
        private Label amountofbombs; 
        private Label time;
        private String numofbo ; 
        private JButton b ; 
        private boolean marks  ;
        private boolean colors ; 
        
        JTextField t1;
        JTextField t2;
        JTextField t3;
        JButton   g;
        JButton   g2;
                 int sw;
                 int sh ;

        
            //MenuBar
        JMenuBar mb;
        JMenu Game;
        JMenu Help ;
         JMenuItem New ; 
         JMenuItem Beginner ; 
         JMenuItem Intermediate ; 
         JMenuItem Expert;
         JMenuItem Custom ;
         JCheckBoxMenuItem checkmarks ; 
         JCheckBoxMenuItem checkcolors;
         JMenuItem Sound;
         JMenuItem BestTimes;
         JMenuItem Exit;
        //done
 
        
            

 public Frame()
 {
        window() ; // ana ekran 
        labels(); // bomba sayisi , zaman 
       menubar(); // menu 
        button(); // tekrardan oynamak düğme
     
        
       
       
        add(screen);  
        

 }  
  // ana ekran 
private void window()
{      
        this.setTitle("MineSweeper");
        gamespace = new gamespace();
	setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(this);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Yazilim\\NetBeans projects\\icons\\mine.png");  
        this.setIconImage(icon);  
        insetLeft    =  getInsets().left;
        insetright   =  getInsets().right;
        insettop     =  getInsets().top;
        insetbottom  =  getInsets().bottom;
        widthinset   = width + insetLeft + insetright ;
        heightinset  = height + insettop + insetbottom ; 
        pack();
        this.setSize(widthinset, heightinset);
        this.setLocationRelativeTo(null);
        setResizable(false);
        font =  new Font("Trebuchet MS",Font.BOLD,20);

        screen = new Screen() ;
 

}  

// bomba sayisi , zaman 
private void labels()        
{   
    
    
     numofbo = String.valueOf(bomobsnum);
     amountofbombs = new Label();
     amountofbombs.setText(numofbo);
     amountofbombs.setFont(font);
     amountofbombs.setForeground(Color.RED);
     amountofbombs.setAlignment(1);
     amountofbombs.setBackground(Color.black);
     amountofbombs.setBounds(this.getWidth()/2-100,22,50,44);
 
       add(amountofbombs);
 
       
       time = new Label("00");
       time.setFont(font);
       time.setForeground(Color.RED);
       time.setAlignment(1);
       time.setBackground(Color.black);
       time.setBounds(this.getWidth()/2+50,22,50,44);
       add(time);
          
                
         

}


// menu 
public void menubar()
{
         
         mb = new JMenuBar();
         Game = new JMenu("Game");
         Help = new JMenu("Help");

          New = new JMenuItem("New");
          Beginner = new JMenuItem("Beginner");
          Intermediate = new JMenuItem("Intermediate");
          Expert = new JMenuItem("Expert");
          Custom = new JMenuItem("Custom...");
          checkmarks = new JCheckBoxMenuItem("Marks",true);
          checkcolors =  new JCheckBoxMenuItem("Color",true);
          Sound = new JMenuItem("Sound");
          BestTimes = new JMenuItem("BestTimes");
          Exit = new JMenuItem("Exit");
         JMenuItem help = new JMenuItem("Help");
          

         Game.add(New);
         Game.add(Beginner);
         Game.add(Intermediate);
         Game.add(Expert);
         Game.add(Custom);
         Game.add(checkmarks);
         Game.add(checkcolors);
         Game.add(Sound);
         Game.add(BestTimes);
         Game.add(Exit);
         Help.add(help);
         
         mb.add(Game);
         mb.add(Help);
         setJMenuBar(mb);
         
         
                   New.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
                       gamespace.reset();
                        screen.repaint(0, 70,width , height);
                      gamespace.dead =false ;
                       bomobsnum = numofbombs;
        
           
                     
         }
    });
                   Beginner.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             tile_num_x = 9;
             tile_num_y=9;
             numofbombs=10;
             bomobsnum = numofbombs; 
                       width = ((tile_size) )* (tile_num_x +1)-20;
                       height = (((tile_size) )* (tile_num_y +1))+top+28;
                       setSize(width,height);
                       amountofbombs.setBounds(getWidth()/2-100,22,50,44);
                       time.setBounds(getWidth()/2+50,22,50,44);
                       b.setBounds(getWidth()/2-40,25,80,40); 
                       numofbo = String.valueOf(bomobsnum);
                       amountofbombs.setText(numofbo);
                       gamespace.reset();
                       screen.repaint(0, 70,width , height);
                       gamespace.dead =false ;
                           

           
           
                     
         }
    });
                   Intermediate.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             tile_num_x = 16;
             tile_num_y=16;
             numofbombs=40;
             bomobsnum = numofbombs; 
                       width = ((tile_size) )* (tile_num_x +1)-20;
                       height = (((tile_size) )* (tile_num_y +1))+top+28;
                       setSize(width,height);
                       amountofbombs.setBounds(getWidth()/2-100,22,50,44);
                       time.setBounds(getWidth()/2+50,22,50,44);
                       b.setBounds(getWidth()/2-40,25,80,40); 
                       numofbo = String.valueOf(bomobsnum);
                       amountofbombs.setText(numofbo);
                       gamespace.reset();
                       screen.repaint(0, 70,width , height);
                       gamespace.dead =false ;
 
                     
         }
    });
                   Expert.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             tile_num_x = 30;
             tile_num_y=16;
             numofbombs=99;
             bomobsnum = numofbombs; 
                       width = ((tile_size) )* (tile_num_x +1)-20;
                       height = (((tile_size) )* (tile_num_y +1))+top+28;
                       setSize(width,height);
                       amountofbombs.setBounds(getWidth()/2-100,22,50,44);
                       time.setBounds(getWidth()/2+50,22,50,44);
                       b.setBounds(getWidth()/2-40,25,80,40); 
                       numofbo = String.valueOf(bomobsnum);
                       amountofbombs.setText(numofbo);
                       gamespace.reset();
                       screen.repaint(0, 70,width , height);
                       gamespace.dead =false ;


           
                     
         }
    });
                   Custom.addActionListener(new ActionListener() {
         

                    

         @Override
         
         public void actionPerformed(ActionEvent ae) {
           new cotum() ; 
                        
             
        
                
                 
                
                
                                
         }
    });
                   Sound.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             Frame f = new Frame();
                JOptionPane.showMessageDialog(f, "//////            Soon              //////");
                     
         }
    });
                   Exit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
                System.exit(0);
           
                     
         }
    });
                   help.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
              Frame f = new Frame();
                JOptionPane.showMessageDialog(f, "You don't need help, just think a little");
           
                     
         }
    });
                     
                   marks = checkmarks.isSelected();
                   colors = checkcolors.isSelected();
}

    public boolean isColors() {
        return checkcolors.isSelected();
    }

// oyundaki düğme
private void button(){
    Icon icon = new ImageIcon("gfx/flag.png");
         b=new JButton(icon);
        
          b.setBounds(getWidth()/2-40,25,80,40);
          
          
                   add(b);


    b.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
                       gamespace.reset();
                        screen.repaint(0, 70,width , height);
                      gamespace.dead =false ;
                       bomobsnum = numofbombs;
                       
                     
         }
    });




}

public  void clickedr(){
                bomobsnum--;
                
                if(bomobsnum>=0){
                String s  = String.valueOf(bomobsnum);
                amountofbombs.setText(s);}


}

 @Override
 //burda zaman başkatım 
    public void mouseClicked(MouseEvent e)
    {
        //burda zaman başkatım 
        if(timestart==0){new timer();
        
                      
}
         
         timestart++ ; 
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //burda mouse nereye tıkladığını belirledim
        int x = e.getX();
        int y = e.getY();
        //yukarda tiklarsa boşversin
        if(y<132){  
        }
        
        else{
          // sag mi sog dümeyı kulandığını bilmek
       if(e.getButton()== 1)gamespace.clickedLeft(x, y);
       if(e.getButton()== 3)
       {
           gamespace.clickedright(x, y,marks);
              if(marks==true){
               clickedr();}
             
       
       
       }
                // ekrani tekrardan çizsin ve nerye çizsın belirlemek
             screen.repaint(0, 70,width , height);
 
        }
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
 
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static int getTop() {
        return top;
    }

    public static int getTile_num_x() {
        return tile_num_x;
    }

    public static  int getTile_num_y() {
        return tile_num_y;
    }

public static int getScreenWidth()
	{
		return width;
	}

public static  int getScreenHeight()
	{
		return height;
	}

    public static int getNumofbombs() {
        return numofbombs;
    }
    
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Frame().setVisible(true);
                
            }
        });
   }

public class Screen extends JPanel 
        
{


@Override
public void paintComponent(Graphics g)
{
    g.setFont(font);
    gamespace.draw(g);
 
    

}




}

public class timer extends JFrame implements ActionListener{
    Timer t = new Timer(1000,this);
      int i = 0 ;

    public timer()
     {

         t.start();
      }

    String num ; 
        @Override
        public void actionPerformed(ActionEvent ae) {
         i++;
         if(i<9){
         num = "0"+String.valueOf(i);
         
         }
         else{num = String.valueOf(i);}
         time.setText(num);
        }
    




}


 public class cotum extends JFrame {
            cotum(){
   
        setTitle("Custom Field");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Yazilim\\NetBeans projects\\icons\\mine.png");  
        setIconImage(icon);
        setSize(500,300);
        setAlwaysOnTop(true);
        this.setVisible(true);
        setLocationRelativeTo(null);
        
        
         t1 = new JTextField(16); 
        t1.setBounds(160,25,80,40);
        t2 = new JTextField(16); 
        t2.setBounds(160,95,80,40);
         t3 = new JTextField(16); 
        t3.setBounds(160,165,80,40);
        
        
          JLabel l = new JLabel("Height"); 
            l.setBounds(40,20,80,40);
          JLabel l2 = new JLabel("Width"); 
            l2.setBounds(40,90,80,40);
          JLabel l3 = new JLabel("Mines"); 
               l3.setBounds(40,160,80,40);
                JLabel l4 = new JLabel(""); 
            
            
       
        
            g=new JButton();  
          g.setBounds(280,50,80,40);
          g.setText("OK");
             g2=new JButton();  
          g2.setBounds(280,100,80,40);
          g2.setText("Cancel");
                    

          
            
            
            
             
                      add(g);
                      add(g2);
                      add(t3);
                   add(t1);
                   add(t2);
                   
                   add(l);add(l2); add(l3); add(l4);
                    
                    x ();
                   
        

        
        
            }
            
            public void x (){
            
            
            g.addActionListener(new ActionListener() {
              
         @Override
         public void actionPerformed(ActionEvent ae) {  
             tile_num_x = Integer.valueOf(t1.getText());
             tile_num_y=Integer.valueOf(t2.getText());
             numofbombs=Integer.valueOf(t3.getText());
             bomobsnum = numofbombs; 
             
             
                 sw = ((30) )* (tile_num_x +1)-20;
               
               sh  = (((30) )* (tile_num_y +1))+top+28;
                      
                       amountofbombs.setBounds(sw/2-100,22,50,44);
                       time.setBounds(sw/2+50,22,50,44);
                       b.setBounds(sw/2-40,25,80,40); 
                       numofbo = String.valueOf(bomobsnum);
                       amountofbombs.setText(numofbo);
                      gamespace.reset();
                       screen.repaint(0, 70,sw , sh);
                       gamespace.dead =false ;
                   
                       

                       
           
                     
         }
    });
          
          
            
            }
            
            
        }   
}






