package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;

/**
 * Created by mike on 1/10/2016.
 */
public class IsInterfaceValid extends Condition {
    private int _interface_id;

    public IsInterfaceValid( int interface_id ) {
        this._interface_id = interface_id;
    }

    @Override
    public boolean active() {
        return Interfaces.isInterfaceValid( this._interface_id );
    }
}
