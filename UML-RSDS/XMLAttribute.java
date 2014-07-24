import java.util.StringTokenizer; 
import java.util.Vector; 
import java.io.*; 

public class XMLAttribute
{ String name;
  String value;

  XMLAttribute()
  { name = ""; value = ""; }
  
  XMLAttribute(String n, String v)
  { name = n; value = v; }

  public String toString()
  { return name + "=" + value; } 

  public String getName()
  { return name; } 
 
  public String getValue()
  { return value; } 

  public void setname(String n)
  { name = n; } 
 
  public void setvalue(String v)
  { value = v; } 

  public void getDataDeclaration(PrintWriter out, String instance, String ent)
  { // returns instance.name = value or value : instance.name
    // as appropriate
    if ("team".equals(name))
    // Attribute att = ent.getDefinedAttribute(name); 
    // if (att != null) // name is an attribute of ent
    { // if ("String".equals(att.getType() + ""))
      out.println(instance + "." + name + " = " + value); 
    } 
    else if ("xPos".equals(name) || "yPos".equals(name) ||
             "number".equals(name)) // trim off the quotes
    { String val = value.substring(1,value.length() - 1); 
      out.println(instance + "." + name + " = " + val); 
    } 
    else // association
    { // Association ast = ent.getDefinedRole(name); 
      if ("field".equals(name)) 
      { // if (ast.getCard2() == ModelElement.ONE)
        // value is single "//@inst.number" or "$id"
        int atind = value.indexOf("@");
        if (atind < 0) 
        { return; }   
        String obj = value.substring(atind + 1, value.length() -1); 
        int dotind = obj.indexOf(".");
        if (dotind < 0) { return; } 
        String obj1 = obj.substring(0,dotind); 
        String obj2 = obj.substring(dotind + 1, obj.length()); 
        out.println(instance + "." + name + " = " + obj1 + obj2); 
        return; 
      } 
      else if ("west".equals(name) || "east".equals(name) || "south".equals(name) ||
               "north".equals(name)) 
      { return; } 
      else // a list of objects
      { StringTokenizer st = new StringTokenizer(value,"\" "); 
        Vector objs = new Vector(); 
        String res = ""; 

        while (st.hasMoreTokens())
        { objs.add(st.nextToken()); }

        for (int i = 0; i < objs.size(); i++) 
        { String oneobj = (String) objs.get(i); 
          // System.out.println(oneobj); 

          int atind = oneobj.indexOf("@");
          if (atind < 0) 
          { continue; }   
          String obj = oneobj.substring(atind + 1, oneobj.length()); 
          int dotind = obj.indexOf(".");
          if (dotind < 0) 
          { // case of a ball: 
            out.println(obj + "0 : " + instance + "." + name);
            return; 
          } 
          String obj1 = obj.substring(0,dotind); 
          String obj2 = obj.substring(dotind + 1, obj.length()); 
          out.println(obj1 + obj2 + " : " + instance + "." + name); 
        }
      } 
    } 
  }  
}
