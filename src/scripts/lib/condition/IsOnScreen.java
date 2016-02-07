package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.types.RSTile;

/**
 * Created by mike on 2/7/2016.
 */
public class IsOnScreen extends Condition {
    private RSTile _positionable;

    public IsOnScreen( RSTile positionable ) {
        this._positionable = positionable;
    }

    @Override
    public boolean active() {
        return _positionable.isOnScreen();
    }
}
