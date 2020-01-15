package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import java.util.Collection;

public final class ConfigurationException
  extends RuntimeException
{
  private final .ImmutableSet<Message> messages;
  private Object partialValue = null;
  private static final long serialVersionUID = 0L;
  
  public ConfigurationException(Iterable<Message> messages)
  {
    this.messages = .ImmutableSet.copyOf(messages);
    initCause(Errors.getOnlyCause(this.messages));
  }
  
  public ConfigurationException withPartialValue(Object partialValue)
  {
    .Preconditions.checkState(this.partialValue == null, "Can't clobber existing partial value %s with %s", new Object[] { this.partialValue, partialValue });
    
    ConfigurationException result = new ConfigurationException(messages);
    partialValue = partialValue;
    return result;
  }
  
  public Collection<Message> getErrorMessages()
  {
    return messages;
  }
  
  public <E> E getPartialValue()
  {
    return (E)partialValue;
  }
  
  public String getMessage()
  {
    return Errors.format("Guice configuration errors", messages);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */