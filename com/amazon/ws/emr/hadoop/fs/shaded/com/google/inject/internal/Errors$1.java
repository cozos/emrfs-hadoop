package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import java.util.Comparator;

class Errors$1
  implements Comparator<Message>
{
  Errors$1(Errors paramErrors) {}
  
  public int compare(Message a, Message b)
  {
    return a.getSource().compareTo(b.getSource());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */