package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 2/7/2016.
 */
public abstract class RuntimeWhile extends RuntimeLinearGroup {
    private Condition _loop_condition;

    public RuntimeWhile( Condition condition ) {
        this._loop_condition = condition;
    }

    @Override
    public boolean run() {
        while( this._loop_condition.active() ) {
            if( !super.run() ) {
                return false;
            }
        }
        return true;
    }
}
