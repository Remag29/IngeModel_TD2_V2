import java.util.ArrayList;

public class OwnedFunction extends StorageMibField {
    String ownedFunctionsid;
    String ownedFunctionsName = "";
    ArrayList<Output> outputs;
    ArrayList<Input> inputs;

    OwnedFunction(String p_Functionsid, String p_FunctionsName) {
        ownedFunctionsid = p_Functionsid;
        ownedFunctionsName = p_FunctionsName;

        outputs = new ArrayList<Output>();
        inputs = new ArrayList<Input>();
    }

    public void AddOutputs(Output e) {
        outputs.add(e);
    }

    public void Addinputs(Input e) {
        inputs.add(e);
    }


    public String GetId() {
        return ownedFunctionsid;
    }
}