import java.util.*;

public class ASTDecl implements ASTNode {
  ASTNode t;
  Vector<Binding> ve;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    Iterator<Binding> it = ve.iterator();
    Env en = e.beginScope();

    while (it.hasNext()) {
      Binding a = it.next();
      en.assoc(a.getId(), a.getExp().eval(en));
    }

    IValue v = t.eval(en);

    en.endScope();

    return v;
  }

  public ASTDecl(Vector<Binding> ve, ASTNode t) {
    this.ve = ve;
    this.t  = t;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{

    Iterator<Binding> it = ve.iterator();
    TypeEnv en = e.beginScope();

    while (it.hasNext()) {
      Binding a = it.next();
      en.assoc(a.getId(), a.getExp().typeCheck(en));
    }

    IType v = t.typeCheck(en);
    en.endScope();

    return new CmdType();
  }

}
