package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class IsValidDeltaY extends TGGConstraintImpl {
	public void solve(Variable<Number> var_0) {
		String bindingStates = getBindingStates(var_0);

		switch (bindingStates) {
		case "B":
			int deltaY = var_0.getValue().intValue();
			boolean result = isValidDeltaY(deltaY);
			this.setSatisfied(result);
		}

	}

	public static boolean isValidDeltaY(int deltaY) {
		boolean result = -7 <= deltaY && deltaY <= 7;
		return result;
	}
}