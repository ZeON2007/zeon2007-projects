package by.herzhot;

        import javafx.application.Application;
        import static javafx.application.Application.launch;
        import javafx.scene.Scene;
        import javafx.scene.layout.StackPane;
        import javafx.scene.web.WebEngine;
        import javafx.scene.web.WebView;
        import javafx.stage.Stage;

/**
 * @web http://java-buddy.blogspot.com/
 */
public class Test extends Application {

    String content_Url = "<iframe width=\"560\" height=\"315\" src=\"http://player.twitch.tv/?channel=dota2ti_ru\" frameborder=\"0\" allowfullscreen></iframe>";


    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(content_Url);

        StackPane root = new StackPane();
        root.getChildren().add(webView);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println(Test.getScreenWidth());
    }

    public static void main(String[] args) {
        launch(args);
    }

    protected static native int getScreenWidth();
}