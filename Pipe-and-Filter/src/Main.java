import model.PipeModel;
import view.PipeView;

public class Main {

    public static void iniciarView(PipeView view) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }

    public static void main(String args[]) {

        PipeView view = new PipeView(new PipeModel());
        iniciarView(view);

    }

}
