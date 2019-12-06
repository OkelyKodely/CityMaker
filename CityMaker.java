
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dhcho
 */
public class CityMaker {

    public class Img {
        int x, y;
        int width, height;
    }
    
    private Img[] imgs;
    private Image[] img;
    
    private Image policeStation = null;
    private Image house = null;
    private Image library = null;

    private JPanel pp = new JPanel();
    
    private JPanel jp = null;
    private JFrame jf = null;
    
    public CityMaker() {
        imgs = new Img[100];
        img = new Image[100];
        set0();
        set();
        set1();
    }
    
    public void set0() {
        jf = new JFrame("hello");
        jf.setLayout(null);
        jf.setBounds(0, 0, 1200, 700);
        pp.setBounds(0, 0, 1200, 600);
        jf.add(pp);
        jp = new JPanel();
        jp.setBounds(0, 600, 1200, 100);
        jf.add(jp);
        
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    boolean p = false;
    int p2, p3;
    int p4, p5;
    int p6, p7;
    Image tImage1 = null;
    Image tImage2 = null;
    Image tImage3 = null;
    String choi = "";
    int c = 0;
    
    public void set1() {
        Graphics g = pp.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 1200, 600);
        pp.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("pp"+p);
                if(p) {
                    Graphics g = pp.getGraphics();
                    g.setColor(Color.GRAY);
                    g.fillRect(0, 0, 1200, 600);
                    if(choi.equals("police")) {
                        p2 = e.getX();
                        p3 = e.getY();
                        imgs[c-1].x = p2;
                        imgs[c-1].y = p3;
                        System.out.println("sdfa");
                    }
                    if(choi.equals("house")) {
                        p4 = e.getX();
                        p5 = e.getY();
                        imgs[c-1].x = p4;
                        imgs[c-1].y = p5;
                        System.out.println("sdfa");
                    }
                    if(choi.equals("library")) {
                        p6 = e.getX();
                        p7 = e.getY();
                        imgs[c-1].x = p6;
                        imgs[c-1].y = p7;
                        System.out.println("sdfa");
                    }
                    Renderer re = new Renderer();
                    re.draw(img, imgs, g);
                    g.dispose();
                }
            }
        });
        
        pp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                p = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        jp.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX());
                System.out.println(e.getY());
                if(e.getX() <= 0 + 30 && e.getX() >= 0 &&
                   e.getY() <= 0 + 10 + 30 && e.getY() >= 10) {
                    try {
                        tImage1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("police.png"));
                        img[c] = tImage1;
                        imgs[c] = new Img();
                        imgs[c].x = e.getX();
                        imgs[c].y = e.getY();
                        imgs[c].width = 100;
                        imgs[c].height = 100;
                        p = true;
                        choi = "police";
                        System.out.println(p);
                    } catch(Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if(e.getX() <= 0 + 40 && e.getX() >= 10 &&
                   e.getY() <= 0 + 10 + 40 && e.getY() >= 10) {
                    try {
                        tImage2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("house.png"));
                        img[c] = tImage2;
                        imgs[c] = new Img();
                        imgs[c].x = e.getX();
                        imgs[c].y = e.getY();
                        imgs[c].width = 100;
                        imgs[c].height = 100;
                        p = true;
                        choi = "house";
                        System.out.println(p);
                    } catch(Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if(e.getX() <= 0 + 80 && e.getX() >= 50 &&
                   e.getY() <= 0 + 10 + 80 && e.getY() >= 10) {
                    try {
                        tImage3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("library.png"));
                        img[c] = tImage3;
                        imgs[c] = new Img();
                        imgs[c].x = e.getX();
                        imgs[c].y = e.getY();
                        imgs[c].width = 100;
                        imgs[c].height = 100;
                        p = true;
                        choi = "library";
                        System.out.println(p);
                    } catch(Exception e2) {
                        e2.printStackTrace();
                    }
                }
                c++;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //p = false;
            }
        });
    }
    
    public void set() {
        try {
            Graphics g = jp.getGraphics();
            policeStation = ImageIO.read(ClassLoader.getSystemResourceAsStream("police.png"));
            g.drawImage(policeStation, 0, 10, 30, 30, null);
            house = ImageIO.read(ClassLoader.getSystemResourceAsStream("house.png"));
            g.drawImage(house, 40, 10, 30, 30, null);
            library = ImageIO.read(ClassLoader.getSystemResourceAsStream("library.png"));
            g.drawImage(library, 80, 10, 30, 30, null);
            g.dispose();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CityMaker cm = new CityMaker();
    }
    
}
