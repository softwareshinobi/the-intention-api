package digital.dwityuniverse.intention;

import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("intention")
public class IntentionAPIController {

    private final String INTENTION_DEFAULT = "the five b's forever and forever.";

    private String intention = INTENTION_DEFAULT;

    public static final String KEY_JSON_INTENTION = "intention";

    public IntentionAPIController() {

        System.out.println("## in2it / IntentionAPIController");

    }

    @GetMapping("")
    public String landing() {

        return "The Intention API";

    }

    @GetMapping("/health")
    public String getHealth() {

        return "GREEN";

    }

    @GetMapping("/")
    public String getIntentionash() {

        return intention;

    }

    @PostMapping("/set-intention")
    public String setIntention(@RequestBody Map requestPayLoad) {

        System.out.println("enter > setIntention");

        System.out.println("requestPayLoad / " + requestPayLoad);

        String intentionFromPayload = requestPayLoad.get(KEY_JSON_INTENTION).toString().trim();

        System.out.println("intention / payload / " + intentionFromPayload);

        System.out.println("intention / before / " + this.intention);

        this.intention = intentionFromPayload;

        System.out.println("intention /  after / " + this.intention);

        String confirmationString = "intention updated /".concat(intention).concat("/");

        System.out.println("return / " + confirmationString);

        System.out.println("exit < setIntention()");

        return confirmationString;

    }

}
