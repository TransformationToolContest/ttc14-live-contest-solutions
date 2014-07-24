package csp.constraints;

import soccerpitch.Teams;
import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class IsInDirectionOfGoal extends TGGConstraintImpl {
	public void solve(Variable<Number> var_0, Variable<Number> var_1,
			Variable<Number> var_2, Variable<Number> var_3,
			Variable<Teams> var_4) {
		String bindingStates = getBindingStates(var_0, var_1, var_2, var_3,
				var_4);

		switch (bindingStates) {
		case "BBBBB":
			int srcX = var_0.getValue().intValue();
			int srcY = var_1.getValue().intValue();
			int tgtX = var_2.getValue().intValue();
			int tgtY = var_3.getValue().intValue();
			Teams ownTeam = var_4.getValue();
			int deltaX = tgtX - srcX;
			int deltaY = tgtY - srcY;
			boolean result = IsValidDeltaX
					.isValidDeltaXForTeam(deltaX, ownTeam)
					&& IsValidDeltaY.isValidDeltaY(deltaY);
			
			this.setSatisfied(result);
		}

	}
}