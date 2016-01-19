package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/8/2016.
 */
public class While extends LinearGroup {
    private Condition _loop_condition;

    public While( Condition condition, Action[] actions ) {
        super( actions );
        this._loop_condition = condition;
    }

    @Override
    public boolean run() {
        System.out.println( "Here" );
        while( this._loop_condition.active() ) {
            System.out.println( "Here" );
            super.run();
        }
        return true;
    }
}
