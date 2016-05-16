package gert.drools;

import gert.drools.dto.Transaction;
import gert.drools.dto.UnallocatedTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gert van Emmenes on 2016/05/13.
 */
public class Test {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<Transaction>();

        transactions.add(new UnallocatedTransaction("2016-01-01", "12345678 vending", "successfull", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "1234567 vending", "fail", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "121 vending", "fail", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "12345678", "maybe", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "12345678", "successfull", "400"));

        try {
            new RuleRunner().runRules(new String[] {"studentNumberRule.drl"}, transactions.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
