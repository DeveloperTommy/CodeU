import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class RotatedList {

    public static boolean isRotation(List<Integer> list1, List<Integer> list2) {         
    	
	if (list1.size() != list2.size()) {
	    return false;
	}
	
	String first = "";
    	String second = "";
	
	for (int i = 0; i < list1.size(); i++) {
    		first += (list1.get(i).toString());
    	}
	
	for (int i = 0; i < list2.size(); i++) {
		second += (list2.get(i).toString());
	}
	
	first = first + first; //If one string is a rotation of the other, then it will exist in this permutation
	
	return first.contains(second);    	
    }

    public static class Test_IsRotation { 
    	
        private static int failCount;
        private static int successCount;

        public static void init() {
            failCount = 0;
            successCount = 0;
        }

        public static void expectFailure(List<Integer> a, List<Integer> b) {
            
            boolean test = isRotation(a, b);
            
            if (test) {
        	report (a, b, test);
        	failCount++;
            }
            else {
        	successCount++;
            }
        	
        }

        public static void expectSuccess(List<Integer> a, List<Integer> b) {        
            
            boolean test = isRotation(a, b);
            
            if (!test) {
        	report (a, b, test);        
        	failCount++;
            }
            else {
        	successCount++;
            }        	
            
        }

        private static void report(List<Integer> a, List<Integer> b, boolean got) {   
            
           System.out.println("Result was: " + got + ", when result should have been: " + !got 
        	   	       + ", for lists a: " + a + " and b: " + b);
            
        }

        public static void reportSummary() {
            if (successCount == 0) {
                System.out.println("Summary: all " + failCount +
                                   " tests FAILED!");
            } else if (failCount == 0) {
                System.out.println("Summary: all " + successCount +
                                   " tests SUCCEEDED!");
            } else {
                System.out.println("Summary: " + successCount +
                                   " tests succeeded, " + failCount +
                                   " tests failed.");
            }
        }
    }

    public static void main(String[] args) {

        Test_IsRotation.init();

        List<Integer> list1, list2;
        list1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4));
        list2 = new LinkedList<Integer>(Arrays.asList(3,4,1,2));
        Test_IsRotation.expectSuccess(list1,list2);
        list1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4));
        list2 = new LinkedList<Integer>(Arrays.asList(3,4,2,1));
        Test_IsRotation.expectFailure(list1,list2);

        // STUDENT: ADD TEST CASES HERE

        // Check performance                                                                              
        int N = 10000;
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        for (int i = 0; i < N; ++i) {
            a1[i] = 0;
            a2[i] = 0;
        }
        // (STUDENT: WHY THIS CASE?)
        a1[0] = 1;
        a2[N/2] = 1;
        list1 = new LinkedList<Integer>(Arrays.asList(a1));
        list2 = new LinkedList<Integer>(Arrays.asList(a2));
        long start_time, end_time;
        start_time = System.nanoTime();
        Test_IsRotation.expectSuccess(list1, list2);
        end_time = System.nanoTime();
        System.out.println("10000 elements: " +
                           (end_time - start_time) + " nsec");

        /********** STUDENT RUN TESTS ***********/
        list1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
        list2 = new LinkedList<Integer>(Arrays.asList(3,4,1,2));
        Test_IsRotation.expectFailure(list1,list2);
        
        list1 = new LinkedList<Integer>(Arrays.asList(1));
        list2 = new LinkedList<Integer>(Arrays.asList(3,4,1,2));
        Test_IsRotation.expectFailure(list1,list2);
        
        
        list1 = new LinkedList<Integer>(Arrays.asList(3,3,3,5,6));
        list2 = new LinkedList<Integer>(Arrays.asList(3,3,3));
        Test_IsRotation.expectFailure(list1,list2);
        
        list1 = new LinkedList<Integer>(Arrays.asList(1,1,1,1));
        list2 = new LinkedList<Integer>(Arrays.asList(1,1,1,1));
        Test_IsRotation.expectSuccess(list1,list2);
        
        list1 = new LinkedList<Integer>(Arrays.asList(9,4,94,94));
        list2 = new LinkedList<Integer>(Arrays.asList(94,9,4,94));
        Test_IsRotation.expectSuccess(list1,list2);
        
        list1 = new LinkedList<Integer>(Arrays.asList(101, 10001, 10000001));
        list2 = new LinkedList<Integer>(Arrays.asList(101, 10001, 3));
        Test_IsRotation.expectFailure(list1,list2);
        
        list1 = new LinkedList<Integer>(Arrays.asList(2, 2));
        list2 = new LinkedList<Integer>(Arrays.asList(2, 2));
        Test_IsRotation.expectSuccess(list1,list2);
        
        list1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        list2 = new LinkedList<Integer>(Arrays.asList(10,2,3,4,5,6,7,8,10));
        Test_IsRotation.expectFailure(list1,list2);

        Test_IsRotation.reportSummary();
    }
}
