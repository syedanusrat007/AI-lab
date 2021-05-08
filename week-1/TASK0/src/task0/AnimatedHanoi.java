
package task0;

/**
 *
 * @author Tonni
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AnimatedHanoi extends JPanel{

static int tower[][];
static int top[];
static int from,to;
static int diskInAir;
static int n,l,b,u;
static Color colors[]={Color.BLUE,Color.CYAN,Color.blue,Color.magenta,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW};

    static void animate() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
public AnimatedHanoi()
{
    tower=new int[3][10];
    top=new int[3];
}

static void push(int to, int diskno)

{
tower[to-1][++top[to-1]]=diskno;
}

static int pop(int from)

{
return(tower[from-1][top[from-1]--]);
}

Color getColor(int disknum)
{
return colors[disknum%8];
}

void drawStill(Graphics g)
{
int j,i,disk;
g.clearRect(0,0,getWidth(),getHeight());
for(j=1;j<=3;j++)
 {

        g.setColor(Color.LIGHT_GRAY);
 g.fillRoundRect(j*l,u,5,b-u,1,1);
        

 for(i=0;i<=top[j-1];i++)
  {
  disk=tower[j-1][i];
                g.setColor(getColor(disk));
  g.fillRect(j*l-15-disk*5,b-(i+1)*10,35+disk*10,10);
  }
 }
}

void drawFrame(Graphics g,int x,int y)
{
try{
drawStill(g);
g.setColor(getColor(diskInAir));
g.fillRect(x-15-diskInAir*5,y-10,35+diskInAir*10,10);
Thread.sleep(60);
}catch(InterruptedException ex){}
}

void animator(Graphics g)

{
int x,y,dif,sign;
diskInAir=pop(from);
x=from*l;
y=b-(top[from-1]+1)*10;

for(;y>u-20;y-=8)
 drawFrame(g, x, y);

y=u-20;
dif=to*l-x;
sign=dif/Math.abs(dif);

for(;Math.abs(x-to*l)>=24;x+=sign*12)
 drawFrame(g, x, y);
x=to*l;

for(;y<b-(top[to-1]+1)*10;y+=8)
 drawFrame(g, x, y);
push(to,diskInAir);
drawStill(g);
}

void moveTopN(Graphics g, int n, int a, int b, int c) throws InterruptedException

        
{
if(n>=1)
 {
 moveTopN(g,n-1,a,c,b);
 drawStill(g);
 Thread.sleep(700);
 from=a;
 to=c;
 
 animator(g);
 moveTopN(g,n-1,b,a,c);
 }
}

public static void Animate()
{

int i;

n=3;
AnimatedHanoi ha=new AnimatedHanoi();

for(i=0;i<3;i++)
 top[i]=-1;


for(i=n;i>0;i--)
 {
 push(1,i);
 }

JFrame fr=new JFrame();
fr.setBackground(Color.BLACK);

fr.setTitle("TOWER OF HANOI");
fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
fr.setLayout(new BorderLayout());
fr.setSize(500,300);
fr.add(ha);
ha.setSize(fr.getSize());
fr.setVisible(true);
l=ha.getWidth()/4;
b=ha.getHeight()-50;
u=b-n*12;

try{
ha.moveTopN(ha.getGraphics(),n,1,2,3);
}catch(Exception ex){}
}

}