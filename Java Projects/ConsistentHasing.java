import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

class Node {

    private Integer position;
    private ArrayList<Integer> requestRange;

    public Node(int position, int numServers, int numRequests) {
        
        this.position = position;
        int serves = numRequests/numServers;
        requestRange = new List<Integer>();
        requestRange.add(position-serves);
        requestRange.add(position+serves);
    }

}


public class ConsistentHashing {

    private final Map<Integer,Node> nodePositions;
    private final ConcurrentSkipListMap<Long, Node> nodeMappings;
    private final Function<String, Long> hashFunction;
    private final int pointMultiplier;

    public ConsistentHashing(final Function<String, Long> hashFunction, final int pointMultiplier) {

        if (pointMultiplier==0) {
            System.out.println("Can't divide by zero");
        }
        else {
            this.hashFunction = hashFunction;
            this.nodePositions = new ConcurrentHashMap<>();
            this.nodeMappings = new ConcurrentSkipListMap<>();
            this.pointMultiplier = pointMultiplier;
        }   

    }

    // If needed code link 
    https://github.com/coding-parrot/Low-Level-Design/blob/master/service-orchestrator/src/main/java/algorithms/ConsistentHashing.java#L6
    // #GKCS
}