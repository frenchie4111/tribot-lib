package scripts.lib.action.npc;

import org.tribot.api2007.Camera;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;
import scripts.lib.action.Action;

/**
 * Created by mike on 1/10/2016.
 */
public class TalkToNPC extends Action {
    private String _npc_name;

    public TalkToNPC( String npc_name ) {
        super();
        this._npc_name = npc_name;
    }

    @Override
    public void start() {
        super.start();

        RSNPC npcs[] = NPCs.findNearest( this._npc_name );

        if( npcs.length > 0 ) {
            if( !npcs[ 0 ].isOnScreen() ) {
                Camera.turnToTile( npcs[ 0 ] );
            }
            if( !npcs[ 0 ].click( "Talk-to" ) ) {
                this.setFail();
            }
        } else {
            this.setFail();
        }
    }
}
