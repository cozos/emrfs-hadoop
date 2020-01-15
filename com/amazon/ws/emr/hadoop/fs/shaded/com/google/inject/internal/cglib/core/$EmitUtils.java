package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class $EmitUtils
{
  private static final .Signature CSTRUCT_NULL = .TypeUtils.parseConstructor("");
  private static final .Signature CSTRUCT_THROWABLE = .TypeUtils.parseConstructor("Throwable");
  private static final .Signature GET_NAME = .TypeUtils.parseSignature("String getName()");
  private static final .Signature HASH_CODE = .TypeUtils.parseSignature("int hashCode()");
  private static final .Signature EQUALS = .TypeUtils.parseSignature("boolean equals(Object)");
  private static final .Signature STRING_LENGTH = .TypeUtils.parseSignature("int length()");
  private static final .Signature STRING_CHAR_AT = .TypeUtils.parseSignature("char charAt(int)");
  private static final .Signature FOR_NAME = .TypeUtils.parseSignature("Class forName(String)");
  private static final .Signature DOUBLE_TO_LONG_BITS = .TypeUtils.parseSignature("long doubleToLongBits(double)");
  private static final .Signature FLOAT_TO_INT_BITS = .TypeUtils.parseSignature("int floatToIntBits(float)");
  private static final .Signature TO_STRING = .TypeUtils.parseSignature("String toString()");
  private static final .Signature APPEND_STRING = .TypeUtils.parseSignature("StringBuffer append(String)");
  private static final .Signature APPEND_INT = .TypeUtils.parseSignature("StringBuffer append(int)");
  private static final .Signature APPEND_DOUBLE = .TypeUtils.parseSignature("StringBuffer append(double)");
  private static final .Signature APPEND_FLOAT = .TypeUtils.parseSignature("StringBuffer append(float)");
  private static final .Signature APPEND_CHAR = .TypeUtils.parseSignature("StringBuffer append(char)");
  private static final .Signature APPEND_LONG = .TypeUtils.parseSignature("StringBuffer append(long)");
  private static final .Signature APPEND_BOOLEAN = .TypeUtils.parseSignature("StringBuffer append(boolean)");
  private static final .Signature LENGTH = .TypeUtils.parseSignature("int length()");
  private static final .Signature SET_LENGTH = .TypeUtils.parseSignature("void setLength(int)");
  private static final .Signature GET_DECLARED_METHOD = .TypeUtils.parseSignature("java.lang.reflect.Method getDeclaredMethod(String, Class[])");
  public static final ArrayDelimiters DEFAULT_DELIMITERS = new ArrayDelimiters("{", ", ", "}");
  
  public static void factory_method(.ClassEmitter ce, .Signature sig)
  {
    .CodeEmitter e = ce.begin_method(1, sig, null);
    e.new_instance_this();
    e.dup();
    e.load_args();
    e.invoke_constructor_this(.TypeUtils.parseConstructor(sig.getArgumentTypes()));
    e.return_value();
    e.end_method();
  }
  
  public static void null_constructor(.ClassEmitter ce)
  {
    .CodeEmitter e = ce.begin_method(1, CSTRUCT_NULL, null);
    e.load_this();
    e.super_invoke_constructor();
    e.return_value();
    e.end_method();
  }
  
  public static void process_array(.CodeEmitter e, .Type type, .ProcessArrayCallback callback)
  {
    .Type componentType = .TypeUtils.getComponentType(type);
    .Local array = e.make_local();
    .Local loopvar = e.make_local(.Type.INT_TYPE);
    .Label loopbody = e.make_label();
    .Label checkloop = e.make_label();
    e.store_local(array);
    e.push(0);
    e.store_local(loopvar);
    e.goTo(checkloop);
    
    e.mark(loopbody);
    e.load_local(array);
    e.load_local(loopvar);
    e.array_load(componentType);
    callback.processElement(componentType);
    e.iinc(loopvar, 1);
    
    e.mark(checkloop);
    e.load_local(loopvar);
    e.load_local(array);
    e.arraylength();
    e.if_icmp(155, loopbody);
  }
  
  public static void process_arrays(.CodeEmitter e, .Type type, .ProcessArrayCallback callback)
  {
    .Type componentType = .TypeUtils.getComponentType(type);
    .Local array1 = e.make_local();
    .Local array2 = e.make_local();
    .Local loopvar = e.make_local(.Type.INT_TYPE);
    .Label loopbody = e.make_label();
    .Label checkloop = e.make_label();
    e.store_local(array1);
    e.store_local(array2);
    e.push(0);
    e.store_local(loopvar);
    e.goTo(checkloop);
    
    e.mark(loopbody);
    e.load_local(array1);
    e.load_local(loopvar);
    e.array_load(componentType);
    e.load_local(array2);
    e.load_local(loopvar);
    e.array_load(componentType);
    callback.processElement(componentType);
    e.iinc(loopvar, 1);
    
    e.mark(checkloop);
    e.load_local(loopvar);
    e.load_local(array1);
    e.arraylength();
    e.if_icmp(155, loopbody);
  }
  
  public static void string_switch(.CodeEmitter e, String[] strings, int switchStyle, .ObjectSwitchCallback callback)
  {
    try
    {
      switch (switchStyle)
      {
      case 0: 
        string_switch_trie(e, strings, callback);
        break;
      case 1: 
        string_switch_hash(e, strings, callback, false);
        break;
      case 2: 
        string_switch_hash(e, strings, callback, true);
        break;
      default: 
        throw new IllegalArgumentException("unknown switch style " + switchStyle);
      }
    }
    catch (RuntimeException ex)
    {
      throw ex;
    }
    catch (Error ex)
    {
      throw ex;
    }
    catch (Exception ex)
    {
      throw new .CodeGenerationException(ex);
    }
  }
  
  private static void string_switch_trie(.CodeEmitter e, String[] strings, .ObjectSwitchCallback callback)
    throws Exception
  {
    .Label def = e.make_label();
    .Label end = e.make_label();
    Map buckets = .CollectionUtils.bucket(Arrays.asList(strings), new .Transformer()
    {
      public Object transform(Object value)
      {
        return new Integer(((String)value).length());
      }
    });
    e.dup();
    e.invoke_virtual(.Constants.TYPE_STRING, STRING_LENGTH);
    e.process_switch(getSwitchKeys(buckets), new .ProcessSwitchCallback()
    {
      private final Map val$buckets;
      private final .CodeEmitter val$e;
      private final .ObjectSwitchCallback val$callback;
      private final .Label val$def;
      private final .Label val$end;
      
      public void processCase(int key, .Label ignore_end)
        throws Exception
      {
        List bucket = (List)val$buckets.get(new Integer(key));
        .EmitUtils.stringSwitchHelper(val$e, bucket, val$callback, val$def, val$end, 0);
      }
      
      public void processDefault()
      {
        val$e.goTo(val$def);
      }
    });
    e.mark(def);
    e.pop();
    callback.processDefault();
    e.mark(end);
  }
  
  private static void stringSwitchHelper(.CodeEmitter e, List strings, .ObjectSwitchCallback callback, .Label def, .Label end, int index)
    throws Exception
  {
    int len = ((String)strings.get(0)).length();
    Map buckets = .CollectionUtils.bucket(strings, new .Transformer()
    {
      private final int val$index;
      
      public Object transform(Object value)
      {
        return new Integer(((String)value).charAt(val$index));
      }
    });
    e.dup();
    e.push(index);
    e.invoke_virtual(.Constants.TYPE_STRING, STRING_CHAR_AT);
    e.process_switch(getSwitchKeys(buckets), new .ProcessSwitchCallback()
    {
      private final Map val$buckets;
      private final int val$index;
      private final int val$len;
      private final .CodeEmitter val$e;
      private final .ObjectSwitchCallback val$callback;
      private final .Label val$end;
      private final .Label val$def;
      
      public void processCase(int key, .Label ignore_end)
        throws Exception
      {
        List bucket = (List)val$buckets.get(new Integer(key));
        if (val$index + 1 == val$len)
        {
          val$e.pop();
          val$callback.processCase(bucket.get(0), val$end);
        }
        else
        {
          .EmitUtils.stringSwitchHelper(val$e, bucket, val$callback, val$def, val$end, val$index + 1);
        }
      }
      
      public void processDefault()
      {
        val$e.goTo(val$def);
      }
    });
  }
  
  static int[] getSwitchKeys(Map buckets)
  {
    int[] keys = new int[buckets.size()];
    int index = 0;
    for (Iterator it = buckets.keySet().iterator(); it.hasNext();) {
      keys[(index++)] = ((Integer)it.next()).intValue();
    }
    Arrays.sort(keys);
    return keys;
  }
  
  private static void string_switch_hash(.CodeEmitter e, String[] strings, .ObjectSwitchCallback callback, boolean skipEquals)
    throws Exception
  {
    Map buckets = .CollectionUtils.bucket(Arrays.asList(strings), new .Transformer()
    {
      public Object transform(Object value)
      {
        return new Integer(value.hashCode());
      }
    });
    .Label def = e.make_label();
    .Label end = e.make_label();
    e.dup();
    e.invoke_virtual(.Constants.TYPE_OBJECT, HASH_CODE);
    e.process_switch(getSwitchKeys(buckets), new .ProcessSwitchCallback()
    {
      private final Map val$buckets;
      private final boolean val$skipEquals;
      private final .CodeEmitter val$e;
      private final .ObjectSwitchCallback val$callback;
      private final .Label val$end;
      private final .Label val$def;
      
      public void processCase(int key, .Label ignore_end)
        throws Exception
      {
        List bucket = (List)val$buckets.get(new Integer(key));
        .Label next = null;
        Iterator it;
        if ((val$skipEquals) && (bucket.size() == 1))
        {
          if (val$skipEquals) {
            val$e.pop();
          }
          val$callback.processCase((String)bucket.get(0), val$end);
        }
        else
        {
          for (it = bucket.iterator(); it.hasNext();)
          {
            String string = (String)it.next();
            if (next != null) {
              val$e.mark(next);
            }
            if (it.hasNext()) {
              val$e.dup();
            }
            val$e.push(string);
            val$e.invoke_virtual(.Constants.TYPE_OBJECT, .EmitUtils.EQUALS);
            if (it.hasNext())
            {
              val$e.if_jump(153, next = val$e.make_label());
              val$e.pop();
            }
            else
            {
              val$e.if_jump(153, val$def);
            }
            val$callback.processCase(string, val$end);
          }
        }
      }
      
      public void processDefault()
      {
        val$e.pop();
      }
    });
    e.mark(def);
    callback.processDefault();
    e.mark(end);
  }
  
  public static void load_class_this(.CodeEmitter e)
  {
    load_class_helper(e, e.getClassEmitter().getClassType());
  }
  
  public static void load_class(.CodeEmitter e, .Type type)
  {
    if (.TypeUtils.isPrimitive(type))
    {
      if (type == .Type.VOID_TYPE) {
        throw new IllegalArgumentException("cannot load void type");
      }
      e.getstatic(.TypeUtils.getBoxedType(type), "TYPE", .Constants.TYPE_CLASS);
    }
    else
    {
      load_class_helper(e, type);
    }
  }
  
  private static void load_class_helper(.CodeEmitter e, .Type type)
  {
    if (e.isStaticHook())
    {
      e.push(.TypeUtils.emulateClassGetName(type));
      e.invoke_static(.Constants.TYPE_CLASS, FOR_NAME);
    }
    else
    {
      .ClassEmitter ce = e.getClassEmitter();
      String typeName = .TypeUtils.emulateClassGetName(type);
      
      String fieldName = "CGLIB$load_class$" + .TypeUtils.escapeType(typeName);
      if (!ce.isFieldDeclared(fieldName))
      {
        ce.declare_field(26, fieldName, .Constants.TYPE_CLASS, null);
        .CodeEmitter hook = ce.getStaticHook();
        hook.push(typeName);
        hook.invoke_static(.Constants.TYPE_CLASS, FOR_NAME);
        hook.putstatic(ce.getClassType(), fieldName, .Constants.TYPE_CLASS);
      }
      e.getfield(fieldName);
    }
  }
  
  public static void push_array(.CodeEmitter e, Object[] array)
  {
    e.push(array.length);
    e.newarray(.Type.getType(remapComponentType(array.getClass().getComponentType())));
    for (int i = 0; i < array.length; i++)
    {
      e.dup();
      e.push(i);
      push_object(e, array[i]);
      e.aastore();
    }
  }
  
  private static Class remapComponentType(Class componentType)
  {
    if (componentType.equals(.Type.class)) {
      return Class.class;
    }
    return componentType;
  }
  
  public static void push_object(.CodeEmitter e, Object obj)
  {
    if (obj == null)
    {
      e.aconst_null();
    }
    else
    {
      Class type = obj.getClass();
      if (type.isArray())
      {
        push_array(e, (Object[])obj);
      }
      else if ((obj instanceof String))
      {
        e.push((String)obj);
      }
      else if ((obj instanceof .Type))
      {
        load_class(e, (.Type)obj);
      }
      else if ((obj instanceof Class))
      {
        load_class(e, .Type.getType((Class)obj));
      }
      else if ((obj instanceof BigInteger))
      {
        e.new_instance(.Constants.TYPE_BIG_INTEGER);
        e.dup();
        e.push(obj.toString());
        e.invoke_constructor(.Constants.TYPE_BIG_INTEGER);
      }
      else if ((obj instanceof BigDecimal))
      {
        e.new_instance(.Constants.TYPE_BIG_DECIMAL);
        e.dup();
        e.push(obj.toString());
        e.invoke_constructor(.Constants.TYPE_BIG_DECIMAL);
      }
      else
      {
        throw new IllegalArgumentException("unknown type: " + obj.getClass());
      }
    }
  }
  
  public static void hash_code(.CodeEmitter e, .Type type, int multiplier, .Customizer customizer)
  {
    if (.TypeUtils.isArray(type))
    {
      hash_array(e, type, multiplier, customizer);
    }
    else
    {
      e.swap(.Type.INT_TYPE, type);
      e.push(multiplier);
      e.math(104, .Type.INT_TYPE);
      e.swap(type, .Type.INT_TYPE);
      if (.TypeUtils.isPrimitive(type)) {
        hash_primitive(e, type);
      } else {
        hash_object(e, type, customizer);
      }
      e.math(96, .Type.INT_TYPE);
    }
  }
  
  private static void hash_array(.CodeEmitter e, .Type type, int multiplier, .Customizer customizer)
  {
    .Label skip = e.make_label();
    .Label end = e.make_label();
    e.dup();
    e.ifnull(skip);
    process_array(e, type, new .ProcessArrayCallback()
    {
      private final .CodeEmitter val$e;
      private final int val$multiplier;
      private final .Customizer val$customizer;
      
      public void processElement(.Type type)
      {
        .EmitUtils.hash_code(val$e, type, val$multiplier, val$customizer);
      }
    });
    e.goTo(end);
    e.mark(skip);
    e.pop();
    e.mark(end);
  }
  
  private static void hash_object(.CodeEmitter e, .Type type, .Customizer customizer)
  {
    .Label skip = e.make_label();
    .Label end = e.make_label();
    e.dup();
    e.ifnull(skip);
    if (customizer != null) {
      customizer.customize(e, type);
    }
    e.invoke_virtual(.Constants.TYPE_OBJECT, HASH_CODE);
    e.goTo(end);
    e.mark(skip);
    e.pop();
    e.push(0);
    e.mark(end);
  }
  
  private static void hash_primitive(.CodeEmitter e, .Type type)
  {
    switch (type.getSort())
    {
    case 1: 
      e.push(1);
      e.math(130, .Type.INT_TYPE);
      break;
    case 6: 
      e.invoke_static(.Constants.TYPE_FLOAT, FLOAT_TO_INT_BITS);
      break;
    case 8: 
      e.invoke_static(.Constants.TYPE_DOUBLE, DOUBLE_TO_LONG_BITS);
    case 7: 
      hash_long(e);
    }
  }
  
  private static void hash_long(.CodeEmitter e)
  {
    e.dup2();
    e.push(32);
    e.math(124, .Type.LONG_TYPE);
    e.math(130, .Type.LONG_TYPE);
    e.cast_numeric(.Type.LONG_TYPE, .Type.INT_TYPE);
  }
  
  public static void not_equals(.CodeEmitter e, .Type type, .Label notEquals, .Customizer customizer)
  {
    new .ProcessArrayCallback()
    {
      private final .CodeEmitter val$e;
      private final .Label val$notEquals;
      private final .Customizer val$customizer;
      
      public void processElement(.Type type)
      {
        .EmitUtils.not_equals_helper(val$e, type, val$notEquals, val$customizer, this);
      }
    }.processElement(type);
  }
  
  private static void not_equals_helper(.CodeEmitter e, .Type type, .Label notEquals, .Customizer customizer, .ProcessArrayCallback callback)
  {
    if (.TypeUtils.isPrimitive(type))
    {
      e.if_cmp(type, 154, notEquals);
    }
    else
    {
      .Label end = e.make_label();
      nullcmp(e, notEquals, end);
      if (.TypeUtils.isArray(type))
      {
        .Label checkContents = e.make_label();
        e.dup2();
        e.arraylength();
        e.swap();
        e.arraylength();
        e.if_icmp(153, checkContents);
        e.pop2();
        e.goTo(notEquals);
        e.mark(checkContents);
        process_arrays(e, type, callback);
      }
      else
      {
        if (customizer != null)
        {
          customizer.customize(e, type);
          e.swap();
          customizer.customize(e, type);
        }
        e.invoke_virtual(.Constants.TYPE_OBJECT, EQUALS);
        e.if_jump(153, notEquals);
      }
      e.mark(end);
    }
  }
  
  private static void nullcmp(.CodeEmitter e, .Label oneNull, .Label bothNull)
  {
    e.dup2();
    .Label nonNull = e.make_label();
    .Label oneNullHelper = e.make_label();
    .Label end = e.make_label();
    e.ifnonnull(nonNull);
    e.ifnonnull(oneNullHelper);
    e.pop2();
    e.goTo(bothNull);
    
    e.mark(nonNull);
    e.ifnull(oneNullHelper);
    e.goTo(end);
    
    e.mark(oneNullHelper);
    e.pop2();
    e.goTo(oneNull);
    
    e.mark(end);
  }
  
  public static void append_string(.CodeEmitter e, .Type type, ArrayDelimiters delims, .Customizer customizer)
  {
    ArrayDelimiters d = delims != null ? delims : DEFAULT_DELIMITERS;
    .ProcessArrayCallback callback = new .ProcessArrayCallback()
    {
      private final .CodeEmitter val$e;
      private final .EmitUtils.ArrayDelimiters val$d;
      private final .Customizer val$customizer;
      
      public void processElement(.Type type)
      {
        .EmitUtils.append_string_helper(val$e, type, val$d, val$customizer, this);
        val$e.push(val$d.inside);
        val$e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, .EmitUtils.APPEND_STRING);
      }
    };
    append_string_helper(e, type, d, customizer, callback);
  }
  
  private static void append_string_helper(.CodeEmitter e, .Type type, ArrayDelimiters delims, .Customizer customizer, .ProcessArrayCallback callback)
  {
    .Label skip = e.make_label();
    .Label end = e.make_label();
    if (.TypeUtils.isPrimitive(type))
    {
      switch (type.getSort())
      {
      case 3: 
      case 4: 
      case 5: 
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_INT);
        break;
      case 8: 
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_DOUBLE);
        break;
      case 6: 
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_FLOAT);
        break;
      case 7: 
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_LONG);
        break;
      case 1: 
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_BOOLEAN);
        break;
      case 2: 
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_CHAR);
      }
    }
    else if (.TypeUtils.isArray(type))
    {
      e.dup();
      e.ifnull(skip);
      e.swap();
      if ((delims != null) && (before != null) && (!"".equals(before)))
      {
        e.push(before);
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_STRING);
        e.swap();
      }
      process_array(e, type, callback);
      shrinkStringBuffer(e, 2);
      if ((delims != null) && (after != null) && (!"".equals(after)))
      {
        e.push(after);
        e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_STRING);
      }
    }
    else
    {
      e.dup();
      e.ifnull(skip);
      if (customizer != null) {
        customizer.customize(e, type);
      }
      e.invoke_virtual(.Constants.TYPE_OBJECT, TO_STRING);
      e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_STRING);
    }
    e.goTo(end);
    e.mark(skip);
    e.pop();
    e.push("null");
    e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, APPEND_STRING);
    e.mark(end);
  }
  
  private static void shrinkStringBuffer(.CodeEmitter e, int amt)
  {
    e.dup();
    e.dup();
    e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, LENGTH);
    e.push(amt);
    e.math(100, .Type.INT_TYPE);
    e.invoke_virtual(.Constants.TYPE_STRING_BUFFER, SET_LENGTH);
  }
  
  private static abstract interface ParameterTyper
  {
    public abstract .Type[] getParameterTypes(.MethodInfo paramMethodInfo);
  }
  
  public static class ArrayDelimiters
  {
    private String before;
    private String inside;
    private String after;
    
    public ArrayDelimiters(String before, String inside, String after)
    {
      this.before = before;
      this.inside = inside;
      this.after = after;
    }
  }
  
  public static void load_method(.CodeEmitter e, .MethodInfo method)
  {
    load_class(e, method.getClassInfo().getType());
    e.push(method.getSignature().getName());
    push_object(e, method.getSignature().getArgumentTypes());
    e.invoke_virtual(.Constants.TYPE_CLASS, GET_DECLARED_METHOD);
  }
  
  public static void method_switch(.CodeEmitter e, List methods, .ObjectSwitchCallback callback)
  {
    member_switch_helper(e, methods, callback, true);
  }
  
  public static void constructor_switch(.CodeEmitter e, List constructors, .ObjectSwitchCallback callback)
  {
    member_switch_helper(e, constructors, callback, false);
  }
  
  private static void member_switch_helper(.CodeEmitter e, List members, .ObjectSwitchCallback callback, boolean useName)
  {
    try
    {
      Map cache = new HashMap();
      ParameterTyper cached = new ParameterTyper()
      {
        private final Map val$cache;
        
        public .Type[] getParameterTypes(.MethodInfo member)
        {
          .Type[] types = (.Type[])val$cache.get(member);
          if (types == null) {
            val$cache.put(member, types = member.getSignature().getArgumentTypes());
          }
          return types;
        }
      };
      .Label def = e.make_label();
      .Label end = e.make_label();
      if (useName)
      {
        e.swap();
        Map buckets = .CollectionUtils.bucket(members, new .Transformer()
        {
          public Object transform(Object value)
          {
            return ((.MethodInfo)value).getSignature().getName();
          }
        });
        String[] names = (String[])buckets.keySet().toArray(new String[buckets.size()]);
        string_switch(e, names, 1, new .ObjectSwitchCallback()
        {
          private final .CodeEmitter val$e;
          private final Map val$buckets;
          private final .ObjectSwitchCallback val$callback;
          private final .EmitUtils.ParameterTyper val$cached;
          private final .Label val$def;
          private final .Label val$end;
          
          public void processCase(Object key, .Label dontUseEnd)
            throws Exception
          {
            .EmitUtils.member_helper_size(val$e, (List)val$buckets.get(key), val$callback, val$cached, val$def, val$end);
          }
          
          public void processDefault()
            throws Exception
          {
            val$e.goTo(val$def);
          }
        });
      }
      else
      {
        member_helper_size(e, members, callback, cached, def, end);
      }
      e.mark(def);
      e.pop();
      callback.processDefault();
      e.mark(end);
    }
    catch (RuntimeException ex)
    {
      throw ex;
    }
    catch (Error ex)
    {
      throw ex;
    }
    catch (Exception ex)
    {
      throw new .CodeGenerationException(ex);
    }
  }
  
  private static void member_helper_size(.CodeEmitter e, List members, .ObjectSwitchCallback callback, ParameterTyper typer, .Label def, .Label end)
    throws Exception
  {
    Map buckets = .CollectionUtils.bucket(members, new .Transformer()
    {
      private final .EmitUtils.ParameterTyper val$typer;
      
      public Object transform(Object value)
      {
        return new Integer(val$typer.getParameterTypes((.MethodInfo)value).length);
      }
    });
    e.dup();
    e.arraylength();
    e.process_switch(getSwitchKeys(buckets), new .ProcessSwitchCallback()
    {
      private final Map val$buckets;
      private final .CodeEmitter val$e;
      private final .ObjectSwitchCallback val$callback;
      private final .EmitUtils.ParameterTyper val$typer;
      private final .Label val$def;
      private final .Label val$end;
      
      public void processCase(int key, .Label dontUseEnd)
        throws Exception
      {
        List bucket = (List)val$buckets.get(new Integer(key));
        .EmitUtils.member_helper_type(val$e, bucket, val$callback, val$typer, val$def, val$end, new BitSet());
      }
      
      public void processDefault()
        throws Exception
      {
        val$e.goTo(val$def);
      }
    });
  }
  
  private static void member_helper_type(.CodeEmitter e, List members, .ObjectSwitchCallback callback, ParameterTyper typer, .Label def, .Label end, BitSet checked)
    throws Exception
  {
    if (members.size() == 1)
    {
      .MethodInfo member = (.MethodInfo)members.get(0);
      .Type[] types = typer.getParameterTypes(member);
      for (int i = 0; i < types.length; i++) {
        if ((checked == null) || (!checked.get(i)))
        {
          e.dup();
          e.aaload(i);
          e.invoke_virtual(.Constants.TYPE_CLASS, GET_NAME);
          e.push(.TypeUtils.emulateClassGetName(types[i]));
          e.invoke_virtual(.Constants.TYPE_OBJECT, EQUALS);
          e.if_jump(153, def);
        }
      }
      e.pop();
      callback.processCase(member, end);
    }
    else
    {
      .Type[] example = typer.getParameterTypes((.MethodInfo)members.get(0));
      Map buckets = null;
      int index = -1;
      for (int i = 0; i < example.length; i++)
      {
        int j = i;
        Map test = .CollectionUtils.bucket(members, new .Transformer()
        {
          private final .EmitUtils.ParameterTyper val$typer;
          private final int val$j;
          
          public Object transform(Object value)
          {
            return .TypeUtils.emulateClassGetName(val$typer.getParameterTypes((.MethodInfo)value)[val$j]);
          }
        });
        if ((buckets == null) || (test.size() > buckets.size()))
        {
          buckets = test;
          index = i;
        }
      }
      if ((buckets == null) || (buckets.size() == 1))
      {
        e.goTo(def);
      }
      else
      {
        checked.set(index);
        
        e.dup();
        e.aaload(index);
        e.invoke_virtual(.Constants.TYPE_CLASS, GET_NAME);
        
        Map fbuckets = buckets;
        String[] names = (String[])buckets.keySet().toArray(new String[buckets.size()]);
        string_switch(e, names, 1, new .ObjectSwitchCallback()
        {
          private final .CodeEmitter val$e;
          private final Map val$fbuckets;
          private final .ObjectSwitchCallback val$callback;
          private final .EmitUtils.ParameterTyper val$typer;
          private final .Label val$def;
          private final .Label val$end;
          private final BitSet val$checked;
          
          public void processCase(Object key, .Label dontUseEnd)
            throws Exception
          {
            .EmitUtils.member_helper_type(val$e, (List)val$fbuckets.get(key), val$callback, val$typer, val$def, val$end, val$checked);
          }
          
          public void processDefault()
            throws Exception
          {
            val$e.goTo(val$def);
          }
        });
      }
    }
  }
  
  public static void wrap_throwable(.Block block, .Type wrapper)
  {
    .CodeEmitter e = block.getCodeEmitter();
    e.catch_exception(block, .Constants.TYPE_THROWABLE);
    e.new_instance(wrapper);
    e.dup_x1();
    e.swap();
    e.invoke_constructor(wrapper, CSTRUCT_THROWABLE);
    e.athrow();
  }
  
  public static void add_properties(.ClassEmitter ce, String[] names, .Type[] types)
  {
    for (int i = 0; i < names.length; i++)
    {
      String fieldName = "$cglib_prop_" + names[i];
      ce.declare_field(2, fieldName, types[i], null);
      add_property(ce, names[i], types[i], fieldName);
    }
  }
  
  public static void add_property(.ClassEmitter ce, String name, .Type type, String fieldName)
  {
    String property = .TypeUtils.upperFirst(name);
    
    .CodeEmitter e = ce.begin_method(1, new .Signature("get" + property, type, .Constants.TYPES_EMPTY), null);
    
    e.load_this();
    e.getfield(fieldName);
    e.return_value();
    e.end_method();
    
    e = ce.begin_method(1, new .Signature("set" + property, .Type.VOID_TYPE, new .Type[] { type }), null);
    
    e.load_this();
    e.load_arg(0);
    e.putfield(fieldName);
    e.return_value();
    e.end_method();
  }
  
  public static void wrap_undeclared_throwable(.CodeEmitter e, .Block handler, .Type[] exceptions, .Type wrapper)
  {
    Set set = exceptions == null ? Collections.EMPTY_SET : new HashSet(Arrays.asList(exceptions));
    if (set.contains(.Constants.TYPE_THROWABLE)) {
      return;
    }
    boolean needThrow = exceptions != null;
    if (!set.contains(.Constants.TYPE_RUNTIME_EXCEPTION))
    {
      e.catch_exception(handler, .Constants.TYPE_RUNTIME_EXCEPTION);
      needThrow = true;
    }
    if (!set.contains(.Constants.TYPE_ERROR))
    {
      e.catch_exception(handler, .Constants.TYPE_ERROR);
      needThrow = true;
    }
    if (exceptions != null) {
      for (int i = 0; i < exceptions.length; i++) {
        e.catch_exception(handler, exceptions[i]);
      }
    }
    if (needThrow) {
      e.athrow();
    }
    e.catch_exception(handler, .Constants.TYPE_THROWABLE);
    e.new_instance(wrapper);
    e.dup_x1();
    e.swap();
    e.invoke_constructor(wrapper, CSTRUCT_THROWABLE);
    e.athrow();
  }
  
  public static .CodeEmitter begin_method(.ClassEmitter e, .MethodInfo method)
  {
    return begin_method(e, method, method.getModifiers());
  }
  
  public static .CodeEmitter begin_method(.ClassEmitter e, .MethodInfo method, int access)
  {
    return e.begin_method(access, method.getSignature(), method.getExceptionTypes());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */