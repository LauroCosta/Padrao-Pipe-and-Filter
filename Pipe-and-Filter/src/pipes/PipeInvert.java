package pipes;

public class PipeInvert implements Pipe {

    private final String NOME = "INV";
    
    @Override
    public String filtrar(String entrada) {

        String saida = null;

        int tam = entrada.length();
        char[] aux = new char[tam];
        char[] auxInvertido = new char[tam];

        for (int i = 0; i < tam; i++) {
            aux[i] = entrada.charAt(i);
        }

        for (int j = 0; j < tam; j++) {
            auxInvertido[j] = aux[tam - 1 - j];
        }
        saida = new String(auxInvertido);

        return saida;
    }
    
    @Override
    public String getSigla() {
        return this.NOME;
    }    
}
