public interface IType {

  public enum TType {
    CMD,
    FUN,
    RECORD,
    INTEGER,
    BOOLEAN,
    REFERENCE
  }

  TType typeOf();

  String toString();

}
