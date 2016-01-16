package scripts.lib.action;

import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/9/2016.
 */
public class WaitAction extends Action {
    private Condition _condition;
    private int _timeout;

    public WaitAction( Condition condition, int timeout ) {
        this._condition = condition;
        this._timeout = timeout;
    }

    public WaitAction( Condition condition ) {
        this( condition, 1000 );
    }

    @Override
    public void start() {
        super.start();
        Timing.waitCondition( this._condition, this._timeout );
    }
}
