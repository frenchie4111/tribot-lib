package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/9/2016.
 */
public class Or extends Condition {
    private Condition[] _conditions;

    public Or( Condition... conditions ) {
        this._conditions = conditions;
    }

    @Override
    public boolean active() {
        for( Condition condition : this._conditions ) {
            if( condition.active() ) {
                return true;
            }
        }

        return false;
    }
}
