package scripts.lib.action.click;

import org.tribot.api.Clicking;
import org.tribot.api.interfaces.Clickable;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public abstract class Click extends Action {
    public abstract Clickable getTarget();

    @Override
    public boolean run() {
        return Clicking.click( this.getTarget() );
    }
}
