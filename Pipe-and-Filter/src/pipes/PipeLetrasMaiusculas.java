package pipes;

public class PipeLetrasMaiusculas implements Pipe {

    private String nome = "LMA";
    
    @Override
    public String filtrar(String entrada) {
        return entrada.toUpperCase();
    }
      
    @Override
    public String getNome() {
        return this.nome;
    }   
}
