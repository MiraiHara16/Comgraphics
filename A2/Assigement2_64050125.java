import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Time;
import java.util.*;
public class Assigement2_64050125_64050079 extends JPanel implements Runnable{
    public static void main(String[] args) {   
        Assigement2_64050125_64050079 m = new Assigement2_64050125_64050079();
        JFrame frame = new JFrame();
        frame.add(m);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Graphics");
        (new Thread(m)).start();
    }

    public void ddaLine(Graphics g, int x1 ,int y1,int x2,int y2){
        double dx = x2 - y1;
        double dy = y2 - y1;
        double y,x;
        double m = dy/dx;

        if(m <= 1 && m >= 0){
            y = Math.min(y1,y2);
            for(x =Math.min(x1,x2);x<= Math.max(x1,x2);x++){
            y = y+m;
            plot(g,(int)x,(int)y, 2);
          }
        }
        else if (m >= -1&& m < 0){
            y = Math.max(y1,y2);
              for(x =Math.max(x1,x2);x>= Math.min(x1,x2);x--){
                y = y + m;
                plot(g,(int)x,(int)y, 2);
              }
        }
        else if (m > 1){
           x  = Math.min(x1,x2);
            for(y = Math.min(y1,y2); y <= Math.max(y1,y2); y++){
                x = x + 1 / m;
              plot(g, (int)x, (int)y, 2);
            }
      }
        else{
            x  = Math.max(x1,x2);
            for(y = Math.max(y1,y2); y >= Math.min(y1,y2); y--){
                x += 1 /m;
                plot(g,(int)x,(int)y, 2);
            }
        }
    }
    
    
    public void  BezierCurve2(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3 ,int x4,int y4){
        for(int i = 0; i <= 1000;i++){
            double t = i/1000.0;

            int x = (int) (Math.pow((1-t),3)*x1 + 3 *t * Math.pow((1-t),2) * x2 + 
            3 * Math.pow(t,2) * (1-t) * x3 + Math.pow(t, 3)*x4);

            int y = (int) (Math.pow((1-t),3)*y1 + 3 *t * Math.pow((1-t),2) * y2 + 
            3 * Math.pow(t,2) * (1-t) * y3 + Math.pow(t, 3)*y4);


            plot(g,x,y,3);
        }

    }

    public void  BezierCurve(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3 ,int x4,int y4){
        for(int i = 0; i <= 1000;i++){
            double t = i/1000.0;

            int x = (int) (Math.pow((1-t),3)*x1 + 3 *t * Math.pow((1-t),2) * x2 + 
            3 * Math.pow(t,2) * (1-t) * x3 + Math.pow(t, 3)*x4);

            int y = (int) (Math.pow((1-t),3)*y1 + 3 *t * Math.pow((1-t),2) * y2 + 
            3 * Math.pow(t,2) * (1-t) * y3 + Math.pow(t, 3)*y4);


            plot(g,x,y,1);
        }

    }
    public void  BezierCurve3(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3 ,int x4,int y4){
        for(int i = 0; i <= 1000;i++){
            double t = i/1000.0;

            int x = (int) (Math.pow((1-t),3)*x1 + 3 *t * Math.pow((1-t),2) * x2 + 
            3 * Math.pow(t,2) * (1-t) * x3 + Math.pow(t, 3)*x4);

            int y = (int) (Math.pow((1-t),3)*y1 + 3 *t * Math.pow((1-t),2) * y2 + 
            3 * Math.pow(t,2) * (1-t) * y3 + Math.pow(t, 3)*y4);
            plot(g,x,y,3);
        }

    }
    public void  BezierCurve4(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3 ,int x4,int y4){
        for(int i = 0; i <= 1000;i++){
            double t = i/1000.0;

            int x = (int) (Math.pow((1-t),3)*x1 + 3 *t * Math.pow((1-t),2) * x2 + 
            3 * Math.pow(t,2) * (1-t) * x3 + Math.pow(t, 3)*x4);

            int y = (int) (Math.pow((1-t),3)*y1 + 3 *t * Math.pow((1-t),2) * y2 + 
            3 * Math.pow(t,2) * (1-t) * y3 + Math.pow(t, 3)*y4);


            plot(g,x,y,2);
        }

    }
    public BufferedImage floodFill(BufferedImage m, int x, int y, Color target_colour, Color replacement_colour) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();

        if (new Color(m.getRGB(x, y)).equals(target_colour)) {
            g2.setColor(replacement_colour);
            plot(g2, x, y, 1);
            q.add(new Point(x, y));

        }
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.y < 600 && new Color(m.getRGB(p.x, p.y + 1)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }

            if (p.y > 0 && new Color(m.getRGB(p.x, p.y - 1)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));

            }

            if (p.x < 600 && new Color(m.getRGB(p.x + 1, p.y)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));

            }
            if (p.x > 0 && new Color(m.getRGB(p.x - 1, p.y)).equals(target_colour)) {
                g2.setColor(replacement_colour);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));

            }
        }
        return m;
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);

    }
    double swordlightx =400; 
    double swordlighty =203;
    double waterx = 20;
    @Override
    public void run(){
        double lastTime = System.currentTimeMillis();
        double currentTime,elapsedTime;
        while(true){
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;
            // velocityY += 9.81 *elapsedTime /1000.0;

            //logic
            for (int i = 0; i < 50; i++) {
                RD[i] += 150 * elapsedTime /1000.0;
                if(RD[i] >= 600)RD[i]=0;
            }

            if(swordlightx > 255){
                swordlightx -=50*elapsedTime/1000;
            }
            if(swordlighty < 405){
                swordlighty += 74*elapsedTime/1000;
            }
            if(swordlightx <= 255 && swordlighty >= 400){
                swordlightx = 400; 
                swordlighty = 203;
                
            }
           

            if(waterx < 392){
                waterx += 50*elapsedTime/1000;
            }


            //เช็คขอบ
            repaint();
        }
    }


    Random rd;
    int n;

    static int[] R0x = new int[50];
    static float[] RD = new float[50];
    Assigement2_64050125_64050079(){
        rd = new Random();
        n =50;
        
        for(int i =0;i<n;i++){
            int temp = rd.nextInt(600);
            int temp2 = rd.nextInt(600)-600;
            R0x[i] = temp;
            RD[i] = temp2;    
        }
        
        
    }


    public void paintComponent(Graphics g){
        BufferedImage buffer0 = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer0.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600); 

        //เส้นอขอบทะเล
        g2.setColor(new Color(95,110,186));
        g2.drawLine(0,483, 600, 483);

        //เงาทะเล
        g2.setColor(new Color(82,97,173));
        g2.drawLine(300,600, 600, 510);
        

        //เคลื่อนทะเล

          ////ฝั่งขวา
        BezierCurve3(g2,392,577, 392,577,438,548,473,549);
        ddaLine(g2, 488,530,541,530);
        ddaLine(g2, 543,522,568,522);
        ddaLine(g2, 581,517,535,517);
        ddaLine(g2, 464,552,427,552);
        ddaLine(g2, 400,557,450,557);

          ////ฝั่งซ้าย
        ddaLine(g2, 127,494,182,494);
        ddaLine(g2, 131,505,156,505);
        ddaLine(g2, 156,502,180,502);
        ddaLine(g2, 90,503,120,503);

          ////ฝั่งกลาง
          BezierCurve2(g2, 383,535,383,535,414, 518,412,510);
          BezierCurve2(g2, 383,535,383,535,448, 500,464,513);
          BezierCurve2(g2, 315,512,315,512,385, 510,393,503);
          BezierCurve2(g2, 225,502,225,502,294, 526,320,523);
          //ฟ้าชั้น 1
        g2.setColor(new Color(255,227,246));
        int skyx1[] = {0,15,30,68,73,92,123,150,180,245,269,273,329,393,396,474,475,553,554,593,600};
        int skyy1[] = {438,438,442,441,443,441,447,448,449,446,446,458,458,455,466,468,471,473,477,477,472};
        g2.drawPolyline(skyx1, skyy1,21);

        //ฟ้าชั้น 2
        g2.setColor(new Color(164,178,222));
        int skyx2[] ={0,6,22,23,42,152,186,267,293,328,420,425,451,462,500,525,537,542,530,539,556,572,593,600};
        int skyy2[] ={243,248,248,262,259,267,270,278,286,283,286,291,290,297,303,302,296,297,283,285,297,300,300,305};
        g2.drawPolyline(skyx2, skyy2,24);
        
        BezierCurve2(g2,147,248, 147,248, 182, 282,203,276);

        //เมฆธรรมดา
        g2.setColor(new Color(245,195,206));
        int skyx3[] ={0,5,21,33,55,73,88,103,121,126,126,100,75,70,56,42,57,74,49,33,36,57,57,24,0};
        int skyy3[] ={36,28,42,42,51,49,44,44,47,45,41,37,30,38,40,36,30,21,20,23,16,16,10,9,15};
        g2.drawPolygon(skyx3, skyy3,25);

        BezierCurve3(g2,78,4, 78,4, 107,32, 152,21);
        BezierCurve3(g2,0,170, 0,170, 31,172, 48,200);

        BezierCurve3(g2,10,382, 10,382, 55, 381,54, 392);
        BezierCurve2(g2,12,390, 12,390, 46, 384,49, 387);
        ddaLine(g2,42,434, 87,428);

        //เมฆธรรมดา2
        g2.setColor(new Color(245,195,206));
        int skyx4[] ={188,204,204,231,230,249,248,241,225,209,199,198,187};
        int skyy4[] ={233,231,237,237,233,234,232,228,224,210,209,213,214};
        g2.drawPolygon(skyx4, skyy4,13);

        int skyx5[] ={600,600,596,596,596,590,593,578};
        int skyy5[] ={426,415,415,413,413,413,421,421};
        g2.drawPolygon(skyx5, skyy5,8);

        int skyx6[] ={495,495,486,486,455,452,461};
        int skyy6[] ={453,448,448,446,446,451,451};
        g2.drawPolygon(skyx6, skyy6,7);
        
        g2.setColor(new Color(144,166,214));
        BezierCurve2(g2,235,335, 235,335, 278, 335,279,326);
        //เมฆเคบื่อนไหว

        buffer0 = floodFill(buffer0,265,503,Color.WHITE,new Color(95,110,186));
        buffer0 = floodFill(buffer0,580,540,Color.WHITE,new Color(82,97,173));
        buffer0 = floodFill(buffer0,585,295,Color.WHITE,new Color(144,166,214));
        buffer0 = floodFill(buffer0,585,360,Color.WHITE,new Color(164,178,222));
        buffer0 = floodFill(buffer0,585,481,Color.WHITE,new Color(255,227,246));
        buffer0 = floodFill(buffer0,20,30,Color.WHITE,new Color(245,195,206));
        buffer0 = floodFill(buffer0,190,222,Color.WHITE,new Color(245,195,206));
        buffer0 = floodFill(buffer0,590,422,Color.WHITE,new Color(245,195,206));
        buffer0 = floodFill(buffer0,475,450,Color.WHITE,new Color(245,195,206));
        g.drawImage(buffer0, 0, 0, null);


        BufferedImage buffer1 = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g1 = buffer1.createGraphics();
        g1.setColor(new Color(255,227,246,0));
        g1.fillRect(0, 0, 600, 600); 

        //ตึก 1
        g1.setColor(new Color(95,110,186));
        int bildx1[] ={182,182,180,179,183,182,177,177,174,174,180,180,177,177,174,174,171,171,179,185,185,180,180,184,185,187,187,190,214,214,202,214,214,217,220,220,222,222,227,232,238,241};
        int bildy1[] ={487,472,470,448,448,442,443,419,419,395,395,369,368,347,347,315,315,296,297,291,262,262,257,257,245,246,262,275,305,310,314,315,330,330,330,378,380,393,393,428,455,487};
        g1.drawPolygon(bildx1, bildy1, 42);

        //ตึก 2
        // int bildx2[] ={182,182,180,179,183,182,177,177,174,174,180,180,177,177,174,174,171,171,179,185,185,180,180,184,185,187,187,190,214,214,202,214,214,217,220,220,222,222,227,232,238,241};
        // int bildy2[] ={487,472,470,448,448,442,443,419,419,395,395,369,368,347,347,315,315,296,297,291,262,262,257,257,245,246,262,275,305,310,314,315,330,330,330,378,380,393,393,428,455,487};
        // for(int i = 0 ; i < bildx2.length;i++){
        //     bildx2[i] += 200; 
        //     bildy2[i] += 100; 
        // }
        // g1.drawPolygon(bildx2, bildy2, 42);

        //ตึก 3
        int bildx3[] ={90,90,98,98,104,104,110,110,119,119,135,138};
        int bildy3[] ={486,446,448,438,436,420,420,452,453,476,483,486};
        g1.drawPolygon(bildx3, bildy3,12);
       
        //หน้าต่าง 1
        g1.setColor(new Color(163,158,206));
        ddaLine(g1, 177,402,187,402);
        ddaLine(g1, 179,416,188,412);
        ddaLine(g1,186,444,215,430);
        g1.drawLine(102,462,109,462);
        ddaLine(g1,181,370,195,370);
        //ddaLine(g1,215,448,233,404);
        ddaLine(g1,100,481,105,481);

        g1.drawLine(410,400,394,404);


        buffer1 = floodFill(buffer1,205,420,Color.black,new Color(95,110,186));
        //buffer1 = floodFill(buffer1,400,405,Color.black,new Color(95,110,186));
        buffer1 = floodFill(buffer1,105,460,Color.black,new Color(95,110,186));
        g.drawImage(buffer1, 0, 0, null);






        BufferedImage buffer2 = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g3 = buffer2.createGraphics();

        g3.setColor(new Color(255,255,255,0));
        g3.fillRect(0, 0, 600, 600);
        //ตัวคน
        g3.setColor(new Color(57, 48,120));
        BezierCurve(g3, 282,536, 282,536,297,435,308,421);
        BezierCurve(g3, 308,421, 308,421,316,392,290,404);
        BezierCurve(g3, 290,404, 290,404,268,410,277,389);
        BezierCurve(g3, 277,389, 277,389,283,353,329,301);
        BezierCurve(g3, 329,301, 329,301,331,258,322,263);
        BezierCurve(g3, 322,263, 322,263,307,287,309,296);
        BezierCurve(g3, 309,296, 309,296,290,307,298,273);
        BezierCurve(g3, 298,273, 298,273,310,236,303,238);
        BezierCurve(g3, 303,238, 303,238,310,215,320,215);
        BezierCurve(g3, 320,215, 320,215,331,222,335,222);
        BezierCurve(g3, 335,222, 335,222,343,223,343,213);
        BezierCurve(g3, 343,213, 343,213,355,202,363,216);
        BezierCurve(g3, 363,216, 363,216,362,222,363,224);
        BezierCurve(g3, 363,224, 363,224,407,203,401,236);
        BezierCurve(g3, 401,236, 401,236,377,284,390,291);
        BezierCurve(g3, 390,291, 390,291,381,298,370,278);
        BezierCurve(g3, 370,278, 370,278,360,281,365,305);
        BezierCurve(g3, 365,305, 365,305,376,315,379,327);
        BezierCurve(g3, 379,327, 379,327,379,345,387,349);
        BezierCurve(g3, 387,349, 387,349,400,371,398,390);
        BezierCurve(g3, 398,390, 398,390,393,411,381,415);
        BezierCurve(g3, 381,415, 381,415,377,397,369,422);
        BezierCurve(g3, 369,422, 369,422,380,493,372,532);
        BezierCurve(g3, 372,532, 372,532,366,558,367,576);
        BezierCurve(g3, 367,576, 367,576,353,579,353,573);   
        BezierCurve(g3, 355,575, 355,573,366,405,336,415);
        BezierCurve(g3, 336,415, 336,415,301,480,300,540);
        BezierCurve(g3, 300,540, 300,540,282,536,282,536);

        //แขน
        g3.setColor(new Color(107, 100,157));
        BezierCurve(g3, 297,295, 297,295,295,327,297,343);
        BezierCurve(g3, 307,297, 307,297,304,327,306,330);

        BezierCurve(g3, 377,287, 377,287,376,316,377,324);
        BezierCurve(g3, 386,293, 386,293,387,349,387,349);

        //รายละเอียดตัว
        BezierCurve(g3, 281,405, 281,405,300,400,303,392);
        BezierCurve(g3, 303,392, 303,392,303,401,306,403);
        BezierCurve(g3, 370,425, 370,425,377,416,382,417);
        
         //วงกรม
        // g3.setColor(new Color(108, 84,143));
        // g3.drawOval(342, 248,50, 50);


        buffer2 = floodFill(buffer2,345,225,Color.black,new Color(57, 48,120));
        buffer2 = floodFill(buffer2,300,399,Color.black,new Color(107, 100,157));
        buffer2 = floodFill(buffer2,378,414,Color.black,new Color(107, 100,157));
        buffer2 = floodFill(buffer2,380,314,Color.black,new Color(107, 100,157));
        buffer2 = floodFill(buffer2,300,314,Color.black,new Color(107, 100,157));

        g.drawImage(buffer2, 0, 0, null);
        






        BufferedImage buffer3 = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g4 = buffer3.createGraphics();

        g4.setColor(new Color(255,255,255,0));
        g4.fillRect(0, 0, 600, 600);

        g4.setColor(new Color(107, 100,157));
        int swordx[] = {419,236,236,425};
        int swordy[] = {182,427,443,191};
        g4.drawPolygon(swordx,swordy,4);
        g4.drawLine(390,221,398,211);
        
        
        //ปลอกดาบ
        BezierCurve(g4,386,242, 386,242,345,365,345,365);
        BezierCurve(g4,345,365, 345,365,355,361,371,315);
        BezierCurve(g4,371,315, 371,315,401,224,401,224);
       
        //ขอบด้ามดาบ
        g4.setColor(new Color(66, 56,139));
        int sowx[] ={403,385,392,399,403,406,409,409,415,416,416};
        int sowy[] ={203,214,195,193,171,171,180,148,147,166,185};
        g4.drawPolygon(sowx,sowy,11);

       
        //ด้ามดาบ
        g4.setColor(new Color(107,100,157));
        int ddx[] ={417,416,476,483};
        int ddy[] ={183,164,77,83};
        g4.drawPolygon(ddx,ddy,4);
        g4.drawLine(416,186,423,174);
        g4.drawLine(468,91,477,72);


        //หัวด้ามดาบ
        g4.setColor(new Color(57,48,120));
        int bx[] = {476,478,490,490,483};
        int by[] = {77,65,63,77,83};
        g4.drawPolygon(bx,by,5);


       //หัว
       g4.setColor(new Color(107,100,157));
       BezierCurve(g4,341,218, 341,218,343,201,376,212);
       BezierCurve(g4,376,212, 376,212,412,183,376,158);
       BezierCurve(g4,376,158, 376,158,339,128,322,176);
       BezierCurve(g4,322,176, 322,176,315,203,341,218);

       BezierCurve(g4,323,175, 323,175,328,190,341,190);
       BezierCurve(g4,341,190, 341,190,329,159,343,150);
       
       //หญ้า
       g4.setColor(new Color(54,75,89));
       BezierCurve2(g4,144,545, 144,545, 154,540,155,529);
       BezierCurve2(g4,155,529, 155,529, 153,545,157,544);
       BezierCurve2(g4,157,540, 157,540, 167,527,164,522);
       BezierCurve2(g4,486,600, 486,600, 510,562,503,553);
       BezierCurve2(g4,495,588, 495,588, 491,578,492,569);

       

       buffer3 = floodFill(buffer3,392,228,Color.black,new Color(107, 100,157));
       buffer3 = floodFill(buffer3,402,183,Color.black,new Color(49,40,119));
       buffer3 = floodFill(buffer3,462,100,Color.black,new Color(137, 131,179));
       buffer3 = floodFill(buffer3,480,75,Color.black,new Color(57, 48,120));
       buffer3 = floodFill(buffer3,356,181,Color.black,new Color(107, 100,157));
       buffer3 = floodFill(buffer3,328,172,Color.black,new Color(57, 48,120));
       buffer3 = floodFill(buffer3,360,330,Color.black,new Color(98, 90,154));
       g.drawImage(buffer3, 0, 0, null);



       BufferedImage buffer4 = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
       Graphics2D g5 = buffer4.createGraphics();
       g5.setColor(new Color(255,227,246,0));
       g5.fillRect(0, 0, 600, 600); 
       
       
       //อนเมชั่นดาบ
       g5.setColor(Color.white);
       g5.drawLine(400,220,(int)swordlightx,(int)swordlighty);
       BezierCurve(g5, 400, 220, 400, 220, (int)swordlightx,(int)swordlighty, (int)swordlightx,(int)swordlighty);
        
       //ปลอกดาบ
        g5.setColor(new Color(255,228,246));
        int sworderx[]={441,445,417,407,391,385,404,414};
        int swordery[]={198,194,167,167,150,152,171,171};
        g5.drawPolygon(sworderx, swordery,8);

        //จุดดาบ
        g5.setColor(new Color(57,48,120));
        g5.drawLine( 434,153, 429,153);
        g5.drawLine( 437,145, 433,145);
        g5.drawLine( 446,136, 439,136);
        g5.drawLine( 473,93, 468,93);
        g5.drawLine( 467,105, 460,105);
        g5.drawLine( 451,119, 458,119);

        //ดิน
       g5.setColor(new Color(53,54,86));
       BezierCurve(g5,0,490,0,490, 25,458, 110,516);
       BezierCurve(g5,110,516,110,516, 132,515, 146,536);
       BezierCurve(g5,146,536,146,536, 225,521, 229,541);
       BezierCurve(g5,229,541,229,541, 289,526, 318,541);
       BezierCurve(g5,318,541,318,541, 438,577, 455,590);
       BezierCurve(g5,455,590,455,590, 493,571, 509,580);
       BezierCurve(g5,509,580,509,580, 528,561, 552,567);
       BezierCurve(g5,552,567,552,567, 590,550, 600,560);
       
       
       //ลายหิน
       g5.setColor(new Color(60,61,105));
       BezierCurve2(g5, 5, 491,5, 491,27,488,29,485);
       BezierCurve2(g5, 29,485,29,485,75,500,85,498);
       ddaLine(g5, 0,501,5,490);
       BezierCurve2(g5, 94,506,94,506,128,542,147,537);
       BezierCurve2(g5, 187,530,187,530,155,540,146,553);
       BezierCurve2(g5, 146,553,146,553,146,543,165,542);
       BezierCurve2(g5, 165,542,165,542,185,547,201,542);
       BezierCurve2(g5, 201,542,201,542,239,566,257,537);
       BezierCurve2(g5, 342,571,342,571,387,580,381,595);
       BezierCurve2(g5, 600,550,600,550,576,545,532,585);


       //หญ้า

       buffer4 = floodFill(buffer4,590,590,Color.black,new Color(53,54,86));
       buffer4 = floodFill(buffer4,126,525,Color.black,new Color(60,61,105));
       buffer4 = floodFill(buffer4,20,485,Color.black,new Color(60,61,105));
       buffer4 = floodFill(buffer4,225,540,Color.black,new Color(60,61,105));
       buffer4 = floodFill(buffer4,595,555,Color.black,new Color(60,61,105));
       buffer4 = floodFill(buffer4,160,537,Color.black,new Color(60,61,105));

       //rain 
       Graphics2D gRain = (Graphics2D) g;
       gRain.setColor(new Color(187 ,208 ,250));
      for (int i = 0; i < R0x.length; i++) {
       gRain.fillRect(R0x[i], (int)RD[i], 1, 10);
       //gRain.fillOval(R0x[i], (int)RD[i], 7, 7); 
          }

        //วงกลม
        
       g.drawImage(buffer4, 0, 0, null);


       BufferedImage buffer5 = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
       Graphics2D g6 = buffer5.createGraphics();
       g6.setColor(new Color(255,227,246,0));
       g6.fillRect(0, 0, 600, 600); 
   
       g6.setColor(new Color(108,84,143));
       g6.drawRoundRect(330, 243,36,36,38,30);
       g6.drawRoundRect(330, 243,30,30,32,24);


       
       buffer5 = floodFill(buffer5,345,275,Color.black,new Color(248,209,235));

       g.drawImage(buffer5, 0, 0, null);
    }

    
}