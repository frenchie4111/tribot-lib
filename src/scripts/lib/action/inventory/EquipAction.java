package scripts.lib.action.inventory;

import org.tribot.api.Clicking;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public class EquipAction extends Action {
    private String _item_name;

    public EquipAction( String item_name ) {
        super();
        this._item_name = item_name;
    }

    @Override
    public void start() {
        super.start();

        RSItem[] items = Inventory.find( this._item_name );

        Clicking.click( items[ 0 ] );
    }

    @Override
    public void updateState() {
        if( Equipment.isEquipped( this._item_name ) ) {
            this.setSuccess();
        }
    }
}
