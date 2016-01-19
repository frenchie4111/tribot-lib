package scripts.lib.antiban;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api.util.ABCUtil;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSNPC;

public class Antiban extends org.tribot.api.util.ABCUtil {

    private static ABCUtil _abc;

    static {
        _abc = new Antiban();
    }

    public static void afterActionSleep() {
        General.sleep( 200, 1000 );
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


    /**
     * Orders attack targets using ABC. Inspired by: https://github.com/Laniax/LanAPI/blob/master/Game/Antiban/Antiban.java#L103
     * @param npcs
     * @return
     */
    public static RSNPC[] orderTargets( RSNPC[] npcs ) {
        if( npcs.length > 0 ) {
            npcs = NPCs.sortByDistance( Player.getPosition(), npcs );

            if( npcs.length > 1 ) {
                if( _abc.BOOL_TRACKER.USE_CLOSEST.next() ) {
                    // if the 2nd closest npc is within 3 tiles of the closest npc, attack the 2nd one first.
                    if ( npcs[ 0 ].getPosition().distanceTo( npcs[ 1 ] ) <= 3 ) {
                        // Swap
                        RSNPC temp = npcs[ 0 ];
                        npcs[ 1 ] = npcs[0];
                        npcs[ 0 ] = temp;
                    }
                }

                _abc.BOOL_TRACKER.USE_CLOSEST.reset();
            }

            return npcs;
        }

        return npcs;
    }
};