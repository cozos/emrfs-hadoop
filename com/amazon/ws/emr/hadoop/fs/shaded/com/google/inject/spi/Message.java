package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;

public final class Message
  implements Serializable, Element
{
  private final String message;
  private final Throwable cause;
  private final List<Object> sources;
  private static final long serialVersionUID = 0L;
  
  public Message(List<Object> sources, String message, Throwable cause)
  {
    this.sources = .ImmutableList.copyOf(sources);
    this.message = ((String).Preconditions.checkNotNull(message, "message"));
    this.cause = cause;
  }
  
  public Message(Object source, String message)
  {
    this(.ImmutableList.of(source), message, null);
  }
  
  public Message(String message)
  {
    this(.ImmutableList.of(), message, null);
  }
  
  public String getSource()
  {
    return sources.isEmpty() ? .SourceProvider.UNKNOWN_SOURCE.toString() : Errors.convert(sources.get(sources.size() - 1)).toString();
  }
  
  public List<Object> getSources()
  {
    return sources;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public Throwable getCause()
  {
    return cause;
  }
  
  public String toString()
  {
    return message;
  }
  
  public int hashCode()
  {
    return message.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (!(o instanceof Message)) {
      return false;
    }
    Message e = (Message)o;
    return (message.equals(message)) && (.Objects.equal(cause, cause)) && (sources.equals(sources));
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).addError(this);
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    Object[] sourcesAsStrings = sources.toArray();
    for (int i = 0; i < sourcesAsStrings.length; i++) {
      sourcesAsStrings[i] = Errors.convert(sourcesAsStrings[i]).toString();
    }
    return new Message(.ImmutableList.of(sourcesAsStrings), message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */