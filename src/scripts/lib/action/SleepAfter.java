package scripts.lib.action;

import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/18/2016.
 */
public abstract class SleepAfter extends Action {
    @Override
    public boolean start() {
        boolean return_value = super.start();
        Antiban.afterActionSleep();
        return return_value;
    }
}
