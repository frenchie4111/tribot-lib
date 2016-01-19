package scripts.lib.action.combat;

import org.tribot.api.Clicking;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Combat;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/9/2016.
 */
public class BeginAttack extends Action {
    private RSNPC _target_npc;

    public BeginAttack( RSNPC target_npc ) {
        super();
        this._target_npc = target_npc;
    }

    @Override
    public boolean run() {
        if ( !Combat.isUnderAttack() ) {
            Camera.turnToTile( this._target_npc );

            if( !Clicking.click( "Attack", this._target_npc ) ) {
                return false;
            }
        }

        Timing.waitCondition( new Condition() {
            @Override
            public boolean active() {
                return ( Combat.isUnderAttack() ) || ( _target_npc.isInCombat() || !_target_npc.isValid() || _target_npc.getInteractingCharacter() != null );
            }
        }, 2000 );

        return Combat.isUnderAttack();
    }
}
