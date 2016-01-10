package scripts.lib.action;

/**
 * Created by mike on 1/6/2016.
 */
public class LoginAction extends Action {
    @Override
    public void start() {
        this.setRunning();
    }

    @Override
    public void updateState() {
        if( org.tribot.api2007.Login.getLoginState() == org.tribot.api2007.Login.STATE.INGAME ) {
            this.setSuccess();
        }
    }
}
