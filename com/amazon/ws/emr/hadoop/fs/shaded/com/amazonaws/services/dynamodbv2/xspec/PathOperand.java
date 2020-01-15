package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Beta
@Immutable
public class PathOperand
  extends Operand
{
  private final Path path;
  private final String pathString;
  
  PathOperand(String path)
  {
    this.path = new Path(path);
    pathString = path;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    return path.asSubstituted(context);
  }
  
  public final FunctionCondition exists()
  {
    return ExpressionSpecBuilder.attribute_exists(this);
  }
  
  public final FunctionCondition notExists()
  {
    return ExpressionSpecBuilder.attribute_not_exists(this);
  }
  
  public final RemoveAction remove()
  {
    return new RemoveAction(this);
  }
  
  final String getPath()
  {
    return pathString;
  }
  
  public final String toString()
  {
    return pathString;
  }
  
  public final int hashCode()
  {
    return pathString.hashCode();
  }
  
  public final boolean equals(Object o)
  {
    if (!(o instanceof PathOperand)) {
      return false;
    }
    PathOperand that = (PathOperand)o;
    return getPath().equals(that.getPath());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.PathOperand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */