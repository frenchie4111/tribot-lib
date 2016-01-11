package scripts.lib.action.click;

import org.tribot.api.Clicking;
import org.tribot.api.interfaces.Clickable;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public abstract class ClickAction extends Action {
    public abstract Clickable getTarget();

    @Override
    public void start() {
        super.start();
        if( !Clicking.click( this.getTarget() ) ) {
            this.setFail();
        }
    }
}
