import java.util.List;

//main idea: use manacher's algorithm ,get all odd palindromes & even
// palindromes.
// then the problem is to get minimum palindroms as possible
// so if there are overlap, how can we handle this situation?
// for example: "aaabbaa" -> 'aaa' + 'bb' + 'aa'
// or        'a' + 'aabbaa'
// it means we cann't apply greedy algorithm.
// overlap range(0, 2) (1, 6), its like a jump game
// if there is a case, we will have three overlaps:
// aaabbaaaa
public class L131 {
    public List<List<String>> partition(String s) {
        return null;
    }
}
