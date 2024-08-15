
package com.rebuild;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * @see com.rebuild.web.RebuildWebConfigurer
 */
@Slf4j
@Component("thymeleafViewResolver")
public class MockThymeleafViewResolver extends ThymeleafViewResolver {

    public MockThymeleafViewResolver() {
        super();
        log.warn("Mock `thymeleafViewResolver` has been enabled");
    }
}
