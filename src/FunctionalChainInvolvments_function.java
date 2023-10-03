public class FunctionalChainInvolvments_function extends FunctionalChainInvolvment {
    // Attributes
    // All attributes are inherited from FunctionalChainInvolvment class
    private Function function;

    // Constructor

    /**
     * @param id       the id to set
     * @param name     the name to set
     * @param summary  the summary to set
     * @param function the function to set
     */
    public FunctionalChainInvolvments_function(String id, String name, String summary, Function function) {
        super(id, name, summary);
        this.function = function;
    }

    // Getters

    /**
     * @return the function
     */
    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return this.function.toString();
    }
}
