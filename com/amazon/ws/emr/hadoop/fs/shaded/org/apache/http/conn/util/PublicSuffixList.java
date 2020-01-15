package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Collections;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public final class PublicSuffixList
{
  private final DomainType type;
  private final List<String> rules;
  private final List<String> exceptions;
  
  public PublicSuffixList(DomainType type, List<String> rules, List<String> exceptions)
  {
    this.type = ((DomainType)Args.notNull(type, "Domain type"));
    this.rules = Collections.unmodifiableList((List)Args.notNull(rules, "Domain suffix rules"));
    this.exceptions = Collections.unmodifiableList(exceptions != null ? exceptions : Collections.emptyList());
  }
  
  public PublicSuffixList(List<String> rules, List<String> exceptions)
  {
    this(DomainType.UNKNOWN, rules, exceptions);
  }
  
  public DomainType getType()
  {
    return type;
  }
  
  public List<String> getRules()
  {
    return rules;
  }
  
  public List<String> getExceptions()
  {
    return exceptions;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */