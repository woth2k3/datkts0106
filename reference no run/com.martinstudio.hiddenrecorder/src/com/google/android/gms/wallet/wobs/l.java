package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class l
  implements SafeParcelable
{
  public static final Parcelable.Creator<l> CREATOR = new m();
  long akX;
  long akY;
  private final int xJ;
  
  l()
  {
    this.xJ = 1;
  }
  
  l(int paramInt, long paramLong1, long paramLong2)
  {
    this.xJ = paramInt;
    this.akX = paramLong1;
    this.akY = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.l
 * JD-Core Version:    0.7.0.1
 */