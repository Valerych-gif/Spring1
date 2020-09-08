import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMaker {

    private static Integer[][] flatList = new Integer[][]{
            {1, null},
            {2, null},
            {3, 1},
            {4, 3},
            {5, null},
            {6, 3},
            {7, 2},
            {8, 5}
    };

    static class Tree{
        Map<Integer, Integer> treeMap = new TreeMap<>();
        private Integer[][] flatList;

        public Tree(Integer[][] flatList) {
            this.flatList = flatList;
            for (int i = 0; i < flatList.length; i++) {
                treeMap.put(flatList[i][0], flatList[i][1]);
            }
        }

        public Integer getParent(Integer node){
            return treeMap.get(node);
        }

        public List<Integer> getChildren(Integer node){
            List<Integer> children = new ArrayList<>();
            treeMap.forEach((k,v)->{
                if (v!=null&&v.equals(node)){
                    children.add(k);
                }
            });
            return children;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(flatList);
        System.out.println(tree.getParent(6));
        System.out.println(tree.getChildren(3));
    }
}
