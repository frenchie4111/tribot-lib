package scripts.lib.action;

/**
 * Created by mike on 2/4/2016.
 */
public class Print extends Action {
    private String _string;

    public Print( String string ) {
        super();
        this._string = string;
    }

    @Override
    public boolean run() {
        System.out.println( this._string );
        return true;
    }
}
