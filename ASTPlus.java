public class ASTPlus implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.DuplicatedVersion, Env.UndeclaredIdentifier {
    IValue v1 = left.eval(e);
    IValue v2 = right.eval(e);

    if (v1.typeOf() == IValue.VType.INTEGER && v2.typeOf() == IValue.VType.INTEGER) {
      IntValue vl = (IntValue)v1;
      IntValue vr = (IntValue)v2;
      return new IntValue(vl.getVal() + vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTPlus(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public IType typeCheck(TypeEnv e) throws TypeError {

    IType l = left.typeCheck(e);
    IType r = right.typeCheck(e);

    if (l.typeOf() == IType.TType.INTEGER && r.typeOf() == IType.TType.INTEGER)
      return new IntType();
    else throw new TypeError();

  }

}
