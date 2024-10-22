package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedLoop {
    public List<int[]> indiciesList;
//    public NestedLoop(int[] loopCounts)
//    {
//        nestedLoops(loopCounts);
//    }
    public NestedLoop (int[] loopCounts) {
        indiciesList=new ArrayList<>();
        nestedLoopsHelper(loopCounts, 0, new int[loopCounts.length]);

    }

    private void nestedLoopsHelper(int[] loopCounts, int currentLevel, int[] indices) {
        if (currentLevel == loopCounts.length) {
            // Do something with the indices
//            indiciesList.forEach(array -> System.out.print(Arrays.toString(array)+",") );

            indiciesList.add(indices.clone());
            return;
        }

        for (int i = 0; i < loopCounts[currentLevel]; i++) {
            indices[currentLevel] = i;
            nestedLoopsHelper(loopCounts, currentLevel + 1, indices);
        }
    }
}
