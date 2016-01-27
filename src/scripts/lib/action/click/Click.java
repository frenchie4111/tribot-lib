package scripts.lib.action.click;

import org.tribot.api.Clicking;
import org.tribot.api.interfaces.Clickable;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public abstract class Click extends Action {
    private String _option;

    public Click( String option ) {
        super();
        this._option = option;
    }

    public Click() {
        this( null );
    }

    public abstract Clickable getTarget();

    @Override
    public boolean run() {
        if( this._option == null ) {
            return Clicking.click( this.getTarget() );
        } else {
            return Clicking.click( this._option, this.getTarget() );
        }
    }
}
