package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HitBuilders
{
  public static class ScreenViewBuilder
    extends HitBuilders.HitBuilder<ScreenViewBuilder>
  {
    public ScreenViewBuilder()
    {
      u.cP().a(u.a.wd);
      set("&t", "screenview");
    }
  }
  
  @Deprecated
  public static class AppViewBuilder
    extends HitBuilders.HitBuilder<AppViewBuilder>
  {
    public AppViewBuilder()
    {
      u.cP().a(u.a.wd);
      set("&t", "screenview");
    }
  }
  
  @Deprecated
  public static class ItemBuilder
    extends HitBuilders.HitBuilder<ItemBuilder>
  {
    public ItemBuilder()
    {
      u.cP().a(u.a.vS);
      set("&t", "item");
    }
    
    public ItemBuilder setCategory(String paramString)
    {
      set("&iv", paramString);
      return this;
    }
    
    public ItemBuilder setCurrencyCode(String paramString)
    {
      set("&cu", paramString);
      return this;
    }
    
    public ItemBuilder setName(String paramString)
    {
      set("&in", paramString);
      return this;
    }
    
    public ItemBuilder setPrice(double paramDouble)
    {
      set("&ip", Double.toString(paramDouble));
      return this;
    }
    
    public ItemBuilder setQuantity(long paramLong)
    {
      set("&iq", Long.toString(paramLong));
      return this;
    }
    
    public ItemBuilder setSku(String paramString)
    {
      set("&ic", paramString);
      return this;
    }
    
    public ItemBuilder setTransactionId(String paramString)
    {
      set("&ti", paramString);
      return this;
    }
  }
  
  @Deprecated
  public static class TransactionBuilder
    extends HitBuilders.HitBuilder<TransactionBuilder>
  {
    public TransactionBuilder()
    {
      u.cP().a(u.a.vz);
      set("&t", "transaction");
    }
    
    public TransactionBuilder setAffiliation(String paramString)
    {
      set("&ta", paramString);
      return this;
    }
    
    public TransactionBuilder setCurrencyCode(String paramString)
    {
      set("&cu", paramString);
      return this;
    }
    
    public TransactionBuilder setRevenue(double paramDouble)
    {
      set("&tr", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setShipping(double paramDouble)
    {
      set("&ts", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setTax(double paramDouble)
    {
      set("&tt", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setTransactionId(String paramString)
    {
      set("&ti", paramString);
      return this;
    }
  }
  
  public static class ExceptionBuilder
    extends HitBuilders.HitBuilder<ExceptionBuilder>
  {
    public ExceptionBuilder()
    {
      u.cP().a(u.a.vA);
      set("&t", "exception");
    }
    
    public ExceptionBuilder setDescription(String paramString)
    {
      set("&exd", paramString);
      return this;
    }
    
    public ExceptionBuilder setFatal(boolean paramBoolean)
    {
      set("&exf", ak.v(paramBoolean));
      return this;
    }
  }
  
  public static class TimingBuilder
    extends HitBuilders.HitBuilder<TimingBuilder>
  {
    public TimingBuilder()
    {
      u.cP().a(u.a.vC);
      set("&t", "timing");
    }
    
    public TimingBuilder(String paramString1, String paramString2, long paramLong)
    {
      this();
      setVariable(paramString2);
      setValue(paramLong);
      setCategory(paramString1);
    }
    
    public TimingBuilder setCategory(String paramString)
    {
      set("&utc", paramString);
      return this;
    }
    
    public TimingBuilder setLabel(String paramString)
    {
      set("&utl", paramString);
      return this;
    }
    
    public TimingBuilder setValue(long paramLong)
    {
      set("&utt", Long.toString(paramLong));
      return this;
    }
    
    public TimingBuilder setVariable(String paramString)
    {
      set("&utv", paramString);
      return this;
    }
  }
  
  public static class SocialBuilder
    extends HitBuilders.HitBuilder<SocialBuilder>
  {
    public SocialBuilder()
    {
      u.cP().a(u.a.vD);
      set("&t", "social");
    }
    
    public SocialBuilder setAction(String paramString)
    {
      set("&sa", paramString);
      return this;
    }
    
    public SocialBuilder setNetwork(String paramString)
    {
      set("&sn", paramString);
      return this;
    }
    
    public SocialBuilder setTarget(String paramString)
    {
      set("&st", paramString);
      return this;
    }
  }
  
  public static class EventBuilder
    extends HitBuilders.HitBuilder<EventBuilder>
  {
    public EventBuilder()
    {
      u.cP().a(u.a.vR);
      set("&t", "event");
    }
    
    public EventBuilder(String paramString1, String paramString2)
    {
      this();
      setCategory(paramString1);
      setAction(paramString2);
    }
    
    public EventBuilder setAction(String paramString)
    {
      set("&ea", paramString);
      return this;
    }
    
    public EventBuilder setCategory(String paramString)
    {
      set("&ec", paramString);
      return this;
    }
    
    public EventBuilder setLabel(String paramString)
    {
      set("&el", paramString);
      return this;
    }
    
    public EventBuilder setValue(long paramLong)
    {
      set("&ev", Long.toString(paramLong));
      return this;
    }
  }
  
  protected static class HitBuilder<T extends HitBuilder>
  {
    List<Product> wA = new ArrayList();
    private Map<String, String> ww = new HashMap();
    ProductAction wx;
    Map<String, List<Product>> wy = new HashMap();
    List<Promotion> wz = new ArrayList();
    
    public T addImpression(Product paramProduct, String paramString)
    {
      if (paramProduct != null)
      {
        if (paramString == null) {
          paramString = "";
        }
        if (!this.wy.containsKey(paramString)) {
          this.wy.put(paramString, new ArrayList());
        }
        ((List)this.wy.get(paramString)).add(paramProduct);
      }
      else
      {
        aa.D("product should be non-null");
      }
      return this;
    }
    
    public T addProduct(Product paramProduct)
    {
      if (paramProduct != null) {
        this.wA.add(paramProduct);
      } else {
        aa.D("product should be non-null");
      }
      return this;
    }
    
    public T addPromotion(Promotion paramPromotion)
    {
      if (paramPromotion != null) {
        this.wz.add(paramPromotion);
      } else {
        aa.D("promotion should be non-null");
      }
      return this;
    }
    
    public Map<String, String> build()
    {
      HashMap localHashMap = new HashMap(this.ww);
      if (this.wx != null) {
        localHashMap.putAll(this.wx.build());
      }
      Iterator localIterator1 = this.wz.iterator();
      Map.Entry localEntry;
      for (int i = 1;; localEntry++)
      {
        if (!localIterator1.hasNext())
        {
          localIterator1 = this.wA.iterator();
          for (i = 1;; localEntry++)
          {
            if (!localIterator1.hasNext())
            {
              localIterator1 = this.wy.entrySet().iterator();
              int j = 1;
              if (!localIterator1.hasNext()) {
                return localHashMap;
              }
              localEntry = (Map.Entry)localIterator1.next();
              List localList = (List)localEntry.getValue();
              String str = o.x(j);
              Iterator localIterator2 = localList.iterator();
              for (int k = 1;; k++)
              {
                if (!localIterator2.hasNext())
                {
                  if (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) {
                    localHashMap.put(str + "nm", localEntry.getKey());
                  }
                  j++;
                  break;
                }
                localHashMap.putAll(((Product)localIterator2.next()).X(str + o.w(k)));
              }
            }
            localHashMap.putAll(((Product)localIterator1.next()).X(o.u(localEntry)));
          }
        }
        localHashMap.putAll(((Promotion)localIterator1.next()).X(o.v(localEntry)));
      }
    }
    
    protected String get(String paramString)
    {
      return (String)this.ww.get(paramString);
    }
    
    public final T set(String paramString1, String paramString2)
    {
      u.cP().a(u.a.uT);
      if (paramString1 == null) {
        aa.D(" HitBuilder.set() called with a null paramName.");
      } else {
        this.ww.put(paramString1, paramString2);
      }
      return this;
    }
    
    public final T setAll(Map<String, String> paramMap)
    {
      u.cP().a(u.a.uU);
      if (paramMap != null) {
        this.ww.putAll(new HashMap(paramMap));
      }
      return this;
    }
    
    public T setCampaignParamsFromUrl(String paramString)
    {
      u.cP().a(u.a.uW);
      Object localObject = ak.V(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ak.U((String)localObject);
        set("&cc", (String)((Map)localObject).get("utm_content"));
        set("&cm", (String)((Map)localObject).get("utm_medium"));
        set("&cn", (String)((Map)localObject).get("utm_campaign"));
        set("&cs", (String)((Map)localObject).get("utm_source"));
        set("&ck", (String)((Map)localObject).get("utm_term"));
        set("&ci", (String)((Map)localObject).get("utm_id"));
        set("&gclid", (String)((Map)localObject).get("gclid"));
        set("&dclid", (String)((Map)localObject).get("dclid"));
        set("&gmob_t", (String)((Map)localObject).get("gmob_t"));
      }
      return this;
    }
    
    public T setCustomDimension(int paramInt, String paramString)
    {
      set(o.s(paramInt), paramString);
      return this;
    }
    
    public T setCustomMetric(int paramInt, float paramFloat)
    {
      set(o.t(paramInt), Float.toString(paramFloat));
      return this;
    }
    
    protected T setHitType(String paramString)
    {
      set("&t", paramString);
      return this;
    }
    
    public T setNewSession()
    {
      set("&sc", "start");
      return this;
    }
    
    public T setNonInteraction(boolean paramBoolean)
    {
      set("&ni", ak.v(paramBoolean));
      return this;
    }
    
    public T setProductAction(ProductAction paramProductAction)
    {
      this.wx = paramProductAction;
      return this;
    }
    
    public T setPromotionAction(String paramString)
    {
      this.ww.put("&promoa", paramString);
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.HitBuilders
 * JD-Core Version:    0.7.0.1
 */