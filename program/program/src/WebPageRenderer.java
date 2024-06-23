import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WebPageRenderer extends JFrame {

    private JEditorPane editorPane;

    public WebPageRenderer(String htmlFilePath) {
        super("Jetson Wizard");

        editorPane = new JEditorPane();
        editorPane.setEditable(false);

        // Handle hyperlinks
        editorPane.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    editorPane.setPage(e.getURL());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        try {
            // Load the HTML file from local file system
            File htmlFile = new File(htmlFilePath);
            URL fileUrl = htmlFile.toURI().toURL();
            editorPane.setPage(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            editorPane.setText("Error loading page: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(editorPane);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

    }
}