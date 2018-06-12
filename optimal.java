package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class optimal {

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

		ArrayList<Integer> frame = new ArrayList<>();
		ArrayList<Integer> index = new ArrayList<>();

		for (int i = 0; i < capacity; i++) {

			index.add(0);
		}

		for (int i = 0; i < n; i++) {

			if (frame.size() < capacity) {

				if (!frame.contains(pages[i])) {

					pagefaults++;
					frame.add(pages[i]);
					for (int j = 0; j < frame.size(); j++) {

						System.out.print(frame.get(j) + " ");

					}
					System.out.println();
				}
			} else {

				if (!frame.contains(pages[i])) {
					pagefaults++;
					for (int k = 0; k < capacity; k++) {
						int flag=0;
						for (int j = i + 1; j < n; j++) {
							
							if(frame.get(k)==pages[j]){
								index.set(k, j);
								flag=1;
							}
							
						}
						if(flag==0){
							index.set(k, 0);
						}
					}
					if(index.contains(0)){
						int ind=index.indexOf(0);
						frame.set(ind, pages[i]);
					}else{
						int max=index.get(0);
						for(int j=1;j<capacity;j++){
							
							if(max<index.get(j)){
								max=index.get(j);
							}
						}
						int ind=index.indexOf(max);
						frame.set(ind, pages[i]);
					}
					for (int j = 0; j < frame.size(); j++) {

						System.out.print(frame.get(j) + " ");

					}
					System.out.println();

				}

			}

		}

		return pagefaults;

	}

}
