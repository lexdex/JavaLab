package push_stream_task;

import java.io.InputStream;
import java.io.PushbackInputStream;

public class OwnPushbackStream extends PushbackInputStream {

    public OwnPushbackStream(InputStream in, int size) {
        super(in, size);
    }

    public OwnPushbackStream(InputStream in) {
        super(in);
    }
}
