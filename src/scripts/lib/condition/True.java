package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 2/6/2016.
 */
public class True extends Condition {
    @Override
    public boolean active() {
        return true;
    }
}
