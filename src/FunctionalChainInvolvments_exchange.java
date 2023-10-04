public class FunctionalChainInvolvments_exchange extends FunctionalChainInvolvment {
    // Attributes
    // All attributes are inherited from FunctionalChainInvolvment class
    private FunctionalExchange functionalExchange;

    //Constructor
    /**
     * @param id      the id to set
     * @param name    the name to set
     * @param summary the summary to set
     */
    public FunctionalChainInvolvments_exchange(String id, String name, String summary, FunctionalExchange functionalExchange) {
        super(id, name, summary);
        this.functionalExchange = functionalExchange;
    }

    public FunctionalExchange getFunctionalExchange() {
        return functionalExchange;
    }

    @Override
    public String toString() {
        return this.functionalExchange.toString();
    }

    public void setFunctionalExchange(FunctionalExchange functionalExchange) {
        this.functionalExchange = functionalExchange;
    }
}
