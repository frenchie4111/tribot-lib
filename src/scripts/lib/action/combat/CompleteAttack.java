package scripts.lib.action.combat;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Combat;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/9/2016.
 */
public class CompleteAttack extends Action {
    private RSNPC _target_npc;

    public CompleteAttack( RSNPC npc ) {
        super();

        this._target_npc = npc;
    }

    @Override
    public boolean run() {
        while( Combat.isUnderAttack() && _target_npc.isValid() ) {
            General.sleep( 200, 2000 );
        }

        return true;
    }
}
