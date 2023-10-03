import java.util.ArrayList;
import java.util.List;

public class FunctionalChain extends ChainElt {
    // Attributes //////////////////////////////////////////////////////////////////////////////////////////////////////
    // id, name and summary are inherited from ChainElt class
    private List<FunctionalChainInvolvment> involvments;

    // Constructor /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @param id          the id to set
     * @param name        the name to set
     * @param summary     the summary to set
     * @param involvments the list of involvments to set
     */
    public FunctionalChain(String id, String name, String summary, List<FunctionalChainInvolvment> involvments) {
        super(id, name, summary);
        this.involvments = involvments;
    }

    // Getters /////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @return the involvments
     */
    public List<FunctionalChainInvolvment> getInvolvments() {
        return involvments;
    }

    public void setInvolvments(List<FunctionalChainInvolvment> involvments) {
        this.involvments = involvments;
    }

    @Override
    public String toString() {
        // Get strings from all involvments
        List<String> involvmentStrings = new ArrayList<>();
        for (FunctionalChainInvolvment involvment : involvments) {
            involvmentStrings.add(involvment.toString());
        }

        return String.format("%s\n%s", "----- " + this.name + " -----", String.join("\n", involvmentStrings));
    }

    // Fonction de comparaison
    public List<FunctionalChainInvolvments_function> getCommunFonction(FunctionalChain otherChain) {

        List<FunctionalChainInvolvments_function> communFonction = new ArrayList<>();

        for (FunctionalChainInvolvment involvment : this.involvments) {
            if (involvment instanceof FunctionalChainInvolvments_function) {
                for (FunctionalChainInvolvment otherInvolvment : otherChain.involvments) {
                    if (otherInvolvment instanceof FunctionalChainInvolvments_function) {
                        if (involvment.equals(otherInvolvment)) {
                            communFonction.add((FunctionalChainInvolvments_function) involvment);
                        }
                    }
                }
            }
        }
        return communFonction;
    }


}
