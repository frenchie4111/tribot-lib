package scripts.lib.antiban;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api.types.generic.Condition;
import org.tribot.api.util.abc.ABCUtil;
import org.tribot.api2007.types.RSObject;

public class Antiban extends ABCUtil {

    private static ABCUtil _abc;

    static {
        _abc = new Antiban();
    }

    public static void afterActionSleep( int min, int max ) {
        General.sleep( min, max );
    }

    public static void afterActionSleep() {
        afterActionSleep( 200, 1000 );
    }

    public static boolean waitCondition( Condition condition ) {
        return waitCondition( condition, 1000 );
    }

    public static boolean waitCondition( Condition condition, long timeout ) {
        return Timing.waitCondition( condition, timeout );
    }

    public static boolean waitCondition( Condition condition, long timeout_min, long timeout_max ) {
        double timeout = timeout_min + ( ( timeout_max - timeout_min ) * Math.random() );
        return waitCondition( condition, ( long ) timeout );
    }

    public static Positionable selectTarget( Positionable[] objects ) {
        return _abc.selectNextTarget( objects );
    }
};