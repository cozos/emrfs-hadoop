package com.amazon.ws.emr.hadoop.fs.dynamodb;

public class ItemKeyCondition
{
  private final ItemKey itemKey;
  private final Condition condition;
  
  public ItemKeyCondition(ItemKey itemKey, Condition condition)
  {
    this.itemKey = itemKey;
    this.condition = condition;
  }
  
  public Condition getCondition()
  {
    return condition;
  }
  
  public ItemKey getItemKey()
  {
    return itemKey;
  }
  
  public static ItemKeyCondition of(ItemKey itemKey, Condition condition)
  {
    return new ItemKeyCondition(itemKey, condition);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKeyCondition
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */