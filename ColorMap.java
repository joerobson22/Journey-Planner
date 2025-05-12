import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

public class ColorMap 
{
    private static final Map<String, Color> COLORMAP = new HashMap<>();

    static 
    {
        COLORMAP.put("pink", Color.PINK);
        COLORMAP.put("blue", Color.BLUE);
        COLORMAP.put("red", Color.RED);
        COLORMAP.put("green", Color.GREEN);
        COLORMAP.put("yellow", Color.YELLOW);
        COLORMAP.put("purple", new Color(152, 3, 252));
        COLORMAP.put("darkblue", new Color(0, 0, 139));
        COLORMAP.put("lightblue", new Color(173, 216, 230));
    }

    public static Color getColor(String color)
    {
        return COLORMAP.getOrDefault(color, Color.WHITE);
    }
}
