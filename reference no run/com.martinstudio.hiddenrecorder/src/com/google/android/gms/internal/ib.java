package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ib
  implements Parcelable.Creator<ic.b>
{
  static void a(ic.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramb.versionCode);
    b.a(paramParcel, 2, paramb.eM, false);
    b.a(paramParcel, 3, paramb.Hm, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ic.b I(Parcel paramParcel)
  {
    hz.a locala = null;
    int j = a.B(paramParcel);
    int i = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ic.b(i, str, locala);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.o(paramParcel, k);
        break;
      case 3: 
        locala = (hz.a)a.a(paramParcel, k, hz.a.CREATOR);
      }
    }
  }
  
  public ic.b[] ax(int paramInt)
  {
    return new ic.b[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ib
 * JD-Core Version:    0.7.0.1
 */