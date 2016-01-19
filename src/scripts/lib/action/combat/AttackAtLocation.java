package scripts.lib.action.combat;

import org.tribot.api.types.generic.Condition;
import scripts.lib.action.*;
import scripts.lib.action.combat.Attack;
import scripts.lib.condition.And;
import scripts.lib.condition.IsNPCInRange;

/**
 * Created by mike on 1/7/2016.
 */
public class AttackAtLocation extends WhileWait {
    public AttackAtLocation( Condition stop_condition, String npc_name, int[] location, Action before_walk ) {
        super( stop_condition, new Action[]{
                        before_walk,
                        new Walk( location ),
                        new WhileWait(
                                new And(
                                        new IsNPCInRange( npc_name ),
                                        stop_condition
                                ), new Action[]{
                                    new Attack( npc_name )
                                }
                        )
                } );
    }
}
