import java.text.DecimalFormat;
    /** 
      * Spherocylinder.
      * A program to set value of cyclinder.
      * Project 02
      * @author Shane Justice
      * @version 03/24/2019 
      */
public class Spherocylinder
{
   private String label = "";
   private double radius;
   private double cylinderHeight; 
   private static int count = 0;
    /**
      * set default value.
      * @param labelIn Command line arguments (not used).
      * @param radiusIn Command line arguments (not used).
      * @param cylinderHeightIn Command line arguments (not used).
      */
   public Spherocylinder(String labelIn, double radiusIn, 
                         double cylinderHeightIn)
   {
      setLabel(labelIn);
      setRadius(radiusIn);
      setCylinderHeight(cylinderHeightIn);
      count++;
   } 
   //getCount gets total number of objects created.
   /**
     *@return count of object created.
     */
   public static int getCount() {
      return count;

   }

   /**resetCount set's count to zero.
     */
   public static void resetCount() {
      count = 0;

   }
    /**
      * Get label of Spherocylinder.
      * @return label Command line arguments (not used).
      */
   public String getLabel()
   {
      return label;
   }
    /**
      * Set the value of label.
      * If label is null return false.
      * @return labelIn Command line arguments (not used).
      * @param labelIn Command line arguments (not used).
      */
   public boolean setLabel(String labelIn) {
      boolean isSet = false;
      if (labelIn != null) {
         label = labelIn.trim();
         isSet = true;
      }
      return isSet;
   }
    /**
      * Get radius of Spherocylinder.
      * @return radius Command line arguments (not used).
      */
   public double getRadius()
   {
      return radius;
   }  
    /**
      * set the value of radius.
      * radius is equal or greater than zero.
      * @return radiusIn Command line arguments (not used).
      * @param radiusIn Command line arguments (not used).
      */
   public boolean setRadius(double radiusIn)
   {
      boolean isSet = false;
      if (radiusIn >= 0)
      {
         radius = radiusIn;
         isSet = true;
      }
      return isSet;
   }
    /**
      * Get height of Cylinder.
      * @return height Command line arguments (not used).
      */
   public double getCylinderHeight()
   {
      return cylinderHeight;
   } 
    /**
      * Set Cylinder Height.
      * Cylinder Height should equal or greater than zero.
      * @return cylinderHeightIn Command line arguments (not used).
      * @param cylinderHeightIn Command line arguments (not used).
      */
   public boolean setCylinderHeight(double cylinderHeightIn)
   {
      boolean isSet = false;
      if (cylinderHeightIn >= 0)
      {
         cylinderHeight = cylinderHeightIn;
         isSet = true;
      }
      return isSet;
   }
    /**
      * Calculate circumference of cylinder.
      * @return circumference Command line arguments (not used).
      */
      
   public double circumference()
   { 
      return 2 * Math.PI * radius;
   }
    /**
      * Calculate surfaceArea of cylinder.
      * @return surfaceArea Command line arguments (not used).
      */
   public double surfaceArea()
   {
      return 2 * Math.PI * radius
         * (2 * radius + cylinderHeight);
   }
    /**
      * Calculate volume of cylinder.
      * @return volume Command line arguments (not used).
      */
   public double volume()
   {
      return Math.PI * Math.pow(radius, 2) 
         * (cylinderHeight + (4 * radius) / 3);
   }
  //method to verify if two objects are equal.
  
   /**
     *@return obj boolean to see if equal.
     *@param obj object.
     */
   public boolean equals(Object obj) {
      if (!(obj instanceof Spherocylinder)) {
         return false;
      } else {
         Spherocylinder d = (Spherocylinder) obj;
         return (label.equalsIgnoreCase(d.getLabel())
                    && Math.abs(radius - d.getRadius()) < .000001
                    && Math.abs(cylinderHeight 
                    - d.getCylinderHeight()) < .000001);
      }
   }

    //method for checkstyle.
   /**
     *@return 0 for checkstyle.
     */
   public int hashCode() {
      return 0;
   }

    //campareTo implementation for the Comparable interface.
   /**
     *@param obj for Spherocylinder obj.
     *@return int for comparing.
     *compare two objects.
     */
//    public int compareTo(Spherocylinder obj) {
// 
//       if (this.volume() > obj.volume()) {
//          return 1;
//       }
//       else if (this.volume() < obj.volume()) {
//          return -1;
//       }
//       else {
//          return 0;
//       }

//   }
   public int compareTo(Spherocylinder obj) {
      if (Math.abs(this.volume() - obj.volume()) < 0.000001) {
         return 0; // consider them equal and return 0
      }
      else if (this.volume() < obj.volume()) {
         return -1; // should return a neg number
      }
      else {
         return 1; // should return a pos number
      }
   }
    /**
      * return string.
      * print out value in certain decimal point.
      * @return string Command line arguments (not used).
      */
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("#,##0.0##");
      String output = "Spherocylinder " + "\"" + label
                     + "\"" + " with radius " + radius
                     + " and cylinder height " + cylinderHeight
                     + " has:"
                     + "\n\tcircumference = " + df1.format(circumference())
                     + " units" 
                     + "\n\tsurface area = " + df1.format(surfaceArea())
                     + " square units"
                     + "\n\tvolume = " + df1.format(volume())
                     + " cubic units"; 
      return output;
   }   

}
