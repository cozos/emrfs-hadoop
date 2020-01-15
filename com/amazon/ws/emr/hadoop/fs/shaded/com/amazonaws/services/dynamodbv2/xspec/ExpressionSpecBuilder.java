package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Beta
public final class ExpressionSpecBuilder
  implements Cloneable
{
  private final Map<String, List<UpdateAction>> updates;
  private Condition keyCondition;
  private Condition condition;
  private final Set<PathOperand> projections;
  
  public ExpressionSpecBuilder()
  {
    updates = new LinkedHashMap();
    projections = new LinkedHashSet();
  }
  
  private ExpressionSpecBuilder(ExpressionSpecBuilder from)
  {
    updates = new LinkedHashMap(updates);
    projections = new LinkedHashSet(projections);
    keyCondition = keyCondition;
    condition = condition;
  }
  
  public ExpressionSpecBuilder addUpdate(UpdateAction updateAction)
  {
    String operator = updateAction.getOperator();
    List<UpdateAction> list = (List)updates.get(operator);
    if (list == null)
    {
      list = new LinkedList();
      updates.put(operator, list);
    }
    list.add(updateAction);
    return this;
  }
  
  public ExpressionSpecBuilder withCondition(Condition condition)
  {
    this.condition = condition;
    return this;
  }
  
  public ExpressionSpecBuilder withKeyCondition(Condition keyCondition)
  {
    this.keyCondition = keyCondition;
    return this;
  }
  
  public ExpressionSpecBuilder addProjection(String path)
  {
    projections.add(new PathOperand(path));
    return this;
  }
  
  public ExpressionSpecBuilder addProjections(String... paths)
  {
    for (String path : paths) {
      addProjection(path);
    }
    return this;
  }
  
  public DeleteItemExpressionSpec buildForDeleteItem()
  {
    return new DeleteItemExpressionSpec(this);
  }
  
  public GetItemExpressionSpec buildForGetItem()
  {
    return new GetItemExpressionSpec(this);
  }
  
  public QueryExpressionSpec buildForQuery()
  {
    return new QueryExpressionSpec(this);
  }
  
  public ScanExpressionSpec buildForScan()
  {
    return new ScanExpressionSpec(this);
  }
  
  public UpdateItemExpressionSpec buildForUpdate()
  {
    return new UpdateItemExpressionSpec(this);
  }
  
  public PutItemExpressionSpec buildForPut()
  {
    return new PutItemExpressionSpec(this);
  }
  
  String buildUpdateExpression(SubstitutionContext context)
  {
    StringBuilder sb = new StringBuilder();
    for (Iterator localIterator1 = updates.entrySet().iterator(); localIterator1.hasNext();)
    {
      e = (Map.Entry)localIterator1.next();
      firstOfUpdateType = true;
      for (UpdateAction expr : (List)e.getValue())
      {
        if (firstOfUpdateType)
        {
          firstOfUpdateType = false;
          String operator = (String)e.getKey();
          if (sb.length() > 0) {
            sb.append(" ");
          }
          sb.append(operator).append(" ");
        }
        else
        {
          sb.append(", ");
        }
        sb.append(expr.asSubstituted(context));
      }
    }
    Map.Entry<String, List<UpdateAction>> e;
    boolean firstOfUpdateType;
    return sb.toString();
  }
  
  String buildProjectionExpression(SubstitutionContext context)
  {
    if (projections.size() == 0) {
      return null;
    }
    StringBuilder sb = new StringBuilder();
    for (PathOperand projection : projections)
    {
      if (sb.length() > 0) {
        sb.append(", ");
      }
      sb.append(projection.asSubstituted(context));
    }
    return sb.toString();
  }
  
  String buildConditionExpression(SubstitutionContext context)
  {
    return condition == null ? null : condition.asSubstituted(context);
  }
  
  String buildKeyConditionExpression(SubstitutionContext context)
  {
    return keyCondition == null ? null : keyCondition.asSubstituted(context);
  }
  
  public ExpressionSpecBuilder clone()
  {
    return new ExpressionSpecBuilder(this);
  }
  
  static <T> IfNotExistsFunction<T> if_not_exists(PathOperand pathOperand, Operand operand)
  {
    return new IfNotExistsFunction(pathOperand, operand);
  }
  
  public static IfNotExistsFunction<N> if_not_exists(String path, Number defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<B> if_not_exists(String path, byte[] defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<B> if_not_exists(String path, ByteBuffer defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<BOOL> if_not_exists(String path, boolean defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<BS> if_not_exists(String path, byte[]... defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<BS> if_not_exists(String path, ByteBuffer... defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<L> if_not_exists(String path, List<?> defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<M> if_not_exists(String path, Map<String, ?> defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<NS> if_not_exists(String path, Number... defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<S> if_not_exists(String path, String defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static IfNotExistsFunction<SS> if_not_exists(String path, String... defaultValue)
  {
    return if_not_exists(new PathOperand(path), new LiteralOperand(defaultValue));
  }
  
  public static <T> ListAppendFunction list_append(String path, T value)
  {
    LinkedList<T> list = new LinkedList();
    list.add(value);
    return list_append(path, list);
  }
  
  public static <T> ListAppendFunction list_append(String path, List<? extends T> value)
  {
    return new ListAppendFunction(L(path), new ListLiteralOperand(new LinkedList(value)));
  }
  
  public static <T> ListAppendFunction list_append(List<? extends T> value, String path)
  {
    return new ListAppendFunction(new ListLiteralOperand(new LinkedList(value)), 
      L(path));
  }
  
  public static <T> FunctionCondition attribute_exists(PathOperand pathOperand)
  {
    return new FunctionCondition("attribute_exists", pathOperand);
  }
  
  public static <T> FunctionCondition attribute_exists(String path)
  {
    return attribute_exists(new PathOperand(path));
  }
  
  public static FunctionCondition attribute_not_exists(PathOperand pathOperand)
  {
    return new FunctionCondition("attribute_not_exists", pathOperand);
  }
  
  public static FunctionCondition attribute_not_exists(String path)
  {
    return attribute_not_exists(new PathOperand(path));
  }
  
  public static <T> NegationCondition not(Condition cond)
  {
    return new NegationCondition(cond);
  }
  
  public static RemoveAction remove(String path)
  {
    return new PathOperand(path).remove();
  }
  
  public static PathOperand attribute(String path)
  {
    return new PathOperand(path);
  }
  
  public static BOOL BOOL(String path)
  {
    return new BOOL(path);
  }
  
  public static NULL NULL(String path)
  {
    return new NULL(path);
  }
  
  public static B B(String path)
  {
    return new B(path);
  }
  
  public static N N(String path)
  {
    return new N(path);
  }
  
  public static S S(String path)
  {
    return new S(path);
  }
  
  public static BS BS(String path)
  {
    return new BS(path);
  }
  
  public static NS NS(String path)
  {
    return new NS(path);
  }
  
  public static SS SS(String path)
  {
    return new SS(path);
  }
  
  public static L L(String path)
  {
    return new L(path);
  }
  
  public static M M(String path)
  {
    return new M(path);
  }
  
  public static <T> ParenthesizedCondition parenthesize(Condition condition)
  {
    return ParenthesizedCondition.getInstance(condition);
  }
  
  public static <T> ParenthesizedCondition _(Condition condition)
  {
    return parenthesize(condition);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ExpressionSpecBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */