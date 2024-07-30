// ImageViewerApp.java
public class ImageViewerApp {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("http://example.com/image1.jpg");
        Image image2 = new ProxyImage("http://example.com/image2.jpg");

        // The first time display is called, the image will be loaded from the remote server
        image1.display();
        System.out.println("");

        // The second time display is called, the cached image will be displayed
        image1.display();
        System.out.println("");

        // The first time display is called, the image will be loaded from the remote server
        image2.display();
        System.out.println("");

        // The second time display is called, the cached image will be displayed
        image2.display();
    }
}

// Image.java
interface Image {
    void display();
}

// RealImage.java
class RealImage implements Image {
    private String url;

    public RealImage(String url) {
        this.url = url;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from " + url);
    }

    @Override
    public void display() {
        System.out.println("Displaying image from " + url);
    }
}

// ProxyImage.java
class ProxyImage implements Image {
    private RealImage realImage;
    private String url;

    public ProxyImage(String url) {
        this.url = url;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(url);
        }
        realImage.display();
    }
}
