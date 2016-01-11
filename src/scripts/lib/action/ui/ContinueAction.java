package scripts.lib.action.ui;

import org.tribot.api.interfaces.Clickable;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.NPCChat;
import scripts.lib.action.Action;
import scripts.lib.action.click.ClickAction;

/**
 * Created by mike on 1/10/2016.
 */
public class ContinueAction extends ClickAction {
    public ContinueAction() {
        super();
    }

    @Override
    public Clickable getTarget() {
        return NPCChat.getClickContinueInterface();
    }
}
