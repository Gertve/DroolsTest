package gert.drools.dto;
/**
 * Created by Gert van Emmenes on 2016/05/13.
 */
public abstract class Transaction {
    private String transDate;

    private String reference;

    private String description;

    private String amount;

    public Transaction() {
    }

    public Transaction(String transDate, String reference, String description, String amount) {
        this.transDate = transDate;
        this.reference = reference;
        this.description = description;
        this.amount = amount;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    abstract void print();
}
