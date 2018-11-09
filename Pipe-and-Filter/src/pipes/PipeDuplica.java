package pipes;


public class PipeDuplica implements Pipe {
  
    private final String SIGLA = "DPL";

    @Override
    public String filtrar(String entrada) {
        return entrada + entrada;
    }

    @Override
    public String getSigla() {
        return this.SIGLA;
    }   
}
