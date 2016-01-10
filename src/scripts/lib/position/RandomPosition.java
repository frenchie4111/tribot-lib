package scripts.lib.position;

import org.tribot.api2007.types.RSTile;

/**
 * Created by mike on 1/6/2016.
 */
public class RandomPosition extends Position {
    private Position[] _positions;
    private Position _chosen_position;

    public RandomPosition( Position[] positions ) {
        super( 0, 0 ); // Give parent dummy data
    }

    public RandomPosition( int[][] positions ) {
        super( 0, 0 ); // Give parent dummy data

        this._positions = new Position[ positions.length ];
        for( int i = 0; i < positions.length; i++ ) {
            this._positions[ i ] = new Position( positions[ i ][ 0 ], positions[ i ][ 1 ] );
        }

        this.setPositions( _positions );
    }

    private void setPositions( Position[] positions ) {
        this._positions = positions;
        this.updatePosition();
    }

    @Override
    public RSTile updatePosition() {
        int i = ( int )( Math.random() * this._positions.length );
        this._chosen_position = this._positions[ i ];
        return this._chosen_position.getPosition();
    }

    @Override
    public RSTile getPosition() {
        return this._chosen_position.getPosition();
    }
}
