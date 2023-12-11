package GameUtils;

public interface Updater {
  default void updateChildren() {
    if (this instanceof RenderObj) {
      for (int i = 0; i < ((RenderObj) this).getChildren().size(); i++) {
        if (((RenderObj) this).getChildren().get(i) instanceof Updater) {
          (
            (Updater) ((RenderObj) this).getChildren().get(i)
          ).updateWithChildren();
        }
      }
    }
  }

  default void updateWithChildren() {
    updateChildren();
    update();
  }

  public void update();
}
