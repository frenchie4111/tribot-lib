package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;

/**
 * Created by mike on 1/9/2016.
 */
public class AndCondition extends Condition {
    private Condition[] _conditions;

    public AndCondition( Condition... conditions ) {
        this._conditions = conditions;
    }

    @Override
    public boolean active() {
        for( Condition condition : this._conditions ) {
            if( !condition.active() ) {
                System.out.printf( "Condition false %S", condition );
                return false;
            }
        }

        return true;
    }
}
