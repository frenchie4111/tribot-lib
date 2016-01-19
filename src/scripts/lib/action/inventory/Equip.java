package scripts.lib.action.inventory;

import org.tribot.api.Clicking;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.lib.action.Action;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/10/2016.
 */
public class Equip extends Action {
    private String _item_name;

    public Equip( String item_name ) {
        super();
        this._item_name = item_name;
    }

    @Override
    public boolean run() {

        RSItem[] items = Inventory.find( this._item_name );

        if( items.length > 0 ) {
            if( Clicking.click( items[ 0 ] ) ) {
                Antiban.afterActionSleep();
            } else {
                return false;
            }
        }

        return Antiban.waitCondition( new Condition() {
            @Override
            public boolean active() {
                return Equipment.isEquipped( _item_name );
            }
        } );
    }
}
