public class IntValue implements IValue {

  int val;

  IntValue(int v) {
    val = v;
  }

  public VType typeOf() {
    return VType.INTEGER;
  }

  public int getVal() {
    return val;
  }

  public String toString() {
    return Integer.toString(val);
  }

}
