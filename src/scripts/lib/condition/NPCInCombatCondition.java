package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.types.RSNPC;

/**
 * Created by mike on 1/8/2016.
 */
public class NPCInCombatCondition extends Condition {
    private RSNPC _npc;

    public NPCInCombatCondition( RSNPC _npc ) {
        this._npc = _npc;
    }

    @Override
    public boolean active() {
        return this._npc.isInCombat();
    }
}
