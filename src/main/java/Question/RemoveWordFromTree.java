package Question;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class RemoveWordFromTree extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
  }

  /*
  [['bacon', 'lettuce', 'tomato'], ['lettuce', 'bacon']], 'lettuce'
->
[['bacon', 'tomato'], ['bacon']]


List<List<String>>  filterWord( List<List<String>> input, String target){

    List<List<String>>  output = new ArrayList<list<String>>();

    for(List<String>  listString : input){
        List<String> listStringNew = new ArrayList<String>();
        for(String str : listString){
            if (!str.equals(target)){
                listStringNew.add(str);
                }

        }
        output.add(listString);
    }
    return output;
}

[['bacon', 'lettuce', 'tomato'], [['bacon'], 'tomato', 'lettuce'], ['lettuce', 'bacon']], 'lettuce'

class TreeNode {
public List<TreeNode> children;
public String val;  //  children and val can only have and exactly one to be null
}

//

TreeNode filterWord(TreeNode input, String target){
// We need to find the node which has the targetvalue and record the path to the word.
// Then we can remove the node that only has one childen along the path.

// For recursive

}

class Result
{
  List<TreeNode> listPath // 2 deep
}
Result findWord( TreeNode node, target)
{


}

{
//iterate through.
// Call this function to find the path to the taget.
}


  */

}
