package digital.softwareshinobi.intention.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("")
public class IntentionController {

    private final String INTENTION_DEFAULT = "the five b's forever";

    private String intention = INTENTION_DEFAULT;

    public static final String KEY_JSON_INTENTION = "intention";

    public IntentionController() {

        System.out.println("init > Intention Controller");

    }

    @GetMapping("health")
    public String getHealth() {

        return "OK";

    }

    @GetMapping("")
    public String getIntention() {

        return this.intention;

    }

    @PostMapping("")
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
