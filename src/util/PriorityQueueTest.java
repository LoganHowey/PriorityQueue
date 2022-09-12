package util;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    @Test
    public void sizeOfEmptyHeapIsZero(){
        PriorityQueue aPriorityQueue = new PriorityQueue(10);
        Assert.assertThat(aPriorityQueue.size(), Is.is(0));
    }

    @Test
    public void canAddToHeap(){
        PriorityQueue aPriorityQueue = new PriorityQueue(6);
        aPriorityQueue.add(10);
        aPriorityQueue.add(5);
        aPriorityQueue.add(108);
        aPriorityQueue.add(54);
        aPriorityQueue.add(9);
        aPriorityQueue.add(100);
        aPriorityQueue.print();
        assertThat(aPriorityQueue.size(), Is.is(6));
    }

    @Test
    public void canFindMin(){
        PriorityQueue aPriorityQueue = new PriorityQueue(6);
        aPriorityQueue.add(10);
        aPriorityQueue.add(5);
        aPriorityQueue.add(108);
        aPriorityQueue.add(54);
        aPriorityQueue.add(9);
        aPriorityQueue.add(100);
        Assert.assertThat(aPriorityQueue.takeMin(), Is.is(5));
    }
}