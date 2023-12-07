import java.io.*;

public class App {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Get source file path from user input
            System.out.print("Enter the source file path: ");
            String sourcePath = reader.readLine();

            // Get destination file path from user input
            System.out.print("Enter the destination file path: ");
            String destinationPath = reader.readLine();

            // Create input stream for the source file
            try (InputStream inputStream = new FileInputStream(sourcePath)) {
                // Create output stream for the destination file
                try (OutputStream outputStream = new FileOutputStream(destinationPath)) {
                    // Copy the contents of the file
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }

            System.out.println("File copy successful!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("File copy failed: " + e.getMessage());
        } finally {
            try {
                // Close the BufferedReader
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
