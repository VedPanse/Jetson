import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String htmlFilePath = "index.html";
            new WebPageRenderer(htmlFilePath);
        });
    }
}