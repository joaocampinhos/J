public interface IValue {

  public enum VType {
    ID,
    FUN,
    REC,
    INTEGER,
    BOOLEAN,
    REFERENCE
  }

  VType typeOf();

  String toString();

}
