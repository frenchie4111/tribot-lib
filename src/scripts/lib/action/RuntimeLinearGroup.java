package scripts.lib.action;

/**
 * Created by mike on 2/7/2016.
 */
public abstract class RuntimeLinearGroup extends LinearGroup {
    @Override
    public abstract Action[] getActions();

    @Override
    public void setActions( Action[] actions ) {
        assert false;
    };

    @Override
    public boolean run() {
        boolean quit = false;

        for( Action a : this.getActions() ) {
            if( !a.start() ) {
                System.out.println( "Failed" );
                quit = true;
                break;
            }
        }

        return !quit;
    }
}
