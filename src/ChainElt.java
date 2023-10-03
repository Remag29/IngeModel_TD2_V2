public class ChainElt {
    // Attributes //////////////////////////////////////////////////////////////////////////////////////////////////////
    protected final String id;
    protected final String name;
    protected String summary;
    protected Boolean contamined = false;

    //Constructor //////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @param id      the id to set
     * @param name    the name to set
     * @param summary the summary to set
     */
    public ChainElt(String id, String name, String summary) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        if (this.summary.equals("THREAT")) {
            this.contamined = true;
        }
    }

    // Getters /////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    public Boolean getContamined() {
        return contamined;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContamined() {
        this.contamined = true;
    }

    public String toString() {
        return "[id=" + id + ", name=" + name + ", summary=" + summary + "]";
    }
}
