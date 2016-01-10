package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;

/**
 * Created by mike on 1/8/2016.
 */
public class InventoryContainsCondition extends Condition {
    private int _item_id;

    public InventoryContainsCondition( int item_id ) {
        this._item_id = item_id;
    }

    @Override
    public boolean active() {
        return Inventory.getCount( this._item_id ) > 0;
    }
}
