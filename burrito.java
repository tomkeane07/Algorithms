import java.lang.Math;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

class Destination
{
   double x;
   double y;
   String address;
   double orderT;
   double distance;
   int index;
   
   public Destination(int index, String address, double x, double y, double orderT)
   {
      this.index = index;
      this.address = address;
      this.x=x;
      this.y=y;
      this.orderT=orderT;
   }
   public double getDistance()
   {
      return this.distance;
   }
}
class Drone
{
   double x;
   double y;

   public void Drone(double x, double y)
   {
      this.x = x;
      this.y = y;
      double[] location = {x,y};
   }
   
   public void setLocation(double x, double y)
   {
      this.x = x;
      this.y = y;
      double[] location = {x,y};
   }
   
   public void getLocation()
   {
      System.out.println(x+","+y);
   }
}

class Haversine {
  private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

  public static double Distance(double startLat, double startLong,
                                double endLat, double endLong) {

      double dLat  = Math.toRadians((endLat - startLat));
      double dLong = Math.toRadians((endLong - startLong));

      startLat = Math.toRadians(startLat);
      endLat   = Math.toRadians(endLat);

      double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

      return EARTH_RADIUS * c; // <-- d
  }

  public static double haversin(double val) {
      return Math.pow(Math.sin(val / 2), 2);
  }
}


public class burrito
{
   static ArrayList<Destination> queue = new ArrayList<Destination>();
   static double time = 19.60;
   static Drone drone = new Drone();
   static double Travelled = 0;
   static int lateCount = 0;
   static double lateMins = 0;
   
   public static void main(String[] args){
    double velocity = 80.00;
   
    Destination origin = new Destination(0,"Burrito Bear", 53.38195, -6.59192, time);
      drone.setLocation(origin.x, origin.y);
      
      Destination delivery1 = new Destination(1,"The Paddocks, Oldtown Mill, Celbridge, Co. Kildare", 53.3473, -6.55057,19.12);
      Destination delivery2 = new Destination(2,"156 Glendale, Leixlip, Co. Kildare", 53.37077, -6.48279,19.12);
      Destination delivery3 = new Destination(3,"26 Thornhill Meadows, Celbridge, Co. Kildare", 53.35152, -6.54989,19.12);
      Destination delivery4 = new Destination(4,"47 Meadowbrook Avenue,Maynooth Co Kildare", 53.37278, -6.59611,19.12);
      Destination delivery5 = new Destination(5,"112 Mill Lane, Kilcock, Co. Kildare", 53.40126, -6.6683,19.13);
      Destination delivery6 = new Destination(6,"54 Willowbrook Lawns, Celbridge, Co. Kildare", 53.34484, -6.54766,19.14);
      Destination delivery7 = new Destination(7,"416A Ballyoulster, Celbridge, Co. Kildare", 53.34133, -6.51856,19.15);
      Destination delivery8 = new Destination(8,"37 The Orchard, Oldtown Mill, Celbridge, Co. Kildare", 53.34492, -6.5557,19.15);
      Destination delivery9 = new Destination(9,"4 Abbey Park Grove, Clane, Co. Kildare", 53.29206, -6.67685,19.16);
      Destination delivery10 = new Destination(10,"36 Rinawade Park, Leixlip, Co. Kildare", 53.36483, -6.51278,19.16);
      Destination delivery11 = new Destination(11,"1 The Close, Temple Manor,Celbridge , Co.Kildare", 53.33067, -6.54686,19.16);
      Destination delivery12 = new Destination(12,"35 Beech Park Wood Beech Park,Leixlip Co Kildare", 53.36287, -6.52468,19.16);
      Destination delivery13 = new Destination(13,"544 Riverforest, Leixlip, Co. Kildare", 53.37416, -6.49494,19.17);
      Destination delivery14 = new Destination(14,"54 Courtown Park,Kilcock Co Kildare", 53.39549, -6.67647,19.17);
      Destination delivery15 = new Destination(15,"10 The Drive, Abbeyfarm, Celbridge, Co. Kildare", 53.33239, -6.55163,19.18);
      Destination delivery16 = new Destination(16,"43 The Woodlands, Castletown, Celbridge, Co. Kildare", 53.34678, -6.53415,19.18);
      Destination delivery17 = new Destination(17,"1002 Avondale, Leixlip, Co. Kildare", 53.36869, -6.48314,19.18);
      Destination delivery18 = new Destination(18,"38 Parsons Hall, Maynooth, Co. Kildare", 53.37521, -6.6103,19.19);
      Destination delivery19 = new Destination(19,"32 The View, St.Wolstan Abbey,Celbridge, Co.Kildare", 53.33751, -6.53173,19.20);
      Destination delivery20 = new Destination(20,"10 Glen Easton Crescent, Leixlip, Co. Kildare", 53.37184, -6.50065, 19.21);
      Destination delivery21 = new Destination(21,"11 Rinawade View, Leixlip, Co. Kildare", 53.36143, -6.51849, 19.21);
      Destination delivery22 = new Destination(22,"856 Old Greenfield, Maynooth, Co.Kildare", 53.37473, -6.59338, 19.21);
      Destination delivery23 = new Destination(23,"8 The Avenue, Castletown, Co.Kildare, Celbridge, Co. Kildare", 53.34514, -6.53615, 19.22);
      Destination delivery24 = new Destination(24,"9 The Park, Louisa Valley, Leixlip, Co. Kildare", 53.36115, -6.48907, 19.22);
      Destination delivery25 = new Destination(25,"33 Leinster Wood,Carton Demesne, Maynooth, Co.Kildare", 53.39351, -6.5542, 19.23);
      Destination delivery26 = new Destination(26,"16 Priory Chase, St.Raphaels Manor,Celbridge, Co.Kildare", 53.33886, -6.55468, 19.23);
      Destination delivery27 = new Destination(27,"14 The Rise, Louisa Valley, Leixlip, Co. Kildare", 53.36115, -6.48907, 19.25);
      Destination delivery28 = new Destination(28,"646 Riverforest,Leixlip Co Kildare", 53.37497, -6.4991, 19.26);
      Destination delivery29 = new Destination(29,"76 Castle Dawson, Maynooth, Co. Kildare", 53.37565, -6.60716, 19.27);
      Destination delivery30 = new Destination(30,"23 Priory Way, St.Raphaels Manor,,Celbridge, Co.Kildare", 53.3354, -6.55111, 19.27);
      Destination delivery31 = new Destination(31,"5 Rinawade View, Leixlip, Co. Kildare", 53.36143, -6.51849, 19.28);
      Destination delivery32 = new Destination(32,"11 The Park, Louisa Valley, Leixlip, Co. Kildare", 53.36115, -6.48907, 19.28);
      Destination delivery33 = new Destination(33,"117 Royal Meadows,Kilcock Co Kildare", 53.39459, -6.66995, 19.28);
      Destination delivery34 = new Destination(34,"12 Maynooth Park, Maynooth, Co. Kildare", 53.37122, -6.586, 19.29);
      Destination delivery35 = new Destination(35,"30 Ryevale Lawns, Leixlip, Co. Kildare", 53.36656, -6.49183, 19.30);
      Destination delivery36 = new Destination(36,"44 Rinawade Avenue, Leixlip, Co. Kildare", 53.36141, -6.51834, 19.30);
      Destination delivery37 = new Destination(37,"7 Straffan Green, Straffan Wood, Maynooth, Co. Kildare", 53.37323, -6.58859, 19.30);
      Destination delivery38 = new Destination(38,"29 Castletown, Leixlip, Co. Kildare", 53.36292, -6.50203, 19.31);
      Destination delivery39 = new Destination(39,"1 Kyldar House, Manor Mills, Maynooth, Co. Kildare", 53.38122, -6.59226, 19.31);
      Destination delivery40 = new Destination(40,"83 Thornhill Meadows, Celbridge, Co. Kildare", 53.35098, -6.54915, 19.31); 
      Destination delivery41 = new Destination(41,"90 Vanessa Lawns, Celbridge, Co. Kildare", 53.34312, -6.54747, 19.31);
      Destination delivery42 = new Destination(42,"50 The Lawn, Oldtown Mill, Celbridge, Co. Kildare", 53.34197, -6.55492, 19.31);
      Destination delivery43 = new Destination(43,"20 Habourview, The Glenroyal Centre, Maynooth, Co.Kildare", 53.37954, -6.58793, 19.32);
      Destination delivery44 = new Destination(44,"13 The Little Grove, Celbridge, Co Kildare", 53.33835, -6.53984, 19.32);
      Destination delivery45 = new Destination(45,"10 Brookfield Avenue,Maynooth Co Kildare", 53.36976, -6.59828, 19.33);
      Destination delivery46 = new Destination(46,"35 Rail Park, Co.Kildare, Maynooth, Co. Kildare", 53.37811, -6.57952, 19.34);
      Destination delivery47 = new Destination(47,"10 Fair Green Court, Kilccock,, Co. Kildare", 53.39847, -6.66787, 19.34);
      Destination delivery48 = new Destination(48,"3 Lyreen Park,Maynooth Co Kildare", 53.38579, -6.58673, 19.34);
      Destination delivery49 = new Destination(49,"34 Silken Vale, Maynooth, Co. Kildare", 53.37626, -6.59308, 19.34);
      Destination delivery50 = new Destination(50,"35 Glen Easton Square, Leixlip, Co. Kildare", 53.37336, -6.48219, 19.35);
      Destination delivery51 = new Destination(51,"10 The Court, Abbey Farm,,Celbridge, Co.Kildare", 53.33032, -6.55311, 19.35);
      Destination delivery52 = new Destination(52,"4 Glendale, Leixlip, Co. Kildare", 53.37201, -6.48517, 19.36);
      Destination delivery53 = new Destination(53,"628 Riverforest, Leixlip, Co. Kildare", 53.37416, -6.49731, 19.36);
      Destination delivery54 = new Destination(54,"111 Elton Court, Leixlip, Co. Kildare", 53.36164, -6.50526, 19.36);
      Destination delivery55 = new Destination(55,"169 Glendale, Co.Kildare, Leixlip, Co. Kildare", 53.37043, -6.48193, 19.37);
      Destination delivery56 = new Destination(56,"94 Croduan Forest Park, Celbridge, Co. Kildare", 53.35372, -6.54564, 19.37);
      Destination delivery57 = new Destination(57,"13 Abbey Park Court , Clane, , Co Kildare.", 53.2908, -6.67746, 19.37);
      Destination delivery58 = new Destination(58,"533 Courtown Road, Kilcock, Co. Kildare", 53.39792, -6.6711, 19.39);
      Destination delivery59 = new Destination(59,"13 The Hawthorns, Kilcock, Co. Kildare", 53.39315, -6.66909, 19.41);
      Destination delivery60 = new Destination(60,"106 The Drive, Castletown,,Celbridge, Co.Kildare", 53.34439, -6.53841, 19.41);       
      Destination delivery61 = new Destination(61,"15 Willow Rise, Primrose Gate, Celbridge, Co. Kildare", 53.33591, -6.53566, 19.42);
      Destination delivery62 = new Destination(62,"7 Rinawade Park, Leixlip, Co. Kildare", 53.3632, -6.51178, 19.42);
      Destination delivery63 = new Destination(63,"40 Oaklawn West., Leixlip, Co. Kildare", 53.36833, -6.50589, 19.43);
      Destination delivery64 = new Destination(64,"12 Castlevillage Avenue, Celbridge, Co. Kildare", 53.35298, -6.54921, 19.43);
      Destination delivery65 = new Destination(65,"107 Castle Dawson, Maynooth, Co. Kildare", 53.38122, -6.59226, 19.43);
      Destination delivery66 = new Destination(66,"The Downs, St.Wolstan Abbey,,Celbridge, Co.Kildare", 53.33605, -6.53414, 19.43);
      Destination delivery67 = new Destination(67,"Simmonstown Manor, Celbridge, Co. Kildare", 53.33324, -6.53978, 19.45);
      Destination delivery68 = new Destination(68,"2 Parsons Street, Maynooth, Co. Kildare", 53.38039, -6.59368, 19.45);
      Destination delivery69 = new Destination(69,"6 Glen Easton View,Leixlip Co Kildare", 53.36883, -6.51468, 19.45);
      Destination delivery70 = new Destination(70,"78 Crodaun Forest Park, Celbridge, Co. Kildare", 53.35401, -6.54603, 19.46);
      Destination delivery71 = new Destination(71,"172 Woodview, Castletown, Celbridge, Co. Kildare", 53.34745, -6.53401, 19.47);
      Destination delivery72 = new Destination(72,"116 Connaught Street, Kilcock, Co. Kildare", 53.39839, -6.66767, 19.48);
      Destination delivery73 = new Destination(73,"35 The Paddocks, Oldtown Mill, Celbridge, Co. Kildare", 53.3473, -6.55057, 19.48);
      Destination delivery74 = new Destination(74,"11 The Lodge,, Abbeylands,, Clane,, Co. Kildare", 53.29128, -6.67836, 19.48);
      Destination delivery75 = new Destination(75,"113 Elton Court, Leixlip, Co. Kildare", 53.36158, -6.50533, 19.48);
      Destination delivery76 = new Destination(76,"3 Greenfield Drive, Maynooth, Co. Kildare", 53.3727, -6.58757, 19.49);
      Destination delivery77 = new Destination(77,"13 Castlevillage Lawns, Celbridge, Co. Kildare", 53.35321, -6.55412, 19.50);
      Destination delivery78 = new Destination(78,"902 Lady Castle, K Club, Straffan, Co. Kildare", 53.31159, -6.60538, 19.50);
      Destination delivery79 = new Destination(79,"13 Rinawade Close, Leixlip, Co. Kildare", 53.36455, -6.51435, 19.50);
      Destination delivery80 = new Destination(80,"Apartment 1, The Lamps, School Street, Kilcock, Co. Kildare", 53.39999, -6.66807, 19.50);
      Destination delivery81 = new Destination(81,"2 Beaufield Drive, Maynooth, Co. Kildare", 53.37414, -6.60028, 19.51);
      Destination delivery82 = new Destination(82,"509 Riverforest, Leixlip, Co. Kildare", 53.37402, -6.49363, 19.51);
      Destination delivery83 = new Destination(83,"43 The Green Moyglare Hall,Maynooth Co Kildare", 53.38983, -6.5951, 19.51);
      Destination delivery84 = new Destination(84,"636 St.Patrick Park,Celbridge, Co.Kildare", 53.34033, -6.54596, 19.52);
      Destination delivery85 = new Destination(85,"132 The Peninsula, Alexandra Walk, Clane, Co. Kildare", 53.28973, -6.67445, 19.52);
      Destination delivery86 = new Destination(86,"14 Rye River Crescent, Dun Carraig, Leixlip, Co. Kildare", 53.36518, -6.48913, 19.52);
      Destination delivery87 = new Destination(87,"348 Ryevale Lawns, Leixlip, Co. Kildare", 53.36873, -6.49619, 19.52);
      Destination delivery88 = new Destination(88,"17 The Crescent, Abbey Farm,,Celbridge, Co.Kildare", 53.33256, -6.55056, 19.52);
      Destination delivery89 = new Destination(89,"36 Castledawson,Maynooth Co Kildare", 53.37565, -6.60701, 19.53);
      Destination delivery90 = new Destination(90,"28 The Lawn Moyglare Abbey,Maynooth Co Kildare", 53.38895, -6.60579, 19.53);
      Destination delivery91 = new Destination(91,"104c Beatty Park, Celbridge, Co. Kildare", 53.34648, -6.54552, 19.54);
      Destination delivery92 = new Destination(92,"40 Thornhill Meadows, Celbridge, Co. Kildare", 53.35202, -6.55099, 19.55);
      Destination delivery93 = new Destination(93,"18 College Green, Maynooth, Co.Kildare", 53.37247, -6.60044, 19.55);
      Destination delivery94 = new Destination(94,"1 Beaufield Crescent, Maynooth, Co Kildare", 53.37449, -6.60005, 19.56);
      Destination delivery95 = new Destination(95,"6 Glen Easton Grove ,Leixlip Co Kildare", 53.36559, -6.51914, 19.56);
      Destination delivery96 = new Destination(96,"14 The Avenue, Rochford, Bakers Walk, Kilcock, Co. Kildare", 53.39648, -6.66612, 19.57);
      Destination delivery97 = new Destination(97,"7 Riverlawn, Abbeyfarm, Celbridge, Co. Kildare", 53.33239, -6.55163, 19.57);
      Destination delivery98 = new Destination(98,"51 Royal Meadows, Kilcock, Co. Kildare", 53.39512, -6.67084, 19.57);
      Destination delivery99 = new Destination(99,"96 Priory Lodge, St. Raphael's Manor, Celbridge, Co.Kildare", 53.33835, -6.53984, 19.58);
      Destination delivery100 = new Destination(100,"18 Castle Dawson, Maynooth,, Co. Kildare", 53.37538, -6.60707, 19.58);

       


      queue.add(delivery1);
      queue.add(delivery2);queue.add(delivery3);
      queue.add(delivery4);queue.add(delivery5);
      queue.add(delivery6);queue.add(delivery7);
      queue.add(delivery8);queue.add(delivery9);
      queue.add(delivery10);queue.add(delivery11);
      queue.add(delivery12);queue.add(delivery13);
      queue.add(delivery14);queue.add(delivery15);
      queue.add(delivery16);queue.add(delivery17);
      queue.add(delivery18);queue.add(delivery19);
      queue.add(delivery20);queue.add(delivery21);
      queue.add(delivery22);queue.add(delivery23);
      queue.add(delivery24);queue.add(delivery25);
      queue.add(delivery26);queue.add(delivery27);
      queue.add(delivery28);queue.add(delivery29);
      queue.add(delivery30);queue.add(delivery31);
      queue.add(delivery32);queue.add(delivery33);
      queue.add(delivery34);queue.add(delivery35);
      queue.add(delivery36);queue.add(delivery37);
      queue.add(delivery38);queue.add(delivery39);
      queue.add(delivery40);queue.add(delivery41);
      queue.add(delivery42);queue.add(delivery43);
      queue.add(delivery44);queue.add(delivery45);
      queue.add(delivery46);queue.add(delivery47);
      queue.add(delivery48);queue.add(delivery49);
      queue.add(delivery50);queue.add(delivery51);
      queue.add(delivery52);queue.add(delivery53);
      queue.add(delivery54);queue.add(delivery55);
      queue.add(delivery56);queue.add(delivery57);
      queue.add(delivery58);queue.add(delivery59);
      queue.add(delivery60);queue.add(delivery61);
      queue.add(delivery62);queue.add(delivery63);
      queue.add(delivery64);queue.add(delivery65);
      queue.add(delivery66);queue.add(delivery67);
      queue.add(delivery68);queue.add(delivery69);
      queue.add(delivery70);queue.add(delivery71);
      queue.add(delivery72);queue.add(delivery73);
      queue.add(delivery74);queue.add(delivery75);
      queue.add(delivery76);queue.add(delivery77);
      queue.add(delivery78);queue.add(delivery79);
      queue.add(delivery80);queue.add(delivery81);
      queue.add(delivery82);queue.add(delivery83);
      queue.add(delivery84);queue.add(delivery85);
      queue.add(delivery86);queue.add(delivery87);
      queue.add(delivery88);queue.add(delivery89);
      queue.add(delivery90);queue.add(delivery91);
      queue.add(delivery92);queue.add(delivery93);
      queue.add(delivery94);queue.add(delivery95);
      queue.add(delivery96);queue.add(delivery97);
      queue.add(delivery98);queue.add(delivery99);
      queue.add(delivery100);

      
      while(queue.size()>0){
        if(drone.x == origin.x && drone.y == origin.y)
         {
            System.out.println("drone at shop");
         }
        Destination priority = queue.get(0);
        //System.out.println("__________________________________PRIORITY IS "+priority.address);
        Travelled += SearchHorizon(drone, priority, queue, time, lateCount);
    }
    System.out.println(Travelled+" Km travelled");
    System.out.println("travelling time: " +Travelled*60/80+" minutes");
    System.out.println("lateMins.."+lateMins);
    //System.out.println(lateCount+" lates");
   }
   
   public static double SearchHorizon(Drone d,Destination p, ArrayList<Destination> queue,  double time, int lateCount)
   {
      double travelled = 0;
      int B = (time - p.orderT < 0.25)? 30:20;
      ArrayList<Destination> stops = new ArrayList<Destination>();
      double distanceDP = getDistance(Double.toString(d.x), Double.toString(d.y), Double.toString(p.x), Double.toString(p.y));
      int A = (queue.size()>=B) ? B:queue.size();
      double distanceDS;
      double lateBy;
      String l="";

      //int lateCount=0;
      for(int i = 1; i<A; i++)
      {
         Destination Stop = queue.get(i);
         distanceDS = getDistance(Double.toString(d.x), Double.toString(d.y), Double.toString(Stop.x), Double.toString(Stop.y));
         if(getDistance(Double.toString(Stop.x), Double.toString(Stop.y), Double.toString(p.x), Double.toString(p.y)) < distanceDP && distanceDS< distanceDP)
         {  
         	  l="";
              stops.add(Stop);
              queue.remove(i);
              A-=1;
              d.setLocation(Stop.x, Stop.y);
              travelled += distanceDS;
              if(time>=Stop.orderT+0.3)
              {
                l="!";
                lateBy = time - Stop.orderT;
                lateCount+=1;

              }
              i-=1;
              System.out.println(Stop.index+", ");
         }
      }
      stops.add(p);
      queue.remove(0);
      
      distanceDS = getDistance(Double.toString(d.x), Double.toString(d.y), Double.toString(p.x), Double.toString(p.y));
      d.setLocation(p.x, p.y);
      travelled += distanceDS;
      if(time>=p.orderT+0.3)
      {
        lateBy = time - p.orderT;
        lateMins +=lateBy*100;

        lateCount+=1;
      }
      if(queue.size()>0)System.out.println(p.index+", ");
      else System.out.println(p.index);
      System.out.println(travelled);
      return travelled;
   }

   public static double getDistance(String lt1, String ln1, String lt2, String ln2){
        final int R = 6371; // Radious of the earth
        Double lat1 = Double.parseDouble(lt1);
        Double lon1 = Double.parseDouble(ln1);
        Double lat2 = Double.parseDouble(lt2);
        Double lon2 = Double.parseDouble(ln2);
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
        Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
        return distance*1000;
    }
   
    public static Double toRad(Double value) {
         return value * Math.PI / 180;
    }
   
}

