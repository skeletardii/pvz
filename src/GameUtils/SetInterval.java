package GameUtils;

import java.util.Timer;
import java.util.TimerTask;

// maybe ma use ni, para dili na need mag add ug ctr
public class SetInterval {

  private final Timer timer;
  @SuppressWarnings("all")
  private final Runnable fc;

  public SetInterval(int interval, Runnable task) {
    this.timer = new Timer();
    this.fc = task;

    // Schedule the task to run repeatedly with the specified interval
    timer.scheduleAtFixedRate(
      new TimerTask() {
        @Override
        public void run() {
          task.run();
        }
      },
      0,
      interval
    );
  }

  public void stop() {
    // Stop the timer when needed
    timer.cancel();
  }
}
