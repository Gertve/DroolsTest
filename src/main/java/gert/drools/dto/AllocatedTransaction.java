package gert.drools.dto;

/**
 * Created by Gert van Emmenes on 2016/05/13.
 */
public class AllocatedTransaction extends Transaction{

    public AllocatedTransaction() {
    }

    public AllocatedTransaction(Transaction transaction){
        super(transaction.getTransDate(), transaction.getReference(), transaction.getDescription(), transaction.getAmount());
    }

    public AllocatedTransaction(String transDate, String reference, String description, String amount) {
        super(transDate, reference, description, amount);
    }

    @Override
    public void print(){
        System.out.println("this is allocated: " + this.getReference() + " " + this.getDescription());
    }
}
