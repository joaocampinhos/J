public interface ASTNode {
  IValue eval(Env e) throws TypeError, Env.DuplicatedVersion, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier;
  IType typeCheck(TypeEnv e) throws TypeError;
}
