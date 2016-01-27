package scripts.lib.action;

/**
 * Created by mike on 1/26/2016.
 */
public class Unfailable extends Action {
    private Action _action;

    public Unfailable( Action action ) {
        this._action = action;
    }

    @Override
    public boolean run() {
        _action.run();
        return true;
    }
}
