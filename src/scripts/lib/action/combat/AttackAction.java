package scripts.lib.action.combat;

import org.tribot.api2007.*;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.Action;
import scripts.lib.action.SequentialActionGroup;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/7/2016.
 */
public class AttackAction extends SequentialActionGroup {
    private String _npc_name;

    public AttackAction( String npc_name ) {
        super();

        this._npc_name = npc_name;
    }

    @Override
    public void start() {
        RSNPC npcs[] = NPCs.findNearest( new AttackTargetFilter( this._npc_name ) );
        npcs = Antiban.orderTargets( npcs );

        if( npcs.length < 1 ) {
            this.setFail();
            return;
        }

        RSNPC target_npc = npcs[ 0 ];

        this.setActions( new Action[] {
                new BeginAttackAction( target_npc ),
                new WaitAttackAction( target_npc )
        } );

        super.start();
    }
}
