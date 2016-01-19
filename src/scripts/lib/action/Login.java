package scripts.lib.action;

import org.tribot.api.types.generic.Condition;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/6/2016.
 */
public class Login extends Action {
    @Override
    public boolean run() {
        return org.tribot.api2007.Login.login();
    }
}
