package ex1;

public class Copiatoare extends Echipament{

    int p_ton;

    Format format;
    public Copiatoare(String denumire, int nrInv, float pret, String zonaMag, Status statusEch,Tip tip, int p_ton,Format format) {
        super(denumire, nrInv, pret, zonaMag, statusEch,tip);
        this.p_ton=p_ton;
        this.format=format;
    }

    @Override
    public String toString() {
        return super.toString() +
                "p_ton=" + p_ton +
                ", format=" + format;
    }

    public int getP_ton() {
        return p_ton;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}

enum Format{
    A3,
    A4
}
