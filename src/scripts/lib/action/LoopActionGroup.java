package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/6/2016.
 */
public class LoopActionGroup extends ConditionalLoopActionGroup {

    final static Condition ALWAYS_TRUE = new Condition() {
        @Override
        public boolean active() {
            return true;
        }
    };

    public LoopActionGroup( Action[] actions ) {
        super( actions, ALWAYS_TRUE );
    }
}
