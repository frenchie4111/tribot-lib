package scripts.lib.action;

import scripts.lib.Properties;

/**
 * Created by mike on 1/6/2016.
 */
public abstract class Action {
    public abstract boolean run();

    public boolean start() {
        Properties.getProperties().setCurrentState( this.toString() );
//        System.out.println( this.toString() );
        return this.run();
    }
}
