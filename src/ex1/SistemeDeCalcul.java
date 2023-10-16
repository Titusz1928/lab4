package ex1;

public class SistemeDeCalcul extends Echipament{
    String TipMon;
    int VitPro;
    int CapHDD;

    SistemOp sistemOp;

    public SistemeDeCalcul(String denumire, int nrInv, float pret, String zonaMag, Status statusEch,Tip tip,String tipMon,int vitPro,int capHDD,SistemOp sistemOp) {
        super(denumire, nrInv, pret, zonaMag, statusEch,tip);
        this.TipMon=tipMon;
        this.VitPro=vitPro;
        this.CapHDD=capHDD;
        this.sistemOp=sistemOp;
    }

    @Override
    public String toString() {
        return super.toString() +
                "TipMon='" + TipMon + '\'' +
                ", VitPro=" + VitPro +
                ", CapHDD=" + CapHDD +
                ", sistemOp=" + sistemOp;
    }

    public String getTipMon() {
        return TipMon;
    }

    public void setTipMon(String tipMon) {
        TipMon = tipMon;
    }

    public int getVitPro() {
        return VitPro;
    }

    public void setVitPro(int vitPro) {
        VitPro = vitPro;
    }

    public int getCapHDD() {
        return CapHDD;
    }

    public void setCapHDD(int capHDD) {
        CapHDD = capHDD;
    }

    public SistemOp getSistemOp() {
        return sistemOp;
    }

    public void setSistemOp(SistemOp sistemOp) {
        this.sistemOp = sistemOp;
    }
}

enum SistemOp{
    Windows,
    Linux
}
