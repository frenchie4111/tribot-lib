package scripts.lib.action.bank;

import org.tribot.api2007.Banking;
import scripts.lib.action.Action;
import scripts.lib.action.SleepAfter;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/10/2016.
 */
public class CloseBank extends SleepAfter {
    @Override
    public boolean run() {
        return  Banking.close();
    }
}
