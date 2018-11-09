package pipes;

public class PipeLetrasMinusculas implements Pipe {
   
    private final String SIGLA = "LMI";
    
    @Override
    public String filtrar(String entrada) {
        return entrada.toLowerCase();
    }
      
    @Override
    public String getSigla() {
        return this.SIGLA;
    }  
}
