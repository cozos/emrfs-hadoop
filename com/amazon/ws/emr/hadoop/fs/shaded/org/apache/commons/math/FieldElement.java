package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public abstract interface FieldElement<T>
{
  public abstract T add(T paramT);
  
  public abstract T subtract(T paramT);
  
  public abstract T multiply(T paramT);
  
  public abstract T divide(T paramT)
    throws ArithmeticException;
  
  public abstract Field<T> getField();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */