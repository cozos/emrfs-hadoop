package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface ExceptionLogger
{
  public static final ExceptionLogger NO_OP = new ExceptionLogger()
  {
    public void log(Exception ex) {}
  };
  public static final ExceptionLogger STD_ERR = new ExceptionLogger()
  {
    public void log(Exception ex)
    {
      ex.printStackTrace();
    }
  };
  
  public abstract void log(Exception paramException);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ExceptionLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */