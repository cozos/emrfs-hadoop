package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public class SingularMatrixException
  extends InvalidMatrixException
{
  private static final long serialVersionUID = -7379143356784298432L;
  
  public SingularMatrixException()
  {
    super("matrix is singular", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.SingularMatrixException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */