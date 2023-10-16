package ex1;

public class Imprimante extends Echipament {
    int ppm;
    int dpi;
    int p_car;
    ModTip modTip;

    public Imprimante(String denumire,int nrInv,float pret,String zonaMag,Status statusEch,Tip tip,int ppm,int dpi,int p_car,ModTip modTip) {
        super(denumire, nrInv, pret, zonaMag, statusEch,tip);
        this.ppm=ppm;
        this.dpi=dpi;
        this.p_car=p_car;
        this.modTip=modTip;

    }

    @Override
    public String toString() {
        return super.toString() +
                "ppm=" + ppm +
                ", dpi=" + dpi +
                ", p_car=" + p_car +
                ", modTip=" + modTip;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public ModTip getModTip() {
        return modTip;
    }

    public void setModTip(ModTip modTip) {
        this.modTip = modTip;
    }
}

enum ModTip{
    color,
    negru
}
