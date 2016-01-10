package scripts.lib.action;

import scripts.lib.position.Path;
import scripts.lib.position.Position;

/**
 * Created by mike on 1/6/2016.
 */
public class PathWalkAction extends SequentialActionGroup {
    private Path _path;

    public PathWalkAction( Path path ) {
        this._path = path;

        Position[] positions = path.getPositions();
        Action[] walk_actions = new Action[ positions.length ];
        for( int i = 0; i < positions.length; i++ ) {
            walk_actions[ i ] = new WalkAction( positions[ i ] );
        }

        this.setActions( walk_actions );
    }

    public PathWalkAction( int[][] path ) {
        this( new Path( path ) );
    }

    public PathWalkAction( int[][][] path ) {
        this( new Path( path ) );
    }

    public void setCurrentToClosest( Position other ) {
        this.setCurrentAction( this._path.getClosestPosition( other ) );
    }
}
