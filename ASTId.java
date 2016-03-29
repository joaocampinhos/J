public class ASTId implements ASTNode {
  String val;
  int version;
  boolean isVersioned;

  public IValue eval(Env e) throws Env.UndeclaredIdentifier {
    if (isVersioned)
      return e.find(val,version);
    else
      return e.find(val);
  }

  public ASTId(String n) {
    val = n;
    isVersioned = false;
  }

  public ASTId(String n, int v) {
    val = n;
    version = v;
    isVersioned = true;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    return e.find(val);
  }

  public String toString() {
   return val+"@"+version;
  }

}
