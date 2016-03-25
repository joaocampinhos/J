import java.util.*;

public class Env {

  class Assoc {
    String id;
    IValue v;

    public Assoc(String s, IValue vi)
    {
      id = s;
      v = vi;
    }

    String getId()
    {
      return id;
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
    Iterator<Assoc> al = alist.iterator();
    while (al.hasNext())
    {
      Assoc a = al.next();
      if (a.getId().equals(id))
        return a.getValue();
    }
    if (upper != null)
      return upper.find(id) ;
    else throw new UndeclaredIdentifier(id);
  }

  void assoc(String id, IValue v) throws IdentifierDeclaredTwice
  {
    Iterator<Assoc> al = alist.iterator();
    while (al.hasNext()) {
      Assoc a = al.next();
      if (a.getId().equals(id))
        throw new IdentifierDeclaredTwice(id);
    }
    alist.addElement(new Assoc(id,v));
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

