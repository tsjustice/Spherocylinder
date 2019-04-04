import java.text.DecimalFormat;
/**
  *Project 3.
  *@author Shane Justice
  *@version 03/30/2019
  */
  
public class SpherocylinderList {

   private String listName = "";
   private Spherocylinder[] sList;
   private int num = 0;
   
    /**
      * set default value.
      * @param labelIn Command line arguments (not used).
      * @param radiusIn Command line arguments (not used).
      * @param cylinderHeightIn Command line arguments (not used).
      */   
   //constructor
   SpherocylinderList(String listNameIn, Spherocylinder[] sListIn, int numIn) {
      
      listName = listNameIn;
      sList = sListIn;
      num = numIn;
      
   }
   /**
    * Getter for listName.
    * @return listName
    */
   public String getName() {
      return listName;
   }
   
   /**
    * @return the number of Triangle objects in the tList.
    */
   public int numberOfSpherocylinders() {
      return  num;
   }
   /**
     *@return surfaceArea of all spherocylinders.
     */
   public double totalSurfaceArea() {
      double surfaceArea = 0;
      int i = 0;
      
      while (i < num) {
         surfaceArea += sList[i].surfaceArea();
         i++;
      }
      return surfaceArea;
   }
   /**
     *@return volume of all spherocylinders.
     *
     */
   public double totalVolume() {
      double volume = 0;
      int i = 0;
      
      while (i < num) {
         volume += sList[i].volume();
         i++;
      }
      return volume;
   }
   /**
     *@return averageS of all sphero.
     */
   public double averageSurfaceArea() {
      double surfaceArea = totalSurfaceArea();
      if (surfaceArea == 0) {
         return 0;
      }
      double averageS = surfaceArea / num; 
      return averageS;
     
   }
   /**
     *@return averageV of all sphero.
     */
   public double averageVolume() {
      double totalVolume = totalVolume();
      if (totalVolume == 0) {
         return 0;
      }
      double averageV = totalVolume / num;
      return averageV;
   }
   /**
     *@return output of results.
     */
   public String toString() {
      DecimalFormat form = new DecimalFormat("#,##0.0##");
      String output = "----- Summary for " + listName + " -----\n"
         + "Number of Spherocylinders: " + num + "\n"
         + "Total Surface Area: " + form.format(totalSurfaceArea())
         + "\nTotal Volume: " + form.format(totalVolume()) + "\n"
         + "Average Surface Area: " + form.format(averageSurfaceArea())
         + "\nAverage Volume: " + form.format(averageVolume());
      return output;
   }
   /**
     *@return sList of objects.
     */
   public Spherocylinder[] getList() {
      return sList;
   }
   /**
     *adds a spherocylinder object.
     *@param labelIn for sphero label.
     *@param radiusIn for radius.
     *@param heightIn for height.
     */
   public void addSpherocylinder(String labelIn, 
      double radiusIn, double heightIn) { 
        
      Spherocylinder s = new Spherocylinder(labelIn, radiusIn, heightIn);
      sList[num] = s;
      num++;
   }  
   /**
     *@return object.
     *@param labelIn for sphero label.
     */
   public Spherocylinder findSpherocylinder(String labelIn) {
      Spherocylinder object = new Spherocylinder("", 0, 0);
      boolean find = false;
      for (int i = 0; i < num; i++) {
         if (sList[i].getLabel().toUpperCase()
            .equals(labelIn.toUpperCase())) {
            object = sList[i];
            find = true;
         }
      }
      if (find) {
         return object;
      }
      return null;
   
   }
   /**
     *@return object.
     *@param labelIn for label.
     */
   public Spherocylinder deleteSpherocylinder(String labelIn) {
      Spherocylinder object = findSpherocylinder(labelIn);
      
      for (int i = 0; i < num; i++) {
         if (sList[i].getLabel().toUpperCase()
            .equals(labelIn.toUpperCase())) {
            object = sList[i];
            for (int j = i; j < num - 1; j++) {
               sList[j] = sList[j + 1];
            }
            sList[num - 1] = null; // overwrite duplicate
            num--;
            break;
         }
      }
      return object;
   }
   
   /**
   * edits spherocylinder in list.
   * @return true.
   * @param labelIn is label.
   * @param radiusIn is radius. 
   * @param cylHeightIn is height.
   */
   
   public boolean editSpherocylinder(String labelIn, 
      double radiusIn, double cylHeightIn) {
      boolean edit = false;
      for (int i = 0; i < num; i++) {
         if (sList[i].getLabel().toUpperCase()
            .equals(labelIn.toUpperCase())) {
            sList[i].setRadius(radiusIn);
            sList[i].setCylinderHeight(cylHeightIn);
            edit = true;
         }
      }
      
      return edit;
   } 
   /**
   * finds spherocylinder with largest volume in list.
   * @return large in list. 
   */

   public Spherocylinder findSpherocylinderWithLargestVolume() {
      if (num > 0) {
         Spherocylinder large = sList[0];
      
         for (int i = 0; i < num; i++) {
            if (sList[i].volume() > large.volume()) {
               large = sList[i];
               
            }
         }
         return large; 
      }
      else {
         return null;
      }
      
   }
  


}