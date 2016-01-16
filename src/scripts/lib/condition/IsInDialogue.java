package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.NPCChat;

/**
 * Created by mike on 1/10/2016.
 */
public class IsInDialogue extends Condition {
    @Override
    public boolean active() {
        return NPCChat.getClickContinueInterface() != null || NPCChat.getSelectOptionInterface() != null;
    }
}
