import java.util.Comparator;

public class VertexSPComparator implements Comparator<Vertex>
{
    @Override
    public int compare(Vertex x, Vertex y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        return x.spWeight - y.spWeight;
    }
}