package scripts.lib.action.bank;

import org.tribot.api2007.Banking;
import scripts.lib.action.Action;
import scripts.lib.action.SleepAfter;

/**
 * Created by mike on 1/10/2016.
 */
public class Withdraw extends SleepAfter {
    private int _count;
    private String[] _item_names;

    public Withdraw( int count, String... item_names ) {
        super();

        this._count = count;
        this._item_names = item_names;
    }

    @Override
    public boolean run() {
        return Banking.withdraw( this._count, _item_names );
    }
}
