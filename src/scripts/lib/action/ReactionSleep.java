package scripts.lib.action;

import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 2/7/2016.
 */
public class ReactionSleep extends Action {
    private int _previous_waiting_time;
    private boolean _hovering;
    private boolean _menu_open;
    private boolean _under_attack;

    public ReactionSleep( int previous_waiting_time, boolean hovering, boolean menu_open, boolean under_attack ) {
        super();

        this._previous_waiting_time = previous_waiting_time;
        this._hovering = hovering;
        this._menu_open = menu_open;
        this._under_attack = under_attack;
    }

    @Override
    public boolean run() {
        Antiban.sleepABC2( this._previous_waiting_time, this._hovering, this._menu_open, this._under_attack );
        return true;
    }
}
