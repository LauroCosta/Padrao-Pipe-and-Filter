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
   
    public PipeController(PipeView view, PipeModel model) {
        this.setModel(model);
        this.setView(view);
        this.model.addObserver(this);
    }

    public PipeModel getModel() {
        return model;
    }

    private void setModel(PipeModel model) {
        if (model != null) 
            this.model = model;
    }

    public PipeView getView() {
        return view;
    }

    private void setView(PipeView view) {
        if (view != null) 
            this.view = view;
    }

    private String filtrarString(String entrada) {   
        return this.getModel().run(entrada);
    }
    
    public void eventoTeclado(KeyEvent evt) {
        this.getModel().notifyALL();
    }

    public void eventoClick(ActionEvent evt){
    
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
        try {
            this.getView().getListaPipes().setText(this.getModel().listaPipes());
            String teste = this.filtrarString(this.getView().getCampoEntrada().getText());
            new Robot().keyPress(10);       
            this.getView().getTxSaida().setText(teste);
   
        } catch (AWTException ex) {
            this.getView().getTxSaida().setText("erro na simulação do enter");
            System.exit(0);
        }
    }
}
