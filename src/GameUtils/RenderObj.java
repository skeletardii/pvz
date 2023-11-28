package GameUtils;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

public abstract class RenderObj implements Comparable<RenderObj>{
    public double z_index = 0.0;
    protected Game game;
    private boolean visible = true;
    private boolean children_visible = true;
    private ArrayList<RenderObj> children;
    private RenderObj parent;

    protected void setGame(Game game) {this.game=game;}
    public boolean isVisible() {return visible;}
    public void setVisible(boolean visible) {this.visible = visible;}
    public boolean isChildrenVisible() {return children_visible;}
    public void setChildrenVisible(boolean children_visible) {this.children_visible = children_visible;}
    public ArrayList<RenderObj> getChildren(){return children;}
    public RenderObj getParent(){return parent;}
    public void setParent(RenderObj p){parent=p;}

    public RenderObj(){
        children = new ArrayList<RenderObj>();
    }
    public void add(RenderObj c){
        c.setParent(this);
        c.setGame(game);
        children.add(c);
    }
    public void remove(){
        parent.removeChild(this);}
    public void removeChild(RenderObj c){
        children.remove(c);}
    public int compareTo(RenderObj other){
        return Double.compare(z_index, other.z_index);}
    public void render(Graphics2D g){
        if(visible) paintComponent(g);
        if(children_visible){
            Collections.sort(children);
            for(int i=0; i<children.size(); i++){
                children.get(i).render(g);
            }
        }
    }
    public abstract void paintComponent(Graphics2D g);
}
