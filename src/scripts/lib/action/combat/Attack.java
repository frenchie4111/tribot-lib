package scripts.lib.action.combat;

import org.tribot.api2007.*;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.Action;
import scripts.lib.action.LinearGroup;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/7/2016.
 */
public class Attack extends LinearGroup {
    private String _npc_name;

    public Attack( String npc_name ) {
        super();

        this._npc_name = npc_name;
    }

    @Override
    public boolean run() {
        RSNPC npcs[] = NPCs.findNearest( new AttackTargetFilter( this._npc_name ) );
        npcs = Antiban.orderTargets( npcs );

        if( npcs.length < 1 ) {
            return false;
        }

        RSNPC target_npc = npcs[ 0 ];

        this.setActions( new Action[] {
                new BeginAttack( target_npc ),
                new CompleteAttack( target_npc )
        } );

        return super.run();
    }
}
