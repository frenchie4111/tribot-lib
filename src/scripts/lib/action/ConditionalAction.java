package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/10/2016.
 */
public class ConditionalAction extends Action {
    private Action _action;
    private Condition _condition;
    private boolean _started = false;

    public ConditionalAction( Action action, Condition condition ) {
        super();
        this._action = action;
        this._condition = condition;
    }

    @Override
    public void start() {
        super.start();
        if( this._condition.active() ) {
            this._action.start();
            this._started = true;
        } else {
            this._started = false;
        }
    }

    @Override
    public void updateState() {
        if( this._started ) {
            this._action.updateState();
        }
    }

    @Override
    public ActionStates getState() {
        if( this._started ) {
            return this._action.getState();
        } else {
            return ActionStates.ACTION_STATES_FAIL.ACTION_STATES_SUCCESS;
        }
    }
}
