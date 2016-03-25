public class RecType implements IType{

  TypeEnv e;

  RecType(TypeEnv e) {
    this.e = e;
  }

  public TType typeOf() {
    return TType.RECORD;
  }

  public TypeEnv getEnv() {
    return e;
  }

  public String toString() {
    return "rec";
  }
}
