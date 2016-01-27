package scripts.lib.action.movement;

import org.tribot.api.types.generic.Filter;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Objects;
import org.tribot.api2007.ext.Doors;
import org.tribot.api2007.types.RSObject;
import scripts.lib.action.SleepAfter;

/**
 * Created by mike on 1/21/2016.
 */
public class OpenDoor extends SleepAfter {
    private int[] _door_coords;

    public OpenDoor( int[] door_coords ) {
        super();
        this._door_coords = door_coords;
    }

    @Override
    public boolean run() {
        RSObject[] doors = Objects.find( 20, new Filter< RSObject >() {
            @Override
            public boolean accept( RSObject rsObject ) {
                return ( rsObject.getDefinition().getName().startsWith( "Door" ) &&
                         rsObject.getPosition().getX() == _door_coords[ 0 ] &&
                         rsObject.getPosition().getY() == _door_coords[ 1 ] );
            }
        } );

        if( doors.length < 1 ) {
            return true;
        }

        Camera.turnToTile( doors[ 0 ] );
        return Doors.handleDoor( doors[ 0 ], true );
    }
}
