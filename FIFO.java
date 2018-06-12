package algo;

import java.util.*;

class FIFO {
    static int pageFaults(int pages[], int n, int capacity) {

        Queue<Integer> indexes = new LinkedList<>();
        ArrayList<Integer> f=new ArrayList<>();
        System.out.println("n = "+n);
        int page_faults = 0;
        for (int i = 0; i < n; i++) {

            if (f.size() < capacity) {

                if (!f.contains(pages[i])) {
                   
                    page_faults++;
                    indexes.add(pages[i]);
                    f.add(pages[i]);
                    for (int j = 0; j < f.size(); j++) {
                       
                        System.out.print(f.get(j) + " ");
                       
                    }
                    System.out.println();
                }
            }

            else {

                if (!f.contains(pages[i])) {

                    int val = indexes.peek();
                    indexes.poll();
                   
                    indexes.add(pages[i]);
                    int in=f.indexOf(val);
                    f.set(in, pages[i]);
                   
                    for (int j = 0; j < f.size(); j++) {
                       
                        System.out.print(f.get(j) + " ");
                       
                    }
                    System.out.println();
                    page_faults++;
                }
            }
        }

        return page_faults;
    }

    public static void main(String args[]) {
        int pages[] = new int[50];
        int capacity,n;
       
        System.out.println("Enter no of Strings.");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
       
        System.out.println("Enter Strings");
       
        for(int i=0;i<n;i++){
            pages[i]=sc.nextInt();
        }
       
        System.out.println("Enter capacity");
        capacity=sc.nextInt();
        
       
        System.out.println("No. of Page Faults = " + pageFaults(pages, n, capacity));
    }
}
