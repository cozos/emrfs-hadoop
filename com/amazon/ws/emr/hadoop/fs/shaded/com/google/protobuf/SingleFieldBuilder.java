package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  implements GeneratedMessage.BuilderParent
{
  private GeneratedMessage.BuilderParent parent;
  private BType builder;
  private MType message;
  private boolean isClean;
  
  public SingleFieldBuilder(MType message, GeneratedMessage.BuilderParent parent, boolean isClean)
  {
    if (message == null) {
      throw new NullPointerException();
    }
    this.message = message;
    this.parent = parent;
    this.isClean = isClean;
  }
  
  public void dispose()
  {
    parent = null;
  }
  
  public MType getMessage()
  {
    if (message == null) {
      message = ((GeneratedMessage)builder.buildPartial());
    }
    return message;
  }
  
  public MType build()
  {
    isClean = true;
    return getMessage();
  }
  
  public BType getBuilder()
  {
    if (builder == null)
    {
      builder = ((GeneratedMessage.Builder)message.newBuilderForType(this));
      builder.mergeFrom(message);
      builder.markClean();
    }
    return builder;
  }
  
  public IType getMessageOrBuilder()
  {
    if (builder != null) {
      return builder;
    }
    return message;
  }
  
  public SingleFieldBuilder<MType, BType, IType> setMessage(MType message)
  {
    if (message == null) {
      throw new NullPointerException();
    }
    this.message = message;
    if (builder != null)
    {
      builder.dispose();
      builder = null;
    }
    onChanged();
    return this;
  }
  
  public SingleFieldBuilder<MType, BType, IType> mergeFrom(MType value)
  {
    if ((builder == null) && (message == message.getDefaultInstanceForType())) {
      message = value;
    } else {
      getBuilder().mergeFrom(value);
    }
    onChanged();
    return this;
  }
  
  public SingleFieldBuilder<MType, BType, IType> clear()
  {
    message = ((GeneratedMessage)(message != null ? message.getDefaultInstanceForType() : builder.getDefaultInstanceForType()));
    if (builder != null)
    {
      builder.dispose();
      builder = null;
    }
    onChanged();
    return this;
  }
  
  private void onChanged()
  {
    if (builder != null) {
      message = null;
    }
    if ((isClean) && (parent != null))
    {
      parent.markDirty();
      
      isClean = false;
    }
  }
  
  public void markDirty()
  {
    onChanged();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.SingleFieldBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */