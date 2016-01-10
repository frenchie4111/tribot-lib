package scripts.lib.action;

/**
 * Created by mike on 1/6/2016.
 */
public abstract class Action {
    private ActionStates _state;
    private Object _result;

    public void start() {
        this.setRunning();
    }

    public void updateState() {
        this.setSuccess();
    }

    public Action() {
        this._state = ActionStates.ACTION_STATES_NOT_STARTED;
    }

    public void setRunning() {
        this._state = ActionStates.ACTION_STATES_RUNNING;
    }

    public void setSuccess() {
        this._state = ActionStates.ACTION_STATES_SUCCESS;
    }

    public void setFail() {
        this._state = ActionStates.ACTION_STATES_FAIL;
    }

    public ActionStates getState() {
        return this._state;
    }
}
