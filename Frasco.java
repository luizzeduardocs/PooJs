package br.edu.unifsa.perfumaria.producao;

public final class Frasco {
    private final int volumeMl;
    public Frasco(int volumeMl) {
        if (volumeMl != 30 && volumeMl != 50 && volumeMl != 100)
            throw new IllegalArgumentException("RN03: frasco deve ter 30, 50 ou 100 ml.");
        this.volumeMl = volumeMl;
    }
    public int getVolumeMl() { return volumeMl; }
    @Override public String toString() { return volumeMl + " ml"; }
}
