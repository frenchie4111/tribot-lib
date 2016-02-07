package scripts.lib.action.click;

import org.tribot.api.Clicking;
import org.tribot.api.DynamicClicking;
import org.tribot.api.interfaces.Clickable;
import org.tribot.api.interfaces.Positionable;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public class Click extends Action {
    private Clickable _object;
    private String _option;

    public Click( Clickable object, String option ) {
        super();
        this._object = object;
        this._option = option;
    }

    public Click( String option ) {
        super();
        this._option = option;
    }

    public Click() {
        this( null );
    }

    public Clickable getTarget() {
        return this._object;
    };

    @Override
    public boolean run() {
        if( this._option == null ) {
            return Clicking.click( this.getTarget() );
        } else {
            return Clicking.click( this._option, this.getTarget() );
        }
    }
}
