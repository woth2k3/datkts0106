package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyCard> CREATOR = new o();
  String ajS;
  String ajT;
  int ajU;
  int ajV;
  private final int xJ;
  
  ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.xJ = paramInt1;
    this.ajS = paramString1;
    this.ajT = paramString2;
    this.ajU = paramInt2;
    this.ajV = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCvn()
  {
    return this.ajT;
  }
  
  public int getExpirationMonth()
  {
    return this.ajU;
  }
  
  public int getExpirationYear()
  {
    return this.ajV;
  }
  
  public String getPan()
  {
    return this.ajS;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.ProxyCard
 * JD-Core Version:    0.7.0.1
 */