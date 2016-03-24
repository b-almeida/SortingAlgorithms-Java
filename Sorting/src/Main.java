import java.util.*;

public class Main {
	
	private static ArrayList<Integer> bubbleSort(ArrayList<Integer> numbers) {
		ArrayList<Integer> sortedNumbers = new ArrayList<Integer>(numbers);
		boolean makePass = true;
		
		int start = 0;
		int end = sortedNumbers.size();
		
		while (makePass) {
			makePass = false;
			
			for (int i = start; i < end - 1; i++) {
				if (sortedNumbers.get(i) > sortedNumbers.get(i + 1)) {
					int firstNumber = sortedNumbers.get(i);
					
					sortedNumbers.set(i, sortedNumbers.get(i + 1));
					sortedNumbers.set(i + 1, firstNumber);
					
					makePass = true;
				}
			}
			
			if (makePass && end > 1) {
				end--;
			}
		}
		
		return sortedNumbers;
	}
	
	
	private static ArrayList<Integer> insertionSort(ArrayList<Integer> numbers) {
		ArrayList<Integer> sortedNumbers = new ArrayList<Integer>(numbers.size());
		
		sortedNumbers.add(numbers.get(0));
		
		for (int i = 1; i < numbers.size(); i++) {
			int number = numbers.get(i);
			
			sortedNumbers.add(-1);
			
			int iInsert;
			
			for (iInsert = sortedNumbers.size() - 1;
				iInsert > 0 && number < sortedNumbers.get(iInsert - 1);
				iInsert--)
			{
				sortedNumbers.set(iInsert, sortedNumbers.get(iInsert - 1));
			}
			
			sortedNumbers.set(iInsert, number);
		}
		
		return sortedNumbers;
	}
	
	
	private static ArrayList<Integer> selectionSort(ArrayList<Integer> numbers) {
		ArrayList<Integer> numbersCopy = new ArrayList<Integer>(numbers);
		ArrayList<Integer> sortedNumbers = new ArrayList<Integer>(numbers.size());
		
		while (numbersCopy.size() > 0) {
			int smallestIndex = 0;
			int smallestNumber = 999999;
			
			for (int i = 0; i < numbersCopy.size(); i++) {
				if (numbersCopy.get(i) < smallestNumber) {
					smallestIndex = i;
					smallestNumber = numbersCopy.get(i);
				}
			}
			
			sortedNumbers.add(smallestNumber);
			numbersCopy.remove(smallestIndex);
		}
		
		return sortedNumbers;
	}
	
	
	private static ArrayList<Integer> mergeSort(ArrayList<Integer> numbers) {
		if (numbers.size() <= 1) {
			return numbers;
		} else {
			ArrayList<Integer> sortedNumbers = new ArrayList<Integer>(numbers);
			
			int halfLength = sortedNumbers.size() / 2;
			ArrayList<Integer> leftHalf = mergeSort(new ArrayList<Integer>(sortedNumbers.subList(0, halfLength)));
			ArrayList<Integer> rightHalf = mergeSort(new ArrayList<Integer>(sortedNumbers.subList(halfLength, sortedNumbers.size())));
			sortedNumbers.clear();
			
			int iLeft = 0;
			int iRight = 0;
			
			while (iLeft < leftHalf.size() && iRight < rightHalf.size()) {
				if (leftHalf.get(iLeft) < rightHalf.get(iRight)) {
					sortedNumbers.add(leftHalf.get(iLeft));
					iLeft++;
				} else {
					sortedNumbers.add(rightHalf.get(iRight));
					iRight++;
				}
			}
			
			while (iLeft < leftHalf.size()) {
				sortedNumbers.add(leftHalf.get(iLeft));
				iLeft++;
			}
			
			while (iRight < rightHalf.size()) {
				sortedNumbers.add(rightHalf.get(iRight));
				iRight++;
			}
			
			return sortedNumbers;
		}
			
	}
	
	
	private static ArrayList<Integer> exchangeSort(ArrayList<Integer> numbers) {
		ArrayList<Integer> sortedNumbers = new ArrayList<Integer>(numbers);
		
		int start = 0;
		int end = sortedNumbers.size();
		
		for (; end - start > 1; start++) {
			for (int i = start + 1; i < sortedNumbers.size(); i++) {
				if (sortedNumbers.get(start) > sortedNumbers.get(i)) {
					int firstNumber = sortedNumbers.get(start);
					
					sortedNumbers.set(start, sortedNumbers.get(i));
					sortedNumbers.set(i, firstNumber);
				}
			}
		}
		
		return sortedNumbers;
	}
	
	
	private static ArrayList<Integer> combSort(ArrayList<Integer> numbers) {
		ArrayList<Integer> sortedNumbers = new ArrayList<Integer>(numbers);
				
		for (int gap = (int) (sortedNumbers.size() / 1.3); gap > 1; gap /= 1.3) {			
			for (int i1 = 0; i1 < sortedNumbers.size() - gap; i1++) {
				int i2 = i1 + gap;
				
				if (sortedNumbers.get(i1) > sortedNumbers.get(i2)) {
					int firstNumber = sortedNumbers.get(i1);
					
					sortedNumbers.set(i1, sortedNumbers.get(i2));
					sortedNumbers.set(i2, firstNumber);
				}
			}
		}
		
		return bubbleSort(sortedNumbers);
	}
	
	
	
	
	private static ArrayList<Integer> subArrayList(ArrayList<Integer> list, int start, int end) {
		ArrayList<Integer> subList = new ArrayList<>(end - start);
		
		for (int i = start; i < end; i++) {
			subList.add(list.get(i));
		}
		
		return subList;
	}
	
	private static ArrayList<Integer> randomNumbers(int length) {
		Random random = new Random(0);
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(length);
		
		for (int i = 0; i < length; i++) {
			numbers.add(random.nextInt(length) + 1);
		}
		
		return numbers;
	}
		
	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			HashMap<String, Double> times = new HashMap<String, Double>();
			// add an entry pair for (sort, time)
			// get all the keys into a list and sort them,
			// then loop through the hashmap each time to find any sorts with that time and display it
			
			ArrayList<Integer> numbers = randomNumbers(1000);
			
			long startTime, endTime;
			double time;
			
			
			
			
			System.out.println("Unsorted");
			System.out.println(numbers);
			System.out.println();
			System.out.println();
			
			startTime = System.nanoTime();
			System.out.println("Bubble Sort");
			System.out.println(bubbleSort(numbers));
			endTime = System.nanoTime();
			time = (endTime - startTime) / 10e9;
			times.put("Bubble Sort", time);
			System.out.println(time + " s");
			System.out.println();
			
			
			startTime = System.nanoTime();
			System.out.println("Insertion Sort");
			System.out.println(insertionSort(numbers));
			endTime = System.nanoTime();
			time = (endTime - startTime) / 10e9;
			times.put("Insertion Sort", time);
			System.out.println(time + " s");
			System.out.println();
			
			
			startTime = System.nanoTime();
			System.out.println("Selection Sort");
			System.out.println(selectionSort(numbers));
			endTime = System.nanoTime();
			time = (endTime - startTime) / 10e9;
			times.put("Selection Sort", time);
			System.out.println(time + " s");
			System.out.println();
			
			
			startTime = System.nanoTime();
			System.out.println("Merge Sort");
			System.out.println(mergeSort(numbers));
			endTime = System.nanoTime();
			time = (endTime - startTime) / 10e9;
			times.put("Merge Sort", time);
			System.out.println(time + " s");
			System.out.println();
			
			
			startTime = System.nanoTime();
			System.out.println("Exchange Sort");
			System.out.println(exchangeSort(numbers));
			endTime = System.nanoTime();
			time = (endTime - startTime) / 10e9;
			times.put("Exchange Sort", time);
			System.out.println(time + " s");
			System.out.println();
			
			
			startTime = System.nanoTime();
			System.out.println("Comb Sort");
			System.out.println(combSort(numbers));
			endTime = System.nanoTime();
			time = (endTime - startTime) / 10e9;
			times.put("Comb Sort", time);
			System.out.println(time + " s");
			System.out.println();
		}
	}

}
