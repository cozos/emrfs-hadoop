package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public class ResetException
  extends SdkClientException
{
  private static final long serialVersionUID = 1L;
  private String extraInfo;
  
  public ResetException(String message, Throwable t)
  {
    super(message, t);
  }
  
  public ResetException(Throwable t)
  {
    super("", t);
  }
  
  public ResetException(String message)
  {
    super(message);
  }
  
  public ResetException()
  {
    super("");
  }
  
  public boolean isRetryable()
  {
    return false;
  }
  
  public String getMessage()
  {
    String msg = super.getMessage();
    return msg + ";  " + extraInfo;
  }
  
  public String getExtraInfo()
  {
    return extraInfo;
  }
  
  public void setExtraInfo(String extraInfo)
  {
    this.extraInfo = extraInfo;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResetException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */