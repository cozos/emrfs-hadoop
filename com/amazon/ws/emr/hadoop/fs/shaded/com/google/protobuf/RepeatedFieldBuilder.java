package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  implements GeneratedMessage.BuilderParent
{
  private GeneratedMessage.BuilderParent parent;
  private List<MType> messages;
  private boolean isMessagesListMutable;
  private List<SingleFieldBuilder<MType, BType, IType>> builders;
  private boolean isClean;
  private MessageExternalList<MType, BType, IType> externalMessageList;
  private BuilderExternalList<MType, BType, IType> externalBuilderList;
  private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
  
  public RepeatedFieldBuilder(List<MType> messages, boolean isMessagesListMutable, GeneratedMessage.BuilderParent parent, boolean isClean)
  {
    this.messages = messages;
    this.isMessagesListMutable = isMessagesListMutable;
    this.parent = parent;
    this.isClean = isClean;
  }
  
  public void dispose()
  {
    parent = null;
  }
  
  private void ensureMutableMessageList()
  {
    if (!isMessagesListMutable)
    {
      messages = new ArrayList(messages);
      isMessagesListMutable = true;
    }
  }
  
  private void ensureBuilders()
  {
    if (builders == null)
    {
      builders = new ArrayList(messages.size());
      for (int i = 0; i < messages.size(); i++) {
        builders.add(null);
      }
    }
  }
  
  public int getCount()
  {
    return messages.size();
  }
  
  public boolean isEmpty()
  {
    return messages.isEmpty();
  }
  
  public MType getMessage(int index)
  {
    return getMessage(index, false);
  }
  
  private MType getMessage(int index, boolean forBuild)
  {
    if (builders == null) {
      return (GeneratedMessage)messages.get(index);
    }
    SingleFieldBuilder<MType, BType, IType> builder = (SingleFieldBuilder)builders.get(index);
    if (builder == null) {
      return (GeneratedMessage)messages.get(index);
    }
    return forBuild ? builder.build() : builder.getMessage();
  }
  
  public BType getBuilder(int index)
  {
    ensureBuilders();
    SingleFieldBuilder<MType, BType, IType> builder = (SingleFieldBuilder)builders.get(index);
    if (builder == null)
    {
      MType message = (GeneratedMessage)messages.get(index);
      builder = new SingleFieldBuilder(message, this, isClean);
      
      builders.set(index, builder);
    }
    return builder.getBuilder();
  }
  
  public IType getMessageOrBuilder(int index)
  {
    if (builders == null) {
      return (MessageOrBuilder)messages.get(index);
    }
    SingleFieldBuilder<MType, BType, IType> builder = (SingleFieldBuilder)builders.get(index);
    if (builder == null) {
      return (MessageOrBuilder)messages.get(index);
    }
    return builder.getMessageOrBuilder();
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> setMessage(int index, MType message)
  {
    if (message == null) {
      throw new NullPointerException();
    }
    ensureMutableMessageList();
    messages.set(index, message);
    if (builders != null)
    {
      SingleFieldBuilder<MType, BType, IType> entry = (SingleFieldBuilder)builders.set(index, null);
      if (entry != null) {
        entry.dispose();
      }
    }
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType message)
  {
    if (message == null) {
      throw new NullPointerException();
    }
    ensureMutableMessageList();
    messages.add(message);
    if (builders != null) {
      builders.add(null);
    }
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> addMessage(int index, MType message)
  {
    if (message == null) {
      throw new NullPointerException();
    }
    ensureMutableMessageList();
    messages.add(index, message);
    if (builders != null) {
      builders.add(index, null);
    }
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> values)
  {
    for (MType value : values) {
      if (value == null) {
        throw new NullPointerException();
      }
    }
    if ((values instanceof Collection))
    {
      Collection<MType> collection = (Collection)values;
      if (collection.size() == 0) {
        return this;
      }
      ensureMutableMessageList();
      for (MType value : values) {
        addMessage(value);
      }
    }
    else
    {
      ensureMutableMessageList();
      for (MType value : values) {
        addMessage(value);
      }
    }
    onChanged();
    incrementModCounts();
    return this;
  }
  
  public BType addBuilder(MType message)
  {
    ensureMutableMessageList();
    ensureBuilders();
    SingleFieldBuilder<MType, BType, IType> builder = new SingleFieldBuilder(message, this, isClean);
    
    messages.add(null);
    builders.add(builder);
    onChanged();
    incrementModCounts();
    return builder.getBuilder();
  }
  
  public BType addBuilder(int index, MType message)
  {
    ensureMutableMessageList();
    ensureBuilders();
    SingleFieldBuilder<MType, BType, IType> builder = new SingleFieldBuilder(message, this, isClean);
    
    messages.add(index, null);
    builders.add(index, builder);
    onChanged();
    incrementModCounts();
    return builder.getBuilder();
  }
  
  public void remove(int index)
  {
    ensureMutableMessageList();
    messages.remove(index);
    if (builders != null)
    {
      SingleFieldBuilder<MType, BType, IType> entry = (SingleFieldBuilder)builders.remove(index);
      if (entry != null) {
        entry.dispose();
      }
    }
    onChanged();
    incrementModCounts();
  }
  
  public void clear()
  {
    messages = Collections.emptyList();
    isMessagesListMutable = false;
    if (builders != null)
    {
      for (SingleFieldBuilder<MType, BType, IType> entry : builders) {
        if (entry != null) {
          entry.dispose();
        }
      }
      builders = null;
    }
    onChanged();
    incrementModCounts();
  }
  
  public List<MType> build()
  {
    isClean = true;
    if ((!isMessagesListMutable) && (builders == null)) {
      return messages;
    }
    boolean allMessagesInSync = true;
    if (!isMessagesListMutable)
    {
      for (int i = 0; i < messages.size(); i++)
      {
        Message message = (Message)messages.get(i);
        SingleFieldBuilder<MType, BType, IType> builder = (SingleFieldBuilder)builders.get(i);
        if ((builder != null) && 
          (builder.build() != message))
        {
          allMessagesInSync = false;
          break;
        }
      }
      if (allMessagesInSync) {
        return messages;
      }
    }
    ensureMutableMessageList();
    for (int i = 0; i < messages.size(); i++) {
      messages.set(i, getMessage(i, true));
    }
    messages = Collections.unmodifiableList(messages);
    isMessagesListMutable = false;
    return messages;
  }
  
  public List<MType> getMessageList()
  {
    if (externalMessageList == null) {
      externalMessageList = new MessageExternalList(this);
    }
    return externalMessageList;
  }
  
  public List<BType> getBuilderList()
  {
    if (externalBuilderList == null) {
      externalBuilderList = new BuilderExternalList(this);
    }
    return externalBuilderList;
  }
  
  public List<IType> getMessageOrBuilderList()
  {
    if (externalMessageOrBuilderList == null) {
      externalMessageOrBuilderList = new MessageOrBuilderExternalList(this);
    }
    return externalMessageOrBuilderList;
  }
  
  private void onChanged()
  {
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
  
  private void incrementModCounts()
  {
    if (externalMessageList != null) {
      externalMessageList.incrementModCount();
    }
    if (externalBuilderList != null) {
      externalBuilderList.incrementModCount();
    }
    if (externalMessageOrBuilderList != null) {
      externalMessageOrBuilderList.incrementModCount();
    }
  }
  
  private static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
    extends AbstractList<MType>
    implements List<MType>
  {
    RepeatedFieldBuilder<MType, BType, IType> builder;
    
    MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> builder)
    {
      this.builder = builder;
    }
    
    public int size()
    {
      return builder.getCount();
    }
    
    public MType get(int index)
    {
      return builder.getMessage(index);
    }
    
    void incrementModCount()
    {
      modCount += 1;
    }
  }
  
  private static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
    extends AbstractList<BType>
    implements List<BType>
  {
    RepeatedFieldBuilder<MType, BType, IType> builder;
    
    BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> builder)
    {
      this.builder = builder;
    }
    
    public int size()
    {
      return builder.getCount();
    }
    
    public BType get(int index)
    {
      return builder.getBuilder(index);
    }
    
    void incrementModCount()
    {
      modCount += 1;
    }
  }
  
  private static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
    extends AbstractList<IType>
    implements List<IType>
  {
    RepeatedFieldBuilder<MType, BType, IType> builder;
    
    MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> builder)
    {
      this.builder = builder;
    }
    
    public int size()
    {
      return builder.getCount();
    }
    
    public IType get(int index)
    {
      return builder.getMessageOrBuilder(index);
    }
    
    void incrementModCount()
    {
      modCount += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RepeatedFieldBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */