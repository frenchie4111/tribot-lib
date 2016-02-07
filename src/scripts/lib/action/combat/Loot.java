package scripts.lib.action.combat;

import org.tribot.api.Timing;
import org.tribot.api.interfaces.Clickable;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Camera;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSGroundItem;
import scripts.lib.action.*;
import scripts.lib.action.camera.TurnToTile;
import scripts.lib.action.click.Click;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/19/2016.
 */
public class Loot extends RuntimeLinearGroup {
    private String _name;

    public Loot( String name ) {
        this._name = name;
    }

    @Override
    public Action[] getActions() {
        RSGroundItem items[] = GroundItems.find( this._name );
        if( items.length <= 0 ) return new Action[] {};

        final int starting_inventory_length = Inventory.getAll().length;

        final RSGroundItem target_item = ( RSGroundItem ) Antiban.selectTarget( items );

        return new Action[] {
            new TurnToTile( target_item ),
            new Click( target_item, "Take " + this._name ),
            new Wait( new Condition() {
                @Override
                public boolean active() {
                    return Inventory.getAll().length > starting_inventory_length;
                }
            }, 5000 ),
            new AfterActionSleep()
        };
    }
}
