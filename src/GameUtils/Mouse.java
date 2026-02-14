package GameUtils;

import java.io.Serializable;

public class Mouse implements Serializable {

  private static final long serialVersionUID = 1L;

  public int x = 0;
  public int y = 0;
  public boolean left = false;
  public boolean right = false;
  public boolean middle = false;
  public boolean dragged = false;
}
