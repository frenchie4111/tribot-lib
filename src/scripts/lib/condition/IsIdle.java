package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Player;

/**
 * Created by mike on 1/21/2016.
 */
public class IsIdle extends Condition {
    @Override
    public boolean active() {
        return Player.getAnimation() == -1;
    }
}
