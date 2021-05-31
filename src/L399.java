import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L399 {
    //main idea: disjoint set union
    Map<String, Double> value = new HashMap<>();
    Map<String, String> parent = new HashMap<>();
    //union by size
    Map<String, Integer> size = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        for (int i=0; i<equations.size(); i++) {
            String a = equations.get(i).get(0), b=equations.get(i).get(1);
            makeSet(a); makeSet(b);
            union(a, b, values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = query(queries.get(i).get(0), queries.get(i).get(1));
        }
        return ans;
    }


    double query(String a, String b) {
        // || !parent.get(a).equals(parent.get(b))
        if (!parent.containsKey(a) || !parent.containsKey(b)) {
            return -1;
        }
        if (!findSet(a).equals(findSet(b))) { return -1; }
        return value.get(a)/value.get(b);
    }

    void union(String a, String b, double val) {
        String pa = findSet(a), pb=findSet(b);
        if (pa.equals(pb)) { return; }

        double newVal=value.get(b)/value.get(a)*val;
        if (size.get(pa) > size.get(pb)) {
            String tmp=pa; pa=pb; pb=tmp;
            newVal = 1/newVal;
        }
        parent.put(pa, pb);
        value.put(pa, newVal);
        size.put(pb, size.get(pa)+size.get(pb));
    }

    String findSet(String s) {
        if (parent.get(s).equals(s)) { return s; }

        String p = parent.get(s);
        parent.put(s, findSet(p));
        value.put(s, value.get(s)*value.get(p));
        return parent.get(s);
    }

    void makeSet(String s) {
        if (parent.containsKey(s)) { return; }
        parent.put(s, s);
        value.put(s, 1.0);
        size.put(s, 1);
    }
}
