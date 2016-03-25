import java.util.*;

public class FunValue implements IValue {

  Vector<String> vs;
  ASTNode body;
  Env e;

  FunValue(Vector<String> vec, ASTNode b, Env e) {
    vs = vec;
    body = b;
    this.e = e;
  }

  public VType typeOf() {
    return VType.FUN;
  }

  public String toString() {
    return body.toString();
  }

  public Vector<String> getParameter(){
    return vs;
  };

  public ASTNode getBody(){
    return body;
  };

  public Env getEnv() {
    return e;
  };

}
