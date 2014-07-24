package org.moflon.soccerclient;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;

import soccerpitch.SoccerpitchPackage;
import updatemodel.UpdatemodelPackage;
import SoccerStrategy.SoccerStrategyPackage;
import TGGRuntime.CorrespondenceModel;


public class SoccerStrategySync extends IntegratorHelper {

	public SoccerStrategySync() throws IOException {
		// Register packages
        eMoflonEMFUtil.init(SoccerStrategyPackage.eINSTANCE);
        eMoflonEMFUtil.init(UpdatemodelPackage.eINSTANCE);
        eMoflonEMFUtil.init(SoccerpitchPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(SoccerStrategyPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Propagate changes made to source
        SoccerStrategySync helper = new SoccerStrategySync();
		helper.syncForward("instances/fwd.corr.xmi");
		
		// Propagate changes made to target
		helper = new SoccerStrategySync();
		helper.syncBackward("instances/fwd.corr.xmi");
	}

	@Override
	public void changeSrc(EObject root){ 
		// TODO: Specify source delta here by performing changes to root
	}
	
	@Override
	public void changeTrg(EObject root){ 
		// TODO: Specify target delta here by performing changes to root
	}
	
	public void syncForward(String corr) {
		loadTriple(corr);
		integrateForward();
		saveResult("fwd");
		
		System.out.println("Completed forward synchronization");
	}
	
	public void syncBackward(String corr) {
		loadTriple(corr);
		integrateBackward();
		saveResult("bwd");
		
		System.out.println("Completed backward synchronization");
	}
	
	private void loadTriple(String corr){ 
		try {
			loadCorr(corr);
			CorrespondenceModel corrModel = (CorrespondenceModel) getCorr();
			setSrc(corrModel.getSource());
			setTrg(corrModel.getTarget());
		} catch (IllegalArgumentException iae) {
			System.err.println("Unable to load input triple for " + corr
					+ ", " + iae.getMessage());
		}
	}
	
	private void saveResult(String direction){ 
		getSrc().eResource().setURI(URI.createFileURI("sync." + direction + ".src.xmi"));
		getTrg().eResource().setURI(URI.createFileURI("sync." + direction + ".trg.xmi"));
		getCorr().eResource().setURI(URI.createFileURI("sync." + direction + ".corr.xmi"));
		
		saveSrc("instances/sync." + direction + ".src.xmi");
		saveTrg("instances/sync." + direction + ".trg.xmi");
		saveCorr("instances/sync." + direction + ".corr.xmi");
		saveProtocol("instances/sync." + direction + ".protocol.xmi");
	}
}