package scripts.lib.action.cooking;

import scripts.lib.action.Action;
import scripts.lib.action.LinearGroup;
import scripts.lib.action.inventory.UseOn;

// 307, 3

/**
 * Created by mike on 1/21/2016.
 */
public class Cook extends LinearGroup {
    public Cook( String item_name, String cooker_name ) {
        super( new Action[] {
            new BeginCook( item_name, cooker_name ),
            new WaitForCookingToStop()
        } );
    }
}
