package scripts.lib.action.inventory;

import org.tribot.api.DynamicClicking;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;
import scripts.lib.action.Action;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/21/2016.
 */
public class UseOn extends Action {
    private String _item_name;
    private String _target_name;

    public UseOn( String item_name, String target_name ) {
        super();
        this._item_name = item_name;
        this._target_name = target_name;
    }

    @Override
    public boolean run() {
        System.out.println( "Running UseOne" );
        RSItem items[] = Inventory.find( this._item_name );
        if( items.length < 1 ) return false;
        RSItem target_item = items[ 0 ];
        System.out.println( items[ 0 ] );

        RSObject _cooker_objects[] = Objects.find( 20, this._target_name );
        if( _cooker_objects.length < 1 ) return false;
        RSObject cooker_object = _cooker_objects[ 0 ];

        Camera.turnToTile( cooker_object );
        Antiban.afterActionSleep( 100, 200 );

//        if( !target_item.click( "Use" ) ) return false;
        target_item.click( "Use" );
        DynamicClicking.clickRSObject( cooker_object, this._item_name + " -> " + this._target_name );
//        if( ! ) return false;
        Antiban.afterActionSleep( 100, 200 );
        return true;
    }
}
