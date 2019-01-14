package lienming;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lienming on 2019/1/9.
 */
@RestController
public class HelloController {
        @RequestMapping("/")
        public String home(){
            return "hello spring server ";
        }
}
