import java.io.*;
import java.net.*;

public class SoccerClientBlue
{ private String sserver = "";
  private Socket client;
  private int port = 2000; 
  public static String END_MARKER = "#END_RESOURCE#"; 
  public static String START_MARKER = "#START_RESOURCE#"; 

  public SoccerClientBlue(String host)
  { sserver = host; }

  public static void main(String[] args)
  { SoccerClientBlue cl = new SoccerClientBlue("127.0.0.1");
    if (args.length > 0)
    { cl.setPort(args[0]); } 
    cl.runClient();
  }

  public void setPort(String s)
  { port = Integer.parseInt(s); } 

  public void runClient()
  { BufferedReader in;
    PrintWriter out;  
    PrintWriter gout; 
    try
     { client = new Socket(InetAddress.getByName(sserver), port);
        System.out.println("Connected to " + client.getInetAddress().getHostName() );
        in = new BufferedReader(
            new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(
            new OutputStreamWriter(client.getOutputStream()));
        System.out.println("Got streams");

        File outfile = new File("out.txt");

        gout = new PrintWriter(
                              new BufferedWriter(
                                new FileWriter(outfile)));
    
        String data = in.readLine();
        System.out.println(data);
        out.println("UML-RSDSBLUE");
        out.flush();

String s; // = in.readLine();
       
    /*   while (s != null && !(s.equals(END_MARKER)))
        { s = in.readLine();
        }
    

        out.println(START_MARKER); 
   out.println("<?xml version=\"1.0\" encoding=\"ASCII\"?><updatemodel:Update xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:updatemodel=\"http://www.transformation-tool-contest.eu/updatemodel/1.0\"><actions playerNumber=\"1\" xsi:type=\"updatemodel:ShootBall\" xDist=\"7\" yDist=\"-3\"/> <actions playerNumber=\"5\" xsi:type=\"updatemodel:MovePlayer\" xDist=\"-3\" yDist=\"-3\"/></updatemodel:Update>"); 

        out.println(END_MARKER); 
   out.flush(); */ 

   int turns = 0; 
   while (turns < 400) 
   {   StringBuffer xmlstring = new StringBuffer(); 
       s = in.readLine();
       
       while (s != null && !(s.equals(END_MARKER)))
        { s = in.readLine();
          xmlstring.append(s);
        }
    
        String resp = Controller.cycle(xmlstring.toString()); 

        System.out.println(resp); 

        out.println(START_MARKER); 
        out.println(resp);  
        out.println(END_MARKER); 
        out.flush(); 
  } 
  
        in.close();
        out.close(); 
        gout.close(); 
        client.close();
    } catch (Exception e) 
      { e.printStackTrace();
        // in.close();
        // out.close(); 
        // gout.close(); 
        // client.close();
    }
  }
}