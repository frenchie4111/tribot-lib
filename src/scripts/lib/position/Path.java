package scripts.lib.position;

/**
 * Created by mike on 1/6/2016.
 */
public class Path {
    Position[] _positions;

    public Path( Position[] positions ){
        this._positions = positions;
    }

    /**
     * Creates a path given a 2d array of coords
     *
     * Constructs each pair into a Position object
     *
     * Example:
     * {
     *     { x1, y1 },
     *     { x2, y2 }
     * }
     *
     * Becomes:
     * {
     *     new Position( { x1, y1 } ),
     *     new Position( { x2, y2 } )
     * }
     *
     * @param positions
     */
    public Path( int[][] positions ) {
        this._positions = new Position[ positions.length ];
        for( int i = 0; i < positions.length; i++ ) {
            this._positions[ i ] = new Position( positions[ i ] );
        }
    }

    /**
     * Creates a path given a 3d array of coords.
     *
     * Example:
     * {
     *     { x1_1, y1_1 }, { x1_2, y1_2 }, { x1_3, y1_3 },
     *     { x2_1, y2_1 }, { x2_2, y2_2 }, { x2_3, y2_3 }
     * }
     *
     * Becomes:
     * {
     *     new RandomPosition( { x1_1, y1_1 }, { x1_2, y1_2 }, { x1_3, y1_3 } ),
     *     new RandomPosition( { x2_1, y2_1 }, { x2_2, y2_2 }, { x2_3, y2_3 } )
     * }
     *
     * @param positions
     */
    public Path( int[][][] positions ) {
        this._positions = new Position[ positions.length ];
        for( int i = 0; i < positions.length; i++ ) {
            this._positions[ i ] = new RandomPosition( positions[ i ] );
        }
    }

    public void updatePositions() {
        for( Position position : this._positions ) {
            position.updatePosition();
        }
    }

    public Position[] getPositions() {
        return this._positions;
    }


    public int getClosestPosition( Position other ) {
        Position[] positions = this.getPositions();

        int closest_point = 0;
        int closest_distance = Math.abs( positions[ closest_point ].getPosition().distanceTo( other.getPosition() ) );

        for( int i = 0; i < this._positions.length; i++ ) {
            int i_distance = Math.abs( positions[ i ].getPosition().distanceTo( other.getPosition() ) );

            if( i_distance < closest_distance ) {
                closest_distance = i_distance;
                closest_point = i;
            }
        }

        return closest_point;
    }
}
