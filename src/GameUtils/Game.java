package GameUtils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.OverlayLayout;
import javax.swing.event.MouseInputListener;

public class Game implements Runnable, Serializable {

  // Serialization vars
  private static final long serialVersionUID = 1L;

  //Option vars
  public static final double TARGET_FPS = 60.0;
  private static final boolean PRINT_FPS = false;

  //Thread vars
  private Thread thread;
  private static final double UPDATE_CAP = 1.0 / TARGET_FPS;
  private boolean running = false;

  //Window vars
  private JFrame frame;
  private JLayeredPane pane;

  //Input vars
  private InputListener inputListener;
  public boolean[] keys;
  public boolean[] keys_prev;
  public Mouse mouse;

  //Collection vars
  public RenderObj renders;
  public ArrayList<Updater> updaters;

  //Constructor
  public Game(JFrame _frame, int sizeX, int sizeY) {
    frame = _frame;

    renders = new RootRenderObj();
    renders.setGame(this);
    updaters = new ArrayList<Updater>();
    updaters.add((Updater) renders);

    pane =
      new JLayeredPane() {
        @Override
        protected void paintComponent(Graphics g) {
          Graphics2D g2d = (Graphics2D) g;
          // g2d.setTransform(
          //   AffineTransform.getScaleInstance(
          //     1.25 * frame.getSize().getWidth() / 814.0,
          //     1.25 * frame.getSize().getHeight() / 637.0
          //   )
          // );
          // System.out.println(frame.getSize().getHeight()); //814,637
          // g2d.setTransform(AffineTransform.getScaleInstance(1, 1));
          g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
          );
          g2d.setRenderingHint(
            RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_SPEED
          );
          renders.render(g2d);
        }
      };
    pane.setPreferredSize(new Dimension(sizeX, sizeY));
    pane.setLayout(new OverlayLayout(pane));
    pane.setBackground(Color.black);
    pane.setOpaque(true);
    frame.add(pane);
    frame.pack();
    frame.setLocationRelativeTo(null);

    inputListener = new InputListener();
    frame.addKeyListener(inputListener);
    pane.addMouseMotionListener(inputListener);
    pane.addMouseListener(inputListener);
    keys = new boolean[256];
    mouse = new Mouse();
  }

  public void add(Object obj) throws IllegalArgumentException {
    if (obj instanceof RenderObj) renders.add((RenderObj) obj); else if (
      obj instanceof Updater
    ) updaters.add((Updater) obj); else throw new IllegalArgumentException(
      "Cannot add non-RenderObj or non-Updater to Game"
    );
  }

  public void remove(Updater obj) throws NoSuchElementException {
    for (int i = 0; i < updaters.size(); i++) {
      if (updaters.get(i) == obj) {
        updaters.remove(i);
        return;
      }
    }
    throw new NoSuchElementException("Object not found in Updater Collection.");
  }

  public void start() {
    thread = new Thread(this);
    Runnable r = new Runnable() { //spooky
      public void run() {
        thread.start();
      }
    };
    new Thread(r).start();
  }

  public void stop() {
    thread.interrupt();
  }

  public void run() { //Main Game Loop
    running = true;
    boolean render = false;
    double firstTime = 0;
    double lastTime = System.nanoTime() / 1000000000.0;
    double passedTime = 0;
    double unprocessedTime = 0;
    double frameTime = 0;
    int frames = 0;
    int fps = 0;

    while (running) {
      render = false;
      firstTime = System.nanoTime() / 1000000000.0;
      passedTime = firstTime - lastTime;
      lastTime = firstTime;
      unprocessedTime += passedTime;
      frameTime += passedTime;

      while (unprocessedTime >= UPDATE_CAP) {
        unprocessedTime -= UPDATE_CAP;
        render = true;
        if (frameTime >= 1.0) {
          frameTime = 0;
          fps = frames;
          frames = 0;
          if (PRINT_FPS) System.out.println("FPS: " + fps);
        }

        //Update inputs:
        keys = inputListener.getKeys();
        mouse = inputListener.getMouse();

        //Update objects:
        for (int i = 0; i < updaters.size(); i++) {
          updaters.get(i).updateWithChildren();
        }
      }
      if (render) {
        frames++;
        //Render new frame:
        pane.repaint();
      } else {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

class InputListener implements KeyListener, MouseInputListener, Serializable {

  private boolean[] keys = new boolean[265];
  private Mouse mouse = new Mouse();

  public void keyPressed(KeyEvent e) {
    keys[e.getKeyCode()] = true;
  }

  public void keyReleased(KeyEvent e) {
    keys[e.getKeyCode()] = false;
  }

  public void mousePressed(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) mouse.left = true;
    if (e.getButton() == MouseEvent.BUTTON2) mouse.middle = true;
    if (e.getButton() == MouseEvent.BUTTON3) mouse.right = true;
  }

  public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON2) mouse.middle = false;
    if (e.getButton() == MouseEvent.BUTTON3) mouse.right = false;
    if (e.getButton() == MouseEvent.BUTTON1) {
      mouse.left = false;
      mouse.dragged = false;
    }
  }

  public void mouseMoved(MouseEvent e) {
    mouse.x = e.getX();
    mouse.y = e.getY();
    mouse.dragged = false;
  }

  public void mouseDragged(MouseEvent e) {
    mouse.x = e.getX();
    mouse.y = e.getY();
    if (mouse.left) mouse.dragged = true;
  }

  public boolean[] getKeys() {
    return keys;
  }

  public Mouse getMouse() {
    return mouse;
  }

  public void keyTyped(KeyEvent e) {}

  public void mouseClicked(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}
}

class RootRenderObj extends RenderObj implements Updater {

  public void update() {}

  public void paintComponent(Graphics2D g) {}
}
