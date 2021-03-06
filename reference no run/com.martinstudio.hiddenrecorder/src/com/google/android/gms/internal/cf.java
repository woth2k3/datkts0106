package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cf
  implements SafeParcelable
{
  public static final ce CREATOR = new ce();
  public final String mimeType;
  public final String nY;
  public final String nZ;
  public final String oa;
  public final String ob;
  public final String oc;
  public final String packageName;
  public final int versionCode;
  
  public cf(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.versionCode = paramInt;
    this.nY = paramString1;
    this.nZ = paramString2;
    this.mimeType = paramString3;
    this.packageName = paramString4;
    this.oa = paramString5;
    this.ob = paramString6;
    this.oc = paramString7;
  }
  
  public cf(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ce.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cf
 * JD-Core Version:    0.7.0.1
 */