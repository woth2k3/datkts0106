package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties
  implements SafeParcelable, Iterable<CustomProperty>
{
  public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new a();
  public static final AppVisibleCustomProperties JK = new a().gy();
  final List<CustomProperty> JL;
  final int xJ;
  
  AppVisibleCustomProperties(int paramInt, Collection<CustomProperty> paramCollection)
  {
    this.xJ = paramInt;
    hn.f(paramCollection);
    this.JL = new ArrayList(paramCollection);
  }
  
  private AppVisibleCustomProperties(Collection<CustomProperty> paramCollection)
  {
    this(1, paramCollection);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Iterator<CustomProperty> iterator()
  {
    return this.JL.iterator();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private final Map<CustomPropertyKey, CustomProperty> JM = new HashMap();
    
    public AppVisibleCustomProperties gy()
    {
      return new AppVisibleCustomProperties(this.JM.values(), null);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
 * JD-Core Version:    0.7.0.1
 */