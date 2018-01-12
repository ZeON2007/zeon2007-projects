package by.herzhot;

import javafx.animation.AnimationTimer;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Animation extends AnimationTimer {

    private DecimalFormat df = new DecimalFormat("#.##");
    private Main main;

    public Animation(Main main) {
        this.main = main;
        df.setRoundingMode(RoundingMode.CEILING);
    }

    @Override
    public void handle(long now) {

        if (main.getPayments() != null) {
            for (int i = 0; i < main.getPayments().length; i++) {
                main.getText()[i].setText((i + 1) + " | " + df.format(main.getPayments()[i]));
            }
        }
    }
}
