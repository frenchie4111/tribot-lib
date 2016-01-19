package scripts.lib.action.bank;

import org.tribot.api2007.WebWalking;
import scripts.lib.action.Action;
import scripts.lib.action.SleepAfter;

/**
 * Created by mike on 1/10/2016.
 */
public class WalkToBank extends SleepAfter {
    @Override
    public boolean run() {
        return WebWalking.walkToBank();
    }
}
