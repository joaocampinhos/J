import java.util.*;

public class Env {

  class Assoc {
    String id;
    int version;
    boolean isVs;
    IValue v;

    public Assoc(String s, IValue vi)
    {
      id = s;
      v = vi;
      isVs = false;
    }

    public Assoc(String s, int vs, IValue vi)
    {
      id = s;
      version = vs;
      v = vi;
      isVs = true;
    }

    String getId()
    {
      return id;
    }

    boolean isVersioned () {
      return isVs;
    }

    int getVersion()
    {
      return version;
    }

    IValue getValue()
    {
      return v;
    }
  }

  public class UndeclaredIdentifier extends Exception {
    String id;

    public UndeclaredIdentifier(String s)
    {
      id = s;
    }
  }

  public class DuplicatedVersion extends Exception {
    Integer id;

    public DuplicatedVersion(Integer s)
    {
      id = s;
    }
  }

  public class IdentifierDeclaredTwice extends Exception {
    String id;

    public IdentifierDeclaredTwice(String s)
    {
      id = s;
    }
  }



  Env upper;
  Vector<Assoc> alist;

  private Env(Env up)
  {
    upper = up;
    alist = new Vector<Assoc>(5,1);
  }

  public Env()
  {
    alist = new Vector<Assoc>(5,1);
  }

  private Env getUpper()
  {
    return upper;
  }

  public Env beginScope()
  {
    //upper = new Env(upper);
    //return upper;
    return new Env(this);
  }

  public Env endScope()
  {
    return upper;
  }

  IValue find(String id) throws UndeclaredIdentifier
  {
    IValue res = null;
    int bigV = 0;
    Iterator<Assoc> al = alist.iterator();
    while (al.hasNext())
    {
      Assoc a = al.next();
      if (a.getId().equals(id)) {
        if (a.getVersion() >= bigV) {
            res = a.getValue();
            bigV = a.getVersion();
        }
      }
    }
    if (res != null) return res;
    if (upper != null)
      return upper.find(id) ;
    else throw new UndeclaredIdentifier(id);
  }

  IValue find(String id, Integer v) throws UndeclaredIdentifier
  {
    System.out.println("Encontra: ("+id+","+v+")");
    System.out.println(toString());
    Iterator<Assoc> al = alist.iterator();
    while (al.hasNext())
    {
      Assoc a = al.next();
      if (a.getId().equals(id)) {
        if (a.isVersioned()) {
          if (a.getVersion() == v) {
            return a.getValue();
          }
        }
        else {
          return a.getValue();
        }
      }
    }
    if (upper != null)
      return upper.find(id,v) ;
    else throw new UndeclaredIdentifier(id);
  }

  void assoc(String id, IValue v) throws IdentifierDeclaredTwice
  {
    //System.out.println("Assoc: ("+id+")");
    Iterator<Assoc> al = alist.iterator();
    while (al.hasNext()) {
      Assoc a = al.next();
      //TODO: fix hack
      if (a.getId().equals(id) && id != "this")
        throw new IdentifierDeclaredTwice(id);
    }
    alist.addElement(new Assoc(id,v));
  }

  void assoc(String id, int vs, IValue v) throws IdentifierDeclaredTwice, DuplicatedVersion
  {
    //System.out.println("Assoc: ("+id+","+v+")");
    Iterator<Assoc> al = alist.iterator();
    while (al.hasNext()) {
      Assoc a = al.next();
      if (a.getId().equals(id))
        if(a.getVersion() == vs)
          throw new DuplicatedVersion(vs);
      }
    alist.addElement(new Assoc(id, vs, v));
  }

  public String toString() {
    String res = "";
    Iterator<Assoc> al = alist.iterator();
    while (al.hasNext())
    {
      Assoc a = al.next();
      res += a.getId() + "->" + a.getValue().toString() +"\n";
    }
    return res;
  }

}

