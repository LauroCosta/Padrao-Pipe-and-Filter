package pipes;

public class PipeLetrasMaiusculas implements Pipe {

    private final String SIGLA = "LMA";
    
    @Override
    public String filtrar(String entrada) {
        return entrada.toUpperCase();
    }
      
    @Override
    public String getSigla() {
        return this.SIGLA;
    }   
}
