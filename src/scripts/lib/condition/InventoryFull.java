package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;

/**
 * Created by mike on 1/19/2016.
 */
public class InventoryFull extends Condition {

    @Override
    public boolean active() {
        return Inventory.isFull();
    }
}
