import java.util.*;

public class FunType implements IType{

  Vector<String> vt, vid;
  ASTNode body;
  TypeEnv e;

  FunType(Vector<String> v, Vector<String> vid, ASTNode b, TypeEnv e) {
    vt = v;
    body = b;
    this.e = e;
    this.vid = vid;
  }

  public TType typeOf() {
    return TType.FUN;
  }

  public String toString() {
    return "function";
  }

  public Vector<String> getParameter() {
    return vt;
  }

  public Vector<String> getIds() {
    return vid;
  }

  public ASTNode getBody() {
    return body;
  }

  public TypeEnv getEnv() {
    return e;
  }
}
