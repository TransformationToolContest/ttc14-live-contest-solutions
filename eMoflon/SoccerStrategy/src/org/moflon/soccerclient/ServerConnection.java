package org.moflon.soccerclient;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.moflon.util.eMoflonEMFUtil;

public class ServerConnection {
	
	public static final int DEFAULT_PORT = 42424;
	
	public static final String START_MARKER = "#START_RESOURCE#";
	public static final String END_MARKER = "#END_RESOURCE#";

	private final String host;
	private final int port;
	private Socket socket;

	private ServerConnection(final String host, final int port) {
		this.host = host;
		this.port = port;
	}

	private void initializeConnection() throws IOException {

		socket = new Socket(host, port);
	}
	
	public void close() throws IOException {
		this.socket.close();
	}
	
	public static ServerConnection connect(final String host, final int port) throws IOException
	{
		ServerConnection connection = new ServerConnection(host, port);
		connection.initializeConnection();
		return connection;
	}

	public String receiveTeamColor() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String color = in.readLine();
		return color;
	}

	public void sendTeamName(final String teamName) throws IOException {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		out.write(teamName + "\n");
		out.flush();
	}

	public void sendResource(XMIResource resource) throws IOException {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		out.println(START_MARKER);
		Map<Object, Object> opts = resource.getDefaultSaveOptions();
		opts.put(XMLResource.OPTION_FORMATTED, false);
		resource.save(out, opts);
		out.println(END_MARKER);
		out.flush();
	}

	public XMIResource receiveResource() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String s = in.readLine();
		if (s == null) {
			throw new IOException("Connection lost while receiving");
		}
		if (!s.equals(START_MARKER)) {
			throw new IOException("Protocol violation: Received " + s
					+ " but was expeting " + START_MARKER);
		}

		StringBuilder sb = new StringBuilder();
		while (!(s = in.readLine()).equals(END_MARKER)) {
			sb.append(s);
		}
		s = sb.toString();
		XMIResource resource = new XMIResourceImpl();
		resource.load(new ByteArrayInputStream(s.getBytes()),
				resource.getDefaultLoadOptions());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(resource);
		
		eMoflonEMFUtil.installCrossReferencers(resourceSet);
		
		
		return resource;
	}
}
