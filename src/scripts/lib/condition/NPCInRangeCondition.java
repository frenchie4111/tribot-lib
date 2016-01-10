package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.combat.AttackTargetFilter;

/**
 * Created by mike on 1/10/2016.
 */
public class NPCInRangeCondition extends Condition {
    private String _npc_name;

    public NPCInRangeCondition( String npc_name ) {
        this._npc_name = npc_name;
    }


    @Override
    public boolean active() {
        RSNPC npcs[] = NPCs.findNearest( new AttackTargetFilter( this._npc_name ) );

        return npcs.length > 0;
    }
}
