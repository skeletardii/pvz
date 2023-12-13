package GameUtils;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

public abstract class RenderObj implements Comparable<RenderObj> {

  private double zIndex = 0.0;
  protected Game game;
  private boolean visible = true;
  private boolean childrenVisible = true;
  private ArrayList<RenderObj> children;
  private RenderObj parent;
  private boolean resort = false;
  private int childrenIndex = 0;

  protected void setGame(Game game) {
    this.game = game;
  }

  public void setZindex(double zIndex) {
    this.zIndex = zIndex;
    if (parent != null) parent.resort();
  }

  public double getZindex() {
    return zIndex;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public boolean isChildrenVisible() {
    return childrenVisible;
  }

  public void setChildrenVisible(boolean children_visible) {
    this.childrenVisible = children_visible;
  }

  public ArrayList<RenderObj> getChildren() {
    return children;
  }

  public RenderObj getParent() {
    return parent;
  }

  public void setParent(RenderObj p) {
    parent = p;
  }

  protected RenderObj() {
    children = new ArrayList<>();
  }

  public void add(RenderObj c) {
    c.setParent(this);
    c.setGame(game);
    children.add(c);
    resort = true;
  }

  public void remove() {
    parent.removeChild(this);
  }

  public void removeChild(RenderObj c) {
    children.remove(c);
    resort();
  }

  @Override
  public int compareTo(RenderObj other) {
    return Double.compare(zIndex, other.zIndex);
  }

  public void render(Graphics2D g) {
    if (resort) {
      resort();
      resort = false;
    }
    if (visible) paintComponent(g);
    //System.out.println("rendering" + this);
    if (childrenVisible && children.size() > 0) {
      for (int i = 0; i < children.size(); i++) {
        children.get(i).render(g);
      }
    }
  }

  public void resort() {
    Collections.sort(children);
    childrenIndex = 0;
    for (int i = 0; i < children.size(); i++) {
      if (zIndex < children.get(i).zIndex) childrenIndex = i;
    }

  }

  public abstract void paintComponent(Graphics2D g);
}
