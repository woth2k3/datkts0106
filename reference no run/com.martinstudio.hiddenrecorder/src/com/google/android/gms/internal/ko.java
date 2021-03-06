package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ko
  extends hz
  implements SafeParcelable, ItemScope
{
  public static final kp CREATOR = new kp();
  private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
  private String Mm;
  private double Va;
  private double Vb;
  private List<ko> acA;
  private String acB;
  private String acC;
  private ko acD;
  private String acE;
  private String acF;
  private List<ko> acG;
  private String acH;
  private String acI;
  private String acJ;
  private String acK;
  private String acL;
  private String acM;
  private String acN;
  private String acO;
  private ko acP;
  private String acQ;
  private String acR;
  private String acS;
  private ko acT;
  private ko acU;
  private ko acV;
  private List<ko> acW;
  private String acX;
  private String acY;
  private String acZ;
  private final Set<Integer> acp;
  private ko acq;
  private List<String> acr;
  private ko acs;
  private String act;
  private String acu;
  private String acv;
  private List<ko> acw;
  private int acx;
  private List<ko> acy;
  private ko acz;
  private String ada;
  private ko adb;
  private String adc;
  private String add;
  private String ade;
  private ko adf;
  private String adg;
  private String adh;
  private String adi;
  private String adj;
  private String mName;
  private String mi;
  private String qU;
  private String qV;
  private String xD;
  private final int xJ;
  
  static
  {
    aco.put("about", hz.a.a("about", 2, ko.class));
    aco.put("additionalName", hz.a.k("additionalName", 3));
    aco.put("address", hz.a.a("address", 4, ko.class));
    aco.put("addressCountry", hz.a.j("addressCountry", 5));
    aco.put("addressLocality", hz.a.j("addressLocality", 6));
    aco.put("addressRegion", hz.a.j("addressRegion", 7));
    aco.put("associated_media", hz.a.b("associated_media", 8, ko.class));
    aco.put("attendeeCount", hz.a.g("attendeeCount", 9));
    aco.put("attendees", hz.a.b("attendees", 10, ko.class));
    aco.put("audio", hz.a.a("audio", 11, ko.class));
    aco.put("author", hz.a.b("author", 12, ko.class));
    aco.put("bestRating", hz.a.j("bestRating", 13));
    aco.put("birthDate", hz.a.j("birthDate", 14));
    aco.put("byArtist", hz.a.a("byArtist", 15, ko.class));
    aco.put("caption", hz.a.j("caption", 16));
    aco.put("contentSize", hz.a.j("contentSize", 17));
    aco.put("contentUrl", hz.a.j("contentUrl", 18));
    aco.put("contributor", hz.a.b("contributor", 19, ko.class));
    aco.put("dateCreated", hz.a.j("dateCreated", 20));
    aco.put("dateModified", hz.a.j("dateModified", 21));
    aco.put("datePublished", hz.a.j("datePublished", 22));
    aco.put("description", hz.a.j("description", 23));
    aco.put("duration", hz.a.j("duration", 24));
    aco.put("embedUrl", hz.a.j("embedUrl", 25));
    aco.put("endDate", hz.a.j("endDate", 26));
    aco.put("familyName", hz.a.j("familyName", 27));
    aco.put("gender", hz.a.j("gender", 28));
    aco.put("geo", hz.a.a("geo", 29, ko.class));
    aco.put("givenName", hz.a.j("givenName", 30));
    aco.put("height", hz.a.j("height", 31));
    aco.put("id", hz.a.j("id", 32));
    aco.put("image", hz.a.j("image", 33));
    aco.put("inAlbum", hz.a.a("inAlbum", 34, ko.class));
    aco.put("latitude", hz.a.h("latitude", 36));
    aco.put("location", hz.a.a("location", 37, ko.class));
    aco.put("longitude", hz.a.h("longitude", 38));
    aco.put("name", hz.a.j("name", 39));
    aco.put("partOfTVSeries", hz.a.a("partOfTVSeries", 40, ko.class));
    aco.put("performers", hz.a.b("performers", 41, ko.class));
    aco.put("playerType", hz.a.j("playerType", 42));
    aco.put("postOfficeBoxNumber", hz.a.j("postOfficeBoxNumber", 43));
    aco.put("postalCode", hz.a.j("postalCode", 44));
    aco.put("ratingValue", hz.a.j("ratingValue", 45));
    aco.put("reviewRating", hz.a.a("reviewRating", 46, ko.class));
    aco.put("startDate", hz.a.j("startDate", 47));
    aco.put("streetAddress", hz.a.j("streetAddress", 48));
    aco.put("text", hz.a.j("text", 49));
    aco.put("thumbnail", hz.a.a("thumbnail", 50, ko.class));
    aco.put("thumbnailUrl", hz.a.j("thumbnailUrl", 51));
    aco.put("tickerSymbol", hz.a.j("tickerSymbol", 52));
    aco.put("type", hz.a.j("type", 53));
    aco.put("url", hz.a.j("url", 54));
    aco.put("width", hz.a.j("width", 55));
    aco.put("worstRating", hz.a.j("worstRating", 56));
  }
  
  public ko()
  {
    this.xJ = 1;
    this.acp = new HashSet();
  }
  
  ko(Set<Integer> paramSet, int paramInt1, ko paramko1, List<String> paramList, ko paramko2, String paramString1, String paramString2, String paramString3, List<ko> paramList1, int paramInt2, List<ko> paramList2, ko paramko3, List<ko> paramList3, String paramString4, String paramString5, ko paramko4, String paramString6, String paramString7, String paramString8, List<ko> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ko paramko5, String paramString18, String paramString19, String paramString20, String paramString21, ko paramko6, double paramDouble1, ko paramko7, double paramDouble2, String paramString22, ko paramko8, List<ko> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ko paramko9, String paramString27, String paramString28, String paramString29, ko paramko10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.acp = paramSet;
    this.xJ = paramInt1;
    this.acq = paramko1;
    this.acr = paramList;
    this.acs = paramko2;
    this.act = paramString1;
    this.acu = paramString2;
    this.acv = paramString3;
    this.acw = paramList1;
    this.acx = paramInt2;
    this.acy = paramList2;
    this.acz = paramko3;
    this.acA = paramList3;
    this.acB = paramString4;
    this.acC = paramString5;
    this.acD = paramko4;
    this.acE = paramString6;
    this.acF = paramString7;
    this.mi = paramString8;
    this.acG = paramList4;
    this.acH = paramString9;
    this.acI = paramString10;
    this.acJ = paramString11;
    this.Mm = paramString12;
    this.acK = paramString13;
    this.acL = paramString14;
    this.acM = paramString15;
    this.acN = paramString16;
    this.acO = paramString17;
    this.acP = paramko5;
    this.acQ = paramString18;
    this.acR = paramString19;
    this.xD = paramString20;
    this.acS = paramString21;
    this.acT = paramko6;
    this.Va = paramDouble1;
    this.acU = paramko7;
    this.Vb = paramDouble2;
    this.mName = paramString22;
    this.acV = paramko8;
    this.acW = paramList5;
    this.acX = paramString23;
    this.acY = paramString24;
    this.acZ = paramString25;
    this.ada = paramString26;
    this.adb = paramko9;
    this.adc = paramString27;
    this.add = paramString28;
    this.ade = paramString29;
    this.adf = paramko10;
    this.adg = paramString30;
    this.adh = paramString31;
    this.qU = paramString32;
    this.qV = paramString33;
    this.adi = paramString34;
    this.adj = paramString35;
  }
  
  public ko(Set<Integer> paramSet, ko paramko1, List<String> paramList, ko paramko2, String paramString1, String paramString2, String paramString3, List<ko> paramList1, int paramInt, List<ko> paramList2, ko paramko3, List<ko> paramList3, String paramString4, String paramString5, ko paramko4, String paramString6, String paramString7, String paramString8, List<ko> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, ko paramko5, String paramString18, String paramString19, String paramString20, String paramString21, ko paramko6, double paramDouble1, ko paramko7, double paramDouble2, String paramString22, ko paramko8, List<ko> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, ko paramko9, String paramString27, String paramString28, String paramString29, ko paramko10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.acp = paramSet;
    this.xJ = 1;
    this.acq = paramko1;
    this.acr = paramList;
    this.acs = paramko2;
    this.act = paramString1;
    this.acu = paramString2;
    this.acv = paramString3;
    this.acw = paramList1;
    this.acx = paramInt;
    this.acy = paramList2;
    this.acz = paramko3;
    this.acA = paramList3;
    this.acB = paramString4;
    this.acC = paramString5;
    this.acD = paramko4;
    this.acE = paramString6;
    this.acF = paramString7;
    this.mi = paramString8;
    this.acG = paramList4;
    this.acH = paramString9;
    this.acI = paramString10;
    this.acJ = paramString11;
    this.Mm = paramString12;
    this.acK = paramString13;
    this.acL = paramString14;
    this.acM = paramString15;
    this.acN = paramString16;
    this.acO = paramString17;
    this.acP = paramko5;
    this.acQ = paramString18;
    this.acR = paramString19;
    this.xD = paramString20;
    this.acS = paramString21;
    this.acT = paramko6;
    this.Va = paramDouble1;
    this.acU = paramko7;
    this.Vb = paramDouble2;
    this.mName = paramString22;
    this.acV = paramko8;
    this.acW = paramList5;
    this.acX = paramString23;
    this.acY = paramString24;
    this.acZ = paramString25;
    this.ada = paramString26;
    this.adb = paramko9;
    this.adc = paramString27;
    this.add = paramString28;
    this.ade = paramString29;
    this.adf = paramko10;
    this.adg = paramString30;
    this.adh = paramString31;
    this.qU = paramString32;
    this.qV = paramString33;
    this.adi = paramString34;
    this.adj = paramString35;
  }
  
  protected boolean a(hz.a parama)
  {
    return this.acp.contains(Integer.valueOf(parama.fI()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hz.a parama)
  {
    Object localObject;
    switch (parama.fI())
    {
    case 35: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
    case 2: 
      localObject = this.acq;
      break;
    case 3: 
      localObject = this.acr;
      break;
    case 4: 
      localObject = this.acs;
      break;
    case 5: 
      localObject = this.act;
      break;
    case 6: 
      localObject = this.acu;
      break;
    case 7: 
      localObject = this.acv;
      break;
    case 8: 
      localObject = this.acw;
      break;
    case 9: 
      localObject = Integer.valueOf(this.acx);
      break;
    case 10: 
      localObject = this.acy;
      break;
    case 11: 
      localObject = this.acz;
      break;
    case 12: 
      localObject = this.acA;
      break;
    case 13: 
      localObject = this.acB;
      break;
    case 14: 
      localObject = this.acC;
      break;
    case 15: 
      localObject = this.acD;
      break;
    case 16: 
      localObject = this.acE;
      break;
    case 17: 
      localObject = this.acF;
      break;
    case 18: 
      localObject = this.mi;
      break;
    case 19: 
      localObject = this.acG;
      break;
    case 20: 
      localObject = this.acH;
      break;
    case 21: 
      localObject = this.acI;
      break;
    case 22: 
      localObject = this.acJ;
      break;
    case 23: 
      localObject = this.Mm;
      break;
    case 24: 
      localObject = this.acK;
      break;
    case 25: 
      localObject = this.acL;
      break;
    case 26: 
      localObject = this.acM;
      break;
    case 27: 
      localObject = this.acN;
      break;
    case 28: 
      localObject = this.acO;
      break;
    case 29: 
      localObject = this.acP;
      break;
    case 30: 
      localObject = this.acQ;
      break;
    case 31: 
      localObject = this.acR;
      break;
    case 32: 
      localObject = this.xD;
      break;
    case 33: 
      localObject = this.acS;
      break;
    case 34: 
      localObject = this.acT;
      break;
    case 36: 
      localObject = Double.valueOf(this.Va);
      break;
    case 37: 
      localObject = this.acU;
      break;
    case 38: 
      localObject = Double.valueOf(this.Vb);
      break;
    case 39: 
      localObject = this.mName;
      break;
    case 40: 
      localObject = this.acV;
      break;
    case 41: 
      localObject = this.acW;
      break;
    case 42: 
      localObject = this.acX;
      break;
    case 43: 
      localObject = this.acY;
      break;
    case 44: 
      localObject = this.acZ;
      break;
    case 45: 
      localObject = this.ada;
      break;
    case 46: 
      localObject = this.adb;
      break;
    case 47: 
      localObject = this.adc;
      break;
    case 48: 
      localObject = this.add;
      break;
    case 49: 
      localObject = this.ade;
      break;
    case 50: 
      localObject = this.adf;
      break;
    case 51: 
      localObject = this.adg;
      break;
    case 52: 
      localObject = this.adh;
      break;
    case 53: 
      localObject = this.qU;
      break;
    case 54: 
      localObject = this.qV;
      break;
    case 55: 
      localObject = this.adi;
      break;
    case 56: 
      localObject = this.adj;
    }
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof ko))
    {
      if (this != paramObject)
      {
        ko localko = (ko)paramObject;
        Iterator localIterator = aco.values().iterator();
        hz.a locala;
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              return true;
            }
            locala = (hz.a)localIterator.next();
            if (a(locala)) {
              break;
            }
          } while (!bool.a(locala));
          bool = false;
          break;
          if (!bool.a(locala))
          {
            bool = false;
            break;
          }
        } while (b(locala).equals(bool.b(locala)));
        bool = false;
      }
      else
      {
        bool = true;
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public HashMap<String, hz.a<?, ?>> fB()
  {
    return aco;
  }
  
  public ItemScope getAbout()
  {
    return this.acq;
  }
  
  public List<String> getAdditionalName()
  {
    return this.acr;
  }
  
  public ItemScope getAddress()
  {
    return this.acs;
  }
  
  public String getAddressCountry()
  {
    return this.act;
  }
  
  public String getAddressLocality()
  {
    return this.acu;
  }
  
  public String getAddressRegion()
  {
    return this.acv;
  }
  
  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.acw;
  }
  
  public int getAttendeeCount()
  {
    return this.acx;
  }
  
  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.acy;
  }
  
  public ItemScope getAudio()
  {
    return this.acz;
  }
  
  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.acA;
  }
  
  public String getBestRating()
  {
    return this.acB;
  }
  
  public String getBirthDate()
  {
    return this.acC;
  }
  
  public ItemScope getByArtist()
  {
    return this.acD;
  }
  
  public String getCaption()
  {
    return this.acE;
  }
  
  public String getContentSize()
  {
    return this.acF;
  }
  
  public String getContentUrl()
  {
    return this.mi;
  }
  
  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.acG;
  }
  
  public String getDateCreated()
  {
    return this.acH;
  }
  
  public String getDateModified()
  {
    return this.acI;
  }
  
  public String getDatePublished()
  {
    return this.acJ;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public String getDuration()
  {
    return this.acK;
  }
  
  public String getEmbedUrl()
  {
    return this.acL;
  }
  
  public String getEndDate()
  {
    return this.acM;
  }
  
  public String getFamilyName()
  {
    return this.acN;
  }
  
  public String getGender()
  {
    return this.acO;
  }
  
  public ItemScope getGeo()
  {
    return this.acP;
  }
  
  public String getGivenName()
  {
    return this.acQ;
  }
  
  public String getHeight()
  {
    return this.acR;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public String getImage()
  {
    return this.acS;
  }
  
  public ItemScope getInAlbum()
  {
    return this.acT;
  }
  
  public double getLatitude()
  {
    return this.Va;
  }
  
  public ItemScope getLocation()
  {
    return this.acU;
  }
  
  public double getLongitude()
  {
    return this.Vb;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ItemScope getPartOfTVSeries()
  {
    return this.acV;
  }
  
  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.acW;
  }
  
  public String getPlayerType()
  {
    return this.acX;
  }
  
  public String getPostOfficeBoxNumber()
  {
    return this.acY;
  }
  
  public String getPostalCode()
  {
    return this.acZ;
  }
  
  public String getRatingValue()
  {
    return this.ada;
  }
  
  public ItemScope getReviewRating()
  {
    return this.adb;
  }
  
  public String getStartDate()
  {
    return this.adc;
  }
  
  public String getStreetAddress()
  {
    return this.add;
  }
  
  public String getText()
  {
    return this.ade;
  }
  
  public ItemScope getThumbnail()
  {
    return this.adf;
  }
  
  public String getThumbnailUrl()
  {
    return this.adg;
  }
  
  public String getTickerSymbol()
  {
    return this.adh;
  }
  
  public String getType()
  {
    return this.qU;
  }
  
  public String getUrl()
  {
    return this.qV;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public String getWidth()
  {
    return this.adi;
  }
  
  public String getWorstRating()
  {
    return this.adj;
  }
  
  public boolean hasAbout()
  {
    return this.acp.contains(Integer.valueOf(2));
  }
  
  public boolean hasAdditionalName()
  {
    return this.acp.contains(Integer.valueOf(3));
  }
  
  public boolean hasAddress()
  {
    return this.acp.contains(Integer.valueOf(4));
  }
  
  public boolean hasAddressCountry()
  {
    return this.acp.contains(Integer.valueOf(5));
  }
  
  public boolean hasAddressLocality()
  {
    return this.acp.contains(Integer.valueOf(6));
  }
  
  public boolean hasAddressRegion()
  {
    return this.acp.contains(Integer.valueOf(7));
  }
  
  public boolean hasAssociated_media()
  {
    return this.acp.contains(Integer.valueOf(8));
  }
  
  public boolean hasAttendeeCount()
  {
    return this.acp.contains(Integer.valueOf(9));
  }
  
  public boolean hasAttendees()
  {
    return this.acp.contains(Integer.valueOf(10));
  }
  
  public boolean hasAudio()
  {
    return this.acp.contains(Integer.valueOf(11));
  }
  
  public boolean hasAuthor()
  {
    return this.acp.contains(Integer.valueOf(12));
  }
  
  public boolean hasBestRating()
  {
    return this.acp.contains(Integer.valueOf(13));
  }
  
  public boolean hasBirthDate()
  {
    return this.acp.contains(Integer.valueOf(14));
  }
  
  public boolean hasByArtist()
  {
    return this.acp.contains(Integer.valueOf(15));
  }
  
  public boolean hasCaption()
  {
    return this.acp.contains(Integer.valueOf(16));
  }
  
  public boolean hasContentSize()
  {
    return this.acp.contains(Integer.valueOf(17));
  }
  
  public boolean hasContentUrl()
  {
    return this.acp.contains(Integer.valueOf(18));
  }
  
  public boolean hasContributor()
  {
    return this.acp.contains(Integer.valueOf(19));
  }
  
  public boolean hasDateCreated()
  {
    return this.acp.contains(Integer.valueOf(20));
  }
  
  public boolean hasDateModified()
  {
    return this.acp.contains(Integer.valueOf(21));
  }
  
  public boolean hasDatePublished()
  {
    return this.acp.contains(Integer.valueOf(22));
  }
  
  public boolean hasDescription()
  {
    return this.acp.contains(Integer.valueOf(23));
  }
  
  public boolean hasDuration()
  {
    return this.acp.contains(Integer.valueOf(24));
  }
  
  public boolean hasEmbedUrl()
  {
    return this.acp.contains(Integer.valueOf(25));
  }
  
  public boolean hasEndDate()
  {
    return this.acp.contains(Integer.valueOf(26));
  }
  
  public boolean hasFamilyName()
  {
    return this.acp.contains(Integer.valueOf(27));
  }
  
  public boolean hasGender()
  {
    return this.acp.contains(Integer.valueOf(28));
  }
  
  public boolean hasGeo()
  {
    return this.acp.contains(Integer.valueOf(29));
  }
  
  public boolean hasGivenName()
  {
    return this.acp.contains(Integer.valueOf(30));
  }
  
  public boolean hasHeight()
  {
    return this.acp.contains(Integer.valueOf(31));
  }
  
  public boolean hasId()
  {
    return this.acp.contains(Integer.valueOf(32));
  }
  
  public boolean hasImage()
  {
    return this.acp.contains(Integer.valueOf(33));
  }
  
  public boolean hasInAlbum()
  {
    return this.acp.contains(Integer.valueOf(34));
  }
  
  public boolean hasLatitude()
  {
    return this.acp.contains(Integer.valueOf(36));
  }
  
  public boolean hasLocation()
  {
    return this.acp.contains(Integer.valueOf(37));
  }
  
  public boolean hasLongitude()
  {
    return this.acp.contains(Integer.valueOf(38));
  }
  
  public boolean hasName()
  {
    return this.acp.contains(Integer.valueOf(39));
  }
  
  public boolean hasPartOfTVSeries()
  {
    return this.acp.contains(Integer.valueOf(40));
  }
  
  public boolean hasPerformers()
  {
    return this.acp.contains(Integer.valueOf(41));
  }
  
  public boolean hasPlayerType()
  {
    return this.acp.contains(Integer.valueOf(42));
  }
  
  public boolean hasPostOfficeBoxNumber()
  {
    return this.acp.contains(Integer.valueOf(43));
  }
  
  public boolean hasPostalCode()
  {
    return this.acp.contains(Integer.valueOf(44));
  }
  
  public boolean hasRatingValue()
  {
    return this.acp.contains(Integer.valueOf(45));
  }
  
  public boolean hasReviewRating()
  {
    return this.acp.contains(Integer.valueOf(46));
  }
  
  public boolean hasStartDate()
  {
    return this.acp.contains(Integer.valueOf(47));
  }
  
  public boolean hasStreetAddress()
  {
    return this.acp.contains(Integer.valueOf(48));
  }
  
  public boolean hasText()
  {
    return this.acp.contains(Integer.valueOf(49));
  }
  
  public boolean hasThumbnail()
  {
    return this.acp.contains(Integer.valueOf(50));
  }
  
  public boolean hasThumbnailUrl()
  {
    return this.acp.contains(Integer.valueOf(51));
  }
  
  public boolean hasTickerSymbol()
  {
    return this.acp.contains(Integer.valueOf(52));
  }
  
  public boolean hasType()
  {
    return this.acp.contains(Integer.valueOf(53));
  }
  
  public boolean hasUrl()
  {
    return this.acp.contains(Integer.valueOf(54));
  }
  
  public boolean hasWidth()
  {
    return this.acp.contains(Integer.valueOf(55));
  }
  
  public boolean hasWorstRating()
  {
    return this.acp.contains(Integer.valueOf(56));
  }
  
  public int hashCode()
  {
    Iterator localIterator = aco.values().iterator();
    hz.a locala2;
    for (hz.a locala3 = 0;; locala3 = locala2)
    {
      if (!localIterator.hasNext()) {
        return locala3;
      }
      hz.a locala1 = (hz.a)localIterator.next();
      if (!a(locala1)) {
        locala1 = locala3;
      } else {
        locala2 = locala3 + locala1.fI() + b(locala1).hashCode();
      }
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  Set<Integer> kf()
  {
    return this.acp;
  }
  
  ko kg()
  {
    return this.acq;
  }
  
  ko kh()
  {
    return this.acs;
  }
  
  List<ko> ki()
  {
    return this.acw;
  }
  
  List<ko> kj()
  {
    return this.acy;
  }
  
  ko kk()
  {
    return this.acz;
  }
  
  List<ko> kl()
  {
    return this.acA;
  }
  
  ko km()
  {
    return this.acD;
  }
  
  List<ko> kn()
  {
    return this.acG;
  }
  
  ko ko()
  {
    return this.acP;
  }
  
  ko kp()
  {
    return this.acT;
  }
  
  ko kq()
  {
    return this.acU;
  }
  
  ko kr()
  {
    return this.acV;
  }
  
  List<ko> ks()
  {
    return this.acW;
  }
  
  ko kt()
  {
    return this.adb;
  }
  
  ko ku()
  {
    return this.adf;
  }
  
  public ko kv()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kp.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ko
 * JD-Core Version:    0.7.0.1
 */