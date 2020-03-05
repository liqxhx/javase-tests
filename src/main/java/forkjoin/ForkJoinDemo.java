package forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.LongAdder;

public class ForkJoinDemo {
    /**
    * ForkJoinDemo 实例
    */
    public static void main(String[] args){
        System.out.println("并行数："+ ForkJoinPool.commonPool().getParallelism());

        System.out.println("CPU处理器数："+Runtime.getRuntime().availableProcessors());

        LongAdder adder = new LongAdder();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // RecursiveAction 递归操作
        AddTask addTask = new AddTask(nums, adder);

        forkJoinPool.invoke(addTask);

        forkJoinPool.shutdown();

        System.out.println(adder.intValue());

    }

    static class AddTask extends RecursiveAction {

        final List<Integer> nums;
        final LongAdder adder;

        AddTask(List<Integer> nums,  LongAdder adder) {
            this.nums = nums;
            this.adder = adder;
        }

        @Override
        protected void compute() {
            int size = nums.size();

            if(size > 1) {

                int pos = size / 2;

                List<Integer> left = nums.subList(0, pos); // [0, pos)
                List<Integer> right = nums.subList(pos, size);

                AddTask leftAddTask = new AddTask(left, adder);
                AddTask rightAddTask = new AddTask(right, adder);

                invokeAll(leftAddTask, rightAddTask);

            } else {
                adder.add(nums.get(0).intValue());
            }

        }
    }

}
