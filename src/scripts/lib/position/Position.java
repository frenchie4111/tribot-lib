package scripts.lib.position;

import org.tribot.api2007.types.RSTile;

/**
 * Created by mike on 1/6/2016.
 */
public class Position {
    private RSTile _position;

    public Position( int x, int y, int plane ) {
        this._position = new RSTile( x, y, plane );
    }

    public Position( int x, int y ) {
        this( x, y, 0 );
    }

    public Position( int[] coords ) {
        this( coords[ 0 ], coords[ 1 ], ( coords.length > 2 ) ? coords[ 2 ] : 0 );
    }

    public Position( RSTile tile ) {
        // Copy it
        this( tile.getX(), tile.getY(), tile.getPlane() );
    }

    public RSTile updatePosition() {
        // NO-OP for Single Position
        return this._position;
    }

    public RSTile getPosition() {
        return this._position;
    }
}
