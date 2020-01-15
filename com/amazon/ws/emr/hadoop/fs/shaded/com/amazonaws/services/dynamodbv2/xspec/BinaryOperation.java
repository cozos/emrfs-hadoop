package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

abstract class BinaryOperation
  extends UnitOfExpression
{
  private final Operand leftOperand;
  private final String operator;
  private final Operand rightOperand;
  
  BinaryOperation(Operand lhs, String operator, Operand rhs)
  {
    leftOperand = lhs;
    this.operator = operator;
    rightOperand = rhs;
  }
  
  final String asSubstituted(SubstitutionContext context)
  {
    return 
      leftOperand.asSubstituted(context) + " " + operator + " " + rightOperand.asSubstituted(context);
  }
  
  Operand getLhs()
  {
    return leftOperand;
  }
  
  String getOperator()
  {
    return operator;
  }
  
  Operand getRhs()
  {
    return rightOperand;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.BinaryOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */