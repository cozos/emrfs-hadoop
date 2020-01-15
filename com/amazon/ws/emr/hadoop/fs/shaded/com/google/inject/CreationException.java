package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import java.util.Collection;

public class CreationException
  extends RuntimeException
{
  private final .ImmutableSet<Message> messages;
  private static final long serialVersionUID = 0L;
  
  public CreationException(Collection<Message> messages)
  {
    this.messages = .ImmutableSet.copyOf(messages);
    .Preconditions.checkArgument(!this.messages.isEmpty());
    initCause(Errors.getOnlyCause(this.messages));
  }
  
  public Collection<Message> getErrorMessages()
  {
    return messages;
  }
  
  public String getMessage()
  {
    return Errors.format("Guice creation errors", messages);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.CreationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */