package scripts.lib.action;

import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/9/2016.
 */
public class WaitAction extends Action {
    private Condition _condition;
    private int _timeout_min;
    private int _timeout_max;

    public WaitAction( Condition condition, int timeout_min, int timeout_max ) {
        this._condition = condition;
        this._timeout_min = timeout_min;
        this._timeout_max = timeout_max;
    }

    public WaitAction( Condition condition ) {
        this( condition, 1000, 1000 );
    }

    public WaitAction( Condition condition, int timeout ) {
        this( condition, timeout, timeout );
    }

    public WaitAction( int timeout ) {
        this( new Condition() {
            @Override
            public boolean active() {
                return false;
            }
        }, timeout, timeout );
    }

    public WaitAction( int timeout_min, int timeout_max ) {
        this( new Condition() {
            @Override
            public boolean active() {
                return false;
            }
        }, timeout_min, timeout_max );
    }


    @Override
    public void start() {
        super.start();
        double timeout = this._timeout_min + ( ( this._timeout_max - this._timeout_min ) * Math.random() );
        Timing.waitCondition( this._condition, ( long ) timeout );
    }
}
