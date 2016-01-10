package scripts.lib.action;

/**
 * Created by mike on 1/6/2016.
 */
public class SequentialActionGroup extends Action {
    private int _current_action = 0;
    private Action[] _actions;
    private int _direction = 1;

    public SequentialActionGroup() {
        this( new Action[] {} );
    }

    public SequentialActionGroup( Action[] actions ) {
        this._actions = actions;
    }

    protected void complete() {
        this.setSuccess();
    }

    protected void fail() {
        this.setFail();
    }

    public void transition() {
        this._current_action += this._direction;

        System.out.printf( "transition %d \n", this._current_action );

        if( ( this._current_action >= this._actions.length && this._direction > 0 ) || ( this._current_action <= 0 && this._direction < 0 ) ) {
            this.complete();
        } else {
            this._actions[ this.getCurrentAction() ].start();
        }
    }

    @Override
    public void start() {
        super.start();

        this._actions[ this.getCurrentAction() ].start();
        this.setRunning();
    }

    @Override
    public void updateState() {
        Action current_action = this._actions[ this.getCurrentAction() ];
        current_action.updateState();

        System.out.println( current_action.toString() );

        switch ( current_action.getState() ) {
            case ACTION_STATES_NOT_STARTED:
            case ACTION_STATES_RUNNING:
                break;
            case ACTION_STATES_SUCCESS:
                this.transition();
                break;
            case ACTION_STATES_FAIL:
                this.fail();
                break;
        }
    }

    public Action[] getActions() {
        return this._actions;
    }

    public void setActions( Action[] actions ) {
        this._actions = actions;
        this._current_action = 0;
    }

    public int getCurrentAction() {
        return this._current_action;
    }

    public void setCurrentAction( int current_action ) {
        this._current_action = current_action;
    }

    public int getDirection() {
        return this._direction;
    }

    public void setDirection( int direction ) {
        this._direction = direction;
    }
}
