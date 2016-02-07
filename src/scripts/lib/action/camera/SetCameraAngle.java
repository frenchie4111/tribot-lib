package scripts.lib.action.camera;

import org.tribot.api2007.Camera;
import scripts.lib.action.Action;

/**
 * Created by mike on 2/7/2016.
 */
public class SetCameraAngle extends Action {
    private int _angle;

    public SetCameraAngle( int angle ) {
        super();

        this._angle = angle;
    }

    public SetCameraAngle( int min_angle, int max_angle ) {
        this._angle = min_angle + ( int )( Math.random() * ( max_angle - min_angle ) );
    }

    @Override
    public boolean run() {
        Camera.setCameraAngle( this._angle );
        return true;
    }
}
