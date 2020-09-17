package Unsorted;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;
//import org.apache.spark.sql.DataFrame;
import scala.collection.immutable.Seq;
import java.util.Date;

import static java.lang.System.*;

/**
 * @author
 * @since 10/28/15
 * This is the template for adding any new class
 */

public class SparkIceberg extends InvokableBase {
  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(200510, 1, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java
    run_datetime();
  }

  void run_datetime() {
//    //org.apache.spark.sql.DataFrame
//    DataFrame logsDF = Seq(("levela","messagea"));
//    SparkSession sparkSession = SparkSession.builder().master("SparkMasterURL")
//            .appName("DatasetCreation")
//            .config("spark.local.dir","/tmp")
//            .getOrCreate();

    out.println("Programmer Interview!");
  }
}
