class PseudoRandomGenerator {

    int INIT_SEED = 123456789;
    long COEF = 22696477;
    long OFFSET = 1;
    long MODULO = (long) (Math.pow(2, 61))-1;
    long MASK = 0x7FFFFFFF;
    int internalValue;

    public PseudoRandomGenerator() {
        this.internalValue = INIT_SEED;
    }

    int getNextValue() {
        // On initialise une variable locale 64 bits courantes avec la valeur courante
        long value = (long)this.internalValue;
        // On multiplie par un coefficiant
        value *= COEF;
        // On ajoute un offset
        value += OFFSET;
        // On applique un modulo
        value %= MODULO;
        // On garde les 31 bits du milieu de notre variable locale 64 bits
        // 31 bits pour avoir une valeur strictement positive
        this.internalValue = (int) ((int) ((value>>16)) & MASK);
        // On retourne la nouvelle valeur
        return this.internalValue;
    }

    public double random() {
        // On récupère la prochaine valeur pseudo-aléatoire
        long value = this.getNextValue();
        // On la converti en valeur décimale normalisée entre 0.0 et 1.0
        // Et on retourne ce résultat
        return ((double)value) / MASK;
    }
}