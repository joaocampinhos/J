import java.util.*;

public class ASTCall implements ASTNode {
  Vector<ASTNode> vs;
  ASTNode body;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{
    IValue f = body.eval(e);
    if (f.typeOf() == IValue.VType.FUN) {
      FunValue fun = (FunValue)f;
      Env ee = fun.getEnv();
      Env en = ee.beginScope();
      Vector<String> vv = fun.getParameter();
      Iterator<ASTNode> it = vs.iterator();
      Iterator<String> iv = vv.iterator();
      while(iv.hasNext()) {
        String d = iv.next();
        ASTNode a = it.next();
        IValue b = a.eval(e);
        en.assoc(d, b);
      }
      IValue r = fun.getBody().eval(en);
      en.endScope();
      return r;
    } else throw new TypeError();
  }

  public ASTCall(Vector<ASTNode> vec, ASTNode b) {
    vs = vec;
    body  = b;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    IType f = body.typeCheck(e);
    if (f.typeOf() == IType.TType.FUN) {
      FunType fun = (FunType)f;
      TypeEnv ee = fun.getEnv();
      TypeEnv en = ee.beginScope();

      Vector<String> vv = fun.getParameter();
      Vector<String> vi = fun.getIds();

      Iterator<ASTNode> it = vs.iterator();
      Iterator<String> iv = vv.iterator();
      Iterator<String> vid = vi.iterator();

      while(iv.hasNext()) {

        String d = iv.next();
        ASTNode a = it.next();
        String id = vid.next();

        IType b = a.typeCheck(e);
        if (b.toString().equals(d)) {
          en.assoc(id, b);
        } else throw new TypeError();
      }

      IType r = fun.getBody().typeCheck(en);
      en.endScope();

      return r;
    } else throw new TypeError();
  }

}
