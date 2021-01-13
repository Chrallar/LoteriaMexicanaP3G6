module leab.loteriamexicana {
    requires javafx.controls;
    requires javafx.fxml;

    opens leab.loteriamexicana to javafx.fxml;
    exports leab.loteriamexicana;
}