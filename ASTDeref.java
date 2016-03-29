
public class ASTDeref implements ASTNode {
  ASTNode t;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.DuplicatedVersion, Env.UndeclaredIdentifier {
    IValue i = t.eval(e);

    if (i.typeOf() == IValue.VType.REFERENCE) {
      RefValue v = (RefValue)i;
      return v.getVal();
    }
    else throw new TypeError();
  }

  public ASTDeref(ASTNode n) {
    t = n;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    IType tt = t.typeCheck(e);
    if (tt.typeOf() == IType.TType.REFERENCE) {
      RefType res = (RefType)tt;

      return res.getRef();
    }
    else throw new TypeError();
  }

}
