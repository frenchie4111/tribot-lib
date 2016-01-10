package scripts.lib.action.combat;

import org.tribot.api.Clicking;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Combat;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/9/2016.
 */
public class BeginAttackAction extends Action {
    private RSNPC _target_npc;

    public BeginAttackAction( RSNPC target_npc ) {
        super();
        this._target_npc = target_npc;
    }

    @Override
    public void start() {
        System.out.println( "attack!" );
        if ( !Combat.isUnderAttack() ) {
            Camera.turnToTile( this._target_npc );

            if( !Clicking.click( "Attack", this._target_npc ) ) {
                System.out.printf( "Failed?" );
                this.setFail();
                return;
            }
        }

        super.start();
    }

    @Override
    public void updateState() {
        System.out.printf( "waiting for attack to start %b %b \n", this._target_npc.isInCombat(), !this._target_npc.isValid() );
        // Waits until combat starts
        if( Combat.isUnderAttack() ) {
            System.out.printf( "setting success %b \n", Combat.isUnderAttack() );
            this.setSuccess();
            return;
        } else if( this._target_npc.isInCombat() || !this._target_npc.isValid() || this._target_npc.getInteractingCharacter() != null ) {
            System.out.println( "setFail" );
            this.setFail();
            return;
        }
        this.setRunning();
    }
}
