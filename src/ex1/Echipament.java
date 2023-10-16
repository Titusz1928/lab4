package ex1;

public class Echipament {
    String Denumire;
    int NrInv;
    float Pret;
    String ZonaMag;
    Status StatusEch;

    Tip Tip;

    public Echipament(String denumire, int nrInv, float pret, String zonaMag, Status statusEch, Tip tip) {
        Denumire = denumire;
        NrInv = nrInv;
        Pret = pret;
        ZonaMag = zonaMag;
        StatusEch = statusEch;
        Tip=tip;
    }

    @Override
    public String toString() {
        return "Denumire='" + Denumire + '\'' +
                ", NrInv=" + NrInv +
                ", Pret=" + Pret +
                ", ZonaMag='" + ZonaMag + '\'' +
                ", StatusEch=" + StatusEch +
                ", Tip=" + Tip;
    }

    public String getDenumire() {
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public int getNrInv() {
        return NrInv;
    }

    public void setNrInv(int nrInv) {
        NrInv = nrInv;
    }

    public float getPret() {
        return Pret;
    }

    public void setPret(float pret) {
        Pret = pret;
    }

    public String getZonaMag() {
        return ZonaMag;
    }

    public void setZonaMag(String zonaMag) {
        ZonaMag = zonaMag;
    }

    public Status getStatusEch() {
        return StatusEch;
    }

    public void setStatusEch(Status statusEch) {
        StatusEch = statusEch;
    }

    public ex1.Tip getTip() {
        return Tip;
    }

    public void setTip(ex1.Tip tip) {
        Tip = tip;
    }
}

enum Status {
    achizitionat,
    expus,
    vandut
}

enum Tip{
    Imprimant,
    Copiator,
    SistemDeCalcul
}
