
package mineSweeper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Huseyin Muhammed
 *            180541616
 */
public class gamespace {
    private static int width = Frame.getTile_num_x() ;
    private static int height =  Frame.getTile_num_y() ;
            static int w = Frame.getScreenWidth();
            static int h = Frame.getScreenHeight();
            static int numofbombs = Frame.getNumofbombs();
    
  

    private tile [][] tiles;
    private static int num_of_bombs = Frame.getNumofbombs(); 
    public static boolean finish ;
    public static boolean dead;
    private Random random;
   
     
    
    
    
    private BufferedImage bomb = ImageLoader.scale(ImageLoader.loadImage("gfx/bomb.png"), tile.gettile_size(), tile.gettile_size());
    private BufferedImage flag = ImageLoader.scale(ImageLoader.loadImage("gfx/flag.png"),  tile.gettile_size(), tile.gettile_size());
    private BufferedImage pressed =ImageLoader.scale(ImageLoader.loadImage("gfx/pressed.png"),  tile.gettile_size(), tile.gettile_size());
    private BufferedImage normal = ImageLoader.scale(ImageLoader.loadImage("gfx/normal.png"),  tile.gettile_size(), tile.gettile_size());


	
  
    
    
    
    
    
    public gamespace(){
    random = new Random();
    
    tiles = new tile[width][height];
    
        for(int x = 0 ; x<width;x++){
            for(int y = 0 ; y<height;y++){
                
                tiles [x][y] =new tile(x,y,normal,bomb,flag,pressed);
              
                

            
            }
        }
        reset();

    
    }
    
    private void maines(int num_of_bombs )
    {
        for(int i = 0 ; i<num_of_bombs;i++){
        
        placebomb();
        
        }

}
    private void placebomb()
    {
    
    int x = random.nextInt(width);
    int y = random.nextInt(height);
     
    if(!tiles[x][y].isBomb())
    {
        tiles[x][y].setBomb(true);
    }
    else{placebomb();}
    
    
    }
    private void setNumbers(){
      for(int x = 0 ; x<width;x++){
            for(int y = 0 ; y<height;y++){
                int mx = x - 1 ;
                int gx = x + 1 ; 
                int my = y - 1 ;
                int gy = y + 1 ; 
                
                int amountOfBombs = 0 ; 
                                if(mx >= 0 && my >= 0 && tiles[mx] [my].isBomb()) amountOfBombs++;
                                
				if(mx >= 0&&tiles[mx] [y].isBomb()) amountOfBombs++;
                                
				if(mx >= 0&&gy < height&&tiles[mx] [gy].isBomb()) amountOfBombs++;
                               
				
				if(my >= 0&&tiles[x] [my].isBomb()) amountOfBombs++;
                                
				if(gy < height && tiles[x] [gy].isBomb()) amountOfBombs++;
				
				if(gx < width && my >= 0 &&tiles[gx] [my].isBomb()) amountOfBombs++;
                                
				if(gx < width && tiles[gx] [y].isBomb()) amountOfBombs++;
                                
				if(gx < width && gy < height&&tiles[gx] [gy].isBomb()) amountOfBombs++;
				
				tiles[x] [y].setAmoutofnearBombs(amountOfBombs);
            }
      
      }
    
    }
    public void clickedLeft(int x , int y )
    {
   
        if(!dead&&!finish){
                int tileX = x/30; 
                int tileY =(y-125)/30; 
                if(!tiles[tileX][tileY].isFlag()){
                tiles[tileX][tileY].setOpened(true);
                if(tiles[tileX][tileY].isBomb())
                {

                dead = true ; 
                }
                else{

                if(tiles[tileX][tileY].getAmoutofnearBombs()==0)
                {
                    open(tileX, tileY);
                }
                }
                checkFinish();

                }
        }
    }
    public void clickedright(int x , int y,boolean marks ){
    
            if(!dead&&!finish){

           
                if(marks==true){
                    int tileX = x/30; 
                int tileY =(y-125)/30;
                tiles[tileX][tileY].placeFlag();
                }

            }

                checkFinish();
                

    }
    
    private void open(int x , int y ){
    
           tiles[x] [y].setOpened(true);
           
		if(tiles[x] [y].getAmoutofnearBombs() == 0)
		{
			int mx = x - 1;
			int gx = x + 1;
			int my = y - 1;
			int gy = y + 1;
			

			if(mx >= 0&&my >= 0&&tiles[mx] [my].canOpen()) open(mx, my);
			if(mx >= 0&&tiles[mx] [y].canOpen()) open(mx, y);
			if(mx >= 0&&gy < height&&tiles[mx] [gy].canOpen()) open(mx, gy);
			
		 	if(my >= 0&&tiles[x] [my].canOpen()) open(x, my);
			if(gy < height&&tiles[x] [gy].canOpen()) open(x, gy);
			
			if(gx < width&&my >= 0&&tiles[gx] [my].canOpen()) open(gx, my);
			if(gx < width&&tiles[gx] [y].canOpen()) open(gx, y);
			if(gx < width&&gy < height&&tiles[gx] [gy].canOpen()) open(gx, gy);
                
                }
    
    
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
    
    
    private void checkFinish()
    {
         finish = true ; 
        outer :   for(int x = 0 ; x<width;x++){
                for(int y = 0 ; y<height;y++){
                
                    if(!(tiles[x][y].isOpened()||tiles[x][y].isBomb()&&tiles[x][y].isFlag())){
                    finish = false ;
                   
                   break outer; 
                    
                    }
                }
            
            }
    
        
        
    }
    
public void reset()
    {
        ///////////////// 1 ///////////////////////////////
         gamespace.width = Frame.getTile_num_x() ;
         gamespace.height =  Frame.getTile_num_y() ;
            gamespace.w = Frame.getScreenWidth();
           gamespace.h = Frame.getScreenHeight();
           gamespace.numofbombs=Frame.getNumofbombs();
        ///////////////// 2 //////////////////////////////
            random = new Random();
        tiles = new tile[width][height];
            for(int x = 0 ; x<width;x++){
                for(int y = 0 ; y<height;y++){
                    tiles [x][y] =new tile(x,y,normal,bomb,flag,pressed);
                }
            }
         ////////////////// 3////////////////////////////
        for(int x = 0 ; x<width;x++){
            for(int y = 0 ; y<height;y++){
                tiles[x][y].reset();
            }
    }
   
        
        
        maines(gamespace.numofbombs);
        setNumbers();
       
        
    } 


    public void draw(Graphics g)
    {
    for(int x = 0 ; x<width;x++){
            for(int y = 0 ; y<height;y++){
                
                tiles [x][y].draw(g);
            
            }
        
        
        }
    if(dead)
    {
        
       new gameover().setVisible(true);
   
    }
    
     else   if(finish)
     { 
    
       
       
     }
     
    }
    

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
    
    
    

    
    
    
    
}
