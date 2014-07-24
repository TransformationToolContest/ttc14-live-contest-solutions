package org.moflon.soccerclient;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;

import TGGLanguage.algorithm.IsApplicableRuleResults;
import TGGLanguage.algorithm.configurator.impl.ConfiguratorImpl;
import TGGRuntime.IsApplicableMatch;
import TGGRuntime.IsApplicableRuleResult;

public class RulePriorityConfigurator extends ConfiguratorImpl {

	@Override
	public IsApplicableMatch chooseOneMatchFromIsApplicableRuleResults(
			EObject translatedObject,
			IsApplicableRuleResults isApplicableRuleResults) {

		IsApplicableMatch selectedMatch = null;

		if (isApplicableRuleResults.getIsapplicableruleresult().size() > 1) {
			/*
			 * Try to find a match for the following high-priority matches.
			 * If none of them has a match, simply select the first possible match.
			 */
			for (final String preferredRule : Arrays.asList(
					"GoalKeeperPassesToPlayer_Red", //
					"GoalKeeper_KickOffBall", //
					"MoveGoalKeeperNorth",
					"MoveGoalKeeperSouth")) {
				for (final IsApplicableRuleResult result : isApplicableRuleResults
						.getIsapplicableruleresult()) {
					if (result.getRule().equals(preferredRule)) {
						selectedMatch = result.getIsApplicableMatch().get(0);
						return selectedMatch;
					}
				}
			}

			// No matching priority rule match found - just take any match.
			if (selectedMatch == null) {
				selectedMatch = isApplicableRuleResults
						.getIsapplicableruleresult().get(0)
						.getIsApplicableMatch().get(0);
			}
		} else {
			selectedMatch = super.chooseOneMatchFromIsApplicableRuleResults(
					translatedObject, isApplicableRuleResults);
		}
		return selectedMatch;
	}
}
