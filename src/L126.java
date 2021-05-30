import java.util.List;

// main idea:
//  if we want to get minimum distance, we should use BFS
//  we can see it as a graph. The neighbor will contains only one
//  different character in the same position.
// So the problem is equal to how to get the neighbor list efficiently.
//
// method one: brute force method( the length of each word is k, n is the #
//  of vertex, i.e. the word #):
// then getting the neighbor list takes O(n^2*k)
// and do BFS will take O(E), E is the the # of edge
// so in total it will take O(k*v*v+E)

// method two: for each word, for each position, we try to replace it with
// another character, then check if the new word is a neighbor, if so,
// we will get a new neighbor. Note that after we processing a word, we will
// delete it from the set and get a new set.
// To speed lookup, we will use set.
// then it will take O(n*26), because for each word, we will try to find its
// neighbor.

// So basically, for method two, the idea is finding next set of current set
// until the next contains the target word. Then we will get the answer.
// If the # of words, i.e the # of vertexes, is n, in the worst case, the times
// of finding neighbor is 26, so the total time is O(26n).
public class L126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }
}
