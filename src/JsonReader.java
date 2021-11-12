import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class JsonReader {
    private static Gson g = new Gson();

    public static Input inlezen() throws IOException {
        String map = "toy sets";
        String file = "toy_10_7";
        Path path = Path.of(map + "/" + file + ".json");

        String json = Files.readString(path);
        return g.fromJson(json, Input.class);
    }

//    public static void uitlezen(Object o, String name) throws IOException {
//        String json = g.toJson(o);
//        Path pad = Path.of("out/output/" + name + ".json");
//        Files.createFile(pad);
//        Files.write(pad, Collections.singleton(json));
//    }
}
