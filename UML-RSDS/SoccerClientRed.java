import java.io.*;
import java.net.*;

public class SoccerClientRed
{ private String sserver = "";
  private Socket client;
  public static String END_MARKER = "#END_RESOURCE#"; 
  public static String START_MARKER = "#START_RESOURCE#"; 

  public SoccerClientRed(String host)
  { sserver = host; }

  public static void main(String[] args)
  { SoccerClientRed cl = new SoccerClientRed("127.0.0.1");
    cl.runClient();
  }

  public void runClient()
  { BufferedReader in;
    PrintWriter out;  
    PrintWriter gout; 
    try
     { client = new Socket(InetAddress.getByName(sserver), 2000);
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
        out.println("UML-RSDSRED");
        out.flush();
        int turns = 0; 
        while (turns < 400)
        { String s = in.readLine();
          while (s != null && !(s.equals(END_MARKER)))
          { // gout.println(s);
            s = in.readLine();
          }
    
          out.println(START_MARKER); 
out.println("<?xml version=\"1.0\" encoding=\"ASCII\"?><updatemodel:Update xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:updatemodel=\"http://www.transformation-tool-contest.eu/updatemodel/1.0\"></updatemodel:Update>"); 
        out.println(END_MARKER); 
        out.flush(); 
   turns++; 
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