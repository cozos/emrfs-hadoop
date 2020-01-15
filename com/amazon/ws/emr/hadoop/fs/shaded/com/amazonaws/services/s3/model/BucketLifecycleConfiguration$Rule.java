package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BucketLifecycleConfiguration$Rule
  implements Serializable
{
  private String id;
  private String prefix;
  private String status;
  private LifecycleFilter filter;
  private int expirationInDays = -1;
  private boolean expiredObjectDeleteMarker = false;
  private int noncurrentVersionExpirationInDays = -1;
  private Date expirationDate;
  private List<BucketLifecycleConfiguration.Transition> transitions;
  private List<BucketLifecycleConfiguration.NoncurrentVersionTransition> noncurrentVersionTransitions;
  private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  @Deprecated
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
  }
  
  public void setExpirationInDays(int expirationInDays)
  {
    this.expirationInDays = expirationInDays;
  }
  
  public void setNoncurrentVersionExpirationInDays(int value)
  {
    noncurrentVersionExpirationInDays = value;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Rule withId(String id)
  {
    this.id = id;
    return this;
  }
  
  @Deprecated
  public String getPrefix()
  {
    return prefix;
  }
  
  @Deprecated
  public Rule withPrefix(String prefix)
  {
    this.prefix = prefix;
    return this;
  }
  
  public int getExpirationInDays()
  {
    return expirationInDays;
  }
  
  public Rule withExpirationInDays(int expirationInDays)
  {
    this.expirationInDays = expirationInDays;
    return this;
  }
  
  public int getNoncurrentVersionExpirationInDays()
  {
    return noncurrentVersionExpirationInDays;
  }
  
  public Rule withNoncurrentVersionExpirationInDays(int value)
  {
    setNoncurrentVersionExpirationInDays(value);
    return this;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public Rule withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setExpirationDate(Date expirationDate)
  {
    this.expirationDate = expirationDate;
  }
  
  public Date getExpirationDate()
  {
    return expirationDate;
  }
  
  public Rule withExpirationDate(Date expirationDate)
  {
    this.expirationDate = expirationDate;
    return this;
  }
  
  @Deprecated
  public void setTransition(BucketLifecycleConfiguration.Transition transition)
  {
    setTransitions(Arrays.asList(new BucketLifecycleConfiguration.Transition[] { transition }));
  }
  
  @Deprecated
  public BucketLifecycleConfiguration.Transition getTransition()
  {
    List<BucketLifecycleConfiguration.Transition> transitions = getTransitions();
    return (transitions != null) && (!transitions.isEmpty()) ? 
      (BucketLifecycleConfiguration.Transition)transitions.get(transitions.size() - 1) : null;
  }
  
  @Deprecated
  public Rule withTransition(BucketLifecycleConfiguration.Transition transition)
  {
    setTransitions(Arrays.asList(new BucketLifecycleConfiguration.Transition[] { transition }));
    return this;
  }
  
  @Deprecated
  public void setNoncurrentVersionTransition(BucketLifecycleConfiguration.NoncurrentVersionTransition nonCurrentVersionTransition)
  {
    setNoncurrentVersionTransitions(
      Arrays.asList(new BucketLifecycleConfiguration.NoncurrentVersionTransition[] { nonCurrentVersionTransition }));
  }
  
  @Deprecated
  public BucketLifecycleConfiguration.NoncurrentVersionTransition getNoncurrentVersionTransition()
  {
    List<BucketLifecycleConfiguration.NoncurrentVersionTransition> transitions = getNoncurrentVersionTransitions();
    return (transitions != null) && (!transitions.isEmpty()) ? 
      (BucketLifecycleConfiguration.NoncurrentVersionTransition)transitions.get(transitions.size() - 1) : null;
  }
  
  @Deprecated
  public Rule withNoncurrentVersionTransition(BucketLifecycleConfiguration.NoncurrentVersionTransition nonCurrentVersionTransition)
  {
    setNoncurrentVersionTransitions(
      Arrays.asList(new BucketLifecycleConfiguration.NoncurrentVersionTransition[] { nonCurrentVersionTransition }));
    return this;
  }
  
  public List<BucketLifecycleConfiguration.Transition> getTransitions()
  {
    return transitions;
  }
  
  public void setTransitions(List<BucketLifecycleConfiguration.Transition> transitions)
  {
    this.transitions = new ArrayList(transitions);
  }
  
  public Rule withTransitions(List<BucketLifecycleConfiguration.Transition> transitions)
  {
    setTransitions(transitions);
    return this;
  }
  
  public Rule addTransition(BucketLifecycleConfiguration.Transition transition)
  {
    if (transition == null) {
      throw new IllegalArgumentException("Transition cannot be null.");
    }
    if (transitions == null) {
      transitions = new ArrayList();
    }
    transitions.add(transition);
    return this;
  }
  
  public List<BucketLifecycleConfiguration.NoncurrentVersionTransition> getNoncurrentVersionTransitions()
  {
    return noncurrentVersionTransitions;
  }
  
  public void setNoncurrentVersionTransitions(List<BucketLifecycleConfiguration.NoncurrentVersionTransition> noncurrentVersionTransitions)
  {
    this.noncurrentVersionTransitions = new ArrayList(noncurrentVersionTransitions);
  }
  
  public Rule withNoncurrentVersionTransitions(List<BucketLifecycleConfiguration.NoncurrentVersionTransition> noncurrentVersionTransitions)
  {
    setNoncurrentVersionTransitions(noncurrentVersionTransitions);
    return this;
  }
  
  public Rule addNoncurrentVersionTransition(BucketLifecycleConfiguration.NoncurrentVersionTransition noncurrentVersionTransition)
  {
    if (noncurrentVersionTransition == null) {
      throw new IllegalArgumentException("NoncurrentVersionTransition cannot be null.");
    }
    if (noncurrentVersionTransitions == null) {
      noncurrentVersionTransitions = new ArrayList();
    }
    noncurrentVersionTransitions.add(noncurrentVersionTransition);
    return this;
  }
  
  public AbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload()
  {
    return abortIncompleteMultipartUpload;
  }
  
  public void setAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload)
  {
    this.abortIncompleteMultipartUpload = abortIncompleteMultipartUpload;
  }
  
  public Rule withAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload)
  {
    setAbortIncompleteMultipartUpload(abortIncompleteMultipartUpload);
    return this;
  }
  
  public boolean isExpiredObjectDeleteMarker()
  {
    return expiredObjectDeleteMarker;
  }
  
  public void setExpiredObjectDeleteMarker(boolean expiredObjectDeleteMarker)
  {
    this.expiredObjectDeleteMarker = expiredObjectDeleteMarker;
  }
  
  public Rule withExpiredObjectDeleteMarker(boolean expiredObjectDeleteMarker)
  {
    this.expiredObjectDeleteMarker = expiredObjectDeleteMarker;
    return this;
  }
  
  public LifecycleFilter getFilter()
  {
    return filter;
  }
  
  public void setFilter(LifecycleFilter filter)
  {
    this.filter = filter;
  }
  
  public Rule withFilter(LifecycleFilter filter)
  {
    setFilter(filter);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Rule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */