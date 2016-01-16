package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Equipment;

/**
 * Created by mike on 1/15/2016.
 */
public class IsEquipedCondition extends Condition {
    private String _item_name;

    public IsEquipedCondition( String item_name ) {
        this._item_name = item_name;
    }

    @Override
    public boolean active() {
        return Equipment.isEquipped( this._item_name );
    }
}
