package scripts.lib.action.combat;

import org.tribot.api.Clicking;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;
import scripts.lib.action.Action;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/10/2016.
 */
public class ChangeStance extends Action {
    public static int INTERFACE_COMBAT_TAB_PARENT_ID = 548;
    public static int INTERFACE_COMBAT_TAB_CHILD_ID = 52;

    public static int INTERFACE_STANCE_PARENT_ID = 593;

    public static int INTERFACE_SELECTED_CHILD_OFFSET = 1;
    public static int INTERFACE_DESELECTED_TEXTURE_ID = 653;
    public static int INTERFACE_SELECTED_TEXTURE_ID = 654;

    private String _stance_name;
    private int _stance_child_id;

    public ChangeStance( String stance_name ) {
        super();
        this._stance_name = stance_name;
    }

    private int findStanceButtonChidlId( RSInterface[] child_interfaces ) {
        for( RSInterface child_interface : child_interfaces ) {
            String[] actions = child_interface.getActions();

            if( actions == null ) continue;

            for( String action : actions ) {
                if( action.startsWith( this._stance_name ) ) {
                    return child_interface.getIndex();
                }
            }
        }

        return -1;
    }

    @Override
    public boolean run() {
        Clicking.click( Interfaces.get( INTERFACE_COMBAT_TAB_PARENT_ID, INTERFACE_COMBAT_TAB_CHILD_ID ) );

        Timing.waitCondition( new Condition() {
            @Override
            public boolean active() {
                return Interfaces.isInterfaceValid( INTERFACE_STANCE_PARENT_ID );
            }
        }, 1000 );

        RSInterface stance_interface = Interfaces.get( INTERFACE_STANCE_PARENT_ID );
        RSInterface children[] = stance_interface.getChildren();
        this._stance_child_id = this.findStanceButtonChidlId( children );

        RSInterface stance_button = stance_interface.getChild( this._stance_child_id );
        if( Clicking.click( stance_button ) ) {
            Antiban.afterActionSleep();
        }

        return Timing.waitCondition( new Condition() {
            @Override
            public boolean active() {
                return Interfaces.get( INTERFACE_STANCE_PARENT_ID, _stance_child_id + INTERFACE_SELECTED_CHILD_OFFSET ).getTextureID() == INTERFACE_SELECTED_TEXTURE_ID;
            }
        }, 1000 );
    }
}

