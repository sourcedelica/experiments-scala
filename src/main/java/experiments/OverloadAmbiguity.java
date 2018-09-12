package experiments;

import java.io.Serializable;
import java.util.List;

public class OverloadAmbiguity {
    public OverloadAmbiguity(int i, Serializable s, String ss) {}

    public OverloadAmbiguity(int i, List<Serializable> s, String ss) {}
}
