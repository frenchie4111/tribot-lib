package scripts.lib.action.bank;

import org.tribot.api2007.Banking;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public class WithdrawAction extends Action {
    private int _count;
    private String[] _item_names;

    public WithdrawAction( int count, String... item_names ) {
        super();

        this._count = count;
        this._item_names = item_names;
    }

    @Override
    public void start() {
        Banking.withdraw( this._count, _item_names );
        super.start();
    }
}
