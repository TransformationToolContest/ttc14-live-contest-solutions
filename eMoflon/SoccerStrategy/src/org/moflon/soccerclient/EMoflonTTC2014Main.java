package org.moflon.soccerclient;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.moflon.util.eMoflonEMFUtil;

import soccerpitch.SoccerPitch;
import soccerpitch.SoccerpitchPackage;
import soccerpitch.Teams;
import updatemodel.Update;
import updatemodel.UpdatemodelPackage;

public class EMoflonTTC2014Main {

	private static String host = "localhost";
	private static int port = ServerConnection.DEFAULT_PORT;
	private static String teamName = "eMoflon";

	private static boolean shouldPersistIntermediateResults = true;
	private static File protocolDirectory = null;
	private static Logger logger = Logger.getLogger(EMoflonTTC2014Main.class);

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out
					.println("Usage: java -jar EMoflonTTC2014.jar <server-host> <server-port> [<team-name>]");
			return;
		}

		parseParameters(args);
		initEMF();

		logger.info(" ... Connecting to " + host + ":" + port);
		ServerConnection connection = ServerConnection.connect(host, port);
		logger.info(" OK  Connected to server.");

		String teamColor = connection.receiveTeamColor();
		logger.info(" OK Received team color: " + teamColor);

		connection.sendTeamName(teamName);
		logger.info(" OK Sent team name " + teamName);

		RulePriorityConfigurator configurator = new RulePriorityConfigurator();
		try {
			for (int turn = 1;; turn++) {

				SoccerPitch pitch = receiveAndPrepareSoccerPitch(connection,
						teamColor, turn);

				SoccerStrategyTrafo soccerStrategyTrafo = performSoccerPitchToUpdateTransformation(
						configurator, turn, pitch);

				if (shouldPersistIntermediateResults)
					persistIntermediateResults(turn, soccerStrategyTrafo);

				prepareAndSendUpdateModel(connection, turn, soccerStrategyTrafo);

				System.gc();
			}
		} catch (Exception e) {
			logger.info("Connection to server lost. This may be OK, if the game is simply over.");
			e.printStackTrace();
		} finally {
			logger.info(" ... Closing connection to server...");
			connection.close();
			logger.info(" OK  Closed connection.");
		}
	}

	private static void initEMF() {
		eMoflonEMFUtil.init(SoccerpitchPackage.eINSTANCE);
		eMoflonEMFUtil.init(UpdatemodelPackage.eINSTANCE);
	}

	private static void parseParameters(String[] args) {
		host = args[0];
		port = Integer.parseInt(args[1]);
		if (args.length >= 3) {
			teamName = args[2];
		}
	}

	private static SoccerStrategyTrafo performSoccerPitchToUpdateTransformation(
			RulePriorityConfigurator configurator, int turn, SoccerPitch pitch)
			throws IOException {
		logger.info("[" + turn
				+ "] ... Performing soccer pitch-to-update model trafo...");
		SoccerStrategyTrafo soccerStrategyTrafo = new SoccerStrategyTrafo();
		soccerStrategyTrafo.setSrc(pitch);
		soccerStrategyTrafo.setConfigurator(configurator);
		soccerStrategyTrafo.integrateForward();
		return soccerStrategyTrafo;
	}

	private static void prepareAndSendUpdateModel(ServerConnection connection,
			int turn, SoccerStrategyTrafo soccerStrategyTrafo)
			throws IOException {
		Update update = (Update) soccerStrategyTrafo.getTrg();
		logger.info("[" + turn
				+ "] OK  Performed soccer pitch-to-update model trafo");

		logger.info("[" + turn + "] ... Sending update to server...");
		XMIResource updateResource = new XMIResourceImpl(
				URI.createURI(UpdatemodelPackage.eNS_URI));
		updateResource.getContents().add(update);
		connection.sendResource(updateResource);
		logger.info("[" + turn + "] ... Sent update to server.");
	}

	private static SoccerPitch receiveAndPrepareSoccerPitch(
			ServerConnection connection, String teamColor, int turn)
			throws IOException {

		logger.info("[" + turn + "] ... Retrieving soccer pitch...");

		XMIResource fieldResource = connection.receiveResource();
		SoccerPitch pitch = (SoccerPitch) fieldResource.getContents().get(0);
		logger.info("[" + turn + "] OK  Retrieved soccer pitch.");

		pitch.setOwnTeam(teamColor.equals("RED") ? Teams.RED : Teams.BLUE);
		pitch.setOpponentTeam(teamColor.equals("RED") ? Teams.BLUE : Teams.RED);
		return pitch;
	}

	private static void prepareProtocolDirectory() {
		protocolDirectory = new File("target/protocol");
		try {
			FileUtils.deleteDirectory(protocolDirectory);
			protocolDirectory.mkdirs();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void persistIntermediateResults(int turn,
			SoccerStrategyTrafo soccerStrategyTrafo) {
		if (protocolDirectory == null) {
			prepareProtocolDirectory();
		}

		try {
			String formattedTurn = String.format("%03d", turn);
			soccerStrategyTrafo.saveProtocol(protocolDirectory
					.getAbsolutePath() + "/protocol" + formattedTurn + ".xmi");
			soccerStrategyTrafo.saveSrc(protocolDirectory.getAbsolutePath()
					+ "/source" + formattedTurn + ".xmi");
			soccerStrategyTrafo.saveTrg(protocolDirectory.getAbsolutePath()
					+ "/target" + formattedTurn + ".xmi");
			soccerStrategyTrafo.saveCorr(protocolDirectory.getAbsolutePath()
					+ "/corr" + formattedTurn + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
