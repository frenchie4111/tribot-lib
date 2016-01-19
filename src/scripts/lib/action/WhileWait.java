package scripts.lib.action;

import org.tribot.api.types.generic.Condition;
import scripts.lib.antiban.Antiban;

/**
 * Created by mike on 1/19/2016.
 */
public class WhileWait extends While {
    public WhileWait( Condition condition, Action[] actions ) {
        super( condition, actions );

        Action new_actions[] = new Action[ actions.length * 2 ];

        for( int i = 0; i < new_actions.length; i++ ) {
            if( i % 2 == 0 ) {
                new_actions[ i ] = actions[ i / 2 ];
            } else {
                new_actions[ i ] = new Wait( 500, 2000 );
            }
        }

        this.setActions( new_actions );
    }
}
