import javax.swing.*;
import java.io.*;

public class WebPageRenderer extends JFrame {
    public WebPageRenderer(String htmlFilePath) {
        setTitle("Web Page Renderer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // Load the HTML file
            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setEditable(false);
            editorPane.setPage(new File(htmlFilePath).toURI().toURL());

            // Add the editor pane to a scroll pane
            JScrollPane scrollPane = new JScrollPane(editorPane);
            add(scrollPane);

        } catch (IOException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

}