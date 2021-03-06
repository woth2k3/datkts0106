package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;

public class StreetViewPanoramaOrientation
  implements SafeParcelable
{
  public static final StreetViewPanoramaOrientationCreator CREATOR = new StreetViewPanoramaOrientationCreator();
  public final float bearing;
  public final float tilt;
  private final int xJ;
  
  public StreetViewPanoramaOrientation(float paramFloat1, float paramFloat2)
  {
    this(1, paramFloat1, paramFloat2);
  }
  
  StreetViewPanoramaOrientation(int paramInt, float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if ((-90.0F > paramFloat1) || (paramFloat1 > 90.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "Tilt needs to be between -90 and 90 inclusive");
    this.xJ = paramInt;
    this.tilt = (0.0F + paramFloat1);
    if (paramFloat2 <= 0.0D) {
      paramFloat2 = 360.0F + paramFloat2 % 360.0F;
    }
    this.bearing = (paramFloat2 % 360.0F);
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    return new Builder(paramStreetViewPanoramaOrientation);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof StreetViewPanoramaOrientation))
      {
        StreetViewPanoramaOrientation localStreetViewPanoramaOrientation = (StreetViewPanoramaOrientation)paramObject;
        if ((Float.floatToIntBits(this.tilt) != Float.floatToIntBits(localStreetViewPanoramaOrientation.tilt)) || (Float.floatToIntBits(this.bearing) != Float.floatToIntBits(localStreetViewPanoramaOrientation.bearing))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.tilt);
    arrayOfObject[1] = Float.valueOf(this.bearing);
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaOrientationCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    public float bearing;
    public float tilt;
    
    public Builder() {}
    
    public Builder(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    {
      this.bearing = paramStreetViewPanoramaOrientation.bearing;
      this.tilt = paramStreetViewPanoramaOrientation.tilt;
    }
    
    public Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }
    
    public StreetViewPanoramaOrientation build()
    {
      return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
    }
    
    public Builder tilt(float paramFloat)
    {
      this.tilt = paramFloat;
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaOrientation
 * JD-Core Version:    0.7.0.1
 */