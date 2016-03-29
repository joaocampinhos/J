public class RefValue implements IValue {

  IValue val;

  RefValue(IValue v) {
    val = v;
  }

  public VType typeOf() {
    return VType.REFERENCE;
  }

  public IValue getVal() {
    return val;
  }

  public void setVal(IValue i) {
    val = i;
  }

  public String toString() {
    return val.toString();
  }

}
