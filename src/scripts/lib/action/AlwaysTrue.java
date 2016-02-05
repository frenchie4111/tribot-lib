package scripts.lib.action;

/**
 * Created by mike on 1/31/2016.
 */
public class AlwaysTrue extends Action {
    private Action _nested;

    public AlwaysTrue( Action nested ) {
        super();
        this._nested = nested;
    }

    @Override
    public boolean run() {
        this._nested.start();
        return true;
    }
}
