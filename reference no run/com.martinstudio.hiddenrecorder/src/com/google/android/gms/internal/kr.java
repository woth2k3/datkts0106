package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class kr
  implements Parcelable.Creator<kq>
{
  static void a(kq paramkq, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramkq.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramkq.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramkq.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramkq.kw(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramkq.getStartDate(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramkq.kx(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramkq.getType(), true);
    }
    b.G(paramParcel, i);
  }
  
  public kq bF(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    ko localko1 = null;
    String str1 = null;
    ko localko2 = null;
    String str3 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new kq(localHashSet, i, str3, localko2, str1, localko1, str2);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str3 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4: 
        localko2 = (ko)a.a(paramParcel, k, ko.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        localko2 = localko2;
        break;
      case 5: 
        str1 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        localko1 = (ko)a.a(paramParcel, k, ko.CREATOR);
        localHashSet.add(Integer.valueOf(6));
        localko1 = localko1;
        break;
      case 7: 
        str2 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
  }
  
  public kq[] dc(int paramInt)
  {
    return new kq[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kr
 * JD-Core Version:    0.7.0.1
 */