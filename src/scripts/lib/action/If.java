package scripts.lib.action;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/10/2016.
 */
public class If extends Action {
    private Action _action;
    private Condition _condition;

    public If( Condition condition, Action action ) {
        super();
        this._action = action;
        this._condition = condition;
    }

    @Override
    public boolean run() {
        System.out.println( "Active asked" );

        return this._action.run();
    }

    @Override
    public boolean start() {
        System.out.println( "Active asked" );

        if( this._condition.active() ) {
            return super.start();
        }

        return true;
    }
}
