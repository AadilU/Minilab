
/**
 * Write a description of class isort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert};
    ListType listType = ListType.Standard;
    
    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private int[] ilist; int icompares = 0; int iswaps = 0;
    private int[] selectionList;

    /**
     * Constructor for objects of class isort
     */
    public Sorts()
    {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++)
            list[i] = (int)(Math.random() * size) + 1;
            
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        selectionList = list.clone();
        this.SelectionSort();
    }
    
    public String toString() {
        int[] list;
        
        switch(listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- "
                  + " Operations: " + (this.bcompares + this.bswaps)
                  + " Compares: " + this.bcompares
                  + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Insert:
            default:
                System.out.println("Insertions Sort -- "
                  + " Operations: " + (this.icompares + this.iswaps)
                  + " Compares: " + this.icompares
                  + " Swaps: " + this.iswaps);
                list = this.ilist;
        }
                
        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }
    
    private int[] BubbleSort() { 
        
        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {
            
            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {
                
                // analytics
                this.bcompares++; // compare counter
                
                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;
               
                    // analytics
                    this.bswaps++; // swap counter
                }
            
            }
            
        }
        return blist;
    }

    
    private int[] InsertionSort() {

        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {
            
            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;
                
                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;
            
            this.iswaps++;  // increment swap counter
            
        }
        
        return ilist;
    }
    
    /**
     * @return
     */
    
    //SelectionSort
    private int[] SelectionSort()
    {
    	int minNum;
    	for(int i = 0; i < selectionList.length - 1; i++)
    	{
    		int t = i;
    		for(int j = i + 1;j < selectionList.length;j++)
    		{
    			if(selectionList[j] < selectionList[t])
    			{
    				t = j;
    			}
    		}
    		minNum = selectionList[t];
    		selectionList[t] = selectionList[i];
    		selectionList[i] = minNum;
    	}
    	return selectionList;
    }
    
    /*Of the three sorts, the best way to compare efficiency would be comparing the best
     * and worst case scenarios of each sorting algorithm. For bubble sort, the worst case
     * is n^2 iterations where n is the length of the array. This is because the inside loop might
     * have to run all the way through everytime the outside loop goes through an iteration.
     * For insertion sort, the worst case is also n^2 and the best case is also n. Selection sort 
     * has n^2 as the worst case and n^2 as the best case because the inner loop and outer
     * loop will always run all the way through regardless of order. This means the selection
     * sort is not the most efficient way to sort an array. With insertion sort and bubble sort left
     * we can compare the method each loop uses to sort the array. With bubble sort, the inner
     * for loop doesn't allow the iterations to be stopped and will always run all the way through
     * while in insertion sort, the while loop allows it to stop whenever an integer in an element
     * is less than the integer in the element before it. Insertion sort is the most efficient
     * of the sorts in this class.
     * */

    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);
        
        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);
        
        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
    }
}
