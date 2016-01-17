package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CodePad.*;
import Lang.JavaCollectionEx;
import Lang.JavaLang;
import Lang.PeekingIteratorModule;
import Question.CQuestion1;
import Question.Combination;
import Question.*;
import Question.FBCoverStringMinSet;
import Question.FBQuestions;
import Question.GQuestion2;
import Question.PrintNumbers;
import Question.RandomWord;
import Question.RemoveWordFromTree;
import Question.Solution;
import languageTip.ReadWriteSample;
import languageTip.ReflectionSample;

/**
 * Created by @author xbian @since 8/6/15.
 */
public class Main {

  static List<InvokableBase> listPrograms = new ArrayList<>();

  static void addingAllNewClasses() {
    listPrograms = Arrays.asList(
        // Add new classes here
        new ReflectionSample(),
        new JavaLang(),
        // LeetCode example
        new AddBinary(),
        new AddTwoNumbers(),
        new Anagrams(),
        new BalancedBinaryTree(),
        new BestTimetoBuyandSellStock(),
        new BestTimetoBuyandSellStockII(),
        new BestTimetoBuyandSellStockIII(),
        new BinaryTreeInorderTraversal(),
        new BinaryTreeLevelOrderTraversalII(),
        new BinaryTreeMaximumPathSum(),
        new Candy(),
        new ClimbingStairs(),
        new Combinations(),
        new CombinationSum(),
        new ConstructBinaryTreefromInorderandPostorderTraversal(),
        new ContainerWithMostWater(),
        new ConvertSortedArraytoBinarySearchTree(),
        new ConvertSortedListtoBinarySearchTree(),
        new CopyListwithRandomPointer(),
        new CountandSay(),
        new DecodeWays(),
        new DistinctSubsequences(),
        new DivideTwoIntegers(),
        new EditDistance(),
        new FirstMissingPositive(),
        new FlattenBinaryTreetoLinkedList(),
        new FourSum(),
        new GenerateParentheses(),
        new GrayCode(),
        new ImplementStrStr(),
        new IntegertoRoman(),
        new InterleavingString(),
        new MergeIntervals(),
        new JumpGame(),
        new LargestRectangleinHistogram(),
        new LengthofLastWord(),
        new LetterCombinationsofaPhoneNumber(),
        new LinkedListCycle(),
        new LongestCommonPrefix(),
        new LongestConsecutiveSequence(),
        new LongestPalindromicSubstring(),
        new LongestSubstringWithoutRepeatingCharacters(),
        new LongestValidParentheses(),
        new MaximalRectangle(),
        new MergeIntervals(),
        new MergekSortedLists(),
        new MergeSortedArray(),
        new MergeTwoSortedLists(),
        new MinimumDepthofBinaryTree(),
        new MinimumPathSum(),
        new MinimumWindowSubstring(),
        new NextPermutation(),
        new PalindromeNumber(),
        new PalindromePartitioning(),
        new PalindromePartitioningII(),
        new PartitionList(),
        new PascalTriangle(),
        new PathSum(),
        new PathSumII(),
        new PermutationsII(),
        new PlusOne(),
        new PopulatingNextRightPointersinEachNode(),
        new PopulatingNextRightPointersinEachNodeII(),
        new PowXN(),
        new RecoverBinarySearchTree(),
        new RemoveDuplicatesfromSortedArray(),
        new RemoveDuplicatesfromSortedList(),
        new RemoveDuplicatesfromSortedListII(),
        new RemoveElement(),
        new RemoveNthNodeFromEndofList(),
        new ReorderList(),
        new RestoreIPAddresses(),
        new ReverseInteger(),
        new ReverseLinkedListII(),
        new ReverseNodesinkGroup(),
        new RomantoInteger(),
        new RotateImage(),
        new SameTree(),
        new ScrambleString(),
        new Searcha2DMatrix(),
        new SearchforaRange(),
        new SearchinRotatedSortedArray(),
        new SearchinRotatedSortedArrayII(),
        new SearchInsertPosition(),
        new SetMatrixZeroes(),
        new SingleNumber(),
        new SortColors(),
        new SpiralMatrix(),
        new Sqrtx(),
        new StringtoIntegerAtoi(),
        new Subsets(),
        new SubsetsII(),
        new SubstringwithConcatenationofAllWords(),
        new SumRoottoLeafNumbers(),
        new SurroundedRegions(),
        new SwapNodesinPairs(),
        new SymmetricTree(),
        new ThreeSum(),
        new Triangle(),
        new TwoSum(),
        new UniqueBinarySearchTrees(),
        new ValidateBinarySearchTree(),
        new ValidPalindrome(),
        new ValidParentheses(),
        new WordBreak(),
        new WordBreakII(),
        new WordLadder(),
        new WordLadderII(),
        new WordSearch(),
        new ZigZagConversion(),
        new AddBinary_ex(),
        new AddTwoNumbers_ex(),
        new Anagrams_ex_star(),
        new BalancedBinaryTree_ex(),
        new BestTimetoBuyandSellStock_ex(),
        new BestTimetoBuyandSellStockII_ex(),
        new BestTimetoBuyandSellStockIII_ex(),
        new BinaryTreeInorderTraversal_ex(),
        new BinaryTreeLevelOrderTraversalII_ex(),
        new BinaryTreeMaximumPathSum_ex(),
        new Candy_ex(),
        new ClimbingStairs_ex(),
        new Combinations_ex(),
        new CombinationSum_ex(),
        new ConstructBinaryTreefromInorderandPostorderTraversal_ex(),
        new ContainerWithMostWater_ex(),
        new ConvertSortedArraytoBinarySearchTree_ex(),
        new ConvertSortedListtoBinarySearchTree_ex(),
        new CopyListwithRandomPointer_ex(),
        new CountandSay_ex(),
        new DecodeWays_ex(),
        new DistinctSubsequences_ex(),
        new DivideTwoIntegers_ex(),
        new EditDistance_ex(),
        new FirstMissingPositive_ex(),
        new FlattenBinaryTreetoLinkedList_ex(),
        new FourSum_ex(),
        new GenerateParentheses_ex(),
        new GrayCode_ex(),
        new ImplementStrStr_ex(),
        new IntegertoRoman_ex(),
        new InterleavingString_ex(),
        new MergeIntervals_xbian_sort_adding_toCurrex(),
        new JumpGame_ex(),
        new LargestRectangleinHistogram_ex(),
        new LengthofLastWord_ex(),
        new LetterCombinationsofaPhoneNumber_ex(),
        new LinkedListCycle_ex(),
        new LongestCommonPrefix_ex(),
        new LongestConsecutiveSequence_ex(),
        new LongestPalindromicSubstring_ex(),
        new LongestSubstringWithoutRepeatingCharacters_ex(),
        new LongestValidParentheses_ex(),
        new MaximalRectangle_ex(),
        new MergeIntervals_xbian_sort_adding_toCurrex(),
        new MergekSortedLists_ex(),
        new MergeSortedArray_ex(),
        new MergeTwoSortedLists_ex(),
        new MinimumDepthofBinaryTree_ex(),
        new MinimumPathSum_ex(),
        new MinimumWindowSubstring_ex(),
        new NextPermutation_ex(),
        new PalindromeNumber_ex(),
        new PalindromePartitioning_ex(),
        new PalindromePartitioningII_ex(),
        new PartitionList_ex(),
        new PascalTriangle_ex(),
        new PathSum_ex(),
        new PathSumII_ex(),
        new PermutationsII_ex(),
        new PlusOne_ex(),
        new PopulatingNextRightPointersinEachNode_ex(),
        new PopulatingNextRightPointersinEachNodeII_ex(),
        new PowXN_ex(),
        new RecoverBinarySearchTree_ex(),
        new RemoveDuplicatesfromSortedArray_ex(),
        new RemoveDuplicatesfromSortedList_ex(),
        new RemoveDuplicatesfromSortedListII_ex(),
        new RemoveElement_ex(),
        new RemoveNthNodeFromEndofList_ex(),
        new ReorderList_ex(),
        new RestoreIPAddresses_ex(),
        new ReverseInteger_ex(),
        new ReverseLinkedListII_ex(),
        new ReverseNodesinkGroup_ex(),
        new RomantoInteger_ex(),
        new RotateImage_ex(),
        new SameTree_ex(),
        new ScrambleString_ex(),
        new Searcha2DMatrix_ex(),
        new SearchforaRange_ex(),
        new SearchinRotatedSortedArray_ex(),
        new SearchinRotatedSortedArrayII_ex(),
        new SearchInsertPosition_ex(),
        new SetMatrixZeroes_ex(),
        new SingleNumber_ex(),
        new SortColors_ex(),
        new SpiralMatrix_ex(),
        new Sqrtx_ex(),
        new StringtoIntegerAtoi_ex(),
        new Subsets_ex(),
        new SubsetsII_ex(),
        new SubstringwithConcatenationofAllWords_ex(),
        new SumRoottoLeafNumbers_ex(),
        new SurroundedRegions_ex_xbian(),
        new SwapNodesinPairs_ex(),
        new SymmetricTree_ex(),
        new ThreeSum_ex(),
        new Triangle_ex(),
        new TwoSum_ex(),
        new UniqueBinarySearchTrees_ex(),
        new ValidateBinarySearchTree_ex(),
        new ValidPalindrome_ex(),
        new ValidParentheses_ex(),
        new WordBreak_ex(),
        new WordBreakII_ex(),
        new WordLadder_ex(),
        new WordLadderII_bian_backtrace_recursive(),
        new WordSearch_ex(),
        new RandomWord(),
        new ZigZagConversion_bian_ex(),
        new ReadWriteSample(),
        new PrintNumbers(),
        new JavaCollectionEx(),

        // Adding anything new here like
        new _NewClassTemplate(),
        new ContainsNearbyAlmostDuplicate(),
        new _NewClassTemplate3(),
        new _NewClassTemplate4(),
        new FBCoverStringMinSet(),
        new FindPairWithGivingDiff(),
        new CombinationOfCoins(),
        new FirstBadVersion(),
        new FB4(),
        new BSTIterator(),
        new FB6(),
        new FBCoveringSegment(),
        new GQuestion2(),
        new Combination(),
        new FBQuestions(),
        new PeekingIteratorModule(),
        new Solution(),
        new CQuestion1(),
        new RemoveWordFromTree(),


        new RemoveDuplicateLetters(),
        new FB8(),
        new FB9(),

        new _NewClassTemplate()
    );
  }


  static public void main(String[] args) {
    addingAllNewClasses();
    runTopPriority();
    // runCategory(InvokableBase.Category.Language);

  }

  static void runTopPriority() {

    // Stream<InvokableBase> stream = listPrograms.stream();

    Integer topPriority = listPrograms.stream().
        mapToInt(p -> p.getRunPriority().getDaySeq()).max().orElse(0);
    listPrograms.stream().filter(p -> p.getRunPriority().getDaySeq().equals(topPriority))
        .forEach(p -> callInvaokeableRunMethod(p));

  }

  static void runCategory(Category category) {
    listPrograms.stream().filter(p -> p.getRunPriority().Cat == category)
        .forEach(InvokableBase::run);
  }

  static void runCategoryTopPriority(Category category) {
    Integer topPriority =
        listPrograms.stream().filter(p -> p.getRunPriority().Cat == category)
            .mapToInt(p -> p.getRunPriority().getDaySeq()).max()
            .orElse(0);

    listPrograms.stream().filter(p -> p.getRunPriority().Cat == category)
        .filter(p -> (p.getRunPriority().getDaySeq().equals(topPriority)))
        .forEach((p) -> {
          callInvaokeableRunMethod(p);
          p.run();
        });
  }

  static void callInvaokeableRunMethod(InvokableBase b) {
    try {
      System.out.println("_____________________________________________________________");
      System.out.println(
          "Start running class:" + b.getClass().getName() + " priority:" + b.getRunPriority()
              .getDaySeq()
          + " Category:"
          + b.getRunPriority().Cat.toString());
      b.run();
      System.out.println("Done with: " + b.getClass().getName());
    } catch (Exception e) {

         e.printStackTrace();


    } finally {
      System.out.println("_____________________________________________________________");
    }
  }
}
