package scripts.lib.action;

import org.tribot.api2007.WebWalking;
import scripts.lib.position.Position;
import scripts.lib.position.RandomPosition;

/**
 * Created by mike on 1/6/2016.
 */
public class Walk extends Action {
    private Position _target;

    public Walk( Position target ) {
        this._target = target;
    }

    public Walk( int[] target_coords ) {
        this( new Position( target_coords ) );
    }

    public Walk( int[][] target_coords ) {
        this( new RandomPosition( target_coords ) );
    }

    @Override
    public boolean run() {
        return WebWalking.walkTo( this._target.getPosition() );
    }
}
