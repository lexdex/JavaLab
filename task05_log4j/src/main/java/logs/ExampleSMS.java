package logs;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class ExampleSMS {

    public static final String ACCOUNT_SID = "AC42e309f43d810ed03979387cf8ba2717";
    public static final String AUTH_TOKEN = "c92f200cea3c4fc029b750f4fb3fb751";

    public static void send(String str) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new PhoneNumber("+380677208000"), /*my phone number*/
                        new PhoneNumber("+19282275000"), str) .create(); /*attached to me number*/
    }
}
