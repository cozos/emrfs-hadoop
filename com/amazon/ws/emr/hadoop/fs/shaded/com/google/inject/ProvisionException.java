package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import java.util.Collection;

public final class ProvisionException
  extends RuntimeException
{
  private final .ImmutableSet<Message> messages;
  private static final long serialVersionUID = 0L;
  
  public ProvisionException(Iterable<Message> messages)
  {
    this.messages = .ImmutableSet.copyOf(messages);
    .Preconditions.checkArgument(!this.messages.isEmpty());
    initCause(Errors.getOnlyCause(this.messages));
  }
  
  public ProvisionException(String message, Throwable cause)
  {
    super(cause);
    messages = .ImmutableSet.of(new Message(.ImmutableList.of(), message, cause));
  }
  
  public ProvisionException(String message)
  {
    messages = .ImmutableSet.of(new Message(message));
  }
  
  public Collection<Message> getErrorMessages()
  {
    return messages;
  }
  
  public String getMessage()
  {
    return Errors.format("Guice provision errors", messages);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ProvisionException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */