package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class IsValidDeltaY extends TGGConstraintImpl {
	public void solve(Variable<Number> var_0) {
		String bindingStates = getBindingStates(var_0);

		switch (bindingStates) {
		case "B":
			int deltaY = var_0.getValue().intValue();
			if (-7 <= deltaY && deltaY <= 7) {
				this.setSatisfied(true);
			}
		}

	}
}