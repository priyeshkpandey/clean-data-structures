package clean.project.ds.queue.application;

import clean.project.ds.queue.contract.MonitoredLimitedQueue;
import clean.project.ds.queue.factory.QueueFactoryBuilder;

import java.util.Arrays;

/**
 * Mathematical background of the algorithm.
 * Following are true for all multiples of 3
 * 1. A number is multiple of 3 if and only if the sum of digits of number is multiple of 3.
 * 2. If a number is multiple of 3, then all permutations of it are also multiple of 3.
 * 3. We get the same remainder when we divide the number and sum of digits of the number by 3.
 */
public class FindLargestMultipleOfThree {

    private static final QueueFactoryBuilder<Integer> intQueueFactoryBuilder = new QueueFactoryBuilder<Integer>();

    public boolean findLargestMultipleOfThreeFromDigits(int [] digits) throws Exception {
        Arrays.sort(digits);
        final MonitoredLimitedQueue<Integer> remainderZeroQueue = intQueueFactoryBuilder.getStraightMonitoredLimitedQueueFactory().getQueue(100);
        final MonitoredLimitedQueue<Integer> remainderOneQueue = intQueueFactoryBuilder.getStraightMonitoredLimitedQueueFactory().getQueue(100);
        final MonitoredLimitedQueue<Integer> remainderTwoQueue = intQueueFactoryBuilder.getStraightMonitoredLimitedQueueFactory().getQueue(100);
        int sumOfDigits = sumDigitsAndDistributeIntoRemainderQueues(digits, remainderZeroQueue, remainderOneQueue, remainderTwoQueue);
        if ((sumOfDigits % 3) == 1) {
            if (!remainderOneQueue.isEmpty()) {
                remainderOneQueue.remove();
            } else {
                for (int numOfTimes = 0; numOfTimes < 2; numOfTimes++) {
                    if (!remainderTwoQueue.isEmpty()) {
                        remainderTwoQueue.remove();
                    } else {
                        return false;
                    }
                }
            }
        } else if ((sumOfDigits % 3) == 2) {
            if (!remainderTwoQueue.isEmpty()) {
                remainderTwoQueue.remove();
            } else {
                for (int numOfTimes = 0; numOfTimes < 2; numOfTimes++) {
                    if (!remainderOneQueue.isEmpty()) {
                        remainderOneQueue.remove();
                    } else {
                        return false;
                    }
                }
            }
        }
        int [] aux = new int[digits.length];
        int lastIndex = sumAllQueuesInArrayAndGetLastIndex(aux, remainderZeroQueue, remainderOneQueue, remainderTwoQueue);
        Arrays.sort(aux, 0, lastIndex);
        System.out.println("Largest Multiple of 3 from the given digits: ");
        for (int index = lastIndex -1; index >= 0; index--) {
            System.out.print(aux[index] + " ");
        }
        return true;
    }

    private int sumDigitsAndDistributeIntoRemainderQueues(int [] sortedDigitsArray,
                                                           MonitoredLimitedQueue<Integer> remainderZeroQueue,
                                                           MonitoredLimitedQueue<Integer> remainderOneQueue,
                                                           MonitoredLimitedQueue<Integer> remainderTwoQueue) throws Exception {
        int sumOfDigits=0;
        for (int i = 0; i < sortedDigitsArray.length; ++i) {
            sumOfDigits += sortedDigitsArray[i];
            if ((sortedDigitsArray[i] % 3) == 0) {
                remainderZeroQueue.insert(sortedDigitsArray[i]);
            } else if ((sortedDigitsArray[i] % 3) == 1) {
                remainderOneQueue.insert(sortedDigitsArray[i]);
            } else {
                remainderTwoQueue.insert(sortedDigitsArray[i]);
            }
        }
        return sumOfDigits;
    }

    private int sumAllQueuesInArrayAndGetLastIndex(int [] aux,
                                                  MonitoredLimitedQueue<Integer> remainderZeroQueue,
                                                  MonitoredLimitedQueue<Integer> remainderOneQueue,
                                                  MonitoredLimitedQueue<Integer> remainderTwoQueue) throws Exception {
        int lastIndex = 0;
        while (!remainderZeroQueue.isEmpty()) {
            aux[lastIndex++] = remainderZeroQueue.remove();
        }
        while (!remainderOneQueue.isEmpty()) {
            aux[lastIndex++] = remainderOneQueue.remove();
        }
        while (!remainderTwoQueue.isEmpty()) {
            aux[lastIndex++] = remainderTwoQueue.remove();
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int [] digits = {8, 1, 7, 6, 0};
        final FindLargestMultipleOfThree findLargestMultipleOfThree = new FindLargestMultipleOfThree();
        try {
            if (!findLargestMultipleOfThree.findLargestMultipleOfThreeFromDigits(digits)) {
                System.out.println("Multiple of 3 not possible");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
