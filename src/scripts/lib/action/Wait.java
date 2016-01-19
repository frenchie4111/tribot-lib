package scripts.lib.action;

import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/9/2016.
 */
public class Wait extends Action {
    private Condition _condition;
    private int _timeout_min;
    private int _timeout_max;

    public Wait( Condition condition, int timeout_min, int timeout_max ) {
        this._condition = condition;
        this._timeout_min = timeout_min;
        this._timeout_max = timeout_max;
    }

    public Wait( Condition condition ) {
        this( condition, 1000, 1000 );
    }

    public Wait( Condition condition, int timeout ) {
        this( condition, timeout, timeout );
    }

    public Wait( int timeout ) {
        this( new Condition() {
            @Override
            public boolean active() {
                return false;
            }
        }, timeout, timeout );
    }

    public Wait( int timeout_min, int timeout_max ) {
        this( new Condition() {
            @Override
            public boolean active() {
                return false;
            }
        }, timeout_min, timeout_max );
    }

    @Override
    public boolean run() {
        Antiban.waitCondition( this._condition, ( long ) this._timeout_min, ( long ) this._timeout_max );
        return true;
    }
}
