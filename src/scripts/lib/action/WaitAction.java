package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/9/2016.
 */
public class WaitAction extends Action {
    private Condition _condition;

    public WaitAction( Condition condition ) {
        this._condition = condition;
    }

    @Override
    public void updateState() {
        if( this._condition.active() ) {
            this.setSuccess();
        }
    }
}
