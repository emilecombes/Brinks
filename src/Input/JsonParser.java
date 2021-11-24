package Input;

import Input.Input;
import Output.Output;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class JsonParser {
    private static Gson g = new Gson();

    public static Input read() throws IOException {
        String map = "data/real_instances";
        String file = "B_f_500_56";
        Path path = Path.of(map + "/" + file + ".json");

        String json = Files.readString(path);
        return g.fromJson(json, Input.class);
    }

    public static void write(Output o) throws IOException {
        String json = g.toJson(o);
        Path pad = Path.of("out/" + o.getInstance_name() + ".json");
        if(!Files.exists(pad)) {
            Files.createFile(pad);
        }
        Files.write(pad, Collections.singleton(json));
   }
}
