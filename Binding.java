public class Binding  {

  String id;
  int vs;
  boolean isVs;
  ASTNode expr;

  public Binding(String s, int v, ASTNode e)
  {
    id = s;
    vs = v;
    expr = e;
    isVs = true;
  }

  public Binding(String s, ASTNode e)
  {
    id = s;
    expr = e;
    isVs = false;
  }

  String getId()
  {
    return id;
  }

  boolean isVersioned() {
    return isVs;
  }

  int getVersion()
  {
    return vs;
  }

  ASTNode getExp()
  {
    return expr;
  }

}

