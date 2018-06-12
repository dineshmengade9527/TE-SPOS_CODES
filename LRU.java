package algo;

import java.util.*;

public class LRU {

	public static void main(String args[]) {

		int pages[] = new int[50];
		int capacity, n;

		System.out.println("Enter no of Strings.");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		System.out.println("Enter Strings");

		for (int i = 0; i < n; i++) {
			pages[i] = sc.nextInt();
		}

		System.out.println("Enter capacity");
		capacity = sc.nextInt();

		System.out.println("No. of Page Faults = " + pageFaults(pages, n, capacity));
	}

	static int pageFaults(int pages[], int n, int capacity) {

		int pagefaults = 0;

		ArrayList<Integer> frame=new ArrayList<>(capacity);
		ArrayList<Integer> queue=new ArrayList<>(capacity);
		
		for (int i = 0; i < n; i++) {

			if (frame.size() < capacity) {

				if (!frame.contains(pages[i])) {

					pagefaults++;
					frame.add(pages[i]);
					queue.add(pages[i]);
					for (int j = 0; j < frame.size(); j++) {

						System.out.print(frame.get(j) + " ");

					}
					System.out.println();
				}else{
					
					int ind=queue.indexOf(pages[i]);
					queue.remove(ind);
					queue.add(pages[i]);
				}
			}else{
				
				if(!frame.contains(pages[i])){
					pagefaults++;
					int ele=queue.get(0);
					int ind=frame.indexOf(ele);
					//System.out.println("a "+ele+" a "+ind+" a");
					frame.set(ind, pages[i]);
					queue.remove(0);
					queue.add(pages[i]);
					
					
					
					for (int j = 0; j < frame.size(); j++) {

						System.out.print(frame.get(j) + " ");

					}
					System.out.println();
				}
				else{
					int ind=queue.indexOf(pages[i]);
					queue.remove(ind);
					queue.add(pages[i]);
				}
			}
		}
		
		return pagefaults;
	}

}
