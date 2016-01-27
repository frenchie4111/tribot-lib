package scripts.lib.action.inventory;

import org.tribot.api2007.Inventory;
import scripts.lib.action.SleepAfter;

/**
 * Created by mike on 1/21/2016.
 */
public class DropAll extends SleepAfter {
    private int[] _except_ids;

    public DropAll() {

    }

    public DropAll( int ...except_ids ) {
        super();
        this._except_ids = except_ids;
    }

    @Override
    public boolean run() {
        Inventory.dropAllExcept( this._except_ids );
        return true;
    }
}
