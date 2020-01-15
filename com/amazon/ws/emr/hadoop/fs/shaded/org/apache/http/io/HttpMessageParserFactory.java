package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;

public abstract interface HttpMessageParserFactory<T extends HttpMessage>
{
  public abstract HttpMessageParser<T> create(SessionInputBuffer paramSessionInputBuffer, MessageConstraints paramMessageConstraints);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */