
package mineSweeper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hussein Mohammed
            180541616
 */
public class tile {
    private BufferedImage bombimage;
    private BufferedImage flagimage ;
    private BufferedImage openedImage;


    private int x ; 
    private int y ; 
    private boolean bomb;
    private boolean opened ;
    private boolean flag ;
    private int amoutofnearBombs ;
    public static int clicked ;
    private BufferedImage normal;
    private int top = Frame.getTop() ; 
    final static int tile_size =30; 
   


 

    public tile(int x , int y  , BufferedImage normal,BufferedImage bomb,BufferedImage flag,BufferedImage openedImage)
    {
        this.x= x ; 
        this.y = y ;
        this.normal = normal;
        this.bombimage = bomb ;
        this.flagimage = flag ; 
        this.openedImage = openedImage;
    
    
    }




    public void setOpened(boolean opened) {
        this.opened = opened;
    }
    
  public boolean isOpened(){
    
        return opened ; 
    
    }
  


    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }
    
    public boolean isBomb(){
    
        return bomb ; 
    
    }

    public void setAmoutofnearBombs(int amoutofnearBombs) {
        this.amoutofnearBombs = amoutofnearBombs;
    }

    public int getAmoutofnearBombs() {
        return amoutofnearBombs;
    }
    public boolean canOpen()
    {
    return !opened &&!bomb&&amoutofnearBombs == 0;
    
    }
    public void placeFlag()
    {
        
        if(flag){ 
            flag = false;
                  }
        else
        {
                       
            if(!opened) {
             
              
                flag =true ;
                
                   
  
            
            } 
        
        }
    
    
    }

    
    public boolean isFlag(){
        return flag ;
    
    }
    public void reset()
    {
    flag = false ; 
    bomb = false ; 
    opened = false ; 
    
    
    
    
    }
    
    
    
    
      public void draw(Graphics g)
    {
        if(!opened)
        {
             
            
            if(!flag){
              
                  g.drawImage(normal, x*tile_size, y*tile_size+top,null);
                  
            }
            else{
                

                g.drawImage(flagimage, x*tile_size, y*tile_size+top,null);
                              

            }
        }
        else 
        {
            g.drawImage(openedImage, x*tile_size, y*tile_size+top,null);
           if(bomb) g.drawImage(bombimage, x*tile_size, y*tile_size+top, null);
           else
           {
               
               if(amoutofnearBombs>0){
                   if(amoutofnearBombs==1)g.setColor(Color.blue);
                   if(amoutofnearBombs==2)g.setColor(Color.GRAY);
                   if(amoutofnearBombs==3)g.setColor(Color.red);

                   
                   g.drawString("" + amoutofnearBombs, x*tile_size+10, y*tile_size+95);
               
               }
           
           }
        }
    }

    public static int gettile_size() {
        return tile_size;
    }


    
    
    
}
