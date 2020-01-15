package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BucketTaggingConfiguration
  implements Serializable
{
  private List<TagSet> tagSets = null;
  
  public BucketTaggingConfiguration()
  {
    tagSets = new ArrayList(1);
  }
  
  public BucketTaggingConfiguration(Collection<TagSet> tagSets)
  {
    this.tagSets = new ArrayList(1);
    this.tagSets.addAll(tagSets);
  }
  
  public BucketTaggingConfiguration withTagSets(TagSet... tagSets)
  {
    this.tagSets.clear();
    for (int index = 0; index < tagSets.length; index++) {
      this.tagSets.add(tagSets[index]);
    }
    return this;
  }
  
  public void setTagSets(Collection<TagSet> tagSets)
  {
    this.tagSets.clear();
    this.tagSets.addAll(tagSets);
  }
  
  public List<TagSet> getAllTagSets()
  {
    return tagSets;
  }
  
  public TagSet getTagSet()
  {
    return (TagSet)tagSets.get(0);
  }
  
  public TagSet getTagSetAtIndex(int index)
  {
    return (TagSet)tagSets.get(index);
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("{");
    sb.append("TagSets: " + getAllTagSets());
    sb.append("}");
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketTaggingConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */