package scripts.lib.action;

/**
 * Created by mike on 1/21/2016.
 */
public class OnFail extends Action {
    private Action _action;
    private Action _on_fail;

    public OnFail( Action action, Action on_fail ) {
        super();
        this._action = action;
        this._on_fail = on_fail;
    }

    @Override
    public boolean run() {
        return this._action.run();
    }

    @Override
    public boolean start() {
        if( !super.start() ) {
            return this._on_fail.start();
        }
        return true;
    }
}
