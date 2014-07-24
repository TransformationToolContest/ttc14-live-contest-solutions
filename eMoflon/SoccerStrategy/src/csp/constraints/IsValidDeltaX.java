package csp.constraints;

import soccerpitch.Teams;
import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class IsValidDeltaX extends TGGConstraintImpl {
	public void solve(Variable<Number> var_0, Variable<Teams> var_1){
    	String bindingStates = getBindingStates(var_0, var_1);
    	
    	switch(bindingStates){
    	case "BB":
    		int deltaX = var_0.getValue().intValue();
    		Teams team = var_1.getValue();
    		boolean result = isValidDeltaXForTeam(deltaX, team);
    		this.setSatisfied(result);
    	}
    	
  	}

	public static boolean isValidDeltaXForTeam(int deltaX, Teams team) {
		boolean result;
		if (team.equals(Teams.RED))
		{
			result = -7 <= deltaX && deltaX <= 0;
		}
		else {
			result = 0 <= deltaX && deltaX <= 7;
		}
		return result;
	}	  
}