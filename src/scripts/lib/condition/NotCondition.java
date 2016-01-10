package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/9/2016.
 */
public class NotCondition extends Condition {
    private Condition _condition;

    public NotCondition( Condition condition ) {
        this._condition = condition;
    }

    @Override
    public boolean active() {
        return !this._condition.active();
    }
}
