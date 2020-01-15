package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import java.io.IOException;

public abstract interface HttpMessageWriter<T extends HttpMessage>
{
  public abstract void write(T paramT)
    throws IOException, HttpException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */