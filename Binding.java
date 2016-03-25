public class Binding  {

  String id;
  ASTNode expr;

  public Binding(String s, ASTNode e)
  {
    id = s;
    expr = e;
  }

  String getId() 
  {
    return id;
  }

  ASTNode getExp() 
  {
    return expr;
  }

}

