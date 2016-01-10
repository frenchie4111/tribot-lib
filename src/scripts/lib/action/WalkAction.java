package scripts.lib.action;

import org.tribot.api2007.WebWalking;
import scripts.lib.position.Position;
import scripts.lib.position.RandomPosition;

/**
 * Created by mike on 1/6/2016.
 */
public class WalkAction extends Action {
    private Position _target;

    public WalkAction( Position target ) {
        this._target = target;
    }

    public WalkAction( int[] target_coords ) {
        this( new Position( target_coords ) );
    }

    public WalkAction( int[][] target_coords ) {
        this( new RandomPosition( target_coords ) );
    }

    @Override
    public void start() {
        super.start();

        WebWalking.walkTo( this._target.getPosition() );
    }
}
