package scripts.lib.action.bank;

import org.tribot.api2007.WebWalking;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public class WalkToBankAction extends Action {
    @Override
    public void start() {
        WebWalking.walkToBank();
        super.start();
    }
}
