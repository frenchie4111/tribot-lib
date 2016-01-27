package scripts.lib.action.cooking;

import org.tribot.api2007.Camera;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;
import scripts.lib.action.Action;
import scripts.lib.action.LinearGroup;
import scripts.lib.action.inventory.UseOn;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/21/2016.
 */
public class BeginCook extends LinearGroup {
    // 307 3
    public BeginCook( String name, String other_name ) {

    }

    public BeginCook() {
        super( new Action[] {
            new UseOn( "Raw chicken", "Cooking pot" )
        } );
    }
}
