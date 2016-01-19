package scripts.lib.action.ui;

import org.tribot.api.interfaces.Clickable;
import org.tribot.api2007.NPCChat;
import scripts.lib.action.click.Click;

/**
 * Created by mike on 1/10/2016.
 */
public class Continue extends Click {
    @Override
    public Clickable getTarget() {
        return NPCChat.getClickContinueInterface();
    }
}
