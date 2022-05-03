package com.github.miyohide.appconfigsample;

import com.azure.spring.cloud.feature.manager.FeatureManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ConfigurationProperties("controller")
public class HelloController {
    private final MessageProperties properties;
    private FeatureManager featureManager;

    public HelloController(MessageProperties properties, FeatureManager featureManager) {
        this.properties = properties;
        this.featureManager = featureManager;
    }

    @GetMapping
    public String getMessage(Model model) {
        model.addAttribute("Message", "Message:" + properties.getMessage());
        return "index";
    }

    @GetMapping("/welcome")
    public String mainWithParam(Model model) {
        model.addAttribute("Beta", featureManager.isEnabledAsync("Beta").block());
        return "welcome";
    }
}
