public class RecValue implements IValue {

  Env e;

  RecValue(Env e) {
    this.e = e;
  }

  public VType typeOf() {
    return VType.REC;
  }

  public Env getEnv() {
    return e;
  }

}
