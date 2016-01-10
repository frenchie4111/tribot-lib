package scripts.lib.action.combat;

import org.tribot.api.types.generic.Filter;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.types.RSNPC;

/**
 * Created by mike on 1/9/2016.
 */
public class AttackTargetFilter extends Filter<RSNPC> {
    private String _npc_name;

    public AttackTargetFilter( String npc_name ) {
        super();
        this._npc_name = npc_name;
    }

    @Override
    public boolean accept( RSNPC npc ) {
        return npc.getName().startsWith( this._npc_name ) &&
                !npc.isInCombat() && npc.isValid() && PathFinding.canReach( npc, false ) && npc.getInteractingCharacter() == null;
    }
}
