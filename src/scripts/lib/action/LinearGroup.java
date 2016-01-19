package scripts.lib.action;

/**
 * Created by mike on 1/6/2016.
 */
public class LinearGroup extends Action {
    private Action[] _actions;

    public LinearGroup() {
        this( new Action[] {} );
    }

    public LinearGroup( Action[] actions ) {
        this._actions = actions;
    }

    @Override
    public boolean run() {
        boolean quit = false;

        for( Action a : this._actions ) {
            System.out.printf( "LinearGroup %S\n", a.toString() );
            if( !a.start() ) {
                quit = true;
                break;
            }
        }

        return !quit;
    }

    public void setActions( Action[] actions ) {
        this._actions = actions;
    }
}
