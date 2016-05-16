package gert.drools;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gert van Emmenes on 2016/05/13.
 */
public class TransactionTest {

    private List<Transaction> transactions;

    @Before
    public void setUp() throws Exception {
        transactions = new ArrayList<Transaction>();

        transactions.add(new UnallocatedTransaction("2016-01-01", "12345678 vending", "successfull", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "1234567 vending", "fail", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "121 vending", "fail", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "12345678", "maybe", "400"));
        transactions.add( new UnallocatedTransaction("2016-01-01", "12345678", "successfull", "400"));
    }

    @Test
    public void testTransactions() throws Exception {
       new RuleRunner().runRules(new String[] {"studentNumberRule.drl"}, transactions.toArray());
    }

}