package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/10/2016.
 */
public class ConditionalAction extends Action {
    private Condition _condition;

    public ConditionalAction( Condition condition ) {
        super();
        this._condition = condition;
    }

    @Override
    public void start() {
        if( this._condition.active() ) {
            super.start();
        }
    }
}
