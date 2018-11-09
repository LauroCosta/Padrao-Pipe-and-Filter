package controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import model.Observer;
import model.PipeModel;
import pipes.PipeDuplica;
import pipes.PipeInvert;
import pipes.PipeLetrasMaiusculas;
import pipes.PipeLetrasMinusculas;
import pipes.PipeSemConsoante;
import pipes.PipeSemVogal;
import view.PipeView;

public class PipeController implements Observer {

    private PipeModel model;
    private PipeView view;
    private String saida;

    public PipeController(PipeView view, PipeModel model) {
        this.setModel(model);
        this.setView(view);
        this.model.addObserver(this);
    }

    public PipeModel getModel() {
        return model;
    }

    public void setModel(PipeModel model) {
        if (model != null) 
            this.model = model;
    }

    public PipeView getView() {
        return view;
    }

    public void setView(PipeView view) {
        if (view != null) 
            this.view = view;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        if (saida != null) 
            this.saida = saida;
    }

    private void filtrarString() {   
        try {
            String entrada = this.getView().getCampoEntrada().getText();
            this.setSaida(this.getModel().run(entrada));
            new Robot().keyPress(10);
        } catch (AWTException ex) {}
    }
    
    public void eventoTeclado(KeyEvent evt) {
        this.filtrarString();
    }

    public void eventoClick(ActionEvent evt){

        this.filtrarString();
        
        switch (evt.getActionCommand()) {

            case "duplica":
                this.getModel().addPipe(new PipeDuplica());
                break;
            case "inverte":
                this.getModel().addPipe(new PipeInvert());
                break;
            case "maiusculo":
                this.getModel().addPipe(new PipeLetrasMaiusculas());
                break;
            case "minusculo":
                this.getModel().addPipe(new PipeLetrasMinusculas());
                break;
            case "semvogal":
                this.getModel().addPipe(new PipeSemVogal());
                break;
            case "semconsoante":
                this.getModel().addPipe(new PipeSemConsoante());
                break;
            case "limpar":
                this.getModel().removeTodosPipes();
                break;
        } 
    }
    
    @Override
    public void update() {
        this.getView().getListaPipes().setText(this.getModel().listaPipes());
        this.getView().getTxSaida().setText(this.getSaida());       
    }
}
