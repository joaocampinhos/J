import java.util.*;

public class ASTFun implements ASTNode {

  Vector<String> vs;
  Vector<String> vt;
  ASTNode body;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    FunValue f = new FunValue(vs, body, e);
    return f;
  }

  public ASTFun(Vector<String> vec, Vector<String> ty, ASTNode b) {
    vs = vec;
    vt = ty;
    body  = b;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    FunType f = new FunType(vt, vs, body, e);
    return f;
  }

}
