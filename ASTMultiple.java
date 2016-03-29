public class ASTMultiple implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.DuplicatedVersion, Env.UndeclaredIdentifier {

    IValue v1 = left.eval(e);

    e.beginScope();
    IValue v2 = right.eval(e);
    e.endScope();

    return v2;
  }

  public ASTMultiple(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{

    left.typeCheck(e);
    IType res = right.typeCheck(e);

    return res;
  }
}
