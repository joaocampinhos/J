import java.util.*;

public class TypeEnv {

  class Assoc {
    String id;
    IType v;
  
    public Assoc(String s, IType vi){
      id = s;
      v = vi;
    }
  
    String getId(){
      return id;
    }

    IType getValue(){
      return v;
    }
  }

  TypeEnv upper;
  Vector<Assoc> aList;

  private TypeEnv(TypeEnv up){
    upper = up;
    aList = new Vector<Assoc>(5,1);
  }

  public TypeEnv(){
    aList = new Vector<Assoc>(5,1);
  }

  private TypeEnv getUpper(){ 
      return upper;
  }

  public TypeEnv beginScope(){ 
    return new TypeEnv(this);
  }

  public TypeEnv endScope(){ 
      return upper;
  }

  IType find(String id){ 
      Iterator<Assoc> al = aList.iterator();
            while (al.hasNext()) 
    {   
        Assoc a = al.next();
        if (a.getId().equals(id))
      return a.getValue();
    }
      //if (upper != null) 
    return upper.find(id) ;
    //else throw new UndeclaredIdentifier(id);
  }

  void assoc(String id, IType v){ 
      Iterator<Assoc> al = aList.iterator();
            while (al.hasNext()) {   
        Assoc a = al.next();
        //if (a.getId().equals(id))
      //throw new IdentifierDeclaredTwice(id);
    }
      aList.addElement(new Assoc(id,v));
  }

  public String toString() {
    String res = "";
    Iterator<Assoc> al = aList.iterator();
            while (al.hasNext()) 
    {   
        Assoc a = al.next();
      res += a.getId() + "->" + a.getValue().toString() +"\n";
    }
    return res;
  }
}