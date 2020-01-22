
class Text implements Cloneable, Resizable {

    private final Double DEFAULT_SIZE = 10.0;

    private Colour colour;
    private Double fontSize;

    private String text;

    public Text() {
        colour = new Colour();
        // fontSize = DEFAULT_SIZE;
    }

    public Text(String text) {
        this.text = text;
        fontSize = DEFAULT_SIZE;
    }

    public Double getFontSize() {
        return fontSize;
    }

    public void setColour(String s) {
        colour = new Colour(s);
    }

    public void setText(String newText) {
        text = newText;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return (text);
    }

    @Override
    public Text clone() throws CloneNotSupportedException {
        Text temp = (Text) super.clone();
        if (colour != null) {
            temp.colour = (Colour) this.colour.clone();
        }
        return temp;
    }

    @Override
    public void shrink(double factor) throws SizeFactorException {
        if (factor < LIMIT) {
            throw new SizeFactorException();
        }
        fontSize /= factor;
    }

    @Override
    public void enlarge(double factor) throws SizeFactorException {
        if (factor < LIMIT) {
            throw new SizeFactorException();
        }
        fontSize *= factor;
    }


}