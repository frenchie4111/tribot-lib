package scripts.lib.action.bank;

import org.tribot.api.General;
import org.tribot.api2007.Banking;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public class BankAllAction extends Action {
    @Override
    public void start() {
        Banking.depositAll();
        General.sleep( 200, 1000 );
        Banking.depositEquipment();
        General.sleep( 200, 1000 );
        super.start();
    }
}
