package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

class UnreliableTestConfig
{
  private int maxNumErrors = 1;
  private int bytesReadBeforeException = 100;
  private boolean isFakeIOException;
  private int resetIntervalBeforeException = 2;
  
  int getMaxNumErrors()
  {
    return maxNumErrors;
  }
  
  int getBytesReadBeforeException()
  {
    return bytesReadBeforeException;
  }
  
  boolean isFakeIOException()
  {
    return isFakeIOException;
  }
  
  int getResetIntervalBeforeException()
  {
    return resetIntervalBeforeException;
  }
  
  UnreliableTestConfig withMaxNumErrors(int maxNumErrors)
  {
    this.maxNumErrors = maxNumErrors;
    return this;
  }
  
  UnreliableTestConfig withBytesReadBeforeException(int bytesReadBeforeException)
  {
    this.bytesReadBeforeException = bytesReadBeforeException;
    return this;
  }
  
  UnreliableTestConfig withFakeIOException(boolean isFakeIOException)
  {
    this.isFakeIOException = isFakeIOException;
    return this;
  }
  
  UnreliableTestConfig withResetIntervalBeforeException(int resetIntervalBeforeException)
  {
    this.resetIntervalBeforeException = resetIntervalBeforeException;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.UnreliableTestConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */