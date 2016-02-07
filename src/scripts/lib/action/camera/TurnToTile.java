package scripts.lib.action.camera;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Camera;
import scripts.lib.action.Action;

/**
 * Created by mike on 2/7/2016.
 */
public class TurnToTile extends Action {
    private Positionable _tile;

    public TurnToTile( Positionable tile ) {
        this._tile = tile;
    }

    @Override
    public boolean run() {
        Camera.turnToTile( this._tile );
        return true;
    }
}
