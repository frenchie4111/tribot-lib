package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/8/2016.
 */
public class ConditionalLoopActionGroup extends SequentialActionGroup {
    private Condition _loop_condition;

    public ConditionalLoopActionGroup( Action[] actions, Condition condition ) {
        super( actions );
        this._loop_condition = condition;
    }

    @Override
    public void complete() {
        if( this._loop_condition.active() ) {
            if( this.getDirection() > 0 ) {
                this.setCurrentAction( 0 );
                this.getActions()[ 0 ].start();
            } else {
                this.setCurrentAction( this.getActions().length - 1 );
            }
            this.setRunning();
        } else {
            this.setSuccess();
        }
    }

    @Override
    public void fail() {
        this.complete();
    }
}
