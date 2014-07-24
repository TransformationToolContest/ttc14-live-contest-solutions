package csp.constraints;

import soccerpitch.Teams;
import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class TeamToDirection extends TGGConstraintImpl {
	public void solve(Variable<Teams> var_0, Variable<Number> var_1) {
		String bindingStates = getBindingStates(var_0, var_1);

		switch (bindingStates) {
		case "BB":
			throw new UnsupportedOperationException(
					"This case in the constraint has not been implemented yet.");
		case "BF":
		{
			Teams team = var_0.getValue();
			final int signum;
			switch (team) {
			case RED:
				signum = -1;
				break;
			case BLUE:
				signum = 1;
				break;
			default:
				throw new UnsupportedOperationException("Unknown case");
			}
			var_1.bindToValue(signum);
			setSatisfied(true);
			break;
		}
		case "FB": {
			int signum = var_1.getValue().intValue();
			Teams team;
			if (signum > 0) {
				team = Teams.BLUE;
			} else {
				team = Teams.RED;
			}
			var_0.bindToValue(team);
			setSatisfied(true);
			break;
		}
		}

	}
}