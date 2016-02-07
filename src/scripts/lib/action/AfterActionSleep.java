package scripts.lib.action;

import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 2/7/2016.
 */
public class AfterActionSleep extends Action {
    @Override
    public boolean run() {
        Antiban.afterActionSleep();
        return true;
    }
}
