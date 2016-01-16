package scripts.lib;

/**
 * Created by mike on 1/15/2016.
 */
public class Properties {
    private static Properties _properties;

    private String _currentState;

    static {
        _properties = new Properties();
    }

    public static Properties getProperties() {
        return _properties;
    }

    public Properties() {
        this._currentState = "Unnamed";
    }

    public String getCurrentState() {
        return this._currentState;
    }

    public void setCurrentState( String current_state ) {
        this._currentState = current_state;
    }
}
