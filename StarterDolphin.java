   import javax.swing.JFrame;

public class StarterDolphin extends JFrame 
{

    public StarterDolphin()
    {
        add(new DolphinDrawing());
        setTitle("Dolphin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new StarterDolphin();
    }
}
