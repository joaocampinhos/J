import java.util.*;

public class ASTRecord implements ASTNode {
  Vector<Binding> ve;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.DuplicatedVersion, Env.UndeclaredIdentifier {
    Env eaux = e.beginScope();

    RecValue r = new RecValue(eaux);
    e.assoc("this", r);

    Iterator<Binding> it = ve.iterator();
    while(it.hasNext()) {
      Binding a = it.next();
      eaux.assoc(a.getId(), a.getVersion(), a.getExp().eval(e));
    }

    eaux.endScope();
    return r;
  }

  public ASTRecord(Vector<Binding> ve) {
    this.ve = ve;
  }

  public IType typeCheck(TypeEnv e) throws TypeError {

    TypeEnv eaux = e.beginScope();

    RecType r = new RecType(eaux);
    e.assoc("this", r);

    Iterator<Binding> it = ve.iterator();
    while(it.hasNext()) {
      Binding a = it.next();
      eaux.assoc(a.getId(), a.getExp().typeCheck(e));
    }

    eaux.endScope();
    return r;
  }

}
