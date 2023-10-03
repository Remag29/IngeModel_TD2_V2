public class FunctionalExchange extends ChainElt {
    // Attributes
    // id, name and summary are inherited from ChainElt class
    private FunctionalChainInvolvment source;
    private FunctionalChainInvolvment target;
    private Input input;
    private Output output;

    // Constructor

    /**
     * @param id      the id to set
     * @param name    the name to set
     * @param summary the summary to set
     * @param source  the previous FunctionalChainInvolvment (function/exchange)
     * @param target  the next FunctionalChainInvolvment (function/exchange
     * @param input   the input
     * @param output  the output
     */
    public FunctionalExchange(String id, String name, String summary, FunctionalChainInvolvment source, FunctionalChainInvolvment target, Input input, Output output) {
        super(id, name, summary);
        this.source = source;
        this.target = target;
        this.input = input;
        this.output = output;
    }

    // Getters

    /**
     * @return the source
     */
    public FunctionalChainInvolvment getSource() {
        return source;
    }

    /**
     * @return the target
     */
    public FunctionalChainInvolvment getTarget() {
        return target;
    }

    /**
     * @return the input
     */
    public Input getInput() {
        return input;
    }

    /**
     * @return the output
     */
    public Output getOutput() {
        return output;
    }

    public void setSource(FunctionalChainInvolvment source) {
        this.source = source;
    }

    public void setTarget(FunctionalChainInvolvment target) {
        this.target = target;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return this.input.toString() + " -> " + this.output.toString();
    }
}
