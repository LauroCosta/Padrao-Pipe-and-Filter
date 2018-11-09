package model;

import java.util.ArrayList;
import pipes.Pipe;

public class PipeModel {

    private ArrayList<Observer> observers;
    private ArrayList<Pipe> pipes;

    public PipeModel() {
        this.setPipes(new ArrayList<>());
        this.setObservers(new ArrayList<>());
    }

    public String run(String entrada) {

        String saida = null;

        if (this.getPipes().size() == 0) {
            saida = entrada;
        } else {
            for (Pipe pipe : pipes) {
                saida = pipe.filtrar(entrada);
                entrada = saida;
            }
        }
        this.notifyALL();
        return entrada;
    }

    public void addPipe(Pipe pipe) {

        if (this.getPipes() != null && pipe != null) {
            this.getPipes().add(pipe);
            this.notifyALL();
        }
    }

    public void removePipe(Pipe pipe) {
        if (this.getPipes() != null && pipe != null) {
            this.getPipes().remove(pipe);
            this.notifyALL();
        }
    }

    public void addObserver(Observer obs) {
        if (this.getObservers() != null && obs != null) {
            this.getObservers().add(obs);
        }
    }

    public String listaPipes() {

        String saida = "";

        for (Pipe pipe : pipes) {
            saida += "[" + pipe.getNome() + "]";
        }

        return saida;
    }

    public void removeTodosPipes() {
        this.getPipes().clear();
        this.notifyALL();
    }

    private ArrayList<Observer> getObservers() {
        return observers;
    }

    private ArrayList<Pipe> getPipes() {
        return pipes;
    }

    private void setObservers(ArrayList<Observer> observers) {
        if (observers != null) {
            this.observers = observers;
        }
    }

    private void setPipes(ArrayList<Pipe> pipes) {
        if (pipes != null) {
            this.pipes = pipes;
        }
    }

    private void notifyALL() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
