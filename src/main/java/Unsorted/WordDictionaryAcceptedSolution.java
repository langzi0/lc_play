package Unsorted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
import Common.Util;

/**
 * @author
 * @since 10/28/15 This is the template for adding any new class
 */

public class WordDictionaryAcceptedSolution extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160123, 0, Category.LeetCode);
  }

  private TrieNode root;

  @Override
  public void run() {
    //Call your test in Common/Main.java
    this.root = new TrieNode();

    addWord("a");

    Util.assertEq(true,

                  search(".")

    );

    root = new TrieNode();
    addWord("bad");
    addWord("dad");
    addWord("mad");
    addWord("mada");
    Util.assertEq(false,
                  search("pad")
    );
    Util.assertEq(true,
                  search("bad")
    );
    Util.assertEq(true,
                  search("b.d")
    );
    Util.assertEq(true,
                  search("ba.")
    );
    Util.assertEq(true,
                  search("b..")
    );
    Util.assertEq(true,
                  search("...")
    );
    Util.assertEq(true,
                  search(".ad")
    );
    Util.assertEq(true,
                  search(".a.")
    );
    Util.assertEq(true,
                  search("..d")
    );
    Util.assertEq(true,
                  search("..da")
    );
    Util.assertEq(true,
                  search("..da")
    );
    Util.assertEq(false,
                  search("..db")
    );
  }


  // Adds a word into the data structure.
  public void addWord(String word) {
    TrieNode currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      currentNode = currentNode.addLetter(word.charAt(i));
    }
    currentNode.setIsWord();
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return search(word, 0, root);
  }

  private boolean search(String word, int index, TrieNode node) {
    if (index == word.length()) {
      return node.isWord();
    }
    if ('.' == word.charAt(index)) {
      for (TrieNode child : node.getAllChildren()) {
        if (search(word, index + 1, child)) {
          return true;
        }
      }
    } else {
      TrieNode child = node.getChild(word.charAt(index));
      if (child != null) {
        return search(word, index + 1, child);
      }
    }
    return false;
  }

  class TrieNode {

    // Initialize your data structure here.
    private Map<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
      this.children = new HashMap<>();
    }

    TrieNode addLetter(Character letter) {
      if (!children.containsKey(letter)) {
        children.put(letter, new TrieNode());
      }
      return children.get(letter);
    }

    TrieNode getChild(Character letter) {
      return children.get(letter);
    }

    void setIsWord() {
      isWord = true;
    }

    boolean isWord() {
      return isWord;
    }

    List<TrieNode> getAllChildren() {
      return new ArrayList<TrieNode>(children.values());
    }
  }

}

