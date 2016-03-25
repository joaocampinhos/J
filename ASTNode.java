public interface ASTNode {
  IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier;
  IType typeCheck(TypeEnv e) throws TypeError;
}
