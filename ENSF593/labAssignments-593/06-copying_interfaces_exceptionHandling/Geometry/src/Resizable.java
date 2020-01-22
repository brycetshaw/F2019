public interface Resizable{

    void shrink(double factor) throws SizeFactorException;
    void enlarge(double factor) throws SizeFactorException;
    double LIMIT = 1.0;
}
