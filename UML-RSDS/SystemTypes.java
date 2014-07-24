import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

public interface SystemTypes
{
  public class Set
  { private Vector elements = new Vector();

  public static List select_8(List _l)
  { List _results_8 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_8_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_8_xx.getteam().equals("RED")) && fieldplayer_8_xx.getnumber() == 9)
      { _results_8.add(fieldplayer_8_xx); }
    }
    return _results_8;
  }

  public static List select_2(List _l)
  { List _results_2 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_2_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_2_xx.getteam().equals("RED")) && fieldplayer_2_xx.getnumber() == 2)
      { _results_2.add(fieldplayer_2_xx); }
    }
    return _results_2;
  }

  public static List select_6(List _l)
  { List _results_6 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_6_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_6_xx.getteam().equals("RED")) && fieldplayer_6_xx.getnumber() == 7)
      { _results_6.add(fieldplayer_6_xx); }
    }
    return _results_6;
  }

  public static List select_1(List _l)
  { List _results_1 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_1_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_1_xx.getteam().equals("RED")) && fieldplayer_1_xx.getnumber() == 5)
      { _results_1.add(fieldplayer_1_xx); }
    }
    return _results_1;
  }

  public static List select_5(List _l)
  { List _results_5 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_5_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_5_xx.getteam().equals("RED")) && fieldplayer_5_xx.getnumber() == 6)
      { _results_5.add(fieldplayer_5_xx); }
    }
    return _results_5;
  }

  public static List select_7(List _l)
  { List _results_7 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_7_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_7_xx.getteam().equals("RED")) && fieldplayer_7_xx.getnumber() == 8)
      { _results_7.add(fieldplayer_7_xx); }
    }
    return _results_7;
  }

  public static List select_0(List _l)
  { List _results_0 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GoalKeeper goalkeeper_0_xx = (GoalKeeper) _l.get(_i);
      if (!(goalkeeper_0_xx.getteam().equals("RED")))
      { _results_0.add(goalkeeper_0_xx); }
    }
    return _results_0;
  }

  public static List select_4(List _l)
  { List _results_4 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_4_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_4_xx.getteam().equals("RED")) && fieldplayer_4_xx.getnumber() == 4)
      { _results_4.add(fieldplayer_4_xx); }
    }
    return _results_4;
  }

  public static List select_3(List _l)
  { List _results_3 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { FieldPlayer fieldplayer_3_xx = (FieldPlayer) _l.get(_i);
      if (!(fieldplayer_3_xx.getteam().equals("RED")) && fieldplayer_3_xx.getnumber() == 3)
      { _results_3.add(fieldplayer_3_xx); }
    }
    return _results_3;
  }






    public static boolean equals(List a, List b)
    { return a.containsAll(b) && b.containsAll(a); }


    public Set add(Object x)
    { elements.add(x);
      return this; }

    public Set add(int x)
    { elements.add(new Integer(x));
      return this; }

    public Set add(double x)
    { elements.add(new Double(x));
      return this; }

    public Set add(boolean x)
    { elements.add(new Boolean(x));
      return this; }

    public List getElements() { return elements; }


  public static Comparable max(List l)
  { Comparable res = null; 
    if (l.size() == 0) { return res; }
    res = (Comparable) l.get(0); 
    for (int i = 1; i < l.size(); i++)
    { Comparable e = (Comparable) l.get(i);
      if (res.compareTo(e) < 0) { res = e; } }
    return res; }


  public static Comparable min(List l)
  { Comparable res = null; 
    if (l.size() == 0) { return res; }
    res = (Comparable) l.get(0); 
    for (int i = 1; i < l.size(); i++)
    { Comparable e = (Comparable) l.get(i);
      if (res.compareTo(e) > 0) { res = e; } }
    return res; }


  public static List union(List a, List b)
  { List res = new Vector(); 
    for (int i = 0; i < a.size(); i++)
    { if (res.contains(a.get(i))) { } else { res.add(a.get(i)); } }
    for (int j = 0; j < b.size(); j++)
    { if (res.contains(b.get(j))) { } else { res.add(b.get(j)); } }
    return res; }


  public static List subtract(List a, List b)
  { List res = new Vector(); 
    res.addAll(a);
    res.removeAll(b);
    return res; }

  public static String subtract(String a, String b)
  { String res = ""; 
    for (int i = 0; i < a.length(); i++)
    { if (b.indexOf(a.charAt(i)) < 0) { res = res + a.charAt(i); } }
    return res; }



  public static List intersection(List a, List b)
  { List res = new Vector(); 
    res.addAll(a);
    res.retainAll(b);
    return res; }



  public static List symmetricDifference(List a, List b)
  { List res = new Vector();
    for (int i = 0; i < a.size(); i++)
    { Object _a = a.get(i);
      if (b.contains(_a) || res.contains(_a)) { }
      else { res.add(_a); }
    }
    for (int j = 0; j < b.size(); j++)
    { Object _b = b.get(j);
      if (a.contains(_b) || res.contains(_b)) { }
      else { res.add(_b); }
    }
    return res;
  }



  public static boolean isUnique(List evals)
  { List vals = new Vector(); 
    for (int i = 0; i < evals.size(); i++)
    { Object ob = evals.get(i); 
      if (vals.contains(ob)) { return false; }
      vals.add(ob);
    }
    return true;
  }


  public static int sumint(List a)
  { int sum = 0; 
    for (int i = 0; i < a.size(); i++)
    { Integer x = (Integer) a.get(i); 
      if (x != null) { sum += x.intValue(); }
    } 
    return sum; }

  public static double sumdouble(List a)
  { double sum = 0.0; 
    for (int i = 0; i < a.size(); i++)
    { Double x = (Double) a.get(i); 
      if (x != null) { sum += x.doubleValue(); }
    } 
    return sum; }

  public static String sumString(List a)
  { String sum = ""; 
    for (int i = 0; i < a.size(); i++)
    { Object x = a.get(i); 
      sum = sum + x; }
    return sum;  }



  public static List concatenate(List a, List b)
  { List res = new Vector(); 
    res.addAll(a); 
    res.addAll(b); 
    return res; }




  public static List asSet(List a)
  { List res = new Vector(); 
    for (int i = 0; i < a.size(); i++)
    { Object obj = a.get(i);
      if (res.contains(obj)) { } 
      else { res.add(obj); }
    } 
    return res; 
  }


  public static List reverse(List a)
  { List res = new Vector(); 
    for (int i = a.size() - 1; i >= 0; i--)
    { res.add(a.get(i)); } 
    return res; }

  public static String reverse(String a)
  { String res = ""; 
    for (int i = a.length() - 1; i >= 0; i--)
    { res = res + a.charAt(i); } 
    return res; }



  public static List front(List a)
  { List res = new Vector(); 
    for (int i = 0; i < a.size() - 1; i++)
    { res.add(a.get(i)); } 
    return res; }


  public static List tail(List a)
  { List res = new Vector(); 
    for (int i = 1; i < a.size(); i++)
    { res.add(a.get(i)); } 
    return res; }


  public static List sort(final List a)
  { int i = a.size()-1;
    return mergeSort(a,0,i);
  }

  static List mergeSort(final List a, int ind1, int ind2)
  { List res = new Vector();
    if (ind1 > ind2)
    { return res; }
    if (ind1 == ind2)
    { res.add(a.get(ind1));
      return res;
    }
    int mid = (ind1 + ind2)/2;
    List a1;
    List a2;
    if (mid == ind1)
    { a1 = new Vector();
      a1.add(a.get(ind1));
      a2 = mergeSort(a,mid+1,ind2);
    }
    else
    { a1 = mergeSort(a,ind1,mid-1);
      a2 = mergeSort(a,mid,ind2);
    }
    int i = 0;
    int j = 0;
    while (i < a1.size() && j < a2.size())
    { Comparable e1 = (Comparable) a1.get(i); 
      Comparable e2 = (Comparable) a2.get(j);
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(e1);
        i++; // get next e1
      } 
      else 
      { res.add(e2);
        j++; 
      } 
    } 
    if (i == a1.size())
    { for (int k = j; k < a2.size(); k++)
      { res.add(a2.get(k)); } 
    } 
    else 
    { for (int k = i; k < a1.size(); k++) 
      { res.add(a1.get(k)); } 
    } 
    return res;
  }


  public static List sortedBy(final List a, List f)
  { int i = a.size()-1;
    java.util.Map f_map = new java.util.HashMap();
    for (int j = 0; j < a.size(); j++)
    { f_map.put(a.get(j), f.get(j)); }
    return mergeSort(a,f_map,0,i);
  }

  static List mergeSort(final List a, java.util.Map f, int ind1, int ind2)
  { List res = new Vector();
    if (ind1 > ind2)
    { return res; }
    if (ind1 == ind2)
    { res.add(a.get(ind1));
      return res;
    }
    if (ind2 == ind1 + 1)
    { Comparable e1 = (Comparable) f.get(a.get(ind1)); 
      Comparable e2 = (Comparable) f.get(a.get(ind2));
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(a.get(ind1)); res.add(a.get(ind2)); return res; }
      else 
      { res.add(a.get(ind2)); res.add(a.get(ind1)); return res; }
    }    int mid = (ind1 + ind2)/2;
    List a1;
    List a2;
    if (mid == ind1)
    { a1 = new Vector();
      a1.add(a.get(ind1));
      a2 = mergeSort(a,f,mid+1,ind2);
    }
    else
    { a1 = mergeSort(a,f,ind1,mid-1);
      a2 = mergeSort(a,f,mid,ind2);
    }
    int i = 0;
    int j = 0;
    while (i < a1.size() && j < a2.size())
    { Comparable e1 = (Comparable) f.get(a1.get(i)); 
      Comparable e2 = (Comparable) f.get(a2.get(j));
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(a1.get(i));
        i++; // get next e1
      } 
      else 
      { res.add(a2.get(j));
        j++; 
      } 
    } 
    if (i == a1.size())
    { for (int k = j; k < a2.size(); k++)
      { res.add(a2.get(k)); } 
    } 
    else 
    { for (int k = i; k < a1.size(); k++) 
      { res.add(a1.get(k)); } 
    } 
    return res;
  }


  public static List integerSubrange(int i, int j)
  { List tmp = new Vector(); 
    for (int k = i; k <= j; k++)
    { tmp.add(new Integer(k)); } 
    return tmp;
  }

  public static String subrange(String s, int i, int j)
  { return s.substring(i-1,j); }

  public static List subrange(List l, int i, int j)
  { List tmp = new Vector(); 
    for (int k = i-1; k < j; k++)
    { tmp.add(l.get(k)); } 
    return tmp; 
  }



  public static List prepend(List l, Object ob)
  { List res = new Vector();
    res.add(ob);
    res.addAll(l);
    return res;
  }


  public static List append(List l, Object ob)
  { List res = new Vector();
    res.addAll(l);
    res.add(ob);
    return res;
  }


  public static int count(List l, Object obj)
  { int res = 0; 
    for (int _i = 0; _i < l.size(); _i++)
    { if (obj == l.get(_i)) { res++; } 
      else if (obj != null && obj.equals(l.get(_i))) { res++; } 
    }
    return res; 
  }

  public static int count(String s, String x)
  { int res = 0; 
    if ("".equals(s)) { return res; }
    int ind = s.indexOf(x); 
    if (ind == -1) { return res; }
    String ss = s.substring(ind+1,s.length());
    res++; 
    while (ind >= 0)
    { ind = ss.indexOf(x); 
      if (ind == -1 || ss.equals("")) { return res; }
      res++; 
      ss = ss.substring(ind+1,ss.length());
    } 
    return res;
  }



  public static List characters(String str)
  { char[] _chars = str.toCharArray();
    Vector _res = new Vector();
    for (int i = 0; i < _chars.length; i++)
    { _res.add("" + _chars[i]); }
    return _res;
  }



    public static Object any(List v)
    { if (v.size() == 0) { return null; }
      return v.get(0);
    }


    public static List subcollections(List v)
    { Vector res = new Vector();
      if (v.size() == 0)
      { res.add(new Vector());
        return res;
      }
      if (v.size() == 1)
      { res.add(new Vector());
        res.add(v);
        return res;
      }
      Vector s = new Vector();
      Object x = v.get(0);
      s.addAll(v);
      s.remove(0);
      List scs = subcollections(s);
      res.addAll(scs);
      for (int i = 0; i < scs.size(); i++)
      { Vector sc = (Vector) scs.get(i);
        Vector scc = new Vector();
        scc.add(x);
        scc.addAll(sc);
        res.add(scc);
      }
      return res;
    }


  public static Vector maximalElements(List s, List v)
  { Vector res = new Vector();
    if (s.size() == 0) { return res; }
    Comparable largest = (Comparable) v.get(0);
    res.add(s.get(0));
    
    for (int i = 1; i < s.size(); i++)
    { Comparable next = (Comparable) v.get(i);
      if (largest.compareTo(next) < 0)
      { largest = next;
        res.clear();
        res.add(s.get(i));
      }
      else if (largest.compareTo(next) == 0)
      { res.add(s.get(i)); }
    }
    return res;
  }

  public static Vector minimalElements(List s, List v)
  { Vector res = new Vector();
    if (s.size() == 0) { return res; }
    Comparable smallest = (Comparable) v.get(0);
    res.add(s.get(0));
    
    for (int i = 1; i < s.size(); i++)
    { Comparable next = (Comparable) v.get(i);
      if (next.compareTo(smallest) < 0)
      { smallest = next;
        res.clear();
        res.add(s.get(i));
      }
      else if (smallest.compareTo(next) == 0)
      { res.add(s.get(i)); }
    }
    return res;
  }


  public static List intersectAll(List se)
  { List res = new Vector(); 
    if (se.size() == 0) { return res; }
    res.addAll((List) se.get(0));
    for (int i = 1; i < se.size(); i++)
    { res.retainAll((List) se.get(i)); }
    return res;
  }



  public static List unionAll(List se)
  { List res = new Vector(); 
    for (int i = 0; i < se.size(); i++)
    { List b = (List) se.get(i); 
      for (int j = 0; j < b.size(); j++)
      { if (res.contains(b.get(j))) { } else { res.add(b.get(j)); } }
    }
    return res;
  }



  public static List insertAt(List l, int ind, Object ob)
  { List res = new Vector();
    for (int i = 0; i < ind-1 && i < l.size(); i++)
    { res.add(l.get(i)); }
    if (ind <= l.size() + 1) { res.add(ob); }
    for (int i = ind-1; i < l.size(); i++)
    { res.add(l.get(i)); }
    return res;
  }
  public static String insertAt(String l, int ind, Object ob)
  { String res = "";
    for (int i = 0; i < ind-1 && i < l.length(); i++)
    { res = res + l.charAt(i); }
    if (ind <= l.length() + 1) { res = res + ob; }
    for (int i = ind-1; i < l.length(); i++)
    { res = res + l.charAt(i); }
    return res;
  }


 public static boolean isInteger(String str)
  { try { Integer.parseInt(str); return true; }
    catch (Exception _e) { return false; }
  }


 public static boolean isReal(String str)
  { try { Double.parseDouble(str); return true; }
    catch (Exception _e) { return false; }
  }

  }
}
