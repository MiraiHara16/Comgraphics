//นายณัฐพล ใจแก้ว 64050079
//นายนพณรงค์ ปวงคำ 64050125



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.Color;

public class Assignment1_64050125_6405079 extends JPanel {

    public static void main(String[] args) {
        Assignment1_64050125_6405079 m = new Assignment1_64050125_6405079();
        JFrame frame = new JFrame();

        frame.add(m);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Graphics");
    }

    public void plot(Graphics g,int x,int y){
        g.fillRect(x, y, 1, 1);
    }
    


    public void  BezierCurve(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3 ,int x4,int y4){
        for(int i = 0; i <= 1000;i++){
            double t = i/1000.0;

            int x = (int) (Math.pow((1-t),3)*x1 + 3 *t * Math.pow((1-t),2) * x2 + 
            3 * Math.pow(t,2) * (1-t) * x3 + Math.pow(t, 3)*x4);

            int y = (int) (Math.pow((1-t),3)*y1 + 3 *t * Math.pow((1-t),2) * y2 + 
            3 * Math.pow(t,2) * (1-t) * y3 + Math.pow(t, 3)*y4);


            plot(g,x,y);
        }

    }

    public BufferedImage floodFill(BufferedImage m,int x,int y,Color targetColor,Color replacementColor){
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();

        if(m.getRGB(x,y)== targetColor.getRGB()){
          g2.setColor(replacementColor);
          plot(g2, x, y);
          q.add(new Point(x,y));
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            
            //south
            if(p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColor.getRGB()){
              g2.setColor(replacementColor);
              plot(g2, p.x, p.y+1);
              q.add(new Point(p.x,p.y+1));
          }
          //north
          if(p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColor.getRGB()){
              g2.setColor(replacementColor);
              plot(g2, p.x, p.y-1);
              q.add(new Point(p.x,p.y-1));
          }
          //east
          if(p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColor.getRGB()){
              g2.setColor(replacementColor);
              plot(g2, p.x +1, p.y);
              q.add(new Point(p.x + 1,p.y));
          }
          //west
          if(p.x > 0 && m.getRGB(p.x-1, p.y) == targetColor.getRGB()){
              g2.setColor(replacementColor);
              plot(g2, p.x-1, p.y);
              q.add(new Point(p.x -1 ,p.y));
          }
      }
        return m;
    }
    
    public static final Color lightgray = new Color(255,102,102);
    @Override
    public void paintComponent(Graphics g){
        BufferedImage buffer = new BufferedImage(601,601,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);
        // 1 2 3 4
        //BezierCurve(g, จุดแรก, จุดแรก, ตัวโค้งจุดแรก,ตัวโค้งจุดแรก, ตัวโค้งจุดสอง x, ตัวโค้งจุดสอง y,จุดสอง x ,จุดสอง y);
        //first point
        g2.setColor(Color.black);
        BezierCurve(g2, 270, 168, 270, 168, 247, 40, 285,20);

        BezierCurve(g2, 285,20, 285,20,320, 82, 295,145);
        BezierCurve(g2, 295,145,295,145,330,140, 341,150);
        BezierCurve(g2, 341,150,341,150,338,68, 443,61);
        BezierCurve(g2, 443,61,443,61,436,137, 361,168);
        BezierCurve(g2, 361,168,361,168,368,188, 365,206);
        BezierCurve(g2, 365,206,365,206,381,231,368,222);
        BezierCurve(g2, 368,222,368,222,367,226,368,227);
        BezierCurve(g2,368,227,368,227,372,228,370,229);
        //last point face right
        BezierCurve(g2,370,229,370,229,364,229,370,231);

        BezierCurve(g2, 270, 168, 270, 168,261,183,262,191);
BezierCurve(g2,262,191,262,191,251,197,247,198);
BezierCurve(g2,247,198,247,198,255,200,246,201);
BezierCurve(g2,246,201,246,201,251,205,252,206);
BezierCurve(g2,252,206,252,206,249,213,246,211);

//หูขวา
BezierCurve(g2,283,150,283,150,257,115,285,35);
BezierCurve(g2,285,35,285,35,310,85,290,149);
//หูซ้าย
BezierCurve(g2,350,155,350,155,360,72,435,68);
BezierCurve(g2,435,68,435,68,430,135,356,160);


//คิ้ว
BezierCurve(g2,277,176,277,176,287,161,300,166);
BezierCurve(g2,322,171,322,171,346,178,351,190);

//แก้ม
//BezierCurve(g,255,207,255,207,271,197,271,197);

BezierCurve(g2,278,192,278,192,288,188,296,195);
BezierCurve(g2,328,202,328,202,338,198,343,203);


//ตาซ้าย
BezierCurve(g2,274,195,274,195,282,195,284,193);
BezierCurve(g2,284,193,284,193,298,201,294,201);
BezierCurve(g2,294,201,294,201,277,195,270,195);
 

//ตาขวา
BezierCurve(g2,326,206,326,206,337,202,345,208);
BezierCurve(g2,345,208,345,208,326,206,326,206);

//ปาก
BezierCurve(g2,312,215,312,215,300,225,312,227);
BezierCurve(g2,312,227,312,227,341,242,346,230);

BezierCurve(g2,302,216,302,216,316,228,297,225);
BezierCurve(g2,297,225,297,225,261,227,267,216);

//มือ 
BezierCurve(g2,244,212,244,212,256,222,261,221);
BezierCurve(g2,261,221,261,221,273,241,278,242);

BezierCurve(g2,265,235,265,235,283,247,290,245);
BezierCurve(g2,290,245,290,245,295,257,267,247);
BezierCurve(g2,291,248,291,248,309,258,295,258);
BezierCurve(g2,295,258,295,258,279,254,279,251);

BezierCurve(g2,297,257,297,257,304,266,292,262);
BezierCurve(g2,292,262,292,262,270,252,258,245);
BezierCurve(g2,258,245,258,245,219,242,217,220);
BezierCurve(g2,268,250,268,250,272,268,250,244);

BezierCurve(g2,246,214,246,214,237,210,228,202);
BezierCurve(g2,228,202,228,202,155,219,138,219);
BezierCurve(g2,138,219,138,219,101,219,84,257);
BezierCurve(g2,84,257,84,257,83,284,154,315);
BezierCurve(g2,154,315,154,315,164,308,162,264);
BezierCurve(g2,164,267,164,267,154,267,146,263);
BezierCurve(g2,146,263,146,263,123,260,117,264);
BezierCurve(g2,142,263,142,263,205,226,218,225);
BezierCurve(g2,154,315,154,315,153,315,150,315);
BezierCurve(g2,150,315,150,315,165,323,167,323);
BezierCurve(g2,167,323,167,323,186,304,180,269);
g2.drawLine(180,269, 163, 265);
BezierCurve(g2,171,266,171,266,192,249,195,251);
g2.setColor(Color.GRAY);
BezierCurve(g2,195,251,195,251,205,271,217,270);
g2.setColor(Color.black);
BezierCurve(g2,198,254,198,254,212,264,217,257);
BezierCurve(g2,217,257,217,257,237,247,242,272);
g2.drawLine(240,263, 245, 267);

BezierCurve(g2,245,267,245,267,262,320,260,335);
BezierCurve(g2,245,266,245,266,260,264,269,267);
g2.drawLine(264,267, 267, 271);
BezierCurve(g2,271,285,271,285,282,276,279,256);
BezierCurve(g2,265,270,265,270,262,282,296,323);
g2.drawLine(281,260, 290, 313);
g2.drawLine(158,320, 159, 340);
BezierCurve(g2,159, 340,159, 340,177,348,192,348);
BezierCurve(g2,192,348,192,348,192,355,201,355);
BezierCurve(g2,182,348,182,348,192,359,198,362);
BezierCurve(g2,228,443,228,443,155,368,229,317);
BezierCurve(g2,210,415,210,415,218,447,218,445);
g2.drawLine(218,445, 224,454);
g2.drawLine(222,448, 221,467);
BezierCurve(g2,221,467,221,467,161,506,169,568);
BezierCurve(g2,191,543,191,543,158,567,163,598);
BezierCurve(g2,163,597,163,597,177,557,191,551);
g2.drawLine(371,231,364,237);
BezierCurve(g2,348,242,348,242,371,238,383,230);
BezierCurve(g2,383,230,383,230,396,227,403,236);
BezierCurve(g2,403,236,403,236,500,321,484,341);
BezierCurve(g2,484,341,484,341,480,355,460,358);
BezierCurve(g2,460,358,460,358,423,367,423,367);
BezierCurve(g2,423,367,423,367,408,347,423,322);
BezierCurve(g2,423,336,423,366,424,308,418,303);
BezierCurve(g2,418,303,418,303,392,256,384,250);
BezierCurve(g2,390,241,390,241,393,242,372,262);
BezierCurve(g2,372,262,372,262,364,266,355,257);
BezierCurve(g2,355,257,355,257,319,261,319,253);
BezierCurve(g2,319,253,319,253,345,248,348,242);
BezierCurve(g2,361,262,361,262,337,270,332,265);
BezierCurve(g2,332,265,332,265,347,261,346,257);
BezierCurve(g2,340,257,340,257,311,264,302,258);
BezierCurve(g2,302,258,302,258,294,262,305,264);
BezierCurve(g2,305,264,305,264,317,267,333,265);
BezierCurve(g2,323,257,323,257,304,257,302,254);
BezierCurve(g2,302,254,302,254,299,257,304,259);
BezierCurve(g2,304,255,304,255,313,253,319,251);
BezierCurve(g2,325,264,325,264,317,290,339,284);
g2.drawLine(336,285, 350,278);
g2.drawLine(350,278, 360,293);
BezierCurve(g2,419,307,419,307,399,315,405,352);
BezierCurve(g2,405,352,405,352,408,384,422,367);
BezierCurve(g2,354,293,354,293,363,286,376,290);
BezierCurve(g2,376,290,376,290,381,284,389,284);
g2.drawLine(389,284, 398,296);
g2.drawLine(389,299, 412,293);
BezierCurve(g2,367,324,367,324,414,424,358,438);
BezierCurve(g2,371,432,371,432,357,464,348,468);
BezierCurve(g2,350,467,350,467,353,485,348,488);
BezierCurve(g2,347,489,347,489,382,557,383,599);


BezierCurve(g2,349,484,349,484,304,476,300,480);
BezierCurve(g2,300,480,300,480,306,464,302,460);
BezierCurve(g2,302,460,302,460,306,464,302,460);
g2.drawLine(302,460,350,467);
g2.drawLine(222,467,270,475);

BezierCurve(g2,270,475,270,475,264,448,267,455);
g2.drawLine(268,474,300,480);
BezierCurve(g2,268,456,273,456,298,456,302,460);
BezierCurve(g2,222,448,222,448,261,451,271,459);
g2.drawLine(278,461,297,464);
g2.drawLine(297,464,296,474);
//g.drawLine(297,464,276,471);
g2.drawLine(278,461,276,471);
g2.drawLine(276,471,296,474);
BezierCurve(g2,384,378,387,378,398,391,401,388);
BezierCurve(g2,401,388,401,388,414,391,431,365);
BezierCurve(g2,180,307,180,307,205,295,188,282);
BezierCurve(g2,173,319,173,319,210,325,217,319);
BezierCurve(g2,362,287,362,287,341,307,339,327);


g2.drawLine(222,389,241,446);
g2.drawLine(238,430,253,452);
g2.drawLine(257,424,270,454);
BezierCurve(g2,323,459,323,459,347,438,348,428);

BezierCurve(g2,281,563,281,563,331,537,341,500);

//ผ้าผันคอ
BezierCurve(g2,230,318,230,318,242,302,244,272);
BezierCurve(g2,244,272,244,272,242,372,235,376);
BezierCurve(g2,235,376,235,376,292,322,300,328);
BezierCurve(g2,300,328,300,328,325,345,335,378);
BezierCurve(g2,335,378,335,378,346,397,346,398);
BezierCurve(g2,346,398,346,398,374,353,370,305);
BezierCurve(g2,306,322,306,322,390,285,336,283);
g2.drawLine(300,314,321,281);
g2.drawLine(269,279,273,291);
BezierCurve(g2,291,330,291,330,288,343,290,354);

BezierCurve(g2,290,354,290,354,296,354,302,359);
BezierCurve(g2,302,359,302,359,311,342,310,335);
BezierCurve(g2,290,353,290,353,246,361,241,425);
BezierCurve(g2,241,425,241,425,287,407,292,385);
BezierCurve(g2,292,385,292,385,303,359,303,359);
BezierCurve(g2,255,399,255,399,289,356,298,356);



BezierCurve(g2,296,375,296,375,295,426,312,440);
BezierCurve(g2,312,440,312,440,316,450,312,455);
BezierCurve(g2,312,455,312,455,342,427,319,384);
BezierCurve(g2,319,384,319,384,308,360,303,359);
BezierCurve(g2,300,362,300,362,312,415,312,434);
g2.drawLine(296,323, 327,320);
g2.drawLine(283,149, 290,150);
g2.drawLine(350,156, 356,160);
g2.drawLine(267,272, 278,274);


BezierCurve(g2,360,300,360,300,342,345,342,342);


BezierCurve(g2,319,558,319,558,299,564,272,600);
BezierCurve(g2,295,575,295,575,283,585,280,600);
BezierCurve(g2,243,571,243,571,249,575,257,600);
BezierCurve(g2,310,555,310,555,281,573,270,600);
//แก้ม
// BezierCurve(g2,300,362,300,362,312,415,312,434);

//g.drawLine(292,385,303,359);



//g.drawLine(263,279,273,291);
//g.drawLine(268,265,276,277);


//BezierCurve(g,219,500,219,500,219,545,300,328);

g2.drawLine(225,482, 225,504);
g2.drawLine(159,600, 164,593);
g2.drawLine(0,600, 600,600);
BezierCurve(g2,225,504,225,504,234,550,259,549);

//blackgrond
buffer = floodFill(buffer,0,0,Color.WHITE,new Color(249, 247, 247));
buffer = floodFill(buffer,216,248,Color.WHITE,new Color(249, 247, 247));
buffer = floodFill(buffer,378,278,Color.WHITE,new Color(249, 247, 247));

//other
//eye
buffer = floodFill(buffer,283,196,Color.WHITE,new Color(51,51,51));
buffer = floodFill(buffer,336,206,Color.WHITE,new Color(51,51,51));

//แขน
buffer = floodFill(buffer,255,232,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,294,253,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,370,247,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,348,262,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,330,262,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,315,258,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,315,255,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,262,251,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,290,210,Color.WHITE,new Color(255, 250, 241));
buffer = floodFill(buffer,300,285,Color.WHITE,new Color(255, 250, 241));

//หู
buffer = floodFill(buffer,285,120,Color.WHITE,new Color(255, 235, 233));
buffer = floodFill(buffer,390,120,Color.WHITE,new Color(255, 235, 233));


//เงา
buffer = floodFill(buffer,275,276,Color.WHITE,new Color(218, 214, 214));
// buffer = floodFill(buffer,350,286,Color.WHITE,new Color(218, 214, 214));

//เข็มขัด
buffer = floodFill(buffer,245,463,Color.WHITE,new Color(212, 170, 132));
buffer = floodFill(buffer,322,466,Color.WHITE,new Color(212, 170, 132));
buffer = floodFill(buffer,283,463,Color.WHITE,new Color(185, 133, 88));
buffer = floodFill(buffer,300,462,Color.WHITE,new Color(152, 105, 64));
g.drawImage(buffer, 0, 0, null);
    }
   
}