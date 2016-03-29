public class RefType implements IType{

  IType n;

  RefType(IType n) {
    this.n = n;
  }

  public TType typeOf() {
    return TType.REFERENCE;
  }

  public TType typeOfRef() {
    return n.typeOf();
  }

  public IType getRef() {
    return n;
  }

  public String toString() {
    //return "ref["+n.toString()+"]";
    return "ref";
  }
}
