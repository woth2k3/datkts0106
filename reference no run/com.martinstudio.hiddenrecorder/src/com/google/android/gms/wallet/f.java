package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class f
  implements Parcelable.Creator<FullWallet>
{
  static void a(FullWallet paramFullWallet, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramFullWallet.getVersionCode());
    b.a(paramParcel, 2, paramFullWallet.aiN, false);
    b.a(paramParcel, 3, paramFullWallet.aiO, false);
    b.a(paramParcel, 4, paramFullWallet.aiP, paramInt, false);
    b.a(paramParcel, 5, paramFullWallet.aiQ, false);
    b.a(paramParcel, 6, paramFullWallet.aiR, paramInt, false);
    b.a(paramParcel, 7, paramFullWallet.aiS, paramInt, false);
    b.a(paramParcel, 8, paramFullWallet.aiT, false);
    b.a(paramParcel, 9, paramFullWallet.aiU, paramInt, false);
    b.a(paramParcel, 10, paramFullWallet.aiV, paramInt, false);
    b.a(paramParcel, 11, paramFullWallet.aiW, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public FullWallet bU(Parcel paramParcel)
  {
    InstrumentInfo[] arrayOfInstrumentInfo = null;
    int i = a.B(paramParcel);
    int j = 0;
    UserAddress localUserAddress1 = null;
    UserAddress localUserAddress2 = null;
    String[] arrayOfString = null;
    Address localAddress2 = null;
    Address localAddress1 = null;
    String str3 = null;
    ProxyCard localProxyCard = null;
    String str2 = null;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new FullWallet(j, str1, str2, localProxyCard, str3, localAddress1, localAddress2, arrayOfString, localUserAddress2, localUserAddress1, arrayOfInstrumentInfo);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        localProxyCard = (ProxyCard)a.a(paramParcel, k, ProxyCard.CREATOR);
        break;
      case 5: 
        str3 = a.o(paramParcel, k);
        break;
      case 6: 
        localAddress1 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 7: 
        localAddress2 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 8: 
        arrayOfString = a.A(paramParcel, k);
        break;
      case 9: 
        localUserAddress2 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 10: 
        localUserAddress1 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 11: 
        arrayOfInstrumentInfo = (InstrumentInfo[])a.b(paramParcel, k, InstrumentInfo.CREATOR);
      }
    }
  }
  
  public FullWallet[] dA(int paramInt)
  {
    return new FullWallet[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.f
 * JD-Core Version:    0.7.0.1
 */