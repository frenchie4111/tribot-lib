package scripts.lib.action.ui;

import org.tribot.api.interfaces.Clickable;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;
import scripts.lib.action.Action;
import scripts.lib.action.click.ClickAction;

/**
 * Created by mike on 1/15/2016.
 */
public class ClickUIElement extends ClickAction {
    private int _interface_id;
    private int _child_id;

    public ClickUIElement( int interface_id, int child_id ) {
        super();
        this._interface_id = interface_id;
        this._child_id = child_id;
    }

    @Override
    public Clickable getTarget() {
        return Interfaces.get( this._interface_id, this._child_id );
    }
}
