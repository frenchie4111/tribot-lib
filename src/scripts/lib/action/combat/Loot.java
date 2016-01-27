package scripts.lib.action.combat;

import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api.types.generic.Filter;
import org.tribot.api2007.Camera;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSGroundItem;
import scripts.lib.action.Action;
import scripts.lib.action.SleepAfter;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/19/2016.
 */
public class Loot extends Action {
    private String _name;

    public Loot( String name ) {
        this._name = name;
    }

    @Override
    public boolean run() {
        RSGroundItem items[] = GroundItems.find( new Filter< RSGroundItem >() {
            @Override
            public boolean accept( RSGroundItem rsGroundItem ) {
                return rsGroundItem.getDefinition().getName().startsWith( _name );
            }
        } );

        final int starting_inventory_length = Inventory.getAll().length;

        if( items.length > 0 ) {
            final RSGroundItem item = ( RSGroundItem ) Antiban.selectTarget( items );

            Camera.turnToTile( item );
            item.click( "Take " + _name );

            Timing.waitCondition( new Condition() {
                @Override
                public boolean active() {
                    return Inventory.getAll().length > starting_inventory_length;
                }
            }, 5000 );

            Antiban.afterActionSleep( 25, 200 );
            return Inventory.getAll().length > starting_inventory_length;
        }

        return false;
    }
}
