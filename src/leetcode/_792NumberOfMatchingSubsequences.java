package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _792NumberOfMatchingSubsequences {
    /*
    Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

    Example :
    Input:
    S = "abcde"
    words = ["a", "bb", "acd", "ace"]
    Output: 3
    Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
    Note:

    All words in words and S will only consists of lowercase letters.
    The length of S will be in the range of [1, 50000].
    The length of words will be in the range of [1, 5000].
    The length of words[i] will be in the range of [1, 50].
     */

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, S, 0, 0)) count++;
        }
        return count;
    }

    private boolean isSubsequence(String word, String s, int wordStart, int sStart) {
        if (wordStart == word.length()) {
            return true;
        }
        if (sStart == s.length()) {
            return false;
        }
        if (word.charAt(wordStart) == s.charAt(sStart)) {
            return isSubsequence(word, s, wordStart + 1, sStart);
        } else {
            return isSubsequence(word, s, wordStart, sStart + 1);
        }
    }
}
