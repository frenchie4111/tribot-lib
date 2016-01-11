package scripts.lib.action.combat;

import org.tribot.api2007.Combat;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/9/2016.
 */
public class WaitAttackAction extends Action {
    private RSNPC _target_npc;

    public WaitAttackAction( RSNPC npc ) {
        super();

        this._target_npc = npc;
    }

    @Override
    public void updateState() {
        if( !Combat.isUnderAttack() || !this._target_npc.isValid() ) {
            this.setSuccess();
        } else {
            this.setRunning();
        }
    }
}
