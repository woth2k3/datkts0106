package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject.a;

public final class OfferWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<OfferWalletObject> CREATOR = new n();
  String ajQ;
  CommonWalletObject ajR;
  String eC;
  private final int xJ;
  
  OfferWalletObject()
  {
    this.xJ = 3;
  }
  
  OfferWalletObject(int paramInt, String paramString1, String paramString2, CommonWalletObject paramCommonWalletObject)
  {
    this.xJ = paramInt;
    this.ajQ = paramString2;
    if (paramInt >= 3) {
      this.ajR = paramCommonWalletObject;
    } else {
      this.ajR = CommonWalletObject.nf().cw(paramString1).ng();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.ajR.getId();
  }
  
  public String getRedemptionCode()
  {
    return this.ajQ;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.OfferWalletObject
 * JD-Core Version:    0.7.0.1
 */