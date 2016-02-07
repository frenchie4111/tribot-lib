package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/26/2016.
 */
public class Count extends Condition {
    private int _retry_count;
    private int _counter = 0;

    public Count( int retry_count ) {
        this._retry_count = retry_count;
    }

    @Override
    public boolean active() {
        return ( this._counter++ < this._retry_count );
    }
}
