package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

public class ObjectTagging
  implements Serializable
{
  private List<Tag> tagSet;
  
  public ObjectTagging(List<Tag> tagSet)
  {
    this.tagSet = tagSet;
  }
  
  public List<Tag> getTagSet()
  {
    return tagSet;
  }
  
  public void setTagSet(List<Tag> tagSet)
  {
    this.tagSet = tagSet;
  }
  
  private ObjectTagging withTagSet(List<Tag> tagSet)
  {
    this.tagSet = tagSet;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectTagging
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */