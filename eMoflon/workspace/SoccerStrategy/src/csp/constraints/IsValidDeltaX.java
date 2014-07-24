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
    		if (team.equals(Teams.RED))
    		{
    			if (-7 <= deltaX && deltaX <= 0)
    			{
    				this.setSatisfied(true);
    			}
    		}
    		else {
    			if (0 <= deltaX && deltaX <= 7)
    			{
    				this.setSatisfied(true);
    			}
    		}
    	}
    	
  	}	  
}