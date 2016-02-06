package scripts.lib.action.cooking;

import scripts.lib.action.Action;
import scripts.lib.action.AlwaysTrue;
import scripts.lib.action.Loop;
import scripts.lib.action.Wait;
import scripts.lib.condition.IsIdle;
import scripts.lib.condition.Not;

/**
 * Created by mike on 2/6/2016.
 */
public class WaitForCookingToStop extends AlwaysTrue {
    public WaitForCookingToStop() {
        super( new Loop(
                new Action[] {
                        // Wait for cooking to start
                        new Wait(
                                new Not(
                                        new IsIdle()
                                ),
                                2000,
                                4000
                        ),
                        // Wait for cooking to stop
                        new Wait(
                                new IsIdle(),
                                60000
                        ),
                }
        ) );
    }
}
