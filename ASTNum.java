public class ASTNum implements ASTNode {
  int val;

  public IValue eval(Env e) {
    return new IntValue(val);
  }

  public ASTNum(int n) {
    val = n;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    return new IntType();
  }

}
