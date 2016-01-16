package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Combat;

/**
 * Created by mike on 1/9/2016.
 */
public class IsInCombat extends Condition {
    @Override
    public boolean active() {
        return Combat.isUnderAttack() || Combat.getTargetEntity() != null;
    }
}
