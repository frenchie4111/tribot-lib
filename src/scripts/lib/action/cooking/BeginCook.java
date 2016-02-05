package scripts.lib.action.cooking;

import org.tribot.api2007.Camera;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;
import scripts.lib.action.Action;
import scripts.lib.action.LinearGroup;
import scripts.lib.action.Wait;
import scripts.lib.action.inventory.UseOn;
import scripts.lib.action.ui.ClickUIElement;
import scripts.lib.antiban.Antiban;
import scripts.lib.condition.IsInterfaceValid;

/**
 * Created by mike on 1/21/2016.
 */
public class BeginCook extends LinearGroup {
    // 307 3
    public BeginCook( String name, String other_name ) {
        super( new Action[] {
                new UseOn( name, other_name ),
                new Wait( new IsInterfaceValid( 307 ), 2000 ),
                new Wait( 1000, 2000 ),
                new ClickUIElement( "Cook All", 307, 3 )
        } );
    }
}
