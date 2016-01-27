package scripts.lib.action.combat;

import org.tribot.api2007.*;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;
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
        RSNPC target_npc = ( RSNPC ) Antiban.selectTarget( npcs );

        this.setActions( new Action[] {
                new BeginAttack( target_npc ),
                new CompleteAttack( target_npc )
        } );

        return super.run();
    }
}
