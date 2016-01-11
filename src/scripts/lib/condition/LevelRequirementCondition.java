package scripts.lib.condition;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Skills;

/**
 * Created by mike on 1/10/2016.
 */
public class LevelRequirementCondition extends Condition {
    private Skills.SKILLS _skill;
    private int _required_lvl;

    public LevelRequirementCondition( Skills.SKILLS skill, int required_lvl ) {
        super();
        this._skill = skill;
        this._required_lvl = required_lvl;
    }

    @Override
    public boolean active() {
        return Skills.getCurrentLevel( this._skill ) >= this._required_lvl;
    }
}
