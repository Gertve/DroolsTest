package gert.drools.dto;

/**
 * Created by Gert van Emmenes on 2016/05/13.
 */
public class UnallocatedTransaction extends Transaction{

    public UnallocatedTransaction() {
    }

    public UnallocatedTransaction(Transaction transaction){
    }

    public UnallocatedTransaction(String transDate, String reference, String description, String amount) {
        super(transDate, reference, description, amount);
    }

    @Override
    public void print(){
        System.out.println("this is unallocated: " + this.getReference() + " " + this.getDescription());
    }
}
