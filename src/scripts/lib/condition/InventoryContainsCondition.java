package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;

/**
 * Created by mike on 1/8/2016.
 */
public class InventoryContainsCondition extends Condition {
    private String _item_name;

    public InventoryContainsCondition( String item_name ) {
        this._item_name = item_name;
    }

    @Override
    public boolean active() {
        return Inventory.getCount( this._item_name ) > 0;
    }
}
